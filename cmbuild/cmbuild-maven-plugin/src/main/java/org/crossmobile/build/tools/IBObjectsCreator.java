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

import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.build.ib.Element;
import org.crossmobile.build.ib.helper.XIBList;
import org.crossmobile.build.ib.helper.XibClassStart;
import org.crossmobile.build.ib.i18n.IBParserMeta;
import org.crossmobile.utils.FileUtils;
import org.crossmobile.utils.Log;
import org.crossmobile.utils.XMLWalker;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.crossmobile.build.AnnotationConfig.GENERATED_EXT;
import static org.crossmobile.utils.FileUtils.*;
import static org.crossmobile.utils.FileUtils.Predicates.extensions;
import static org.crossmobile.utils.FileUtils.Predicates.noHidden;
import static org.crossmobile.utils.TextUtils.plural;
import static org.crossmobile.utils.TextUtils.trim;

public class IBObjectsCreator {

    public static XIBList parse(File materials, File ann) {
        ann.mkdirs();
        forAllRecursively(ann, f -> f.getName().equals(GENERATED_EXT), (path, file) -> file.delete());
        XIBList root = new XIBList(new IBParserMeta(ann));
        forAllRecursively(materials, noHidden().and(extensions(".xib", ".storyboard")), (path, file) -> {
            root.getMeta().beginFile(file, materials);
            XMLWalker walker = XMLWalker.load(file).node("document");
            String type = walker.attribute("type").toLowerCase();
            if (type.endsWith(".storyboard.xib")) {
                XibClassStart classStart = ((XibClassStart) root.addChild("xibclassstart", null, root.getMeta()));

                classStart.setFilename(toFilename(materials, file));
                classStart.setInitialViewController(walker.attribute("initialViewController"));
                walker.node("scenes").nodes(node -> construct(root, node));

                root.addChild("xibclassend", null, root.getMeta());
            } else if (type.endsWith(".cocoatouch.xib"))
                walker.nodes(node -> construct(root, node));
            root.getMeta().endFile();
        });
        return root;
    }

    private static void construct(Element parent, XMLWalker walker) {
        walker.nodes(node -> {
            Element child = parent.addChild(node.name(), node.attribute("key"), parent.getMeta());
            if (child != null) {
                node.attributes(child::setAttribute);
                child.performChecks();
                child.applyLocalizations(parent);
                construct(child, node);
            }
        });
    }

    public static void createJavaSource(XIBList xiblist, File destination, File cache) {
        destination.getParentFile().mkdirs();
        int size = xiblist.countItems();
        if (size > 0) {
            cache.getParentFile().mkdirs();
            try (Writer out = new OutputStreamWriter(new FileOutputStream(cache), StandardCharsets.UTF_8)) {
                out.append(xiblist.toCode());
                Log.info("Added " + size + " Interface Builder resource class" + plural(size, "es"));
            } catch (IOException ex) {
                BaseUtils.throwException(ex);
            }
        }
        if (cache.exists())
            sync(cache, destination, false);
    }

    private static String toFilename(File baseDir, File currentFile) {
        return FileUtils.getRelative(baseDir, currentFile)
                .replace("\\", "_")
                .replace("/", "_")
                .replace(".", "_")
                .replace(" ", "_");
    }
}
