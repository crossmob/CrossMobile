// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UITouch implementation

#import "crossmobile_ios_coregraphics_CGPoint.h"
#import "crossmobile_ios_uikit_UITouch.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "crossmobile_ios_uikit_UIWindow.h"

@implementation crossmobile_ios_uikit_UITouch$Ext

@end

@implementation UITouch (cm_crossmobile_ios_uikit_UITouch)

// @property(nonatomic, readonly) UITouchPhase phase;
- (int) phase__
{
    return [self phase];
}

// @property(nonatomic, readonly) NSUInteger tapCount;
- (int) tapCount__
{
    return [self tapCount];
}

// @property(nonatomic, readonly) NSTimeInterval timestamp;
- (double) timestamp__
{
    return [self timestamp];
}

// @property(nonatomic, readonly, strong) UIView *view;
- (UIView*) view__
{
    UIView* re$ult = [self view];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, strong) UIWindow *window;
- (UIWindow*) window__
{
    UIWindow* re$ult = [self window];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (CGPoint)locationInView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGPoint*) locationInView___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[self locationInView:(view == JAVA_NULL ? nil : view)]];
}

@end
