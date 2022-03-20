// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_quicklook_QLPreviewControllerDataSource definition

#import "xmlvm.h"
#import <QuickLook/QuickLook.h>
@class crossmobile_ios_quicklook_QLPreviewController;
@protocol crossmobile_ios_quicklook_QLPreviewItem;

@protocol crossmobile_ios_quicklook_QLPreviewControllerDataSource
- (int) numberOfPreviewItemsInPreviewController___crossmobile_ios_quicklook_QLPreviewController:(QLPreviewController*) controller ;
- (id<QLPreviewItem>) previewItemAtIndex___crossmobile_ios_quicklook_QLPreviewController_int:(QLPreviewController*) controller :(int) index ;
@end
