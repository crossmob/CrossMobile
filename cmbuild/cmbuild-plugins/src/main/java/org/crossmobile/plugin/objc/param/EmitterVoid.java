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

import org.crossmobile.plugin.model.NType;

public class EmitterVoid extends Emitter {

    public static final Emitter TYPE = new EmitterVoid();

    private EmitterVoid() {
        super("", "", new NType("void", Void.TYPE), false, false);
    }

    @Override
    protected String execForward(String caller, boolean needsDestroy) {
        return caller + ";\n";
    }

    @Override
    protected String execReverse(String caller, boolean needsDestroy) {
        return execForward(caller, needsDestroy);
    }

    @Override
    protected String resultForward(String exec, boolean needsDestroy) {
        return "";
    }

    @Override
    protected String resultReverse(String exec, boolean needsDestroy) {
        return "";
    }

}
