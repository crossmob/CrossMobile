/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package org.crossmobile.build.tools;

import org.crossmobile.utils.FileUtils;
import org.crossmobile.utils.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.crossmobile.utils.TextUtils.plural;

public class ObjCPostProcess {

    private static final Pattern unicodeP = Pattern.compile("\\\\([0-9]+)");
    private static final Pattern constrP = Pattern.compile(": (crossmobile_ios_[^\\s]+)");
    private static final Pattern javaclass = Pattern.compile("[a-zA-Z][a-zA-Z_0-9$]*(\\.[a-zA-Z][a-zA-Z_0-9$]*)*");

    /**
     * @param objc           The objective C file to process
     * @param ignoreIncludes a semicolon separated list of canonical class names,  used to remove dependencies in
     *                       external libraries that are not implemented yet.
     */
    public static void exec(File objc, String ignoreIncludes) {
        List<Pattern> ignoreInclPatterns = retrieveIgnoreIncludePattern(ignoreIncludes);
        int h_files = 0;
        int m_files = 0;
        AtomicInteger ignoredIncludeCount = new AtomicInteger(0);
        File[] objcfiles = objc.listFiles();
        if (objcfiles != null)
            for (File f : objcfiles) {
                String content = FileUtils.read(f);
                if (f.getName().endsWith(".h")) {
                    h_files++;
                    content = parseConstructors(content);
                } else {
                    m_files++;
                    content = parseIgnoreIncludes(content, ignoreInclPatterns, ignoredIncludeCount);
                }
                content = parseUnicode(content).
                        replaceAll("isKindOfClass: objc_getClass\\(\"crossmobile_ios_", "isKindOfClass: objc_getClass(\"").
                        replaceAll("conformsToProtocol: objc_getProtocol\\(\"crossmobile_ios_", "conformsToProtocol: objc_getProtocol(\"");

                FileUtils.write(f, content);
            }
        if (ignoredIncludeCount.get() > 0)
            Log.info("Ignoring importing of " + ignoredIncludeCount.get() + " class" + plural(ignoredIncludeCount.get(), "es"));
        Log.info("Parsed " + h_files + " header file" + plural(h_files) + " and " + m_files + " implementation file" + plural(m_files));
    }

    private static String parseIgnoreIncludes(String content, List<Pattern> patterns, AtomicInteger ignored) {
        for (Pattern pattern : patterns) {
            Matcher matcher = pattern.matcher(content);
            if (matcher.find()) {
                Log.debug("Found ignoring imported pattern " + pattern.pattern());
                content = matcher.replaceFirst("//" + matcher.group());
                ignored.incrementAndGet();
            }
        }
        return content;
    }

    private static List<Pattern> retrieveIgnoreIncludePattern(String ignoreIncludes) {
        if (ignoreIncludes == null || ignoreIncludes.trim().isEmpty())
            return Collections.emptyList();
        List<Pattern> patterns = new ArrayList<>();
        for (String part : ignoreIncludes.split(";")) {
            part = part.trim();
            if (part.isEmpty())
                continue;
            if (javaclass.matcher(part).matches()) {
                Log.debug("Ignoring inclusion of imported class " + part);
                part = part.replace('.', '_').replaceAll("\\.", "\\.");
                patterns.add(Pattern.compile("#import \"" + part + "\\.h\""));
            } else
                Log.error("User requested to ignore class name " + part + ", which doesn't look like a Java class.");
        }
        return patterns;
    }

    private static String parseConstructors(String input) {
        Matcher constrM = constrP.matcher(input);
        input = constrM.find()
                ? constrM.replaceFirst(": $1\\$Ext")
                : input;
        return input;
    }

    private static String parseUnicode(String input) {
        Matcher m = unicodeP.matcher(input);
        while (m.find()) {
            input = input.substring(0, m.start()) + new String(Character.toChars(Integer.parseInt(m.group(1), 8))) + input.substring(m.end());
            m.reset(input);
        }
        return input;
    }
}
