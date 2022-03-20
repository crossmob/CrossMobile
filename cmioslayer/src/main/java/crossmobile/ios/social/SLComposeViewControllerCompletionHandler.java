/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.social;

import org.crossmobile.bridge.ann.CMBlock;
import org.crossmobile.bridge.ann.CMTarget;
import org.robovm.objc.block.VoidBlock1;

/**
 * SLComposeViewControllerCompletionHandler interface is the handler that is called
 * after the composition of a post for a social network.
 */
@CMTarget
public interface SLComposeViewControllerCompletionHandler extends VoidBlock1<Integer> {

    /**
     * It is called in order to handle the composition of a post for a social network.
     *
     * @param SLComposeViewControllerResult The result of composition operation.
     * @see crossmobile.ios.social.SLComposeViewControllerResult
     */
    @Override
    @CMBlock("void (^SLComposeViewControllerCompletionHandler)(SLComposeViewControllerResult result);")
    public void invoke(Integer SLComposeViewControllerResult);

}
