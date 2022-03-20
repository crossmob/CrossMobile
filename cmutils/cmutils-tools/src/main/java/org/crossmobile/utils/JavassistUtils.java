/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import javassist.*;
import javassist.bytecode.*;
import javassist.bytecode.annotation.Annotation;
import org.crossmobile.bridge.system.BaseUtils;

import java.io.File;
import java.util.Collection;
import java.util.function.Function;

public class JavassistUtils {

    private static Annotation constructAnnotation(ConstPool cp, String annotationName, JavassistAnnParam... params) {
        Annotation ann = new Annotation(annotationName, cp);
        for (JavassistAnnParam p : params)
            if (p != null)
                ann.addMemberValue(p.getName(), p.getValue(cp));
        return ann;
    }

    private static AttributeInfo constructAttribute(AttributeInfo info, ConstPool cp, String annotationName, JavassistAnnParam... params) {
        if (info == null)
            info = new AnnotationsAttribute(cp, AnnotationsAttribute.visibleTag);
        ((AnnotationsAttribute) info).addAnnotation(constructAnnotation(cp, annotationName, params));
        return info;
    }

    private static AttributeInfo constructAttribute(AttributeInfo info, ConstPool cp, int fields, int fieldIdx, String annotationName, JavassistAnnParam... params) {
        ParameterAnnotationsAttribute attribute = (ParameterAnnotationsAttribute) info;
        if (attribute == null)
            attribute = new ParameterAnnotationsAttribute(cp, ParameterAnnotationsAttribute.visibleTag);

        Annotation[][] annotations = attribute.getAnnotations();
        if (annotations == null || annotations.length == 0)
            annotations = new Annotation[fields][];
        for (int i = 0; i < annotations.length; i++)
            if (annotations[i] == null)
                annotations[i] = new Annotation[0];

        Annotation[] oldA = annotations[fieldIdx];
        annotations[fieldIdx] = new Annotation[oldA.length + 1];
        System.arraycopy(oldA, 0, annotations[fieldIdx], 0, oldA.length);
        annotations[fieldIdx][oldA.length] = constructAnnotation(cp, annotationName, params);

        attribute.setAnnotations(annotations);
        return attribute;
    }

    public static void addAnnotation(CtBehavior behavior, String annotationName, JavassistAnnParam... params) {
        MethodInfo methodInfo = behavior.getMethodInfo();
        methodInfo.addAttribute(constructAttribute(methodInfo.getAttribute(AnnotationsAttribute.visibleTag), methodInfo.getConstPool(), annotationName, params));
    }


    public static void addAnnotation(CtBehavior behavior, int paramIdx, String annotationName, JavassistAnnParam... params) {
        int paramCount;
        try {
            paramCount = behavior.getParameterTypes().length;
            if (paramIdx >= paramCount)
                throw new IndexOutOfBoundsException("Method " + behavior.getName() + " has " + paramCount + " parameters, requested parameter #" + paramIdx);
        } catch (NotFoundException e) {
            Log.error(e);
            return;
        }
        MethodInfo methodInfo = behavior.getMethodInfo();
        methodInfo.addAttribute(constructAttribute(methodInfo.getAttribute(ParameterAnnotationsAttribute.visibleTag),
                methodInfo.getConstPool(), paramCount, paramIdx, annotationName, params));
    }

    public static void addAnnotation(CtClass cls, String annotationName, JavassistAnnParam... params) {
        ClassFile classFile = cls.getClassFile();
        classFile.addAttribute(constructAttribute(classFile.getAttribute(AnnotationsAttribute.visibleTag),
                classFile.getConstPool(), annotationName, params));
    }

    public static Annotation createAnnotation(CtClass cls, String annotationName, JavassistAnnParam... params) {
        return constructAnnotation(cls.getClassFile().getConstPool(), annotationName, params);
    }

    public static ClassPool getClassPool(Iterable<File> jarfiles) {
        ClassPool cp = ClassPool.getDefault();
        if (jarfiles != null)
            for (File file : jarfiles)
                try {
                    cp.appendPathList(file.getAbsolutePath());
                } catch (NotFoundException ex) {
                }
        return cp;
    }

    public static <NTYPE> CtConstructor makeConstructor(Collection<NTYPE> params, Function<NTYPE, String> nameConv, CtClass cclass) {
        CtClass[] cParams = CollectionUtils.asList(params, p -> getClass(p, nameConv, cclass)).toArray(new CtClass[]{});
        return new CtConstructor(cParams, cclass);
    }

    public static <NTYPE> CtMethod makeMethod(String name, NTYPE returnType, Collection<NTYPE> params, Function<NTYPE, String> paramConv, Function<NTYPE, String> returnConv, CtClass cclass) {
        CtClass[] cParams = CollectionUtils.asList(params, p -> getClass(p, paramConv, cclass)).toArray(new CtClass[]{});
        return new CtMethod(getClass(returnType, returnConv, cclass), name, cParams, cclass);
    }

    private static <NTYPE> CtClass getClass(NTYPE type, Function<NTYPE, String> nameConv, CtClass cclass) {
        try {
            return cclass.getClassPool().get(nameConv.apply(type));
        } catch (NotFoundException e) {
            BaseUtils.throwException(e);
            return null;
        }
    }
}
