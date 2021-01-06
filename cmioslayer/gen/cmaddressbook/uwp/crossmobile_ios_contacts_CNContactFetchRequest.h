// (c) 2021 under LGPL by CrossMobile plugin tools

// crossmobile_ios_contacts_CNContactFetchRequest definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@protocol java_util_List;

@interface crossmobile_ios_contacts_CNContactFetchRequest$Ext : CNContactFetchRequest
@end

#define crossmobile_ios_contacts_CNContactFetchRequest CNContactFetchRequest
@interface CNContactFetchRequest (cm_crossmobile_ios_contacts_CNContactFetchRequest)
- (instancetype) __init_crossmobile_ios_contacts_CNContactFetchRequest___java_util_List:(NSArray*) keysToFetch ;
- (void) setKeysToFetch___java_util_List:(NSArray*) keysToFetch ;
- (NSArray*) keysToFetch__;
- (void) setMutableObjects___boolean:(BOOL) mutableObjects ;
- (BOOL) mutableObjects__;
- (void) setSortOrder___int:(int) sortOrder ;
- (int) sortOrder__;
- (void) setUnifyResults___boolean:(BOOL) unifyResults ;
- (BOOL) unifyResults__;
@end
