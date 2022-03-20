// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIPinchGestureRecognizer implementation

#import "crossmobile_ios_foundation_NSSelector.h"
#import "crossmobile_ios_uikit_UIPinchGestureRecognizer.h"
#import "java_lang_reflect_Method.h"

@implementation crossmobile_ios_uikit_UIPinchGestureRecognizer$Ext

@end

@implementation UIPinchGestureRecognizer (cm_crossmobile_ios_uikit_UIPinchGestureRecognizer)

// - (instancetype)initWithTarget:(id)target action:(SEL)action;
- (instancetype) __init_crossmobile_ios_uikit_UIPinchGestureRecognizer___crossmobile_ios_foundation_NSSelector:(id<crossmobile_ios_foundation_NSSelector>) target 
{
    objc_setAssociatedObject(self, (void*)target, target, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    return [self initWithTarget:(target == JAVA_NULL ? nil : target) action:@selector(exec___java_lang_Object:)];
}

// @property(nonatomic) CGFloat scale;
- (void) setScale___double:(double) scale 
{
    [self setScale:scale];
}

// @property(nonatomic) CGFloat scale;
- (double) scale__
{
    return [self scale];
}

// @property(nonatomic, readonly) CGFloat velocity;
- (double) velocity__
{
    return [self velocity];
}

@end
