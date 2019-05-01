// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIStoryboardUnwindSegueSource implementation

#import "crossmobile_ios_uikit_UIStoryboardUnwindSegueSource.h"
#import "crossmobile_ios_uikit_UIViewController.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_lang_reflect_Method.h"

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
