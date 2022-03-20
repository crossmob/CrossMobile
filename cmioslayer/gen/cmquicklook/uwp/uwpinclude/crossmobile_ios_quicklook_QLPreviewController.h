// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_quicklook_QLPreviewController definition

#import "xmlvm.h"
#import <QuickLook/QuickLook.h>
@protocol crossmobile_ios_quicklook_QLPreviewControllerDataSource;
@protocol crossmobile_ios_quicklook_QLPreviewControllerDelegate;
@protocol crossmobile_ios_quicklook_QLPreviewItem;

CM_EXPORT_CLASS
@interface crossmobile_ios_quicklook_QLPreviewController$Ext : QLPreviewController
@end

#define crossmobile_ios_quicklook_QLPreviewController QLPreviewController
@interface QLPreviewController (cm_crossmobile_ios_quicklook_QLPreviewController)
+ (BOOL) canPreviewItem___crossmobile_ios_quicklook_QLPreviewItem:(id<QLPreviewItem>) item ;
- (instancetype) __init_crossmobile_ios_quicklook_QLPreviewController__;
- (id<QLPreviewItem>) currentPreviewItem__;
- (void) setCurrentPreviewItemIndex___int:(int) currentPreviewItemIndex ;
- (int) currentPreviewItemIndex__;
- (void) setDataSource___crossmobile_ios_quicklook_QLPreviewControllerDataSource:(id<QLPreviewControllerDataSource>) dataSource ;
- (id<QLPreviewControllerDataSource>) dataSource__;
- (void) setDelegate___crossmobile_ios_quicklook_QLPreviewControllerDelegate:(id<QLPreviewControllerDelegate>) delegate ;
- (id<QLPreviewControllerDelegate>) delegate__;
- (void) refreshCurrentPreviewItem__;
- (void) reloadData__;
@end
