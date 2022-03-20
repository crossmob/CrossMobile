// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_webkit_WKBackForwardList implementation

#import "crossmobile_ios_webkit_WKBackForwardList.h"
#import "crossmobile_ios_webkit_WKBackForwardListItem.h"
#import "java_util_List.h"

@implementation crossmobile_ios_webkit_WKBackForwardList$Ext

@end

@implementation WKBackForwardList (cm_crossmobile_ios_webkit_WKBackForwardList)

// @property(nullable, nonatomic, readonly, strong) WKBackForwardListItem *backItem;
- (WKBackForwardListItem*) backItem__
{
    WKBackForwardListItem* re$ult = [self backItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, copy) NSArray<WKBackForwardListItem *> *backList;
- (NSArray*) backList__
{
    NSArray* re$ult = [self backList];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nullable, nonatomic, readonly, strong) WKBackForwardListItem *currentItem;
- (WKBackForwardListItem*) currentItem__
{
    WKBackForwardListItem* re$ult = [self currentItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nullable, nonatomic, readonly, strong) WKBackForwardListItem *forwardItem;
- (WKBackForwardListItem*) forwardItem__
{
    WKBackForwardListItem* re$ult = [self forwardItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, copy) NSArray<WKBackForwardListItem *> *forwardList;
- (NSArray*) forwardList__
{
    NSArray* re$ult = [self forwardList];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (WKBackForwardListItem *)itemAtIndex:(NSInteger)index;
- (WKBackForwardListItem*) itemAtIndex___int:(int) index 
{
    WKBackForwardListItem* re$ult = [self itemAtIndex:index];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
