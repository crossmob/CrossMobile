/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGAffineTransform;
import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.coregraphics.CGRect;
import org.crossmobile.bind.graphics.GraphicsBridgeConstants;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * UISplitViewController class defines a view controller that is the root view
 * controller of the application. It manages the arrangement of the child view
 * controllers.
 */
@CMClass
public class UISplitViewController extends UIViewController {

    private UISplitViewControllerDelegate delegate;

    private SplitView splitView;
    private UIView detail;
    private UIView master;
    private boolean compact;

    private List<UIViewController> viewControllers;
    private boolean presentsWithGesture = true;
    private int preferredDisplayMode = UISplitViewControllerDisplayMode.Automatic;
    private int displayMode = UISplitViewControllerDisplayMode.Automatic;
    private boolean isCollapsed;
    private double preferredPrimaryColumnWidthFraction = AutomaticDimension;
    private double minimumPrimaryColumnWidth = AutomaticDimension;
    private double maximumPrimaryColumnWidth = AutomaticDimension;
    private double primaryColumnWidth;

    List<NSLayoutConstraint> constraints = new ArrayList<>();

    public static final float AutomaticDimension = -340282346638528859811704183484516925440.000000f;

    private UIViewController masterController;
    private UIViewController detailController;
    private UIBarButtonItem displayModeButtonItem;

    /**
     * Returns the array of view controllers that this UISplitViewController
     * manages.
     *
     * @return The array of view controllers that this UISplitViewController
     * manages.
     */
    @CMGetter("@property(nonatomic, copy) NSArray<__kindof UIViewController *> *viewControllers;")
    public List<UIViewController> viewControllers() {
        return new ArrayList<>(viewControllers);
    }

    /**
     * Sets the specified array of view controllers as the set that this
     * UISplitViewController manages.
     *
     * @param viewControllers The array of view controllers that this
     *                        UISplitViewController manages.
     */
    @CMSetter("@property(nonatomic, copy) NSArray<__kindof UIViewController *> *viewControllers;")
    public void setViewControllers(List<UIViewController> viewControllers) {
        if (viewControllers.size() < 2)
            return;
        this.viewControllers = viewControllers;
        masterController = viewControllers.get(0);
        masterController.setParentController(this);
        detailController = viewControllers.get(1);
        detailController.setParentController(this);
    }

    /**
     * Returns a Boolean that shows whether this UISplitViewController can show
     * up or conceal with a swipe gesture.
     *
     * @return A Boolean that shows whether this UISplitViewController can show
     * up or conceal with a swipe gesture.
     */
    @CMGetter("@property(nonatomic) BOOL presentsWithGesture;")
    public boolean presentsWithGesture() {
        return presentsWithGesture;
    }

    /**
     * Sets a Boolean that defines whether this UISplitViewController can show
     * up or conceal with a swipe gesture.
     *
     * @param presentsWithGesture A Boolean that defines whether this
     *                            UISplitViewController can show up or conceal with a swipe gesture.
     */
    @CMSetter("@property(nonatomic) BOOL presentsWithGesture;")
    public void setPresentsWithGesture(boolean presentsWithGesture) {
        this.presentsWithGesture = presentsWithGesture;
    }

    /**
     * Returns the preferred display mode of this split view controller.
     *
     * @return The preferred display mode of this split view controller.
     */
    @CMGetter("@property(nonatomic) UISplitViewControllerDisplayMode preferredDisplayMode;")
    public int preferredDisplayMode() {
        return preferredDisplayMode;
    }

    /**
     * Sets the preferred display mode for this split view controller.
     *
     * @param UISplitViewControllerDisplayMode The preferred display mode for
     *                                         this split view controller.
     */
    @CMSetter("@property(nonatomic) UISplitViewControllerDisplayMode preferredDisplayMode;")
    public void setPreferredDisplayMode(int UISplitViewControllerDisplayMode) {
        this.preferredDisplayMode = UISplitViewControllerDisplayMode;
    }

    /**
     * Returns the display mode for this split view controller.
     *
     * @return The display mode for the split view controller.
     * @see crossmobile.ios.uikit.UISplitViewControllerDisplayMode
     */
    @CMGetter("@property(nonatomic, readonly) UISplitViewControllerDisplayMode displayMode;")
    public int displayMode() {
        return displayMode;
    }

    /**
     * Returns the button of this UISplitViewController. This button changes the
     * state of it.
     *
     * @return The button of this UISplitViewController.
     */
    @CMSelector("- (UIBarButtonItem *)displayModeButtonItem;")
    public UIBarButtonItem displayModeButtonItem() {
        return null;
    }

    /**
     * Returns a Boolean that shows whether only one child of the view
     * controller is displayed.
     *
     * @return A Boolean that shows whether only one child of the view
     * controller is displayed.
     */
    @CMGetter("@property(nonatomic, readonly, getter=isCollapsed) BOOL collapsed;")
    public boolean isCollapsed() {
        return checkCompact();
    }

    /**
     * Returns the relative width of content of the primary view controller.
     *
     * @return The relative width of content of the primary view controller.
     */
    @CMGetter("@property(nonatomic, assign) CGFloat preferredPrimaryColumnWidthFraction;")
    public double preferredPrimaryColumnWidthFraction() {
        return preferredPrimaryColumnWidthFraction == AutomaticDimension ? 0.4f : preferredPrimaryColumnWidthFraction;
    }

    /**
     * Sets the relative width for content of the primary view controller.
     *
     * @param preferredPrimaryColumnWidthFraction The relative width for content
     *                                            of the primary view controller.
     */
    @CMSetter("@property(nonatomic, assign) CGFloat preferredPrimaryColumnWidthFraction;")
    public void setPreferredPrimaryColumnWidthFraction(double preferredPrimaryColumnWidthFraction) {
        this.preferredPrimaryColumnWidthFraction = preferredPrimaryColumnWidthFraction;
    }

    /**
     * Returns the width of content of the primary view controller expressed in
     * points.
     *
     * @return The width of content of the primary view controller expressed in
     * points.
     */
    @CMGetter("@property(nonatomic, readonly) CGFloat primaryColumnWidth;")
    public double primaryColumnWidth() {
        return master.cframe().getSize().getWidth();
    }

    /**
     * Returns the minimum width of content of the primary view controller
     * expressed in points.
     *
     * @return The minimum width of content of the primary view controller
     * expressed in points.
     */
    @CMGetter("@property(nonatomic, assign) CGFloat minimumPrimaryColumnWidth;")
    public double minimumPrimaryColumnWidth() {
        return minimumPrimaryColumnWidth == AutomaticDimension ? 0 : minimumPrimaryColumnWidth;
    }

    /**
     * Sets the minimum width for content of the primary view controller
     * expressed in points.
     *
     * @param minimumPrimaryColumnWidth The minimum width for content of the
     *                                  primary view controller expressed in points.
     */
    @CMSetter("@property(nonatomic, assign) CGFloat minimumPrimaryColumnWidth;")
    public void setMinimumPrimaryColumnWidth(double minimumPrimaryColumnWidth) {
        this.minimumPrimaryColumnWidth = minimumPrimaryColumnWidth;
    }

    /**
     * Returns the maximum width of content of the primary view controller
     * expressed in points.
     *
     * @return The maximum width of content of the primary view controller
     * expressed in points.
     */
    @CMGetter("@property(nonatomic, assign) CGFloat maximumPrimaryColumnWidth;")
    public double maximumPrimaryColumnWidth() {
        return maximumPrimaryColumnWidth == AutomaticDimension ? 320 : maximumPrimaryColumnWidth;
    }

    /**
     * Sets the maximum width for content of the primary view controller
     * expressed in points.
     *
     * @param maximumPrimaryColumnWidth The maximum width for content of the
     *                                  primary view controller expressed in points.
     */
    @CMSetter("@property(nonatomic, assign) CGFloat maximumPrimaryColumnWidth;")
    public void setMaximumPrimaryColumnWidth(double maximumPrimaryColumnWidth) {
        this.maximumPrimaryColumnWidth = maximumPrimaryColumnWidth;
    }

    /**
     * Returns specified delegate of this UISplitViewController.
     *
     * @return The specified delegate of this UISplitViewController.
     */
    @CMGetter("@property(nonatomic, weak) id<UISplitViewControllerDelegate> delegate;")
    public UISplitViewControllerDelegate delegate() {
        return delegate;
    }

    /**
     * Set the specified delegate of this UISplitViewController.
     *
     * @param delegate The specified delegate of this UISplitViewController.
     */
    @CMSetter("@property(nonatomic, weak) id<UISplitViewControllerDelegate> delegate;")
    public void setDelegate(UISplitViewControllerDelegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Presents the specified UISplitViewController as the secondary controller
     * of this UISplitViewController.
     *
     * @param vc     The secondary controller of this UISplitViewController.
     * @param sender The object that applied this request.
     */
    @CMSelector("- (void)showDetailViewController:(UIViewController *)vc \n"
            + "                          sender:(id)sender;")
    @Override
    public void showDetailViewController(final UIViewController vc, Object sender) {
        Native.widget().resignFocus();

        if (isCollapsed()) {
            if (masterController instanceof UINavigationController)
                if (vc instanceof UINavigationController)
                    ((UINavigationController) masterController).pushViewController(((UINavigationController) vc).popViewControllerAnimated(false), true);
                else
                    ((UINavigationController) masterController).pushViewController(vc, true);
            else if (vc instanceof UINavigationController)
                masterController.navigationController().pushViewController(((UINavigationController) vc).popViewControllerAnimated(false), true);
            else
                masterController.navigationController().pushViewController(vc, true);
            renewDetail(vc);
        } else if (detailController instanceof UINavigationController)
            ((UINavigationController) detailController).pushViewController(vc, true);
        else {
            if (vc.view() == detail)
                return;
            if (vc instanceof UINavigationController)
                ((UINavigationController) vc).updateView(null, UIViewAnimationOptions.TransitionNone);
            vc.view().setFrame(new CGRect(splitView.cframe().getSize().getWidth(), detail.cframe().getOrigin().getY(), detail.cframe().getSize().getWidth(), detail.cframe().getSize().getHeight()));   // do this before animations!
            splitView.addSubview(vc.view());
            UIView.animateWithDuration(GraphicsBridgeConstants.DefaultAnimationDuration, 0, UIViewAnimationOptions.CurveEaseInOut, () -> vc.view().setLocation(detail.cframe().getOrigin().getX(), detail.cframe().getOrigin().getY()), result -> {
                UIView detailOld = detail;
                renewDetail(vc);
                updateView(true);
                detailOld.removeFromSuperview();
            });
        }
    }

    private void renewDetail(UIViewController vc) {
        viewControllers.remove(detailController);
        viewControllers.add(1, vc);
        detailController = vc;
        detailController.setParentController(this);
        splitView.layoutSubviews();
    }

    /**
     * Presents the specified UISplitViewController as the primary controller of
     * this UISplitViewController.
     *
     * @param vc     The primary controller of this UISplitViewController.
     * @param sender The object that applied this request.
     */
    @Override
    public void showViewController(final UIViewController vc, Object sender) {
        if (isCollapsed()) {
            if (masterController instanceof UINavigationController) {
                ((UINavigationController) masterController).viewControllers().add(0, vc);
                ((UINavigationController) masterController).popToRootViewControllerAnimated(true);
            } else {
                masterController.navigationController().viewControllers().add(0, vc);
                masterController.navigationController().popToRootViewControllerAnimated(true);
            }
            renewMaster(vc, true);
        } else {
            if (vc.view() == master)
                return;
            vc.view().setFrame(new CGRect(-master.cframe().getSize().getWidth(), master.cframe().getOrigin().getY(), master.cframe().getSize().getWidth(), master.cframe().getSize().getHeight()));   // do this before animations!
            splitView.addSubview(vc.view());
            UIView.animateWithDuration(GraphicsBridgeConstants.DefaultAnimationDuration, 0, UIViewAnimationOptions.CurveEaseInOut, () -> vc.view().setLocation(master.cframe().getOrigin().getX(), master.cframe().getOrigin().getY()), completion -> {
                UIView masterOld = master;
                renewMaster(vc, false);
                masterOld.removeFromSuperview();
            });
        }
    }

    private void renewMaster(UIViewController vc, boolean primaryHidden) {
        viewControllers.remove(masterController);
        viewControllers.add(0, vc);
        masterController = vc;
        masterController.setParentController(this);
        if (primaryHidden)
            primaryHidden(false, true);
        else
            updateView(true);
        splitView.layoutSubviews();
    }

    @Override
    public void loadView() {
        splitView = new SplitView();
        updateView(true);
        setView(splitView);
    }

    void updateView(boolean onRotate) {
        compact = checkCompact();
        if (splitView.showsOverlay)
            splitView.hideOverlay(false);
        switch (preferredDisplayMode) {
            case UISplitViewControllerDisplayMode.Automatic:
                if (checkCompact() && (displayMode != UISplitViewControllerDisplayMode.PrimaryHidden || onRotate))
                    primaryHidden(true, onRotate);
                else if (!checkCompact() && (displayMode != UISplitViewControllerDisplayMode.AllVisible || onRotate))
                    allVisible();
                break;
            case UISplitViewControllerDisplayMode.AllVisible:
                if (checkCompact() && (displayMode != UISplitViewControllerDisplayMode.PrimaryHidden || onRotate))
                    primaryHidden(true, onRotate);
                else if (!checkCompact() && (displayMode != UISplitViewControllerDisplayMode.AllVisible || onRotate))
                    allVisible();
                break;
            case UISplitViewControllerDisplayMode.PrimaryHidden:
                primaryHidden(true, onRotate);
                break;
            case UISplitViewControllerDisplayMode.PrimaryOverlay:
                if (checkCompact() && (displayMode != UISplitViewControllerDisplayMode.PrimaryHidden || onRotate)) {
                    if (master != null && master.isHidden())
                        master.setHidden(false);
                    primaryHidden(true, onRotate);
                } else if (!checkCompact() && (displayMode != UISplitViewControllerDisplayMode.PrimaryOverlay || onRotate))
                    primaryOverlay();
                break;
        }
    }

    private boolean checkCompact() {
        return splitView.cframe().getSize().getWidth() < splitView.cframe().getSize().getHeight();
    }

    synchronized void allVisible() {
        if (delegate != null && displayMode != UISplitViewControllerDisplayMode.AllVisible)
            delegate.willChangeToDisplayMode(this, UISplitViewControllerDisplayMode.AllVisible);
        clean();
        displayMode = UISplitViewControllerDisplayMode.AllVisible;
        master = masterController.view();
        detail = detailController.view();
        if (detailController instanceof UINavigationController)
            ((UINavigationController) detailController).updateView(null, UIViewAnimationOptions.TransitionNone);
        splitView.addSubview(detail);
        detail.setTranslatesAutoresizingMaskIntoConstraints(false);
        splitView.addSubview(master);
        master.setTranslatesAutoresizingMaskIntoConstraints(false);
        NSLayoutConstraint fraction = master.widthAnchor().constraintEqualToAnchor(splitView.widthAnchor(), (float) (preferredPrimaryColumnWidthFraction == AutomaticDimension ? 0.4 : preferredPrimaryColumnWidthFraction));
        fraction.setPriority(UILayoutPriority.DefaultLow);
        constraints.add(fraction);
        constraints.add(master.widthAnchor().constraintLessThanOrEqualToConstant((float) (minimumPrimaryColumnWidth == AutomaticDimension ? 0 : minimumPrimaryColumnWidth)));
        constraints.add(master.widthAnchor().constraintGreaterThanOrEqualToConstant((float) (maximumPrimaryColumnWidth == AutomaticDimension ? 320 : maximumPrimaryColumnWidth)));
        constraints.add(master.heightAnchor().constraintEqualToAnchor(splitView.heightAnchor()));
        constraints.add(master.leadingAnchor().constraintEqualToAnchor(splitView.leadingAnchor()));
        constraints.add(master.topAnchor().constraintEqualToAnchor(splitView.topAnchor()));
        constraints.add(detail.heightAnchor().constraintEqualToAnchor(splitView.heightAnchor()));
        constraints.add(detail.leadingAnchor().constraintEqualToAnchor(master.trailingAnchor()));
        constraints.add(detail.trailingAnchor().constraintEqualToAnchor(splitView.trailingAnchor()));
        constraints.add(detail.topAnchor().constraintEqualToAnchor(splitView.topAnchor()));
        load();
    }

    synchronized void primaryOverlay() {
        if (delegate != null && displayMode != UISplitViewControllerDisplayMode.PrimaryOverlay)
            delegate.willChangeToDisplayMode(this, UISplitViewControllerDisplayMode.PrimaryOverlay);
        clean();
        displayMode = UISplitViewControllerDisplayMode.PrimaryOverlay;
        master = masterController.view();
        if (detailController instanceof UINavigationController)
            ((UINavigationController) detailController).updateView(null, UIViewAnimationOptions.TransitionNone);
        detail = detailController.view();
        splitView.addSubview(master);
        splitView.addSubview(detail);
        detail.setTranslatesAutoresizingMaskIntoConstraints(false);
        master.setHidden(true);
        master.setTranslatesAutoresizingMaskIntoConstraints(false);
        constraints.add(master.widthAnchor().constraintEqualToAnchor(splitView.widthAnchor(), (float) (preferredPrimaryColumnWidthFraction == AutomaticDimension ? 0.4 : preferredPrimaryColumnWidthFraction)));
        constraints.add(master.widthAnchor().constraintLessThanOrEqualToConstant((float) (minimumPrimaryColumnWidth == AutomaticDimension ? 0 : minimumPrimaryColumnWidth)));
        constraints.add(master.widthAnchor().constraintGreaterThanOrEqualToConstant((float) (maximumPrimaryColumnWidth == AutomaticDimension ? 320 : maximumPrimaryColumnWidth)));
        constraints.add(master.heightAnchor().constraintEqualToAnchor(splitView.heightAnchor()));
        constraints.add(master.trailingAnchor().constraintEqualToAnchor(splitView.leadingAnchor()));
        constraints.add(master.topAnchor().constraintEqualToAnchor(splitView.topAnchor()));
        constraints.add(detail.heightAnchor().constraintEqualToAnchor(splitView.heightAnchor()));
        constraints.add(detail.leadingAnchor().constraintEqualToAnchor(master.trailingAnchor()));
        constraints.add(detail.trailingAnchor().constraintEqualToAnchor(splitView.trailingAnchor()));
        constraints.add(detail.topAnchor().constraintEqualToAnchor(splitView.topAnchor()));
        load();
    }

    private synchronized void primaryHidden(boolean showdetail, boolean onrotate) {
        if (delegate != null && displayMode != UISplitViewControllerDisplayMode.PrimaryHidden)
            delegate.willChangeToDisplayMode(this, UISplitViewControllerDisplayMode.PrimaryHidden);
        clean();
        displayMode = UISplitViewControllerDisplayMode.PrimaryHidden;
        UINavigationController nc;
        nc = (UINavigationController) ((masterController instanceof UINavigationController) ? masterController : new UINavigationController(masterController));
        if (showdetail) {
            if (!detailController.isViewLoaded())
                detailController.loadView();
            if (detailController instanceof UINavigationController) {
                ((UINavigationController) detailController).updateView(null, UIViewAnimationOptions.TransitionNone);
                nc.pushViewController(((UINavigationController) detailController).popViewControllerAnimated(false), false);
            } else
                nc.pushViewController(detailController, false);
        }
        master = masterController.view();
        splitView.addSubview(nc.view());
        nc.view().setTranslatesAutoresizingMaskIntoConstraints(false);
        constraints.add(nc.view().heightAnchor().constraintEqualToAnchor(splitView.heightAnchor()));
        constraints.add(nc.view().leadingAnchor().constraintEqualToAnchor(splitView.leadingAnchor()));
        constraints.add(nc.view().trailingAnchor().constraintEqualToAnchor(splitView.trailingAnchor()));
        constraints.add(nc.view().topAnchor().constraintEqualToAnchor(splitView.topAnchor()));
        load();
    }

    @Override
    public void didReceiveMemoryWarning() {
        for (UIViewController vc : viewControllers)
            vc.didReceiveMemoryWarning();
        super.didReceiveMemoryWarning();
    }

    private void clean() {
        NSLayoutConstraint.deactivateConstraints(constraints);
        constraints.clear();
        if (displayMode == UISplitViewControllerDisplayMode.PrimaryHidden && (masterController instanceof UINavigationController) && ((UINavigationController) masterController).topViewController().equals(detailController))
            ((UINavigationController) masterController).popViewControllerAnimated(false);
        for (UIView old : splitView.subviews())
            old.removeFromSuperview();
    }

    private void load() {
        NSLayoutConstraint.activateConstraints(constraints);
        splitView.layoutSubviews();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void willRotateToInterfaceOrientation(int UIInterfaceOrientation, double duration) {
        if (splitView.showsOverlay)
            splitView.hideOverlay(false);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void didRotateFromInterfaceOrientation(int UIInterfaceOrientation) {
//        if (splitView.showsOverlay)
//            splitView.hideOverlay();
        updateView(true);
        splitView.setNeedsLayout();
    }

    private class SplitView extends UIView {

        private CGPoint startpoint;
        private boolean showsOverlay = false;

        @Override
        public void setFrame(CGRect frame) {
            super.setFrame(frame);
            updateView(false);
        }

        @Override
        public void touchesCancelled(Set<UITouch> touches, UIEvent event) {
            super.touchesCancelled(touches, event); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void touchesEnded(Set<UITouch> touches, UIEvent event) {
            if (presentsWithGesture) {
                CGPoint click = touches.iterator().next().locationInView(this);
                if (startpoint == null)
                    return;
                double dx = click.getX() - startpoint.getX();
                if (displayMode == UISplitViewControllerDisplayMode.PrimaryOverlay && dx < 0)
                    if (showsOverlay)
                        hideOverlay();
//                    showOverlay();
            }
        }

        @Override
        public void touchesMoved(Set<UITouch> touches, UIEvent event) {
            if (presentsWithGesture) {
                CGPoint click;
                click = touches.iterator().next().locationInView(this);
                if (startpoint == null)
                    return;
                double dx = click.getX() - startpoint.getX();
                if (!isCollapsed()) {
                    if (displayMode == UISplitViewControllerDisplayMode.PrimaryOverlay)
                        if (showsOverlay && dx < 0)
                            hideOverlay();
                        else if (!showsOverlay && dx > 20)
                            showOverlay();
                } else if (displayMode == UISplitViewControllerDisplayMode.PrimaryHidden && dx > 20)
                    if ((masterController instanceof UINavigationController) && ((UINavigationController) masterController).viewControllers().size() > 1)
                        ((UINavigationController) masterController).popViewControllerAnimated(true);
                    else if (!(masterController instanceof UINavigationController) && masterController.navigationController().viewControllers().size() > 1)
                        masterController.navigationController().popViewControllerAnimated(true);
            }
        }

        @Override
        public void touchesBegan(Set<UITouch> touches, UIEvent event) {
            if (presentsWithGesture) {
                startpoint = null;
                CGPoint click = touches.iterator().next().locationInView(this);
                if (click.getX() < 20 && !showsOverlay)
                    startpoint = touches.iterator().next().locationInView(this);
                if (showsOverlay && click.getX() > master.cframe().getSize().getWidth())
                    hideOverlay();
            }
        }

        void showOverlay() {
            master.setHidden(false);
            splitView.bringSubviewToFront(master);
            UIView.animateWithDuration(GraphicsBridgeConstants.DefaultAnimationDuration, () -> master.setTransform(CGAffineTransform.makeTranslation((float) (cframe().getSize().getWidth() * preferredPrimaryColumnWidthFraction()), 0)));
            showsOverlay = true;
        }

        void hideOverlay() {
            hideOverlay(true);
        }

        void hideOverlay(boolean animated) {
            CGAffineTransform trans = CGAffineTransform.makeTranslation(0, 0);
            if (!animated)
                master.setTransform(transform);
            else
                UIView.animateWithDuration(GraphicsBridgeConstants.DefaultAnimationDuration, 0, UIViewAnimationOptions.CurveEaseInOut, () -> master.setTransform(trans), completion -> {
                    splitView.bringSubviewToFront(detail);
                    master.setHidden(true);
                });
            showsOverlay = false;
        }

    }

    @Override
    CGRect getActiveFrame() {
        return splitView.frame();
    }

}
