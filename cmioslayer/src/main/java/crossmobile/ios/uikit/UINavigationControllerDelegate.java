/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * UINavigationControllerDelegate interface is the delegate responsible for
 * receiving and handling notifications from the UINavigationController.
 */
@CMClass
public interface UINavigationControllerDelegate {

    /**
     * It is used before navigation controller displays the view controller's
     * view.
     *
     * @param navigationController The navigation controller that corresponds to
     *                             this delegate.
     * @param viewController       The related view controller.
     * @param animated             Boolean that defines whether the change will be animated.
     */
    @CMSelector("- (void)navigationController:(UINavigationController *)navigationController \n"
            + "      willShowViewController:(UIViewController *)viewController \n"
            + "                    animated:(BOOL)animated;")
    default void willShowViewController(UINavigationController navigationController, UIViewController viewController, boolean animated) {
    }

    /**
     * It is used after the navigation controller displays the view controller's
     * view.
     *
     * @param navigationController The navigation controller that corresponds to
     *                             this delegate.
     * @param viewController       The related view controller.
     * @param animated             Boolean that defines whether the change will be animated.
     */
    @CMSelector("- (void)navigationController:(UINavigationController *)navigationController \n"
            + "       didShowViewController:(UIViewController *)viewController \n"
            + "                    animated:(BOOL)animated;")
    default void didShowViewController(UINavigationController navigationController, UIViewController viewController, boolean animated) {
    }
}
