// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.usernotifications.UNNotificationSound definition

#import "xmlvm.h"
#import <UserNotifications/UserNotifications.h>
@class java_lang_String;

@interface crossmobile_ios_usernotifications_UNNotificationSound$Ext : UNNotificationSound
@end

#define crossmobile_ios_usernotifications_UNNotificationSound UNNotificationSound
@interface UNNotificationSound (cm_crossmobile_ios_usernotifications_UNNotificationSound)
+ (instancetype) defaultSound__;
+ (instancetype) soundNamed___java_lang_String:(NSString*) name ;
@end
