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
import org.crossmobile.plugin.model.NStructField;
import org.crossmobile.plugin.utils.Streamer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

import static org.crossmobile.bridge.ann.CMReference.REFERENCE_NAME;
import static org.crossmobile.plugin.reg.TypeRegistry.*;
import static org.crossmobile.plugin.utils.Texters.toObjCType;
import static org.crossmobile.utils.NamingUtils.getClassNameSimple;
import static org.crossmobile.utils.NamingUtils.toObjC;

public class HeaderEmitter extends FileEmitter {
    private final boolean asImportHeaders;
    private final Collection<String> imports = new TreeSet<>();

    public HeaderEmitter(NObject obj, boolean asImportHeaders, String... imports) {
        super(obj);
        this.asImportHeaders = asImportHeaders;
        this.imports.addAll(Arrays.asList(imports));
    }

    public void emit(Streamer out) throws IOException {
        emitInfo(out);
        emitReferences(out);
        emitDefinition(out);
        emitSelectors(out);
        emitHelperSelectors(out);
        emitEnd(out, false);
    }

    private void emitReferences(Streamer out) throws IOException {
        out.append("#import \"xmlvm.h\"\n");
        for (String imp : imports)
            out.append("#import ").append(imp).append("\n");
        Collection<String> dependencies = obj.getDependencies();
        if (!obj.isObjCBased() && obj.getType().getSuperclass() != null) {
            String parent = fullName(obj.getType().getSuperclass());
            dependencies.remove(parent);
            out.append("#import \"").append(parent).append(".h\"\n");
        }
        for (String dependency : dependencies)
            out.append("@").append(getJavaClass(dependency).isInterface() ? "protocol" : "class").append(" ").append(dependency).append(";\n");
        out.append("\n");
    }

    private void emitDefinition(Streamer out) throws IOException {
        if (asImportHeaders)
            out.append("CM_EXPORT_CLASS\n");
        if (obj.getType().isInterface()) {
            out.append("@protocol ").append(fullName());
//            Texters.outProtocols(out, obj.getParentProtocols());
            out.append("\n");
        } else if (obj.isAnyReference()) {
            boolean withVariable = obj.isStruct() || (obj.isReference() && !isReference(obj.getType().getSuperclass()));
            out.append("@interface ").append(fullName()).append(" : ").append(fullName(obj.getType().getSuperclass()));
            if (withVariable)
                out.append(" {\n");
            if (obj.isStruct())
                for (NStructField field : obj.getStructFields()) {
                    String simpleType = toObjC(field.type);
                    String objType = toObjCType(field.type);
                    out.append("@public ").append(objType).append(" ").append(field.name).append("_").append(simpleType).append(";\n");
                }
            else if (obj.isReference() && withVariable)
                out.append("@public ").append(obj.isCBased() ? "void*" : "id").append(" ").append(REFERENCE_NAME).append(";\n");
            if (withVariable)
                out.append("}\n");
            out.append("\n");
        } else {
            if (obj.needsOverrideBindings()) {
                out.append("@interface ").append(fullName()).append("$Ext : ").append(simpleName()).append("\n");
                out.append("@end\n\n");
            }
            out.append("#define ").append(fullName()).append(" ").append(simpleName()).append("\n");
            out.append("@interface ").append(simpleName()).append(" (cm_").append(fullName()).append(")\n");
        }
    }

    private void emitHelperSelectors(Streamer out) throws IOException {
        if (obj.isAnyReference() && !obj.isBundle()) {
            String cname = getClassNameSimple(obj.getType());
            out.append("- (instancetype) initWith").append(cname).append(":(").append(getObjCTypeRef(obj.getType())).append(") reference;\n");
            if (obj.isStruct()) {
                out.append("- (void) set").append(cname).append(":(").append(cname).append(") other;\n");
                out.append("- (").append(cname).append(") get").append(cname).append(";\n");
            }
        }
    }

    private void emitSelectors(Streamer out) throws IOException {
        for (NSelector selector : obj.getSelectors())
            new SelectorEmitter(selector).emitSignature(out);
    }

    @Override
    public String getFileType() {
        return "definition";
    }

}
