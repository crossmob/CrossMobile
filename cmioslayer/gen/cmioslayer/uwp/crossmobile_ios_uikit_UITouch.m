// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UITouch implementation

#import "crossmobile_ios_coregraphics_CGPoint.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_uikit_UITouch.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "crossmobile_ios_uikit_UIWindow.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_uikit_UITouch$Ext

// (UITouch) @property(nonatomic, readonly) UITouchPhase phase;
- (int) phase__
{
    return [super phase];
}

// (UITouch) @property(nonatomic, readonly) NSUInteger tapCount;
- (int) tapCount__
{
    return [super tapCount];
}

// (UITouch) @property(nonatomic, readonly) NSTimeInterval timestamp;
- (double) timestamp__
{
    return [super timestamp];
}

// (UITouch) @property(nonatomic, readonly, strong) UIView *view;
- (UIView*) view__
{
    UIView* re$ult = [super view];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UITouch) @property(nonatomic, readonly, strong) UIWindow *window;
- (UIWindow*) window__
{
    UIWindow* re$ult = [super window];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (UITouch) - (CGPoint)locationInView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGPoint*) locationInView___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[super locationInView:(view == JAVA_NULL ? nil : view)]];
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

@implementation UITouch (cm_crossmobile_ios_uikit_UITouch)

// direct binding of: @property(nonatomic, readonly) UITouchPhase phase;
- (int) phase__
{
    return [self phase];
}

// direct binding of: @property(nonatomic, readonly) NSUInteger tapCount;
- (int) tapCount__
{
    return [self tapCount];
}

// direct binding of: @property(nonatomic, readonly) NSTimeInterval timestamp;
- (double) timestamp__
{
    return [self timestamp];
}

// direct binding of: @property(nonatomic, readonly, strong) UIView *view;
- (UIView*) view__
{
    UIView* re$ult = [self view];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, strong) UIWindow *window;
- (UIWindow*) window__
{
    UIWindow* re$ult = [self window];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (CGPoint)locationInView:(UIView *)view;
- (crossmobile_ios_coregraphics_CGPoint*) locationInView___crossmobile_ios_uikit_UIView:(UIView*) view 
{
    return [[crossmobile_ios_coregraphics_CGPoint alloc] initWithCGPoint:[self locationInView:(view == JAVA_NULL ? nil : view)]];
}

@end
