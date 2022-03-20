/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
