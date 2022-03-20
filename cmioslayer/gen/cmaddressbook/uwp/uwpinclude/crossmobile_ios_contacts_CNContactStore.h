// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_contacts_CNContactStore definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class crossmobile_ios_contacts_CNContact;
@class crossmobile_ios_contacts_CNSaveRequest;
@class crossmobile_ios_foundation_NSError;
@class crossmobile_ios_foundation_NSPredicate;
@class crossmobile_rt_StrongReference;
@class java_lang_Boolean;
@class java_lang_String;
@protocol java_util_List;
@protocol org_robovm_objc_block_VoidBlock2;

CM_EXPORT_CLASS
@interface crossmobile_ios_contacts_CNContactStore$Ext : CNContactStore
@end

#define crossmobile_ios_contacts_CNContactStore CNContactStore
@interface CNContactStore (cm_crossmobile_ios_contacts_CNContactStore)
+ (int) authorizationStatusForEntityType___int:(int) entityType ;
- (instancetype) __init_crossmobile_ios_contacts_CNContactStore__;
- (NSArray*) containersMatchingPredicate___crossmobile_ios_foundation_NSPredicate_crossmobile_rt_StrongReference:(NSPredicate*) predicate :(crossmobile_rt_StrongReference*) error ;
- (NSString*) defaultContainerIdentifier__;
- (BOOL) executeSaveRequest___crossmobile_ios_contacts_CNSaveRequest_crossmobile_rt_StrongReference:(CNSaveRequest*) saveRequest :(crossmobile_rt_StrongReference*) error ;
- (NSArray*) groupsMatchingPredicate___crossmobile_ios_foundation_NSPredicate_crossmobile_rt_StrongReference:(NSPredicate*) predicate :(crossmobile_rt_StrongReference*) error ;
- (void) requestAccessForEntityType___int_org_robovm_objc_block_VoidBlock2:(int) entityType :(id<org_robovm_objc_block_VoidBlock2>) completionHandler ;
- (CNContact*) unifiedContactWithIdentifier___java_lang_String_java_util_List_crossmobile_rt_StrongReference:(NSString*) identifier :(NSArray*) keys :(crossmobile_rt_StrongReference*) error ;
- (NSArray*) unifiedContactsMatchingPredicate___crossmobile_ios_foundation_NSPredicate_java_util_List_crossmobile_rt_StrongReference:(NSPredicate*) predicate :(NSArray*) keys :(crossmobile_rt_StrongReference*) error ;
@end
