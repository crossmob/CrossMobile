// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIStoryboardSegue implementation

#import "crossmobile_ios_uikit_UIStoryboardSegue.h"
#import "crossmobile_ios_uikit_UIViewController.h"
#import "java_lang_Runnable.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_uikit_UIStoryboardSegue$Ext

@end

@implementation UIStoryboardSegue (cm_crossmobile_ios_uikit_UIStoryboardSegue)

// + (instancetype)segueWithIdentifier:(NSString *)identifier source:(UIViewController *)source destination:(UIViewController *)destination performHandler:(void (^)(void))performHandler;
+ (instancetype) segueWithIdentifier___java_lang_String_crossmobile_ios_uikit_UIViewController_crossmobile_ios_uikit_UIViewController_java_lang_Runnable:(NSString*) identifier :(UIViewController*) source :(UIViewController*) destination :(id<java_lang_Runnable>) performHandler 
{
    id re$ult = [UIStoryboardSegue segueWithIdentifier:(identifier == JAVA_NULL ? nil : identifier) source:(source == JAVA_NULL ? nil : source) destination:(destination == JAVA_NULL ? nil : destination) performHandler:(performHandler == JAVA_NULL ? nil : ^{
        [performHandler run__];
    })];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (instancetype)initWithIdentifier:(NSString *)identifier source:(UIViewController *)source destination:(UIViewController *)destination;
- (instancetype) __init_crossmobile_ios_uikit_UIStoryboardSegue___java_lang_String_crossmobile_ios_uikit_UIViewController_crossmobile_ios_uikit_UIViewController:(NSString*) identifier :(UIViewController*) source :(UIViewController*) destination 
{
    return [self initWithIdentifier:(identifier == JAVA_NULL ? nil : identifier) source:(source == JAVA_NULL ? nil : source) destination:(destination == JAVA_NULL ? nil : destination)];
}

// @property(nonatomic, readonly) __kindof UIViewController *destinationViewController;
- (UIViewController*) destinationViewController__
{
    UIViewController* re$ult = [self destinationViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy, readonly) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [self identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) __kindof UIViewController *sourceViewController;
- (UIViewController*) sourceViewController__
{
    UIViewController* re$ult = [self sourceViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)perform;
- (void) perform__
{
    [self perform];
}

@end
