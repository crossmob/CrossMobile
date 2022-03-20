// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_addressbook_ABPersonViewController implementation

#import "crossmobile_ios_addressbook_ABAddressBook.h"
#import "crossmobile_ios_addressbook_ABPersonViewController.h"
#import "crossmobile_ios_addressbook_ABPersonViewControllerDelegate.h"
#import "crossmobile_ios_addressbook_ABRecord.h"
#import "java_util_List.h"

@implementation crossmobile_ios_addressbook_ABPersonViewController$Ext

@end

@implementation ABPersonViewController (cm_crossmobile_ios_addressbook_ABPersonViewController)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_addressbook_ABPersonViewController__
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

// @property(nonatomic) BOOL allowsActions;
- (void) setAllowsActions___boolean:(BOOL) allowsActions 
{
    [self setAllowsActions:allowsActions];
}

// @property(nonatomic) BOOL allowsActions;
- (BOOL) allowsActions__
{
    return [self allowsActions];
}

// @property(nonatomic) BOOL allowsEditing;
- (void) setAllowsEditing___boolean:(BOOL) allowsEditing 
{
    [self setAllowsEditing:allowsEditing];
}

// @property(nonatomic) BOOL allowsEditing;
- (BOOL) allowsEditing__
{
    return [self allowsEditing];
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

// @property(nonatomic, assign) id<ABPersonViewControllerDelegate> personViewDelegate;
- (void) setPersonViewDelegate___crossmobile_ios_addressbook_ABPersonViewControllerDelegate:(id<ABPersonViewControllerDelegate>) personViewDelegate 
{
    objc_setAssociatedObject(self, @selector(setPersonViewDelegate:), personViewDelegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setPersonViewDelegate:(personViewDelegate == JAVA_NULL ? nil : personViewDelegate)];
}

// @property(nonatomic, assign) id<ABPersonViewControllerDelegate> personViewDelegate;
- (id<ABPersonViewControllerDelegate>) personViewDelegate__
{
    id<ABPersonViewControllerDelegate> re$ult = [self personViewDelegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) BOOL shouldShowLinkedPeople;
- (void) setShouldShowLinkedPeople___boolean:(BOOL) shouldShowLinkedPeople 
{
    [self setShouldShowLinkedPeople:shouldShowLinkedPeople];
}

// @property(nonatomic) BOOL shouldShowLinkedPeople;
- (BOOL) shouldShowLinkedPeople__
{
    return [self shouldShowLinkedPeople];
}

// - (void)setHighlightedItemForProperty:(ABPropertyID)property withIdentifier:(ABMultiValueIdentifier)identifier;
- (void) setHighlightedItemForProperty___int_int:(int) property :(int) identifier 
{
    [self setHighlightedItemForProperty:property withIdentifier:identifier];
}

@end
