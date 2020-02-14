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

import crossmobile.rt.StrongReference;
import org.crossmobile.bridge.ann.CMRef;
import org.crossmobile.plugin.model.NParam;
import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.plugin.model.NType;
import org.crossmobile.plugin.model.StaticMappingType;
import org.crossmobile.plugin.robovm.models.parameters.ArrayRParam;
import org.crossmobile.plugin.robovm.models.parameters.PrimArrayRParam;
import org.crossmobile.plugin.robovm.models.parameters.ClassRParam;
import org.crossmobile.plugin.robovm.models.parameters.IdRParam;
import org.crossmobile.plugin.robovm.models.parameters.InstanceRParam;
import org.crossmobile.plugin.robovm.models.parameters.LengthRParam;
import org.crossmobile.plugin.robovm.models.parameters.NativeRParam;
import org.crossmobile.plugin.robovm.models.parameters.PointerRParam;
import org.crossmobile.plugin.robovm.models.parameters.RParam;
import org.crossmobile.plugin.robovm.models.parameters.RefRParam;
import org.crossmobile.plugin.robovm.models.parameters.StaticRefRParam;
import org.crossmobile.plugin.robovm.models.parameters.StringArrayRParam;
import org.crossmobile.plugin.robovm.models.parameters.StringRParam;
import org.crossmobile.plugin.robovm.models.parameters.StrongRParam;
import org.crossmobile.plugin.robovm.models.parameters.StructRParam;
import org.crossmobile.utils.CustomTypeClasses;
import org.crossmobile.utils.Log;

import java.lang.reflect.Method;

public class ParamBuilder {

    public static RParam createParam(NParam nParam, NType type, Class<?> parameter, NSelector selector) {
        if(nParam != null && !nParam.getStaticMapping().equals(StaticMappingType.NATIVE) && nParam.getJavaParameter() != null && nParam.getJavaParameter().getDeclaredAnnotation(CMRef.class)!=null)
            return new StructRParam(nParam, parameter, type , nParam.getJavaParameter().getDeclaredAnnotation(CMRef.class).value());
        else if (type.getNativeType().equals("id") && type.getType().equals(parameter))
            return new IdRParam(nParam, parameter, type);
        else if (type.getType().isArray() && type.getType().equals(parameter) && type.getType().getComponentType()!=null && type.getType().getComponentType().isPrimitive())
            return new PrimArrayRParam(nParam, parameter, type);
        else if (type.getType().isArray() && type.getType().equals(parameter))
            return new ArrayRParam(nParam, parameter, type);
        else if (type.getType().isArray() && String[].class.equals(parameter))
            return new StringArrayRParam(nParam, parameter, type);
        else if (Method.class.equals(parameter)){
            //ignore for now
            Log.error("No RParam available for Ntype : " + type.getType() + " , with parameter : " + parameter + " and native type : " + type.getNativeType() + ", for selector : " + selector.getObjCSignature() + ", in class : " + selector.getJavaExecutable().getDeclaringClass().getName());
        }
        else if (type.getType().equals(parameter))
            return new NativeRParam(nParam, parameter, type);
        else if (type.isPrimitive() && objectified(type.getType()).equals(parameter) && ClassBuilder.wp.contains(parameter.getName()) )
            return new NativeRParam(nParam, parameter, type);
        else if (type.getType().equals(CustomTypeClasses.Instance.class) && (parameter == null || parameter.equals(selector.getJavaExecutable().getDeclaringClass())))
            return new InstanceRParam(nParam, selector.getJavaExecutable().getDeclaringClass(), type);
        else if (parameter == null && type.getType().equals(selector.getJavaExecutable().getDeclaringClass()))
            return new StaticRefRParam(nParam, parameter, type);
        else if (parameter != null && parameter.equals(StrongReference.class))
            return new StrongRParam(nParam, parameter, type);
        // This "parameter.getCanonicalName().equals("crossmobile.ios.foundation.NSObject")" is not a misstype
        // calling NSObject.class throws exception because it cannot find NativeObject (which is not in classpool anyway)
        else if ((parameter == null || parameter.getCanonicalName().equals("crossmobile.ios.foundation.NSObject")) && type.getNativeType().equals("id"))
            return new IdRParam(nParam, selector.getJavaExecutable().getDeclaringClass(), type);
        else if (type.getType().equals(char[].class) && parameter.equals(String.class))
            return new StringRParam(nParam, parameter, type);
        else if (type.getType().equals(int.class) && (parameter.isArray() || parameter.equals(String.class)))
            return new LengthRParam(nParam, parameter, type);
        else if (type.getType().equals(CustomTypeClasses.VoidRef.class))
            return new PointerRParam(nParam, parameter, type);
        else if (type.getType().equals(String.class) && parameter.equals(Class.class))
            return new ClassRParam(nParam, parameter, type);
        else if (type.getNativeType().endsWith("Ref") && type.getType().isAssignableFrom(parameter))
            return new RefRParam(nParam, parameter, type);
            else
            Log.error("No RParam available for Ntype : " + type.getType() + " , with parameter : " + parameter + " and native type : " + type.getNativeType() + ", for selector : " + selector.getObjCSignature() + ", in class : " + selector.getJavaExecutable().getDeclaringClass().getName());
        return null;
    }

    private static Object objectified(Class type) {
        if (type.equals(int.class))
            return Integer.class;
        if (type.equals(long.class))
            return Long.class;
        if (type.equals(float.class))
            return Float.class;
        if (type.equals(double.class))
            return Double.class;
        if (type.equals(byte.class))
            return Byte.class;
        if (type.equals(boolean.class))
            return Boolean.class;
        return type;
    }

}
