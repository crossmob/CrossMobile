/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.quicklook;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * QLPreviewControllerDataSource interface provides QLPreview items to the
 * QLPreviewController.
 */
@CMClass
public interface QLPreviewControllerDataSource {

    /**
     * Returns the number of the QLPreview items that will be displayed in the
     * preview navigation list.
     *
     * @param controller The QLPreviewController whose number of preview items
     *                   is requested.
     * @return The number of the QLPreview items that will be displayed in the
     * preview navigation list.
     */
    @CMSelector("- (NSInteger)numberOfPreviewItemsInPreviewController:(QLPreviewController *)controller;")
    int numberOfPreviewItemsInPreviewController(QLPreviewController controller);

    /**
     * Returns the QLPreviewItem of the specified index position of this
     * QLPreviewController.
     *
     * @param controller The QLPreviewController that is requesting a preview
     *                   item.
     * @param index      The index of the requested QLPreviewItem.
     * @return The QLPreviewItem that is requested.
     */
    @CMSelector("- (id<QLPreviewItem>)previewController:(QLPreviewController *)controller \n"
            + "                    previewItemAtIndex:(NSInteger)index;")
    QLPreviewItem previewItemAtIndex(QLPreviewController controller, int index);
}
