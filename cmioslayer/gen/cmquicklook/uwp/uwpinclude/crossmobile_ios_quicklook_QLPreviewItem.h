// (c) 2021 under LGPL by CrossMobile plugin tools

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
