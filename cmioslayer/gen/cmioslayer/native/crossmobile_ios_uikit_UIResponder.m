// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIResponder implementation

#import "crossmobile_ios_uikit_UIEvent.h"
#import "crossmobile_ios_uikit_UIResponder.h"
#import "java_util_Set.h"

@implementation crossmobile_ios_uikit_UIResponder$Ext

@end

@implementation UIResponder (cm_crossmobile_ios_uikit_UIResponder)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIResponder__
{
    return [self init];
}

// - (BOOL)becomeFirstResponder;
- (BOOL) becomeFirstResponder__
{
    return [self becomeFirstResponder];
}

// - (BOOL)isFirstResponder;
- (BOOL) isFirstResponder__
{
    return [self isFirstResponder];
}

// - (UIResponder *)nextResponder;
- (UIResponder*) nextResponder__
{
    UIResponder* re$ult = [self nextResponder];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (BOOL)resignFirstResponder;
- (BOOL) resignFirstResponder__
{
    return [self resignFirstResponder];
}

// - (void)touchesBegan:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event;
- (void) touchesBegan___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event 
{
    [self touchesBegan:(touches == JAVA_NULL ? nil : touches) withEvent:(event == JAVA_NULL ? nil : event)];
}

// - (void)touchesCancelled:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event;
- (void) touchesCancelled___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event 
{
    [self touchesCancelled:(touches == JAVA_NULL ? nil : touches) withEvent:(event == JAVA_NULL ? nil : event)];
}

// - (void)touchesEnded:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event;
- (void) touchesEnded___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event 
{
    [self touchesEnded:(touches == JAVA_NULL ? nil : touches) withEvent:(event == JAVA_NULL ? nil : event)];
}

// - (void)touchesMoved:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event;
- (void) touchesMoved___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event 
{
    [self touchesMoved:(touches == JAVA_NULL ? nil : touches) withEvent:(event == JAVA_NULL ? nil : event)];
}

@end
