/*
 * (c) 2020 by Panayotis Katsaloulis
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
