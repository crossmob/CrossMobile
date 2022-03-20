// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIRotationGestureRecognizer implementation

#import "crossmobile_ios_foundation_NSSelector.h"
#import "crossmobile_ios_uikit_UIRotationGestureRecognizer.h"
#import "java_lang_reflect_Method.h"

@implementation crossmobile_ios_uikit_UIRotationGestureRecognizer$Ext

@end

@implementation UIRotationGestureRecognizer (cm_crossmobile_ios_uikit_UIRotationGestureRecognizer)

// - (instancetype)initWithTarget:(id)target action:(SEL)action;
- (instancetype) __init_crossmobile_ios_uikit_UIRotationGestureRecognizer___crossmobile_ios_foundation_NSSelector:(id<crossmobile_ios_foundation_NSSelector>) target 
{
    objc_setAssociatedObject(self, (void*)target, target, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    return [self initWithTarget:(target == JAVA_NULL ? nil : target) action:@selector(exec___java_lang_Object:)];
}

// @property(nonatomic) CGFloat rotation;
- (void) setRotation___double:(double) rotation 
{
    [self setRotation:rotation];
}

// @property(nonatomic) CGFloat rotation;
- (double) rotation__
{
    return [self rotation];
}

// @property(nonatomic, readonly) CGFloat velocity;
- (double) velocity__
{
    return [self velocity];
}

@end
