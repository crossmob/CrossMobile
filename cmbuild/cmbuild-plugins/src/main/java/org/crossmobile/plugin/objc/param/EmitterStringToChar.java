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

class EmitterStringToChar extends Emitter {

    EmitterStringToChar(NParam param, boolean forward) {
        this(param.getName(), param.getVarname(), param.getNType(), forward);
    }

    EmitterStringToChar(String paramName, String varName, NType type, boolean forward) {
        super(paramName, varName, type, true, forward);
    }

    @Override
    protected String embedForward() {
        return "[" + givenVar() + " UTF8String]";
    }

    @Override
    protected String initReverse() {
        return "NSString* " + paramVar() + " = [[NSString alloc] initWithUTF8String:" + givenVar() + "];\n";
    }

    @Override
    protected String destroyReverse() {
        return "[" + paramVar() + " release];\n";
    }

}
