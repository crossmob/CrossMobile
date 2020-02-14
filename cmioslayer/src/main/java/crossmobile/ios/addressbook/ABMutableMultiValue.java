/*
 * (c) 2020 by Panayotis Katsaloulis
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
package crossmobile.ios.addressbook;

import crossmobile.ios.foundation.CFType;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMFunction;
import org.crossmobile.bridge.ann.CMReference;

/**
 * ABMutableMultiValue class defines objects that represent changeable
 * properties with multiple values.
 */
@Deprecated
@CMReference
public class ABMutableMultiValue extends ABMultiValue {

    /**
     * Creates and returns a new, empty, mutable multivalue property of the
     * specified type.
     *
     * @param ABPropertyType The type of the values of the new property.
     */
    @CMConstructor(" ABMutableMultiValueRef ABMultiValueCreateMutable ( ABPropertyType type ); ")
    public ABMutableMultiValue(int ABPropertyType) {
    }

    /**
     * Adds the specified value and label to this multivalue property.
     *
     * @param value         The value to add to multiValue property.
     * @param label         The label of the value.
     * @param outIdentifier The address of the value's id.
     * @return TRUE if the operation was successfully completed.
     */
    @CMFunction(" bool ABMultiValueAddValueAndLabel ( ABMutableMultiValueRef multiValue, CFTypeRef value, CFStringRef label, ABMultiValueIdentifier *outIdentifier ); ")
    public boolean addValueAndLabel(CFType value, String label, int[] outIdentifier) {
        Native.lifecycle().notImplemented();
        return false;
    }

    /**
     * Inserts the specified value and label into a multivalue property.
     *
     * @param value         The new value to insert.
     * @param label         The new label to insert.
     * @param index         The index at which the new value and label are being
     *                      inserted.
     * @param outIdentifier The identifier of the added value.
     * @return TRUE if the operation was successfully completed.
     */
    @CMFunction(" bool ABMultiValueInsertValueAndLabelAtIndex ( ABMutableMultiValueRef multiValue, CFTypeRef value, CFStringRef label, CFIndex index, ABMultiValueIdentifier *outIdentifier ); ")
    public boolean insertValueAndLabelAtIndex(CFType value, String label, long index, int[] outIdentifier) {
        Native.lifecycle().notImplemented();
        return false;
    }

    /**
     * Removes the value at the specified index.
     *
     * @param index The index of the value that is removed.
     * @return TRUE if the operation was successfully completed.
     */
    @CMFunction(" bool ABMultiValueRemoveValueAndLabelAtIndex ( ABMutableMultiValueRef multiValue, CFIndex index ); ")
    public boolean removeValueAndLabelAtIndex(long index) {
        Native.lifecycle().notImplemented();
        return false;
    }

    /**
     * Replaces the specified value with the new value.
     *
     * @param value The new value.
     * @param index The index of the value to be replaced.
     * @return TRUE if the operation was successfully completed.
     */
    @CMFunction(" bool ABMultiValueReplaceValueAtIndex ( ABMutableMultiValueRef multiValue, CFTypeRef value, CFIndex index ); ")
    public boolean replaceValueAtIndex(CFType value, long index) {
        Native.lifecycle().notImplemented();
        return false;
    }

    /**
     * Replaces the label of the given multivalue property with the specified
     * label.
     *
     * @param label The new label.
     * @param index The index of the label to be replaced.
     * @return TRUE if the operation was successfully completed.
     */
    @CMFunction(" bool ABMultiValueReplaceLabelAtIndex ( ABMutableMultiValueRef multiValue, CFStringRef label, CFIndex index ); ")
    public boolean replaceLabelAtIndex(String label, long index) {
        Native.lifecycle().notImplemented();
        return false;
    }

}
