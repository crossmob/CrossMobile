/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

/**
 * UIBarItem is an abstract class for items that appear inside a bar-like
 * structure, usually at the top or at the bottom of the screen.
 */
@CMClass
public abstract class UIBarItem extends NSObject {

    private UIImage image;
    private UIEdgeInsets imageInsets = null;
    private int tag;
    private UIView view;
    private String title = "";

    UIBarItem(boolean isVirtual, UIView customView) {
        if (customView != null)
            setView(customView);
        else if (!isVirtual) {
            UINavigationButton button = new UINavigationButton();
            button.imageView().setContentMode(UIViewContentMode.Center);
            setView(button);
        }
    }

    /**
     * Returns a Boolean that defines whether this bar item is enabled.
     *
     * @return A Boolean that defines whether this bar item is enabled.
     */
    @CMGetter("@property(nonatomic, getter=isEnabled) BOOL enabled;")
    public boolean isEnabled() {
        return !(view instanceof UIControl) || ((UIControl) view).isEnabled();
    }

    /**
     * Sets a Boolean that defines whether this bar item is enabled.
     *
     * @param enabled A Boolean that defines whether this bar item is enabled.
     */
    @CMSetter("@property(nonatomic, getter=isEnabled) BOOL enabled;")
    public void setEnabled(boolean enabled) {
        if (view instanceof UIControl)
            ((UIControl) view).setEnabled(enabled);
    }

    /**
     * Returns the image of this bar item.
     *
     * @return The image of this bar item.
     */
    @CMGetter("@property(nonatomic, strong) UIImage *image;")
    public UIImage image() {
        return image;
    }

    /**
     * Sets the image for this bar item.
     *
     * @param image The image for this bar item.
     */
    @CMSetter("@property(nonatomic, strong) UIImage *image;")
    public void setImage(UIImage image) {
        this.image = image;
        if (view instanceof UINavigationButton)
            ((UINavigationButton) view).setImage(image);
    }

    /**
     * Returns the image inset/outset of each edge.
     *
     * @return The image inset/outset of each edge.
     */
    @CMGetter("@property(nonatomic) UIEdgeInsets imageInsets;")
    public UIEdgeInsets imageInsets() {
        if (imageInsets == null)
            imageInsets = UIEdgeInsets.zero();
        return imageInsets;
    }

    /**
     * Sets the image inset/outset for each edge.
     *
     * @param imageInsets The image inset/outset for each edge.
     */
    @CMSetter("@property(nonatomic) UIEdgeInsets imageInsets;")
    public void setImageInsets(UIEdgeInsets imageInsets) {
        this.imageInsets = imageInsets;
        if (view instanceof UINavigationButton)
            ((UINavigationButton) view).setImageEdgeInsets(imageInsets);
    }

    /**
     * Returns the title of this bar item.
     *
     * @return The title of this bar item.
     */
    @CMGetter("@property(nonatomic, copy) NSString *title;")
    public String title() {
        return title;
    }

    /**
     * Sets the title for this bar item.
     *
     * @param title The title for this bar item.
     */
    @CMSetter("@property(nonatomic, copy) NSString *title;")
    public void setTitle(String title) {
        this.title = title == null ? "" : title;
        if (view instanceof UINavigationButton)
            ((UINavigationButton) view).setTitle(this.title);
    }

    /**
     * Returns the id of this bar item.
     *
     * @return The id of this bar item.
     */
    @CMGetter("@property(nonatomic) NSInteger tag;")
    public int tag() {
        return tag;
    }

    /**
     * Sets the id for this bar item.
     *
     * @param tag The id for this bar item.
     */
    @CMSetter("@property(nonatomic) NSInteger tag;")
    public void setTag(int tag) {
        this.tag = tag;
    }

    final void setView(UIView view) {
        this.view = view;
    }

    UIView view() {
        return view;
    }

    void setButtonDelegate(Runnable action) {
        if (view instanceof UINavigationButton) {
            UINavigationButton nb = (UINavigationButton) view;
            nb.removeTarget(null, UIControlEvents.AllEvents);
            if (action != null)
                nb.addTarget((a, b) -> action.run(), UIControlEvents.TouchUpInside);
        }
    }

    private static class UINavigationButton extends UIButton {

        UINavigationButton() {
            super(UIButtonType.Custom);
        }

        public void setImage(UIImage img) {
            if (img != null)
                setImage(img.cacheTinted(true, this), UIControlState.Normal);
            relayoutNavButton();
        }

        public void setTitle(String title) {
            setTitle(title, UIControlState.Normal);
            relayoutNavButton();
        }

        private void relayoutNavButton() {
            updateVisuals();
            setFrame(new CGRect(0, 0, intrinsicContentSize.getWidth(), intrinsicContentSize.getHeight()));
        }
    }
}
