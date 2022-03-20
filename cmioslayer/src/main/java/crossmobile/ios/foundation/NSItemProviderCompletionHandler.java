/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMBlock;
import org.crossmobile.bridge.ann.CMTarget;
import org.robovm.objc.block.VoidBlock2;

@CMTarget
public interface NSItemProviderCompletionHandler extends VoidBlock2<NSSecureCoding, NSError> {

    @Override
    @CMBlock("void (^NSItemProviderCompletionHandler)(id<NSSecureCoding> item, NSError *error);")
    public void invoke(NSSecureCoding item, NSError error);
}
