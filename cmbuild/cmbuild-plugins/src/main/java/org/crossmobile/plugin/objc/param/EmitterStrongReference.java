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
package org.crossmobile.plugin.objc.param;

import crossmobile.rt.StrongReference;
import org.crossmobile.plugin.model.NParam;

import static org.crossmobile.plugin.utils.Texters.toObjC;
import static org.crossmobile.plugin.utils.Texters.toObjCType;
import static org.crossmobile.utils.NamingUtils.getClassNameBare;
import static org.crossmobile.utils.TextUtils.TAB;

class EmitterStrongReference extends Emitter {

    EmitterStrongReference(NParam param, boolean forward) {
        super(param.getName(), param.getVarname(), param.getNType(), true, forward);
    }

    @Override
    protected String initForward() {
        return givenVar() + " = " + givenVar() + " == JAVA_NULL ? nil : " + givenVar() + ";\n"
                + "id " + paramVar() + " = nil;\n";
    }

    @Override
    protected String embedForward() {
        return "(" + givenVar() + " ? &" + paramVar() + " : nil)";
    }

    @Override
    protected String destroyForward() {
        return "if (" + givenVar() + ")\n"
                + TAB + "[" + givenVar() + " set___java_lang_Object:(" + paramVar() + " ? " + paramVar() + " : JAVA_NULL)];\n";
    }

    @Override
    protected String initReverse() {
        return toObjCType(StrongReference.class) + " " + paramVar() + " = " + givenVar() + " ? [["
                + toObjC(getClassNameBare(StrongReference.class))
                + " alloc] __init_crossmobile_ios_StrongReference___java_lang_Object:*" + givenVar() + "] : JAVA_NULL;\n";
    }

    @Override
    protected String destroyReverse() {
        return "[" + paramVar() + " release];\n";
    }

}
