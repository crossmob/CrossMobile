// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_usernotifications_UNNotificationResponse implementation

#import "crossmobile_ios_usernotifications_UNNotification.h"
#import "crossmobile_ios_usernotifications_UNNotificationResponse.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_usernotifications_UNNotificationResponse$Ext

@end

@implementation UNNotificationResponse (cm_crossmobile_ios_usernotifications_UNNotificationResponse)

// @property(readonly, copy, nonatomic) NSString *actionIdentifier;
- (NSString*) actionIdentifier__
{
    NSString* re$ult = [self actionIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) UNNotification *notification;
- (UNNotification*) notification__
{
    UNNotification* re$ult = [self notification];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
