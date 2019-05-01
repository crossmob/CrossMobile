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

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMSelector;

import java.util.Map;

/**
 * UIImagePickerControllerDelegate interface is the delegate responsible for
 * receiving and handling notifications from the UIImagePickerController.
 */
@CMClass
@CMLib(name = "cmimage")
public interface UIImagePickerControllerDelegate extends UINavigationControllerDelegate {

    /**
     * It is used in order to handle the fact that the user just picked a movie
     * or an image.
     *
     * @param picker The image picker controller that corresponds to this
     *               delegate.
     * @param info   Relative editing information. NULL if the editing is
     *               disabled.
     */
    @CMSelector("- (void)imagePickerController:(UIImagePickerController *)picker\n"
            + "didFinishPickingMediaWithInfo:(NSDictionary<NSString *,\n"
            + "                                       id> *)info")
    public default void didFinishPickingMediaWithInfo(UIImagePickerController picker, Map<String, Object> info) {
    }

    /**
     * It is used in order to handle the fact that the user canceled picking a
     * movie or an image.
     *
     * @param picker The image picker controller that corresponds to this
     *               delegate.
     */
    @CMSelector("- (void)imagePickerControllerDidCancel:(UIImagePickerController *)picker;")
    public default void didCancel(UIImagePickerController picker) {
    }
}
