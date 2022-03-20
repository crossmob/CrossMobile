/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bind.system.SystemUtilities;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;
import org.crossmobile.support.cassowary.*;
import org.crossmobile.support.cassowary.clconstraint.ClConstraint;
import org.crossmobile.support.cassowary.clconstraint.ClLinearEquation;
import org.crossmobile.support.cassowary.clconstraint.ClLinearInequality;
import org.crossmobile.support.cassowary.clconstraint.ClStayConstraint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * NSLayoutConstraint class defines an object that represents the relationship
 * that should be satisfied concerning two layout attributes in a constraint
 * based layout system.
 */
@SuppressWarnings("LocalVariableHidesMemberVariable")
@CMClass
public class NSLayoutConstraint extends NSObject {

    private final Object firstItem;
    private final int firstAttribute;
    private final int relation;
    private final Object secondItem;
    private final int secondAttribute;
    private final double multiplier;
    private float priority;
    private boolean shouldBeArchived;
    private double constant;
    private String identifier;
    private boolean active = false;
    private ClConstraint constraint;
    private ClStrength strength;
    private Map<String, ClStayConstraint> stays = new HashMap<>();

    private NSLayoutConstraint(Object view1, int NSLayoutAttribute1, int NSLayoutRelation, Object view2, int NSLayoutAttribute2, double multiplier, double constant) {
        firstItem = view1;
        firstAttribute = NSLayoutAttribute1;
        relation = NSLayoutRelation;
        secondItem = view2;
        secondAttribute = NSLayoutAttribute2;
        this.multiplier = multiplier;
        this.constant = constant;
        strength = new ClStrength("Required", new ClSymbolicWeight(new double[]{1000}));
    }

    /**
     * Creates and returns a list of constraints using the specified ASCII
     * visual format string.
     *
     * @param format                The specification of the constraints.
     * @param NSLayoutFormatOptions The NSLayoutFormat options of the objects.
     * @param metrics               The constants of the visual format string.
     * @param views                 The views of the visual format string.
     * @return The resulting list of the constraints.
     * @see crossmobile.ios.uikit.NSLayoutFormatOptions
     */
    @CMSelector("+ (NSArray<__kindof NSLayoutConstraint *> *)constraintsWithVisualFormat:(NSString *)format \n"
            + "                                                                options:(NSLayoutFormatOptions)opts \n"
            + "                                                                metrics:(NSDictionary<NSString *,id> *)metrics \n"
            + "                                                                  views:(NSDictionary<NSString *,id> *)views;")
    public static List<NSLayoutConstraint> constraintsWithVisualFormat(String format, int NSLayoutFormatOptions, Map<String, Float> metrics, Map<String, UIView> views) {
        cmConstraintWithVisualFormat con = new cmConstraintWithVisualFormat();
        return con.constraintWithVisualFormat(format, NSLayoutFormatOptions, metrics, views);
    }

    /**
     * Constructs and returns a constraint for the attributes of the specified
     * views.
     *
     * @param view1              The view of the left side of the constraint.
     * @param NSLayoutAttribute1 The attribute of the view for the left side of
     *                           the constraint.
     * @param NSLayoutRelation   The relationship between the two sides of the
     *                           constraint.
     * @param view2              The view of the right side of the constraint.
     * @param NSLayoutAttribute2 The attribute of the view for the right side of
     *                           the constraint.
     * @param multiplier         The multiplier of the attribute on the right side of
     *                           the constraint.
     * @param constant           The constant added to the multiplied attribute value on
     *                           the right side of the constraint.
     * @return The resulting constraint object.
     */
    @CMSelector("+ (instancetype)constraintWithItem:(id)view1 \n"
            + "                         attribute:(NSLayoutAttribute)attr1 \n"
            + "                         relatedBy:(NSLayoutRelation)relation \n"
            + "                            toItem:(id)view2 \n"
            + "                         attribute:(NSLayoutAttribute)attr2 \n"
            + "                        multiplier:(CGFloat)multiplier \n"
            + "                          constant:(CGFloat)c;")
    public static NSLayoutConstraint constraintWithItem(Object view1, int NSLayoutAttribute1, int NSLayoutRelation, Object view2, int NSLayoutAttribute2, double multiplier, double constant) {
        return new NSLayoutConstraint(view1, NSLayoutAttribute1, NSLayoutRelation, view2, NSLayoutAttribute2, multiplier, constant);
    }

    /**
     * Activates all the constraints of the specified list.
     *
     * @param constraints The list of constraints that should be activated.
     */
    @CMSelector("+ (void)activateConstraints:(NSArray<NSLayoutConstraint *> *)constraints;")
    public static void activateConstraints(List<NSLayoutConstraint> constraints) {
        for (NSLayoutConstraint constraint : constraints)
            constraint.setActive(true);
    }

    /**
     * Deactivates all the constraints of the specified list.
     *
     * @param constraints The list of constraints that should be deactivated.
     */
    @CMSelector("+ (void)deactivateConstraints:(NSArray<NSLayoutConstraint *> *)constraints;")
    public static void deactivateConstraints(List<NSLayoutConstraint> constraints) {
        for (NSLayoutConstraint constraint : constraints)
            constraint.setActive(false);
    }

    /**
     * Returns the state of this constraint.
     *
     * @return TRUE then the constraint is active.
     */
    @CMGetter("@property(getter=isActive) BOOL active;")
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the state of this constraint.
     *
     * @param active TRUE then the constraint is active.
     */
    @CMSetter("@property(getter=isActive) BOOL active;")
    public void setActive(boolean active) {
        this.active = active;
        //Layout Guides
        if (firstItem instanceof UILayoutGuide)
            if (active)
                ((UILayoutGuide) firstItem).owningView().addConstraint(this);
            else
                ((UILayoutGuide) firstItem).owningView().removeConstraint(this);
        else if (secondItem != null && (secondItem instanceof UILayoutGuide))
            if (active)
                ((UILayoutGuide) secondItem).owningView().addConstraint(this);
            else
                ((UILayoutGuide) secondItem).owningView().removeConstraint(this);
            //Layout Support
        else if (firstItem instanceof UIViewController.LayoutSupport)
            if (active)
                ((UIViewController.LayoutSupport) firstItem).owningView().addConstraint(this);
            else
                ((UIViewController.LayoutSupport) firstItem).owningView().removeConstraint(this);
        else if (secondItem != null && (secondItem instanceof UIViewController.LayoutSupport))
            if (active)
                ((UIViewController.LayoutSupport) secondItem).owningView().addConstraint(this);
            else
                ((UIViewController.LayoutSupport) secondItem).owningView().removeConstraint(this);
            //View
        else {
            UIView commonAncestor = closestCommonAncestor((UIView) firstItem, (UIView) secondItem);
            if (commonAncestor != null) {
                if (active)
                    commonAncestor.addConstraint(this);
                else
                    commonAncestor.removeConstraint(this);
            }
        }
    }

    static private UIView closestCommonAncestor(UIView first, UIView secondItem) {
        if (first == null)
            return null;
        if (secondItem == null)
            return first;
        List<UIView> firstAncestry = ancestryList(first, new ArrayList<>());
        List<UIView> secondAncestry = ancestryList(secondItem, new ArrayList<>());
        for (int i = firstAncestry.size() - 1; i >= 0; i--)
            for (int j = secondAncestry.size() - 1; j >= 0; j--)
                if (firstAncestry.get(i).equals(secondAncestry.get(j)))
                    return firstAncestry.get(i);
        return null;
    }

    static private List<UIView> ancestryList(UIView view, List<UIView> list) {
        if (view == null) return list;
        ancestryList(view.superview(), list).add(view);
        return list;
    }

    /**
     * Returns the priority of the constraint.
     *
     * @return The priority of the constraint.
     * @see crossmobile.ios.uikit.UILayoutPriority
     */
    @CMGetter("@property UILayoutPriority priority;")
    public float priority() {
        return priority;
    }

    /**
     * Sets the priority of the constraint.
     *
     * @param UILayoutPriority The priority of the constraint.
     * @see crossmobile.ios.uikit.UILayoutPriority
     */
    @CMSetter("@property UILayoutPriority priority;")
    public void setPriority(float UILayoutPriority) {
        if (priority < 1000 && UILayoutPriority == 1000 && active) {
            System.out.println("Cant change Priority from Not - Required to Required After the Constraint is added to the view");
            return;
        }
        if (priority == 1000 && UILayoutPriority < 1000 && active) {
            System.out.println("Cant change Priority from Required to Not - Required After the Constraint is added to the view");
            return;
        }
        this.priority = UILayoutPriority;
        if (UILayoutPriority == 1000)
            strength = new ClStrength("Required", new ClSymbolicWeight(new double[]{1000}));
        else if (UILayoutPriority == 750)
            strength = new ClStrength("DefaultHigh", new ClSymbolicWeight(new double[]{priority}));
        else if (UILayoutPriority == 250)
            strength = new ClStrength("DefaultLow", new ClSymbolicWeight(new double[]{priority}));
        else if (UILayoutPriority == 50)
            strength = new ClStrength("FittingSizeLevel", new ClSymbolicWeight(new double[]{priority}));
        else
            strength = new ClStrength("Custom", new ClSymbolicWeight(new double[]{priority}));
    }

    /**
     * Returns the first object of the constraint.
     *
     * @return The first object of the constraint.
     */
    @CMGetter("@property(readonly, assign) id firstItem;")
    public Object firstItem() {
        return firstItem;
    }

    /**
     * Returns the attribute of the first object of the constraint.
     *
     * @return The attribute of the first object of the constraint.
     */
    @CMGetter("@property(readonly) NSLayoutAttribute firstAttribute;")
    public int firstAttribute() {
        return firstAttribute;
    }

    /**
     * Returns the relation between the items of the constraint.
     *
     * @return The relation between the items of the constraint.
     */
    @CMGetter("@property(readonly) NSLayoutRelation relation;")
    public int relation() {
        return relation;
    }

    /**
     * Returns the second item of the constraint.
     *
     * @return The second item of the constraint.
     */
    @CMGetter("@property(readonly, assign) id secondItem;")
    public Object secondItem() {
        return secondItem;
    }

    /**
     * Returns the second attribute of the constraint.
     *
     * @return The second attribute of the constraint.
     */
    @CMGetter("@property(readonly) NSLayoutAttribute secondAttribute;")
    public int secondAttribute() {
        return secondAttribute;
    }

    /**
     * Returns the multiplier of the second attribute of the constraint.
     *
     * @return The multiplier of the second attribute of the constraint.
     */
    @CMGetter("@property(readonly) CGFloat multiplier;")
    public double multiplier() {
        return multiplier;
    }

    /**
     * Returns the constant that is added to the multiplied second attribute of
     * the constraint.
     *
     * @return The constant that is added to the multiplied second attribute of
     * the constraint.
     */
    @CMGetter("@property CGFloat constant;")
    public double constant() {
        return constant;
    }

    /**
     * Sets the constant that is added to the multiplied second attribute of the
     * constraint.
     *
     * @param constant The constant that is added to the multiplied second
     *                 attribute of the constraint.
     */
    @CMSetter("@property CGFloat constant;")
    public void setConstant(double constant) {
        this.constant = constant;
    }

    /**
     * Returns the id of this NSLayoutConstraint.
     *
     * @return The id of this NSLayoutConstraint.
     */
    @CMGetter("@property(copy) NSString *identifier;")
    public String identifier() {
        return identifier;
    }

    /**
     * Set the id of this NSLayoutConstraint.
     *
     * @param identifier The id of this NSLayoutConstraint.
     */
    @CMSetter("@property(copy) NSString *identifier;")
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Returns a Boolean that shows whether this NSLayoutConstraint is archived
     * by its owning view.
     *
     * @return TRUE then this NSLayoutConstraint should be archived by its
     * owning view.
     */
    @CMGetter("@property BOOL shouldBeArchived;")
    public boolean shouldBeArchived() {
        return shouldBeArchived;
    }

    /**
     * Set a Boolean that defines whether this NSLayoutConstraint should be
     * archived by its owning view.
     *
     * @param shouldBeArchived TRUE then this NSLayoutConstraint should be
     *                         archived by its owning view.
     */
    @CMSetter("@property BOOL shouldBeArchived;")
    public void setShouldBeArchived(boolean shouldBeArchived) {
        this.shouldBeArchived = shouldBeArchived;
    }


    // Stay constraints MUST be created first and then added to solver
    // because removing or adding a constraint to solver causes the solver
    // to solve the constraints (yes this makes sense) and change the values
    // of the variables we want to create the new stay constarints from
    void addToSolverStay(ClSimplexSolver solver) {
        Map<String, ClStayConstraint> temp = new HashMap<>();
        for (ClAbstractVariable clAbstractVariable : constraint.expression().terms().keySet())
            temp.put(clAbstractVariable.name(), new ClStayConstraint((ClVariable) clAbstractVariable, ClStrength.weak, 1.0));
        for (String variableName : temp.keySet()) {
            if (stays.keySet().contains(variableName))
                solver.removeConstraint(stays.get(variableName));
            stays.put(variableName, temp.get(variableName));
            solver.addConstraint(temp.get(variableName));
        }
    }

    //Not from Api
    void addToSolver(ClSimplexSolver solver) {
        if (constraint == null)
            constraint = buildConstraint();
        if (!solver.getConstraintMap().keySet().contains(constraint)) {
            solver.addConstraint(constraint);
        }
    }

    void removeFromSolver(ClSimplexSolver solver) {
        active = false;
        try {
            solver.removeConstraint(constraint);
        } catch (Exception e) {
        }
    }

    private ClConstraint buildConstraint() {

        if (relation == NSLayoutRelation.RelationEqual)
            constraint = new ClLinearEquation(firstExpression(), secondExpression(), strength);
        else {
            byte op = (relation == NSLayoutRelation.GreaterThanOrEqual ? CL.GEQ : CL.LEQ);
            constraint = new ClLinearInequality(firstExpression(), op, secondExpression(), strength);
        }
//        System.out.println(constraint);
        return constraint;
    }

    private ClLinearExpression firstExpression() {
        return getExpression(firstAttribute, firstItem);
    }

    private ClLinearExpression secondExpression() {
        return getExpression(secondAttribute, secondItem, multiplier, constant);
    }

    private ClLinearExpression getExpression(int attribute, Object item) {
        return getExpression(attribute, item, 1, 0);
    }

    private ClLinearExpression getExpression(int attribute, Object item, double multiplier, double constant) {
        switch (attribute) {
            case NSLayoutAttribute.Right:
                return new ClLinearExpression(getVariable(NSLayoutAttribute.Left, item), multiplier)
                        .plus(new ClLinearExpression(getVariable(NSLayoutAttribute.Width, item), multiplier, constant));
            case NSLayoutAttribute.Bottom:
                return new ClLinearExpression(getVariable(NSLayoutAttribute.Top, item), multiplier)
                        .plus(new ClLinearExpression(getVariable(NSLayoutAttribute.Height, item), multiplier, constant));
            case NSLayoutAttribute.Leading:
                return new ClLinearExpression(getVariable(NSLayoutAttribute.Left, item), multiplier, constant);
            case NSLayoutAttribute.Trailing:
                return new ClLinearExpression(getVariable(NSLayoutAttribute.Left, item), multiplier)
                        .plus(new ClLinearExpression(getVariable(NSLayoutAttribute.Width, item), multiplier, constant));
            case NSLayoutAttribute.CenterX:
                return new ClLinearExpression(getVariable(NSLayoutAttribute.Left, item), multiplier)
                        .plus(new ClLinearExpression(getVariable(NSLayoutAttribute.Width, item), 0.5 * multiplier, constant));
            case NSLayoutAttribute.CenterY:
                return new ClLinearExpression(getVariable(NSLayoutAttribute.Top, item), multiplier)
                        .plus(new ClLinearExpression(getVariable(NSLayoutAttribute.Height, item), 0.5 * multiplier, constant));
            case NSLayoutAttribute.LastBaseline:
                if (item.equals(((UIView) item).viewForLastBaselineLayout()))
                    return new ClLinearExpression(getVariable(NSLayoutAttribute.Top, item), multiplier)
                            .plus(new ClLinearExpression(getVariable(NSLayoutAttribute.Height, item), multiplier, constant));
                return new ClLinearExpression(getVariable(NSLayoutAttribute.Top,
                        ((item instanceof UIView) ? ((UIView) item).viewForLastBaselineLayout() : null)), multiplier)
                        .plus(new ClLinearExpression(getVariable(NSLayoutAttribute.Height,
                                ((item instanceof UIView) ? ((UIView) item).viewForLastBaselineLayout() : null)), multiplier))
                        .plus(new ClLinearExpression(getVariable(NSLayoutAttribute.Top, item), multiplier, constant));
            case NSLayoutAttribute.FirstBaseline:
                return new ClLinearExpression(getVariable(NSLayoutAttribute.Top,
                        ((item instanceof UIView) ? ((UIView) item).viewForFirstBaselineLayout() : null)), 1, 0)
                        .plus(new ClLinearExpression(getVariable(NSLayoutAttribute.Height,
                                ((item instanceof UIView) ? ((UIView) item).viewForFirstBaselineLayout() : null)), 1, 0))
                        .plus(new ClLinearExpression(getVariable(NSLayoutAttribute.Top, item), 1, 0));
            case NSLayoutAttribute.LeadingMargin:
                return new ClLinearExpression(getVariable(NSLayoutAttribute.Left, item), multiplier, constant
                        + ((item instanceof UIView) ? ((UIView) item).layoutMargins.getLeft() : 0));
            case NSLayoutAttribute.LeftMargin:
                return new ClLinearExpression(getVariable(NSLayoutAttribute.Left, item), multiplier, constant
                        + ((item instanceof UIView) ? ((UIView) item).layoutMargins.getLeft() : 0));
            case NSLayoutAttribute.TrailingMargin:
                return new ClLinearExpression(getVariable(NSLayoutAttribute.Left, item), multiplier)
                        .plus(new ClLinearExpression(getVariable(NSLayoutAttribute.Width, item), multiplier, constant
                                + ((item instanceof UIView) ? ((UIView) item).layoutMargins.getRight() : 0)));
            case NSLayoutAttribute.RightMargin:
                return new ClLinearExpression(getVariable(NSLayoutAttribute.Left, item), multiplier)
                        .plus(new ClLinearExpression(getVariable(NSLayoutAttribute.Width, item), multiplier, constant
                                + ((item instanceof UIView) ? ((UIView) item).layoutMargins.getRight() : 0)));
            case NSLayoutAttribute.TopMargin:
                return new ClLinearExpression(getVariable(NSLayoutAttribute.Top, item), multiplier, constant
                        + ((item instanceof UIView) ? ((UIView) item).layoutMargins.getTop() : 0));
            case NSLayoutAttribute.BottomMargin:
                return new ClLinearExpression(getVariable(NSLayoutAttribute.Top, item), multiplier)
                        .plus(new ClLinearExpression(getVariable(NSLayoutAttribute.Height, item), multiplier, constant
                                + ((item instanceof UIView) ? ((UIView) item).layoutMargins.getRight() : 0)));
            case NSLayoutAttribute.CenterXWithinMargins:
                return new ClLinearExpression(getVariable(NSLayoutAttribute.Left, item), multiplier,
                        ((item instanceof UIView) ? ((UIView) item).layoutMargins.getLeft() : 0))
                        .plus(new ClLinearExpression(getVariable(NSLayoutAttribute.Width, item), 0.5 * multiplier, constant
                                - (((item instanceof UIView) ? ((UIView) item).layoutMargins.getLeft() : 0)
                                + ((item instanceof UIView) ? ((UIView) item).layoutMargins.getRight() : 0) / 2)));
            case NSLayoutAttribute.CenterYWithinMargins:
                return new ClLinearExpression(getVariable(NSLayoutAttribute.Left, item), multiplier,
                        ((item instanceof UIView) ? ((UIView) item).layoutMargins.getTop() : 0))
                        .plus(new ClLinearExpression(getVariable(NSLayoutAttribute.Height, item), 0.5 * multiplier, constant
                                - (((item instanceof UIView) ? ((UIView) item).layoutMargins.getTop() : 0)
                                + ((item instanceof UIView) ? ((UIView) item).layoutMargins.getBottom() : 0) / 2)));
            case NSLayoutAttribute.NotAnAttribute:
                return new ClLinearExpression(constant);
            default:
                return new ClLinearExpression(getVariable(attribute, item), multiplier, constant);
        }
    }

    private ClAbstractVariable getVariable(int attribute, Object item) {
        if (item instanceof UILayoutGuide)
            return ((UILayoutGuide) item).getVariable(attribute);
        else if (item instanceof UIViewController.LayoutSupport)
            return ((UIViewController.LayoutSupport) item).getVariable(attribute);
        else if (item instanceof UIView)
            return ((UIView) item).getVariable(attribute);
        else
            return null;    // Don't know what to do
    }

    @Override
    public String toString() {
        return SystemUtilities.getClassName(getClass()) + " first=" + firstItem + (secondItem == null ? "" : "  second=" + secondItem);
    }

}
