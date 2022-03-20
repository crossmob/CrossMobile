// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UITapGestureRecognizer implementation

#import "crossmobile_ios_foundation_NSSelector.h"
#import "crossmobile_ios_uikit_UITapGestureRecognizer.h"
#import "java_lang_reflect_Method.h"

@implementation crossmobile_ios_uikit_UITapGestureRecognizer$Ext

@end

@implementation UITapGestureRecognizer (cm_crossmobile_ios_uikit_UITapGestureRecognizer)

// - (instancetype)initWithTarget:(id)target action:(SEL)action;
- (instancetype) __init_crossmobile_ios_uikit_UITapGestureRecognizer___crossmobile_ios_foundation_NSSelector:(id<crossmobile_ios_foundation_NSSelector>) target 
{
    objc_setAssociatedObject(self, (void*)target, target, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    return [self initWithTarget:(target == JAVA_NULL ? nil : target) action:@selector(exec___java_lang_Object:)];
}

// @property(nonatomic) NSUInteger numberOfTapsRequired;
- (void) setNumberOfTapsRequired___int:(int) numberOfTapsRequired 
{
    [self setNumberOfTapsRequired:numberOfTapsRequired];
}

// @property(nonatomic) NSUInteger numberOfTapsRequired;
- (int) numberOfTapsRequired__
{
    return [self numberOfTapsRequired];
}

// @property(nonatomic) NSUInteger numberOfTouchesRequired;
- (void) setNumberOfTouchesRequired___int:(int) numberOfTouchesRequired 
{
    [self setNumberOfTouchesRequired:numberOfTouchesRequired];
}

// @property(nonatomic) NSUInteger numberOfTouchesRequired;
- (int) numberOfTouchesRequired__
{
    return [self numberOfTouchesRequired];
}

@end
