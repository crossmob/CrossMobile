/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMBlock;
import org.crossmobile.bridge.ann.CMParamMod;
import org.crossmobile.bridge.ann.CMTarget;
import org.robovm.objc.block.VoidBlock3;

import java.util.Map;

@CMTarget
public interface NSItemProviderLoadHandler extends VoidBlock3<NSItemProviderCompletionHandler, Class, Map<String, Object>> {

    @CMBlock("void (^NSItemProviderLoadHandler)(NSItemProviderCompletionHandler completionHandler, Class expectedValueClass, NSDictionary *options);")
    @Override
    void invoke(NSItemProviderCompletionHandler completionHandler, @CMParamMod(convertWith = "jclass_to_class") Class expectedValueClass, Map<String, Object> options);
}
