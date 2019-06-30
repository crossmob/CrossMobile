/*
 * (c) 2019 by Panayotis Katsaloulis
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
