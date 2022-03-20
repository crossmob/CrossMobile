// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_quartzcore_CALayer definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGContext;
@class crossmobile_ios_coregraphics_CGPoint;
@class crossmobile_ios_quartzcore_CAAnimation;
@class crossmobile_ios_uikit_UIView;
@class java_lang_String;
@protocol java_util_List;
@protocol java_util_Map;

CM_EXPORT_CLASS
@interface crossmobile_ios_quartzcore_CALayer$Ext : CALayer
@end

#define crossmobile_ios_quartzcore_CALayer CALayer
@interface CALayer (cm_crossmobile_ios_quartzcore_CALayer)
+ (instancetype) layer__;
- (instancetype) __init_crossmobile_ios_quartzcore_CALayer__;
- (void) setAnchorPoint___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) anchorPoint ;
- (crossmobile_ios_coregraphics_CGPoint*) anchorPoint__;
- (void) setDelegate___crossmobile_ios_uikit_UIView:(UIView*) delegate ;
- (id) delegate__;
- (void) setMask___crossmobile_ios_quartzcore_CALayer:(CALayer*) mask ;
- (CALayer*) mask__;
- (NSDictionary*) style__;
- (void) addAnimation___crossmobile_ios_quartzcore_CAAnimation_java_lang_String:(CAAnimation*) anim :(NSString*) key ;
- (CAAnimation*) animationForKey___java_lang_String:(NSString*) key ;
- (NSArray*) animationKeys__;
- (void) removeAllAnimations__;
- (void) removeAnimationForKey___java_lang_String:(NSString*) key ;
- (void) renderInContext___crossmobile_ios_coregraphics_CGContext:(crossmobile_ios_coregraphics_CGContext*) ctx ;
@end
