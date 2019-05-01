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
package crossmobile.ios.addressbook;

import crossmobile.ios.foundation.CFType;
import crossmobile.ios.foundation.NSError;
import crossmobile.rt.StrongReference;
import org.crossmobile.bridge.ann.CMFunction;
import org.crossmobile.bridge.ann.CMReference;

/**
 * ABRecord class defines an object that handles and represents a contact stored
 * in the address book of the application.
 */
@Deprecated
@CMReference
public class ABRecord extends CFType {

    /**
     * Invalid record.
     */
    public static final int InvalidID = -1;

    /**
     * Person record.
     */
    public static final int PersonType = 0;

    /**
     * Group record.
     */
    public static final int GroupType = 1;

    /**
     * Source record.
     */
    public static final int SourceType = 2;

    ABRecord() {
    }

    /**
     * Returns the id of this ABRecord.
     *
     * @return The id of this ABRecord.
     */
    @CMFunction(" ABRecordID ABRecordGetRecordID ( ABRecordRef record ); ")
    public int getRecordID() {
        return ABRecord.InvalidID;
    }

    /**
     * Returns the type of this ABRecord.
     *
     * @return The type of this ABRecord.
     */
    @CMFunction(" ABRecordType ABRecordGetRecordType ( ABRecordRef record ); ")
    public int getRecordType() {
        return PersonType;
    }

    /**
     * Returns the value of the specified property of this ABRecord.
     *
     * @param property The property whose value is being returned.
     * @return The value of this ABRecord.
     */
    @CMFunction(" CFTypeRef ABRecordCopyValue ( ABRecordRef record, ABPropertyID property ); ")
    public CFType copyValue(int property) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Sets the value of the specified property for this ABRecord.
     *
     * @param property The property whose value is being set.
     * @param value    The new value of the property.
     * @param error    The error that occurs in case of failure.
     * @return TRUE if the operation was successful.
     */
    @CMFunction(" bool ABRecordSetValue ( ABRecordRef record, ABPropertyID property, CFTypeRef value, CFErrorRef *error ); ")
    public boolean setValue(int property, CFType value, StrongReference<NSError> error) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Removes the value of the specified property.
     *
     * @param property The property of this ABRecord whose value is being
     *                 removed.
     * @param error    The error in case failure.
     * @return TRUE if the operation was successful.
     */
    @CMFunction(" bool ABRecordRemoveValue ( ABRecordRef record, ABPropertyID property, CFErrorRef *error ); ")
    public boolean removeValue(int property, StrongReference<NSError> error) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns a readable name for this ABRecord.
     *
     * @return A readable name for this ABRecord.
     */
    @CMFunction(" CFStringRef ABRecordCopyCompositeName ( ABRecordRef record ); ")
    public String copyCompositeName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
