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

import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.plugin.objc.param.ParamEmitter;
import org.crossmobile.plugin.utils.Streamer;

import java.io.IOException;

import static org.crossmobile.utils.CollectionUtils.forEach;
import static org.crossmobile.utils.NamingUtils.execSignature;

public class SelectorEmitterReverse extends SelectorEmitter {

    private final String blockvar;

    public SelectorEmitterReverse(NSelector selector) {
        this(selector, null);
    }

    public SelectorEmitterReverse(NSelector selector, String blockvar) {
        super(selector);
        this.blockvar = blockvar;
    }

    @Override
    protected void emitDefinition(Streamer out) throws IOException {
        out.append(selector.isStatic() ? "+" : "-").append(" (");
        out.append(selector.getReturnType().getNativeType()).append(") ").append(selector.getName());
        forEach(selector.getParams()).
                onTail(p -> out.append(" ")).
                onAny(p -> out.append(p.getName()).append(":").append("(").append(p.getNType().getNativeType()).append(")").append(" ").append(p.getVarname())).
                go();
    }

    @Override
    protected ParamEmitter getParams() {
        return ParamEmitter.reverse(selector, blockvar);
    }

    @Override
    protected String getOriginalCode() {
        return execSignature(selector.getJavaExecutable(), false) + ";";
    }

    @Override
    protected void emitAssociate(Streamer out) throws IOException {
    }

    @Override
    protected void emitBreakEarly(Streamer out) throws IOException {
    }

}
