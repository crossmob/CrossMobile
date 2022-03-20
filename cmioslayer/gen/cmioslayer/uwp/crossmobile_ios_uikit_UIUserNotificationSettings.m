// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIUserNotificationSettings implementation

#import "crossmobile_ios_uikit_UIUserNotificationSettings.h"
#import "java_util_Set.h"

@implementation crossmobile_ios_uikit_UIUserNotificationSettings$Ext

@end

@implementation UIUserNotificationSettings (cm_crossmobile_ios_uikit_UIUserNotificationSettings)

// + (instancetype)settingsForTypes:(UIUserNotificationType)types categories:(NSSet<UIUserNotificationCategory *> *)categories;
+ (instancetype) settingsForTypes___int_java_util_Set:(int) types :(NSSet*) categories 
{
    id re$ult = [UIUserNotificationSettings settingsForTypes:types categories:(categories == JAVA_NULL ? nil : categories)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy, readonly) NSSet<UIUserNotificationCategory *> *categories;
- (NSSet*) categories__
{
    NSSet* re$ult = [self categories];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) UIUserNotificationType types;
- (int) types__
{
    return [self types];
}

@end
