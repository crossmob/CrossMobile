// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.quartzcore.CAAnimation implementation

#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_quartzcore_CAAnimation.h"
#import "crossmobile_ios_quartzcore_CATransition.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_quartzcore_CAAnimation$Ext

// (CAAnimation) @property(strong) id delegate;
- (void) setDelegate___crossmobile_ios_foundation_NSObject:(NSObject*) delegate 
{
    [super setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// (CAAnimation) @property(strong) id delegate;
- (id) delegate__
{
    id re$ult = [super delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CAAnimation) @property(getter=isRemovedOnCompletion) BOOL removedOnCompletion;
- (void) setRemovedOnCompletion___boolean:(BOOL) removedOnCompletion 
{
    [super setRemovedOnCompletion:removedOnCompletion];
}

// (CAAnimation) @property(getter=isRemovedOnCompletion) BOOL removedOnCompletion;
- (BOOL) isRemovedOnCompletion__
{
    return [super isRemovedOnCompletion];
}

// (CAAnimation) - (void)animationDidStart:(CAAnimation *)anim;
- (void) animationDidStart___crossmobile_ios_quartzcore_CAAnimation:(CAAnimation*) anim 
{
    [super animationDidStart:(anim == JAVA_NULL ? nil : anim)];
}

// (CAAnimation) - (void)animationDidStop:(CAAnimation *)theAnimation finished:(BOOL)flag;
- (void) animationDidStop___crossmobile_ios_quartzcore_CAAnimation_boolean:(CAAnimation*) theAnimation :(BOOL) flag 
{
    [super animationDidStop:(theAnimation == JAVA_NULL ? nil : theAnimation) finished:flag];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation CAAnimation (cm_crossmobile_ios_quartzcore_CAAnimation)

// direct binding of: + (instancetype)animation;
+ (instancetype) animation__
{
    id re$ult = [CAAnimation animation];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (id)defaultValueForKey:(NSString *)key;
+ (id) defaultValueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [CAAnimation defaultValueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_quartzcore_CAAnimation__
{
    return [self init];
}

// direct binding of: @property(strong) id delegate;
- (void) setDelegate___crossmobile_ios_foundation_NSObject:(NSObject*) delegate 
{
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// direct binding of: @property(strong) id delegate;
- (id) delegate__
{
    id re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(getter=isRemovedOnCompletion) BOOL removedOnCompletion;
- (void) setRemovedOnCompletion___boolean:(BOOL) removedOnCompletion 
{
    [self setRemovedOnCompletion:removedOnCompletion];
}

// direct binding of: @property(getter=isRemovedOnCompletion) BOOL removedOnCompletion;
- (BOOL) isRemovedOnCompletion__
{
    return [self isRemovedOnCompletion];
}

// direct binding of: - (void)animationDidStart:(CAAnimation *)anim;
- (void) animationDidStart___crossmobile_ios_quartzcore_CAAnimation:(CAAnimation*) anim 
{
    [self animationDidStart:(anim == JAVA_NULL ? nil : anim)];
}

// direct binding of: - (void)animationDidStop:(CAAnimation *)theAnimation finished:(BOOL)flag;
- (void) animationDidStop___crossmobile_ios_quartzcore_CAAnimation_boolean:(CAAnimation*) theAnimation :(BOOL) flag 
{
    [self animationDidStop:(theAnimation == JAVA_NULL ? nil : theAnimation) finished:flag];
}

@end
