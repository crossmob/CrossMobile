// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIPrintInteractionController implementation

#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_ios_uikit_UIBarButtonItem.h"
#import "crossmobile_ios_uikit_UIPrintInteractionCompletionHandler.h"
#import "crossmobile_ios_uikit_UIPrintInteractionController.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Set.h"

@implementation crossmobile_ios_uikit_UIPrintInteractionController$Ext

// (UIPrintInteractionController) @property(nonatomic, copy) id printingItem;
- (void) setPrintingItem___crossmobile_ios_foundation_NSObject:(NSObject*) printingItem 
{
    [super setPrintingItem:(printingItem == JAVA_NULL ? nil : printingItem)];
}

// (UIPrintInteractionController) @property(nonatomic, copy) id printingItem;
- (id) printingItem__
{
    id re$ult = [super printingItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIPrintInteractionController) @property(nonatomic, copy) NSArray *printingItems;
- (void) setPrintingItems___java_util_List:(NSArray*) printingItems 
{
    [super setPrintingItems:(printingItems == JAVA_NULL ? nil : printingItems)];
}

// (UIPrintInteractionController) @property(nonatomic, copy) NSArray *printingItems;
- (NSArray*) printingItems__
{
    NSArray* re$ult = [super printingItems];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIPrintInteractionController) - (void)dismissAnimated:(BOOL)animated;
- (void) dismissAnimated___boolean:(BOOL) animated 
{
    [super dismissAnimated:animated];
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

@implementation UIPrintInteractionController (cm_crossmobile_ios_uikit_UIPrintInteractionController)

// direct binding of: + (BOOL)canPrintData:(NSData *)data;
+ (BOOL) canPrintData___crossmobile_ios_foundation_NSData:(NSData*) data 
{
    return [UIPrintInteractionController canPrintData:(data == JAVA_NULL ? nil : data)];
}

// direct binding of: + (BOOL)canPrintURL:(NSURL *)url;
+ (BOOL) canPrintURL___crossmobile_ios_foundation_NSURL:(NSURL*) url 
{
    return [UIPrintInteractionController canPrintURL:(url == JAVA_NULL ? nil : url)];
}

// direct binding of: + (BOOL)isPrintingAvailable;
+ (BOOL) isPrintingAvailable__
{
    return [UIPrintInteractionController isPrintingAvailable];
}

// direct binding of: + (NSSet<NSString *> *)printableUTIs;
+ (NSSet*) printableUTIs__
{
    NSSet* re$ult = [UIPrintInteractionController printableUTIs];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UIPrintInteractionController *)sharedPrintController;
+ (UIPrintInteractionController*) sharedPrintController__
{
    UIPrintInteractionController* re$ult = [UIPrintInteractionController sharedPrintController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIPrintInteractionController__
{
    return [self init];
}

// direct binding of: @property(nonatomic, copy) id printingItem;
- (void) setPrintingItem___crossmobile_ios_foundation_NSObject:(NSObject*) printingItem 
{
    [self setPrintingItem:(printingItem == JAVA_NULL ? nil : printingItem)];
}

// direct binding of: @property(nonatomic, copy) id printingItem;
- (id) printingItem__
{
    id re$ult = [self printingItem];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, copy) NSArray *printingItems;
- (void) setPrintingItems___java_util_List:(NSArray*) printingItems 
{
    [self setPrintingItems:(printingItems == JAVA_NULL ? nil : printingItems)];
}

// direct binding of: @property(nonatomic, copy) NSArray *printingItems;
- (NSArray*) printingItems__
{
    NSArray* re$ult = [self printingItems];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)dismissAnimated:(BOOL)animated;
- (void) dismissAnimated___boolean:(BOOL) animated 
{
    [self dismissAnimated:animated];
}

// direct binding of: - (BOOL)presentAnimated:(BOOL)animated completionHandler:(UIPrintInteractionCompletionHandler)completion;
- (BOOL) presentAnimated___boolean_crossmobile_ios_uikit_UIPrintInteractionCompletionHandler:(BOOL) animated :(id<crossmobile_ios_uikit_UIPrintInteractionCompletionHandler>) completion 
{
    return [self presentAnimated:animated completionHandler:(completion == JAVA_NULL ? nil : ^(UIPrintInteractionController* printInteractionController, BOOL completed, NSError* error) {
        java_lang_Boolean* completed$conv = [[java_lang_Boolean alloc] initWithBool:completed];
        [completion invoke___crossmobile_ios_uikit_UIPrintInteractionController_java_lang_Boolean_crossmobile_ios_foundation_NSError:(printInteractionController ? printInteractionController : JAVA_NULL) :completed$conv :(error ? error : JAVA_NULL)];
        [completed$conv release];
    })];
}

// direct binding of: - (BOOL)presentFromBarButtonItem:(UIBarButtonItem *)item animated:(BOOL)animated completionHandler:(UIPrintInteractionCompletionHandler)completion;
- (BOOL) presentFromBarButtonItem___crossmobile_ios_uikit_UIBarButtonItem_boolean_crossmobile_ios_uikit_UIPrintInteractionCompletionHandler:(UIBarButtonItem*) item :(BOOL) animated :(id<crossmobile_ios_uikit_UIPrintInteractionCompletionHandler>) completion 
{
    return [self presentFromBarButtonItem:(item == JAVA_NULL ? nil : item) animated:animated completionHandler:(completion == JAVA_NULL ? nil : ^(UIPrintInteractionController* printInteractionController, BOOL completed, NSError* error) {
        java_lang_Boolean* completed$conv = [[java_lang_Boolean alloc] initWithBool:completed];
        [completion invoke___crossmobile_ios_uikit_UIPrintInteractionController_java_lang_Boolean_crossmobile_ios_foundation_NSError:(printInteractionController ? printInteractionController : JAVA_NULL) :completed$conv :(error ? error : JAVA_NULL)];
        [completed$conv release];
    })];
}

// direct binding of: - (BOOL)presentFromRect:(CGRect)rect inView:(UIView *)view animated:(BOOL)animated completionHandler:(UIPrintInteractionCompletionHandler)completion;
- (BOOL) presentFromRect___crossmobile_ios_coregraphics_CGRect_crossmobile_ios_uikit_UIView_boolean_crossmobile_ios_uikit_UIPrintInteractionCompletionHandler:(crossmobile_ios_coregraphics_CGRect*) rect :(UIView*) view :(BOOL) animated :(id<crossmobile_ios_uikit_UIPrintInteractionCompletionHandler>) completion 
{
    return [self presentFromRect:[rect getCGRect] inView:(view == JAVA_NULL ? nil : view) animated:animated completionHandler:(completion == JAVA_NULL ? nil : ^(UIPrintInteractionController* printInteractionController, BOOL completed, NSError* error) {
        java_lang_Boolean* completed$conv = [[java_lang_Boolean alloc] initWithBool:completed];
        [completion invoke___crossmobile_ios_uikit_UIPrintInteractionController_java_lang_Boolean_crossmobile_ios_foundation_NSError:(printInteractionController ? printInteractionController : JAVA_NULL) :completed$conv :(error ? error : JAVA_NULL)];
        [completed$conv release];
    })];
}

@end
