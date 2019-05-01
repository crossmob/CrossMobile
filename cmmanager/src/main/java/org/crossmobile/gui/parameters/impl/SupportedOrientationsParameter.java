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

import org.crossmobile.gui.parameters.MultiButtonParameter;
import org.crossmobile.utils.ParamList;

import static org.crossmobile.utils.ParamsCommon.ORIENTATIONS_SUPPORTED;

public class SupportedOrientationsParameter extends MultiButtonParameter {

    private static final char SEPERATOR = ':';

    public SupportedOrientationsParameter(ParamList list) {
        super(list, ORIENTATIONS_SUPPORTED.tag(),
                new String[]{"UIInterfaceOrientationPortrait",
                        "UIInterfaceOrientationLandscapeRight",
                        "UIInterfaceOrientationPortraitUpsideDown",
                        "UIInterfaceOrientationLandscapeLeft"},
                new String[]{"Portrait", "Right", "Upside down", "Left"},
                new String[]{"images/portrait", "images/right", "images/upside", "images/left"},
                null, SEPERATOR);
    }

    @Override
    public String getVisualTag() {
        return "Supported orientations:";
    }

    public void setOrientation(String value) {
        activateValue(value);
    }
}
