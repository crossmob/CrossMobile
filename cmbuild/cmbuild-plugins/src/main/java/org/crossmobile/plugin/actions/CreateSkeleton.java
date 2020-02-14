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
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.ParameterAnnotationsAttribute;
import javassist.bytecode.annotation.Annotation;
import org.crossmobile.bridge.ann.CMLibTarget;
import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.plugin.reg.PluginRegistry;
import org.crossmobile.plugin.reg.TargetRegistry;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import static org.crossmobile.plugin.actions.CreateBeanAPI.GETTER_ATTRIBUTE;

@SuppressWarnings("StaticNonFinalUsedInInitialization")
public class CreateSkeleton {

    private final ClassPool cp;

    public CreateSkeleton(ClassPool cp) {
        this.cp = cp;
    }

    private static void removeBody(CtBehavior method) {
        try {
            if (method.getParameterTypes().length > 0) {
                CodeAttribute cattr = method.getMethodInfo().getCodeAttribute();
                if (cattr != null) {
                    LocalVariableAttribute table = (LocalVariableAttribute) cattr.getAttribute(LocalVariableAttribute.tag);
                    if (table != null)
                        // I don't really know what to do here :'(
                        return;
                }
            }
            method.setBody(null);
        } catch (Exception ex) {
        }
    }

    public boolean stripClass(Class cls, Function<String, File> resolver, byte apiStyleMask) throws IOException {
        try {
            String name = cls.getName();
            CtClass s = cp.get(name);
            if (TargetRegistry.getTarget(s.getName()).compile && !shouldRetainBody(s)) {
                if (s.getClassInitializer() != null)
                    s.removeConstructor(s.getClassInitializer());
//                removeAttrs((AnnotationsAttribute) s.getClassFile().getAttribute(AnnotationsAttribute.visibleTag));

                for (CtConstructor c : s.getDeclaredConstructors())
                    if (!Modifier.isPublic(c.getModifiers()))
                        s.removeConstructor(c);
                    else
                        removeBody(c); //                        removeAttrs((AnnotationsAttribute) c.getMethodInfo().getAttribute(AnnotationsAttribute.visibleTag));
                //                        removeAttrs((ParameterAnnotationsAttribute) c.getMethodInfo2().getAttribute(ParameterAnnotationsAttribute.visibleTag));

                for (CtMethod m : s.getDeclaredMethods()) {
                    CtMethod pmeth = null;  // if parent method exists, we don't need to re-implement it
                    try {
                        pmeth = s.getSuperclass().getMethod(m.getName(), m.getSignature());
                    } catch (Exception e) {
                    }
                    if (!Modifier.isPublic(m.getModifiers()) || pmeth != null)
                        s.removeMethod(m);
                    else {
                        byte[] attr = m.getAttribute(GETTER_ATTRIBUTE);
                        if (attr != null && (attr[0] & apiStyleMask) == 0)
                            s.removeMethod(m);
                        else
                            removeBody(m); //                        removeAttrs((AnnotationsAttribute) m.getMethodInfo().getAttribute(AnnotationsAttribute.visibleTag));
                        //                        removeAttrs((ParameterAnnotationsAttribute) m.getMethodInfo2().getAttribute(ParameterAnnotationsAttribute.visibleTag));
                    }
                }

                for (CtField f : s.getDeclaredFields())
                    if (!Modifier.isPublic(f.getModifiers()))
                        s.removeField(f);
//                    else
//                        removeAttrs((AnnotationsAttribute) f.getFieldInfo().getAttribute(AnnotationsAttribute.visibleTag));
            }
            s.writeFile(resolver.apply(PluginRegistry.getPlugin(name)).getAbsolutePath());
            return true;
        } catch (IOException | NotFoundException | CannotCompileException ex) {
            BaseUtils.throwException(ex);
            return false;
        }
    }

    private static void removeAttrs(ParameterAnnotationsAttribute aa) {
        if (aa != null) {
            Annotation[][] annotations = aa.getAnnotations();
            for (int i = 0; i < annotations.length; i++) {
                Annotation[] par = annotations[i];
                List<Annotation> ann = new ArrayList<>(Arrays.asList(par));
                Iterator<Annotation> iterator = ann.iterator();
                while (iterator.hasNext()) {
                    Annotation cann = iterator.next();
                    CMLibTarget target = TargetRegistry.getTarget(cann.getTypeName(), true);
                    if (!target.compile)
                        iterator.remove();
                }
                annotations[i] = ann.toArray(new Annotation[ann.size()]);
            }
            aa.setAnnotations(annotations);
        }
    }

    private static void removeAttrs(AnnotationsAttribute aa) {
        if (aa != null) {
            List<Annotation> ann = new ArrayList<>(Arrays.asList(aa.getAnnotations()));
            Iterator<Annotation> iterator = ann.iterator();
            while (iterator.hasNext()) {
                Annotation cann = iterator.next();
                CMLibTarget target = TargetRegistry.getTarget(cann.getTypeName(), true);
                if (!target.compile)
                    iterator.remove();
            }
            aa.setAnnotations(ann.toArray(new Annotation[ann.size()]));
        }
    }
//    private static void removeBody(CtBehavior method) {
//
//        CodeAttribute cattr = method.getMethodInfo().getCodeAttribute();
//        Bytecode code;
//        try {
//            code = new Javac(method.getDeclaringClass()).compileBody(method, null);
//        } catch (CompileError ex) {
//            BaseUtils.throwException(ex);
//            return;
//        }
//        if (cattr != null) {
//            LocalVariableAttribute table = (LocalVariableAttribute) cattr.getAttribute(LocalVariableAttribute.tag);
//            if (table != null) {
//                cattr = new CodeAttribute(cattr.getConstPool(), cattr.getMaxStack(), cattr.getMaxLocals(), code.get(), new ExceptionTable(cattr.getConstPool()));
//                cattr.getAttributes().add(table);
//            } else
//                cattr = code.toCodeAttribute();
//        } else
//            cattr = code.toCodeAttribute();
//        method.getMethodInfo().setCodeAttribute(cattr);
//    }
//
//    private static void removeBody(CtBehavior method) {
//        try {
//            CodeAttribute cattr = method.getMethodInfo().getCodeAttribute();
//            if (cattr != null) {
//                LocalVariableAttribute table = (LocalVariableAttribute) cattr.getAttribute(LocalVariableAttribute.tag);
//                if (table != null) {
//                    Bytecode code = new Javac(method.getDeclaringClass()).compileBody(method, null);
//                    cattr = code.toCodeAttribute();
//                    cattr.getAttributes().add(table);
//                    method.getMethodInfo().setCodeAttribute(cattr);
//                    return;
//                }
//            }
//            method.setBody(null);
//        } catch (Exception ex) {
//            BaseUtils.throwException(ex);
//        }
//    }
//
//     private static void removeBody(CtBehavior method) {
//        Method setCode = null;
//        try {
//            setCode = CodeAttribute.class.getDeclaredMethod("setCode", byte[].class);
//            setCode.setAccessible(true);
//        } catch (Exception ex) {
//            Log.error(ex);
//        }
//        CodeAttribute oldAttr = method.getMethodInfo().getCodeAttribute();
//        if (oldAttr != null) {
//            try {
//                byte[] code = new Javac(method.getDeclaringClass()).compileBody(method, "throw new RuntimeException();").get();
//                setCode.invoke(oldAttr, new Object[]{code});
//                Iterator<AttributeInfo> it = oldAttr.getAttributes().iterator();
//                while (it.hasNext()) {
//                    AttributeInfo info = it.next();
//                    if (info instanceof LineNumberAttribute)
//                        it.remove();
//                }
//            } catch (Exception ex) {
//                Log.error(ex);
//            }
//            method.getMethodInfo().setCodeAttribute(oldAttr);
//        }
//    }

    private boolean shouldRetainBody(CtClass s) {
        if (s.isInterface())
            return true;
        try {
            if (s.getAnnotation(SupportedAnnotationTypes.class) != null)
                return true;
        } catch (ClassNotFoundException ex) {
        }
        return false;
    }
}
