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
package crossmobile.ios.foundation;

import crossmobile.ios.coregraphics.CGSize;
import crossmobile.ios.uikit.UIImage;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.robovm.objc.block.VoidBlock1;
import org.robovm.objc.block.VoidBlock3;

import java.util.List;

@CMClass
public class NSExtensionContext extends NSObject {
    public static final String NSExtensionItemsAndErrorsKey = "NSExtensionItemsAndErrorsKey";
    private List<NSExtensionItem> inputItems;
    private CGSize hostedViewMaximumAllowedSize;
    private CGSize hostedViewMinimumAllowedSize;

    @CMSelector("- (void)cancelRequestWithError:(NSError *)error;")
    public void cancelRequestWithError(NSError error) {

    }

    @CMSelector("- (void)completeRequestReturningItems:(NSArray *)items\n" +
            "    completionHandler:(void (^)(BOOL expired))completionHandler;")
    public void completeRequestReturningItems(List items, VoidBlock1<Boolean> completionHandler) {

    }

    @CMSelector("- (void)openURL:(NSURL *)URL\n" +
            "    completionHandler:(void (^)(BOOL success))completionHandler;")
    public void openURL(NSURL URL, VoidBlock1<Boolean> completionHandler) {

    }

    @CMGetter("@property(readonly, copy, nonatomic) NSArray *inputItems;")
    public List<NSExtensionItem> inputItems() {
        return inputItems;
    }


    @CMSelector("- (void)loadBroadcastingApplicationInfoWithCompletion:(void (^)(NSString *bundleID, NSString *displayName, UIImage *appIcon))handler;")
    public void loadBroadcastingApplicationInfoWithCompletion(VoidBlock3<String, String, UIImage> handler) {

    }

}
