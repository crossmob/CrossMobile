// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_addressbook_ABPeoplePickerNavigationController implementation

#import "crossmobile_ios_addressbook_ABAddressBook.h"
#import "crossmobile_ios_addressbook_ABPeoplePickerNavigationController.h"
#import "crossmobile_ios_addressbook_ABPeoplePickerNavigationControllerDelegate.h"
#import "java_util_List.h"

@implementation crossmobile_ios_addressbook_ABPeoplePickerNavigationController$Ext

@end

@implementation ABPeoplePickerNavigationController (cm_crossmobile_ios_addressbook_ABPeoplePickerNavigationController)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_addressbook_ABPeoplePickerNavigationController__
{
    return [self init];
}

// @property(nonatomic, readwrite) ABAddressBookRef addressBook;
- (void) setAddressBook___crossmobile_ios_addressbook_ABAddressBook:(crossmobile_ios_addressbook_ABAddressBook*) addressBook 
{
    [self setAddressBook:addressBook->$reference];
}

// @property(nonatomic, readwrite) ABAddressBookRef addressBook;
- (crossmobile_ios_addressbook_ABAddressBook*) addressBook__
{
    return [[crossmobile_ios_addressbook_ABAddressBook alloc] initWithABAddressBook:[self addressBook]];
}

// @property(nonatomic, copy) NSArray<NSNumber *> *displayedProperties;
- (void) setDisplayedProperties___java_util_List:(NSArray*) displayedProperties 
{
    [self setDisplayedProperties:(displayedProperties == JAVA_NULL ? nil : displayedProperties)];
}

// @property(nonatomic, copy) NSArray<NSNumber *> *displayedProperties;
- (NSArray*) displayedProperties__
{
    NSArray* re$ult = [self displayedProperties];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, assign) id<ABPeoplePickerNavigationControllerDelegate> peoplePickerDelegate;
- (void) setPeoplePickerDelegate___crossmobile_ios_addressbook_ABPeoplePickerNavigationControllerDelegate:(id<ABPeoplePickerNavigationControllerDelegate>) peoplePickerDelegate 
{
    objc_setAssociatedObject(self, @selector(setPeoplePickerDelegate:), peoplePickerDelegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setPeoplePickerDelegate:(peoplePickerDelegate == JAVA_NULL ? nil : peoplePickerDelegate)];
}

// @property(nonatomic, assign) id<ABPeoplePickerNavigationControllerDelegate> peoplePickerDelegate;
- (id<ABPeoplePickerNavigationControllerDelegate>) peoplePickerDelegate__
{
    id<ABPeoplePickerNavigationControllerDelegate> re$ult = [self peoplePickerDelegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
