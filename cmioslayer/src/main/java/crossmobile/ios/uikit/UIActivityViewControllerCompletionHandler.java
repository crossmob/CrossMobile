/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMBlock;
import org.crossmobile.bridge.ann.CMTarget;
import org.robovm.objc.block.VoidBlock2;

@Deprecated
@CMTarget
public interface UIActivityViewControllerCompletionHandler extends VoidBlock2<String, Boolean> {

    @Deprecated
    @Override
    @CMBlock("void (^UIActivityViewControllerCompletionHandler)(UIActivityType activityType, BOOL completed);")
    public void invoke(String activityType, Boolean completed);
}
