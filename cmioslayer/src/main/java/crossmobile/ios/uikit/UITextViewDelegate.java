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

import crossmobile.ios.foundation.NSRange;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * UITextViewDelegate is the delegate that is responsible for handling
 * operations related to text view objects.
 */
@CMClass
public interface UITextViewDelegate {

    /**
     * It is used in order to permit the editing of this text view.
     *
     * @param textView The text view that corresponds to this delegate.
     * @return TRUE the editing is permitted.
     */
    @CMSelector("- (BOOL)textViewShouldBeginEditing:(UITextView *)textView")
    default boolean shouldBeginEditing(UITextView textView) {
        return true;
    }

    /**
     * It is used in order to permit the end editing of this text view.
     *
     * @param textView The text view that corresponds to this delegate.
     * @return TRUE the editing should stop.
     */
    @CMSelector("- (BOOL)textViewShouldEndEditing:(UITextView *)textView")
    default boolean shouldEndEditing(UITextView textView) {
        return true;
    }

    /**
     * It is used after the beginning of this text view's editing.
     *
     * @param textView The text view that corresponds to this delegate.
     */
    @CMSelector("- (void)textViewDidBeginEditing:(UITextView *)textView")
    default void didBeginEditing(UITextView textView) {
    }

    /**
     * It is used after the end of this text view's editing.
     *
     * @param textView The text view that corresponds to this delegate.
     */
    @CMSelector("- (void)textViewDidEndEditing:(UITextView *)textView")
    default void didEndEditing(UITextView textView) {
    }

    /**
     * It is used in order to permit the replacement of this text view's
     * content.
     *
     * @param textView The text view that corresponds to this delegate.
     * @param range    The range of the content to be replaced.
     * @param text     The text to insert.
     * @return TRUE the replacement is permitted.
     */
    @CMSelector("- (BOOL)textView:(UITextView *)textView\n" +
            "shouldChangeTextInRange:(NSRange)range\n" +
            " replacementText:(NSString *)text")
    default boolean shouldChangeTextInRange(UITextView textView, NSRange range, String text) {
        return true;
    }

    /**
     * It is used when the attributes of this text view were changed by the
     * user.
     *
     * @param textView The text view that corresponds to this delegate.
     */
    @CMSelector("- (void)textViewDidChange:(UITextView *)textView")
    default void didChange(UITextView textView) {
    }

    /**
     * It is used when the text selection of this text view was changed.
     *
     * @param textView The text view that corresponds to this delegate.
     */
    @CMSelector("- (void)textViewDidChangeSelection:(UITextView *)textView")
    default void didChangeSelection(UITextView textView) {
    }
}
