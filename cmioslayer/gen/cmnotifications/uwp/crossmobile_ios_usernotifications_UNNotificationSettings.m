// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.usernotifications.UNNotificationSettings implementation

#import "crossmobile_ios_usernotifications_UNNotificationSettings.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_usernotifications_UNNotificationSettings$Ext

// (UNNotificationSettings) @property(readonly, nonatomic) UNNotificationSetting alertSetting;
- (JAVA_LONG) alertSetting__
{
    return [super alertSetting];
}

// (UNNotificationSettings) @property(readonly, nonatomic) UNAlertStyle alertStyle;
- (int) alertStyle__
{
    return [super alertStyle];
}

// (UNNotificationSettings) @property(readonly, nonatomic) UNAuthorizationStatus authorizationStatus;
- (int) authorizationStatus__
{
    return [super authorizationStatus];
}

// (UNNotificationSettings) @property(readonly, nonatomic) UNNotificationSetting badgeSetting;
- (JAVA_LONG) badgeSetting__
{
    return [super badgeSetting];
}

// (UNNotificationSettings) @property(readonly, nonatomic) UNNotificationSetting carPlaySetting;
- (JAVA_LONG) carPlaySetting__
{
    return [super carPlaySetting];
}

// (UNNotificationSettings) @property(readonly, nonatomic) UNNotificationSetting lockScreenSetting;
- (JAVA_LONG) lockScreenSetting__
{
    return [super lockScreenSetting];
}

// (UNNotificationSettings) @property(readonly, nonatomic) UNNotificationSetting notificationCenterSetting;
- (JAVA_LONG) notificationCenterSetting__
{
    return [super notificationCenterSetting];
}

// (UNNotificationSettings) @property(readonly, nonatomic) UNNotificationSetting soundSetting;
- (JAVA_LONG) soundSetting__
{
    return [super soundSetting];
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

@implementation UNNotificationSettings (cm_crossmobile_ios_usernotifications_UNNotificationSettings)

// direct binding of: @property(readonly, nonatomic) UNNotificationSetting alertSetting;
- (JAVA_LONG) alertSetting__
{
    return [self alertSetting];
}

// direct binding of: @property(readonly, nonatomic) UNAlertStyle alertStyle;
- (int) alertStyle__
{
    return [self alertStyle];
}

// direct binding of: @property(readonly, nonatomic) UNAuthorizationStatus authorizationStatus;
- (int) authorizationStatus__
{
    return [self authorizationStatus];
}

// direct binding of: @property(readonly, nonatomic) UNNotificationSetting badgeSetting;
- (JAVA_LONG) badgeSetting__
{
    return [self badgeSetting];
}

// direct binding of: @property(readonly, nonatomic) UNNotificationSetting carPlaySetting;
- (JAVA_LONG) carPlaySetting__
{
    return [self carPlaySetting];
}

// direct binding of: @property(readonly, nonatomic) UNNotificationSetting lockScreenSetting;
- (JAVA_LONG) lockScreenSetting__
{
    return [self lockScreenSetting];
}

// direct binding of: @property(readonly, nonatomic) UNNotificationSetting notificationCenterSetting;
- (JAVA_LONG) notificationCenterSetting__
{
    return [self notificationCenterSetting];
}

// direct binding of: @property(readonly, nonatomic) UNNotificationSetting soundSetting;
- (JAVA_LONG) soundSetting__
{
    return [self soundSetting];
}

@end
