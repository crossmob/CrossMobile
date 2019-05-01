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
package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;
import org.crossmobile.bridge.ann.CMLib;

/**
 * UIImagePickerControllerQualityType class defines different video quality
 * options.
 */
@CMEnum
@CMLib(name = "cmimage")
public final class UIImagePickerControllerQualityType {

    /**
     * The video quality is set to be high.
     */
    public static final int High = 0;

    /**
     * The video quality is VGA (640x480 pixels).
     */
    public static final int D640x480 = 3;

    /**
     * The video quality is set to be medium.
     */
    public static final int Medium = 1;

    /**
     * The video quality is set to be low.
     */
    public static final int Low = 2;

    private UIImagePickerControllerQualityType() {
    }
}
