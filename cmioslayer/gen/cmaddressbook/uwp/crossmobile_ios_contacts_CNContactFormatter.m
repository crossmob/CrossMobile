// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_contacts_CNContactFormatter implementation

#import "crossmobile_ios_contacts_CNContact.h"
#import "crossmobile_ios_contacts_CNContactFormatter.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_contacts_CNContactFormatter$Ext

@end

@implementation CNContactFormatter (cm_crossmobile_ios_contacts_CNContactFormatter)

// + (NSString *)stringFromContact:(CNContact *)contact style:(CNContactFormatterStyle)style;
+ (NSString*) stringFromContact___crossmobile_ios_contacts_CNContact_int:(CNContact*) contact :(int) style 
{
    NSString* re$ult = [CNContactFormatter stringFromContact:(contact == JAVA_NULL ? nil : contact) style:style];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_contacts_CNContactFormatter__
{
    return [self init];
}

@end
