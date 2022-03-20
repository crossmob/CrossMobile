/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.quicklook;

import crossmobile.ios.foundation.NSURL;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;

/**
 * QLPreviewItem interface defines properties of items that can be previewed in
 * a QuickLook preview.
 */
@CMClass
public interface QLPreviewItem {

    /**
     * Returns the URL of the QLPreviewItem.
     *
     * @return The URL of the QLPreviewItem.
     */
    @CMGetter("@property(readonly, nonatomic) NSURL *previewItemURL;")
    public abstract NSURL previewItemURL();

    /**
     * Returns the title of the QLPreviewItem.
     *
     * @return The title of the QLPreviewItem.
     */
    @CMGetter("@property(readonly, nonatomic) NSString *previewItemTitle;")
    public abstract String previewItemTitle();
}
