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
package org.crossmobile.plugin.actions;

import javassist.*;
import javassist.bytecode.*;
import javassist.bytecode.SignatureAttribute.ClassSignature;
import javassist.bytecode.SignatureAttribute.TypeParameter;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.ClassMemberValue;
import javassist.bytecode.annotation.MemberValue;
import javassist.bytecode.annotation.StringMemberValue;
import org.crossmobile.bridge.ann.CMParamMod;
import org.crossmobile.bridge.ann.CMReference;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;
import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.plugin.reg.ObjectRegistry;
import org.crossmobile.utils.Log;
import org.robovm.objc.annotation.UIAppearanceSelector;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

import static org.crossmobile.plugin.actions.AppearanceInjections.AnnMetaData.asClass;
import static org.crossmobile.plugin.actions.AppearanceInjections.AnnMetaData.asString;
import static org.crossmobile.utils.TextUtils.plural;

public class AppearanceInjections {
    private static final String RESULT_ANCHOR = "RESULT_TYPE";
    private static final String SOURCE_ANCHOR = "SOURCE_TYPE";


    private static final String CLASS_SUFFIX = "Appearance";
    private static final String APPEARANCE_NATIVE = "+ (instancetype)appearance;";
    private static final String APPEARANCE_CONTAINED_NATIVE = "+ (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;";
    private static final String APPEARANCE_CONTAINED_SIGNATURE = "(Ljava/util/List<Ljava/lang/Class<+Lcrossmobile/ios/uikit/UIAppearanceContainer;>;>;)L" + RESULT_ANCHOR + ";";
    private static final String APPEARANCE_CODE = "return (" + RESULT_ANCHOR + ")org.crossmobile.bind.graphics.AppearanceRegistry.requestAppearance(" + SOURCE_ANCHOR + ".class, " + RESULT_ANCHOR + ".class);";
    private static final String APPEARANCE_CONTAINED_CODE = "return (" + RESULT_ANCHOR + ")org.crossmobile.bind.graphics.AppearanceRegistry.requestAppearance(" + SOURCE_ANCHOR + ".class, $1, " + RESULT_ANCHOR + ".class);";


    private CtClass NSObjectCt;
    private CtClass UIAppearanceCt;
    private CtClass ListCt;

    private final ClassPool cp;

    public AppearanceInjections(ClassPool cp) {
        this.cp = cp;
        try {
            this.NSObjectCt = cp.get(ObjectRegistry.NSObjectClassName);
            this.UIAppearanceCt = cp.get(ObjectRegistry.UIAppearanceClassName);
            this.ListCt = cp.get(List.class.getName());
            this.ListCt.setGenericSignature(new ClassSignature(new TypeParameter[]{new TypeParameter("T")}).encode());
        } catch (NotFoundException ignored) {
        }
    }

    public void cleanup(File cp) {
        AtomicInteger howMany = new AtomicInteger();
        cleanupImpl(cp, howMany);
        Log.info("Removing " + howMany.get() + " file" + plural(howMany.get()));
    }

    public void cleanupImpl(File cp, AtomicInteger howMany) {
        String suffix = CLASS_SUFFIX + ".class";
        if (cp.isDirectory()) {
            File[] children = cp.listFiles();
            if (children != null && children.length > 0)
                for (File child : children)
                    cleanupImpl(child, howMany);
        } else {
            if (cp.getName().endsWith(suffix)) {
                File other = new File(cp.getParentFile(), cp.getName().substring(0, cp.getName().length() - suffix.length()) + ".class");
                if (other.exists()) {
//                    if (FileUtils.getLastModified(cp) < FileUtils.getLastModified(other))
                    howMany.incrementAndGet();
                    if (!cp.delete())
                        Log.error("Requested to delete file " + cp.getAbsolutePath() + " but unable to do so.");
                    else {
                        Log.debug("Deleting file " + cp.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void makeAppearance(Class<?> cls, String rootClassPath) {
        try {
            String className = cls.getName() + CLASS_SUFFIX;
            String jclassName = className.replace('.', '/');
            try {
                cp.get(className); // already exists
                return;
            } catch (NotFoundException ignored) { // Needs creation
            }
            CtClass baseC = cp.get(cls.getName());
            CtClass appearanceC = cp.makeClass(className, NSObjectCt);
            appearanceC.setInterfaces(new CtClass[]{UIAppearanceCt});

            CtConstructor constructor = CtNewConstructor.defaultConstructor(appearanceC);
            constructor.setModifiers(Modifier.setPrivate(constructor.getModifiers()));
            appearanceC.addConstructor(constructor);

            appearanceC.getClassFile().addAttribute(getAttribute(CMReference.class, appearanceC, asClass("proxyOf", baseC)));
            for (CtMethod fromM : baseC.getMethods())
                if (fromM.hasAnnotation(UIAppearanceSelector.class)) {
                    CtMethod toM = CtNewMethod.make(fromM.getReturnType(), fromM.getName(), fromM.getParameterTypes(), null, null, appearanceC);
                    appearanceC.addMethod(toM);
                    addCode(CMSelector.class, fromM, toM);
                    addCode(CMSetter.class, fromM, toM);
                }
            appearanceC.writeFile(rootClassPath);
            appearanceC.defrost();

            CtMethod appMethodPlain = CtNewMethod.make(appearanceC, "appearance", new CtClass[0], null, null, baseC);
            appMethodPlain.setModifiers(appMethodPlain.getModifiers() | Modifier.STATIC);
            appMethodPlain.getMethodInfo().addAttribute(getAttribute(CMSelector.class, baseC, asString("value", APPEARANCE_NATIVE)));
            appMethodPlain.setBody(APPEARANCE_CODE.replaceAll(RESULT_ANCHOR, className).replaceAll(SOURCE_ANCHOR, cls.getName()));
            baseC.addMethod(appMethodPlain);

            CtMethod appMethodHierarchy = CtNewMethod.make(appearanceC, "appearanceWhenContainedInInstancesOfClasses", new CtClass[]{ListCt}, null, null, baseC);
            appMethodHierarchy.setModifiers(appMethodHierarchy.getModifiers() | Modifier.STATIC);
            appMethodHierarchy.getMethodInfo().addAttribute(getAttribute(CMSelector.class, baseC, asString("value", APPEARANCE_CONTAINED_NATIVE)));
            setParamAttr(0, CMParamMod.class, appMethodHierarchy, asString("convertWith", "jclass_to_class_list"));
            appMethodHierarchy.getMethodInfo().addAttribute(new SignatureAttribute(appMethodHierarchy.getMethodInfo().getConstPool(), APPEARANCE_CONTAINED_SIGNATURE.replace(RESULT_ANCHOR, jclassName)));
            appMethodHierarchy.setBody(APPEARANCE_CONTAINED_CODE.replaceAll(RESULT_ANCHOR, className).replaceAll(SOURCE_ANCHOR, cls.getName()));
            baseC.addMethod(appMethodHierarchy);

            baseC.writeFile(rootClassPath);
            baseC.defrost();
        } catch (Exception err) {
            Log.error(err);
        }
    }

    private <T extends java.lang.annotation.Annotation> boolean addCode(Class<T> annotationClass, CtMethod srcMethod, CtMethod destMethod) {
        if (srcMethod.hasAnnotation(annotationClass)) {
            try {
                Object annotation = srcMethod.getAnnotation(annotationClass);
                if (annotation != null) {
                    String value = (String) annotationClass.getMethod("value").invoke(annotation);
                    destMethod.getMethodInfo().addAttribute(getAttribute(annotationClass, destMethod.getDeclaringClass(), asString("value", value)));
                    return true;
                }
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException ignored) {
            }
        }
        return false;
    }

    private AttributeInfo getAttribute(Class<? extends java.lang.annotation.Annotation> annotationClass, CtClass container, AnnMetaData... metaData) {
        ClassFile classFile = container.getClassFile();
        ConstPool constpool = classFile.getConstPool();
        AnnotationsAttribute attr = new AnnotationsAttribute(constpool, AnnotationsAttribute.visibleTag);
        attr.addAnnotation(getAnnotation(annotationClass, constpool, metaData));
        return attr;
    }

    private void setParamAttr(int idx, Class<? extends java.lang.annotation.Annotation> annotationClass, CtMethod method, AnnMetaData... metaData) {
        ConstPool cp = method.getMethodInfo().getConstPool();
        ParameterAnnotationsAttribute paramAttribute = (ParameterAnnotationsAttribute) method.getMethodInfo().getAttribute(ParameterAnnotationsAttribute.visibleTag); // or inVisibleTag
        if (paramAttribute == null)
            paramAttribute = new ParameterAnnotationsAttribute(cp, ParameterAnnotationsAttribute.visibleTag);

        Annotation annotation = getAnnotation(annotationClass, cp, metaData);

        Annotation[][] paramsAnn = paramAttribute.getAnnotations();
        try {
            if (paramsAnn == null || paramsAnn.length != method.getParameterTypes().length)
                paramsAnn = new Annotation[method.getParameterTypes().length][];
        } catch (NotFoundException ex) {
            BaseUtils.throwException(ex);
            return;
        }

        // gather and shift old annotations
        Annotation[] oldParamAnn = paramsAnn[idx];
        Annotation[] newParamAnn = oldParamAnn == null || oldParamAnn.length == 0
                ? new Annotation[1]
                : Arrays.copyOf(oldParamAnn, oldParamAnn.length + 1);
        newParamAnn[oldParamAnn == null ? 0 : oldParamAnn.length] = annotation;

        paramsAnn[idx] = newParamAnn;
        paramAttribute.setAnnotations(paramsAnn);
        method.getMethodInfo().addAttribute(paramAttribute);
    }

    private Annotation getAnnotation(Class<?> annotationClass, ConstPool constpool, AnnMetaData... metaData) {
        Annotation annotation = new Annotation(annotationClass.getName(), constpool);
        for (AnnMetaData meta : metaData)
            annotation.addMemberValue(meta.name, meta.valueConstructor.apply(constpool));
        return annotation;
    }

    static class AnnMetaData {
        final String name;
        final Function<ConstPool, ? extends MemberValue> valueConstructor;

        private AnnMetaData(String name, Function<ConstPool, ? extends MemberValue> valueConstructor) {
            this.name = name;
            this.valueConstructor = valueConstructor;
        }

        public static AnnMetaData asClass(String name, CtClass classType) {
            return new AnnMetaData(name, cp -> new ClassMemberValue(classType.getName(), cp));
        }

        public static AnnMetaData asString(String name, String value) {
            return new AnnMetaData(name, cp -> new StringMemberValue(value, cp));
        }
    }
}
