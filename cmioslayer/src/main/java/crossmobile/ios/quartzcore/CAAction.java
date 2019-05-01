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
package crossmobile.ios.quartzcore;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

import java.util.Map;

/**
 * CAAction interface is implemented by objects that respond to CALayer actions.
 */
@CMClass
public interface CAAction {

    /**
     * It used in order to trigger the specified action.
     *
     * @param key       The id of the action.
     * @param object    The object on which the action should occur.
     * @param arguments Parameters associated to this action.
     */
    @CMSelector("- (void)runActionForKey:(NSString *)event \n"
            + "                 object:(id)anObject \n"
            + "              arguments:(NSDictionary *)dict;")
    public void runActionForKey(String key, NSObject object, Map arguments);
}
