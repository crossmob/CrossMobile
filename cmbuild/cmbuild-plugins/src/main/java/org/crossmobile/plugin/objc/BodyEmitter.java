/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.crossmobile.plugin.objc;

import org.crossmobile.plugin.model.NObject;
import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.plugin.reg.PluginRegistry;
import org.crossmobile.plugin.utils.Streamer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

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
            emitSelectors(out, swift, filter, true);
            emitEnd(out, true);
        }
//        emitStaticFunctionPointers(out);
        emitDefinition(out, false);
//        emitLoad(out);
        emitSelectors(out, swift, filter, false);
        emitHelperSelectors(out);
        emitEnd(out, false);
    }

    private void emitIncludes(Streamer out) throws IOException {
        Collection<String> dependencies = obj.getDependencies(true);
        dependencies.add(fullName());
        if (!obj.isObjCBased() && obj.getType().getSuperclass() != null)
            dependencies.remove(fullName(obj.getType().getSuperclass()));
        for (String dependency : dependencies)
            out.append("#import \"").append(dependency).append(".h\"\n");
        for (NSelector sel : obj.getSelectors())
            if (sel.getMethodType().isVarArgs()) {
                out.append("#import \"java_util_Arrays.h\"\n");
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
        if (obj.isCBased())
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
            out.append("- (instancetype) initWith").append(getClassNameSimple(obj.getType())).append(":(").append(getObjCTypeRef(obj.getType())).append(") reference\n{\n").tab();
            Class parentClass = obj.getType().getSuperclass();
            out.append("self = ");
            if (parentClass != null && isReference(parentClass))
                out.append("[super initWith").append(getClassNameSimple(parentClass)).append(":reference];\n");
            else
                out.append("[super init];\n");
            if (!isReference(parentClass)) {
                out.append("self->").append(REFERENCE_NAME).append(" = reference;\n");
                out.append("if (self->").append(REFERENCE_NAME).append(")\n").tab().append("CFRetain(self->").append(REFERENCE_NAME).append(");\n").untab();
            }
            out.append("return self;\n").untab();
            out.append("}\n\n");

            if (!isReference(parentClass)) {
                out.append("- (void) dealloc\n{\n").tab();
                out.append("if (self->").append(REFERENCE_NAME).append(")\n").tab().append("CFRelease(self->").append(REFERENCE_NAME).append(");\n").untab();
                out.append("[super dealloc];\n").untab();
                out.append("}\n\n");
            }
        } else if (obj.isStruct())
            StructConstructorParser.helperMethods(obj, out);
    }

    private void emitSelectors(Streamer out, Streamer swift, String[] filter, boolean overridableSelectors) throws IOException {
        for (NSelector sel : overridableSelectors ? obj.getAllSelectors() : obj.getSelectors())
            if (filter == null || startsWith(sel.getName(), Arrays.asList(filter)))
                if (overridableSelectors) {
                    if (sel.needsOverrideBindings()) {
                        out.append("// (").append(getClassNameSimple(sel.getContainer().getType())).append(") ").append(sel.getOriginalCode()).append("\n");
                        new SelectorEmitter(sel, true).emitImplementation(out);
                    }
                } else {
                    out.append("// direct binding of: ").append(sel.getOriginalCode()).append("\n");
                    new SelectorEmitter(sel).emitImplementation(out).emitSwift(swift);
                }
    }

    @Override
    public String getFileType() {
        return "implementation";
    }

}
