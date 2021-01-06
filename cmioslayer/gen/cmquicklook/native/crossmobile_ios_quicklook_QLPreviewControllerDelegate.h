// (c) 2021 under LGPL by CrossMobile plugin tools

// crossmobile_ios_quicklook_QLPreviewControllerDelegate definition

#import "xmlvm.h"
#import <QuickLook/QuickLook.h>
@class crossmobile_ios_foundation_NSURL;
@class crossmobile_ios_quicklook_QLPreviewController;
@protocol crossmobile_ios_quicklook_QLPreviewItem;

@protocol crossmobile_ios_quicklook_QLPreviewControllerDelegate
- (void) didDismiss___crossmobile_ios_quicklook_QLPreviewController:(QLPreviewController*) controller ;
- (BOOL) shouldOpenURL___crossmobile_ios_quicklook_QLPreviewController_crossmobile_ios_foundation_NSURL_crossmobile_ios_quicklook_QLPreviewItem:(QLPreviewController*) controller :(NSURL*) url :(id<QLPreviewItem>) item ;
- (void) willDismiss___crossmobile_ios_quicklook_QLPreviewController:(QLPreviewController*) controller ;
@end
