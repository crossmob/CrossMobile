/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.foundation.NSLineBreakMode;
import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bind.graphics.Theme;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import java.util.Map;

/**
 * UINavigationItem class is responsible for the position and functionality of
 * the button items that appear on the navigation bar.
 */
@CMClass
public class UINavigationItem extends NSObject {

    boolean leftSetByUser = false;

    private String title;
    private UIView titleView;
    private UILabel defaultTitleView;
    private String prompt;
    private UILabel promptView;
    private boolean hidesBackButton;
    private UIBarButtonItem backBarButtonItem;
    private UIBarButtonItem leftBarButtonItem;
    private UIBarButtonItem rightBarButtonItem;
    private UINavigationBar bar;               // Back reference to parent object
    private final Runnable childBackRef = () -> {
        if (bar != null)
            bar.layoutSubviews();
    };

    /**
     * Constructs a UINavigationItem with the specified title.
     *
     * @param title The title of the new UINavigationItem.
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    @CMConstructor("- (instancetype)initWithTitle:(NSString *)title;")
    public UINavigationItem(String title) {
        setTitle(title);
    }

    void setToolbar(UINavigationBar bar) {
        this.bar = bar;
    }

    private void initBackButton() {
        backBarButtonItem = new UIBarButtonItem(Native.graphics().getBackChar() + " Back", UIBarButtonItemStyle.Bordered, () -> {
            if (bar != null)
                bar.backClicked();
        });
        backBarButtonItem.setParentCallback(childBackRef);
    }

    /**
     * Returns the back bar button item.
     *
     * @return The back bar button item.
     */
    @CMGetter("@property(nonatomic, strong) UIBarButtonItem *backBarButtonItem;")
    public UIBarButtonItem backBarButtonItem() {
        if (leftBarButtonItem == null)
            initBackButton();
        return backBarButtonItem;
    }

    /**
     * Sets a back button item when it is needed.
     *
     * @param backBarButtonItem The back bar button item.
     */
    @CMSetter("@property(nonatomic, strong) UIBarButtonItem *backBarButtonItem;")
    public void setBackBarButtonItem(UIBarButtonItem backBarButtonItem) {
        this.backBarButtonItem = backBarButtonItem;
        if (backBarButtonItem != null)
            backBarButtonItem.setParentCallback(childBackRef);
        childBackRef.run();
    }

    /**
     * Returns a Boolean that shows if the back button is hidden or not.
     *
     * @return A Boolean that shows if the back button is hidden or not.
     */
    @CMGetter("@property(nonatomic, assign) BOOL hidesBackButton;")
    public boolean hidesBackButton() {
        return hidesBackButton;
    }

    /**
     * Sets the back button hidden or not.
     *
     * @param hidesBackButton Boolean that defines whether the back button will
     *                        be hidden or not.
     */
    @CMSetter("@property(nonatomic, assign) BOOL hidesBackButton;")
    public void setHidesBackButton(boolean hidesBackButton) {
        setHidesBackButton(hidesBackButton, false);
    }

    /**
     * Sets the back button hidden or not with animated way or not.
     *
     * @param hidesBackButton Boolean that defines whether the back button will
     *                        be hidden or not.
     * @param animated        Boolean that defines whether the change will be animated
     *                        or not
     */
    @CMSelector("- (void)setHidesBackButton:(BOOL)hidesBackButton \n"
            + "                  animated:(BOOL)animated;")
    public void setHidesBackButton(boolean hidesBackButton, boolean animated) {
        this.hidesBackButton = hidesBackButton;
        childBackRef.run();
    }

    /**
     * Returns the item that is placed at the left side of the navigation bar.
     *
     * @return The item that is placed at the left side of the navigation bar.
     */
    @CMGetter("@property(nonatomic, strong) UIBarButtonItem *leftBarButtonItem;")
    public UIBarButtonItem leftBarButtonItem() {
        return leftBarButtonItem;
    }

    /**
     * Sets a navigation item at the left side of the navigation bar.
     *
     * @param leftBarButtonItem The navigation item that will placed at the left
     *                          side of the bar.
     */
    @CMSetter("@property(nonatomic, strong) UIBarButtonItem *leftBarButtonItem;")
    public void setLeftBarButtonItem(UIBarButtonItem leftBarButtonItem) {
        setLeftBarButtonItem(leftBarButtonItem, false);
    }

    /**
     * Sets a navigation item at the left side of the navigation bar with
     * animated way or not.
     *
     * @param leftBarButtonItem The navigation item that will placed at the left
     *                          side of the bar.
     * @param animated          Boolean that defines whether the change will be animated
     *                          or not.
     */
    @CMSelector("- (void)setLeftBarButtonItem:(UIBarButtonItem *)item \n"
            + "                    animated:(BOOL)animated;")
    public void setLeftBarButtonItem(UIBarButtonItem leftBarButtonItem, boolean animated) {
        leftSetByUser = true;
        setLeftBarButtonItem(leftBarButtonItem, animated, true);
    }

    void setLeftBarButtonItem(UIBarButtonItem leftBarButtonItem, boolean animated, boolean informChild) {
        this.leftBarButtonItem = leftBarButtonItem;
        if (leftBarButtonItem == null)
            initBackButton();
        else
            leftBarButtonItem.setParentCallback(childBackRef);
        if (informChild)
            childBackRef.run();
    }

    /**
     * Returns the item that is placed at the right side of the navigation bar.
     *
     * @return The item that is placed at the right side of the navigation bar.
     */
    @CMGetter("@property(nonatomic, strong) UIBarButtonItem *rightBarButtonItem;")
    public UIBarButtonItem rightBarButtonItem() {
        return rightBarButtonItem;
    }

    /**
     * Sets a navigation item at the right side of the navigation bar.
     *
     * @param rightBarButtonItem The navigation item that will placed at the
     *                           right side of the bar.
     */
    @CMSetter("@property(nonatomic, strong) UIBarButtonItem *rightBarButtonItem;")
    public void setRightBarButtonItem(UIBarButtonItem rightBarButtonItem) {
        setRightBarButtonItem(rightBarButtonItem, false);
    }

    /**
     * Sets a navigation item at the right side of the navigation bar with
     * animated way or not.
     *
     * @param rightBarButtonItem The navigation item that will placed at the
     *                           right side of the bar.
     * @param animated           Boolean that defines whether the change will be animated
     *                           or not.
     */
    @CMSelector("- (void)setRightBarButtonItem:(UIBarButtonItem *)item \n"
            + "                     animated:(BOOL)animated;")
    public void setRightBarButtonItem(UIBarButtonItem rightBarButtonItem, boolean animated) {
        this.rightBarButtonItem = rightBarButtonItem;
        if (rightBarButtonItem != null)
            rightBarButtonItem.setParentCallback(childBackRef);
        childBackRef.run();
    }

    /**
     * Returns the text that is placed at the top of the navigation bar.
     *
     * @return The text that is placed at the top of the navigation bar.
     */
    @CMGetter("@property(nonatomic, copy) NSString *prompt;")
    public String prompt() {
        return prompt;
    }

    /**
     * Sets a text at the top of the navigation bar.
     *
     * @param prompt THe text that will be placed at the top of the navigation
     *               bar.
     */
    @CMSetter("@property(nonatomic, copy) NSString *prompt;")
    public void setPrompt(String prompt) {
        // ignore set, if it is the same
        if (this.prompt == null ? prompt == null : this.prompt.equals(prompt))
            return;

        Native.system().notImplemented();
//        this.prompt = prompt;
//        // set promptView if prompt is set
//        if (prompt != null) {
//            if (promptView == null)
//                promptView = initDefaultTitleView(true);
//            promptView.setText(prompt);
//        } else
//            promptView = null;
//        childBackRef.invokeWithArgument(null);
    }

    UILabel promptView() {
        return promptView;
    }

    /**
     * Returns the title of this navigation item in the middle of the navigation
     * bar.
     *
     * @return The title of the navigation item.
     */
    @CMGetter("@property(nonatomic, copy) NSString *title;")
    public String title() {
        return title;
    }

    /**
     * Sets the title of this navigation item in the middle of the navigation
     * bar.
     *
     * @param title The title of the navigation item.
     */
    @CMSetter("@property(nonatomic, copy) NSString *title;")
    public void setTitle(String title) {
        if (title == null)
            title = "";
        if (title.equals(this.title))
            return;
        this.title = title;
        if (defaultTitleView != null)
            defaultTitleView.setText(title);
        childBackRef.run();
    }

    /**
     * Returns the view that is placed in the middle of the navigation bar when
     * the item the top of the stack.
     *
     * @return The view in the middle of the navigation bar.
     */
    @CMGetter("@property(nonatomic, strong) UIView *titleView")
    public UIView titleView() {
        return titleView;
    }

    UIView effectiveTitleView() {
        return titleView != null ? titleView : (defaultTitleView != null ? defaultTitleView : initDefaultTitleView());
    }

    /**
     * Sets the specified view in the middle of the navigation bar when this
     * item is the top item of the stack.
     *
     * @param titleView The view that will placed in the middle of the
     *                  navigation bar.
     */
    @CMSetter("@property(nonatomic, strong) UIView *titleView")
    public void setTitleView(UIView titleView) {
        if (this.titleView == titleView)
            return;
        this.titleView = titleView;
        childBackRef.run();
    }

    private UILabel initDefaultTitleView() {
        if (defaultTitleView == null) {
            defaultTitleView = new UILabel();
            defaultTitleView.setText(title);
            defaultTitleView.setTextAlignment(UITextAlignment.Center);
            defaultTitleView.setFont(UIFont.boldSystemFontOfSize(Theme.Bar.FONTSIZE));
            defaultTitleView.setTextColor(Theme.Bar.FORE);
            defaultTitleView.setLineBreakMode(NSLineBreakMode.ByClipping);
            defaultTitleView.setNumberOfLines(1);
            if (Theme.Bar.Nav.ISSHADOWED) {
                defaultTitleView.setShadowColor(Theme.Bar.SHADOW);
                defaultTitleView.setShadowOffset(Theme.Bar.Nav.SHADOWOFFSET);
            }
            if (bar != null && bar.titleTextAttributes != null)
                updateTextAttributes(bar.titleTextAttributes);
        }
        return defaultTitleView;
    }

    void updateTextAttributes(Map<String, Object> attributes) {
        initDefaultTitleView();
        Object textFont = attributes.get(UITextAttribute.Font);
        Object textColor = attributes.get(UITextAttribute.TextColor);
        Object textShadowColor = attributes.get(UITextAttribute.TextShadowColor);
        Object textShadowOffset = attributes.get(UITextAttribute.TextShadowOffset);
        if (textFont instanceof UIFont)
            defaultTitleView.setFont((UIFont) textFont);
        if (textColor instanceof UIColor)
            defaultTitleView.setTextColor((UIColor) textColor);
        if (textShadowColor instanceof UIColor)
            defaultTitleView.setShadowColor((UIColor) textShadowColor);
        if (textShadowOffset instanceof UIOffset)
            defaultTitleView.setShadowOffset(((UIOffset) textShadowOffset).toCGSize());
    }
}
