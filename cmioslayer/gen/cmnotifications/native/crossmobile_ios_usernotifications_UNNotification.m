// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_usernotifications_UNNotification implementation

#import "crossmobile_ios_foundation_NSDate.h"
#import "crossmobile_ios_usernotifications_UNNotification.h"
#import "crossmobile_ios_usernotifications_UNNotificationRequest.h"

@implementation crossmobile_ios_usernotifications_UNNotification$Ext

@end

@implementation UNNotification (cm_crossmobile_ios_usernotifications_UNNotification)

// @property(nonatomic, readonly, copy) NSDate *date;
- (NSDate*) date__
{
    NSDate* re$ult = [self date];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, copy) UNNotificationRequest *request;
- (UNNotificationRequest*) request__
{
    UNNotificationRequest* re$ult = [self request];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
