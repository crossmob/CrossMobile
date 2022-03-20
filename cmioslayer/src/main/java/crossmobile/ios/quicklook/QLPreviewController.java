/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.quicklook;

import crossmobile.ios.uikit.UIViewController;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;

/**
 * QLPreviewController class defines an object that handles the previews of
 * items.
 */
@CMClass
public class QLPreviewController extends UIViewController {

    private QLPreviewControllerDataSource datasource;
    private QLPreviewControllerDelegate delegate;

    /**
     * Returns a Boolean that shows whether this QLPreviewController can display
     * the specified item.
     *
     * @param item The item that is requested to be displayed by the
     *             QLPreviewController.
     * @return The QLPreviewController can display the specified item.
     */
    @CMSelector("+ (BOOL)canPreviewItem:(id<QLPreviewItem>)item;")
    public static boolean canPreviewItem(QLPreviewItem item) {
        Native.system().notImplemented();
        return false;
    }

    /**
     * Returns the data source of this QLPreviewController.
     *
     * @return The data source of this QLPreviewController.
     */
    @CMGetter("@property(nonatomic, weak) id<QLPreviewControllerDataSource> dataSource;\n"
            + "")
    public QLPreviewControllerDataSource dataSource() {
        return datasource;
    }

    /**
     * Sets the data source of this QLPreviewController.
     *
     * @param dataSource The data source of this QLPreviewController.
     */
    @CMSetter("@property(nonatomic, weak) id<QLPreviewControllerDataSource> dataSource;")
    public void setDataSource(QLPreviewControllerDataSource dataSource) {
        this.datasource = dataSource;
    }

    /**
     * Returns the index of item that is displayed on this QLPreviewController.
     *
     * @return The index of item that is displayed on this QLPreviewController.
     */
    @CMGetter("@property NSInteger currentPreviewItemIndex;")
    public int currentPreviewItemIndex() {
        Native.system().notImplemented();
        return 0;
    }

    /**
     * Sets the item that will be displayed on this QLPreviewController.
     *
     * @param currentPreviewItemIndex The item to be displayed on this
     *                                QLPreviewController.
     */
    @CMSetter("@property NSInteger currentPreviewItemIndex;")
    public void setCurrentPreviewItemIndex(int currentPreviewItemIndex) {
        Native.system().notImplemented();
    }

    /**
     * Returns the item that is displayed on this QLPreviewController.
     *
     * @return The item that is displayed on this QLPreviewController.
     */
    @CMGetter("@property(readonly) id<QLPreviewItem> currentPreviewItem;\n"
            + "")
    public QLPreviewItem currentPreviewItem() {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Returns the delegate of this QLPreviewController.
     *
     * @return The delegate of this QLPreviewController.
     */
    @CMGetter("@property(nonatomic, weak) id<QLPreviewControllerDelegate> delegate;\n"
            + "")
    public QLPreviewControllerDelegate delegate() {
        return delegate;
    }

    /**
     * Sets the delegate for this QLPreviewController.
     *
     * @param delegate The delegate of this QLPreviewController.
     */
    @CMSetter("@property(nonatomic, weak) id<QLPreviewControllerDelegate> delegate;\n"
            + "")
    public void setDelegate(QLPreviewControllerDelegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Reloads the data from its data source.
     */
    @CMSelector("- (void)reloadData;")
    public void reloadData() {
        Native.system().notImplemented();
    }

    /**
     * Refreshes the current preview item.
     */
    @CMSelector("- (void)refreshCurrentPreviewItem;")
    public void refreshCurrentPreviewItem() {
        Native.system().notImplemented();
    }
}
