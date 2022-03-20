/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.GraphicsDrill;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bind.wrapper.TextWrapper;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;
import org.crossmobile.bridge.system.BaseUtils;

import java.util.Set;

import static crossmobile.ios.coregraphics.GraphicsDrill.*;
import static crossmobile.ios.uikit.cmCommonFonts.getLabelFont;

/**
 * UITextField class defines an object that represents a visible text area that
 * is editable.
 */
@SuppressWarnings({"FieldMayBeFinal", "unchecked"})
@CMClass
public class UITextField extends UIControl implements UITextInputTraits {

    private int autocapitalizationType = UITextAutocapitalizationType.Sentences;
    private int autocorrectionType = UITextAutocorrectionType.Default;
    private int spellCheckingType = UITextSpellCheckingType.Default;
    private int smartQuotesType = UITextSmartQuotesType.Default;
    private int smartDashesType = UITextSmartDashesType.Default;
    private int smartInsertDeleteType = UITextSmartInsertDeleteType.Default;
    private int keyboardType = UIKeyboardType.Default;
    private int keyboardAppearance = UIKeyboardAppearance.Default;
    private int returnKeyType = UIReturnKeyType.Default;
    private boolean enablesReturnKeyAutomatically = false;
    private boolean isSecureTextEntry = false;
    private String textContentType = null;

    private int borderStyle = UITextBorderStyle.RoundedRect;
    private UITextFieldDelegate delegate;
    private boolean adjustsFontSizeToFitWidth = false;

    private UIView viewForLastBaselineLayout;
    private UIView viewForFirstBaselineLayout;

    /**
     * Constructs a default UITextField object located at (0,0) with 0 weight
     * and 0 height.
     */
    public UITextField() {
        this(CGRect.zero());
    }

    /**
     * Constructor for UITextField A UITextField object is a control that
     * displays editable text and sends an action message to a target object
     * when the user presses the return button.
     *
     * @param rect describes the location and size of UITextField
     */
    @SuppressWarnings({"LeakingThisInConstructor", "OverridableMethodCallInConstructor"})
    @CMConstructor("- (instancetype)initWithFrame:(CGRect)frame;")
    public UITextField(CGRect rect) {
        super(rect);
        registerWidget(Native.widget().textField(this));
        widget().setFont(GraphicsDrill.font(getLabelFont().cgfont));
        setBorderStyle(UITextBorderStyle.None);
    }

    private TextWrapper widget() {
        return (TextWrapper) getWidget();
    }

    @Override
    public int autocapitalizationType() {
        return autocapitalizationType;
    }

    @Override
    public void setAutocapitalizationType(int UITextAutocapitalizationType) {
        this.autocapitalizationType = UITextAutocapitalizationType;
    }

    @Override
    public int autocorrectionType() {
        return autocorrectionType;
    }

    @Override
    public void setAutocorrectionType(int UITextAutocorrectionType) {
        this.autocorrectionType = UITextAutocorrectionType;
    }

    @Override
    public boolean enablesReturnKeyAutomatically() {
        return enablesReturnKeyAutomatically;
    }

    @Override
    public void setEnablesReturnKeyAutomatically(boolean enablesReturnKeyAutomatically) {
        this.enablesReturnKeyAutomatically = enablesReturnKeyAutomatically;
    }

    @Override
    public int keyboardAppearance() {
        return keyboardAppearance;
    }

    @Override
    public void setKeyboardAppearance(int UIKeyboardAppearance) {
        this.keyboardAppearance = UIKeyboardAppearance;
    }

    @Override
    public int keyboardType() {
        return keyboardType;
    }

    @Override
    public void setKeyboardType(int UIKeyboardType) {
        this.keyboardType = UIKeyboardType;
    }

    @Override
    public int returnKeyType() {
        return returnKeyType;
    }

    @Override
    public void setReturnKeyType(int UIReturnKeyType) {
        this.returnKeyType = UIReturnKeyType;
    }

    @Override
    public boolean isSecureTextEntry() {
        return widget().isSecure();
    }

    @Override
    public void setSecureTextEntry(boolean secureTextEntry) {
        widget().setSecure(secureTextEntry);
        setNeedsDisplay();
    }

    @Override
    public String textContentType() {
        return textContentType;
    }

    @Override
    public void setTextContentType(String textContentType) {
        this.textContentType = textContentType;
    }

    /**
     * Returns the text that is displayed on this text field.
     *
     * @return The text displayed on the text field.
     */
    @CMGetter("@property(nonatomic, copy) NSString *text;")
    public String text() {
        return widget().getText();
    }

    /**
     * Sets the text to be displayed on this text field.
     *
     * @param text The text to be displayed on this text field.
     */
    @CMSetter("@property(nonatomic, copy) NSString *text;")
    public void setText(String text) {
        if (!BaseUtils.equals(text, widget().getText()))
            Native.lifecycle().runOnEventThread(() -> {
                widget().setText(text);
                setNeedsDisplay();
            });
    }

    /**
     * Returns the text color of this text field.
     *
     * @return The text color of this text field.
     */
    @CMGetter("@property(nonatomic, strong) UIColor *textColor;")
    public UIColor textColor() {
        return new UIColor(widget().getTextColor());
    }

    /**
     * Sets the text color for this text field.
     *
     * @param color The text color for this text field.
     */
    @CMSetter("@property(nonatomic, strong) UIColor *textColor;")
    public void setTextColor(UIColor color) {
        widget().setTextColor(color(color.cgcolor));
        setNeedsDisplay();
    }

    /**
     * Returns border style of this text field.
     *
     * @return The border style of this text field.
     * @see crossmobile.ios.uikit.UITextBorderStyle
     */
    @CMGetter("@property(nonatomic) UITextBorderStyle borderStyle;")
    public int borderStyle() {
        return borderStyle;
    }

    /**
     * Sets the border style for this text field.
     *
     * @param UITextBorderStyle The border style for this text field.
     * @see crossmobile.ios.uikit.UITextBorderStyle
     */
    @CMSetter("@property(nonatomic) UITextBorderStyle borderStyle;")
    public void setBorderStyle(int UITextBorderStyle) {
        this.borderStyle = UITextBorderStyle;
        widget().drawNativeBorder(this.borderStyle == crossmobile.ios.uikit.UITextBorderStyle.RoundedRect);
    }

    /**
     * Returns font of this text field.
     *
     * @return The font of this text field.
     */
    @CMGetter("@property(nonatomic, strong) UIFont *font;")
    public UIFont font() {
        return new UIFont(cgfont(widget().getFont()));
    }

    /**
     * Sets the font of this text field.
     *
     * @param font The font of this text field.
     */
    @CMSetter("@property(nonatomic, strong) UIFont *font;")
    public void setFont(UIFont font) {
        widget().setFont(GraphicsDrill.font(font.cgfont));
        setNeedsDisplay();
    }

    /**
     * Returns a Boolean that shows whether the font size is adjusted to fit the
     * size of this text field.
     *
     * @return A Boolean that defines whether the font size should adjust to fit
     * the size of this text field.
     */
    @CMGetter("@property(nonatomic) BOOL adjustsFontSizeToFitWidth;")
    public boolean adjustsFontSizeToFitWidth() {
        return adjustsFontSizeToFitWidth;
    }

    /**
     * Set a Boolean that defines whether the font size should adjust to fit the
     * size of this text field.
     *
     * @param adjustsFontSizeToFitWidth A Boolean that defines whether the font
     *                                  size should adjust to fit the size of this text field.
     */
    @CMSetter("@property(nonatomic) BOOL adjustsFontSizeToFitWidth;")
    public void setAdjustsFontSizeToFitWidth(boolean adjustsFontSizeToFitWidth) {
        this.adjustsFontSizeToFitWidth = adjustsFontSizeToFitWidth;
    }

    /**
     * Returns the text alignment of this text field.
     *
     * @return The technique of this text field.
     * @see crossmobile.ios.uikit.UITextAlignment
     */
    @CMGetter("@property(nonatomic) NSTextAlignment textAlignment;\n"
            + "")
    public int textAlignment() {
        return widget().getAlignment();
    }

    /**
     * Set the text alignment for this text field.
     *
     * @param UITextAlignment The text alignment for this text field.
     * @see crossmobile.ios.uikit.UITextAlignment
     */
    @CMSetter("@property(nonatomic) NSTextAlignment textAlignment;\n"
            + "")
    public void setTextAlignment(int UITextAlignment) {
        widget().setAlignment(UITextAlignment);
    }

    /**
     * Sets the text to be displayed when there is no text inserted in this text
     * field.
     *
     * @param placeholder The text to be displayed when there is no text
     *                    inserted in this text field.
     */
    @CMSetter("@property(nonatomic, copy) NSString *placeholder;")
    public void setPlaceholder(String placeholder) {
        if (!BaseUtils.equals(placeholder, widget().getPlaceholder()))
            widget().setPlaceholder(placeholder);
    }

    /**
     * Returns the text that is displayed when there is no text inserted in this
     * text field.
     *
     * @return The text that is displayed when there is no text inserted in this
     * text field.
     */
    @CMGetter("@property(nonatomic, copy) NSString *placeholder;")
    public String placeholder() {
        return widget().getPlaceholder();
    }

    /**
     * Sets the delegate for this text field.
     *
     * @param delegate The delegate for this text field.
     */
    @CMSetter("@property(nonatomic, weak) id<UITextFieldDelegate> delegate;")
    public void setDelegate(UITextFieldDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public void setBackgroundColor(UIColor background) {
        super.setBackgroundColor(background);
        widget().setBackgroundColor(color(background.cgcolor));
    }

    /**
     * Returns the delegate of this text field.
     *
     * @return The delegate of this text field.
     */
    @CMGetter("@property(nonatomic, weak) id<UITextFieldDelegate> delegate;")
    public UITextFieldDelegate delegate() {
        return delegate;
    }

    @Override
    public boolean resignFirstResponder() {
        if (!isFirstResponder()
                || (delegate != null && (!delegate.shouldEndEditing(this)))
                || !super.resignFirstResponder())
            return false;

        Native.widget().resignFocus();
        return false;
    }

    @Override
    public boolean becomeFirstResponder() {
        if (isFirstResponder()
                || (delegate != null && (!delegate.shouldBeginEditing(this)))
                || !super.becomeFirstResponder())
            return false;

        Native.widget().requestFocus(widget().getNativeWidget());
        return true;
    }

    @Override
    public void touchesBegan(Set<UITouch> touches, UIEvent event) {
        if (becomeFirstResponder())
            widget().sendHardwareTouches(event.originalEvent, event.getTouches(this));
    }

    @Override
    public void touchesMoved(Set<UITouch> touches, UIEvent event) {
        if (isFirstResponder())
            widget().sendHardwareTouches(event.originalEvent, event.getTouches(this));
    }

    @Override
    public void touchesEnded(Set<UITouch> touches, UIEvent event) {
        if (isFirstResponder())
            widget().sendHardwareTouches(event.originalEvent, event.getTouches(this));
    }

    @Override
    public void touchesCancelled(Set<UITouch> touches, UIEvent event) {
        widget().sendHardwareTouches(event.originalEvent, event.getTouches(this));
    }

    @Override
    public final void drawRect(CGRect rect) {
        if (getWidget() != null) {
            GraphicsContext<?> cxt = context(UIGraphics.getCurrentContext());
            if (borderStyle == UITextBorderStyle.Line || borderStyle == UITextBorderStyle.Bezel) {
                cxt.setFillColorWithColor(0xFF000000);
                cxt.drawRect(rect.getOrigin().getX(), rect.getOrigin().getY(), rect.getSize().getWidth(), rect.getSize().getHeight());
            }
            getWidget().draw(cxt);
        }
    }
}
