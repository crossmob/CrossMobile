// (c) 2020 under LGPL by CrossMobile plugin tools

// crossmobile_ios_usernotifications_UNNotificationSound definition

#import "xmlvm.h"
#import <UIKit/UIKit.h>
#import <UserNotifications/UserNotifications.h>
@class java_lang_String;

@interface crossmobile_ios_usernotifications_UNNotificationSound$Ext : UNNotificationSound
@end

#define crossmobile_ios_usernotifications_UNNotificationSound UNNotificationSound
@interface UNNotificationSound (cm_crossmobile_ios_usernotifications_UNNotificationSound)
+ (instancetype) defaultSound__;
+ (instancetype) soundNamed___java_lang_String:(NSString*) name ;
@end
