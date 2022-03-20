/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
