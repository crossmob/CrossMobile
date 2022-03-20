/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGContext;
import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.CGSize;
import crossmobile.ios.foundation.NSRange;
import org.crossmobile.bind.graphics.Theme;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import java.util.List;

import static crossmobile.ios.uikit.UISearchBarIcon.ITEM_COUNT;

/**
 * UISearchBar class defines an object that handles text based searches.
 * Visually it consists of a field for text of the query and basic functional
 * buttons search,cancel and bookmark.
 */
@CMClass
public class UISearchBar extends UIView {

    private final static UIImage[] iconNormal = new UIImage[ITEM_COUNT];
    private final static UIImage[] iconDisabled = new UIImage[ITEM_COUNT];
    private final float cancelSize = 80;

    private final UITextField field;
    private UIButton cancel;

    private String prompt;
    private int barStyle;
    private int searchBarStyle;
    private UIColor barTintColor;
    private boolean translucent;
    private boolean showsBookmarkButton;
    private UISearchBarDelegate delegate;
    private boolean showsScopeBar;
    private int selectedScopeButtonIndex;
    private List<String> scopeButtonTitles;

    /**
     * Constructs a default UISearchBar object located at (0,0) with 0 weight
     * and 0 height.
     */
    public UISearchBar() {
        this(CGRect.zero());
    }

    /**
     * Constructs a UISearchBar object initialized with the dimensions and
     * position specified in the rect parameter.
     *
     * @param rect CGRect that defines dimension and position of UISearchBar
     */
    @CMConstructor("- (instancetype)initWithFrame:(CGRect)frame;")
    public UISearchBar(CGRect rect) {
        super(rect);
        field = new UITextField(new CGRect(0, 0, rect.getSize().getWidth(), rect.getSize().getHeight()));
        field.setAutoresizingMask(UIViewAutoresizing.FlexibleHeight | UIViewAutoresizing.FlexibleWidth);
        field.setDelegate(new UITextFieldDelegate() {

            @Override
            public void didBeginEditing(UITextField textField) {
                if (delegate != null)
                    delegate.textDidBeginEditing(UISearchBar.this);
            }

            @Override
            public void didEndEditing(UITextField textField) {
                if (delegate != null)
                    delegate.textDidEndEditing(UISearchBar.this);
            }

            @Override
            public boolean shouldBeginEditing(UITextField textField) {
                if (delegate != null)
                    return delegate.shouldBeginEditing(UISearchBar.this);
                else
                    return true;
            }

            @Override
            public boolean shouldEndEditing(UITextField textField) {
                if (delegate != null)
                    return delegate.shouldEndEditing(UISearchBar.this);
                else
                    return true;
            }

            @Override
            public boolean shouldChangeCharactersInRange(UITextField textField, NSRange range, String replacementString) {
                if (delegate != null)
                    delegate.textDidChange(UISearchBar.this, field.text());
                return true;
            }
        });
        addSubview(field);
    }

    /**
     * Returns the type of autocapitalization that is set for this text field.
     *
     * @return Integer that defines type of autocapitalization.
     * @see crossmobile.ios.uikit.UITextAutocapitalizationType
     */
    @CMGetter(" @property(nonatomic) UITextAutocapitalizationType autocapitalizationType ")
    public int autocapitalizationType() {
        return field.autocapitalizationType();
    }

    /**
     * Sets the type of autocapitalization that will be applied to the text
     * field specified by the value of UITextAutocapitalizationType.
     *
     * @param UITextAutocapitalizationType Defines type of autocapitalization.
     * @see crossmobile.ios.uikit.UITextAutocapitalizationType
     */
    @CMSetter(" @property(nonatomic) UITextAutocapitalizationType autocapitalizationType ")
    public void setAutocapitalizationType(int UITextAutocapitalizationType) {
        field.setAutocorrectionType(UITextAutocapitalizationType);
    }

    /**
     * Returns the type of autocorrection that is set for this text field.
     *
     * @return Integer that defines type of autocorrection.
     * @see crossmobile.ios.uikit.UITextAutocorrectionType
     */
    @CMGetter(" @property(nonatomic) UITextAutocorrectionType autocorrectionType ")
    public int autocorrectionType() {
        return field.autocorrectionType();
    }

    /**
     * Sets the type of autocorrection that will be applied to the text field
     * specified by the value of UITextAutocorrectionType.
     *
     * @param UITextAutocorrectionType Defines the type of autocorrection.
     * @see crossmobile.ios.uikit.UITextAutocorrectionType
     */
    @CMSetter(" @property(nonatomic) UITextAutocorrectionType autocorrectionType ")
    public void setAutocorrectionType(int UITextAutocorrectionType) {
        field.setAutocorrectionType(UITextAutocorrectionType);
    }

    /**
     * Returns the type of this search bar.
     *
     * @return Integer that defines the style type of this search bar.
     * @see crossmobile.ios.uikit.UIBarStyle
     */
    @CMGetter("@property(nonatomic) UIBarStyle barStyle;")
    public int barStyle() {
        return barStyle;
    }

    /**
     * Sets style of this search bar.
     *
     * @param UIBarStyle Defines the type of style.
     * @see crossmobile.ios.uikit.UIBarStyle
     */
    @CMSetter("@property(nonatomic) UIBarStyle barStyle;")
    public void setBarStyle(int UIBarStyle) {
        this.barStyle = UIBarStyle;
    }

    /**
     * Returns the style of this background of the search bar.
     *
     * @return A flag that shows whether this search bar has background or not.
     * @see crossmobile.ios.uikit.UISearchBarStyle
     */
    @CMGetter("@property(nonatomic) UISearchBarStyle searchBarStyle;")
    public int searchBarStyle() {
        return searchBarStyle;
    }

    /**
     * Set the background style of this search bar.
     *
     * @param UISearchBarStyle Defines the background style of this search bar.
     * @see crossmobile.ios.uikit.UISearchBarStyle
     */
    @CMSetter("@property(nonatomic) UISearchBarStyle searchBarStyle;")
    public void setSearchBarStyle(int UISearchBarStyle) {
        this.searchBarStyle = UISearchBarStyle;
    }

    /**
     * Returns the delegate object of this search bar that is the object
     * responsible for search bar's functionality.
     *
     * @return A UISearchBarDelegate object.
     */
    @CMGetter("@property(nonatomic, weak) id<UISearchBarDelegate> delegate;")
    public UISearchBarDelegate delegate() {
        return delegate;
    }

    /**
     * Sets the image for a given search bar icon type and control state of this
     * search bar.
     *
     * @param iconImage       The image of the search bar.
     * @param UISearchBarIcon The icon type for which the image is set.
     * @param UIControlState  The state of the search bar.
     * @see crossmobile.ios.uikit.UISearchBarIcon
     * @see crossmobile.ios.uikit.UIControlState
     */
    @CMSelector("- (void)setImage:(UIImage *)iconImage \n"
            + "forSearchBarIcon:(UISearchBarIcon)icon \n"
            + "           state:(UIControlState)state;")
    public void setImage(UIImage iconImage, int UISearchBarIcon, int UIControlState) {
        if (UISearchBarIcon < 0 || UISearchBarIcon >= ITEM_COUNT)
            return;
        if ((UIControlState & crossmobile.ios.uikit.UIControlState.Disabled) != 0)
            iconDisabled[UISearchBarIcon] = iconImage;
        else
            iconNormal[UISearchBarIcon] = iconImage;
    }

    /**
     * Sets the delegate object for this search bar,the object responsible for
     * search bar's functionality.
     *
     * @param delegate Delegate object.
     */
    @CMSetter("@property(nonatomic, weak) id<UISearchBarDelegate> delegate;")
    public void setDelegate(UISearchBarDelegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Returns the keyboard type of the text field of this search bar.
     *
     * @return Integer that defines the type of keyboard.
     */
    @CMGetter(" @property(nonatomic) UIKeyboardType keyboardType ")
    public int keyboardType() {
        return field.keyboardType();
    }

    /**
     * Sets the type of keyboard for the text field of the search bar.
     *
     * @param UIKeyboardType Defines the type of keyboard of the text field.
     */
    @CMSetter(" @property(nonatomic) UIKeyboardType keyboardType ")
    public void setKeyboardType(int UIKeyboardType) {
        field.setKeyboardType(UIKeyboardType);
    }

    /**
     * Returns the String that is displayed when there is no other text in the
     * text field of the search bar.
     *
     * @return String that displayed if there is no text in the text field.
     */
    @CMGetter("@property(nonatomic, copy) NSString *placeholder;")
    public String placeholder() {
        return field.placeholder();
    }

    /**
     * Sets the appropriate String when there is no text in the text field of
     * the search bar.
     *
     * @param placeholder The String to be displayed into the search bar, when
     *                    there is no text.
     */
    @CMSetter("@property(nonatomic, copy) NSString *placeholder;")
    public void setPlaceholder(String placeholder) {
        field.setPlaceholder(placeholder);
    }

    /**
     * Returns the prompt text that is displayed above the search bar.
     *
     * @return String that is the prompt text above the search bar.
     */
    @CMGetter("@property(nonatomic, copy) NSString *prompt;\n"
            + "")
    public String prompt() {
        return prompt;
    }

    /**
     * Sets as prompt text displayed above the search bar the String specified
     * in the prompt parameter.
     *
     * @param prompt The prompt text above the search bar.
     */
    @CMSetter("@property(nonatomic, copy) NSString *prompt;\n"
            + "")
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    /**
     * Returns a flag that indicates whether there is a bookmark or not on this
     * search bar.
     *
     * @return Flag for the bookmark.
     */
    @CMGetter("@property(nonatomic) BOOL showsBookmarkButton;")
    public boolean showsBookmarkButton() {
        return showsBookmarkButton;
    }

    /**
     * Sets the flag defined by the showsBookmarkButton for existence of
     * bookmark button.
     *
     * @param showsBookmarkButton Defines the existence or not of a bookmark
     *                            button of this search bar.
     */
    @CMSetter("@property(nonatomic) BOOL showsBookmarkButton;")
    public void setShowsBookmarkButton(boolean showsBookmarkButton) {
        this.showsBookmarkButton = showsBookmarkButton;
    }

    /**
     * Return a flag that defines if there is a cancel button or not.
     *
     * @return Flag for cancel button.
     */
    @CMGetter("@property(nonatomic) BOOL showsCancelButton;")
    public boolean showsCancelButton() {
        return cancel != null;
    }

    /**
     * Sets the flag defined by showCancelButton for existence of cancel button
     * or not for this search bar.
     *
     * @param showsCancelButton Defines the existence or not of a cancel button.
     */
    @CMSetter("@property(nonatomic) BOOL showsCancelButton;")
    public void setShowsCancelButton(boolean showsCancelButton) {
        if (showsCancelButton == showsCancelButton())
            return;

        if (showsCancelButton) {
            cancel = UIButton.buttonWithType(UIButtonType.System);
            cancel.setFrame(new CGRect(cframe().getSize().getWidth() - cancelSize, 0, cancelSize, cframe().getSize().getHeight()));
            cancel.setTitle("Cancel", UIControlState.Normal);
            cancel.addTarget((UIControl sender, UIEvent event) -> {
                if (delegate != null)
                    delegate.cancelButtonClicked(UISearchBar.this);
            }, UIControlEvents.TouchUpInside);
            cancel.setAutoresizingMask(UIViewAutoresizing.FlexibleLeftMargin | UIViewAutoresizing.FlexibleHeight);
            addSubview(cancel);

            field.setFrame(new CGRect(0, 0, cframe().getSize().getWidth() - cancelSize, cframe().getSize().getHeight()));
        } else {
            cancel.removeFromSuperview();
            cancel = null;
            field.setFrame(new CGRect(0, 0, cframe().getSize().getWidth(), cframe().getSize().getHeight()));
        }
    }

    /**
     * Returns the String that is inside the text field of this search bar.
     *
     * @return String of search bar's text field.
     */
    @CMGetter("@property(nonatomic, copy) NSString *text;")
    public String text() {
        return field.text();
    }

    /**
     * Sets the text field of this search bar the String text.
     *
     * @param text String for the text field.
     */
    @CMSetter("@property(nonatomic, copy) NSString *text;")
    public void setText(String text) {
        field.setText(text);
    }

    /**
     * Returns the color of the search bar background.
     *
     * @return The color of the search bar background.
     */
    @CMGetter("@property(nonatomic, strong) UIColor *barTintColor;")
    public UIColor barTintColor() {
        return barTintColor;
    }

    /**
     * Sets the color of the search bar background.
     *
     * @param tintColor The color of the search bar background.
     */
    @CMSetter("@property(nonatomic, strong) UIColor *barTintColor;")
    public void setBarTintColor(UIColor tintColor) {
        this.barTintColor = tintColor;
        setNeedsDisplay();
    }

    /**
     * Returns a Boolean that shows whether the search bar is translucent.
     *
     * @return A Boolean that shows whether the search bar is translucent.
     */
    @CMGetter("@property(nonatomic, assign, getter=isTranslucent) BOOL translucent;")
    public boolean isTranslucent() {
        return translucent;
    }

    /**
     * Sets the search bar translucent or not.
     *
     * @param translucent TRUE the search bar is translucent.
     */
    @CMSetter("@property(nonatomic, assign, getter=isTranslucent) BOOL translucent;")
    public void setTranslucent(boolean translucent) {
        this.translucent = translucent;
        setNeedsDisplay();
    }

    /**
     * Returns a list with the titles of the scope buttons' titles.
     *
     * @return A list with the titles of the scope buttons' titles.
     */
    @CMGetter("@property(nonatomic, copy) NSArray<NSString *> *scopeButtonTitles;\n"
            + "")
    public List<String> scopeButtonTitles() {
        return scopeButtonTitles;
    }

    /**
     * Sets the titles displayed on the scope buttons.
     *
     * @param scopeButtonTitles The list withe the new titles displayed on the
     *                          scope buttons.
     */
    @CMSetter("@property(nonatomic, copy) NSArray<NSString *> *scopeButtonTitles;\n"
            + "")
    public void setScopeButtonTitles(List<String> scopeButtonTitles) {
        this.scopeButtonTitles = scopeButtonTitles;
    }

    /**
     * Returns the index of the selected scope button.
     *
     * @return The index of the selected scope button.
     */
    @CMGetter("@property(nonatomic) NSInteger selectedScopeButtonIndex;")
    public int selectedScopeButtonIndex() {
        return selectedScopeButtonIndex;
    }

    /**
     * Sets the scope button at the specified index as selected.
     *
     * @param selectedScopeButtonIndex The index of the selected scope button.
     */
    @CMSetter("@property(nonatomic) NSInteger selectedScopeButtonIndex;")
    public void setSelectedScopeButtonIndex(int selectedScopeButtonIndex) {
        this.selectedScopeButtonIndex = selectedScopeButtonIndex;
    }

    /**
     * Returns the visibility state of the scope bar.
     *
     * @return The visibility state of the scope bar.
     */
    @CMGetter("@property(nonatomic) BOOL showsScopeBar;")
    public boolean showsScopeBar() {
        return showsScopeBar;
    }

    /**
     * Sets the scope bar visible or not according to the parameter.
     *
     * @param showsScopeBar Boolean that defines visibility of scope bar.
     */
    @CMSetter("@property(nonatomic) BOOL showsScopeBar;")
    public void setShowsScopeBar(boolean showsScopeBar) {
        this.showsScopeBar = showsScopeBar;
    }

    @Override
    public boolean resignFirstResponder() {
        return field.resignFirstResponder();
    }

    @Override
    public boolean becomeFirstResponder() {
        return field.becomeFirstResponder();
    }

    @Override
    boolean shouldDrawOnTop() {
        return text().isEmpty();
    }

    @Override
    void drawOnTop(CGContext cx, CGRect rect) {
        if (text().isEmpty()) {
            int iconIdx = UISearchBarIcon.Search;

            UIImage icon;
//            if (isEnabled()) {
            if (iconNormal[iconIdx] == null)
                iconNormal[iconIdx] = UIImage.imageWithContentsOfFile(Native.file().getSystemPrefix() + Theme.Images.SEARCH);
            icon = iconNormal[iconIdx];
//            } else {
//                if (iconDisabled[iconIdx] == null)
//                    iconDisabled[iconIdx] = UIImage.imageWithContentsOfFile(Native.file().getSystemPrefix() + Theme.Images.SEARCH);
//                icon = iconDisabled[iconIdx];
//            }
            CGSize iconSize = icon.size();
            double width = rect.getSize().getWidth() - (showsCancelButton() ? cancelSize : 0);
            icon.drawAtPoint(new CGPoint(rect.getOrigin().getX() + (width - iconSize.getWidth()) / 2, rect.getOrigin().getY() + (rect.getSize().getHeight() - iconSize.getHeight()) / 2));
        }
    }
}
