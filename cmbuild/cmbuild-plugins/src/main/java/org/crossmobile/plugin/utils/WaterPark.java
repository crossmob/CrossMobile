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
package org.crossmobile.plugin.utils;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import org.crossmobile.plugin.reg.ObjectRegistry;
import org.crossmobile.utils.Log;

/**
 * This Class Creates a new clean Class pool for new classes to be created in
 * without tainting the default java pool
 */
public class WaterPark {

    // initialClasses contains classes that are not referenced but are necessary to compile
    private final static Class<?>[] initialClasses = {Object.class, Class.class};
    private final ClassPool defaultClassPool;
    private final ClassPool current;

    public WaterPark(ClassPool parent) {
        this.defaultClassPool = parent;
        current = new ClassPool();
        for (Class<?> initialClass : initialClasses) transferToCurrent(initialClass.getName());
    }

    /**
     * Checks if classname exists in the ClassPool.
     * If Class does not exist in the class pool but does not need to be
     * created (i.e. it is not part of the specified iOS API, but it is part of JDK API),
     * then it brought from the default ClassPool
     * <p>
     * e.g. if className == "java.lang.String" and not in ClassPool it will be transferred
     * from the default ClassPool and the method will return true, while if
     * className == "crossmobile.ios.foundation.NSObject" and is not in the @ClassPool
     * the method will return false because the class needs to be created
     *
     * @param className The full name of the class i.e. "java.lang.String"
     * @return false if the class is not in the @ClassPool and needs to be created otherwise true
     */
    public boolean contains(String className) {
        if (current.getOrNull(className) != null)
            return true;

        if (ObjectRegistry.contains(className))
            return false;

        transferToCurrent(className);
        return true;
    }

    /**
     * returns the current ClassPool
     *
     * @return returns the current ClassPool
     */
    public ClassPool classPool() {
        return current;
    }

    /**
     * @param className The full name of the class i.e. "java.lang.String"
     * @return The Corresponding CtClass
     */
    public CtClass get(String className) {
        return current.getOrNull(className);
    }


    /**
     * Tries to get Class from current class pool
     *
     * @param className the fully quallified class name ex. "org.robovm.apple.foundation.NSArray$AsListMarshaler"
     * @return the Class<?> Object of the specified class or null
     */
    public Class<?> toClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException ignored) {
        }
        try {
            return current.toClass(get(className));
        } catch (CannotCompileException e) {
            Log.error("Could not fetch " + className + " from current class pool , couse");
            return null;
        }
    }

    /**
     * Transfers the class from the default ClassPool to current
     *
     * @param className The full name of the class i.e. "java.lang.String"
     */
    private void transferToCurrent(String className) {
        CtClass pclass = defaultClassPool.getOrNull(className);
        if (pclass == null)
            Log.error("Class named " + className + " could not be found in default classpool");
        try {
            current.makeClass(pclass.getClassFile());
        } catch (Exception e) {
            System.out.println();
        }

    }
}
