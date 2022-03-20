// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_quicklook_QLPreviewItem definition

#import "xmlvm.h"
#import <QuickLook/QuickLook.h>
@class crossmobile_ios_foundation_NSURL;
@class java_lang_String;

CM_EXPORT_CLASS
@protocol crossmobile_ios_quicklook_QLPreviewItem
- (NSString*) previewItemTitle__;
- (NSURL*) previewItemURL__;
@end
