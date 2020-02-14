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
import javassist.NotFoundException;
import org.crossmobile.plugin.model.NObject;
import org.crossmobile.plugin.model.NParam;
import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.plugin.model.NType;
import org.crossmobile.plugin.model.StaticMappingType;
import org.crossmobile.plugin.reg.ObjectRegistry;
import org.crossmobile.plugin.robovm.models.methods.CConstructorRMethod;
import org.crossmobile.plugin.robovm.models.methods.ConstructorRMethod;
import org.crossmobile.plugin.robovm.models.methods.FunctionRMethod;
import org.crossmobile.plugin.robovm.models.methods.GlobalVariableRMethod;
import org.crossmobile.plugin.robovm.models.methods.InterfaceRMethod;
import org.crossmobile.plugin.robovm.models.methods.PropertyRMethod;
import org.crossmobile.plugin.robovm.models.methods.RMethod;
import org.crossmobile.plugin.robovm.models.methods.SelectorRMethod;
import org.crossmobile.plugin.robovm.models.methods.StaticSelectorRMethod;
import org.crossmobile.plugin.robovm.models.methods.StructMemberRMethod;
import org.crossmobile.plugin.robovm.models.parameters.RParam;
import org.crossmobile.utils.CollectionUtils;
import org.crossmobile.utils.CustomTypeClasses;
import org.crossmobile.utils.Log;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

import static org.crossmobile.plugin.robovm.ClassBuilder.wp;
import static org.crossmobile.plugin.robovm.ParamBuilder.createParam;
import static org.crossmobile.utils.NamingUtils.execSignature;

public class MethodBuilder {

    private static Class[] BLACKLIST = {CustomTypeClasses.Instance.class, CustomTypeClasses.VoidRef.class};
    private final NObject object;
    private final NSelector selector;
    private final CtClass cclass;
    Function<Collection<RParam>, Collection<NParam>> nparams = rparams -> CollectionUtils.asList(rparams, RParam::getnParam);
    private RParam returnParam;
    private List<RParam> parameters = new ArrayList<>();
    private RMethod method = null;
    private boolean mappingBuilt = false;

    MethodBuilder(NSelector selector, NObject object, CtClass cclass) throws ClassNotFoundException, CannotCompileException, NotFoundException, IOException {
        this.object = object;
        this.selector = selector;
        this.cclass = cclass;
        parseParameters();
        if (returnParam != null && !parameters.contains(null)) {
            generateMissing(returnParam.getType());
            generateMissing(nparams.apply(parameters));
            buildNative(selector, returnParam, parameters);
        }
    }

    private void parseParameters() {
        Parameter[] params = selector.getJavaExecutable().getParameters();
        List<NParam> selParams = selector.getParams();

        returnParam = createParam(null, selector.getReturnType(), selector.isConstructor() ? null : ((Method) selector.getJavaExecutable()).getReturnType(), selector);

        int paramIndex = 0;
        int nparamIndex = 0;

        try {
            List<Runnable> postProccessing = new ArrayList<>();
            while (paramIndex < params.length || nparamIndex < selParams.size()) {
                if (selParams.get(nparamIndex).getStaticMapping().equals(StaticMappingType.NATIVE)) {
                    parameters.add(
                            createParam(selParams.get(nparamIndex), selParams.get(nparamIndex).getNType(), null, selector));
                    nparamIndex++;
                    if (params.length == 0)
                        break;
                }
                if (selParams.get(nparamIndex).getAffiliation() != null) {
                    postProccessing.add(addPost(selParams.get(nparamIndex), selector, nparamIndex));
                    nparamIndex++;
                } else {
                    parameters.add(
                            createParam(selParams.get(nparamIndex), selParams.get(nparamIndex).getNType(), params[paramIndex].getType(), selector));
                    paramIndex++;
                    nparamIndex++;
                }
            }
            for (Runnable runnable : postProccessing) runnable.run();
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            Log.error("Oops, Something was not processed correctly \uD83D\uDE11 : " + e.toString());
        }
        if (paramIndex < params.length || nparamIndex < selParams.size())
            Log.error("Oops, Something was not processed at all \uD83D\uDE11 ");

    }

    private void buildNative(NSelector selector, RParam returnParam, List<RParam> parameters) {
        if (selector.isConstructor() && object.isStruct()) {
            method = new CConstructorRMethod(selector, returnParam, parameters, object, cclass);
        } else if (selector.isConstructor() && object.isObjCBased()) {
            method = new ConstructorRMethod(selector, returnParam, parameters, object, cclass);
        } else if (selector.isConstructor()) {
            Log.warning("Please provide more information about constructor " + execSignature(selector.getJavaExecutable()));
            return;
        } else if (object.isProtocol() || object.isTarget()) {
            method = new InterfaceRMethod(selector, returnParam, parameters, object, cclass);
        } else if (object.isObjCBased() && (selector.isGetter() || selector.isSetter())) {
            method = new PropertyRMethod(selector, returnParam, parameters, object, cclass);
        } else if (object.isObjCBased() && selector.isStatic() && !Modifier.isStatic(selector.getJavaExecutable().getModifiers())) {
            method = new FunctionRMethod(selector, returnParam, parameters, object, cclass);
        } else if (object.isObjCBased() && selector.isStatic()) {
            method = new StaticSelectorRMethod(selector, returnParam, parameters, object, cclass);
        } else if (object.isObjCBased()) {
            method = new SelectorRMethod(selector, returnParam, parameters, object, cclass);
        } else if (object.isCBased() && (selector.isGetter() || selector.isSetter())) {
            method = new StructMemberRMethod(selector, returnParam, parameters, object, cclass);
        } else if (object.isCBased() && selector.getMethodType().isExternal()) {
            method = new GlobalVariableRMethod(selector, returnParam, parameters, object, cclass);
        } else if (object.isCBased()) {
            method = new FunctionRMethod(selector, returnParam, parameters, object, cclass);
        } else {
            Log.error("Unknown handling of " + execSignature(selector.getJavaExecutable()) + " of object family : " + object.getFamily());
            return;
        }
        try {
            method.buildNative();
        } catch (Exception e) {
            Log.error("could not make \"" + method.getSelector().getObjCSignature() + "\" . cause : " + e.getMessage());
        }
    }

    public void buildNativeMapping() throws CannotCompileException {
        try {
            if (!mappingBuilt && method != null && method.needsMapping())
                method.buildNativeMapping();
        } catch (Exception e) {
            Log.error("Cannot Compile : " + e.getMessage());
        }
        mappingBuilt = true;
    }

    private Runnable addPost(NParam param, NSelector selector, int index) {
        return () ->
                parameters.add(index,
                        createParam(param, param.getNType(),
                                getAffiliated(param).getJava(),
                                selector));
    }

    private RParam getAffiliated(NParam npram) {
        for (RParam parameter : parameters)
            if (parameter.getnParam().equals(npram.getAffiliation().getParameter()))
                return parameter;
        return null;
    }

    private void generateMissing(NType type) throws ClassNotFoundException, CannotCompileException, NotFoundException, IOException {
        if (!isBlacklisted(type) && !type.isPrimitive() && !wp.contains(type.getType().getName()))
            ClassBuilder.getClass(ObjectRegistry.retrieve(type.getType())).finaliseClass();
    }

    private boolean isBlacklisted(NType returnType) {
        for (Class aClass : BLACKLIST)
            if (returnType.getType().equals(aClass))
                return true;
        return false;
    }

    private void generateMissing(Collection<NParam> params) throws ClassNotFoundException, CannotCompileException, NotFoundException, IOException {
        for (NParam param : params) generateMissing(param.getNType());
    }
}
