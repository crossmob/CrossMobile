// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_webkit_WKBackForwardList definition

#import "xmlvm.h"
#import <WebKit/WebKit.h>
@class crossmobile_ios_webkit_WKBackForwardListItem;
@protocol java_util_List;

@interface crossmobile_ios_webkit_WKBackForwardList$Ext : WKBackForwardList
@end

#define crossmobile_ios_webkit_WKBackForwardList WKBackForwardList
@interface WKBackForwardList (cm_crossmobile_ios_webkit_WKBackForwardList)
- (WKBackForwardListItem*) backItem__;
- (NSArray*) backList__;
- (WKBackForwardListItem*) currentItem__;
- (WKBackForwardListItem*) forwardItem__;
- (NSArray*) forwardList__;
- (WKBackForwardListItem*) itemAtIndex___int:(int) index ;
@end
