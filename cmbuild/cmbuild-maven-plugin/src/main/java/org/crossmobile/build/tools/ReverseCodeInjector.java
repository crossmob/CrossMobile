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

import javassist.CtClass;
import javassist.CtMethod;
import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.bridge.system.Pair;
import org.crossmobile.utils.ClasspathUtils;
import org.crossmobile.utils.FileUtils;
import org.crossmobile.utils.Log;
import org.crossmobile.utils.ReverseCodeCollection;
import org.crossmobile.utils.ReverseCodeCollection.ReverseMethod;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.singleton;
import static java.util.Comparator.comparing;
import static java.util.regex.Matcher.quoteReplacement;
import static org.crossmobile.utils.FileUtils.read;
import static org.crossmobile.utils.FileUtils.write;
import static org.crossmobile.utils.NamingUtils.execSignature;
import static org.crossmobile.utils.NamingUtils.toObjC;
import static org.crossmobile.utils.TextUtils.plural;

public class ReverseCodeInjector {

    public static void exec(File selfClassPath, Collection<File> libJarPaths, File destinationDir) {
        Collection<File> classPaths = new ArrayList<>();
        Map<String, String> codeInjections = new HashMap<>();
        Map<String, String> importsInjections = new HashMap<>();

        classPaths.add(selfClassPath);
        classPaths.addAll(libJarPaths);
        ReverseCodeCollection dbn = new ReverseCodeCollection(classPaths);
        Map<CtClass, Map<String, String>> superCode = new TreeMap<>(comparing(CtClass::getName));
        Collection<String> superImports = new TreeSet<>();
        for (String className : ClasspathUtils.getClasspathClasses(singleton(selfClassPath), true)) {
            try {
                CtClass objectC = dbn.getClassPool().get(className);
                String canonicalClassName = className.replace('.', '_').replace('$', '_');
                InjectionResult injectionData = findInjectionsForClass(dbn, objectC, superCode, superImports);
                if (injectionData != null) {
                    codeInjections.put(canonicalClassName, injectionData.getReverseCode());
                    importsInjections.put(canonicalClassName, injectionData.getReverseImports());
                }
            } catch (Exception ex) {
                BaseUtils.throwException(ex);
            }
        }

        int countOverride = 0;
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
                countOverride++;
                Log.debug("Applied reverse connections for file " + mfileRef.getName());
            }
        }

        int countSuper = 0;
        if (!superCode.isEmpty()) {
            StringBuilder out = new StringBuilder();
            out.append("/* Overridable categories to support super.method() */\n");
            for (String importedClass : superImports)
                out.append("#import \"").append(importedClass).append(".h\"\n");
            for (CtClass ctclass : superCode.keySet()) {
                Map<String, String> selectors = superCode.get(ctclass);
                String objcClassName = toObjC(ctclass.getName());
                out.append("\n@implementation ").append(objcClassName).append("$Ext (cm_super_impl)\n\n");
                for (String selector : superCode.get(ctclass).values()) {
                    countSuper++;
                    out.append(selector);
                }
                out.append("@end\n");
            }
            FileUtils.write(new File(destinationDir, "crossmobilesuperimpl.m"), out.toString());
        }

        Log.info("Injected " + countOverride + " class" + plural(countOverride, "es")
                + " and " + countSuper + " super implementation" + plural(countSuper));
    }

    private static InjectionResult findInjectionsForClass(ReverseCodeCollection dbn, CtClass objectC, Map<CtClass, Map<String, String>> superCode, Collection<String> superImports) {
        InjectionResult injections = null;
        for (CtMethod m : objectC.getDeclaredMethods()) {
            String signature = execSignature(m);
            Pair<ReverseMethod, CtClass> methodData = dbn.getMethodData(objectC, signature);
            if (methodData != null) {
                if (injections == null)
                    injections = new InjectionResult();
                ReverseMethod data = methodData.a;
                CtClass baseClass = methodData.b;
                injections.reverseCode.append(data.getReverse());
                if (!baseClass.isInterface()) {
                    superCode.computeIfAbsent(baseClass, c -> new TreeMap<>()).put(signature, data.getSuper());
                    superImports.add(toObjC(baseClass.getName()));
                    superImports.addAll(data.getSuperImports());
                }
                data.getReverseImports().forEach(injections.reverseImports::add);
                Log.debug("Found reverse connection for " + objectC.getName() + "." + m.getName());
            }
        }
        return injections;
    }

    private static class InjectionResult {
        private final StringBuilder reverseCode = new StringBuilder();
        private final Collection<String> reverseImports = new TreeSet<>();

        public String getReverseCode() {
            return reverseCode.toString();
        }

        public String getReverseImports() {
            return reverseImports.isEmpty() ? "" : reverseImports.stream().collect(Collectors.joining(".h\"\n#import \"", "#import \"", ".h\"\n"));
        }
    }
}
