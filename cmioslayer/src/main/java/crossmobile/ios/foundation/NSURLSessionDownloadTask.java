/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;
import org.robovm.objc.block.VoidBlock1;

@CMClass
public class NSURLSessionDownloadTask extends NSURLSessionTask {
    @CMSelector(" - (void)cancelByProducingResumeData:(void (^)(NSData *resumeData))completionHandler;")
    public void cancelByProducingResumeData(VoidBlock1<NSData> completionHandler) {

    }
}
