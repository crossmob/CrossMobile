// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_quartzcore_CAAnimation definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_foundation_NSObject;
@class crossmobile_ios_quartzcore_CATransition;
@class java_lang_String;

@interface crossmobile_ios_quartzcore_CAAnimation$Ext : CAAnimation
@end

#define crossmobile_ios_quartzcore_CAAnimation CAAnimation
@interface CAAnimation (cm_crossmobile_ios_quartzcore_CAAnimation)
+ (instancetype) animation__;
+ (id) defaultValueForKey___java_lang_String:(NSString*) key ;
- (instancetype) __init_crossmobile_ios_quartzcore_CAAnimation__;
- (void) setDelegate___crossmobile_ios_foundation_NSObject:(NSObject*) delegate ;
- (id) delegate__;
- (void) setRemovedOnCompletion___boolean:(BOOL) removedOnCompletion ;
- (BOOL) isRemovedOnCompletion__;
- (void) animationDidStart___crossmobile_ios_quartzcore_CAAnimation:(CAAnimation*) anim ;
- (void) animationDidStop___crossmobile_ios_quartzcore_CAAnimation_boolean:(CAAnimation*) theAnimation :(BOOL) flag ;
@end
