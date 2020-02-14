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

import org.crossmobile.plugin.model.NObject;
import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.plugin.reg.PluginRegistry;
import org.crossmobile.plugin.reg.TypeRegistry;
import org.crossmobile.plugin.utils.Streamer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.crossmobile.bridge.ann.CMReference.REFERENCE_NAME;
import static org.crossmobile.plugin.reg.TypeRegistry.getObjCTypeRef;
import static org.crossmobile.plugin.reg.TypeRegistry.isReference;
import static org.crossmobile.plugin.utils.Texters.getClassNameReference;
import static org.crossmobile.plugin.utils.Texters.getMetaClassNameReference;
import static org.crossmobile.utils.NamingUtils.getClassNameSimple;
import static org.crossmobile.utils.TextUtils.startsWith;

public class BodyEmitter extends FileEmitter {

    public BodyEmitter(NObject obj) {
        super(obj);
    }

    void emit(Streamer out, Streamer swift, String[] filter) throws IOException {
        emitInfo(out);
        emitIncludes(out);
        if (obj.needsOverrideBindings()) {
            emitDefinition(out, true);
            emitEnd(out, true);
        }
//        emitStaticFunctionPointers(out);
        emitDefinition(out, false);
//        emitLoad(out);
        emitSelectors(out, swift, filter);
        emitHelperSelectors(out);
        emitEnd(out, false);
    }

    private void emitIncludes(Streamer out) throws IOException {
        Collection<String> dependencies = obj.getDependencies();
        dependencies.add(fullName());
        if (!obj.isObjCBased() && obj.getType().getSuperclass() != null)
            dependencies.remove(fullName(obj.getType().getSuperclass()));
        for (String dependency : dependencies)
            out.append("#import \"").append(dependency).append(".h\"\n");
        for (NSelector sel : obj.getSelectors())
            if (!sel.getSwiftMethod().isEmpty()) {
                out.append("#import \"").append(PluginRegistry.getPlugin(obj.getType().getName())).append("-Swift.h\"\n");
                break;
            }
        out.append("\n");
    }

    private void emitStaticFunctionPointers(Streamer out) throws IOException {
        if (obj.isObjCBased()) {
            out.append("static Class ").append(getClassNameReference(obj)).append(";\n");
            out.append("static Class ").append(getMetaClassNameReference(obj)).append(";\n\n");
        }
    }

    private void emitDefinition(Streamer out, boolean extended) throws IOException {
        if (obj.isAnyReference())
            out.append("@implementation ").append(fullName()).append("\n\n");
        else if (extended)
            out.append("@implementation ").append(fullName()).append("$Ext\n\n");
        else
            out.append("@implementation ").append(simpleName()).append(" (cm_").append(fullName()).append(")\n\n");
    }

    private void emitLoad(Streamer out) throws IOException {
        if (obj.isObjCBased()) {
            out.append("+ (void) load {\n").tab();
            out.append(getClassNameReference(obj)).append(" = [").append(simpleName()).append(" class];\n");
            out.append(getMetaClassNameReference(obj)).append(" = object_getClass(").append(getClassNameReference(obj)).append(");\n");
            out.untab().append("}\n\n");
        }
    }

    private void emitHelperSelectors(Streamer out) throws IOException {
        if (obj.isReference()) {
            Class parentClass = obj.getType().getSuperclass();
            boolean parentIsReference = isReference(parentClass);
            boolean isObjCReference = !parentIsReference && !obj.isCBased();
            out.append("- (instancetype) initWith").append(getClassNameSimple(obj.getType())).append(":(").append(getObjCTypeRef(obj.getType())).append(") reference\n{\n").tab();
            out.append("self = ");
            if (parentIsReference)
                out.append("[super initWith").append(getClassNameSimple(parentClass)).append(":reference];\n");
            else
                out.append("[super init];\n");
            if (!parentIsReference) {
                out.append("self->").append(REFERENCE_NAME).append(" = reference;\n");
                out.append("if (self->").append(REFERENCE_NAME).append(")\n").tab();
                if (isObjCReference)
                    out.append("[self->").append(REFERENCE_NAME).append(" retain];\n").untab();
                else
                    out.append("CFRetain(self->").append(REFERENCE_NAME).append(");\n").untab();
            }
            out.append("return self;\n").untab();
            out.append("}\n\n");

            if (!parentIsReference) {
                out.append("- (void) dealloc\n{\n").tab();
                out.append("if (self->").append(REFERENCE_NAME).append(")\n").tab();
                if (isObjCReference)
                    out.append("[self->").append(REFERENCE_NAME).append(" release];\n").untab();
                else
                    out.append("CFRelease(self->").append(REFERENCE_NAME).append(");\n").untab();
                out.append("[super dealloc];\n").untab();
                out.append("}\n\n");
            }
        } else if (obj.isStruct())
            StructConstructorParser.helperMethods(obj, out);
    }

    private void emitSelectors(Streamer out, Streamer swift, String[] filter) throws IOException {
        String selfName = TypeRegistry.isObjCReference(obj.getType()) ? "self->" + REFERENCE_NAME : null;
        for (NSelector sel : obj.getSelectors())
            if (filter == null || startsWith(sel.getName(), Arrays.asList(filter))) {
                out.append("// ").append(sel.getOriginalCode()).append("\n");
                new SelectorEmitter(sel, selfName).emitImplementation(out).emitSwift(swift);
            }
    }

    @Override
    public String getFileType() {
        return "implementation";
    }

}
