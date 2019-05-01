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

import crossmobile.ios.foundation.NSError;
import org.crossmobile.bridge.ann.CMBlock;
import org.crossmobile.bridge.ann.CMTarget;
import org.robovm.objc.block.VoidBlock2;

/**
 * ABAddressBookRequestAccessCompletionHandler interface specifies the handler that is
 * called when an access request is completed.
 */
@CMTarget
public interface ABAddressBookRequestAccessCompletionHandler extends VoidBlock2<Boolean, NSError> {

    /**
     * It is called when an access request is completed.
     *
     * @param granted TRUE if the access is granted after the request.
     * @param error   The error in case of failure.
     */
    @Override
    @CMBlock("void (^ABAddressBookRequestAccessCompletionHandler)(bool granted, CFErrorRef error);")
    public void invoke(Boolean granted, NSError error);
}
