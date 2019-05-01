// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.quicklook.QLPreviewControllerDataSource definition

#import "xmlvm.h"
#import <QuickLook/QuickLook.h>
@class crossmobile_ios_quicklook_QLPreviewController;
@protocol crossmobile_ios_quicklook_QLPreviewItem;

CM_EXPORT_CLASS
@protocol crossmobile_ios_quicklook_QLPreviewControllerDataSource
- (int) numberOfPreviewItemsInPreviewController___crossmobile_ios_quicklook_QLPreviewController:(QLPreviewController*) controller ;
- (id<QLPreviewItem>) previewItemAtIndex___crossmobile_ios_quicklook_QLPreviewController_int:(QLPreviewController*) controller :(int) index ;
@end
