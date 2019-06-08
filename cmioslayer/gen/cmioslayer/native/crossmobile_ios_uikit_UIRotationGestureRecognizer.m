// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIRotationGestureRecognizer implementation

#import "crossmobile_ios_coregraphics_CGPoint.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_foundation_NSSelector.h"
#import "crossmobile_ios_uikit_UIEvent.h"
#import "crossmobile_ios_uikit_UIGestureRecognizer.h"
#import "crossmobile_ios_uikit_UIGestureRecognizerDelegate.h"
#import "crossmobile_ios_uikit_UIRotationGestureRecognizer.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_lang_reflect_Method.h"
#import "java_util_Map.h"
#import "java_util_Set.h"

@implementation crossmobile_ios_uikit_UIRotationGestureRecognizer$Ext

// (UIGestureRecognizer) @property(nonatomic) BOOL cancelsTouchesInView;
- (void) setCancelsTouchesInView___boolean:(BOOL) cancelsTouchesInView 
{
    [super setCancelsTouchesInView:cancelsTouchesInView];
}

// (UIGestureRecognizer) @property(nonatomic) BOOL cancelsTouchesInView;
- (BOOL) cancelsTouchesInView__
{
    return [super cancelsTouchesInView];
}

// (UIGestureRecognizer) @property(nonatomic) BOOL delaysTouchesBegan;
- (void) setDelaysTouchesBegan___boolean:(BOOL) delaysTouchesBegan 
{
    [super setDelaysTouchesBegan:delaysTouchesBegan];
}

// (UIGestureRecognizer) @property(nonatomic) BOOL delaysTouchesBegan;
- (BOOL) delaysTouchesBegan__
{
    return [super delaysTouchesBegan];
}

// (UIGestureRecognizer) @property(nonatomic) BOOL delaysTouchesEnded;
- (void) setDelaysTouchesEnded___boolean:(BOOL) delaysTouchesEnded 
{
    [super setDelaysTouchesEnded:delaysTouchesEnded];
}

// (UIGestureRecognizer) @property(nonatomic) BOOL delaysTouchesEnded;
- (BOOL) delaysTouchesEnded__
{
    return [super delaysTouchesEnded];
}

// (UIGestureRecognizer) @property(nonatomic, weak) id<UIGestureRecognizerDelegate> delegate;
- (void) setDelegate___crossmobile_ios_uikit_UIGestureRecognizerDelegate:(id<UIGestureRecognizerDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [super setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// (UIGestureRecognizer) @property(nonatomic, weak) id<UIGestureRecognizerDelegate> delegate;
- (id<UIGestureRecognizerDelegate>) delegate__
{
    id<UIGestureRecognizerDelegate> re$ult = [super delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIGestureRecognizer) @property(nonatomic, getter=isEnabled) BOOL enabled;
- (void) setEnabled___boolean:(BOOL) enabled 
{
    [super setEnabled:enabled];
}

// (UIGestureRecognizer) @property(nonatomic, getter=isEnabled) BOOL enabled;
- (BOOL) isEnabled__
{
    return [super isEnabled];
}

// (UIRotationGestureRecognizer) @property(nonatomic) CGFloat rotation;
- (void) setRotation___double:(double) rotation 
{
    [super setRotation:rotation];
}

// (UIRotationGestureRecognizer) @property(nonatomic) CGFloat rotation;
- (double) rotation__
{
    return [super rotation];
}

// (UIGestureRecognizer) @property(nonatomic, readonly) UIGestureRecognizerState state;
- (int) state__
{
    return [super state];
}

// (UIRotationGestureRecognizer) @property(nonatomic, readonly) CGFloat velocity;
- (double) velocity__
{
    return [super velocity];
}

// (UIGestureRecognizer) @property(nonatomic, readonly) UIView *view;
- (UIView*) view__
{
    UIView* re$ult = [super view];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (UIGestureRecognizer) - (void)addTarget:(id)target action:(SEL)action;
- (void) addTarget___crossmobile_ios_foundation_NSSelector:(id<crossmobile_ios_foundation_NSSelector>) target 
{
    objc_setAssociatedObject(self, (void*)target, target, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [super addTarget:(target == JAVA_NULL ? nil : target) action:@selector(exec___java_lang_Object:)];
}

// (UIGestureRecognizer) - (BOOL)canBePreventedByGestureRecognizer:(UIGestureRecognizer *)preventingGestureRecognizer;
- (BOOL) canBePreventedByGestureRecognizer___crossmobile_ios_uikit_UIGestureRecognizer:(UIGestureRecognizer*) preventingGestureRecognizer 
{
    return [super canBePreventedByGestureRecognizer:(preventingGestureRecognizer == JAVA_NULL ? nil : preventingGestureRecognizer)];
}

// (UIGestureRecognizer) - (BOOL)canPreventGestureRecognizer:(UIGestureRecognizer *)preventedGestureRecognizer;
- (BOOL) canPreventGestureRecognizer___crossmobile_ios_uikit_UIGestureRecognizer:(UIGestureRecognizer*) preventedGestureRecognizer 
{
    return [super canPreventGestureRecognizer:(preventedGestureRecognizer == JAVA_NULL ? nil : preventedGestureRecognizer)];
}

// (UIGestureRecognizer) - (CGPoint)locationInView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGPoint*) locationInView___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[super locationInView:(view == JAVA_NULL ? nil : view)]];
}

// (UIGestureRecognizer) - (CGPoint)locationOfTouch:(NSUInteger)touchIndex inView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGPoint*) locationOfTouch___int_crossmobile_ios_uikit_UIView:(int) touchIndex :(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[super locationOfTouch:touchIndex inView:(view == JAVA_NULL ? nil : view)]];
}

// (UIGestureRecognizer) - (NSUInteger)numberOfTouches;
- (int) numberOfTouches__
{
    return [super numberOfTouches];
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

// (UIGestureRecognizer) - (void)removeTarget:(id)target action:(SEL)action;
- (void) removeTarget___crossmobile_ios_foundation_NSSelector:(id<crossmobile_ios_foundation_NSSelector>) target 
{
    objc_setAssociatedObject(self, (void*)target, nil, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [super removeTarget:(target == JAVA_NULL ? nil : target) action:@selector(exec___java_lang_Object:)];
}

// (UIGestureRecognizer) - (void)requireGestureRecognizerToFail:(UIGestureRecognizer *)otherGestureRecognizer;
- (void) requireGestureRecognizerToFail___crossmobile_ios_uikit_UIGestureRecognizer:(UIGestureRecognizer*) otherGestureRecognizer 
{
    [super requireGestureRecognizerToFail:(otherGestureRecognizer == JAVA_NULL ? nil : otherGestureRecognizer)];
}

// (UIGestureRecognizer) - (void)reset;
- (void) reset__
{
    [super reset];
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

// (UIGestureRecognizer) - (void)touchesBegan:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event;
- (void) touchesBegan___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event 
{
    [super touchesBegan:(touches == JAVA_NULL ? nil : touches) withEvent:(event == JAVA_NULL ? nil : event)];
}

// (UIGestureRecognizer) - (void)touchesCancelled:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event;
- (void) touchesCancelled___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event 
{
    [super touchesCancelled:(touches == JAVA_NULL ? nil : touches) withEvent:(event == JAVA_NULL ? nil : event)];
}

// (UIGestureRecognizer) - (void)touchesEnded:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event;
- (void) touchesEnded___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event 
{
    [super touchesEnded:(touches == JAVA_NULL ? nil : touches) withEvent:(event == JAVA_NULL ? nil : event)];
}

// (UIGestureRecognizer) - (void)touchesMoved:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event;
- (void) touchesMoved___java_util_Set_crossmobile_ios_uikit_UIEvent:(NSSet*) touches :(UIEvent*) event 
{
    [super touchesMoved:(touches == JAVA_NULL ? nil : touches) withEvent:(event == JAVA_NULL ? nil : event)];
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

@implementation UIRotationGestureRecognizer (cm_crossmobile_ios_uikit_UIRotationGestureRecognizer)

// direct binding of: - (instancetype)initWithTarget:(id)target action:(SEL)action;
- (instancetype) __init_crossmobile_ios_uikit_UIRotationGestureRecognizer___crossmobile_ios_foundation_NSSelector:(id<crossmobile_ios_foundation_NSSelector>) target 
{
    objc_setAssociatedObject(self, (void*)target, target, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    return [self initWithTarget:(target == JAVA_NULL ? nil : target) action:@selector(exec___java_lang_Object:)];
}

// direct binding of: @property(nonatomic) CGFloat rotation;
- (void) setRotation___double:(double) rotation 
{
    [self setRotation:rotation];
}

// direct binding of: @property(nonatomic) CGFloat rotation;
- (double) rotation__
{
    return [self rotation];
}

// direct binding of: @property(nonatomic, readonly) CGFloat velocity;
- (double) velocity__
{
    return [self velocity];
}

@end
