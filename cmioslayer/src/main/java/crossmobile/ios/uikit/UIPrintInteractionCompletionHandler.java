/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.foundation.NSError;
import org.crossmobile.bridge.ann.CMBlock;
import org.crossmobile.bridge.ann.CMTarget;
import org.robovm.objc.block.VoidBlock3;

/**
 * UIPrintInteractionCompletionHandler interface is the handler that is called
 * after the completion of a printing job or when a printing error.
 */
@CMTarget
public interface UIPrintInteractionCompletionHandler extends VoidBlock3<UIPrintInteractionController, Boolean, NSError> {

    @Override
    @CMBlock("void (^UIPrintInteractionCompletionHandler) (UIPrintInteractionController *printInteractionController,BOOL completed, NSError *error);")
    public void invoke(UIPrintInteractionController printInteractionController, Boolean completed, NSError error);

}
