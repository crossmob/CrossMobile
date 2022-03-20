/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.*;

/**
 * UIEdgeInsets class defines edge insets used in order to reduce or expand
 * views' rectangles.
 */
@CMStruct({"top", "left", "bottom", "right"})
public final class UIEdgeInsets {

    /**
     * Top parameter of the UIEdgeInset object.
     */
    private double top;

    /**
     * Left parameter of the UIEdgeInset object.
     */
    private double left;

    /**
     * Bottom parameter of the UIEdgeInset object.
     */
    private double bottom;

    /**
     * Right parameter of the UIEdgeInset object.
     */
    private double right;

    /**
     * Constructs a UIEdgeInsets instance object with all of the UIEdgeInsets
     * parameters set to zero.
     *
     * @return The default UIEdgeInset instance
     */
    @CMFunction(" extern const UIEdgeInsets UIEdgeInsetsZero;")
    public static UIEdgeInsets zero() {
        return new UIEdgeInsets();
    }

    /**
     * Constructs a UIEdgeInset object with the specified values for the edges.
     *
     * @param top    The the top inset of the UIEdgeInset object.
     * @param left   The the left inset of the UIEdgeInset object.
     * @param bottom The the bottom inset of the UIEdgeInset object.
     * @param right  The the right inset of the UIEdgeInset object.
     */
    @CMConstructor("UIEdgeInsets UIEdgeInsetsMake(CGFloat top, CGFloat left, CGFloat bottom, CGFloat right);")
    public UIEdgeInsets(@CMRef("top") double top, @CMRef("left") double left, @CMRef("bottom") double bottom, @CMRef("right") double right) {
        this.top = top;
        this.left = left;
        this.bottom = bottom;
        this.right = right;
    }

    UIEdgeInsets() {
        top = 0;
        left = 0;
        bottom = 0;
        right = 0;
    }

    UIEdgeInsets(UIEdgeInsets other) {
        if (other != null) {
            this.top = other.top;
            this.left = other.left;
            this.bottom = other.bottom;
            this.right = other.right;
        } else {
            this.top = 0;
            this.left = 0;
            this.bottom = 0;
            this.right = 0;
        }
    }

    @CMGetter("CGFloat top;")
    public double getTop() {
        return top;
    }

    @CMSetter("CGFloat top;")
    public void setTop(double top) {
        this.top = top;
    }

    @CMGetter("CGFloat left;")
    public double getLeft() {
        return left;
    }

    @CMSetter("CGFloat left;")
    public void setLeft(double left) {
        this.left = left;
    }

    @CMGetter("CGFloat bottom;")
    public double getBottom() {
        return bottom;
    }

    @CMSetter("CGFloat bottom;")
    public void setBottom(double bottom) {
        this.bottom = bottom;
    }

    @CMGetter("CGFloat right;")
    public double getRight() {
        return right;
    }

    @CMSetter("CGFloat right;")
    public void setRight(double right) {
        this.right = right;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Float.floatToIntBits((float) this.top);
        hash = 67 * hash + Float.floatToIntBits((float) this.left);
        hash = 67 * hash + Float.floatToIntBits((float) this.bottom);
        hash = 67 * hash + Float.floatToIntBits((float) this.right);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return equals((UIEdgeInsets) obj);
    }

    /**
     * Returns a Boolean that determines whether the specified instances of
     * UIEdgeInsets are equal.
     *
     * @param other The compared instance of UIEdgeInset.
     * @return true the two instances are equal.
     */
    @CMFunction("BOOL UIEdgeInsetsEqualToEdgeInsets(UIEdgeInsets insets1, UIEdgeInsets insets2);")
    public boolean equalToEdgeInsets(UIEdgeInsets other) {
        return equals(other);
    }

    @Override
    public String toString() {
        return "t=" + top + ",r=" + right + ",b=" + bottom + ",l=" + left;
    }

    boolean equals(UIEdgeInsets other) {
        return this.top == other.top && this.right == other.right && this.bottom == other.bottom && this.left == other.left;
    }

    void set(UIEdgeInsets contentInset) {
        if (contentInset == null) {
            this.top = 0;
            this.right = 0;
            this.bottom = 0;
            this.left = 0;
        } else {
            this.top = contentInset.top;
            this.right = contentInset.right;
            this.bottom = contentInset.bottom;
            this.left = contentInset.left;
        }
    }

    UIEdgeInsets fixForSize(int width, int height) {
        return new UIEdgeInsets(this).fixForSizeImpl(width, height);
    }

    private UIEdgeInsets fixForSizeImpl(int width, int height) {
        if (top < 0)
            top = 0;
        if (top >= height) {
            top = height;
            bottom = 0;
        }
        if (left < 0)
            left = 0;
        if (left >= width) {
            left = width;
            right = 0;
        }

        // These are true only if top/left is smaller than height/width
        if (top + bottom > height)
            bottom = height - top - 1;
        if (right + left > width)
            right = width - left - 1;
        return this;
    }
}
