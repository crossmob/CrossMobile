/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class TemplateUtils {

    public static void copyTemplateIfMissing(String source, File dest, String logInfo, ParamList params) throws ProjectException {
        if (!dest.isFile()) {
            dest.getParentFile().mkdirs();
            Log.info(logInfo);
            copyTemplate(source, dest, params);
        }
    }

    public static void copyTemplate(String source, File dest, ParamList list) throws ProjectException {
        copyTemplate(source, dest, list, null);
    }

    public static void copyTemplate(String source, File dest, ParamList list, File backupDir) throws ProjectException {
        source = "templates/" + source;

        FileUtils.backup(dest, backupDir, false);
        if (source.toLowerCase().endsWith(".jpg")
                || source.toLowerCase().endsWith(".jpeg")
                || source.toLowerCase().endsWith(".png")
                || source.toLowerCase().endsWith(".pom"))
            FileUtils.copyResource(source, dest.getAbsolutePath());
        else {
            String data = FileUtils.readResourceSafe(source);
            if (data == null)
                throw new ProjectException("Resource " + source + " can not be created.");

            boolean isProperty = source.endsWith(".properties") || source.endsWith(".crossmobile") || source.endsWith("pom.xml");
            if (list != null)
                for (Param param : list.getParamset().build())
                    if (param.anchor != null)
                        data = data.replace(param.anchor, list.get(param, isProperty));
            FileUtils.write(dest, data);
        }
    }

    public static void updateProperties(String source, File dest, final ParamList list, File backupDir) throws ProjectException {
        if (!dest.exists())
            copyTemplate(source, dest, list);

        FileUtils.backup(dest, backupDir, true);
        FileInputStream fis;
        try {
            fis = new FileInputStream(dest);
        } catch (FileNotFoundException ex) {
            throw new ProjectException("Unable to store file " + source, ex);
        }

        final StringBuilder buffer = new StringBuilder();
        final Set<Param> missingTags = new HashSet<>(list.getParamset().local());
        FileUtils.read(fis, source, new Consumer<String>() {
            StringBuilder out = new StringBuilder();

            @Override
            public void accept(String line) {
                if (line.endsWith("\\"))
                    out.append(line, 0, line.length() - 1);
                else {
                    if (out.length() > 0) {
                        out.append(line);
                        line = out.toString();
                        out = new StringBuilder();
                    }
                    String proc = processLine(line);
                    if (proc == null)
                        buffer.append(line).append('\n');
                    else if (!proc.isEmpty())
                        buffer.append(proc);
                    else
                        Log.debug("proc:" + proc + " line:" + line);
                }
            }

            private String processLine(String line) {
                if (line.startsWith("#"))
                    return null;
                int equal = line.indexOf('=');
                if (equal < 0)
                    return null;
                String propName = line.substring(0, equal).trim();
                Param tag = ParamsCommon.getTag(propName);
                if (tag == null)
                    return null;
                missingTags.remove(tag);
                String res = list.get(tag, true);
                if ((res == null || res.trim().isEmpty()) && tag.omitIfMissing)
                    return "";
                return res == null ? null : tag.name + "=" + res + '\n';
            }
        });
        if (missingTags != null)
            for (Param tag : missingTags) {
                String res = list.get(tag, true);
                if (!((res == null || (res.trim().isEmpty()) && tag.omitIfMissing)))
                    buffer.append(tag.name).append("=").append(res).append("\n");
            }
        FileUtils.write(dest, buffer.toString());
    }
}
