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

import org.crossmobile.gui.parameters.SelectionListParameter;
import org.crossmobile.utils.ParamList;

import static org.crossmobile.utils.ParamsCommon.ORIENTATIONS_INITIAL;

public class InitialOrientationParameter extends SelectionListParameter {

    public InitialOrientationParameter(ParamList list) {
        super(list, ORIENTATIONS_INITIAL.tag(), new String[]{"UIInterfaceOrientationPortrait", "UIInterfaceOrientationPortraitUpsideDown", "UIInterfaceOrientationLandscapeLeft", "UIInterfaceOrientationLandscapeRight"}, new String[]{"Portrait", "Upside down", "Left", "Right"}, new String[]{"Initial orientation will be portrait", "Initial orientation will be upside down portrait", "Initial orientation will be counter-clockwise landscape", "Initial orientation will be clockwise landscape"}, 0);
    }

    @Override
    public String getVisualTag() {
        return "Initial orientation";
    }

    public void check(String value) {
        String[] split = value.split(":");
        if (split.length < 1)
            return;
        for (String s : split)
            if (s.equals(getValue()))
                return;
        setValue(split[0]);
    }
}
