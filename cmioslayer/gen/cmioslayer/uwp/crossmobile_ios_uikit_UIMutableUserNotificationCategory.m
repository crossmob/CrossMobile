// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIMutableUserNotificationCategory implementation

#import "crossmobile_ios_uikit_UIMutableUserNotificationCategory.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UIMutableUserNotificationCategory$Ext

// (UIMutableUserNotificationCategory) @property(nonatomic, copy) NSString *identifier;
- (void) setIdentifier___java_lang_String:(NSString*) identifier 
{
    [super setIdentifier:(identifier == JAVA_NULL ? nil : identifier)];
}

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

// (UIMutableUserNotificationCategory) - (void)setActions:(NSArray<UIUserNotificationAction *> *)actions forContext:(UIUserNotificationActionContext)context;
- (void) setActions___java_util_List_int:(NSArray*) actions :(int) context 
{
    [super setActions:(actions == JAVA_NULL ? nil : actions) forContext:context];
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

@implementation UIMutableUserNotificationCategory (cm_crossmobile_ios_uikit_UIMutableUserNotificationCategory)

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIMutableUserNotificationCategory__
{
    return [self init];
}

// direct binding of: @property(nonatomic, copy) NSString *identifier;
- (void) setIdentifier___java_lang_String:(NSString*) identifier 
{
    [self setIdentifier:(identifier == JAVA_NULL ? nil : identifier)];
}

// direct binding of: - (void)setActions:(NSArray<UIUserNotificationAction *> *)actions forContext:(UIUserNotificationActionContext)context;
- (void) setActions___java_util_List_int:(NSArray*) actions :(int) context 
{
    [self setActions:(actions == JAVA_NULL ? nil : actions) forContext:context];
}

@end
