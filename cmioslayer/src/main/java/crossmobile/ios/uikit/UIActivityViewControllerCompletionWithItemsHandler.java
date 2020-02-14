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
package crossmobile.ios.uikit;

import crossmobile.ios.foundation.NSError;
import org.crossmobile.bridge.ann.CMBlock;
import org.crossmobile.bridge.ann.CMTarget;
import org.robovm.objc.block.VoidBlock4;

import java.util.List;


@CMTarget
public interface UIActivityViewControllerCompletionWithItemsHandler extends VoidBlock4<String, Boolean, List, NSError> {

    @Override
    @CMBlock("void (^UIActivityViewControllerCompletionWithItemsHandler)(UIActivityType activityType, BOOL completed, NSArray *returnedItems, NSError *activityError);")
    public void invoke(String activityType, Boolean completed, List returnedItems, NSError activityError);
}
