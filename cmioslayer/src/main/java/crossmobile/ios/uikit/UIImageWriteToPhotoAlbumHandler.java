/*
 * (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
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
