// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSExtensionContext definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSError;
@class crossmobile_ios_foundation_NSURL;
@class crossmobile_ios_uikit_UIImage;
@class java_lang_Boolean;
@class java_lang_String;
@protocol java_util_List;
@protocol org_robovm_objc_block_VoidBlock1;
@protocol org_robovm_objc_block_VoidBlock3;

CM_EXPORT_CLASS
@interface crossmobile_ios_foundation_NSExtensionContext$Ext : NSExtensionContext
@end

#define crossmobile_ios_foundation_NSExtensionContext NSExtensionContext
@interface NSExtensionContext (cm_crossmobile_ios_foundation_NSExtensionContext)
- (instancetype) __init_crossmobile_ios_foundation_NSExtensionContext__;
- (NSArray*) inputItems__;
- (void) cancelRequestWithError___crossmobile_ios_foundation_NSError:(NSError*) error ;
- (void) completeRequestReturningItems___java_util_List_org_robovm_objc_block_VoidBlock1:(NSArray*) items :(id<org_robovm_objc_block_VoidBlock1>) completionHandler ;
- (void) loadBroadcastingApplicationInfoWithCompletion___org_robovm_objc_block_VoidBlock3:(id<org_robovm_objc_block_VoidBlock3>) handler ;
- (void) openURL___crossmobile_ios_foundation_NSURL_org_robovm_objc_block_VoidBlock1:(NSURL*) URL :(id<org_robovm_objc_block_VoidBlock1>) completionHandler ;
@end
