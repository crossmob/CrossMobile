// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_quicklook_QLPreviewControllerDelegate definition

#import "xmlvm.h"
#import <QuickLook/QuickLook.h>
@class crossmobile_ios_foundation_NSURL;
@class crossmobile_ios_quicklook_QLPreviewController;
@protocol crossmobile_ios_quicklook_QLPreviewItem;

CM_EXPORT_CLASS
@protocol crossmobile_ios_quicklook_QLPreviewControllerDelegate
- (void) didDismiss___crossmobile_ios_quicklook_QLPreviewController:(QLPreviewController*) controller ;
- (BOOL) shouldOpenURL___crossmobile_ios_quicklook_QLPreviewController_crossmobile_ios_foundation_NSURL_crossmobile_ios_quicklook_QLPreviewItem:(QLPreviewController*) controller :(NSURL*) url :(id<QLPreviewItem>) item ;
- (void) willDismiss___crossmobile_ios_quicklook_QLPreviewController:(QLPreviewController*) controller ;
@end
