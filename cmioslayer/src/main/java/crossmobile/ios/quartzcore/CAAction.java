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
