/*
 * (c) 2019 by Panayotis Katsaloulis
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

import javassist.CtClass;
import javassist.CtMethod;
import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.bridge.system.Pair;
import org.crossmobile.utils.*;
import org.crossmobile.utils.NativeCodeCollection.NativeMethodData;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

import static java.util.regex.Matcher.quoteReplacement;
import static org.crossmobile.utils.FileUtils.*;
import static org.crossmobile.utils.TextUtils.plural;

public class GenerateReverseConnection {

    public static void exec(File selfClassPath, Collection<File> libJarPaths, File destinationDir) {
        Collection<File> classPaths = new ArrayList<>();
        Map<String, String> codeInjections = new HashMap<>();
        Map<String, String> importsInjections = new HashMap<>();

        classPaths.add(selfClassPath);
        classPaths.addAll(libJarPaths);
        NativeCodeCollection dbn = new NativeCodeCollection(classPaths);
        for (String className : ClasspathUtils.getClasspathClasses(Collections.singleton(selfClassPath), true)) {
            try {
                CtClass objectC = dbn.getClassPool().get(className);
                Pair<String, String> injectionData = findInjectionsForClass(dbn, objectC);
                String code = injectionData.a;
                String imports = injectionData.b;
                if (!code.isEmpty()) {
                    String canonicalClassName = className.replace('.', '_').replace('$', '_');
                    codeInjections.put(canonicalClassName, code);
                    importsInjections.put(canonicalClassName, imports);
                }
            } catch (Exception ex) {
                BaseUtils.throwException(ex);
            }
        }

        int count = 0;
        for (String name : codeInjections.keySet()) {
            File mfileRef = new File(destinationDir, name + ".m");
            String mfile = read(mfileRef);
            if (mfile == null)
                Log.error("Reverse connections for " + mfileRef.getName() + " not applied, file missing (maybe due to incremental compiling)");
            else {
                mfile = mfile.replaceFirst("@end", quoteReplacement(codeInjections.get(name) + "\n\n@end"));
                String imports = importsInjections.get(name);
                if (!imports.isEmpty())
                    mfile = mfile.replaceFirst("#import", quoteReplacement(imports + "#import"));
                write(mfileRef, mfile);
                count++;
                Log.debug("Applied reverse connections for file " + mfileRef.getName());
            }
        }
        Log.info("Injected " + count + " class" + plural(count, "es"));
    }

    private static Pair<String, String> findInjectionsForClass(NativeCodeCollection dbn, CtClass objectC) {
        StringBuilder out = new StringBuilder();
        Collection<String> injectedClasses = new TreeSet<>();
        for (CtMethod m : objectC.getDeclaredMethods()) {
            NativeMethodData data = dbn.getCode(objectC, m);
            String code = data == null ? "" : data.getCode();
            if (!code.isEmpty()) {
                out.append(code);
                injectedClasses.addAll(data.getGeneratedBlocks());
                Log.debug("Found reverse connection for " + objectC.getName() + "." + m.getName());
            }
        }
        return new Pair<>(out.toString(),
                injectedClasses.isEmpty() ? "" : injectedClasses.stream().collect(Collectors.joining(".h\"\n#import \"", "#import \"", ".h\"\n")));
    }
}
