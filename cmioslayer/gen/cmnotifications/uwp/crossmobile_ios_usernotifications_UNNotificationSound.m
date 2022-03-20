// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_usernotifications_UNNotificationSound implementation

#import "crossmobile_ios_usernotifications_UNNotificationSound.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_usernotifications_UNNotificationSound$Ext

@end

@implementation UNNotificationSound (cm_crossmobile_ios_usernotifications_UNNotificationSound)

// + (instancetype)defaultSound;
+ (instancetype) defaultSound__
{
    id re$ult = [UNNotificationSound defaultSound];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (instancetype)soundNamed:(NSString *)name;
+ (instancetype) soundNamed___java_lang_String:(NSString*) name 
{
    id re$ult = [UNNotificationSound soundNamed:(name == JAVA_NULL ? nil : name)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
