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
package org.crossmobile.gui.parameters.impl;

import org.crossmobile.gui.parameters.FreeTextParameter;
import org.crossmobile.utils.ParamList;

import static org.crossmobile.utils.ParamsCommon.OBJC_IGNORE_INCLUDES;

public class HideIncludesParameter extends FreeTextParameter {
    public HideIncludesParameter(ParamList list) {
        super(list, OBJC_IGNORE_INCLUDES.tag());
    }

    @Override
    protected String getVisualTag() {
        return "Ignore include files that are not implemented yet, as a semicolon list";
    }

    @Override
    protected boolean isSingleLineVisual() {
        return false;
    }
}
