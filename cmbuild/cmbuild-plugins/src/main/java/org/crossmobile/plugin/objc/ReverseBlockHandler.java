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
package org.crossmobile.plugin.objc;

import org.crossmobile.plugin.model.NParam;
import org.crossmobile.plugin.model.NSelector;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static org.crossmobile.utils.NamingUtils.toObjC;
import static org.crossmobile.utils.CollectionUtils.KeyValue.map;
import static org.crossmobile.utils.CollectionUtils.mapOf;

class ReverseBlockHandler {
    final String className;
    final String importData;
    final String bodyData;

    ReverseBlockHandler(String className, Class<?> containerClass, NSelector block) {
        if (!block.getJavaReturn().getName().equals("void"))
            throw new RuntimeException("Only void blocks can be implemented right now");

        this.className = className;

        AtomicInteger count = new AtomicInteger();
        List<TransformedParam> params = block.getParams().stream().map(p -> new TransformedParam(p, count.incrementAndGet())).collect(Collectors.toList());
        boolean needsDoubleMethod = !params.isEmpty() && params.stream().anyMatch(tp -> tp.needsBoxing);

        String objMethodSignature = getParamDefinition(params, TransformedParam::getObjClass);
        String genMethodSignature = needsDoubleMethod ? getParamDefinition(params, TransformedParam::getBoxedClassName) : "";
        Class<?> selfClass = block.getJavaExecutable().getDeclaringClass();

        String imports = getAllTypes(params, Object.class, containerClass, selfClass)
                .stream().map(p -> toObjC(p.getName()))
                .collect(joining(".h\"\n#import \"", "#import \"", ".h\"\n"));

        String directMethod = "\n" + (genMethodSignature.isEmpty() ? objMethodSignature : genMethodSignature) + "\n"
                + "{\n"
                + "    ((" + block.getOriginalCode() + ")blockVar)(" + getParamRealCall(params) + ");\n"
                + "}\n";
        String indirectMethod = !needsDoubleMethod ? "" : "\n" + objMethodSignature + "\n"
                + "{\n"
                + "    [self " + getMethodName(params, TransformedParam::getBoxedClassName) + getParamObjCall(params) + "];\n"
                + "}\n";

        this.importData = generateImport(className, selfClass, imports, objMethodSignature + ";\n" + (genMethodSignature.isEmpty() ? "" : genMethodSignature + ";\n"));
        this.bodyData = generateBody(className, indirectMethod + directMethod);
    }

    private String getParamRealCall(List<TransformedParam> params) {
        return params.stream().map(TransformedParam::getNativeArg).collect(joining(", "));
    }

    private Collection<Class<?>> getAllTypes(List<TransformedParam> params, Class<?>... otherObjects) {
        Collection<Class<?>> types = new TreeSet<>(Comparator.comparing(Class::getName));
        types.addAll(Arrays.asList(otherObjects));
        params.forEach(p -> types.add(p.getBoxedClassType()));
        return types;
    }


    private String getMethodName(List<TransformedParam> params, Function<TransformedParam, String> className) {
        StringBuilder out = new StringBuilder();
        if (params.isEmpty())
            out.append("run__");
        else {
            out.append("invoke__");
            params.forEach(p -> out.append("_").append(className.apply(p)));
        }
        return out.toString();
    }

    private String getParamDefinition(List<TransformedParam> params, Function<TransformedParam, String> className) {
        return "- (void) "
                + getMethodName(params, className)
                + params.stream().map(p -> " :(" + className.apply(p) + "*)n" + p.idx).collect(joining());
    }

    private String getParamObjCall(List<TransformedParam> params) {
        return params.isEmpty() ? ""
                : params.stream().map(TransformedParam::getGenericArg).collect(joining());
    }

    private String generateImport(String className, Class<?> interfaceClass, String imports, String otherMethods) {
        return "#import \"xmlvm.h\"\n" +
                imports +
                "\n" +
                "@interface " + className + " : java_lang_Object<" + toObjC(interfaceClass.getName()) + "> {\n" +
                "@private id blockVar;\n" +
                "}\n" +
                "\n" +
                "-(instancetype) initWithCMBlock:(id) blk;\n" +
                otherMethods +
                "@end";
    }

    private String generateBody(String className, String otherMethods) {
        return "#import \"" + className + ".h\"\n" +
                "\n" +
                "@implementation " + className + "\n" +
                "\n" +
                "-(instancetype) initWithCMBlock:(id) blk\n" +
                "{\n" +
                "    self = [super init];\n" +
                "    self->blockVar = blk;\n" +
                "    return self;\n" +
                "}\n" +
                otherMethods +
                "\n" +
                "@end";
    }
}

class TransformedParam {
    private final static Map<Class<?>, Class<?>> PRIMITIVE_MAP = mapOf(
            map(boolean.class, Boolean.class),
            map(byte.class, Byte.class),
            map(short.class, Short.class),
            map(int.class, Integer.class),
            map(long.class, Long.class),
            map(float.class, Float.class),
            map(double.class, Double.class),
            map(char.class, Character.class)
    );

    private static final String objClass = toObjC(Object.class.getName());

    private final Class<?> originalClass;
    private final Class<?> boxedClass;
    private final String boxedClassName;
    final int idx;
    final boolean needsBoxing;

    TransformedParam(NParam param, int idx) {
        this.originalClass = param.getNType().getType();
        this.needsBoxing = originalClass.isPrimitive();
        this.boxedClass = needsBoxing ? PRIMITIVE_MAP.get(originalClass) : originalClass;
        this.idx = idx;
        this.boxedClassName = toObjC(boxedClass.getName());
    }

    String getBoxedClassName() {
        return boxedClassName;
    }

    Class<?> getBoxedClassType() {
        return boxedClass;
    }

    String getObjClass() {
        return objClass;
    }

    String getGenericArg() {
        return " :" + (originalClass == boxedClass ? "" : "(" + boxedClassName + "*)") + "n" + idx;
    }

    String getNativeArg() {
        return needsBoxing ? "[n" + idx + " " + originalClass.getName() + "Value__]" : "n" + idx;
    }
}