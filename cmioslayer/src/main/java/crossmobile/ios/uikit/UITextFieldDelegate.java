/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.foundation.NSRange;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * UITextFieldDelegate interface is the delegate that is responsible for
 * handling operations related to text fields.
 */
@CMClass
public interface UITextFieldDelegate {

    /**
     * It is used in order control the beginning of the editing of a text field.
     *
     * @param textField The text field that corresponds to this delegate.
     * @return TRUE if the editing of a text field can begin.
     */
    @CMSelector("- (BOOL)textFieldShouldBeginEditing:(UITextField *)textField;")
    default boolean shouldBeginEditing(UITextField textField) {
        return true;
    }

    /**
     * It is used after the editing of a text field just began.
     *
     * @param textField The text field that corresponds to this delegate.
     */
    @CMSelector("- (void)textFieldDidBeginEditing:(UITextField *)textField;")
    default void didBeginEditing(UITextField textField) {
    }

    /**
     * It is used in order to stop the editing of a text field.
     *
     * @param textField The text field that corresponds to this delegate.
     * @return TRUE the editing should stop.
     */
    @CMSelector("- (BOOL)textFieldShouldEndEditing:(UITextField *)textField;")
    default boolean shouldEndEditing(UITextField textField) {
        return true;
    }

    /**
     * It is used after the editing of a text field stopped.
     *
     * @param textField The text field that corresponds to this delegate.
     */
    @CMSelector("- (void)textFieldDidEndEditing:(UITextField *)textField;")
    default void didEndEditing(UITextField textField) {
    }

    /**
     * It is used in order to permit the change of a specified text.
     *
     * @param textField         The text field that corresponds to this delegate.
     * @param range             The range of characters to be replaced
     * @param replacementString The replacement string.
     * @return TRUE if the text is permitted to change.
     */
    @CMSelector("- (BOOL)textField:(UITextField *)textField \n"
            + "shouldChangeCharactersInRange:(NSRange)range \n"
            + "replacementString:(NSString *)string;")
    default boolean shouldChangeCharactersInRange(UITextField textField, NSRange range, String replacementString) {
        return true;
    }

    /**
     * It is used in order to permit the removal of the text field's content.
     *
     * @param textField The text field that corresponds to this delegate.
     * @return TRUE the removal of the text field's is allowed.
     */
    @CMSelector("- (BOOL)textFieldShouldClear:(UITextField *)textField;")
    default boolean shouldClear(UITextField textField) {
        return true;
    }

    /**
     * It is used in order to allow the process of the return button.
     *
     * @param textField The text field that corresponds to this delegate.
     * @return TRUE the process of the return button is allowed.
     */
    @CMSelector("- (BOOL)textFieldShouldReturn:(UITextField *)textField;")
    default boolean shouldReturn(UITextField textField) {
        return true;
    }
}
