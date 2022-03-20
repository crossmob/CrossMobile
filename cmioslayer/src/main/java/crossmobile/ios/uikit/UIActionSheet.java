/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import java.util.ArrayList;
import java.util.List;

import static org.crossmobile.bridge.SystemBridge.CANCEL_ID;
import static org.crossmobile.bridge.SystemBridge.DESTROY_ID;

/**
 * UIActionSheet class defines certain type of visible objects called action
 * sheets. Actions sheets are set of buttons that prompt the user to select a
 * option for the completion of a task. The display of the action sheets is
 * triggered by user action.
 * <p>
 * This object is deprecated, please use UIAlertController with UIAlertControllerStyle.Alert instead.
 *
 * @see UIAlertController
 * @see UIAlertControllerStyle#Sheet
 */
@Deprecated
@CMClass
public class UIActionSheet extends UIView {

    private String title;
    private String cancelButtonTitle;
    private String destructiveButtonTitle;
    private final List<String> otherButtonTitles = new ArrayList<>();
    private final List<Integer> otherButtonIndex = new ArrayList<>();
    private UIActionSheetDelegate delegate;

    private int cancelButtonIndex = -1;
    private int destructiveButtonIndex = -1;
    private int firstOtherButtonIndex = -1;

    /**
     * Defines an action sheet the specified parameters.
     *
     * @param title                  The title of the action sheet.
     * @param delegate               The preferred delegate.
     * @param cancelButtonTitle      Cancel button's title.
     * @param destructiveButtonTitle Destructive button's title
     * @param otherButtonTitles      Titles for the other buttons.
     */
    @Deprecated
    @CMConstructor("- (instancetype)initWithTitle:(NSString *)title \n"
            + "                     delegate:(id<UIActionSheetDelegate>)delegate \n"
            + "            cancelButtonTitle:(NSString *)cancelButtonTitle \n"
            + "       destructiveButtonTitle:(NSString *)destructiveButtonTitle \n"
            + "            otherButtonTitles:(NSString *)otherButtonTitles, ...;")
    public UIActionSheet(String title, @CMParamMod(association = AssociationType.ASSOCIATE) UIActionSheetDelegate delegate, String cancelButtonTitle, String destructiveButtonTitle, String... otherButtonTitles) {
        this.title = title;
        this.delegate = delegate;
        this.cancelButtonTitle = cancelButtonTitle;
        this.destructiveButtonTitle = destructiveButtonTitle;

        int nextButton = 0;
        if (destructiveButtonTitle != null)
            destructiveButtonIndex = nextButton++;
        if (otherButtonTitles != null) {
            for (String other : otherButtonTitles)
                if (other != null) {
                    if (firstOtherButtonIndex < 0)
                        firstOtherButtonIndex = nextButton;
                    this.otherButtonIndex.add(nextButton++);
                    this.otherButtonTitles.add(other);
                } else {
                    Native.system().error("Null found in null terminated list - no more entries will be processed", null);
                    break;
                }
        }
        if (cancelButtonTitle != null)
            cancelButtonIndex = nextButton;
    }

    /**
     * Returns the title of this action sheet.
     *
     * @return the title of this action sheet
     */
    @CMGetter("@property(nonatomic, copy) NSString *title;")
    public String title() {
        return title;
    }

    /**
     * Sets the title of this action sheet
     *
     * @param title the new title of this action sheet
     */
    @CMSetter("@property(nonatomic, copy) NSString *title;")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Add a new button to the action sheet
     *
     * @param title the index number of this action sheet
     * @return the new number of buttons
     */
    @CMSelector("- (NSInteger)addButtonWithTitle:(NSString *)title;")
    public int addButtonWithTitle(String title) {
        if (title == null)
            throw new NullPointerException("Button title should not be null");
        int id = numberOfButtons(); // Already increased by 1
        otherButtonTitles.add(title);
        otherButtonIndex.add(id);
        return id;
    }

    /**
     * Returns delegate of this action sheet.
     *
     * @return The delegate of this action sheet.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, weak) id<UIActionSheetDelegate> delegate;")
    public UIActionSheetDelegate delegate() {
        return delegate;
    }

    /**
     * Sets the delegate for this action sheet.
     *
     * @param delegate The delegate for this action sheet.
     */
    @Deprecated
    @CMSetter("@property(nonatomic, weak) id<UIActionSheetDelegate> delegate;")
    public void setDelegate(UIActionSheetDelegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Returns the index of the cancel button.
     *
     * @return The index of the cancel button.
     */
    @Deprecated
    @CMGetter("@property(nonatomic) NSInteger cancelButtonIndex;")
    public int cancelButtonIndex() {
        return cancelButtonIndex;
    }

    /**
     * Returns the index of the destructive button.
     *
     * @return The index of the destructive button.
     */
    @Deprecated
    @CMGetter("@property(nonatomic) NSInteger destructiveButtonIndex;")
    public int destructiveButtonIndex() {
        return destructiveButtonIndex;
    }

    /**
     * Returns the index of the first custom button.
     *
     * @return The index of the first custom button.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, readonly) NSInteger firstOtherButtonIndex;")
    public int firstOtherButtonIndex() {
        return firstOtherButtonIndex;
    }

    /**
     * Returns the number of buttons on the action sheet.
     *
     * @return The number of buttons on the action sheet.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, readonly) NSInteger numberOfButtons;")
    public int numberOfButtons() {
        return otherButtonTitles.size() + (cancelButtonIndex >= 0 ? 1 : 0) + (destructiveButtonIndex >= 0 ? 1 : 0);
    }

    /**
     * Displays an action sheet of the specified tab bar.
     *
     * @param bar The preferred tab bar.
     */
    @Deprecated
    @CMSelector("- (void)showFromTabBar:(UITabBar *)view;")
    public void showFromTabBar(UITabBar bar) {
        show();
    }

    /**
     * Displays an action sheet of the specified toolbar.
     *
     * @param bar The preferred toolbar.
     */
    @Deprecated
    @CMSelector("- (void)showFromToolbar:(UIToolbar *)view;")
    public void showFromToolbar(UIToolbar bar) {
        show();
    }

    /**
     * Displays an action sheet of the specified view.
     *
     * @param view The preferred view.
     */
    @Deprecated
    @CMSelector("- (void)showInView:(UIView *)view;")
    public void showInView(UIView view) {
        show();
    }

    /**
     * Dismisses the action sheet with animation or not.
     *
     * @param buttonIndex The index of the button,
     * @param animated    Defines whether the dismissal will be animated or not.
     */
    @Deprecated
    @CMSelector("- (void)dismissWithClickedButtonIndex:(NSInteger)buttonIndex \n"
            + "                             animated:(BOOL)animated;")
    public void dismissWithClickedButtonIndex(int buttonIndex, boolean animated) {
    }

    private void show() {
        if (delegate != null) {
            delegate.willPresentActionSheet(this);
            delegate.didPresentActionSheet(this);
        }
        Native.system().showActionSheet(title, cancelButtonTitle, destructiveButtonTitle, otherButtonTitles, buttonSelection -> {
            if (delegate == null)
                return;
            int buttonIndex = buttonSelection == CANCEL_ID ? cancelButtonIndex : (
                    buttonSelection == DESTROY_ID ? destructiveButtonIndex :
                            otherButtonIndex.get(buttonSelection));

            if (buttonIndex == CANCEL_ID)
                delegate.cancel(this);
            delegate.willDismissWithButtonIndex(this, buttonIndex);
            if (buttonIndex >= 0)
                delegate.clickedButtonAtIndex(this, buttonIndex);
            delegate.didDismissWithButtonIndex(this, buttonIndex);
        });
    }

}
