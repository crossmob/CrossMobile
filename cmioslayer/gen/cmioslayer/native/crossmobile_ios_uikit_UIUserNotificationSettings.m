// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIUserNotificationSettings implementation

#import "crossmobile_ios_uikit_UIUserNotificationSettings.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Set.h"

@implementation crossmobile_ios_uikit_UIUserNotificationSettings$Ext

// (UIUserNotificationSettings) @property(nonatomic, copy, readonly) NSSet<UIUserNotificationCategory *> *categories;
- (NSSet*) categories__
{
    NSSet* re$ult = [super categories];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIUserNotificationSettings) @property(nonatomic, readonly) UIUserNotificationType types;
- (int) types__
{
    return [super types];
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

@implementation UIUserNotificationSettings (cm_crossmobile_ios_uikit_UIUserNotificationSettings)

// direct binding of: + (instancetype)settingsForTypes:(UIUserNotificationType)types categories:(NSSet<UIUserNotificationCategory *> *)categories;
+ (instancetype) settingsForTypes___int_java_util_Set:(int) types :(NSSet*) categories 
{
    id re$ult = [UIUserNotificationSettings settingsForTypes:types categories:(categories == JAVA_NULL ? nil : categories)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, copy, readonly) NSSet<UIUserNotificationCategory *> *categories;
- (NSSet*) categories__
{
    NSSet* re$ult = [self categories];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) UIUserNotificationType types;
- (int) types__
{
    return [self types];
}

@end
