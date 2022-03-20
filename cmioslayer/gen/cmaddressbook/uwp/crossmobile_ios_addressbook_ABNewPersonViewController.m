// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_addressbook_ABNewPersonViewController implementation

#import "crossmobile_ios_addressbook_ABAddressBook.h"
#import "crossmobile_ios_addressbook_ABNewPersonViewController.h"
#import "crossmobile_ios_addressbook_ABNewPersonViewControllerDelegate.h"
#import "crossmobile_ios_addressbook_ABRecord.h"

@implementation crossmobile_ios_addressbook_ABNewPersonViewController$Ext

@end

@implementation ABNewPersonViewController (cm_crossmobile_ios_addressbook_ABNewPersonViewController)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_addressbook_ABNewPersonViewController__
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

// @property(nonatomic, readwrite) ABRecordRef displayedPerson;
- (void) setDisplayedPerson___crossmobile_ios_addressbook_ABRecord:(crossmobile_ios_addressbook_ABRecord*) displayedPerson 
{
    [self setDisplayedPerson:displayedPerson->$reference];
}

// @property(nonatomic, readwrite) ABRecordRef displayedPerson;
- (crossmobile_ios_addressbook_ABRecord*) displayedPerson__
{
    return [[crossmobile_ios_addressbook_ABRecord alloc] initWithABRecord:[self displayedPerson]];
}

// @property(nonatomic, assign) id< ABNewPersonViewControllerDelegate > newPersonViewDelegate ;
- (void) setNewPersonViewDelegate___crossmobile_ios_addressbook_ABNewPersonViewControllerDelegate:(id<ABNewPersonViewControllerDelegate>) newPersonViewDelegate 
{
    objc_setAssociatedObject(self, @selector(setNewPersonViewDelegate:), newPersonViewDelegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setNewPersonViewDelegate:(newPersonViewDelegate == JAVA_NULL ? nil : newPersonViewDelegate)];
}

// @property(nonatomic, assign) id< ABNewPersonViewControllerDelegate > newPersonViewDelegate ;
- (id<ABNewPersonViewControllerDelegate>) newPersonViewDelegate__
{
    id<ABNewPersonViewControllerDelegate> re$ult = [self newPersonViewDelegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readwrite) ABRecordRef parentGroup;
- (void) setParentGroup___crossmobile_ios_addressbook_ABRecord:(crossmobile_ios_addressbook_ABRecord*) parentGroup 
{
    [self setParentGroup:parentGroup->$reference];
}

// @property(nonatomic, readwrite) ABRecordRef parentGroup;
- (crossmobile_ios_addressbook_ABRecord*) parentGroup__
{
    return [[crossmobile_ios_addressbook_ABRecord alloc] initWithABRecord:[self parentGroup]];
}

@end
