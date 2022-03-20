// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIPrintInteractionController implementation

#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_ios_uikit_UIBarButtonItem.h"
#import "crossmobile_ios_uikit_UIPrintInteractionCompletionHandler.h"
#import "crossmobile_ios_uikit_UIPrintInteractionController.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "java_util_List.h"
#import "java_util_Set.h"

@implementation crossmobile_ios_uikit_UIPrintInteractionController$Ext

@end

@implementation UIPrintInteractionController (cm_crossmobile_ios_uikit_UIPrintInteractionController)

// + (BOOL)canPrintData:(NSData *)data;
+ (BOOL) canPrintData___crossmobile_ios_foundation_NSData:(NSData*) data 
{
    return [UIPrintInteractionController canPrintData:(data == JAVA_NULL ? nil : data)];
}

// + (BOOL)canPrintURL:(NSURL *)url;
+ (BOOL) canPrintURL___crossmobile_ios_foundation_NSURL:(NSURL*) url 
{
    return [UIPrintInteractionController canPrintURL:(url == JAVA_NULL ? nil : url)];
}

// + (BOOL)isPrintingAvailable;
+ (BOOL) isPrintingAvailable__
{
    return [UIPrintInteractionController isPrintingAvailable];
}

// + (NSSet<NSString *> *)printableUTIs;
+ (NSSet*) printableUTIs__
{
    NSSet* re$ult = [UIPrintInteractionController printableUTIs];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UIPrintInteractionController *)sharedPrintController;
+ (UIPrintInteractionController*) sharedPrintController__
{
    UIPrintInteractionController* re$ult = [UIPrintInteractionController sharedPrintController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIPrintInteractionController__
{
    return [self init];
}

// @property(nonatomic, copy) id printingItem;
- (void) setPrintingItem___crossmobile_ios_foundation_NSObject:(NSObject*) printingItem 
{
    [self setPrintingItem:(printingItem == JAVA_NULL ? nil : printingItem)];
}

// @property(nonatomic, copy) id printingItem;
- (id) printingItem__
{
    id re$ult = [self printingItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy) NSArray *printingItems;
- (void) setPrintingItems___java_util_List:(NSArray*) printingItems 
{
    [self setPrintingItems:(printingItems == JAVA_NULL ? nil : printingItems)];
}

// @property(nonatomic, copy) NSArray *printingItems;
- (NSArray*) printingItems__
{
    NSArray* re$ult = [self printingItems];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)dismissAnimated:(BOOL)animated;
- (void) dismissAnimated___boolean:(BOOL) animated 
{
    [self dismissAnimated:animated];
}

// - (BOOL)presentAnimated:(BOOL)animated completionHandler:(UIPrintInteractionCompletionHandler)completion;
- (BOOL) presentAnimated___boolean_crossmobile_ios_uikit_UIPrintInteractionCompletionHandler:(BOOL) animated :(id<crossmobile_ios_uikit_UIPrintInteractionCompletionHandler>) completion 
{
    return [self presentAnimated:animated completionHandler:(completion == JAVA_NULL ? nil : ^(UIPrintInteractionController* printInteractionController, BOOL completed, NSError* error) {
        java_lang_Boolean* completed$conv = [[java_lang_Boolean alloc] initWithBool:completed];
        [completion invoke___crossmobile_ios_uikit_UIPrintInteractionController_java_lang_Boolean_crossmobile_ios_foundation_NSError:(printInteractionController ? printInteractionController : JAVA_NULL) :completed$conv :(error ? error : JAVA_NULL)];
        [completed$conv release];
    })];
}

// - (BOOL)presentFromBarButtonItem:(UIBarButtonItem *)item animated:(BOOL)animated completionHandler:(UIPrintInteractionCompletionHandler)completion;
- (BOOL) presentFromBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem_boolean_crossmobile_ios_uikit_UIPrintInteractionCompletionHandler:(UIBarButtonItem*) item :(BOOL) animated :(id<crossmobile_ios_uikit_UIPrintInteractionCompletionHandler>) completion 
{
    return [self presentFromBarButtonItem:(item == JAVA_NULL ? nil : item) animated:animated completionHandler:(completion == JAVA_NULL ? nil : ^(UIPrintInteractionController* printInteractionController, BOOL completed, NSError* error) {
        java_lang_Boolean* completed$conv = [[java_lang_Boolean alloc] initWithBool:completed];
        [completion invoke___crossmobile_ios_uikit_UIPrintInteractionController_java_lang_Boolean_crossmobile_ios_foundation_NSError:(printInteractionController ? printInteractionController : JAVA_NULL) :completed$conv :(error ? error : JAVA_NULL)];
        [completed$conv release];
    })];
}

// - (BOOL)presentFromRect:(CGRect)rect inView:(UIView *)view animated:(BOOL)animated completionHandler:(UIPrintInteractionCompletionHandler)completion;
- (BOOL) presentFromRect___crossmobile_ios_coregraphics_CGRect_crossmobile_ios_uikit_UIView_boolean_crossmobile_ios_uikit_UIPrintInteractionCompletionHandler:(crossmobile_ios_coregraphics_CGRect*) rect :(UIView*) view :(BOOL) animated :(id<crossmobile_ios_uikit_UIPrintInteractionCompletionHandler>) completion 
{
    return [self presentFromRect:[rect getCGRect] inView:(view == JAVA_NULL ? nil : view) animated:animated completionHandler:(completion == JAVA_NULL ? nil : ^(UIPrintInteractionController* printInteractionController, BOOL completed, NSError* error) {
        java_lang_Boolean* completed$conv = [[java_lang_Boolean alloc] initWithBool:completed];
        [completion invoke___crossmobile_ios_uikit_UIPrintInteractionController_java_lang_Boolean_crossmobile_ios_foundation_NSError:(printInteractionController ? printInteractionController : JAVA_NULL) :completed$conv :(error ? error : JAVA_NULL)];
        [completed$conv release];
    })];
}

@end
