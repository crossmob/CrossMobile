/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;
import org.robovm.objc.block.VoidBlock1;

/**
 * UIAlertAction class defines an object that is related to an alert action that
 * takes place after tapping an alert button.
 */
@CMClass
public class UIAlertAction extends NSObject {

    private final String title;
    private final int style;
    VoidBlock1<UIAlertAction> handler;
    private boolean enabled = true;

    private UIAlertAction(String title, int style, VoidBlock1<UIAlertAction> handler) {
        this.title = title;
        this.style = style;
        this.handler = handler;
    }

    /**
     * Constructor of the UIAlertAction. Returns UIAlertAction object with the
     * specified title and style that is related to the specified handler that
     * will be executed when it is selected.
     *
     * @param title              The title of the alert button. Not NULL.
     * @param UIAlertActionStyle The style of the alert button.
     * @param handler            The handler of the alert button.
     * @return The new alert action button.
     * @see crossmobile.ios.uikit.UIAlertActionStyle
     */
    @CMSelector("+ (instancetype)actionWithTitle:(NSString *)title \n"
            + "                          style:(UIAlertActionStyle)style \n"
            + "                        handler:(void (^)(UIAlertAction *action))handler;")
    public static UIAlertAction actionWithTitle(String title, int UIAlertActionStyle, VoidBlock1<UIAlertAction> handler) {
        return new UIAlertAction(title, UIAlertActionStyle, handler);

    }

    /**
     * Returns the title of the action button.
     *
     * @return The title of the action button.
     */
    @CMGetter("@property(nonatomic, readonly) NSString *title;")
    public String title() {
        return title;
    }

    /**
     * Returns an integer that is related to the style of the action button.
     *
     * @return An integer related to action button'style.
     * @see crossmobile.ios.uikit.UIAlertActionStyle
     */
    @CMGetter("@property(nonatomic, readonly) UIAlertActionStyle style;")
    public int style() {
        return style;
    }

    /**
     * Returns a Boolean value that shows whether the alert is enabled or not.
     *
     * @return A Boolean value that shows whether the alert is enabled or not.
     */
    @CMGetter("@property(nonatomic, getter=isEnabled) BOOL enabled;")
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets a Boolean value that defines whether the alert is enabled or not.
     *
     * @param enabled A Boolean value that defines whether the alert is enabled
     *                or not.
     */
    @CMSetter("@property(nonatomic, getter=isEnabled) BOOL enabled;")
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
