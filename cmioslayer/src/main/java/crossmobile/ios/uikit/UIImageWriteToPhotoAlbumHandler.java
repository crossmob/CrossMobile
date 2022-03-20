/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.foundation.NSError;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMTarget;

/**
 * UIImageWriteToPhotoAlbumHandler interface is used as a callback in case an
 * error occurs after writing to photo album.
 */
@CMTarget
public interface UIImageWriteToPhotoAlbumHandler {

    /**
     * Used when an image was added to the photo album and an error occurred.
     *
     * @param image   The image that was added to the photo album.
     * @param error   The type of error that occurred.
     * @param context Additional information.
     */
    @CMSelector("- (void) image: (UIImage *) image didFinishSavingWithError: (NSError *) error contextInfo: (void *) contextInfo;")
    public void didFinishSavingWithError(UIImage image, NSError error, Object context);
}
