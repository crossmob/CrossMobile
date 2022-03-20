// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_quartzcore_CALayer implementation

#import "crossmobile_ios_coregraphics_CGContext.h"
#import "crossmobile_ios_coregraphics_CGPoint.h"
#import "crossmobile_ios_quartzcore_CAAnimation.h"
#import "crossmobile_ios_quartzcore_CALayer.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_quartzcore_CALayer$Ext

@end

@implementation CALayer (cm_crossmobile_ios_quartzcore_CALayer)

// + (instancetype)layer;
+ (instancetype) layer__
{
    id re$ult = [CALayer layer];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_quartzcore_CALayer__
{
    return [self init];
}

// @property CGPoint anchorPoint;
- (void) setAnchorPoint___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) anchorPoint 
{
    [self setAnchorPoint:[anchorPoint getCGPoint]];
}

// @property CGPoint anchorPoint;
- (crossmobile_ios_coregraphics_CGPoint*) anchorPoint__
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[self anchorPoint]];
}

// @property(weak) id delegate;
- (void) setDelegate___crossmobile_ios_uikit_UIView:(UIView*) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(weak) id delegate;
- (id) delegate__
{
    id re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(strong) __kindof CALayer *mask;
- (void) setMask___crossmobile_ios_quartzcore_CALayer:(CALayer*) mask 
{
    [self setMask:(mask == JAVA_NULL ? nil : mask)];
}

// @property(strong) __kindof CALayer *mask;
- (CALayer*) mask__
{
    CALayer* re$ult = [self mask];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(copy) NSDictionary *style;
- (NSDictionary*) style__
{
    NSDictionary* re$ult = [self style];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)addAnimation:(CAAnimation *)anim forKey:(NSString *)key;
- (void) addAnimation___crossmobile_ios_quartzcore_CAAnimation_java_lang_String:(CAAnimation*) anim :(NSString*) key 
{
    [self addAnimation:(anim == JAVA_NULL ? nil : anim) forKey:(key == JAVA_NULL ? nil : key)];
}

// - (CAAnimation *)animationForKey:(NSString *)key;
- (CAAnimation*) animationForKey___java_lang_String:(NSString*) key 
{
    CAAnimation* re$ult = [self animationForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSArray<NSString *> *)animationKeys;
- (NSArray*) animationKeys__
{
    NSArray* re$ult = [self animationKeys];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)removeAllAnimations;
- (void) removeAllAnimations__
{
    [self removeAllAnimations];
}

// - (void)removeAnimationForKey:(NSString *)key;
- (void) removeAnimationForKey___java_lang_String:(NSString*) key 
{
    [self removeAnimationForKey:(key == JAVA_NULL ? nil : key)];
}

// - (void)renderInContext:(CGContextRef)ctx;
- (void) renderInContext___crossmobile_ios_coregraphics_CGContext:(crossmobile_ios_coregraphics_CGContext*) ctx 
{
    [self renderInContext:ctx->$reference];
}

@end
