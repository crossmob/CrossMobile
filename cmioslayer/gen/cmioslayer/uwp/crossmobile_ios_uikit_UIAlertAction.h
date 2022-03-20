// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIAlertAction definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class java_lang_String;
@protocol org_robovm_objc_block_VoidBlock1;

@interface crossmobile_ios_uikit_UIAlertAction$Ext : UIAlertAction
@end

#define crossmobile_ios_uikit_UIAlertAction UIAlertAction
@interface UIAlertAction (cm_crossmobile_ios_uikit_UIAlertAction)
+ (instancetype) actionWithTitle___java_lang_String_int_org_robovm_objc_block_VoidBlock1:(NSString*) title :(int) style :(id<org_robovm_objc_block_VoidBlock1>) handler ;
- (void) setEnabled___boolean:(BOOL) enabled ;
- (BOOL) isEnabled__;
- (int) style__;
- (NSString*) title__;
@end
