// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIActivityViewController implementation

#import "crossmobile_ios_uikit_UIActivityViewController.h"
#import "crossmobile_ios_uikit_UIActivityViewControllerCompletionHandler.h"
#import "crossmobile_ios_uikit_UIActivityViewControllerCompletionWithItemsHandler.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UIActivityViewController$Ext

@end

@implementation UIActivityViewController (cm_crossmobile_ios_uikit_UIActivityViewController)

// - (instancetype)initWithActivityItems:(NSArray *)activityItems applicationActivities:(NSArray<__kindof UIActivity *> *)applicationActivities;
- (instancetype) __init_crossmobile_ios_uikit_UIActivityViewController___java_util_List_java_util_List:(NSArray*) activityItems :(NSArray*) applicationActivities 
{
    return [self initWithActivityItems:(activityItems == JAVA_NULL ? nil : activityItems) applicationActivities:(applicationActivities == JAVA_NULL ? nil : applicationActivities)];
}

// @property(nonatomic, copy) UIActivityViewControllerCompletionHandler completionHandler;
- (void) setCompletionHandler___crossmobile_ios_uikit_UIActivityViewControllerCompletionHandler:(id<crossmobile_ios_uikit_UIActivityViewControllerCompletionHandler>) completionHandler 
{
    [self setCompletionHandler:(completionHandler == JAVA_NULL ? nil : ^(UIActivityType activityType, BOOL completed) {
        java_lang_Boolean* completed$conv = [[java_lang_Boolean alloc] initWithBool:completed];
        [completionHandler invoke___java_lang_String_java_lang_Boolean:(activityType ? activityType : JAVA_NULL) :completed$conv];
        [completed$conv release];
    })];
}

// @property(nonatomic, copy) UIActivityViewControllerCompletionWithItemsHandler completionWithItemsHandler;
- (void) setCompletionWithItemsHandler___crossmobile_ios_uikit_UIActivityViewControllerCompletionWithItemsHandler:(id<crossmobile_ios_uikit_UIActivityViewControllerCompletionWithItemsHandler>) completionWithItemsHandler 
{
    [self setCompletionWithItemsHandler:(completionWithItemsHandler == JAVA_NULL ? nil : ^(UIActivityType activityType, BOOL completed, NSArray* returnedItems, NSError* activityError) {
        java_lang_Boolean* completed$conv = [[java_lang_Boolean alloc] initWithBool:completed];
        [completionWithItemsHandler invoke___java_lang_String_java_lang_Boolean_java_util_List_crossmobile_ios_foundation_NSError:(activityType ? activityType : JAVA_NULL) :completed$conv :(returnedItems ? returnedItems : JAVA_NULL) :(activityError ? activityError : JAVA_NULL)];
        [completed$conv release];
    })];
}

// @property(nonatomic, copy) NSArray<UIActivityType> *excludedActivityTypes;
- (void) setExcludedActivityTypes___java_util_List:(NSArray*) excludedActivityTypes 
{
    [self setExcludedActivityTypes:(excludedActivityTypes == JAVA_NULL ? nil : excludedActivityTypes)];
}

// @property(nonatomic, copy) NSArray<UIActivityType> *excludedActivityTypes;
- (NSArray*) excludedActivityTypes__
{
    NSArray* re$ult = [self excludedActivityTypes];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
