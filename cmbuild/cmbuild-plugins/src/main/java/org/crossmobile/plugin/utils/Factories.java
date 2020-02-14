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

import org.crossmobile.bridge.ann.CMJoinMEM;
import org.crossmobile.bridge.ann.CMJoinSEL;
import org.crossmobile.plugin.model.*;
import org.crossmobile.plugin.parser.BlockListener;
import org.crossmobile.plugin.parser.antlr.CMAnnotParser;
import org.crossmobile.plugin.parser.antlr.CMAnnotParser.VartypeContext;
import org.crossmobile.plugin.reg.TypeUnknown;
import org.crossmobile.utils.Log;
import org.crossmobile.utils.TextUtils;

import java.lang.reflect.Executable;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.crossmobile.plugin.parser.AnnotationParser.getText;
import static org.crossmobile.plugin.reg.TypeRegistry.blockType;
import static org.crossmobile.plugin.reg.TypeRegistry.getJavaClass;
import static org.crossmobile.plugin.utils.Texters.annName;
import static org.crossmobile.utils.NamingUtils.execSignature;

public class Factories {

    public static NType getType(CMAnnotParser.VartypeContext vartype) {
        return getType(vartype, null, false);
    }

    public static NType getType(CMAnnotParser.VartypeContext vartype, VarargType vararg, boolean array) {
        int stars = (vartype.s1 != null ? 1 : 0) + (vartype.s2 != null ? 1 : 0);
        if (vartype.type != null) {
            String typeid = vartype.type.getText();
            AtomicInteger references = new AtomicInteger();
            NType nt = new NType(getText(vartype), getJavaClass(typeid, stars, vararg != null, array, references));
            nt.setVarArgType(vararg);
            nt.setReferences(references.get());
            nt.setConstant(vartype.constant != null);
            for (VartypeContext genericType : vartype.vartype())
                nt.addGenericType(getType(genericType));
            if (stars > 1) {
                NType gt = new NType(getText(vartype), getJavaClass(typeid, stars - 1, false, false, null));
                nt.addGenericType(gt);
            }
            return nt;
        } else if (vartype.block() != null) {
            CMAnnotParser.BlockContext block = vartype.block();
            int paramSize = block.simple_vartype_name().size() - 1;
            if (paramSize > 0 && block.simple_vartype_name().get(1).simple_vartype().getText().equals("void"))
                paramSize--;
            NType nt = new NType(getText(block), blockType(paramSize, block.simple_vartype_name(0).simple_vartype().getText().equals("void")));
            NSelector sel = new NSelector();
            BlockListener.parse(sel, vartype.block(), nt);
            nt.setBlock(sel);
            nt.setConstant(block.constant != null);
            return nt;
        } else if (vartype.protocol != null) {
            String typeid = vartype.protocol.getText();
            AtomicInteger references = new AtomicInteger();
            NType nt = new NType(getText(vartype), getJavaClass(typeid, stars, vararg != null, array, references));
            nt.setConstant(vartype.constant != null);
            nt.setVarArgType(vararg);
            nt.setReferences(references.get());
            return nt;
        } else
            return new NType(getText(vartype), TypeUnknown.class);
    }

    public static NType getType(CMAnnotParser.Simple_vartypeContext ctx) {
        AtomicInteger references = new AtomicInteger();
        NType type = new NType(ctx.getText(), getJavaClass(ctx.ID().getText(), ctx.s1 == null ? 0 : 1, false, false, references));
        type.setReferences(references.get());
        return type;
    }

    public static NParam getParam(CMAnnotParser.SelectorParamContext ctx, VarargType vararg, boolean array) {
        NParam param = new NParam();
        param.setVarname(ctx.variablename.getText());
        param.setNType(Factories.getType(ctx.vartype(), vararg, array));
        return param;
    }

    public static NParam getParam(CMAnnotParser.Simple_vartype_nameContext ctx) {
        NParam p = new NParam();
        p.setNType(getType(ctx.simple_vartype()));
        p.setVarname(ctx.name == null ? "" : ctx.name.getText());
        return p;
    }

    public static NSelector getSetterSelector(NProperty property) {
        NSelector sel = new NSelector();
        sel.setName("set" + TextUtils.capitalize(property.getName()));
        sel.setProperty(property);
        sel.setOriginalCode(property.getOriginalCode());

        NType retType = new NType("void", void.class);
        sel.setReturnType(retType);

        NType argType = new NType(property.getType().getNativeType(), property.getType().getType());
        NParam param = new NParam();
        param.setVarname(property.getName());
        param.setNType(argType);
        sel.addParam(param);

        return sel;
    }

    public static NSelector getGetterSelector(NProperty property) {
        NSelector sel = new NSelector();
        sel.setName(property.getGetter());
        sel.setProperty(property);
        sel.setOriginalCode(property.getOriginalCode());
        sel.setReturnType(property.getType());
        return sel;
    }

    public static NType getDereferType(NType type) {
        if (type.getNativeType().endsWith("*") && type.getType().isArray()) {
            NType result = new NType(type.getNativeType().substring(0, type.getNativeType().length() - 1), type.getType().getComponentType());
            result.setReferences(type.countReferences() - 1);
            return result;
        } else
            return type;
    }


    public static NSelector joinParams(NSelector selector, Executable exec) {
        Parameter[] params = exec.getParameters();
        List<NParam> selParams = selector.getParams();
        for (int i = 0; i < params.length; i++) {
            Parameter p = params[i];
            CMJoinMEM memAnn = p.getAnnotation(CMJoinMEM.class);
            CMJoinSEL selAnn = p.getAnnotation(CMJoinSEL.class);
            if (memAnn != null && selAnn != null)
                Log.error("Parameter at position #" + (i + 1) + " in " + selector.getFamily() + " `" + execSignature(exec) + "` should contain only one of annotations " + annName(CMJoinSEL.class) + " or " + annName(CMJoinMEM.class) + " ; native code provided: " + selector.getOriginalCode());
            if (selAnn != null) {
                if (joinParamsOnMeta(selAnn.target(), selAnn.selector(), selParams, selector, exec, NParamAffiliation.Type.SELECTOR) == null)
                    return null;
            } else if (memAnn != null) {
                if (!p.getType().isArray() && !p.getType().equals(String.class)) {
                    Log.error("Joined parameter at position #" + (i + 1) + " in " + selector.getFamily() + " `" + execSignature(exec) + "` should be an array or a String, to simulate memory block.");
                    return null;
                }
                NParam metaP = joinParamsOnMeta(memAnn.memory(), memAnn.size(), selParams, selector, exec, NParamAffiliation.Type.MEMBLOCK);
                if (metaP == null)
                    return null;
                if (!metaP.getNType().getType().equals(int.class)) {
                    Log.error("Joined parameter at position #" + (i + 1) + " in " + selector.getFamily() + " `" + execSignature(exec) + "` should correspond to a mempry block size of type int; native code provided: " + selector.getOriginalCode());
                    return null;
                }
            }
        }
        return selector;
    }

    private static NParam joinParamsOnMeta(String base, String meta, List<NParam> selParams, NSelector selector, Executable exec, NParamAffiliation.Type type) {
        NParam metaP = Collectors.findParamNamed(selParams, meta.trim(), selector.getFamily() + " `" + execSignature(exec) + "` ; native code provided: " + selector.getOriginalCode());
        NParam baseP = Collectors.findParamNamed(selParams, base.trim(), selector.getFamily() + " `" + execSignature(exec) + "` ; native code provided: " + selector.getOriginalCode());
        if (metaP == null || baseP == null)
            return null;
        metaP.affiliateTo(baseP, type);
        return metaP;
    }

}
