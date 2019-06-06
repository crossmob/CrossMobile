/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * UIActionSheetDelegate interface is the delegate responsible for receiving and
 * handling notifications related to action sheets.
 */
@CMClass
public interface UIActionSheetDelegate {

    /**
     * It is used in order to handle the action sheet before its presentation to
     * the user.
     *
     * @param actionSheet The action sheet that corresponds to this delegate.
     */
    @Deprecated
    @CMSelector("- (void)willPresentActionSheet:(UIActionSheet *)actionSheet;")
    default void willPresentActionSheet(UIActionSheet actionSheet) {
    }

    /**
     * It is used in order to handle the action sheet after its presentation to
     * the user.
     *
     * @param actionSheet The action sheet that corresponds to this delegate.
     */
    @Deprecated
    @CMSelector("- (void)didPresentActionSheet:(UIActionSheet *)actionSheet;")
    default void didPresentActionSheet(UIActionSheet actionSheet) {
    }

    /**
     * It is used in order to handle the dismission of the action sheet before a
     * click on the specified button.
     *
     * @param actionSheet The action sheet that corresponds to this delegate.
     * @param buttonIndex The button related to the dismissal of the action
     *                    sheet.
     */
    @Deprecated
    @CMSelector("- (void)actionSheet:(UIActionSheet *)actionSheet \n" +
            "willDismissWithButtonIndex:(NSInteger)buttonIndex;")
    default void willDismissWithButtonIndex(UIActionSheet actionSheet, int buttonIndex) {
    }

    /**
     * It is used in order to handle the dismission of the action sheet after a
     * click on the specified button.
     *
     * @param actionSheet The action sheet that corresponds to this delegate.
     * @param buttonIndex The button that causes the dismissal of the action
     *                    sheet.
     */
    @Deprecated
    @CMSelector("- (void)actionSheet:(UIActionSheet *)actionSheet \n" +
            "didDismissWithButtonIndex:(NSInteger)buttonIndex;")
    default void didDismissWithButtonIndex(UIActionSheet actionSheet, int buttonIndex) {
    }

    /**
     * It is used in order to handle user's click on the specified button of the
     * action sheet.
     *
     * @param actionSheet The action sheet that corresponds to this delegate.
     * @param buttonIndex The button that the user clicked.
     */
    @Deprecated
    @CMSelector("- (void)actionSheet:(UIActionSheet *)actionSheet \n" +
            "clickedButtonAtIndex:(NSInteger)buttonIndex;")
    default void clickedButtonAtIndex(UIActionSheet actionSheet, int buttonIndex) {
    }

    /**
     * It is used to handle the cancellation of the specified action sheet.
     *
     * @param actionSheet The action sheet that corresponds to this delegate.
     */
    @CMSelector("- (void)actionSheetCancel:(UIActionSheet *)actionSheet;")
    default void cancel(UIActionSheet actionSheet) {
    }
}
