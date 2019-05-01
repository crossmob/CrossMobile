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
    public int numberOfPreviewItemsInPreviewController(QLPreviewController controller);

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
    public QLPreviewItem previewItemAtIndex(QLPreviewController controller, int index);
}
