// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_contacts_CNSaveRequest implementation

#import "crossmobile_ios_contacts_CNMutableContact.h"
#import "crossmobile_ios_contacts_CNSaveRequest.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_contacts_CNSaveRequest$Ext

@end

@implementation CNSaveRequest (cm_crossmobile_ios_contacts_CNSaveRequest)

// - (void)addContact:(CNMutableContact *)contact toContainerWithIdentifier:(NSString *)identifier;
- (void) addContact___crossmobile_ios_contacts_CNMutableContact_java_lang_String:(CNMutableContact*) contact :(NSString*) identifier 
{
    [self addContact:(contact == JAVA_NULL ? nil : contact) toContainerWithIdentifier:(identifier == JAVA_NULL ? nil : identifier)];
}

// - (void)deleteContact:(CNMutableContact *)contact;
- (void) deleteContact___crossmobile_ios_contacts_CNMutableContact:(CNMutableContact*) contact 
{
    [self deleteContact:(contact == JAVA_NULL ? nil : contact)];
}

// - (void)updateContact:(CNMutableContact *)contact;
- (void) updateContact___crossmobile_ios_contacts_CNMutableContact:(CNMutableContact*) contact 
{
    [self updateContact:(contact == JAVA_NULL ? nil : contact)];
}

@end
