/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGRect;
import org.crossmobile.bridge.ann.*;

import java.util.HashSet;
import java.util.Set;

/**
 * UIBarButtonItem class defines button items that are used on toolbars and
 * navigation bars.
 */
@CMClass
public class UIBarButtonItem extends UIBarItem {

    private static final String[] SYSTEMTITLES = {"Done", "Cancel", "Edit", "Save", "Add", null, null, "Compose", "Reply", "Action", "Organize", "Bookmarks", "Search", "Refresh", "Stop", "Camera", "Trash", "Play", "Pause", "Rewind", "FastForward", "Undo", "Redo"};
    //
    int systemItem = -1;
    private Set<String> possibleTitles = new HashSet<>();
    private Runnable target;
    private int style;
    private Runnable parentCallback;

    /**
     * Initializes a new item containing the specified system item.
     *
     * @param UIBarButtonSystemItem The system item to use as the first item on
     *                              the bar. One of the constants defined in UIBarButtonSystemItem.
     * @param action                The action to send to target when this item is selected.
     * @see crossmobile.ios.uikit.UIBarButtonItemStyle
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    @CMConstructor("- (instancetype)initWithBarButtonSystemItem:(UIBarButtonSystemItem)systemItem\n"
            + "                                     target:(id)target\n"
            + "                                     action:(SEL)action")
    public UIBarButtonItem(int UIBarButtonSystemItem, @CMJoinSEL(selector = "action", target = "target") @CMParamMod(association = AssociationType.ASSOCIATE) final Runnable action) {
        this(SYSTEMTITLES[UIBarButtonSystemItem], null, null,
                UIBarButtonSystemItem == crossmobile.ios.uikit.UIBarButtonSystemItem.FlexibleSpace
                        || UIBarButtonSystemItem == crossmobile.ios.uikit.UIBarButtonSystemItem.FixedSpace,
                UIBarButtonItemStyle.Plain, action);

        switch (UIBarButtonSystemItem) {
            case crossmobile.ios.uikit.UIBarButtonSystemItem.FlexibleSpace:
                setWidth(0);
                break;
            case crossmobile.ios.uikit.UIBarButtonSystemItem.FixedSpace:
                break;
            default:
        }
        this.systemItem = UIBarButtonSystemItem;
    }

    /**
     * Constructs a bar button item with the specified custom view.
     *
     * @param customview A custom view for the bar button item.
     */
    @CMConstructor("- (instancetype)initWithCustomView:(UIView *)customView;")
    public UIBarButtonItem(UIView customview) {
        this(null, null, customview, false, UIBarButtonItemStyle.Plain, null);
    }

    /**
     * Constructs a bar button item with the specified image,style and connects
     * it with a particular delegate.
     *
     * @param image                The item’s image. If NULL then no image displayed.
     * @param UIBarButtonItemStyle The style of the item.
     * @param action               The delegate for this bar button item.
     * @see crossmobile.ios.uikit.UIBarButtonItemStyle
     */
    @CMConstructor("- (instancetype)initWithImage:(UIImage *)image\n"
            + "                        style:(UIBarButtonItemStyle)style\n"
            + "                       target:(id)target\n"
            + "                       action:(SEL)action")
    public UIBarButtonItem(UIImage image, int UIBarButtonItemStyle, @CMJoinSEL(selector = "action", target = "target") @CMParamMod(association = AssociationType.ASSOCIATE) final Runnable action) {
        this(null, image, null, false, UIBarButtonItemStyle, action);
    }

    /**
     * Constructs a bar button item with the specified title,style and connects
     * it with a particular delegate.
     *
     * @param title                The item’s title. If NULL then no title displayed.
     * @param UIBarButtonItemStyle The style of the item.
     * @param action               The delegate for this bar button item.
     * @see crossmobile.ios.uikit.UIBarButtonItemStyle
     */
    @CMConstructor("- (instancetype)initWithTitle:(NSString *)title\n"
            + "                        style:(UIBarButtonItemStyle)style\n"
            + "                       target:(id)target\n"
            + "                       action:(SEL)action")
    public UIBarButtonItem(String title, int UIBarButtonItemStyle, @CMJoinSEL(selector = "action", target = "target") @CMParamMod(association = AssociationType.ASSOCIATE) final Runnable action) {
        this(title, null, null, false, UIBarButtonItemStyle, action);
    }

    @SuppressWarnings("OverridableMethodCallInConstructor")
    private UIBarButtonItem(String title, UIImage image, UIView givenView, boolean viewless, int style, final Runnable action) {
        super(viewless, givenView);
        setButtonDelegate(action);
        setTitle(title);
        setImage(image);
        if (title != null)
            possibleTitles.add(title);
        this.style = style;
    }

    /**
     * Returns a custom view for this bar button item.
     *
     * @return A custom view for this bar button item.
     */
    @CMGetter("@property(nonatomic, strong) __kindof UIView *customView;")
    public UIView customView() {
        return systemItem < 0 ? view() : null;
    }

    /**
     * Sets a custom view for this bar button item.
     *
     * @param customView A custom view for this bar button item..
     */
    @CMSetter("@property(nonatomic, strong) __kindof UIView *customView;")
    public void setCustomView(UIView customView) {
        setView(customView);
        callbackParent();
    }

    /**
     * Returns the set of the possible titles of this bar button item.
     *
     * @return The possible titles of this bar button item.
     */
    @CMGetter("@property(nonatomic, copy) NSSet<NSString *> *possibleTitles;")
    public Set<String> possibleTitles() {
        return possibleTitles;
    }

    /**
     * Sets the possible titles of this bar button item.
     *
     * @param possibleTitles The possible titles of this bar button item.
     */
    @CMSetter("@property(nonatomic, copy) NSSet<NSString *> *possibleTitles;")
    public void setPossibleTitles(Set<String> possibleTitles) {
        this.possibleTitles = possibleTitles;
        callbackParent();
    }

    /**
     * Returns the style of this bar button item.
     *
     * @return The style of this bar button item.
     */
    @CMGetter("@property(nonatomic) UIBarButtonItemStyle style;")
    public int style() {
        return style;
    }

    /**
     * Sets the style for this bar button item.
     *
     * @param style The style for this bar button item.
     * @see crossmobile.ios.uikit.UIBarButtonItemStyle
     */
    @CMSetter("@property(nonatomic) UIBarButtonItemStyle style;")
    public void setStyle(int style) {
        this.style = style;
        callbackParent();
    }

    /**
     * Returns the object related to this item's action.
     *
     * @return The object related to this item's action.
     */
    @CMGetter("@property(nonatomic, weak) id target;")
    public Runnable target() {
        return target;
    }

    /**
     * Sets the object related to this item's action.
     *
     * @param target The object related to this item's action.
     */
    @CMSetter("@property(nonatomic, weak) id target;")
    public void setTarget(Runnable target) {
        this.target = target;
    }

    /**
     * Returns the width of this UIBarButtonItem.
     *
     * @return The width of this UIBarButtonItem.
     */
    @CMGetter(" @property(nonatomic) CGFloat width ")
    public double width() {
        UIView view = view();
        if (view == null)
            return 0;
        return view.cframe().getSize().getWidth();
    }

    /**
     * Set the width for this UIBarButtonItem.
     *
     * @param width The width of this UIBarButtonItem.
     */
    @CMSetter(" @property(nonatomic) CGFloat width ")
    public void setWidth(double width) {
        UIView view = view();
        if (view == null)
            return;
        view.setFrame(new CGRect(view.cframe().getOrigin().getX(), view.cframe().getOrigin().getY(), width, view.cframe().getSize().getHeight()));
        callbackParent();
    }

    void setParentCallback(Runnable parentCallback) {
        this.parentCallback = parentCallback;
    }

    private void callbackParent() {
        if (parentCallback != null)
            parentCallback.run();
    }

}
