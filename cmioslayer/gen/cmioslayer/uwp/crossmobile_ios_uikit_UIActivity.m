// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIActivity implementation

#import "crossmobile_ios_uikit_UIActivity.h"
#import "crossmobile_ios_uikit_UIImage.h"
#import "crossmobile_ios_uikit_UIViewController.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UIActivity$Ext

// (UIActivity) @property(nonatomic, readonly) UIImage *activityImage;
- (UIImage*) activityImage__
{
    UIImage* re$ult = [super activityImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIActivity) @property(nonatomic, readonly) NSString *activityTitle;
- (NSString*) activityTitle__
{
    NSString* re$ult = [super activityTitle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIActivity) @property(nonatomic, readonly) UIActivityType activityType;
- (NSString*) activityType__
{
    NSString* re$ult = [super activityType];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIActivity) @property(nonatomic, readonly) UIViewController *activityViewController;
- (UIViewController*) activityViewController__
{
    UIViewController* re$ult = [super activityViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIActivity) - (void)activityDidFinish:(BOOL)completed;
- (void) activityDidFinish___boolean:(BOOL) completed 
{
    [super activityDidFinish:completed];
}

// (UIActivity) - (BOOL)canPerformWithActivityItems:(NSArray *)activityItems;
- (BOOL) canPerformWithActivityItems___java_util_List:(NSArray*) activityItems 
{
    return [super canPerformWithActivityItems:(activityItems == JAVA_NULL ? nil : activityItems)];
}

// (UIActivity) - (void)performActivity;
- (void) performActivity__
{
    [super performActivity];
}

// (UIActivity) - (void)prepareWithActivityItems:(NSArray *)activityItems;
- (void) prepareWithActivityItems___java_util_List:(NSArray*) activityItems 
{
    [super prepareWithActivityItems:(activityItems == JAVA_NULL ? nil : activityItems)];
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

@implementation UIActivity (cm_crossmobile_ios_uikit_UIActivity)

// direct binding of: + (UIActivityCategory)activityCategory;
+ (JAVA_LONG) activityCategory__
{
    return [UIActivity activityCategory];
}

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIActivity__
{
    return [self init];
}

// direct binding of: @property(nonatomic, readonly) UIImage *activityImage;
- (UIImage*) activityImage__
{
    UIImage* re$ult = [self activityImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) NSString *activityTitle;
- (NSString*) activityTitle__
{
    NSString* re$ult = [self activityTitle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) UIActivityType activityType;
- (NSString*) activityType__
{
    NSString* re$ult = [self activityType];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) UIViewController *activityViewController;
- (UIViewController*) activityViewController__
{
    UIViewController* re$ult = [self activityViewController];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)activityDidFinish:(BOOL)completed;
- (void) activityDidFinish___boolean:(BOOL) completed 
{
    [self activityDidFinish:completed];
}

// direct binding of: - (BOOL)canPerformWithActivityItems:(NSArray *)activityItems;
- (BOOL) canPerformWithActivityItems___java_util_List:(NSArray*) activityItems 
{
    return [self canPerformWithActivityItems:(activityItems == JAVA_NULL ? nil : activityItems)];
}

// direct binding of: - (void)performActivity;
- (void) performActivity__
{
    [self performActivity];
}

// direct binding of: - (void)prepareWithActivityItems:(NSArray *)activityItems;
- (void) prepareWithActivityItems___java_util_List:(NSArray*) activityItems 
{
    [self prepareWithActivityItems:(activityItems == JAVA_NULL ? nil : activityItems)];
}

@end
