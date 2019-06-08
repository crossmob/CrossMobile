// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIStoryboardUnwindSegueSource implementation

#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_uikit_UIStoryboardUnwindSegueSource.h"
#import "crossmobile_ios_uikit_UIViewController.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_lang_reflect_Method.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_uikit_UIStoryboardUnwindSegueSource$Ext

// (UIStoryboardUnwindSegueSource) @property(readonly) id sender;
- (id) sender__
{
    id re$ult = [super sender];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIStoryboardUnwindSegueSource) @property(readonly) UIViewController *sourceViewController;
- (UIViewController*) sourceViewController__
{
    UIViewController* re$ult = [super sourceViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIStoryboardUnwindSegueSource) @property(readonly) SEL unwindAction;
- (java_lang_reflect_Method*) unwindAction__
{
    java_lang_reflect_Method* re$ult = [super unwindAction];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
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

@implementation UIStoryboardUnwindSegueSource (cm_crossmobile_ios_uikit_UIStoryboardUnwindSegueSource)

// direct binding of: @property(readonly) id sender;
- (id) sender__
{
    id re$ult = [self sender];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly) UIViewController *sourceViewController;
- (UIViewController*) sourceViewController__
{
    UIViewController* re$ult = [self sourceViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly) SEL unwindAction;
- (java_lang_reflect_Method*) unwindAction__
{
    java_lang_reflect_Method* re$ult = [self unwindAction];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
