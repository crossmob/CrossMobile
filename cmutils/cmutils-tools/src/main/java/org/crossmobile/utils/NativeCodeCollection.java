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
package org.crossmobile.utils;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.bridge.system.JsonHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

import static org.crossmobile.prefs.Config.REVERSE_INF;
import static org.crossmobile.utils.NamingUtils.execSignature;

public class NativeCodeCollection {

    private final Map<String, Map<CtClass, NativeMethodData>> methodClassCode = new HashMap<>();
    private Map<String, Map<String, NativeMethodData>> classMethodCode;
    private final ClassPool cp;

    public NativeCodeCollection(ClassPool cp) {
        this.cp = cp;

    }

    public NativeCodeCollection(Collection<File> jarfiles) {
        this(ReflectionUtils.getClassPool(jarfiles));
        loadSources(jarfiles);
    }

    public ClassPool getClassPool() {
        return cp;
    }

    public void add(String method, Class typeClass, String code, Collection<String> generatedBlocks) {
        add(method, typeClass.getName(), code, generatedBlocks);
    }

    public void add(String method, String typeClass, String code, Collection<String> generatedBlocks) {
        try {
            add(method, cp.get(typeClass), code, generatedBlocks);
        } catch (NotFoundException ex) {
            Log.error("Unable to locate class " + typeClass);
        }
    }

    public void add(String method, CtClass given, String code, Collection<String> generatedBlocks) {
        if (code.isEmpty())
            return;
        Map<CtClass, NativeMethodData> classCode = methodClassCode.get(method);
        CtClass toRemove = null;
        if (classCode == null) {
            classCode = new HashMap<>();
            methodClassCode.put(method, classCode);
        } else
            for (CtClass older : classCode.keySet()) {
                try {
                    if (given.subtypeOf(older))
                        return; // class type is subclass of already attached class; aborting
                } catch (NotFoundException ignored) {
                }
                try {
                    if (older.subtypeOf(given)) {
                        toRemove = older;   // already attached class is subtype of type; should remove old attached class
                        break;
                    }
                } catch (NotFoundException ignored) {
                }
            }
        if (toRemove != null)
            classCode.remove(toRemove);
        classCode.put(given, new NativeMethodData(code, generatedBlocks));
    }

    public Map<String, Map<String, NativeMethodData>> getClassMethodCode() {
        if (classMethodCode == null) {
            classMethodCode = new TreeMap<>();
            for (String method : methodClassCode.keySet()) {
                Map<CtClass, NativeMethodData> objectCode = methodClassCode.get(method);
                for (CtClass object : objectCode.keySet()) {
                    String className = object.getName();
                    addClassMethodCode(className, method, objectCode.get(object));
                }
            }
        }
        return classMethodCode;
    }

    private void addClassMethodCode(String className, String method, NativeMethodData code) {
        Map<String, NativeMethodData> methodCode = classMethodCode.get(className);
        if (methodCode == null) {
            methodCode = new TreeMap<>();
            classMethodCode.put(className, methodCode);
        }
        methodCode.put(method, code);
    }

    public NativeMethodData getCode(CtClass baseClass, CtMethod exec) {
        String sig = execSignature(exec);
        if (sig == null)
            Log.error("Unable to retrieve signature of " + baseClass.toString());
        else {
            Map<CtClass, NativeMethodData> classCode = methodClassCode.get(sig);
            if (classCode != null)
                for (CtClass cls : classCode.keySet())
                    try {
                        if (baseClass.subtypeOf(cls))
                            return classCode.get(cls);
                    } catch (NotFoundException ignored) {
                    }
        }
        return null;
    }

    // JSON related methods
    @SuppressWarnings("UseSpecificCatch")
    private void loadSources(Collection<File> classpaths) {
        for (File classpath : classpaths)
            if (classpath.isDirectory())
                try {
                    loadSources(new FileInputStream(new File(classpath, REVERSE_INF)), classpath);
                } catch (Exception ex) {
                }
            else if (classpath.isFile())
                try {
                    JarFile jar = new JarFile(classpath);
                    ZipEntry codeentry = jar.getEntry(REVERSE_INF);
                    loadSources(jar.getInputStream(codeentry), classpath);
                } catch (Exception ex) {
                    BaseUtils.throwException(new IOException("Unable to locate reverse bindings for plugin " + classpath.getName(), ex));
                }
    }

    @SuppressWarnings("unchecked")
    public void loadSources(InputStream stream, File location) {
        String content = FileUtils.readSafe(stream, "plugin file");
        if (content == null || content.isEmpty())
            throw new RuntimeException("Unable to load reverse bindings from " + location.getAbsolutePath());
        Map<String, Object> classes = (Map<String, Object>) JsonHelper.decode(content);
        for (String className : classes.keySet()) {
            Map<String, Object> classData = (Map<String, Object>) classes.get(className);
            for (String method : classData.keySet()) {
                Map<String, Object> methodData = (Map<String, Object>) classData.get(method);
                String code = (String) methodData.get("code");
                Collection<String> imports = (Collection<String>) methodData.getOrDefault("classes", Collections.emptyList());
                add(method, className, code, imports);
            }
        }
    }

    public Iterable<String> getClasses() {
        return classMethodCode.keySet();
    }

    public static class NativeMethodData implements JsonHelper.JsonSerializable {
        private HashMap<String, Object> data = new HashMap<>();

        private NativeMethodData(String code, Collection<String> injectedClasses) {
            data.put("code", code);
            if (!injectedClasses.isEmpty())
                data.put("classes", injectedClasses);
        }

        public String getCode() {
            return (String) data.get("code");
        }

        @SuppressWarnings("unchecked")
        public Collection<String> getGeneratedBlocks() {
            return (Collection<String>) data.getOrDefault("classes", Collections.emptyList());
        }

        @Override
        public Object asJsonSerializable() {
            return data;
        }
    }
}
