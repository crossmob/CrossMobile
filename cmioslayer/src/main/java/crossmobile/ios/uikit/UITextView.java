/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.GraphicsDrill;
import org.crossmobile.bind.wrapper.TextWrapper;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

import java.util.Set;

import static crossmobile.ios.coregraphics.GraphicsDrill.color;
import static crossmobile.ios.coregraphics.GraphicsDrill.context;
import static crossmobile.ios.uikit.cmCommonFonts.getSmallSystemFont;

/**
 * UITextView class defines an object that represents a visible, rectangular
 * area that accepts text.
 */
@CMClass
public class UITextView extends UIView {

    private UITextViewDelegate delegate;
    private int autocapitalizationType = UITextAutocapitalizationType.None;
    //
    private int autocorrectionType = UITextAutocorrectionType.Default;
    private boolean enablesReturnKeyAutomatically = false;
    private int keyboardAppearance = UIKeyboardAppearance.Default;
    private int keyboardType = UIKeyboardType.Default;
    private int returnKeyType = UIReturnKeyType.Default;
    private UIEdgeInsets textContainerInset;
    private long dataDetectorTypes;

    /**
     * Constructs a default UITextView object located at (0,0) with 0 weight and
     * 0 height.
     */
    public UITextView() {
        this(CGRect.zero());
    }

    /**
     * Constructs a UITextView object initialized with the dimensions and
     * position specified in the rect parameter.
     *
     * @param rect CGRect that defines dimension and position of the UITextView.
     */
    @SuppressWarnings({"LeakingThisInConstructor", "unchecked"})
    @CMConstructor("- (instancetype)initWithFrame:(CGRect)frame;")
    public UITextView(CGRect rect) {
        super(rect, UIColor.whiteColor);
        registerWidget(Native.widget().textView(this));
        synchronizeNativeBackgroundColor();
        widget().setFont(GraphicsDrill.font(getSmallSystemFont().cgfont));
    }

    private TextWrapper widget() {
        return (TextWrapper) getWidget();
    }

    /**
     * Returns the text that is displayed on the text view.
     *
     * @return The text displayed on the text view.
     */
    @CMGetter("@property(nonatomic, copy) NSString *text;")
    public String text() {
        return widget().getText();
    }

    /**
     * Sets the text of the text view.
     *
     * @param txt The text displayed on the text view.
     */
    @CMSetter("@property(nonatomic, copy) NSString *text;")
    public void setText(String txt) {
        widget().setText(txt);
        setNeedsDisplay();
    }

    /**
     * Returns the insets of the text view container.
     *
     * @return textContainerInset The insets of the text view container.
     * @see crossmobile.ios.uikit.UIEdgeInsets
     */
    @CMGetter("@property(nonatomic, assign) UIEdgeInsets textContainerInset;")
    public UIEdgeInsets textContainerInset() {
        return textContainerInset;
    }

    /**
     * Sets the insets of the text view container.
     *
     * @param textContainerInset The insets of the text view container.
     * @see crossmobile.ios.uikit.UIEdgeInsets
     */
    @CMSetter("@property(nonatomic, assign) UIEdgeInsets textContainerInset;")
    public void setTextContainerInset(UIEdgeInsets textContainerInset) {
        this.textContainerInset = textContainerInset;
    }

    /**
     * Returns the font of text view content.
     *
     * @return The font of the text view content.
     * @see crossmobile.ios.uikit.UIFont
     */
    @CMGetter("@property(nonatomic, strong) UIFont *font;")
    public UIFont font() {
        return new UIFont(GraphicsDrill.cgfont(widget().getFont()));
    }

    /**
     * Sets the font of the text view content.
     *
     * @param font The font of the text view content.
     * @see crossmobile.ios.uikit.UIFont
     */
    @CMSetter("@property(nonatomic, strong) UIFont *font;")
    public void setFont(UIFont font) {
        widget().setFont(GraphicsDrill.font(font.cgfont));
        setNeedsDisplay();
    }

    /**
     * Returns the color of the text view.
     *
     * @return The color of the text view.
     * @see crossmobile.ios.uikit.UIColor
     */
    @CMGetter("@property(nonatomic, strong) UIColor *textColor;")
    public UIColor textColor() {
        return new UIColor(widget().getTextColor());
    }

    /**
     * Sets the color of the text view.
     *
     * @param color The color of the text view.
     */
    @CMSetter("@property(nonatomic, strong) UIColor *textColor;")
    public void setTextColor(UIColor color) {
        widget().setTextColor(color(color.cgcolor));
        Native.graphics().refreshDisplay();
    }

    /**
     * Returns the text alignment that is used for the content of the text view.
     *
     * @return The text alignment of the content of the text view.
     * @see crossmobile.ios.uikit.UITextAlignment
     */
    @CMGetter("@property(nonatomic) NSTextAlignment textAlignment;")
    public int textAlignment() {
        return widget().getAlignment();
    }

    /**
     * Sets the text alignment for the content of the text view.
     *
     * @param UITextAlignment The text alignment of the content of the text
     *                        view.
     * @see crossmobile.ios.uikit.UITextAlignment
     */
    @CMSetter("@property(nonatomic) NSTextAlignment textAlignment;")
    public void setTextAlignment(int UITextAlignment) {
        widget().setAlignment(UITextAlignment);
    }

    /**
     * Returns the auto-capitalization style that is applied to the text view.
     *
     * @return The auto-capitalization style of the text view.
     * @see crossmobile.ios.uikit.UITextAutocapitalizationType
     */
    @CMGetter("@property(nonatomic) UITextAutocapitalizationType autocapitalizationType")
    public int autocapitalizationType() {
        return autocapitalizationType;
    }

    /**
     * Sets the auto-capitalization style for the text view.
     *
     * @param UITextAutocapitalizationType The auto-capitalization style for the
     *                                     text view.
     * @see crossmobile.ios.uikit.UITextAutocapitalizationType
     */
    @CMSetter("@property(nonatomic) UITextAutocapitalizationType autocapitalizationType")
    public void setAutocapitalizationType(int UITextAutocapitalizationType) {
        this.autocapitalizationType = UITextAutocapitalizationType;
    }

    /**
     * Returns the auto-correction style of the text view.
     *
     * @return The auto-correction style of the text view.
     * @see crossmobile.ios.uikit.UITextAutocorrectionType
     */
    @CMGetter("@property(nonatomic) UITextAutocorrectionType autocorrectionType")
    public int autocorrectionType() {
        return autocorrectionType;
    }

    /**
     * Sets the auto-correction style for the text view.
     *
     * @param UITextAutocorrectionType The auto-correction style for the text
     *                                 view.
     * @see crossmobile.ios.uikit.UITextAutocorrectionType
     */
    @CMSetter("@property(nonatomic) UITextAutocorrectionType autocorrectionType")
    public void setAutocorrectionType(int UITextAutocorrectionType) {
        this.autocorrectionType = UITextAutocorrectionType;
    }

    /**
     * Returns the keyboard style of the text view.
     *
     * @return The keyboard style of the text view.
     * @see crossmobile.ios.uikit.UIKeyboardType
     */
    @CMGetter("@property(nonatomic) UIKeyboardType keyboardType")
    public int keyboardType() {
        return keyboardType;
    }

    /**
     * Sets the keyboard style for the text view.
     *
     * @param UIKeyboardType The keyboard style for the text view.
     * @see crossmobile.ios.uikit.UIKeyboardType
     */
    @CMSetter("@property(nonatomic) UIKeyboardType keyboardType")
    public void setKeyboardType(int UIKeyboardType) {
        this.keyboardType = UIKeyboardType;
    }

    /**
     * Returns a Boolean that shows whether the return key of the text view is
     * automatically enabled or not.
     *
     * @return A Boolean that shows whether the return key of the text view is
     * automatically enabled or not.
     */
    @CMGetter("@property(nonatomic) BOOL enablesReturnKeyAutomatically")
    public boolean enablesReturnKeyAutomatically() {
        return enablesReturnKeyAutomatically;
    }

    /**
     * Sets a Boolean that defines whether the return key of the text view is
     * automatically enabled or not.
     *
     * @param enablesReturnKeyAutomatically A Boolean that defines whether the
     *                                      return key of the text view is automatically enabled or not.
     */
    @CMSetter("@property(nonatomic) BOOL enablesReturnKeyAutomatically")
    public void setEnablesReturnKeyAutomatically(boolean enablesReturnKeyAutomatically) {
        this.enablesReturnKeyAutomatically = enablesReturnKeyAutomatically;
    }

    /**
     * Returns an integer that represents keyboard style used by the text view.
     *
     * @return The appearance style of the keyboard that is used by the text
     * view.
     * @see crossmobile.ios.uikit.UIKeyboardAppearance
     */
    @CMGetter("@property(nonatomic) UIKeyboardAppearance keyboardAppearance")
    public int keyboardAppearance() {
        return keyboardAppearance;
    }

    /**
     * Sets the appearance of the keyboard that is used by the text view.
     *
     * @param UIKeyboardAppearance The appearance style of the keyboard that is
     *                             used by the text view.
     * @see crossmobile.ios.uikit.UIKeyboardAppearance
     */
    @CMSetter("@property(nonatomic) UIKeyboardAppearance keyboardAppearance")
    public void setKeyboardAppearance(int UIKeyboardAppearance) {
        this.keyboardAppearance = UIKeyboardAppearance;
    }

    /**
     * Returns an integer that corresponds to the text on the return key.
     *
     * @return The text on the return key.
     * @see crossmobile.ios.uikit.UIReturnKeyType
     */
    @CMGetter("@property(nonatomic) UIReturnKeyType returnKeyType")
    public int returnKeyType() {
        return returnKeyType;
    }

    /**
     * Sets the text that is displayed on the return key.
     *
     * @param UIReturnKeyType The text displaye on the return key.
     * @see crossmobile.ios.uikit.UIReturnKeyType
     */
    @CMSetter("@property(nonatomic) UIReturnKeyType returnKeyType")
    public void setReturnKeyType(int UIReturnKeyType) {
        this.returnKeyType = UIReturnKeyType;
    }

    /**
     * Returns a Boolean that show whether the text view hides or not the text
     * that is being entered.
     *
     * @return A Boolean that show whether the text view hides or not the text
     * that is being entered.
     */
    @CMGetter("@property(nonatomic, getter=isSecureTextEntry) BOOL secureTextEntry")
    public boolean isSecureTextEntry() {
        return widget().isSecure();
    }

    /**
     * Sets a Boolean value that defines whether the text view hides the text
     * that is entered.
     *
     * @param secureTextEntry A Boolean value that defines whether the text view
     *                        hides the text that is entered.
     */
    @CMSetter("@property(nonatomic, getter=isSecureTextEntry) BOOL secureTextEntry")
    public void setSecureTextEntry(boolean secureTextEntry) {
        widget().setSecure(secureTextEntry);
        Native.graphics().refreshDisplay();
    }

    /**
     * Returns a Boolean value that shows whether the text view is editable or
     * not.
     *
     * @return A Boolean value that shows whether the text view is editable or
     * not.
     */
    @CMGetter("@property(nonatomic, getter=isEditable) BOOL editable;")
    public boolean isEditable() {
        return widget().isEditable();
    }

    /**
     * Sets a Boolean value that defines whether the text view is editable or
     * not.
     *
     * @param editable A Boolean that defines whether the text view is editable
     *                 or not.
     */
    @CMSetter("@property(nonatomic, getter=isEditable) BOOL editable;")
    public void setEditable(boolean editable) {
        widget().setEditable(editable);
        Native.graphics().refreshDisplay();
    }

    @Override
    public void setBackgroundColor(UIColor background) {
        super.setBackgroundColor(background);
        synchronizeNativeBackgroundColor();
    }

    private void synchronizeNativeBackgroundColor() {
        UIColor backCol = backgroundColor();
        if (backCol != null)
            widget().setBackgroundColor(GraphicsDrill.color(backCol.cgcolor));
    }

    /**
     * Sets the receiver's delegate.
     *
     * @param delegate The receiver’s delegate.
     */
    @CMSetter("@property(nonatomic, weak) id<UITextViewDelegate> delegate;")
    public void setDelegate(UITextViewDelegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Returns the delegate of the receiver.
     *
     * @return The receiver’s delegate.
     */
    @CMGetter("@property(nonatomic, weak) id<UITextViewDelegate> delegate;")
    public UITextViewDelegate delegate() {
        return delegate;
    }

    /**
     * Returns the types of data that are viewed as clickable URLs in the text
     * view content.
     *
     * @return The types of data that will be viewed as clickable URLs. content.
     */
    @CMGetter("@property(nonatomic) UIDataDetectorTypes dataDetectorTypes;")
    public long dataDetectorTypes() {
        return dataDetectorTypes;
    }

    /**
     * Sets the types of data that will be viewed as clickable URLs in the text
     * view content.
     *
     * @param dataDetectorTypes The types of data that will be viewed as
     *                          clickable URLs.
     */
    @CMSetter("@property(nonatomic) UIDataDetectorTypes dataDetectorTypes;")
    public void setDataDetectorTypes(long dataDetectorTypes) {
        this.dataDetectorTypes = dataDetectorTypes;
    }

    @Override
    public boolean resignFirstResponder() {
        if (!isFirstResponder()
                || (delegate != null && (!delegate.shouldEndEditing(this)))
                || !super.resignFirstResponder())
            return false;

        Native.widget().resignFocus();

        if (delegate != null)
            delegate.didEndEditing(this);
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean becomeFirstResponder() {
        if (isFirstResponder()
                || (delegate != null && (!delegate.shouldBeginEditing(this)))
                || !super.becomeFirstResponder())
            return false;

        Native.widget().requestFocus(widget().getNativeWidget());

        if (delegate != null)
            delegate.didBeginEditing(this);
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
        if (getWidget() != null)
            getWidget().draw(context(UIGraphics.getCurrentContext()));
    }

}
