/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.foundation.NSData;
import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.foundation.NSURL;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * UIPrintInteractionController class provides all the essential methods for the
 * printing user interface.
 */
@CMClass
public class UIPrintInteractionController extends NSObject {

    private static final UIPrintInteractionController shared = new UIPrintInteractionController();
    private NSObject printingItem;
    private List printingItems;

    /**
     * Returns the shared print-interaction controller.
     *
     * @return The shared print-interaction controller. NULL in case it could
     * not be created.
     */
    @CMSelector("+ (UIPrintInteractionController *)sharedPrintController;")
    public static UIPrintInteractionController sharedPrintController() {
        return shared;
    }

    /**
     * Returns a Boolean that shows whether the printing is supported.
     *
     * @return TRUE if the device supports printing.
     */
    @CMSelector("+ (BOOL)isPrintingAvailable;")
    public static boolean isPrintingAvailable() {
        return false;
    }

    /**
     * Returns a Boolean that shows whether the specified data can be printed.
     *
     * @param p1 The data to be printed.
     * @return TRUE if the data is printable.
     */
    @CMSelector("+ (BOOL)canPrintData:(NSData *)data;")
    public static boolean canPrintData(NSData p1) {
        return false;
    }

    /**
     * Returns a Boolean that shows the file of the specified URL is printable.
     *
     * @param p1 The URL of the file to be printed.
     * @return TRUE if the file is printable.
     */
    @CMSelector("+ (BOOL)canPrintURL:(NSURL *)url;")
    public static boolean canPrintURL(NSURL p1) {
        return false;
    }

    /**
     * Returns the Uniform Type Identifiers that the UKit can print.
     *
     * @return The Uniform Type Identifiers that the UKit can print.
     */
    @CMSelector("+ (NSSet<NSString *> *)printableUTIs;")
    public static Set<String> printableUTIs() {
        return new HashSet<String>();
    }

    /**
     * Displays the printing user interface in an sheet using animation or not.
     *
     * @param p1 TRUE then the display is animated.
     * @param p2 The handler of the printing job.
     * @return TRUE if the operation was successfully completed.
     */
    @CMSelector("- (BOOL)presentAnimated:(BOOL)animated \n"
            + "      completionHandler:(UIPrintInteractionCompletionHandler)completion;")
    public boolean presentAnimated(boolean p1, UIPrintInteractionCompletionHandler p2) {
        Native.system().notImplemented();
        return false;
    }

    /**
     * Displays the printing user interface in a popover using animation(or not)
     * controlled by bar button item.
     *
     * @param p1 The bar button item that controls the animation.
     * @param p2 TRUE then the display is animated.
     * @param p3 The handler of the printing job.
     * @return TRUE if the operation was successfully completed.
     */
    @CMSelector("- (BOOL)presentFromBarButtonItem:(UIBarButtonItem *)item \n"
            + "                        animated:(BOOL)animated \n"
            + "               completionHandler:(UIPrintInteractionCompletionHandler)completion;")
    public boolean presentFromBarButtonItem(UIBarButtonItem p1, boolean p2, UIPrintInteractionCompletionHandler p3) {
        Native.system().notImplemented();
        return false;
    }

    /**
     * Displays the printing user interface in a popover that can be animated
     * from any area in a view.
     *
     * @param p1 The rectangle area of the view.
     * @param p2 The view providing the coordinate system for rectangle area.
     * @param p3 TRUE then the display is animated.
     * @param p4 The handler of the printing job.
     * @return TRUE if the operation was completed successfully.
     */
    @CMSelector("- (BOOL)presentFromRect:(CGRect)rect \n"
            + "                 inView:(UIView *)view \n"
            + "               animated:(BOOL)animated \n"
            + "      completionHandler:(UIPrintInteractionCompletionHandler)completion;")
    public boolean presentFromRect(CGRect p1, UIView p2, boolean p3, UIPrintInteractionCompletionHandler p4) {
        Native.system().notImplemented();
        return false;
    }

    /**
     * Dismisses the printing options using animation or not.
     *
     * @param p1 TRUE the dismissal is animated.
     */
    @CMSelector("- (void)dismissAnimated:(BOOL)animated;")
    public void dismissAnimated(boolean p1) {
        Native.system().notImplemented();
    }

    /**
     * Returns a ready to print item.
     *
     * @return A ready to print item.
     */
    @CMGetter("@property(nonatomic, copy) id printingItem;\n"
            + "")
    public NSObject printingItem() {
        return printingItem;
    }

    /**
     * Sets an item ready to print.
     *
     * @param printingItem A ready to print item.
     */
    @CMSetter("@property(nonatomic, copy) id printingItem;\n"
            + "")
    public void setPrintingItem(NSObject printingItem) {
        if ((printingItem instanceof NSURL) || (printingItem instanceof NSData) || (printingItem instanceof UIImage)) {
            this.printingItem = printingItem;
            this.printingItems = null;
        }
    }

    /**
     * Returns the list with items ready to print.
     *
     * @return The list with items ready to print.
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @CMGetter("@property(nonatomic, copy) NSArray *printingItems;")
    public List printingItems() {
        return new ArrayList(printingItems);
    }

    /**
     * Sets a list with items ready to print.
     *
     * @param printingItems The list with items ready to print.
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @CMSetter("@property(nonatomic, copy) NSArray *printingItems;")
    public void setPrintingItems(List printingItems) {
        this.printingItem = null;
        this.printingItems = new ArrayList();
        for (Object o : printingItems)
            if ((o instanceof NSURL) || (o instanceof NSData) || (o instanceof UIImage))
                printingItems.add(o);
    }
}
