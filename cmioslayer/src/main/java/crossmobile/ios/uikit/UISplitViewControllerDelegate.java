/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * UISplitViewControllerDelegate interface is the delegate responsible for
 * handing changes to split view interfaces such as collapsing and expanding.
 */
@CMClass
public interface UISplitViewControllerDelegate {

    /**
     * It is used in order to handle a view controller that is about to be
     * hidden.
     *
     * @param svc             The split view controller that that corresponds to this
     *                        delegate.
     * @param aViewController The view controller that is about to be hidden.
     * @param barButtonItem   The bar button item related to this action that can
     *                        be added to the bar.
     * @param pc              The related popover controller.
     */
    @Deprecated
    @CMSelector("- (void)splitViewController:(UISplitViewController *)svc \n"
            + "     willHideViewController:(UIViewController *)aViewController \n"
            + "          withBarButtonItem:(UIBarButtonItem *)barButtonItem \n"
            + "       forPopoverController:(UIPopoverController *)pc;")
    default void willHideViewController(UISplitViewController svc, UIViewController aViewController, UIBarButtonItem barButtonItem, UIPopoverController pc) {

    }

    /**
     * It is used to in order to handle a view controller that is about to be
     * shown again.
     *
     * @param svc             The split view controller that corresponds to this delegate.
     * @param aViewController The view controller that is about to be shown
     *                        again.
     * @param barButtonItem   The bar button item of the bar related to this
     *                        action.
     */
    @CMSelector("- (void)splitViewController:(UISplitViewController *)svc \n"
            + "     willShowViewController:(UIViewController *)aViewController \n"
            + "  invalidatingBarButtonItem:(UIBarButtonItem *)barButtonItem;")
    default void willShowViewController(UISplitViewController svc, UIViewController aViewController, UIBarButtonItem barButtonItem) {
    }

    /**
     * It is used when a hidden view controller is about to be shown in a
     * popover.
     *
     * @param svc             The split view controller that corresponds to this delegate.
     * @param pc              The related popover controller.
     * @param aViewController The view controller that is about to be shown
     *                        again.
     */
    @Deprecated
    @CMSelector("- (void)splitViewController:(UISplitViewController *)svc \n"
            + "          popoverController:(UIPopoverController *)pc \n"
            + "  willPresentViewController:(UIViewController *)aViewController;")
    default void popoverController(UISplitViewController svc, UIPopoverController pc, UIViewController aViewController) {
    }

    /**
     * It is used in order to control whether the first view controller should
     * be hidden concerning the given orientation.
     *
     * @param svc         The split view controller that corresponds to this delegate.
     * @param vc          The first view controller that is about to be hidden.
     * @param orientation The orientation.
     * @return TRUE if the first view controller should be hidden.
     */
    @CMSelector("- (BOOL)splitViewController:(UISplitViewController *)svc \n"
            + "   shouldHideViewController:(UIViewController *)vc \n"
            + "              inOrientation:(UIInterfaceOrientation)orientation;")
    default boolean shouldHideViewController(UISplitViewController svc, UIViewController vc, int orientation) {
        return true;
    }

    /**
     * It is used when the split view controller's display mode is going to
     * change.
     *
     * @param svc                              The split view controller that corresponds to this delegate.
     * @param UISplitViewControllerDisplayMode The new display mode of the view
     *                                         controller.
     */
    @CMSelector("- (void)splitViewController:(UISplitViewController *)svc \n"
            + "    willChangeToDisplayMode:(UISplitViewControllerDisplayMode)displayMode;")
    default void willChangeToDisplayMode(UISplitViewController svc, int UISplitViewControllerDisplayMode) {
    }

    /**
     * It is used in order to determine the display mode after a split view
     * controller action.
     *
     * @param svc The split view controller that corresponds to this delegate.
     * @return The display mode of the split view controller.
     */
    @CMSelector("- (UISplitViewControllerDisplayMode)targetDisplayModeForActionInSplitViewController:(UISplitViewController *)svc;")
    default int targetDisplayModeForActionInSplitViewController(UISplitViewController svc) {
        return UISplitViewControllerDisplayMode.Automatic;
    }

    /**
     * It is used in order to determine the orientation of the split view
     * controller.
     *
     * @param splitViewController The split view controller that corresponds to
     *                            this delegate.
     * @return The orientation of the split view controller.
     */
    @CMSelector("- (UIInterfaceOrientation)splitViewControllerPreferredInterfaceOrientationForPresentation:(UISplitViewController *)splitViewController;")
    default int preferredInterfaceOrientationForPresentation(UISplitViewController splitViewController) {
        return UIInterfaceOrientationMask.All;
    }

    /**
     * It is used in order to determine the supported orientations of the split
     * view controller.
     *
     * @param splitViewController The split view controller that corresponds to
     *                            this delegate.
     * @return The supported orientations of the split view controller.
     */
    @CMSelector("- (UIInterfaceOrientationMask)splitViewControllerSupportedInterfaceOrientations:(UISplitViewController *)splitViewController;")
    default int supportedInterfaceOrientations(UISplitViewController splitViewController) {
        return UIInterfaceOrientationMask.All;
    }

    /**
     * It is used in order to determine the single view controller that will be
     * displayed after a collapse.
     *
     * @param splitViewController The split view controller that corresponds to
     *                            this delegate.
     * @return The single view controller to be displayed.
     */
    @CMSelector("- (UIViewController *)primaryViewControllerForCollapsingSplitViewController:(UISplitViewController *)splitViewController;")
    default UIViewController primaryViewControllerForCollapsingSplitViewController(UISplitViewController splitViewController) {
        return null;
    }

    /**
     * It is used in order to add a secondary view controller after adjusting
     * the primary in a collapsed interface.
     *
     * @param splitViewController     The split view controller that corresponds to
     *                                this delegate.
     * @param secondaryViewController The secondary view controller.
     * @param primaryViewController   The primary view controller.
     * @return FALSE the split view controller tries to add the secondary view
     * controller.
     */
    @CMSelector("- (BOOL)splitViewController:(UISplitViewController *)splitViewController \n"
            + "collapseSecondaryViewController:(UIViewController *)secondaryViewController \n"
            + "  ontoPrimaryViewController:(UIViewController *)primaryViewController;")
    default boolean collapseSecondaryViewController(UISplitViewController splitViewController, UIViewController secondaryViewController, UIViewController primaryViewController) {
        return true;
    }

    /**
     * It is used when the split view interface expands in order to provide the
     * view controller.
     *
     * @param splitViewController The split view controller that corresponds to
     *                            this delegate.
     * @return The view controller to use.
     */
    @CMSelector("- (UIViewController *)primaryViewControllerForExpandingSplitViewController:(UISplitViewController *)splitViewController;")
    default UIViewController primaryViewControllerForExpandingSplitViewController(UISplitViewController splitViewController) {
        return null;
    }

    /**
     * It is used in when a new secondary view controller is needed.
     *
     * @param splitViewController   The split view controller that corresponds to
     *                              this delegate.
     * @param primaryViewController The related primary view controller.
     * @return The secondary view controller.
     */
    @CMSelector("- (UIViewController *)splitViewController:(UISplitViewController *)splitViewController \n"
            + "separateSecondaryViewControllerFromPrimaryViewController:(UIViewController *)primaryViewController;")
    default UIViewController separateSecondaryViewControllerFromPrimaryViewController(UISplitViewController splitViewController, UIViewController primaryViewController) {
        return null;
    }

    /**
     * It is used in order to control the process of changing the primary view
     * controller.
     *
     * @param splitViewController The split view controller that corresponds to
     *                            this delegate.
     * @param vc                  The new primary view controller.
     * @param sender              The object that requests this.
     * @return FALSE the split view controller takes over it.
     */
    @CMSelector("- (BOOL)splitViewController:(UISplitViewController *)splitViewController \n"
            + "         showViewController:(UIViewController *)vc \n"
            + "                     sender:(id)sender;")
    default boolean showViewController(UISplitViewController splitViewController, UIViewController vc, Object sender) {
        return true;
    }

    /**
     * It is used in order to control the process of changing the secondary view
     * controller.
     *
     * @param splitViewController The split view controller that corresponds to
     *                            this delegate.
     * @param vc                  The current secondary view controller.
     * @param sender              The object that requests this.
     * @return FALSE the split view controller takes over it.
     */
    @CMSelector("- (BOOL)splitViewController:(UISplitViewController *)splitViewController \n"
            + "   showDetailViewController:(UIViewController *)vc \n"
            + "                     sender:(id)sender;")
    default boolean showDetailViewController(UISplitViewController splitViewController, UIViewController vc, Object sender) {
        return true;
    }
}
