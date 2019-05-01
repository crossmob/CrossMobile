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
package org.crossmobile.plugin.reg;

import org.crossmobile.plugin.model.NObject;
import org.crossmobile.utils.ReflectionUtils;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class ObjectRegistry {

    private static final Map<Class, NObject> objects = new TreeMap<>(Comparator.comparing(Class::getName));
    private static Class<?> NSObjectClass;
    private static Class<?> CFTypeClass;

    public static void register(NObject nobj) {
        objects.put(nobj.getType(), nobj);
    }

    public static NObject retrieve(Class objClass) {
        return objects.get(objClass);
    }

    public static Iterable<NObject> retrieveAll() {
        return objects.values();
    }

    public static Class<?> getNSObject() {
        if (NSObjectClass == null) {
            NSObjectClass = ReflectionUtils.getClassForName("crossmobile.ios.foundation.NSObject");
            if (NSObjectClass == null)
                throw new RuntimeException("Unable to locate NSObject in classpath");
        }
        return NSObjectClass;
    }

    public static Class<?> getCFType() {
        if (CFTypeClass == null) {
            CFTypeClass = ReflectionUtils.getClassForName("crossmobile.ios.foundation.CFType");
            if (CFTypeClass == null)
                throw new RuntimeException("Unable to locate CFType in classpath");
        }
        return CFTypeClass;
    }

    public static boolean contains(String className) {
        for (Class aClass : objects.keySet())
            if (aClass.getName().equals(className))
                return true;
        return false;
    }
}
