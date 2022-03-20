/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGRect;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * UIAlertView class defines view objects that are used in order to display an
 * alert to the user.
 *
 * This object is deprecated, please use UIAlertController with UIAlertControllerStyle.Alert instead.
 * @see UIAlertController
 * @see UIAlertControllerStyle#Alert
 */
@Deprecated
@CMClass
public class UIAlertView extends UIView {

    private UIAlertViewDelegate delegate;
    private String title;
    private String message;
    private final List<String> buttons;
    private int alertViewStyle;
    private UITextField tf1;
    private UITextField tf2;

    /**
     * A convenient method for initializing an alert view.
     *
     * @param title             The string that appears in the receiver’s title bar.
     * @param message           Descriptive text that provides more details than the
     *                          title.
     * @param delegate          The receiver’s delegate or NULL if it doesn’t have a
     *                          delegate.
     * @param cancelButtonTitle The title of the cancel button or null if there
     *                          is no cancel button.
     * @param otherButtonTitles The title of another button.
     */
    @Deprecated
    @CMConstructor("- (instancetype)initWithTitle:(NSString *)title \n"
            + "                      message:(NSString *)message \n"
            + "                     delegate:(id)delegate \n"
            + "            cancelButtonTitle:(NSString *)cancelButtonTitle \n"
            + "            otherButtonTitles:(NSString *)otherButtonTitles, ...;")
    public UIAlertView(String title, String message, @CMParamMod(association = AssociationType.ASSOCIATE) UIAlertViewDelegate delegate, String cancelButtonTitle, String... otherButtonTitles) {
        this.title = title;
        this.message = message;
        this.delegate = delegate;
        this.alertViewStyle = UIAlertViewStyle.Default;
        buttons = new ArrayList<>();
        if (cancelButtonTitle != null)
            buttons.add(cancelButtonTitle);
        if (otherButtonTitles != null)
            buttons.addAll(Arrays.asList(otherButtonTitles));
    }

    /**
     * Sets the delegate for this alert view.
     *
     * @param delegate The delegate for this alert view.
     * @see crossmobile.ios.uikit.UIAlertViewDelegate
     */
    @Deprecated
    @CMSetter("@property(nonatomic, weak) id delegate;")
    public void setDelegate(UIAlertViewDelegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Returns the delegate of this alert view. It returns null if there is not
     * delegate.
     *
     * @return The delegate of this alert view.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, weak) id delegate;")
    public UIAlertViewDelegate delegate() {
        return delegate;
    }

    /**
     * Displays the alert view using animation.
     */
    @CMSelector("- (void)show;")
    public void show() {
        String showTitle, showMessage;
        if (message == null || message.length() == 0) {
            showTitle = "";
            showMessage = title;
        } else {
            showTitle = title;
            showMessage = message;
        }
        Native.system().showAlert(this, showTitle, showMessage, buttons, delegate);
    }

    /**
     * Sets the title of this object.
     *
     * @param title The title of this object.
     */
    @Deprecated
    @CMSetter("@property(nonatomic, copy) NSString *title;")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the title of this object.
     *
     * @return The string that contains the title.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, copy) NSString *title;")
    public String title() {
        return title;
    }

    /**
     * Inserts the specified text into the text field below the title. This text
     * contains more information than the title.
     *
     * @param message The text to be inserted into the text field below the
     *                title.
     */
    @Deprecated
    @CMSetter("@property(nonatomic, copy) NSString *message;")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Returns the text field below the title of the alert view that contains
     * the detailed information.
     *
     * @return The detailed text field below the title.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, copy) NSString *message;")
    public String message() {
        return message;
    }

    /**
     * Adds a button with the specified title to this object.
     *
     * @param title The title of the button.
     * @return The index of the button.
     */
    @Deprecated
    @CMSelector("- (NSInteger)addButtonWithTitle:(NSString *)title;")
    public int addButtonWithTitle(String title) {
        buttons.add(title);
        return buttons.size() - 1;
    }

    /**
     * Returns the text field at the given index.
     *
     * @param index The index of the text field. Text field starts at 0.
     * @return Thee text field at the given index.
     * @see crossmobile.ios.uikit.UITextField
     */
    @Deprecated
    @CMSelector("- (UITextField *)textFieldAtIndex:(NSInteger)textFieldIndex;")
    public UITextField textFieldAtIndex(int index) {
        switch (index) {
            case 0:
                return tf1;
            case 1:
                return tf2;
            default:
                return null;
        }
    }

    /**
     * Returns an integer that represents the style of the alert view.
     *
     * @return The integer that represents the style of the alert view.
     * @see crossmobile.ios.uikit.UIAlertViewStyle
     */
    @Deprecated
    @CMGetter("@property(nonatomic, assign) UIAlertViewStyle alertViewStyle;")
    public int alertViewStyle() {
        return alertViewStyle;
    }

    /**
     * Sets an integer that represents the style of the alert view.
     *
     * @param UIAlertViewStyle The kind of alert displayed to the user.
     * @see crossmobile.ios.uikit.UIAlertViewStyle
     */
    @Deprecated
    @CMSetter("@property(nonatomic, assign) UIAlertViewStyle alertViewStyle;")
    public void setAlertViewStyle(int UIAlertViewStyle) {
        this.alertViewStyle = UIAlertViewStyle;
        switch (UIAlertViewStyle) {
            case crossmobile.ios.uikit.UIAlertViewStyle.Default:
                tf1 = null;
                tf2 = null;
                break;
            case crossmobile.ios.uikit.UIAlertViewStyle.PlainTextInput:
                tf1 = constructTextField(false);
                tf2 = null;
                break;
            case crossmobile.ios.uikit.UIAlertViewStyle.SecureTextInput:
                tf1 = constructTextField(true);
                tf2 = null;
                break;
            case crossmobile.ios.uikit.UIAlertViewStyle.LoginAndPasswordInput:
                tf1 = constructTextField(false);
                tf2 = constructTextField(true);
                break;
        }
    }

    private UITextField constructTextField(boolean isSecure) {
        UITextField t = new UITextField();
        if (isSecure)
            t.setSecureTextEntry(true);
        return t;
    }
}
