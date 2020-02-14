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

import org.crossmobile.build.ib.AnnotationHelpers.CodeAnnotations;
import org.crossmobile.build.ib.AnnotationHelpers.NativeCode;
import org.crossmobile.utils.FileUtils;
import org.crossmobile.utils.Log;

import java.io.File;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnnConnXcode {

    private static final Pattern depack = Pattern.compile("crossmobile_ios_([a-zA-Z]*)_([a-zA-Z]*)");

    public static void exec(Map<String, CodeAnnotations> annotations, File objcBase) {
        for (String objectName : annotations.keySet())
            parseAnnotation(objectName, annotations.get(objectName), objcBase);
        if (!annotations.isEmpty())
            Log.info("Found " + annotations.size() + " annotated objects");
    }

    private static void parseAnnotation(String name, CodeAnnotations annotation, File objcBase) {
        File hfileRef = new File(objcBase, name + ".h");
        File mfileRef = new File(objcBase, name + ".m");

        if (!hfileRef.exists()) {
            Log.warning("Generated header file " + hfileRef.getName() + " does not exist, skipping " + name + " annotations");
            return;
        }
        if (!mfileRef.exists()) {
            Log.warning("Generated source file " + mfileRef.getName() + " does not exist, skipping " + name + " annotations");
            return;
        }
        String hfile = FileUtils.read(hfileRef);
        String mfile = FileUtils.read(mfileRef);

        /* Inject actions */
        {
            StringBuilder hactions = new StringBuilder();
            StringBuilder mactions = new StringBuilder();
            for (String action : annotation.getActions()) {
                hactions.append("- (IBAction) ").append(action).append(":(id) sender;\n");
                mactions.append("- (IBAction) ").append(action).append(":(id) sender {\n    [self ").append(action).append("___java_lang_Object:sender];\n}\n\n");
            }
            hfile = hfile.replace("@end", hactions.toString() + "\n@end");
            mfile = mfile.replace("@end", mactions.toString() + "\n@end");
        }

        /* Inject outlets */
        {
            for (String oname : annotation.getOutlets()) {
                String otype = annotation.getOutletType(oname);
                String fname = oname.replace("_" + otype, "") + "_field";
                String toName = "@property " + otype + "* " + fname + ";";
                if (hfile.contains(toName)) {
                    hfile = hfile.replace(toName, "@property (strong) IBOutlet " + simplifyType(otype) + "* " + fname + ";");
                    if (otype.startsWith("crossmobile_ios_"))
                        hfile = hfile.replace("@class " + otype + ";", "#import \"" + otype + ".h\"");
                } else
                    Log.warning("Unable to find " + oname + ", skipping");
            }
        }

        /* Inject native methods */
        {
            for (String oldmethod : annotation.getNatives()) {
                String oldcode = "// [NATIVE PLACEHOLDER] " + oldmethod;
                NativeCode nativeCode = annotation.getNativeCode(oldmethod);
                if (!mfile.contains(oldcode))
                    throw new RuntimeException("Unbale to match signature " + oldcode);
                mfile = mfile.replace(oldcode, nativeCode.body).
                        replace(oldmethod + "\n{", nativeCode.signature + "\n{").
                        replace(oldmethod + "\r\n{", nativeCode.signature + "\r\n{");
            }
        }

        /* Write files */
        FileUtils.write(hfileRef, hfile);
        FileUtils.write(mfileRef, mfile);
    }

    private static String simplifyType(String type) {
        Matcher m = depack.matcher(type);
        return m.matches() ? m.replaceFirst("$2") : type;
    }

}
