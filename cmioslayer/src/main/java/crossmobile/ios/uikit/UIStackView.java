/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.quartzcore.CALayer;
import org.crossmobile.bridge.ann.*;

import java.util.ArrayList;
import java.util.List;

/**
 * UIStackView class defines structure used to organize a set views in a stack
 * vertically or horizontally. It controls the way these views appear on screen
 * adapting the size and the alignment of the structure as a whole or of its
 * content.
 */
@CMClass
public class UIStackView extends UIView {

    private List<UIView> arrangedSubviews;
    private int alignment;
    private int axis;
    private boolean baselineRelativeArrangement;
    private boolean layoutMarginsRelativeArrangement;
    private int distribution;
    private double spacing;
    private final List<NSLayoutConstraint> constraints = new ArrayList<>();

    /**
     * Constructs a UIStackView with the default values for the settings.
     *
     * @param views The views to be arranged by the stack view.
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    @CMConstructor("- (instancetype)initWithArrangedSubviews:(NSArray<__kindof UIView *> *)views;")
    public UIStackView(List<UIView> views) {
        this.distribution = UIStackViewDistribution.Fill;
        this.layoutMarginsRelativeArrangement = false;
        this.baselineRelativeArrangement = false;
        this.axis = UILayoutConstraintAxis.Horizontal;
        this.alignment = UIStackViewAlignment.Fill;
        this.spacing = 0;
        if (views != null && !views.isEmpty())
            for (UIView view : views)
                addArrangedSubview(view);
    }

    /**
     * Adds the specified view to the stack view.
     *
     * @param view The view to be added to the stack view.
     */
    @CMSelector("- (void)addArrangedSubview:(UIView *)view;")
    public void addArrangedSubview(UIView view) {
        if (arrangedSubviews == null)
            arrangedSubviews = new ArrayList<UIView>();
        if (!arrangedSubviews.contains(view))
            arrangedSubviews.add(view);
        if (!subviews().contains(view))
            addSubview(view);
        if (view.translatesAutoresizingMaskIntoConstraints())
            view.setTranslatesAutoresizingMaskIntoConstraints(false);
        updateStackViewConstraints();
    }

    /**
     * Inserts the particular view to the specified index of the stack view.
     *
     * @param view       The view to be added to the stack view.
     * @param stackIndex The index of the stack view into which the new view
     *                   added.
     */
    @CMSelector("- (void)insertArrangedSubview:(UIView *)view \n"
            + "                      atIndex:(NSUInteger)stackIndex;")
    public void insertArrangedSubview(UIView view, int stackIndex) {
        if (arrangedSubviews == null)
            arrangedSubviews = new ArrayList<UIView>();
        if (!arrangedSubviews.contains(view))
            arrangedSubviews.add(stackIndex, view);
        if (!subviews().contains(view))
            addSubview(view);
        updateStackViewConstraints();
    }

    /**
     * Removes the specified view from the stack view.
     *
     * @param view The view to be removed from the stack view.
     */
    @CMSelector("- (void)removeArrangedSubview:(UIView *)view;")
    public void removeArrangedSubview(UIView view) {
        if (arrangedSubviews.contains(view))
            arrangedSubviews.remove(view);
        updateStackViewConstraints();
    }

    /**
     * Returns the list of the subviews.
     *
     * @return The list of the subviews.
     */
    @CMGetter("@property(nonatomic, readonly, copy) NSArray<__kindof UIView *> *arrangedSubviews;")
    public List<UIView> arrangedSubviews() {
        return arrangedSubviews;
    }

    /**
     * Sets the alignment of the subviews perpendicular to the axis of the stack
     * view.
     *
     * @param UIStackViewAlignment The alignment of the subviews in the stack.
     * @see crossmobile.ios.uikit.UIStackViewAlignment
     */
    @CMSetter("@property(nonatomic) UIStackViewAlignment alignment;")
    public void setAlignment(int UIStackViewAlignment) {
        alignment = UIStackViewAlignment;
        updateStackViewConstraints();
    }

    /**
     * Returns the alignment of the subviews in the stack view.
     *
     * @return The alignment of the subviews in the stack view.
     */
    @CMGetter("@property(nonatomic) UIStackViewAlignment alignment;")
    public int alignment() {
        return alignment;
    }

    /**
     * Sets the axis of the stack view along which the subviews are organized.
     *
     * @param UILayoutConstraintAxis The axis of the stack view along which the
     *                               subviews are organized.
     * @see crossmobile.ios.uikit.UILayoutConstraintAxis
     */
    @CMSetter("@property(nonatomic) UILayoutConstraintAxis axis;")
    public void setAxis(int UILayoutConstraintAxis) {
        axis = UILayoutConstraintAxis;
        updateStackViewConstraints();
    }

    /**
     * Returns the axis of the stack view along which the subviews are
     * organized.
     *
     * @return The axis of the stack view along which the subviews are
     * organized.
     * @see crossmobile.ios.uikit.UILayoutConstraintAxis
     */
    @CMGetter("@property(nonatomic) UILayoutConstraintAxis axis;")
    public int axis() {
        return axis;
    }

    /**
     * Returns a Boolean that shows whether the spacing between consecutive
     * subviews in the stack is measured from their baselines.
     *
     * @return TRUE then spacing is measured from the baselines of the subviews.
     */
    @CMGetter("@property(nonatomic, getter=isBaselineRelativeArrangement) BOOL baselineRelativeArrangement;")
    public boolean isBaselineRelativeArrangement() {
        return baselineRelativeArrangement;
    }

    /**
     * Sets a Boolean that defines whether the spacing between consecutive
     * subviews in the stack is measured from their baselines.
     *
     * @param baselineRelativeArrangement TRUE then spacing is measured from the
     *                                    baselines of the subviews.
     */
    @CMSetter("@property(nonatomic, getter=isBaselineRelativeArrangement) BOOL baselineRelativeArrangement;")
    public void setBaselineRelativeArrangement(boolean baselineRelativeArrangement) {
        this.baselineRelativeArrangement = baselineRelativeArrangement;
        updateStackViewConstraints();
    }

    /**
     * Returns a Boolean that shows whether the subviews are arranged relative
     * to stack's layout margin.
     *
     * @return TRUE the subviews are arranged relative to stack's layout margin.
     */
    @CMGetter("@property(nonatomic, getter=isLayoutMarginsRelativeArrangement) BOOL layoutMarginsRelativeArrangement;")
    public boolean isLayoutMarginsRelativeArrangement() {
        return layoutMarginsRelativeArrangement;
    }

    /**
     * Sets a Boolean that defines whether the subviews are arranged relative to
     * stack's layout margin.
     *
     * @param layoutMarginsRelativeArrangement TRUE sets the subviews are
     *                                         arranged relative to stack's layout margin.
     */
    @CMSetter("@property(nonatomic, getter=isLayoutMarginsRelativeArrangement) BOOL layoutMarginsRelativeArrangement;")
    public void setLayoutMarginsRelativeArrangement(boolean layoutMarginsRelativeArrangement) {
        this.layoutMarginsRelativeArrangement = layoutMarginsRelativeArrangement;
        updateStackViewConstraints();
    }

    /**
     * Returns the arrangement of the views along the axis of the stack view.
     * (horizontal or vertical)
     *
     * @return The arrangement of the views along the axis of the stack view.
     * @see crossmobile.ios.uikit.UIStackViewDistribution
     */
    @CMGetter("@property(nonatomic) UIStackViewDistribution distribution;")
    public int distribution() {
        return distribution;
    }

    /**
     * Sets the arrangement of the views along the axis of the stack
     * view.(horizontal or vertical)
     *
     * @param UIStackViewDistribution The arrangement of the views along the
     *                                axis of the stack view.
     * @see crossmobile.ios.uikit.UIStackViewDistribution
     */
    @CMSetter("@property(nonatomic) UIStackViewDistribution distribution;")
    public void setDistribution(int UIStackViewDistribution) {
        this.distribution = UIStackViewDistribution;
        updateStackViewConstraints();
    }

    /**
     * Returns the distance between consecutive subviews expressed in points.
     * The default value is 0.0.
     *
     * @return The distance between consecutive subviews expressed in points.
     */
    @CMGetter("@property(nonatomic) CGFloat spacing;")
    public double spacing() {
        return spacing;
    }

    /**
     * Sets the distance between consecutive subviews expressed in points.
     *
     * @param spacing The distance between consecutive subviews expressed in
     *                points. The default value is 0.0.
     */
    @CMSetter("@property(nonatomic) CGFloat spacing;")
    public void setSpacing(double spacing) {
        this.spacing = spacing;
        updateStackViewConstraints();
    }

    @Override
    public CALayer layer() {
        return null;
    }

    @Override
    public UIColor backgroundColor() {
        return null;
    }

    @Override
    public void setBackgroundColor(UIColor background) {
    }

    private void updateStackViewConstraints() {
        NSLayoutConstraint.deactivateConstraints(constraints);
        constraints.clear();
        if (arrangedSubviews == null || arrangedSubviews.isEmpty())
            return;
        List<UIView> sortedViews = arrangedSubviews;
        double sum = 0;
        int counter = 0;
        NSLayoutConstraint constraint;
        switch (axis) {
            case UILayoutConstraintAxis.Horizontal:
                constraints.add(arrangedSubviews.get(0).leadingAnchor().constraintEqualToAnchor(this.leadingAnchor()));
                constraints.add(arrangedSubviews.get(arrangedSubviews.size() - 1).trailingAnchor().constraintEqualToAnchor(this.trailingAnchor()));
                switch (alignment) {
                    case UIStackViewAlignment.Fill:
                        for (UIView arrangedSubview : arrangedSubviews) {
                            constraints.add(arrangedSubview.heightAnchor().constraintEqualToAnchor(this.heightAnchor()));
                            constraints.add(arrangedSubview.topAnchor().constraintEqualToAnchor(this.topAnchor()));
                        }
                        break;
                    case UIStackViewAlignment.Center:
                        for (UIView arrangedSubview : arrangedSubviews)
                            constraints.add(arrangedSubview.centerYAnchor().constraintEqualToAnchor(this.centerYAnchor()));
                        break;
                    case UIStackViewAlignment.Trailing:
                        for (UIView arrangedSubview : arrangedSubviews)
                            constraints.add(arrangedSubview.trailingAnchor().constraintEqualToAnchor(this.trailingAnchor()));
                        break;
                    case UIStackViewAlignment.LastBaseline:
                        for (UIView arrangedSubview : arrangedSubviews)
                            constraints.add(NSLayoutConstraint.constraintWithItem(arrangedSubview, NSLayoutAttribute.Baseline, NSLayoutRelation.RelationEqual, this, NSLayoutAttribute.Baseline, 1, 0));
                        break;
                    case UIStackViewAlignment.Leading:
                        for (UIView arrangedSubview : arrangedSubviews)
                            constraints.add(arrangedSubview.leadingAnchor().constraintEqualToAnchor(this.leadingAnchor()));
                        break;
                    case UIStackViewAlignment.FirstBaseline:
                        for (UIView arrangedSubview : arrangedSubviews)
                            constraints.add(NSLayoutConstraint.constraintWithItem(arrangedSubview, NSLayoutAttribute.FirstBaseline, NSLayoutRelation.RelationEqual, this, NSLayoutAttribute.FirstBaseline, 1, 0));
                        break;
                }
                switch (distribution) {
                    case UIStackViewDistribution.Fill:
                        for (int i = 0; i < arrangedSubviews.size() - 1; i++)
                            constraints.add(arrangedSubviews.get(i).trailingAnchor().constraintEqualToAnchor(arrangedSubviews.get(i + 1).leadingAnchor(), -spacing));
                        break;
                    case UIStackViewDistribution.FillEqually:
                        for (int i = 0; i < arrangedSubviews.size() - 1; i++)
                            constraints.add(arrangedSubviews.get(i).trailingAnchor().constraintEqualToAnchor(arrangedSubviews.get(i + 1).leadingAnchor(), -spacing));
                        for (int i = 0; i < arrangedSubviews.size() - 1; i++)
                            constraints.add(arrangedSubviews.get(i).widthAnchor().constraintEqualToAnchor(arrangedSubviews.get(i + 1).widthAnchor()));
                        break;
                    case UIStackViewDistribution.FillProportionally:
                        for (int i = 0; i < arrangedSubviews.size() - 1; i++)
                            constraints.add(arrangedSubviews.get(i).trailingAnchor().constraintEqualToAnchor(arrangedSubviews.get(i + 1).leadingAnchor(), -spacing));
                        for (UIView arrangedSubview : arrangedSubviews) {
                            constraint = arrangedSubview.widthAnchor().constraintLessThanOrEqualToAnchor(this.widthAnchor(), 1f / arrangedSubviews.size(), -spacing);
                            constraint.setPriority(750);
                            constraints.add(constraint);
                        }
                        break;
                    case UIStackViewDistribution.EqualSpacing:
                        sortedViews.sort((o1, o2) -> {
                            if (o1.contentCompressionResistancePriorityForAxis(axis) > o2.contentCompressionResistancePriorityForAxis(axis))
                                return -1;
                            else if (o1.contentCompressionResistancePriorityForAxis(axis) < o2.contentCompressionResistancePriorityForAxis(axis))
                                return 1;
                            else
                                return 0;
                        });
                        for (UIView sortedSubview : sortedViews) {
                            sum += sortedSubview.intrinsicContentSize().getWidth() + spacing;
                            if (sum > this.cframe().getSize().getWidth()) {
                                sum = sum - (sortedSubview.intrinsicContentSize().getWidth() + spacing);
                                break;
                            }
                            counter++;
                        }
                        if (counter < sortedViews.size()) {
                            for (int i = 0; i < sortedViews.size() - 1; i++)
                                constraints.add(sortedViews.get(i).trailingAnchor().constraintGreaterThanOrEqualToAnchor(sortedViews.get(i + 1).leadingAnchor(), -spacing));
                            constraints.add(sortedViews.get(counter).widthAnchor().constraintEqualToConstant(this.cframe().getSize().getWidth() - sum));
                            for (int i = counter + 1; i < sortedViews.size(); i++)
                                constraints.add(sortedViews.get(i).widthAnchor().constraintEqualToConstant(0));
                        } else {
                            for (UIView sortedSubview : sortedViews)
                                sortedSubview.widthAnchor().constraintEqualToConstant(sortedSubview.intrinsicContentSize().getWidth());
                            for (int i = 0; i < sortedViews.size() - 1; i++)
                                constraints.add(sortedViews.get(i).trailingAnchor().constraintGreaterThanOrEqualToAnchor(sortedViews.get(i + 1).leadingAnchor(), -(this.cframe().getSize().getHeight() - (sum - sortedViews.size() * spacing)) / (sortedViews.size() - 1)));
                        }
                        break;
                    case UIStackViewDistribution.EqualCentering:
                        double centerspacing = (this.cframe().getSize().getWidth() - (arrangedSubviews.get(1).cframe().getSize().getWidth() / 2 + arrangedSubviews.get(arrangedSubviews.size() - 1).cframe().getSize().getWidth() / 2)) / (arrangedSubviews.size() - 1);
                        for (int i = 0; i < arrangedSubviews.size() - 1; i++)
                            constraints.add(arrangedSubviews.get(i).trailingAnchor().constraintGreaterThanOrEqualToAnchor(arrangedSubviews.get(i + 1).leadingAnchor(), -spacing));
                        for (int i = 0; i < arrangedSubviews.size() - 1; i++)
                            constraints.add(arrangedSubviews.get(i).centerXAnchor().constraintEqualToAnchor(arrangedSubviews.get(i + 1).centerXAnchor(), -centerspacing));
                        break;
                }
                break;
            case UILayoutConstraintAxis.Vertical:
                constraints.add(arrangedSubviews.get(0).topAnchor().constraintEqualToAnchor(this.topAnchor()));
                constraints.add(arrangedSubviews.get(arrangedSubviews.size() - 1).bottomAnchor().constraintEqualToAnchor(this.bottomAnchor()));
                switch (alignment) {
                    case UIStackViewAlignment.Fill:
                        for (UIView arrangedSubview : arrangedSubviews) {
                            constraints.add(arrangedSubview.leadingAnchor().constraintEqualToAnchor(this.leadingAnchor()));
                            constraints.add(arrangedSubview.trailingAnchor().constraintEqualToAnchor(this.trailingAnchor()));
                        }
                        break;
                    case UIStackViewAlignment.Center:
                        for (UIView arrangedSubview : arrangedSubviews)
                            constraints.add(arrangedSubview.centerXAnchor().constraintEqualToAnchor(this.centerXAnchor()));
                        break;
                    case UIStackViewAlignment.Trailing:
                        for (UIView arrangedSubview : arrangedSubviews)
                            constraints.add(arrangedSubview.bottomAnchor().constraintEqualToAnchor(this.bottomAnchor()));
                        break;
                    case UIStackViewAlignment.LastBaseline:
                    case UIStackViewAlignment.Leading:
                        for (UIView arrangedSubview : arrangedSubviews)
                            constraints.add(arrangedSubview.topAnchor().constraintEqualToAnchor(this.topAnchor()));
                        break;
                    case UIStackViewAlignment.FirstBaseline:
                }
                switch (distribution) {
                    case UIStackViewDistribution.Fill:
                        for (int i = 0; i < arrangedSubviews.size() - 1; i++)
                            constraints.add(arrangedSubviews.get(i).bottomAnchor().constraintEqualToAnchor(arrangedSubviews.get(i + 1).topAnchor(), -spacing));
                        break;
                    case UIStackViewDistribution.FillEqually:
                        for (int i = 0; i < arrangedSubviews.size() - 1; i++)
                            constraints.add(arrangedSubviews.get(i).bottomAnchor().constraintEqualToAnchor(arrangedSubviews.get(i + 1).topAnchor(), -spacing));
                        for (int i = 0; i < arrangedSubviews.size() - 1; i++)
                            constraints.add(arrangedSubviews.get(i).heightAnchor().constraintEqualToAnchor(arrangedSubviews.get(i + 1).heightAnchor()));
                        break;
                    case UIStackViewDistribution.FillProportionally:
                        for (UIView arrangedSubview : arrangedSubviews) {
                            constraint = arrangedSubview.heightAnchor().constraintLessThanOrEqualToAnchor(this.heightAnchor(), 1f / arrangedSubviews.size(), -spacing);
                            constraint.setPriority(750);
                            constraints.add(constraint);
                        }
                        break;
                    case UIStackViewDistribution.EqualSpacing:
                        sortedViews.sort((o1, o2) -> {
                            if (o1.contentCompressionResistancePriorityForAxis(axis) > o2.contentCompressionResistancePriorityForAxis(axis))
                                return -1;
                            else if (o1.contentCompressionResistancePriorityForAxis(axis) < o2.contentCompressionResistancePriorityForAxis(axis))
                                return 1;
                            else
                                return 0;
                        });
                        for (UIView sortedSubview : sortedViews) {
                            sum += sortedSubview.intrinsicContentSize().getHeight() + spacing;
                            if (sum > this.cframe().getSize().getHeight()) {
                                sum = sum - (sortedSubview.intrinsicContentSize().getHeight());
                                break;
                            }
                            counter++;
                        }
                        if (counter < sortedViews.size()) {
                            for (int i = 0; i < arrangedSubviews.size() - 1; i++)
                                constraints.add(arrangedSubviews.get(i).bottomAnchor().constraintGreaterThanOrEqualToAnchor(arrangedSubviews.get(i + 1).topAnchor(), -spacing));
                            constraints.add(sortedViews.get(counter).heightAnchor().constraintEqualToConstant(this.cframe().getSize().getHeight() - sum));
                            for (int i = counter + 1; i < sortedViews.size(); i++)
                                constraints.add(sortedViews.get(i).heightAnchor().constraintEqualToConstant(0));
                        } else {
                            for (UIView sortedSubview : sortedViews)
                                sortedSubview.heightAnchor().constraintEqualToConstant(sortedSubview.intrinsicContentSize().getHeight());
                            for (int i = 0; i < sortedViews.size() - 1; i++)
                                constraints.add(arrangedSubviews.get(i).bottomAnchor().constraintGreaterThanOrEqualToAnchor(arrangedSubviews.get(i + 1).topAnchor(), -(this.cframe().getSize().getHeight() - (sum - sortedViews.size() * spacing)) / (sortedViews.size() - 1)));
                        }
                        break;
                    case UIStackViewDistribution.EqualCentering:
                        double centerspacing = (this.cframe().getSize().getHeight() - (arrangedSubviews.get(1).cframe().getSize().getHeight() / 2 + arrangedSubviews.get(arrangedSubviews.size() - 1).cframe().getSize().getHeight() / 2)) / (arrangedSubviews.size() - 1);
                        for (int i = 0; i < arrangedSubviews.size() - 1; i++)
                            constraints.add(arrangedSubviews.get(i).bottomAnchor().constraintGreaterThanOrEqualToAnchor(arrangedSubviews.get(i + 1).topAnchor(), -spacing));
                        for (int i = 0; i < arrangedSubviews.size() - 1; i++)
                            constraints.add(arrangedSubviews.get(i).centerYAnchor().constraintEqualToAnchor(arrangedSubviews.get(i + 1).centerYAnchor(), -centerspacing));
                        break;
                }
                break;
        }
        NSLayoutConstraint.activateConstraints(constraints);
        layoutSubviews();
    }

}
