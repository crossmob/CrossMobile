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
package org.crossmobile.plugin.actions;

import javassist.*;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.ClassMemberValue;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMEnum;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMReference;
import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.plugin.reg.ObjectRegistry;
import org.crossmobile.plugin.reg.TargetRegistry;
import org.crossmobile.plugin.utils.ClassCollection;
import org.crossmobile.utils.FileUtils;
import org.crossmobile.utils.Log;
import org.crossmobile.utils.TextUtils;
import org.robovm.objc.annotation.UIAppearanceSelector;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

import static java.util.Arrays.stream;
import static java.util.Comparator.comparing;

@SuppressWarnings("StaticNonFinalUsedInInitialization")
public class CreateBeanAPI {

    public static final byte OBJ_STYLE = 0x10;
    public static final byte BEAN_STYLE = 0x20;
    public static final String GETTER_ATTRIBUTE = "G";

    private static final byte[] OBJ_STYLE_ATTR = {OBJ_STYLE};
    private static final byte[] BEAN_STYLE_ATTR = {BEAN_STYLE};
    private static final byte[] BOTH_STYLES_ATTR = {OBJ_STYLE | BEAN_STYLE};

    private final ClassPool cp;

    public CreateBeanAPI(ClassPool cp) {
        this.cp = cp;
    }

    public boolean beanClass(Class cls, File basedir) {
        try {
            String name = cls.getName();
            CtClass s = cp.get(name);
            if (TargetRegistry.getTarget(s.getName()).compile) {
                boolean changed = false;
                for (CtMethod m : s.getDeclaredMethods()) {
                    if (Modifier.isPublic(m.getModifiers()) && m.getAnnotation(CMGetter.class) != null) {
                        try {
                            if (s.getSuperclass().getMethod(m.getName(), m.getSignature()) != null)
                                continue;
                        } catch (Exception ignore) {
                        }
                        beanMethod(s, m);
                        changed = true;
                    }
                }
                if (changed) {
                    s.writeFile(basedir.getAbsolutePath());
                    s.defrost();
                }
            }
            return true;
        } catch (ClassNotFoundException | IOException | NotFoundException | CannotCompileException ex) {
            BaseUtils.throwException(ex);
            return false;
        }
    }

    private void beanMethod(CtClass s, CtMethod m) throws NotFoundException, CannotCompileException {
        String currentName = m.getName();
        String beanName;
        if (m.getReturnType().equals(CtClass.booleanType)) {
            if (currentName.startsWith("is") || currentName.startsWith("get"))
                beanName = currentName;
            else
                beanName = "get" + TextUtils.capitalize(currentName);
        } else {
            if (currentName.startsWith("get"))
                beanName = currentName;
            else
                beanName = "get" + TextUtils.capitalize(currentName);
        }
        if (beanName.equals(currentName)) {
            m.setAttribute(GETTER_ATTRIBUTE, BOTH_STYLES_ATTR);
            return;
        }

        m.setAttribute(GETTER_ATTRIBUTE, OBJ_STYLE_ATTR);
        try {
            CtMethod found = s.getMethod(beanName, m.getMethodInfo().getDescriptor());
            if (found != null)
                BaseUtils.throwException(new Exception("Name collision: requested to create method " + beanName + " based on " + currentName +
                        " in class " + s.getName() + ", but this method already exists" +
                        (found.getDeclaringClass().equals(s) ? "" : " in class " + found.getDeclaringClass().getName())));
        } catch (NotFoundException ignore) {
            // Throwing an exception is the expected behaviour. If not, *then* it is an error.
        }

        Log.debug(s.getName() + "." + currentName + "() => " + beanName + "()");
        CtMethod beanMethod = new CtMethod(m.getReturnType(), beanName, new CtClass[0], s);
        beanMethod.setBody("return " + currentName + "();");
        beanMethod.setAttribute(GETTER_ATTRIBUTE, BEAN_STYLE_ATTR);
        s.addMethod(beanMethod);
    }


}
