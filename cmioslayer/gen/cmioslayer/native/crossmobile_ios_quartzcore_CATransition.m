// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.quartzcore.CATransition implementation

#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_quartzcore_CAAnimation.h"
#import "crossmobile_ios_quartzcore_CATransition.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

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

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
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

// (NSObject) - (void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary<NSKeyValueChangeKey, id> *)change context:(void *)context;
- (void) observeValueForKeyPath___java_lang_String_java_lang_Object_java_util_Map_java_lang_Object:(NSString*) keyPath :(id) object :(NSDictionary*) change :(id) context 
{
    [super observeValueForKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) ofObject:(object == JAVA_NULL ? nil : object) change:(change == JAVA_NULL ? nil : change) context:(context == JAVA_NULL ? nil : context)];
}

// (NSObject) - (void)removeObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String:(NSObject*) observer :(NSString*) keyPath 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath)];
}

// (NSObject) - (void)removeObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath context:(void *)context;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(id) context 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) context:(context == JAVA_NULL ? nil : context)];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValueForKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (void)setValue:(id)value forUndefinedKey:(NSString *)key;
- (void) setValueForUndefinedKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forUndefinedKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (id)valueForUndefinedKey:(NSString *)key;
- (id) valueForUndefinedKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForUndefinedKey:(key == JAVA_NULL ? nil : key)];
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
