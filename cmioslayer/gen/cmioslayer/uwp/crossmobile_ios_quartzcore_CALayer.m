// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.quartzcore.CALayer implementation

#import "crossmobile_ios_coregraphics_CGContext.h"
#import "crossmobile_ios_coregraphics_CGPoint.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_quartzcore_CAAnimation.h"
#import "crossmobile_ios_quartzcore_CALayer.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_quartzcore_CALayer$Ext

// (CALayer) @property CGPoint anchorPoint;
- (void) setAnchorPoint___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) anchorPoint 
{
    [super setAnchorPoint:[anchorPoint getCGPoint]];
}

// (CALayer) @property CGPoint anchorPoint;
- (crossmobile_ios_coregraphics_CGPoint*) anchorPoint__
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[super anchorPoint]];
}

// (CALayer) @property(weak) id delegate;
- (void) setDelegate___crossmobile_ios_uikit_UIView:(UIView*) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [super setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// (CALayer) @property(weak) id delegate;
- (id) delegate__
{
    id re$ult = [super delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CALayer) @property(copy) NSDictionary *style;
- (NSDictionary*) style__
{
    NSDictionary* re$ult = [super style];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CALayer) - (void)addAnimation:(CAAnimation *)anim forKey:(NSString *)key;
- (void) addAnimation___crossmobile_ios_quartzcore_CAAnimation_java_lang_String:(CAAnimation*) anim :(NSString*) key 
{
    [super addAnimation:(anim == JAVA_NULL ? nil : anim) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (CALayer) - (CAAnimation *)animationForKey:(NSString *)key;
- (CAAnimation*) animationForKey___java_lang_String:(NSString*) key 
{
    CAAnimation* re$ult = [super animationForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CALayer) - (NSArray<NSString *> *)animationKeys;
- (NSArray*) animationKeys__
{
    NSArray* re$ult = [super animationKeys];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary<NSKeyValueChangeKey, id> *)change context:(void *)context;
- (void) observeValueForKeyPath___java_lang_String_java_lang_Object_java_util_Map_java_lang_Object:(NSString*) keyPath :(id) object :(NSDictionary*) change :(id) context 
{
    [super observeValueForKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) ofObject:(object == JAVA_NULL ? nil : object) change:(change == JAVA_NULL ? nil : change) context:(context == JAVA_NULL ? nil : context)];
}

// (CALayer) - (void)removeAllAnimations;
- (void) removeAllAnimations__
{
    [super removeAllAnimations];
}

// (CALayer) - (void)removeAnimationForKey:(NSString *)key;
- (void) removeAnimationForKey___java_lang_String:(NSString*) key 
{
    [super removeAnimationForKey:(key == JAVA_NULL ? nil : key)];
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

// (CALayer) - (void)renderInContext:(CGContextRef)ctx;
- (void) renderInContext___crossmobile_ios_coregraphics_CGContext:(crossmobile_ios_coregraphics_CGContext*) ctx 
{
    [super renderInContext:ctx->$reference];
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

@implementation CALayer (cm_crossmobile_ios_quartzcore_CALayer)

// direct binding of: + (instancetype)layer;
+ (instancetype) layer__
{
    id re$ult = [CALayer layer];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_quartzcore_CALayer__
{
    return [self init];
}

// direct binding of: @property CGPoint anchorPoint;
- (void) setAnchorPoint___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) anchorPoint 
{
    [self setAnchorPoint:[anchorPoint getCGPoint]];
}

// direct binding of: @property CGPoint anchorPoint;
- (crossmobile_ios_coregraphics_CGPoint*) anchorPoint__
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[self anchorPoint]];
}

// direct binding of: @property(weak) id delegate;
- (void) setDelegate___crossmobile_ios_uikit_UIView:(UIView*) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// direct binding of: @property(weak) id delegate;
- (id) delegate__
{
    id re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(copy) NSDictionary *style;
- (NSDictionary*) style__
{
    NSDictionary* re$ult = [self style];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)addAnimation:(CAAnimation *)anim forKey:(NSString *)key;
- (void) addAnimation___crossmobile_ios_quartzcore_CAAnimation_java_lang_String:(CAAnimation*) anim :(NSString*) key 
{
    [self addAnimation:(anim == JAVA_NULL ? nil : anim) forKey:(key == JAVA_NULL ? nil : key)];
}

// direct binding of: - (CAAnimation *)animationForKey:(NSString *)key;
- (CAAnimation*) animationForKey___java_lang_String:(NSString*) key 
{
    CAAnimation* re$ult = [self animationForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (NSArray<NSString *> *)animationKeys;
- (NSArray*) animationKeys__
{
    NSArray* re$ult = [self animationKeys];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)removeAllAnimations;
- (void) removeAllAnimations__
{
    [self removeAllAnimations];
}

// direct binding of: - (void)removeAnimationForKey:(NSString *)key;
- (void) removeAnimationForKey___java_lang_String:(NSString*) key 
{
    [self removeAnimationForKey:(key == JAVA_NULL ? nil : key)];
}

// direct binding of: - (void)renderInContext:(CGContextRef)ctx;
- (void) renderInContext___crossmobile_ios_coregraphics_CGContext:(crossmobile_ios_coregraphics_CGContext*) ctx 
{
    [self renderInContext:ctx->$reference];
}

@end
