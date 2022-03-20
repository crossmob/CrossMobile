/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

@CMClass
public interface UITextInputTraits {

    /**
     * property fields easy access
     * private int autocapitalizationType = UITextAutocapitalizationType.Sentences;
     * private int autocorrectionType = UITextAutocorrectionType.Default;
     * private int spellCheckingType = UITextSpellCheckingType.Default;
     * private int smartQuotesType = UITextSmartQuotesType.Default;
     * private int smartDashesType = UITextSmartDashesType.Default;
     * private int smartInsertDeleteType = UITextSmartInsertDeleteType.Default;
     * private int keyboardType = UIKeyboardType.Default;
     * private int keyboardAppearance = UIKeyboardAppearance.Default;
     * private int returnKeyType = UIReturnKeyType.Default;
     * private boolean enablesReturnKeyAutomatically = false;
     * private boolean isSecureTextEntry = false;
     * private String textContentType = null;
     **/


    /**
     * Returns the type of auto-capitalization of the content of the text field.
     *
     * @return The type of auto-capitalization of the content of the text field.
     */
    @CMGetter("@property(nonatomic) UITextAutocapitalizationType autocapitalizationType;")
    default int autocapitalizationType() {
        return UITextAutocapitalizationType.Sentences;
    }

    /**
     * Sets the type of auto-capitalization for the content of the text field.
     *
     * @param UITextAutocapitalizationType The auto-capitalization style for the
     *                                     content of the text field.
     * @see crossmobile.ios.uikit.UITextAutocapitalizationType
     */
    @CMSetter("@property(nonatomic) UITextAutocapitalizationType autocapitalizationType;")
    default void setAutocapitalizationType(int UITextAutocapitalizationType) {
    }

    /**
     * Returns the type of auto-correction of the content of this text field.
     *
     * @return The type of auto-correction of the content of this text field.
     */
    @CMGetter("@property(nonatomic) UITextAutocorrectionType autocorrectionType;")
    default int autocorrectionType() {
        return UITextAutocorrectionType.Default;
    }

    /**
     * Sets the type of auto-correction for the content of this text field.
     *
     * @param UITextAutocorrectionType The type of auto-correction for the
     *                                 content of this text field.
     * @see crossmobile.ios.uikit.UITextAutocorrectionType
     */
    @CMSetter("@property(nonatomic) UITextAutocorrectionType autocorrectionType;")
    default void setAutocorrectionType(int UITextAutocorrectionType) {
    }

    /**
     * The auto correction type for the text
     * @return The auto correction type for the text
     */
    @CMGetter("@property(nonatomic) UITextSpellCheckingType spellCheckingType;")
    default int spellCheckingType() {
        return UITextSpellCheckingType.Default;
    }

    /**
     * Sets the auto spell checking type for the text
     * @param UITextSpellCheckingType The auto spell checking type for the text
     */
    @CMSetter("@property(nonatomic) UITextSpellCheckingType spellCheckingType;")
    default void setSpellCheckingType(int UITextSpellCheckingType) {
    }

    /**
     * The smart quotes type for the text
     * @return The smart quotes type for the text
     */
    @CMGetter("@property(nonatomic) UITextSmartQuotesType smartQuotesType;")
    default int smartQuotesType() {
        return UITextSmartQuotesType.Default;
    }

    /**
     * Sets the smart quotes type for the text
     * @param UITextSmartQuotesType The smart quotes type for the text
     */
    @CMSetter("@property(nonatomic) UITextSmartQuotesType smartQuotesType;")
    default void setSmartQuotesType(int UITextSmartQuotesType) {
    }

    /**
     * The smart quotes type for the text
     * @return The smart quotes type for the text
     */
    @CMGetter("@property(nonatomic) UITextSmartDashesType smartDashesType;")
    default int smartDashesType() {
        return UITextSmartDashesType.Default;
    }

    /**
     * Sets the smart dashes type for the text
     * @param UITextSmartDashesType The smart dashes type for the text
     */
    @CMSetter("@property(nonatomic) UITextSmartDashesType smartDashesType;")
    default void setSmartDashesType(int UITextSmartDashesType) {
    }

    /**
     * The smart insert - delete type for space characters
     * @return The smart insert - delete type for space characters
     */
    @CMGetter("@property(nonatomic) UITextSmartInsertDeleteType smartInsertDeleteType;")
    default int smartInsertDeleteType() {
        return UITextSmartInsertDeleteType.Default;
    }

    /**
     * Sets the smart insert - delete type for space characters
     * @param UITextSmartInsertDeleteType The smart insert - delete type for space characters
     */
    @CMSetter("@property(nonatomic) UITextSmartInsertDeleteType smartInsertDeleteType;")
    default void setSmartInsertDeleteType(int UITextSmartInsertDeleteType) {
    }

    /**
     * Returns the style of the keyboard that is used along with the text field.
     *
     * @return The style of the keyboard that is used along with the text field.
     */
    @CMGetter("@property(nonatomic) UIKeyboardType keyboardType;")
    default int keyboardType() {
        return UIKeyboardType.Default;
    }

    /**
     * Sets the style of the keyboard that will be used along with the text
     * field.
     *
     * @param UIKeyboardType The style of keyboard that will be used along with
     *                       the text field.
     * @see crossmobile.ios.uikit.UIKeyboardType
     */
    @CMSetter("@property(nonatomic) UIKeyboardType keyboardType;")
    default void setKeyboardType(int UIKeyboardType) {
    }

    /**
     * Returns the appearance type of the keyboard used along with the text
     * field.
     *
     * @return The appearance type of the keyboard use along with the text
     * field.
     * @see crossmobile.ios.uikit.UIKeyboardAppearance
     */
    @CMGetter("@property(nonatomic) UIKeyboardAppearance keyboardAppearance;")
    default int keyboardAppearance() {
        return UIKeyboardAppearance.Default;
    }

    /**
     * Sets appearance type of the keyboard used along with the text field.
     *
     * @param UIKeyboardAppearance The appearance type of the keyboard used
     *                             along with the text field.
     * @see crossmobile.ios.uikit.UIKeyboardAppearance
     */
    @CMSetter("@property(nonatomic) UIKeyboardAppearance keyboardAppearance;")
    default void setKeyboardAppearance(int UIKeyboardAppearance) {
    }

    /**
     * Returns the type of the return key.
     *
     * @return The type of the return key.
     * @see crossmobile.ios.uikit.UIReturnKeyType
     */
    @CMGetter("@property(nonatomic) UIReturnKeyType returnKeyType;")
    default int returnKeyType() {
        return UIReturnKeyType.Default;
    }

    /**
     * Sets the type of the return key.
     *
     * @param UIReturnKeyType The type of the return key.
     * @see crossmobile.ios.uikit.UIReturnKeyType
     */
    @CMSetter("@property(nonatomic) UIReturnKeyType returnKeyType;")
    default void setReturnKeyType(int UIReturnKeyType) {
    }

    /**
     * Returns a Boolean that shows whether the return key is automatically
     * enabled.
     *
     * @return A Boolean that shows whether the return key is automatically
     * enabled.
     */
    @CMGetter("@property(nonatomic) BOOL enablesReturnKeyAutomatically;")
    default boolean enablesReturnKeyAutomatically() {
        return false;
    }

    /**
     * Sets a Boolean that defines whether the return key is automatically
     * enabled.
     *
     * @param enablesReturnKeyAutomatically A Boolean that defines whether the
     *                                      return key is automatically enabled.
     */
    @CMSetter("@property(nonatomic) BOOL enablesReturnKeyAutomatically;")
    default void setEnablesReturnKeyAutomatically(boolean enablesReturnKeyAutomatically) {
    }

    /**
     * Returns a Boolean that shows whether the text that is being entered in
     * the text field is hidden.
     *
     * @return A Boolean that shows whether the text that is being entered in
     * the text field is hidden.
     */
    @CMGetter("@property(nonatomic,getter=isSecureTextEntry) BOOL secureTextEntry;")
    default boolean isSecureTextEntry() {
        return false;
    }

    /**
     * Sets a Boolean that defines if the text that is being entered in the text
     * field should be hidden.
     *
     * @param secureTextEntry A Boolean that defines if the text that is being
     *                        entered in the text field should be hidden.
     */
    @CMSetter("@property(nonatomic,getter=isSecureTextEntry) BOOL secureTextEntry;")
    default void setSecureTextEntry(boolean secureTextEntry) {
    }

    /**
     * The type of text expected in the text input area
     *
     * @return The type of text expected in the text input area
     */
    @CMGetter("@property(nonatomic,copy) UITextContentType textContentType;")
    default String textContentType() {
        return null;
    }

    /**
     * Sets the type of text expected in the text input area
     *
     * @param UITextContentType The type of text expected in the text input area
     */
    @CMSetter("@property(nonatomic,copy) UITextContentType textContentType;")
    default void setTextContentType(String UITextContentType) {
    }

}
