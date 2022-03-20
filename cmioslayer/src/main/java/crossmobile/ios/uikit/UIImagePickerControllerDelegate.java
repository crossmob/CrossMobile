/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
    default void didFinishPickingMediaWithInfo(UIImagePickerController picker, Map<String, Object> info) {
    }

    /**
     * It is used in order to handle the fact that the user canceled picking a
     * movie or an image.
     *
     * @param picker The image picker controller that corresponds to this
     *               delegate.
     */
    @CMSelector("- (void)imagePickerControllerDidCancel:(UIImagePickerController *)picker;")
    default void didCancel(UIImagePickerController picker) {
    }
}
