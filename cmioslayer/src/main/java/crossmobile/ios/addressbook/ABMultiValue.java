/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.addressbook;

import crossmobile.ios.foundation.CFType;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMFunction;
import org.crossmobile.bridge.ann.CMReference;

import java.util.List;

/**
 * ABMultiValue class defines objects that represent properties with multiple
 * values.
 */
@Deprecated
@CMReference
public class ABMultiValue extends CFType {

    ABMultiValue() {
    }

    /**
     * Returns the type of the values in the multivalue property.
     *
     * @return The type of the values in the multivalue property.
     */
    @CMFunction(" ABPropertyType ABMultiValueGetPropertyType ( ABMultiValueRef multiValue ); ")
    public int getPropertyType() {
        Native.system().notImplemented();
        return 0;
    }

    /**
     * Returns the number of values of the multivalue property.
     *
     * @return The number of values of the multivalue property.
     */
    @CMFunction(" CFIndex ABMultiValueGetCount ( ABMultiValueRef multiValue ); ")
    public long getCount() {
        Native.system().notImplemented();
        return 0;
    }

    /**
     * Returns the value of the specified index.
     *
     * @param index The index of the requested value.
     * @return The value of the specified index.
     */
    @CMFunction(" CFTypeRef ABMultiValueCopyValueAtIndex ( ABMultiValueRef multiValue, CFIndex index ); ")
    public CFType copyValueAtIndex(long index) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Returns a list with the values of the multivalue property.
     *
     * @return A list with the values of the multivalue property.
     */
    @CMFunction(" CFArrayRef ABMultiValueCopyArrayOfAllValues ( ABMultiValueRef multiValue ); ")
    public List copyArrayOfAllValues() {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Returns the label of the value at the specified index.
     *
     * @param index The index of the value whose label is requested.
     * @return The label of the value at the specified index.
     */
    @CMFunction(" CFStringRef ABMultiValueCopyLabelAtIndex ( ABMultiValueRef multiValue, CFIndex index ); ")
    public String copyLabelAtIndex(long index) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Returns the index of the value with the specified id.
     *
     * @param identifier The id of the value whose index is requested.
     * @return The index of the value with the specified id.
     */
    @CMFunction(" CFIndex ABMultiValueGetIndexForIdentifier ( ABMultiValueRef multiValue, ABMultiValueIdentifier identifier ); ")
    public long getIndexForIdentifier(int identifier) {
        Native.system().notImplemented();
        return 0;
    }

    /**
     * Returns the id of a value in a multivalue property.
     *
     * @param index The index of the value whose id is being returned.
     * @return The id of the specified value.
     */
    @CMFunction(" ABMultiValueIdentifier ABMultiValueGetIdentifierAtIndex ( ABMultiValueRef multiValue, CFIndex index ); ")
    public int getIdentifierAtIndex(long index) {
        Native.system().notImplemented();
        return 0;
    }

    /**
     * Returns the first index of the specified value.
     *
     * @param value The value to search for.
     * @return The first index of the specified value.
     */
    @CMFunction(" CFIndex ABMultiValueGetFirstIndexOfValue ( ABMultiValueRef multiValue, CFTypeRef value ); ")
    public long getFirstIndexOfValue(CFType value) {
        Native.system().notImplemented();
        return 0;
    }

    /**
     * Returns a copy of this ABMultiValue that is changeable.
     *
     * @return A mutable copy of this ABMultiValue.
     */
    @CMFunction("ABMutableMultiValueRef ABMultiValueCreateMutableCopy(ABMultiValueRef multiValue);")
    public ABMutableMultiValue createMutableCopy() {
        Native.system().notImplemented();
        return null;
    }
}
