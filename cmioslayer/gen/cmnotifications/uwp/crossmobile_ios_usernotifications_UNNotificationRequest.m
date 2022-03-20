// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_usernotifications_UNNotificationRequest implementation

#import "crossmobile_ios_usernotifications_UNNotificationContent.h"
#import "crossmobile_ios_usernotifications_UNNotificationRequest.h"
#import "crossmobile_ios_usernotifications_UNNotificationTrigger.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_usernotifications_UNNotificationRequest$Ext

@end

@implementation UNNotificationRequest (cm_crossmobile_ios_usernotifications_UNNotificationRequest)

// + (instancetype)requestWithIdentifier:(NSString *)identifier content:(UNNotificationContent *)content trigger:(UNNotificationTrigger *)trigger;
+ (instancetype) requestWithIdentifier___java_lang_String_crossmobile_ios_usernotifications_UNNotificationContent_crossmobile_ios_usernotifications_UNNotificationTrigger:(NSString*) identifier :(UNNotificationContent*) content :(UNNotificationTrigger*) trigger 
{
    id re$ult = [UNNotificationRequest requestWithIdentifier:(identifier == JAVA_NULL ? nil : identifier) content:(content == JAVA_NULL ? nil : content) trigger:(trigger == JAVA_NULL ? nil : trigger)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) UNNotificationContent *content;
- (UNNotificationContent*) content__
{
    UNNotificationContent* re$ult = [self content];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [self identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) UNNotificationTrigger *trigger;
- (UNNotificationTrigger*) trigger__
{
    UNNotificationTrigger* re$ult = [self trigger];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
