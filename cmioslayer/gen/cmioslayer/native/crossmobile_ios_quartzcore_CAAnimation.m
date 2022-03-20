// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_quartzcore_CAAnimation implementation

#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_quartzcore_CAAnimation.h"
#import "crossmobile_ios_quartzcore_CATransition.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_quartzcore_CAAnimation$Ext

@end

@implementation CAAnimation (cm_crossmobile_ios_quartzcore_CAAnimation)

// + (instancetype)animation;
+ (instancetype) animation__
{
    id re$ult = [CAAnimation animation];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (id)defaultValueForKey:(NSString *)key;
+ (id) defaultValueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [CAAnimation defaultValueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_quartzcore_CAAnimation__
{
    return [self init];
}

// @property(strong) id delegate;
- (void) setDelegate___crossmobile_ios_foundation_NSObject:(NSObject*) delegate 
{
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(strong) id delegate;
- (id) delegate__
{
    id re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(getter=isRemovedOnCompletion) BOOL removedOnCompletion;
- (void) setRemovedOnCompletion___boolean:(BOOL) removedOnCompletion 
{
    [self setRemovedOnCompletion:removedOnCompletion];
}

// @property(getter=isRemovedOnCompletion) BOOL removedOnCompletion;
- (BOOL) isRemovedOnCompletion__
{
    return [self isRemovedOnCompletion];
}

// - (void)animationDidStart:(CAAnimation *)anim;
- (void) animationDidStart___crossmobile_ios_quartzcore_CAAnimation:(CAAnimation*) anim 
{
    [self animationDidStart:(anim == JAVA_NULL ? nil : anim)];
}

// - (void)animationDidStop:(CAAnimation *)theAnimation finished:(BOOL)flag;
- (void) animationDidStop___crossmobile_ios_quartzcore_CAAnimation_boolean:(CAAnimation*) theAnimation :(BOOL) flag 
{
    [self animationDidStop:(theAnimation == JAVA_NULL ? nil : theAnimation) finished:flag];
}

@end
