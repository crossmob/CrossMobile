// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_usernotifications_UNNotificationCategory implementation

#import "crossmobile_ios_usernotifications_UNNotificationCategory.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_usernotifications_UNNotificationCategory$Ext

@end

@implementation UNNotificationCategory (cm_crossmobile_ios_usernotifications_UNNotificationCategory)

// + (instancetype)categoryWithIdentifier:(NSString *)identifier actions:(NSArray<UNNotificationAction *> *)actions intentIdentifiers:(NSArray<NSString *> *)intentIdentifiers options:(UNNotificationCategoryOptions)options;
+ (instancetype) categoryWithIdentifier___java_lang_String_java_util_List_java_util_List_long:(NSString*) identifier :(NSArray*) actions :(NSArray*) intentIdentifiers :(JAVA_LONG) options 
{
    id re$ult = [UNNotificationCategory categoryWithIdentifier:(identifier == JAVA_NULL ? nil : identifier) actions:(actions == JAVA_NULL ? nil : actions) intentIdentifiers:(intentIdentifiers == JAVA_NULL ? nil : intentIdentifiers) options:options];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSArray<UNNotificationAction *> *actions;
- (NSArray*) actions__
{
    NSArray* re$ult = [self actions];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [self identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSArray<NSString *> *intentIdentifiers;
- (NSArray*) intentIdentifiers__
{
    NSArray* re$ult = [self intentIdentifiers];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, nonatomic) UNNotificationCategoryOptions options;
- (JAVA_LONG) options__
{
    return [self options];
}

@end
