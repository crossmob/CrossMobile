/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.crossmobile.utils;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import org.crossmobile.bridge.system.ExceptionUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

import static org.crossmobile.utils.NamingUtils.execSignature;

public class NativeCodeCollection {

    public final static String REVERSE_INF = "META-INF/REVERSE.INF";

    private final Map<String, Map<CtClass, String>> methodClassCode = new HashMap<>();
    private Map<String, Map<String, String>> classMethodCode;
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

    public void add(String method, Class typeClass, String code) {
        add(method, typeClass.getName(), code);
    }

    public void add(String method, String typeClass, String code) {
        try {
            add(method, cp.get(typeClass), code);
        } catch (NotFoundException ex) {
            Log.error("Unable to locate class " + typeClass);
        }
    }

    public void add(String method, CtClass given, String code) {
        if (code.isEmpty())
            return;
        Map<CtClass, String> classCode = methodClassCode.get(method);
        CtClass toRemove = null;
        if (classCode == null) {
            classCode = new HashMap<>();
            methodClassCode.put(method, classCode);
        } else
            for (CtClass older : classCode.keySet()) {
                try {
                    if (given.subtypeOf(older))
                        return; // class type is subclass of already attached class; aborting
                } catch (NotFoundException ex) {
                }
                try {
                    if (older.subtypeOf(given)) {
                        toRemove = older;   // already attached class is subtype of type; should remove old attached class
                        break;
                    }
                } catch (NotFoundException ex) {
                }
            }
        if (toRemove != null)
            classCode.remove(toRemove);
        classCode.put(given, code);
    }

    public Map<String, Map<String, String>> getClassMethodCode() {
        if (classMethodCode == null) {
            classMethodCode = new TreeMap<>();
            for (String method : methodClassCode.keySet()) {
                Map<CtClass, String> objectCode = methodClassCode.get(method);
                for (CtClass object : objectCode.keySet()) {
                    String classname = object.getName();
                    addClassMethodCode(classname, method, objectCode.get(object));
                }
            }
        }
        return classMethodCode;
    }

    private void addClassMethodCode(String classname, String method, String code) {
        Map<String, String> methodCode = classMethodCode.get(classname);
        if (methodCode == null) {
            methodCode = new TreeMap<>();
            classMethodCode.put(classname, methodCode);
        }
        methodCode.put(method, code);
    }

    public String getCode(CtClass baseClass, CtMethod exec) {
        String sig = execSignature(exec);
        if (sig == null)
            Log.error("Unable to retrieve signature of " + baseClass.toString());
        else {
            Map<CtClass, String> classCode = methodClassCode.get(sig);
            if (classCode != null)
                for (CtClass cls : classCode.keySet())
                    try {
                        if (baseClass.subtypeOf(cls))
                            return classCode.get(cls);
                    } catch (NotFoundException ex) {
                    }
        }
        return "";
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
                    ExceptionUtils.throwException(new IOException("Unable to locate reverse bindings for plugin " + classpath.getName(), ex));
                }
    }

    public void loadSources(InputStream stream, File location) {
        String content = FileUtils.readSafe(stream, "plugin file");
        if (content == null || content.isEmpty())
            throw new RuntimeException("Unable to load reverse bindings from " + location.getAbsolutePath());
        JsonObject obj = Json.parse(content).asObject();
        for (String cls : obj.names()) {
            JsonObject methodCode = obj.get(cls).asObject();
            for (String method : methodCode.names())
                add(method, cls, methodCode.getString(method, null));
        }
    }

    public Iterable<String> getClasses() {
        return classMethodCode.keySet();
    }

}
