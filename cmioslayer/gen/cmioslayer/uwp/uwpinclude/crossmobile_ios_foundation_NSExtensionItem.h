// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSExtensionItem definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@protocol java_util_List;
@protocol java_util_Map;

CM_EXPORT_CLASS
@interface crossmobile_ios_foundation_NSExtensionItem$Ext : NSExtensionItem
@end

#define crossmobile_ios_foundation_NSExtensionItem NSExtensionItem
@interface NSExtensionItem (cm_crossmobile_ios_foundation_NSExtensionItem)
- (instancetype) __init_crossmobile_ios_foundation_NSExtensionItem__;
- (void) setAttachments___java_util_List:(NSArray*) attachments ;
- (NSArray*) attachments__;
- (void) setUserInfo___java_util_Map:(NSDictionary*) userInfo ;
- (NSDictionary*) userInfo__;
@end
