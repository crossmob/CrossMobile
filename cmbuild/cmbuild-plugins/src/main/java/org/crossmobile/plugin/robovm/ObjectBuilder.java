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
package org.crossmobile.plugin.robovm;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtMethod;
import javassist.CtNewConstructor;
import javassist.CtNewMethod;
import javassist.NotFoundException;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMReference;
import org.crossmobile.bridge.ann.CMStruct;
import org.crossmobile.plugin.model.NObject;
import org.crossmobile.plugin.reg.ObjectRegistry;
import org.crossmobile.plugin.reg.PluginRegistry;
import org.crossmobile.utils.Log;

import java.io.IOException;

import static org.crossmobile.plugin.bro.JavaTransformer.BYTE_PTR;
import static org.crossmobile.plugin.bro.JavaTransformer.CFT_OBJ;
import static org.crossmobile.plugin.bro.JavaTransformer.LIBRARY_ANN;
import static org.crossmobile.plugin.bro.JavaTransformer.MARSHLERS;
import static org.crossmobile.plugin.bro.JavaTransformer.NATIVECLASS_ANN;
import static org.crossmobile.plugin.bro.JavaTransformer.NSOBJ_OBJ;
import static org.crossmobile.plugin.bro.JavaTransformer.NSOBJ_OBJ_PROT;
import static org.crossmobile.plugin.bro.JavaTransformer.OBJC_CLS;
import static org.crossmobile.plugin.bro.JavaTransformer.OBJC_OBJ;
import static org.crossmobile.plugin.bro.JavaTransformer.OBJC_PROT;
import static org.crossmobile.plugin.bro.JavaTransformer.OBJC_RUNTIME;
import static org.crossmobile.plugin.bro.JavaTransformer.RT_BRO;
import static org.crossmobile.plugin.bro.JavaTransformer.RT_PTR;
import static org.crossmobile.plugin.bro.JavaTransformer.STRUCT;
import static org.crossmobile.utils.JavassistAnnParam.toParam;
import static org.crossmobile.utils.JavassistUtils.addAnnotation;

class ObjectBuilder extends ClassBuilder {

    static CtClass[] skipInitP;
    static CtClass[] handleP;

    ObjectBuilder(NObject obj) throws IOException, CannotCompileException, NotFoundException, ClassNotFoundException {
        super(obj);
        createClass();
        addPointer(getCclass(), filedest.getAbsolutePath());
        addAnnotations();
    }

    static void initialise() throws CannotCompileException, NotFoundException, IOException {
        CtClass strct = wp.classPool().makeClass(STRUCT);
        strct.addConstructor(CtNewConstructor.defaultConstructor(strct));
        strct.addMethod(CtNewMethod.make("public " + STRUCT + " next(long delta) {return null;}", strct));
        strct.addMethod(CtNewMethod.make("public static " + STRUCT + " allocate(java.lang.Class cls, int n) {return null;}", strct));

        CtClass ptr = wp.classPool().makeClass(RT_PTR, strct);
        ptr.addConstructor(CtNewConstructor.defaultConstructor(ptr));
        ptr.addMethod(CtNewMethod.make("public " + RT_PTR + " set(java.lang.Object o){return this;}", ptr));

        CtClass btptr = wp.classPool().makeClass(BYTE_PTR, strct);
        addPointer(btptr, null);

        wp.contains("java.lang.String");
        btptr.addMethod(CtNewMethod.make("public static " + BYTE_PTR + " toBytePtrAsciiZ(java.lang.String s) {return null;}", btptr));

        CtClass obj = wp.classPool().makeClass(OBJC_OBJ);
        obj.addConstructor(CtNewConstructor.defaultConstructor(obj));
        obj.addConstructor(new CtConstructor(new CtClass[]{CtClass.longType}, obj));
        obj.addMethod(CtMethod.make("protected void initObject(long handle) {}", obj));

        CtClass objcl = wp.classPool().makeClass(OBJC_CLS, obj);
        objcl.addMethod(CtNewMethod.make("public static " + OBJC_CLS + " getByType(java.lang.Class type) {return null;}", objcl));
        objcl.addMethod(CtNewMethod.make("public String getName() {return null;}", objcl));

        CtClass nsobj = wp.classPool().makeClass(NSOBJ_OBJ, obj);
        nsobj.addConstructor(CtNewConstructor.defaultConstructor(nsobj));
        nsobj.addConstructor(new CtConstructor(new CtClass[]{CtClass.longType}, nsobj));

        CtClass objProt = wp.classPool().makeInterface(OBJC_PROT);
        wp.classPool().makeInterface(NSOBJ_OBJ_PROT, objProt);
        {
            // Sanitize root objects
            skipInitP = new CtClass[]{wp.classPool().makeClass(NSOBJ_OBJ + "$SkipInit")};
            handleP = new CtClass[]{wp.classPool().makeClass(NSOBJ_OBJ + "$Handle"), CtClass.longType};

            CtConstructor skipInitC = new CtConstructor(skipInitP, nsobj);
            skipInitC.setBody(null);
            nsobj.addConstructor(skipInitC);

            CtConstructor handleC = new CtConstructor(handleP, nsobj);
            handleC.setBody("super($2);");
            nsobj.addConstructor(handleC);

        }

        for (String marshler : MARSHLERS) {
            CtClass mar = wp.classPool().makeClass(marshler);
            mar.addConstructor(CtNewConstructor.defaultConstructor(mar));
        }

        CtClass cft = wp.classPool().makeClass(CFT_OBJ);
        cft.addConstructor(CtNewConstructor.defaultConstructor(cft));

        CtClass objc_rt = wp.classPool().makeClass(OBJC_RUNTIME);
        objc_rt.addConstructor(CtNewConstructor.defaultConstructor(objc_rt));
        objc_rt.addMethod(CtNewMethod.make("public static void bind(Class c) {}", objc_rt));

        CtClass rt_bro = wp.classPool().makeClass(RT_BRO);
        rt_bro.addConstructor(CtNewConstructor.defaultConstructor(rt_bro));
        rt_bro.addMethod(CtNewMethod.make("public static void bind(Class c) {}", rt_bro));

    }

    private static void addPointer(CtClass cclass, String path) throws NotFoundException, CannotCompileException, IOException {
        CtClass nestedClass = cclass.makeNestedClass(cclass.getSimpleName() + "Ptr", true);
        nestedClass.setSuperclass(wp.classPool().getCtClass(RT_PTR));
        if (path != null)
            nestedClass.writeFile(path);
    }

    private void addAnnotations() {
        if (target.getAnnotation(CMClass.class) != null)
            addAnnotation(getCclass(), NATIVECLASS_ANN);

        if (target.getAnnotation(CMClass.class) != null ||
                target.getAnnotation(CMReference.class) != null ||
                target.getAnnotation(CMStruct.class) != null)
            addLibraryAnnotation(getCclass(), target);
    }

    void createClass() throws NotFoundException, CannotCompileException, IOException, ClassNotFoundException {
        Class superclass = target.getSuperclass();
        setCclass(superclass != null ?
                wp.classPool().makeClass(target.getName(), wp.contains(superclass.getName()) ?
                        wp.get(superclass.getName()) :
                        ClassBuilder.getClass(ObjectRegistry.retrieve(superclass)).getCclass())
                : wp.classPool().makeClass(target.getName()));
    }

    /**
     * Adds the library annotation to Classes
     *
     * @param cclass
     * @param target
     */
    private void addLibraryAnnotation(CtClass cclass, Class target) {
        String lib = PluginRegistry.getLibs(target.getName());
        if (lib.isEmpty())
            Log.error("Cant find library for class : " + target.getName());
        else lib = lib.substring(0, lib.indexOf('.'));
        addAnnotation(cclass, LIBRARY_ANN, toParam("value", lib));
    }

    @Override
    public void finaliseClass() throws CannotCompileException, IOException, NotFoundException, ClassNotFoundException {
        addEmptyConstructorIfNeeded(getCclass());
        super.finaliseClass();
    }

    private void addEmptyConstructorIfNeeded(CtClass cclass) throws CannotCompileException {
        if (cclass.getConstructors().length == 0)
            cclass.addConstructor(CtNewConstructor.defaultConstructor(cclass));
    }
}
