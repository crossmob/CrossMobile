// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.usernotifications.UNNotificationCategory definition

#import "xmlvm.h"
#import <UserNotifications/UserNotifications.h>
@class java_lang_String;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_usernotifications_UNNotificationCategory$Ext : UNNotificationCategory
@end

#define crossmobile_ios_usernotifications_UNNotificationCategory UNNotificationCategory
@interface UNNotificationCategory (cm_crossmobile_ios_usernotifications_UNNotificationCategory)
+ (instancetype) categoryWithIdentifier___java_lang_String_java_util_List_java_util_List_long:(NSString*) identifier :(NSArray*) actions :(NSArray*) intentIdentifiers :(JAVA_LONG) options ;
- (NSArray*) actions__;
- (NSString*) identifier__;
- (NSArray*) intentIdentifiers__;
- (JAVA_LONG) options__;
@end
