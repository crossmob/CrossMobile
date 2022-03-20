// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIActivity implementation

#import "crossmobile_ios_uikit_UIActivity.h"
#import "crossmobile_ios_uikit_UIImage.h"
#import "crossmobile_ios_uikit_UIViewController.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UIActivity$Ext

@end

@implementation UIActivity (cm_crossmobile_ios_uikit_UIActivity)

// + (UIActivityCategory)activityCategory;
+ (JAVA_LONG) activityCategory__
{
    return [UIActivity activityCategory];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIActivity__
{
    return [self init];
}

// @property(nonatomic, readonly) UIImage *activityImage;
- (UIImage*) activityImage__
{
    UIImage* re$ult = [self activityImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) NSString *activityTitle;
- (NSString*) activityTitle__
{
    NSString* re$ult = [self activityTitle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) UIActivityType activityType;
- (NSString*) activityType__
{
    NSString* re$ult = [self activityType];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) UIViewController *activityViewController;
- (UIViewController*) activityViewController__
{
    UIViewController* re$ult = [self activityViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)activityDidFinish:(BOOL)completed;
- (void) activityDidFinish___boolean:(BOOL) completed 
{
    [self activityDidFinish:completed];
}

// - (BOOL)canPerformWithActivityItems:(NSArray *)activityItems;
- (BOOL) canPerformWithActivityItems___java_util_List:(NSArray*) activityItems 
{
    return [self canPerformWithActivityItems:(activityItems == JAVA_NULL ? nil : activityItems)];
}

// - (void)performActivity;
- (void) performActivity__
{
    [self performActivity];
}

// - (void)prepareWithActivityItems:(NSArray *)activityItems;
- (void) prepareWithActivityItems___java_util_List:(NSArray*) activityItems 
{
    [self prepareWithActivityItems:(activityItems == JAVA_NULL ? nil : activityItems)];
}

@end
