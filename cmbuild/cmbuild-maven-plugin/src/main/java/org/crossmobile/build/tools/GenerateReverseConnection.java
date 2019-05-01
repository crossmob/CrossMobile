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
package org.crossmobile.build.tools;

import javassist.CtClass;
import javassist.CtMethod;
import org.crossmobile.bridge.system.ExceptionUtils;
import org.crossmobile.utils.Log;
import org.crossmobile.utils.NativeCodeCollection;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.crossmobile.utils.FileUtils.*;
import static org.crossmobile.utils.TextUtils.plural;

public class GenerateReverseConnection {

    public static void exec(File selfClassPath, Collection<File> libjarpaths, File destdir) {
        Collection<File> classpaths = new ArrayList<>();
        Map<String, String> injections = new HashMap<>();

        classpaths.add(selfClassPath);
        classpaths.addAll(libjarpaths);
        NativeCodeCollection dbn = new NativeCodeCollection(classpaths);
        forAll(selfClassPath, file -> file.getName().toLowerCase().endsWith(".class"), (path, file) -> {
            String classname = selfClassPath.toURI().relativize(file.toURI()).toString();
            classname = classname.substring(0, classname.length() - 6).replace('/', '.').replace('\\', '.');
            try {
                CtClass objectC = dbn.getClassPool().get(classname);
                String injection = findInjectionsForClass(dbn, objectC);
                if (!injection.isEmpty())
                    injections.put(classname.replace('.', '_').replace('$', '_'), injection);
            } catch (Exception ex) {
                ExceptionUtils.throwException(ex);
            }
        });

        int count = 0;
        for (String name : injections.keySet()) {
            File mfileRef = new File(destdir, name + ".m");
            if (!mfileRef.isFile())
                Log.debug("Reverse connections for " + mfileRef.getName() + " not applied, file missing (maybe due to incremental compiling)");
            else {
                String mfile = read(mfileRef);
                mfile = mfile.replace("@end", injections.get(name) + "\n\n@end");
                write(mfileRef, mfile);
                count++;
                Log.debug("Applied reverse connections for file " + mfileRef.getName());
            }
        }
        Log.info("Injected " + count + " class" + plural(count, "es"));
    }

    private static String findInjectionsForClass(NativeCodeCollection dbn, CtClass objectC) {
        StringBuilder out = new StringBuilder();
        for (CtMethod m : objectC.getDeclaredMethods()) {
            String code = dbn.getCode(objectC, m);
            if (!code.isEmpty()) {
                out.append(code);
                Log.debug("Found reverse connection for " + objectC.getName() + "." + m.getName());
            }
        }
        return out.toString();
    }
}
