// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.addressbook.ABAddressBook implementation

#import "crossmobile_ios_addressbook_ABAddressBook.h"
#import "crossmobile_ios_addressbook_ABAddressBookRequestAccessCompletionHandler.h"
#import "crossmobile_ios_addressbook_ABRecord.h"
#import "crossmobile_rt_StrongReference.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_addressbook_ABAddressBook

// direct binding of: CFStringRef ABAddressBookCopyLocalizedLabel ( CFStringRef label );
+ (NSString*) copyLocalizedLabel___java_lang_String:(NSString*) label 
{
    NSString* re$ult = ABAddressBookCopyLocalizedLabel((label == JAVA_NULL ? nil : label));
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: ABAuthorizationStatus ABAddressBookGetAuthorizationStatus(void);
+ (int) getAuthorizationStatus__
{
    return ABAddressBookGetAuthorizationStatus();
}

// direct binding of: ABAddressBookRef ABAddressBookCreateWithOptions ( CFDictionaryRef options, CFErrorRef *error );
- (crossmobile_ios_addressbook_ABAddressBook*) __init_crossmobile_ios_addressbook_ABAddressBook___java_util_Map_crossmobile_rt_StrongReference:(NSDictionary*) options :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    crossmobile_ios_addressbook_ABAddressBook* re$ult = [self initWithABAddressBook:ABAddressBookCreateWithOptions((options == JAVA_NULL ? nil : options), (error ? &error$conv : nil))];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return re$ult;
}

// direct binding of: bool ABAddressBookAddRecord ( ABAddressBookRef addressBook, ABRecordRef record, CFErrorRef *error );
- (BOOL) addRecord___crossmobile_ios_addressbook_ABRecord_crossmobile_rt_StrongReference:(crossmobile_ios_addressbook_ABRecord*) record :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    BOOL re$ult = ABAddressBookAddRecord(self->$reference, record->$reference, (error ? &error$conv : nil));
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return re$ult;
}

// direct binding of: CFArrayRef ABAddressBookCopyArrayOfAllGroups ( ABAddressBookRef addressBook );
- (NSArray*) copyArrayOfAllGroups__
{
    NSArray* re$ult = ABAddressBookCopyArrayOfAllGroups(self->$reference);
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: CFArrayRef ABAddressBookCopyArrayOfAllGroupsInSource ( ABAddressBookRef addressBook, ABRecordRef source );
- (NSArray*) copyArrayOfAllGroupsInSource___crossmobile_ios_addressbook_ABRecord:(crossmobile_ios_addressbook_ABRecord*) source 
{
    NSArray* re$ult = ABAddressBookCopyArrayOfAllGroupsInSource(self->$reference, source->$reference);
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: CFArrayRef ABAddressBookCopyArrayOfAllPeople ( ABAddressBookRef addressBook );
- (NSArray*) copyArrayOfAllPeople__
{
    NSArray* re$ult = ABAddressBookCopyArrayOfAllPeople(self->$reference);
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: CFArrayRef ABAddressBookCopyArrayOfAllPeopleInSource ( ABAddressBookRef addressBook, ABRecordRef source );
- (NSArray*) copyArrayOfAllPeopleInSource___crossmobile_ios_addressbook_ABRecord:(crossmobile_ios_addressbook_ABRecord*) source 
{
    NSArray* re$ult = ABAddressBookCopyArrayOfAllPeopleInSource(self->$reference, source->$reference);
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: CFArrayRef ABAddressBookCopyArrayOfAllPeopleInSourceWithSortOrdering ( ABAddressBookRef addressBook, ABRecordRef source, ABPersonSortOrdering sortOrdering );
- (NSArray*) copyArrayOfAllPeopleInSourceWithSortOrdering___crossmobile_ios_addressbook_ABRecord_long:(crossmobile_ios_addressbook_ABRecord*) source :(JAVA_LONG) sortOrdering 
{
    NSArray* re$ult = ABAddressBookCopyArrayOfAllPeopleInSourceWithSortOrdering(self->$reference, source->$reference, sortOrdering);
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: CFArrayRef ABAddressBookCopyArrayOfAllSources ( ABAddressBookRef addressBook );
- (NSArray*) copyArrayOfAllSources__
{
    NSArray* re$ult = ABAddressBookCopyArrayOfAllSources(self->$reference);
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: ABRecordRef ABAddressBookCopyDefaultSource(ABAddressBookRef addressBook);
- (crossmobile_ios_addressbook_ABRecord*) copyDefaultSource__
{
    return [[crossmobile_ios_addressbook_ABRecord alloc] initWithABRecord:ABAddressBookCopyDefaultSource(self->$reference)];
}

// direct binding of: CFArrayRef ABAddressBookCopyPeopleWithName ( ABAddressBookRef addressBook, CFStringRef name );
- (NSArray*) copyPeopleWithName___java_lang_String:(NSString*) name 
{
    NSArray* re$ult = ABAddressBookCopyPeopleWithName(self->$reference, (name == JAVA_NULL ? nil : name));
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: CFIndex ABAddressBookGetGroupCount(ABAddressBookRef addressBook);
- (JAVA_LONG) getGroupCount__
{
    return ABAddressBookGetGroupCount(self->$reference);
}

// direct binding of: ABRecordRef ABAddressBookGetGroupWithRecordID(ABAddressBookRef addressBook, ABRecordID recordID);
- (crossmobile_ios_addressbook_ABRecord*) getGroupWithRecordID___int:(int) recordID 
{
    return [[crossmobile_ios_addressbook_ABRecord alloc] initWithABRecord:ABAddressBookGetGroupWithRecordID(self->$reference, recordID)];
}

// direct binding of: CFIndex ABAddressBookGetPersonCount(ABAddressBookRef addressBook);
- (JAVA_LONG) getPersonCount__
{
    return ABAddressBookGetPersonCount(self->$reference);
}

// direct binding of: ABRecordRef ABAddressBookGetPersonWithRecordID(ABAddressBookRef addressBook, ABRecordID recordID);
- (crossmobile_ios_addressbook_ABRecord*) getPersonWithRecordID___int:(int) recordID 
{
    return [[crossmobile_ios_addressbook_ABRecord alloc] initWithABRecord:ABAddressBookGetPersonWithRecordID(self->$reference, recordID)];
}

// direct binding of: ABRecordRef ABAddressBookGetSourceWithRecordID(ABAddressBookRef addressBook, ABRecordID sourceID);
- (crossmobile_ios_addressbook_ABRecord*) getSourceWithRecordID___int:(int) sourceID 
{
    return [[crossmobile_ios_addressbook_ABRecord alloc] initWithABRecord:ABAddressBookGetSourceWithRecordID(self->$reference, sourceID)];
}

// direct binding of: bool ABAddressBookHasUnsavedChanges ( ABAddressBookRef addressBook );
- (BOOL) hasUnsavedChanges__
{
    return ABAddressBookHasUnsavedChanges(self->$reference);
}

// direct binding of: bool ABAddressBookRemoveRecord ( ABAddressBookRef addressBook, ABRecordRef record, CFErrorRef *error );
- (BOOL) removeRecord___crossmobile_ios_addressbook_ABRecord_crossmobile_rt_StrongReference:(crossmobile_ios_addressbook_ABRecord*) record :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    BOOL re$ult = ABAddressBookRemoveRecord(self->$reference, record->$reference, (error ? &error$conv : nil));
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return re$ult;
}

// direct binding of: void ABAddressBookRequestAccessWithCompletion ( ABAddressBookRef addressBook, ABAddressBookRequestAccessCompletionHandler completion );
- (void) requestAccessWithCompletion___crossmobile_ios_addressbook_ABAddressBookRequestAccessCompletionHandler:(id<crossmobile_ios_addressbook_ABAddressBookRequestAccessCompletionHandler>) completion 
{
    ABAddressBookRequestAccessWithCompletion(self->$reference, (completion == JAVA_NULL ? nil : ^(bool granted, CFErrorRef error) {
        java_lang_Boolean* granted$conv = [[java_lang_Boolean alloc] initWithBool:granted];
        [completion invoke___java_lang_Boolean_crossmobile_ios_foundation_NSError:granted$conv :(error ? (__bridge NSError*)error : JAVA_NULL)];
        [granted$conv release];
    }));
}

// direct binding of: void ABAddressBookRevert(ABAddressBookRef addressBook);
- (void) revert__
{
    ABAddressBookRevert(self->$reference);
}

// direct binding of: bool ABAddressBookSave(ABAddressBookRef addressBook, CFErrorRef *error);
- (BOOL) save___crossmobile_rt_StrongReference:(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    BOOL re$ult = ABAddressBookSave(self->$reference, (error ? &error$conv : nil));
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return re$ult;
}

- (instancetype) initWithABAddressBook:(ABAddressBookRef) reference
{
    self = [super initWithCFType:reference];
    return self;
}

@end
