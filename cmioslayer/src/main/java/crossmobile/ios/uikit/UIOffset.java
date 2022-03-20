/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGSize;
import org.crossmobile.bridge.ann.*;

/**
 * UIOffset class creates an object that defines the position offset.
 */
@CMStruct({"horizontal", "vertical"})
public final class UIOffset {

    /**
     * The horizontal offset.
     */
    private double horizontal;

    /**
     * The vertical offset.
     */
    private double vertical;

    /**
     * Constructs a default UIOffset object with the specified horizontal and
     * vertical values.
     *
     * @param horizontal The horizontal offset.
     * @param vertical   The vertical offset.
     */
    @CMConstructor("UIOffset UIOffsetMake(CGFloat horizontal, CGFloat vertical);")
    public UIOffset(@CMRef("horizontal") double horizontal, @CMRef("vertical") double vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    @CMGetter("CGFloat horizontal;")
    public double getHorizontal() {
        return horizontal;
    }

    @CMSetter("CGFloat horizontal;")
    public void setHorizontal(double horizontal) {
        this.horizontal = horizontal;
    }

    @CMGetter("CGFloat vertical;")
    public double getVertical() {
        return vertical;
    }

    @CMSetter("CGFloat vertical;")
    public void setVertical(double vertical) {
        this.vertical = vertical;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Float.floatToIntBits((float) this.horizontal);
        hash = 97 * hash + Float.floatToIntBits((float) this.vertical);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final UIOffset other = (UIOffset) obj;
        return other.horizontal == this.horizontal && other.vertical == this.vertical;
    }

    void set(float horizontal, float vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    @Override
    public String toString() {
        return horizontal + "," + vertical;
    }

    CGSize toCGSize() {
        return new CGSize(horizontal, vertical);
    }
}
