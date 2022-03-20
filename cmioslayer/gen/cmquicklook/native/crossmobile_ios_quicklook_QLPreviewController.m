// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_quicklook_QLPreviewController implementation

#import "crossmobile_ios_quicklook_QLPreviewController.h"
#import "crossmobile_ios_quicklook_QLPreviewControllerDataSource.h"
#import "crossmobile_ios_quicklook_QLPreviewControllerDelegate.h"
#import "crossmobile_ios_quicklook_QLPreviewItem.h"

@implementation crossmobile_ios_quicklook_QLPreviewController$Ext

@end

@implementation QLPreviewController (cm_crossmobile_ios_quicklook_QLPreviewController)

// + (BOOL)canPreviewItem:(id<QLPreviewItem>)item;
+ (BOOL) canPreviewItem___crossmobile_ios_quicklook_QLPreviewItem:(id<QLPreviewItem>) item 
{
    return [QLPreviewController canPreviewItem:(item == JAVA_NULL ? nil : item)];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_quicklook_QLPreviewController__
{
    return [self init];
}

// @property(readonly) id<QLPreviewItem> currentPreviewItem;
- (id<QLPreviewItem>) currentPreviewItem__
{
    id<QLPreviewItem> re$ult = [self currentPreviewItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property NSInteger currentPreviewItemIndex;
- (void) setCurrentPreviewItemIndex___int:(int) currentPreviewItemIndex 
{
    [self setCurrentPreviewItemIndex:currentPreviewItemIndex];
}

// @property NSInteger currentPreviewItemIndex;
- (int) currentPreviewItemIndex__
{
    return [self currentPreviewItemIndex];
}

// @property(nonatomic, weak) id<QLPreviewControllerDataSource> dataSource;
- (void) setDataSource___crossmobile_ios_quicklook_QLPreviewControllerDataSource:(id<QLPreviewControllerDataSource>) dataSource 
{
    objc_setAssociatedObject(self, @selector(setDataSource:), dataSource, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDataSource:(dataSource == JAVA_NULL ? nil : dataSource)];
}

// @property(nonatomic, weak) id<QLPreviewControllerDataSource> dataSource;
- (id<QLPreviewControllerDataSource>) dataSource__
{
    id<QLPreviewControllerDataSource> re$ult = [self dataSource];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, weak) id<QLPreviewControllerDelegate> delegate;
- (void) setDelegate___crossmobile_ios_quicklook_QLPreviewControllerDelegate:(id<QLPreviewControllerDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(nonatomic, weak) id<QLPreviewControllerDelegate> delegate;
- (id<QLPreviewControllerDelegate>) delegate__
{
    id<QLPreviewControllerDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)refreshCurrentPreviewItem;
- (void) refreshCurrentPreviewItem__
{
    [self refreshCurrentPreviewItem];
}

// - (void)reloadData;
- (void) reloadData__
{
    [self reloadData];
}

@end
