/*
 * (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
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
