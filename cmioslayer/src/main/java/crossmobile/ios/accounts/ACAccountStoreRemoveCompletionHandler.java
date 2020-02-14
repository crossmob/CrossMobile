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
package crossmobile.ios.accounts;

import crossmobile.ios.foundation.NSError;
import org.crossmobile.bridge.ann.CMBlock;
import org.crossmobile.bridge.ann.CMTarget;
import org.robovm.objc.block.VoidBlock2;

/**
 * ACAccountStoreRemoveCompletionHandler interface specifies the handler that is called
 * when an account is being removed from the store.
 */
@CMTarget
public interface ACAccountStoreRemoveCompletionHandler extends VoidBlock2<Boolean, NSError> {

    /**
     * It is called when an account is being removed from the store.
     *
     * @param input1 TRUE, if the removal is successful.
     * @param input2 The error in case of failure.
     */
    @Override
    @CMBlock("void(^ACAccountStoreRemoveCompletionHandler)(BOOL success, NSError *error);")
    public void invoke(Boolean input1, NSError input2);

}
