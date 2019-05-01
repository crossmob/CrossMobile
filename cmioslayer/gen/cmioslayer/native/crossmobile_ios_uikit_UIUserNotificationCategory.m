// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIUserNotificationCategory implementation

#import "crossmobile_ios_uikit_UIUserNotificationCategory.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UIUserNotificationCategory$Ext

// (UIUserNotificationCategory) @property(nonatomic, copy, readonly) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [super identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIUserNotificationCategory) - (NSArray<UIUserNotificationAction *> *)actionsForContext:(UIUserNotificationActionContext)context;
- (NSArray*) actionsForContext___int:(int) context 
{
    NSArray* re$ult = [super actionsForContext:context];
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

@implementation UIUserNotificationCategory (cm_crossmobile_ios_uikit_UIUserNotificationCategory)

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIUserNotificationCategory__
{
    return [self init];
}

// direct binding of: @property(nonatomic, copy, readonly) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [self identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (NSArray<UIUserNotificationAction *> *)actionsForContext:(UIUserNotificationActionContext)context;
- (NSArray*) actionsForContext___int:(int) context 
{
    NSArray* re$ult = [self actionsForContext:context];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
