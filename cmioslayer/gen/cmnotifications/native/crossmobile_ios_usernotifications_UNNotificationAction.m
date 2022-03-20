// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_usernotifications_UNNotificationAction implementation

#import "crossmobile_ios_usernotifications_UNNotificationAction.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_usernotifications_UNNotificationAction$Ext

@end

@implementation UNNotificationAction (cm_crossmobile_ios_usernotifications_UNNotificationAction)

// + (instancetype)actionWithIdentifier:(NSString *)identifier title:(NSString *)title options:(UNNotificationActionOptions)options;
+ (instancetype) actionWithIdentifier___java_lang_String_java_lang_String_long:(NSString*) identifier :(NSString*) title :(JAVA_LONG) options 
{
    id re$ult = [UNNotificationAction actionWithIdentifier:(identifier == JAVA_NULL ? nil : identifier) title:(title == JAVA_NULL ? nil : title) options:options];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(copy, readonly, nonatomic) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [self identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, nonatomic) UNNotificationActionOptions options;
- (JAVA_LONG) options__
{
    return [self options];
}

// @property(copy, readonly, nonatomic) NSString *title;
- (NSString*) title__
{
    NSString* re$ult = [self title];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
