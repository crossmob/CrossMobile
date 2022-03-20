/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.bridge.system.JsonHelper;
import org.crossmobile.bridge.system.Pair;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

import static java.util.Collections.emptyList;
import static java.util.Comparator.comparing;
import static org.crossmobile.prefs.Config.REVERSE_INF;
import static org.crossmobile.utils.ReflectionUtils.*;

public class ReverseCodeCollection {
    private static final String REVERSE_KEY = "reverse";
    private static final String SUPER_KEY = "super";
    private static final String REV_IMPORT_KEY = "revimport";
    private static final String SUP_IMPORT_KEY = "supimport";

    // method name, containing class, reverse implementation
    private final Map<String, Map<CtClass, ReverseMethod>> methodClassCode = new TreeMap<>();
    private Map<String, Map<String, ReverseMethod>> classMethodCode;
    private final ClassPool cp;

    public ReverseCodeCollection(ClassPool cp) {
        this.cp = cp;
    }

    public ReverseCodeCollection(Collection<File> jarfiles) {
        this(ReflectionUtils.getClassPool(jarfiles));
        loadSources(jarfiles);
    }

    public ClassPool getClassPool() {
        return cp;
    }

    /* Add from reflection */
    public void addFromSource(String method, Class<?> typeClass, String reverseCode, String superCode, Collection<String> reverseImport, Collection<String> superImport) {
        add(method, typeClass.getName(), reverseCode, superCode, reverseImport, superImport);
    }

    public void add(String method, String typeClass, String reverseCode, String superCode, Collection<String> reverseImport, Collection<String> superImport) {
        methodClassCode.computeIfAbsent(method, m -> new TreeMap<>(comparing(CtClass::getName)))
                .put(getCtClass(cp, typeClass), new ReverseMethod(reverseCode, superCode, reverseImport, superImport));
        classMethodCode = null;
    }

    public Map<String, Map<String, ReverseMethod>> getClassMethodCode() {
        if (classMethodCode == null) {
            classMethodCode = new TreeMap<>();
            for (String method : methodClassCode.keySet()) {
                Map<CtClass, ReverseMethod> objectCode = methodClassCode.get(method);
                for (CtClass object : objectCode.keySet())
                    classMethodCode.computeIfAbsent(object.getName(), k -> new TreeMap<>())
                            .put(method, objectCode.get(object));
            }
        }
        return classMethodCode;
    }

    public Pair<ReverseMethod, CtClass> getMethodData(CtClass ctClass, String signature) {
        Map<CtClass, ReverseMethod> classCode = methodClassCode.get(signature);
        if (classCode == null)
            return null;
        for (CtClass currentClass : getInheritedClasses(ctClass)) {
            CtClass initialAppear = null;
            while (currentClass != null) {
                ReverseMethod reverseMethod = classCode.get(currentClass);
                if (reverseMethod != null) {
                    if (initialAppear == null)
                        initialAppear = currentClass;
                    if (reverseMethod.isDataHere())
                        return new Pair<>(reverseMethod, initialAppear);
                }
                currentClass = getSuperClass(currentClass);
            }
            if (initialAppear != null)
                Log.error("Although method " + signature + " was found in " + initialAppear.getName() + ", no reverse definitions where found");
        }
        return null;
    }

    // JSON related methods
    @SuppressWarnings("UseSpecificCatch")
    private void loadSources(Collection<File> classpaths) {
        for (File classpath : classpaths)
            if (classpath.isDirectory())
                try {
                    loadSources(new FileInputStream(new File(classpath, REVERSE_INF)), classpath.getAbsolutePath());
                } catch (Exception ignored) {
                }
            else if (classpath.isFile())
                try {
                    JarFile jar = new JarFile(classpath);
                    ZipEntry codeentry = jar.getEntry(REVERSE_INF);
                    loadSources(jar.getInputStream(codeentry), classpath.getAbsolutePath());
                } catch (Exception ex) {
                    BaseUtils.throwException(new IOException("Unable to locate reverse bindings for plugin " + classpath.getName(), ex));
                }
    }

    @SuppressWarnings("unchecked")
    public void loadSources(InputStream stream, String location) {
        String content = FileUtils.readSafe(stream, "plugin file");
        if (content == null || content.isEmpty())
            throw new RuntimeException("Unable to load reverse bindings from " + location);
        Map<String, Map<String, Map<String, Object>>> classes = (Map<String, Map<String, Map<String, Object>>>) JsonHelper.decode(content);
        for (String className : classes.keySet()) {
            Map<String, Map<String, Object>> classData = classes.get(className);
            for (String method : classData.keySet()) {
                Map<String, Object> methodData = classData.get(method);
                add(method, className
                        , methodData == null ? "" : methodData.get(REVERSE_KEY).toString()
                        , methodData == null ? "" : methodData.get(SUPER_KEY).toString()
                        , methodData == null ? emptyList() : (Collection<String>) methodData.getOrDefault(REV_IMPORT_KEY, emptyList())
                        , methodData == null ? emptyList() : (Collection<String>) methodData.getOrDefault(SUP_IMPORT_KEY, emptyList()));
            }
        }
    }

    public Iterable<String> getClasses() {
        return classMethodCode.keySet();
    }

    public static class ReverseMethod implements JsonHelper.JsonSerializable {

        private final String reverseCode;
        private final String superCode;
        private final Collection<String> reverseImport;
        private final Collection<String> superImport;

        private ReverseMethod(String reverseCode, String superCode, Collection<String> reverseImport, Collection<String> superImport) {
            this.reverseCode = reverseCode;
            this.superCode = superCode;
            this.reverseImport = reverseImport;
            this.superImport = superImport;
        }

        private boolean isDataHere() {
            return !reverseCode.isEmpty();
        }

        public String getReverse() {
            return reverseCode;
        }

        public String getSuper() {
            return superCode;
        }

        @SuppressWarnings("unchecked")
        public Iterable<String> getReverseImports() {
            return reverseImport;
        }

        @SuppressWarnings("unchecked")
        public Collection<String> getSuperImports() {
            return superImport;
        }

        @Override
        public Object asJsonSerializable() {
            if (reverseCode.isEmpty())
                return null;
            Map<String, Object> data = new TreeMap<>();
            data.put(REVERSE_KEY, reverseCode);
            data.put(SUPER_KEY, superCode);
            if (!reverseImport.isEmpty())
                data.put(REV_IMPORT_KEY, reverseImport);
            if (!superImport.isEmpty())
                data.put(SUP_IMPORT_KEY, superImport);
            return data;
        }
    }
}
