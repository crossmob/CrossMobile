// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_addressbook_ABAddressBook definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
#import "crossmobile_ios_foundation_CFType.h"
@protocol crossmobile_ios_addressbook_ABAddressBookRequestAccessCompletionHandler;
@class crossmobile_ios_addressbook_ABRecord;
@class crossmobile_rt_StrongReference;
@class java_lang_Object;
@class java_lang_String;
@protocol java_util_List;
@protocol java_util_Map;

@interface crossmobile_ios_addressbook_ABAddressBook : crossmobile_ios_foundation_CFType
+ (NSString*) copyLocalizedLabel___java_lang_String:(NSString*) label ;
+ (int) getAuthorizationStatus__;
- (crossmobile_ios_addressbook_ABAddressBook*) __init_crossmobile_ios_addressbook_ABAddressBook___java_util_Map_crossmobile_rt_StrongReference:(NSDictionary*) options :(crossmobile_rt_StrongReference*) error ;
- (BOOL) addRecord___crossmobile_ios_addressbook_ABRecord_crossmobile_rt_StrongReference:(crossmobile_ios_addressbook_ABRecord*) record :(crossmobile_rt_StrongReference*) error ;
- (NSArray*) copyArrayOfAllGroups__;
- (NSArray*) copyArrayOfAllGroupsInSource___crossmobile_ios_addressbook_ABRecord:(crossmobile_ios_addressbook_ABRecord*) source ;
- (NSArray*) copyArrayOfAllPeople__;
- (NSArray*) copyArrayOfAllPeopleInSource___crossmobile_ios_addressbook_ABRecord:(crossmobile_ios_addressbook_ABRecord*) source ;
- (NSArray*) copyArrayOfAllPeopleInSourceWithSortOrdering___crossmobile_ios_addressbook_ABRecord_long:(crossmobile_ios_addressbook_ABRecord*) source :(JAVA_LONG) sortOrdering ;
- (NSArray*) copyArrayOfAllSources__;
- (crossmobile_ios_addressbook_ABRecord*) copyDefaultSource__;
- (NSArray*) copyPeopleWithName___java_lang_String:(NSString*) name ;
- (JAVA_LONG) getGroupCount__;
- (crossmobile_ios_addressbook_ABRecord*) getGroupWithRecordID___int:(int) recordID ;
- (JAVA_LONG) getPersonCount__;
- (crossmobile_ios_addressbook_ABRecord*) getPersonWithRecordID___int:(int) recordID ;
- (crossmobile_ios_addressbook_ABRecord*) getSourceWithRecordID___int:(int) sourceID ;
- (BOOL) hasUnsavedChanges__;
- (BOOL) removeRecord___crossmobile_ios_addressbook_ABRecord_crossmobile_rt_StrongReference:(crossmobile_ios_addressbook_ABRecord*) record :(crossmobile_rt_StrongReference*) error ;
- (void) requestAccessWithCompletion___crossmobile_ios_addressbook_ABAddressBookRequestAccessCompletionHandler:(id<crossmobile_ios_addressbook_ABAddressBookRequestAccessCompletionHandler>) completion ;
- (void) revert__;
- (BOOL) save___crossmobile_rt_StrongReference:(crossmobile_rt_StrongReference*) error ;
- (instancetype) initWithABAddressBook:(ABAddressBookRef) reference;
@end
