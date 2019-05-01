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

import org.crossmobile.bridge.ann.CMParamMod;
import org.crossmobile.plugin.model.NParam;
import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.plugin.model.NType;

import static org.crossmobile.plugin.reg.TypeRegistry.getCastingIfNeeded;

class EmitterObject extends Emitter {

    private final String typeConverter;
    private final boolean needsRetain;
    private final String casting;

    EmitterObject(NParam param, NSelector sel, boolean forward) {
        this(param.getName(), param.getVarname(), param.getNType(), !(sel.isConstructor() || sel.isFakeConstructor()), forward);
    }

    EmitterObject(String paramName, String varName, NType type, boolean noObjectRetainNeeded, boolean forward) {
        super(paramName, varName, type, !type.getTypeConverter().isEmpty(), forward);
        this.typeConverter = type.getTypeConverter();
        this.needsRetain = !noObjectRetainNeeded;
        casting = getCastingIfNeeded(type.getNativeType());
    }

    @Override
    protected String initForward() {
        return isEmbeddable()
                ? ""
                : givenVar() + " = " + getForward() + ";\n"
                + typeConverter.replace(CMParamMod.JAVA_PARAM, givenVar()).replace(CMParamMod.NATIVE_PARAM, paramVar()) + "\n";
    }

    @Override
    protected String embedForward() {
        return isEmbeddable() ? "(" + getForward() + ")" : paramVar();
    }

    private String getForward() {
        return givenVar() + " == JAVA_NULL ? nil : " + givenVar();
    }

    @Override
    protected String embedReverse() {
        return "(" + givenVar() + " ? " + casting + givenVar() + " : JAVA_NULL)";
    }

    private boolean isEmbeddable() {
        return !isForward || typeConverter.isEmpty();
    }

    @Override
    protected String execForward(String exec, boolean needsDestroy) {
        return (!needsRetain && !needsDestroy)
                ? "return " + exec + ";\n"
                : super.execForward(exec, true);
    }

    @Override
    protected String resultForward(String caller, boolean needsDestroy) {
        if (!needsRetain && !needsDestroy)
            return "";
        else if (!needsRetain)
            return "return " + givenVar() + ";\n";
        else
            return "return [(" + givenVar() + " ? " + givenVar() + " : JAVA_NULL) " + "retain];\n";
    }

    @Override
    protected String execReverse(String exec, boolean needsDestroy) {
        return super.execReverse(exec, needsDestroy); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String resultReverse(String exec, boolean needsDestroy) {
        return "return [(" + givenVar() + " == JAVA_NULL ? nil : " + givenVar() + ") " + "autorelease];\n";
    }

}
