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
package org.crossmobile.plugin.robovm.models.methods;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtNewConstructor;
import javassist.Modifier;
import org.crossmobile.plugin.model.NObject;
import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.plugin.robovm.models.parameters.RParam;

import java.util.List;

public class CConstructorRMethod extends RMethod {
    public CConstructorRMethod(NSelector selector, RParam returnParam, List<RParam> parameters, NObject object, CtClass cclass) {
        super(selector, returnParam, parameters, object, cclass);
    }

    @Override
    public boolean needsReturn() {
        return false;
    }

    @Override
    protected void makeNativeMethod() {
    }

    @Override
    public boolean needsMapping() {
        return true;
    }

    @Override
    protected String mapSignature() {
        return super.mapSignature();
    }

    @Override
    protected String nativeCall() {
        return "";
    }

    @Override
    protected String javaSignature() {
        return getCclass().getSimpleName();
    }

    @Override
    protected String mapReturn() {
        return "";
    }

    public void buildNativeMapping() throws CannotCompileException {
        mapping = CtNewConstructor.make(mapMethod(), getCclass());
        setMappingModifiers();
        annotateParams(mapping, getParameters(), true);
        addMappingAnnotation();
        getCclass().addConstructor((CtConstructor) mapping);
    }

    protected void setMappingModifiers() {
        mapping.setModifiers(Modifier.PUBLIC);
    }
}
