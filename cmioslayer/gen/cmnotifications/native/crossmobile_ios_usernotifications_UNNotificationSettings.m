// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.usernotifications.UNNotificationSettings implementation

#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_usernotifications_UNNotificationSettings.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

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

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (NSObject) - (void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary<NSKeyValueChangeKey, id> *)change context:(void *)context;
- (void) observeValueForKeyPath___java_lang_String_java_lang_Object_java_util_Map_java_lang_Object:(NSString*) keyPath :(id) object :(NSDictionary*) change :(id) context 
{
    [super observeValueForKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) ofObject:(object == JAVA_NULL ? nil : object) change:(change == JAVA_NULL ? nil : change) context:(context == JAVA_NULL ? nil : context)];
}

// (NSObject) - (void)removeObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String:(NSObject*) observer :(NSString*) keyPath 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath)];
}

// (NSObject) - (void)removeObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath context:(void *)context;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(id) context 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) context:(context == JAVA_NULL ? nil : context)];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValueForKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (void)setValue:(id)value forUndefinedKey:(NSString *)key;
- (void) setValueForUndefinedKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forUndefinedKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (id)valueForUndefinedKey:(NSString *)key;
- (id) valueForUndefinedKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForUndefinedKey:(key == JAVA_NULL ? nil : key)];
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
