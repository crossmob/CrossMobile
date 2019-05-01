// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.quartzcore.CATransition implementation

#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_quartzcore_CAAnimation.h"
#import "crossmobile_ios_quartzcore_CATransition.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_quartzcore_CATransition$Ext

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

// (CATransition) @property float endProgress;
- (void) setEndProgress___float:(float) endProgress 
{
    [super setEndProgress:endProgress];
}

// (CATransition) @property float endProgress;
- (float) endProgress__
{
    return [super endProgress];
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

// (CATransition) @property float startProgress;
- (void) setStartProgress___float:(float) startProgress 
{
    [super setStartProgress:startProgress];
}

// (CATransition) @property float startProgress;
- (float) startProgress__
{
    return [super startProgress];
}

// (CATransition) @property(copy) NSString *subtype;
- (void) setSubtype___java_lang_String:(NSString*) subtype 
{
    [super setSubtype:(subtype == JAVA_NULL ? nil : subtype)];
}

// (CATransition) @property(copy) NSString *subtype;
- (NSString*) subtype__
{
    NSString* re$ult = [super subtype];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CATransition) @property(copy) NSString *type;
- (void) setType___java_lang_String:(NSString*) type 
{
    [super setType:(type == JAVA_NULL ? nil : type)];
}

// (CATransition) @property(copy) NSString *type;
- (NSString*) type__
{
    NSString* re$ult = [super type];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

@implementation CATransition (cm_crossmobile_ios_quartzcore_CATransition)

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_quartzcore_CATransition__
{
    return [self init];
}

// direct binding of: @property float endProgress;
- (void) setEndProgress___float:(float) endProgress 
{
    [self setEndProgress:endProgress];
}

// direct binding of: @property float endProgress;
- (float) endProgress__
{
    return [self endProgress];
}

// direct binding of: @property float startProgress;
- (void) setStartProgress___float:(float) startProgress 
{
    [self setStartProgress:startProgress];
}

// direct binding of: @property float startProgress;
- (float) startProgress__
{
    return [self startProgress];
}

// direct binding of: @property(copy) NSString *subtype;
- (void) setSubtype___java_lang_String:(NSString*) subtype 
{
    [self setSubtype:(subtype == JAVA_NULL ? nil : subtype)];
}

// direct binding of: @property(copy) NSString *subtype;
- (NSString*) subtype__
{
    NSString* re$ult = [self subtype];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(copy) NSString *type;
- (void) setType___java_lang_String:(NSString*) type 
{
    [self setType:(type == JAVA_NULL ? nil : type)];
}

// direct binding of: @property(copy) NSString *type;
- (NSString*) type__
{
    NSString* re$ult = [self type];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
