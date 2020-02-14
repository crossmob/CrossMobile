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
import javassist.Modifier;
import javassist.NotFoundException;
import org.crossmobile.plugin.model.NObject;
import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.plugin.reg.ObjectRegistry;
import org.crossmobile.plugin.utils.WaterPark;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClassBuilder {

    private static final Map<NObject, ClassBuilder> objects = new HashMap<>();
    static File filedest;
    public static WaterPark wp;
    protected final Class target;
    protected final NObject obj;
    private CtClass cclass;

    ClassBuilder(NObject obj) throws ClassNotFoundException, CannotCompileException, NotFoundException, IOException {
        target = obj.getType();
        this.obj = obj;
    }

    public static void initialise(WaterPark waterPark, File file) throws CannotCompileException, NotFoundException, IOException, ClassNotFoundException {
        filedest = file;
        wp = waterPark;
        ObjectBuilder.initialise();
        NObject nsobject = ObjectRegistry.retrieve(ObjectRegistry.getNSObject());
        NObject cftype = ObjectRegistry.retrieve(ObjectRegistry.getCFType());
        objects.put(cftype, new CFTypeBuilder());
        objects.put(nsobject, new NSObjectBuilder());
    }

    public static ClassBuilder getClass(NObject obj) throws IOException, CannotCompileException, NotFoundException, ClassNotFoundException {
        if (!objects.containsKey(obj))
            objects.put(obj, getBuilder(obj));
        return objects.get(obj);
    }

    private static ClassBuilder getBuilder(NObject obj) throws NotFoundException, CannotCompileException, IOException, ClassNotFoundException {
        if (obj.getType().isInterface())
            return new InterfaceBuilder(obj);
        if (obj.isStruct())
            return new StructBuilder(obj);
        if (obj.isObjCBased())
            return new ObjcObjectBuilder(obj);
        if (obj.isCBased())
            return new CObjectBuilder(obj);
        return null;
    }

    public static void write() throws CannotCompileException, IOException {
        for (ClassBuilder value : objects.values()) value.getCclass().writeFile(filedest.getAbsolutePath());

    }
    private final Map<String, MethodBuilder> methodBuilders = new HashMap<>();

    public void finaliseClass() throws CannotCompileException, IOException, NotFoundException, ClassNotFoundException {
        for (NSelector selector : obj.getSelectors())
            if (!methodBuilders.keySet().contains(selector.getName()))
                methodBuilders.put(selector.getName(), new MethodBuilder(selector, obj, cclass));
        for (MethodBuilder methodBuilder : methodBuilders.values()) methodBuilder.buildNativeMapping();
        if (!cclass.isInterface())
            cclass.setModifiers(cclass.getModifiers() & ~Modifier.ABSTRACT);
    }

    public CtClass getCclass() {
        if (cclass == null)
            throw new RuntimeException("Class type creation for " + obj.getType() + "has not be created");
        return cclass;
    }

    public void setCclass(CtClass cclass) {
        this.cclass = cclass;
    }
}
