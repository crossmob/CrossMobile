// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIStoryboard implementation

#import "crossmobile_ios_foundation_NSBundle.h"
#import "crossmobile_ios_uikit_UIStoryboard.h"
#import "crossmobile_ios_uikit_UIViewController.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_uikit_UIStoryboard$Ext

@end

@implementation UIStoryboard (cm_crossmobile_ios_uikit_UIStoryboard)

// + (UIStoryboard *)storyboardWithName:(NSString *)name bundle:(NSBundle *)storyboardBundleOrNil;
+ (UIStoryboard*) storyboardWithName___java_lang_String_crossmobile_ios_foundation_NSBundle:(NSString*) name :(NSBundle*) storyboardBundleOrNil 
{
    UIStoryboard* re$ult = [UIStoryboard storyboardWithName:(name == JAVA_NULL ? nil : name) bundle:(storyboardBundleOrNil == JAVA_NULL ? nil : storyboardBundleOrNil)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIStoryboard__
{
    return [self init];
}

// - (__kindof UIViewController *)instantiateInitialViewController;
- (UIViewController*) instantiateInitialViewController__
{
    UIViewController* re$ult = [self instantiateInitialViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (__kindof UIViewController *)instantiateViewControllerWithIdentifier:(NSString *)identifier;
- (UIViewController*) instantiateViewControllerWithIdentifier___java_lang_String:(NSString*) identifier 
{
    UIViewController* re$ult = [self instantiateViewControllerWithIdentifier:(identifier == JAVA_NULL ? nil : identifier)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
