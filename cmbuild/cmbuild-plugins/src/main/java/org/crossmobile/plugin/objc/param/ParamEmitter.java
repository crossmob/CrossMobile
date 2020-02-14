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
package org.crossmobile.plugin.objc.param;

import crossmobile.rt.StrongReference;
import org.crossmobile.plugin.model.*;
import org.crossmobile.plugin.objc.ReverseImportRegistry;
import org.crossmobile.plugin.utils.Texters;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;

import static org.crossmobile.plugin.reg.TypeRegistry.*;
import static org.crossmobile.utils.NamingUtils.getClassNameFull;

public class ParamEmitter {

    private final Collection<Emitter> emitters = new ArrayList<>();
    private final boolean staticObject;
    private final ResultEmitter result;
    private final String name;
    private String instanceName;

    public static ParamEmitter forward(NSelector sel, String instancename) {
        return new ParamEmitter(sel, null, true, instancename);
    }

    public static ParamEmitter reverse(NSelector sel, ReverseImportRegistry handleRegistry, String instancename) {
        return new ParamEmitter(sel, handleRegistry, false, instancename == null ? "self" : instancename);
    }

    private ParamEmitter(NSelector sel, ReverseImportRegistry handleRegistry, boolean forward, String instanceName) {
        this.instanceName = instanceName;
        this.staticObject = forward ? sel.isStatic() : Modifier.isStatic(sel.getJavaExecutable().getModifiers());
        this.name = forward ? sel.getName() : Texters.methodObjCName(sel.getJavaExecutable());
        for (NParam param : sel.getParams())
            addEmitter(parseParam(param, sel, handleRegistry, forward));
        this.result = new ResultEmitter(sel, forward);
    }

    private Emitter parseParam(NParam param, NSelector sel, ReverseImportRegistry handleRegistry, boolean forward) {
        NType type = param.getNType();
        if (param.getAffiliation() != null)
            if (param.getAffiliation().getType().equals(NParamAffiliation.Type.MEMBLOCK))
                return new EmitterMemSize(param, forward);
            else
                return new EmitterSelector(param, forward);
        else if (type.isPrimitive())
            return new EmitterPrimitive(param, forward);
        else if (isCBased(type.getType())) // C-types could be reference! so it should be considered before references check
            return new EmitterCType(param, false, forward);
        else if (type.getType().equals(char[].class) && param.getJavaParameter().getType().equals(String.class))
            return new EmitterStringToChar(param, forward);
        else if (type.getVarargType() != null)
            return new EmitterVarArgs(param, forward);
        else if (param.getJavaParameter().getType().isArray())
            return new EmitterArray(param, forward);
        else if (type.getBlock() != null || isBlockTarget(type.getType()))
            return new EmitterBlock(param, handleRegistry, forward);
        else if (param.getJavaParameter().getType().equals(StrongReference.class))
            return new EmitterStrongReference(param, forward);
        else if (isSelector(type.getType())) {
            EmitterSelector emitter = new EmitterSelector(param, forward);
            instanceName = emitter.getInstanceName();
            return emitter;
        } else if (param.getStaticMapping() != StaticMappingType.NONE) {
            EmitterStaticType emitter = new EmitterStaticType(param, forward);
            instanceName = emitter.getInstanceName();
            return emitter;
        } else if (isObjCBased(type.getType()) || isJavaWrapped(type.getType()))
            return new EmitterObject(param, sel, forward);
        else if (isStructReference(type.getType(), param.getJavaParameter().getType()))
            return new EmitterStructReference(param, forward);
        else {
            System.out.println("Unknown emitter for " + getClassNameFull(type.getType()) + " in selector `" + sel.getOriginalCode() + "` in class " + getClassNameFull(sel.getContainer().getType()));
            return new Emitter(param.getName(), type, false, forward) {
            };
        }
    }

    protected final void addEmitter(Emitter e) {
        emitters.add(e);
    }

    public final boolean isStatic() {
        return staticObject;
    }

    public String getName() {
        return name;
    }

    public Collection<Emitter> getNativeParameters() {
        return emitters;
    }

    public ResultEmitter getResultEmitter() {
        return result.copy();
    }

    public String getInstanceName() {
        return instanceName;
    }

}
