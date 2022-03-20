/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bind.system.SystemUtilities;
import org.crossmobile.bridge.ann.*;
import org.crossmobile.support.cassowary.ClVariable;

import java.util.HashMap;
import java.util.Map;

/**
 * UILayoutGuide class defines a frame that represents the limits of a view and
 * interacts with the Auto Layout system based on constraints.
 */
@CMClass
public class UILayoutGuide extends NSObject {

    private String identifier;
    private CGRect layoutFrame = CGRect.zero();
    private UIView owningView;
    //Anchors
    private final NSLayoutYAxisAnchor bottomAnchor = new NSLayoutYAxisAnchor(this, NSLayoutAttribute.Bottom);
    private final NSLayoutXAxisAnchor centerXAnchor = new NSLayoutXAxisAnchor(this, NSLayoutAttribute.CenterX);
    private final NSLayoutYAxisAnchor centerYAnchor = new NSLayoutYAxisAnchor(this, NSLayoutAttribute.CenterY);
    private final NSLayoutYAxisAnchor firstBaselineAnchor = new NSLayoutYAxisAnchor(this, NSLayoutAttribute.FirstBaseline);
    private final NSLayoutDimension heightAnchor = new NSLayoutDimension(this, NSLayoutAttribute.Height);
    private final NSLayoutYAxisAnchor lastBaselineAnchor = new NSLayoutYAxisAnchor(this, NSLayoutAttribute.LastBaseline);
    private final NSLayoutXAxisAnchor leadingAnchor = new NSLayoutXAxisAnchor(this, NSLayoutAttribute.Leading);
    private final NSLayoutXAxisAnchor leftAnchor = new NSLayoutXAxisAnchor(this, NSLayoutAttribute.Left);
    private final NSLayoutXAxisAnchor rightAnchor = new NSLayoutXAxisAnchor(this, NSLayoutAttribute.Right);
    private final NSLayoutYAxisAnchor topAnchor = new NSLayoutYAxisAnchor(this, NSLayoutAttribute.Top);
    private final NSLayoutXAxisAnchor trailingAnchor = new NSLayoutXAxisAnchor(this, NSLayoutAttribute.Trailing);
    private final NSLayoutDimension widthAnchor = new NSLayoutDimension(this, NSLayoutAttribute.Width);

    private Map<Integer, ClVariable> variableMap = new HashMap<>();

    /**
     * The default constructor of the layout guide.
     */
    public UILayoutGuide() {
        initVars();
    }

    /**
     * Returns the String id of this layout guide.
     *
     * @return The String id of this layout guide.
     */
    @CMGetter("@property(nonatomic, copy) NSString *identifier;")
    public String identifier() {
        return identifier;
    }

    /**
     * Sets a String id for this layout guide.
     *
     * @param identifier The String id for this layout guide.
     */
    @CMSetter("@property(nonatomic, copy) NSString *identifier;")
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * The frame of this layout guide expressed in the coordinate system of the
     * view that own it.
     *
     * @return The CGRect of this layout guide.
     */
    @CMGetter("@property(nonatomic, readonly) CGRect layoutFrame;")
    public CGRect layoutFrame() {
        return layoutFrame;
    }

    /**
     * Returns the view of this layout guide.
     *
     * @return The view of this layout guide.
     */
    @CMGetter("@property(nonatomic, weak) UIView *owningView;")
    public UIView owningView() {
        return owningView;
    }

    /**
     * Set the view parameter as the owner of this layout guide.
     *
     * @param owningView The view that owns this this layout guide.
     */
    @CMSetter("@property(nonatomic, weak) UIView *owningView;")
    public void setOwningView(@CMParamMod(association = AssociationType.WEAK) UIView owningView) {
        this.owningView = owningView;
    }

    /**
     * Returns the layout anchor for the bottom edge.
     *
     * @return The layout anchor for the bottom edge.
     */
    @CMGetter("@property(readonly, strong) NSLayoutYAxisAnchor *bottomAnchor;")
    public NSLayoutYAxisAnchor bottomAnchor() {
        return bottomAnchor;
    }

    /**
     * Returns the layout anchor for horizontal center.
     *
     * @return The layout anchor for horizontal center.
     */
    @CMGetter("@property(readonly, strong) NSLayoutXAxisAnchor *centerXAnchor;")
    public NSLayoutXAxisAnchor centerXAnchor() {
        return centerXAnchor;
    }

    /**
     * Returns the layout anchor for vertical center.
     *
     * @return The layout anchor for vertical center.
     */
    @CMGetter("@property(readonly, strong) NSLayoutYAxisAnchor *centerYAnchor;")
    public NSLayoutYAxisAnchor centerYAnchor() {
        return centerYAnchor;
    }

    /**
     * Returns the layout anchor for the height.
     *
     * @return The layout anchor for the height.
     */
    @CMGetter("@property(readonly, strong) NSLayoutDimension *heightAnchor;")
    public NSLayoutDimension heightAnchor() {
        return heightAnchor;
    }

    /**
     * Returns the layout anchor for the leading edge.
     *
     * @return The layout anchor for the leading edge.
     */
    @CMGetter("@property(readonly, strong) NSLayoutXAxisAnchor *leadingAnchor;")
    public NSLayoutXAxisAnchor leadingAnchor() {
        return leadingAnchor;
    }

    /**
     * Returns the layout anchor for the left edge.
     *
     * @return The layout anchor for the left edge.
     */
    @CMGetter("@property(readonly, strong) NSLayoutXAxisAnchor *leftAnchor;")
    public NSLayoutXAxisAnchor leftAnchor() {
        return leftAnchor;
    }

    /**
     * Returns the layout anchor for the right edge.
     *
     * @return The layout anchor for the right edge.
     */
    @CMGetter("@property(readonly, strong) NSLayoutXAxisAnchor *rightAnchor;")
    public NSLayoutXAxisAnchor rightAnchor() {
        return rightAnchor;
    }

    /**
     * Returns the layout anchor for the top edge.
     *
     * @return The layout anchor for the top edge.
     */
    @CMGetter("@property(readonly, strong) NSLayoutYAxisAnchor *topAnchor;")
    public NSLayoutYAxisAnchor topAnchor() {
        return topAnchor;
    }

    /**
     * Returns the layout anchor for the trailing edge.
     *
     * @return The layout anchor for the trailing edge.
     */
    @CMGetter("@property(readonly, strong) NSLayoutXAxisAnchor *trailingAnchor;")
    public NSLayoutXAxisAnchor trailingAnchor() {
        return trailingAnchor;
    }

    /**
     * Returns the layout anchor for the width
     *
     * @return The layout anchor for the width.
     */
    @CMGetter("@property(readonly, strong) NSLayoutDimension *widthAnchor;")
    public NSLayoutDimension widthAnchor() {
        return widthAnchor;
    }

    ClVariable getVariable(int attribute) {
        return variableMap.get(attribute);
    }

    private void initVars() {
        variableMap.put(NSLayoutAttribute.Left, new ClVariable(this.getClass().getSimpleName() + "@" + this.hashCode() + "_Left"));
        variableMap.put(NSLayoutAttribute.Top, new ClVariable(this.getClass().getSimpleName() + "@" + this.hashCode() + "_Top"));
        variableMap.put(NSLayoutAttribute.Width, new ClVariable(this.getClass().getSimpleName() + "@" + this.hashCode() + "_Width"));
        variableMap.put(NSLayoutAttribute.Height, new ClVariable(this.getClass().getSimpleName() + "@" + this.hashCode() + "_Height"));
    }

    void applyResult() {
        layoutFrame.getSize().setWidth((float) getVariable(NSLayoutAttribute.Width).getValue());
        layoutFrame.getSize().setHeight((float) getVariable(NSLayoutAttribute.Height).getValue());
        layoutFrame.getOrigin().setX((float) getVariable(NSLayoutAttribute.Left).getValue() - owningView().cframe().getOrigin().getX());
        layoutFrame.getOrigin().setY((float) getVariable(NSLayoutAttribute.Top).getValue() - owningView().cframe().getOrigin().getY());
    }

    @Override
    public String toString() {
        return SystemUtilities.getClassName(getClass()) + (identifier == null ? "" : " id=" + identifier) + (layoutFrame.isEmpty() ? "" : " frame=" + layoutFrame.toString());
    }

}
