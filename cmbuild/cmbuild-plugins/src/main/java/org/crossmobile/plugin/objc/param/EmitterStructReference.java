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

import org.crossmobile.plugin.model.NParam;
import org.crossmobile.plugin.model.NType;

import static org.crossmobile.plugin.utils.Factories.getDereferType;
import static org.crossmobile.plugin.utils.Texters.toObjC;
import static org.crossmobile.utils.NamingUtils.getClassNameSimple;
import static org.crossmobile.utils.TextUtils.TAB;

class EmitterStructReference extends Emitter {

    private final EmitterCType internal;
    private final NType deref;
    private final boolean constant;

    EmitterStructReference(NParam param, boolean forward) {
        super(param.getName(), param.getVarname(), param.getNType(), true, forward);
        deref = getDereferType(param.getNType());
        internal = new EmitterCType(param.getName(), param.getVarname(), deref, false, false, forward);
        constant = param.getNType().isConstant();
    }

    @Override
    protected String initForward() {
        return toObjC(getClassNameSimple(deref.getType())) + " " + paramVar() + ";\n"
                + "if (" + givenVar() + " != JAVA_NULL)\n"
                + TAB + paramVar() + " = " + internal.embedForward() + ";\n";
    }

    @Override
    protected String embedForward() {
        return "(" + givenVar() + " == JAVA_NULL ? NULL : &" + paramVar() + ")";
    }

    @Override
    protected String destroyForward() {
        return constant
                ? ""
                : "if (" + givenVar() + " != JAVA_NULL) \n"
                + TAB + "[" + givenVar() + " set" + toObjC(getClassNameSimple(deref.getType())) + ":" + paramVar() + "];\n";
    }

}
