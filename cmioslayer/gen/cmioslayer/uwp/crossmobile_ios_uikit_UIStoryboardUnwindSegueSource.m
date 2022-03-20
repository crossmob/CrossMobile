// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIStoryboardUnwindSegueSource implementation

#import "crossmobile_ios_uikit_UIStoryboardUnwindSegueSource.h"
#import "crossmobile_ios_uikit_UIViewController.h"
#import "java_lang_Object.h"
#import "java_lang_reflect_Method.h"

@implementation crossmobile_ios_uikit_UIStoryboardUnwindSegueSource$Ext

@end

@implementation UIStoryboardUnwindSegueSource (cm_crossmobile_ios_uikit_UIStoryboardUnwindSegueSource)

// @property(readonly) id sender;
- (id) sender__
{
    id re$ult = [self sender];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly) UIViewController *sourceViewController;
- (UIViewController*) sourceViewController__
{
    UIViewController* re$ult = [self sourceViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly) SEL unwindAction;
- (java_lang_reflect_Method*) unwindAction__
{
    java_lang_reflect_Method* re$ult = [self unwindAction];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
