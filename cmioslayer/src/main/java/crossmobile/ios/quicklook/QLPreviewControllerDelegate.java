/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.quicklook;

import crossmobile.ios.foundation.NSURL;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * QLPreviewControllerDelegate interface is the delegate that cooperates with
 * QLPreviewController objects.
 */
@CMClass
public interface QLPreviewControllerDelegate {

    /**
     * It is called before the QLPreviewController is closed.
     *
     * @param controller The QLPreviewController that corresponds to this
     *                   delegate.
     */
    @CMSelector("- (void)previewControllerWillDismiss:(QLPreviewController *)controller;")
    public void willDismiss(QLPreviewController controller);

    /**
     * It is called after the QLPreviewController is closed.
     *
     * @param controller The QLPreviewController that corresponds to this
     *                   delegate.
     */
    @CMSelector("- (void)previewControllerDidDismiss:(QLPreviewController *)controller;")
    public void didDismiss(QLPreviewController controller);

    /**
     * It is called before the QLPreviewController tries to open the specified
     * URL.
     * <p>
     * Called by the Quick Look preview controller before trying to open a URL.
     *
     * @param controller The QLPreviewController that corresponds to this
     *                   delegate.
     * @param url        The URL that is requested to open.
     * @param item       The related QLPreview item.
     * @return TRUE then the URL should be opened.
     */
    @CMSelector("- (BOOL)previewController:(QLPreviewController *)controller \n"
            + "            shouldOpenURL:(NSURL *)url \n"
            + "           forPreviewItem:(id<QLPreviewItem>)item;")
    public boolean shouldOpenURL(QLPreviewController controller, NSURL url, QLPreviewItem item);

}
