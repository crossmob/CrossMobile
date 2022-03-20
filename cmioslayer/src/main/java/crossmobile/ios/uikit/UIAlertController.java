/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;
import org.robovm.objc.block.VoidBlock1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * UIAlertController class defines an object that displays an alert message to
 * the user.
 */
@SuppressWarnings("deprecation")
@CMClass
public class UIAlertController extends UIViewController {

    private final List<UIAlertAction> actions = new ArrayList<>();
    private final List<UITextField> textFields = new ArrayList<>();
    private String message;
    private int style;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    private UIAlertController(String title, String message, int UIAlertControllerStyle) {
        UIView view = new UIView();
        setView(view);
        setTitle(title);
        this.message = message;
        this.style = UIAlertControllerStyle;
    }

    /**
     * Constructs an alert controller with the specified parameters.
     *
     * @param title                  The title of the alert.
     * @param message                The text with details of the alert purpose.
     * @param UIAlertControllerStyle The style of the alert controller.
     * @return The new alert controller.
     * @see crossmobile.ios.uikit.UIAlertControllerStyle
     */
    @CMSelector("+ (instancetype)alertControllerWithTitle:(NSString *)title \n"
            + "                                 message:(NSString *)message \n"
            + "                          preferredStyle:(UIAlertControllerStyle)preferredStyle;")
    public static UIAlertController alertControllerWithTitle(String title, String message, int UIAlertControllerStyle) {
        return new UIAlertController(title, message, UIAlertControllerStyle);
    }

    /**
     * Returns a text that contains the details of the alert purpose.
     *
     * @return A String that contains the details of the alert purpose.
     */
    @CMGetter("@property(nonatomic, copy) NSString *message;")
    public String message() {
        return message;
    }

    /**
     * Sets a text that contains the details of the alert purpose.
     *
     * @param message The String with the details of the alert purpose.
     */
    @CMSetter("@property(nonatomic, copy) NSString *message;")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Returns the style of alert controller.
     *
     * @return The style of the alert controller.
     */
    @CMGetter("@property(nonatomic, readonly) UIAlertControllerStyle preferredStyle;")
    public int preferredStyle() {
        return style;
    }

    /**
     * Adds an action to the alert or the action sheet.
     *
     * @param action The action to be added to the alert or the action sheet.
     */
    @CMSelector("- (void)addAction:(UIAlertAction *)action;")
    public void addAction(UIAlertAction action) {
        actions.add(action);
    }

    /**
     * Returns a list of actions that this alert provides to the user.
     *
     * @return The list of actions that this alert provides to the user.
     */
    @CMGetter("@property(nonatomic, readonly) NSArray<UIAlertAction *> *actions;")
    public List<UIAlertAction> actions() {
        return actions;
    }

    /**
     * Used in order to adds a text field to an alert. Repeated use add more
     * text fields.
     *
     * @param configurationHandler A block use for the configuration of the text
     *                             field before being displayed to the alert.
     */
    @CMSelector("- (void)addTextFieldWithConfigurationHandler:(void (^)(UITextField *textField))configurationHandler;")
    public void addTextFieldWithConfigurationHandler(VoidBlock1<UITextField> configurationHandler) {
        if (style != UIAlertControllerStyle.Alert)
            throw new RuntimeException("You can add a text field only if the preferredStyle property is set to UIAlertControllerStyle.Alert.");
        UITextField tf = new UITextField();
        if (configurationHandler != null)
            configurationHandler.invoke(tf);
        textFields.add(tf);
    }

    /**
     * Returns an array of text fields that are displayed by this alert.
     *
     * @return The array of text fields that are displayed by this alert.
     */
    @CMGetter("@property(nonatomic, readonly) NSArray<UITextField *> *textFields;")
    public List<UITextField> textFields() {
        return Collections.unmodifiableList(textFields);
    }

    @Override
    public void viewWillAppear(boolean animated) {
        super.viewWillAppear(animated);
        if (style == UIAlertControllerStyle.Alert) {
            UIAlertView alert = new UIAlertView(title(), message, new UIAlertViewDelegate() {
                @Override
                public void clickedButtonAtIndex(UIAlertView alertView, int buttonIndex) {
                    UIAlertAction action = actions.get(buttonIndex);
                    if (action != null && action.handler != null)
                        action.handler.invoke(action);
                }
            }, null);
            for (UIAlertAction action : actions)
                alert.addButtonWithTitle(action.title());
            alert.show();
        } else if (style == UIAlertControllerStyle.Sheet) {
            String[] actionLabels = new String[this.actions.size()];
            for (int i = 0; i < this.actions.size(); i++)
                actionLabels[i] = this.actions.get(i).title();
            new UIActionSheet(title(), new UIActionSheetDelegate() {
                @Override
                public void clickedButtonAtIndex(UIActionSheet actionSheet, int buttonIndex) {
                    UIAlertAction action = actions.get(buttonIndex);
                    if (action != null && action.handler != null)
                        action.handler.invoke(action);
                }
            }, null, null, actionLabels)
                    .showInView(null);
        }
    }

}
