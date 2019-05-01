// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIStoryboardSegue implementation

#import "crossmobile_ios_uikit_UIStoryboardSegue.h"
#import "crossmobile_ios_uikit_UIViewController.h"
#import "java_lang_Object.h"
#import "java_lang_Runnable.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_uikit_UIStoryboardSegue$Ext

// (UIStoryboardSegue) @property(nonatomic, readonly) __kindof UIViewController *destinationViewController;
- (UIViewController*) destinationViewController__
{
    UIViewController* re$ult = [super destinationViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIStoryboardSegue) @property(nonatomic, copy, readonly) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [super identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIStoryboardSegue) @property(nonatomic, readonly) __kindof UIViewController *sourceViewController;
- (UIViewController*) sourceViewController__
{
    UIViewController* re$ult = [super sourceViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIStoryboardSegue) - (void)perform;
- (void) perform__
{
    [super perform];
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

@implementation UIStoryboardSegue (cm_crossmobile_ios_uikit_UIStoryboardSegue)

// direct binding of: + (instancetype)segueWithIdentifier:(NSString *)identifier source:(UIViewController *)source destination:(UIViewController *)destination performHandler:(void (^)(void))performHandler;
+ (instancetype) segueWithIdentifier___java_lang_String_crossmobile_ios_uikit_UIViewController_crossmobile_ios_uikit_UIViewController_java_lang_Runnable:(NSString*) identifier :(UIViewController*) source :(UIViewController*) destination :(id<java_lang_Runnable>) performHandler 
{
    id re$ult = [UIStoryboardSegue segueWithIdentifier:(identifier == JAVA_NULL ? nil : identifier) source:(source == JAVA_NULL ? nil : source) destination:(destination == JAVA_NULL ? nil : destination) performHandler:(performHandler == JAVA_NULL ? nil : ^{
        [performHandler run__];
    })];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (instancetype)initWithIdentifier:(NSString *)identifier source:(UIViewController *)source destination:(UIViewController *)destination;
- (instancetype) __init_crossmobile_ios_uikit_UIStoryboardSegue___java_lang_String_crossmobile_ios_uikit_UIViewController_crossmobile_ios_uikit_UIViewController:(NSString*) identifier :(UIViewController*) source :(UIViewController*) destination 
{
    return [self initWithIdentifier:(identifier == JAVA_NULL ? nil : identifier) source:(source == JAVA_NULL ? nil : source) destination:(destination == JAVA_NULL ? nil : destination)];
}

// direct binding of: @property(nonatomic, readonly) __kindof UIViewController *destinationViewController;
- (UIViewController*) destinationViewController__
{
    UIViewController* re$ult = [self destinationViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, copy, readonly) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [self identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) __kindof UIViewController *sourceViewController;
- (UIViewController*) sourceViewController__
{
    UIViewController* re$ult = [self sourceViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)perform;
- (void) perform__
{
    [self perform];
}

@end
