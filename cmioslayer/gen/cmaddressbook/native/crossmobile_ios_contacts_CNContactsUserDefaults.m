// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_contacts_CNContactsUserDefaults implementation

#import "crossmobile_ios_contacts_CNContactsUserDefaults.h"

@implementation crossmobile_ios_contacts_CNContactsUserDefaults$Ext

@end

@implementation CNContactsUserDefaults (cm_crossmobile_ios_contacts_CNContactsUserDefaults)

// + (instancetype)sharedDefaults;
+ (instancetype) sharedDefaults__
{
    id re$ult = [CNContactsUserDefaults sharedDefaults];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
