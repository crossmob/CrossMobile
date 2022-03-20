// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_addressbook_ABUnknownPersonViewController implementation

#import "crossmobile_ios_addressbook_ABAddressBook.h"
#import "crossmobile_ios_addressbook_ABRecord.h"
#import "crossmobile_ios_addressbook_ABUnknownPersonViewController.h"
#import "crossmobile_ios_addressbook_ABUnknownPersonViewControllerDelegate.h"
#import "java_lang_String.h"

@implementation ABUnknownPersonViewController (cm_crossmobile_ios_addressbook_ABUnknownPersonViewController)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_addressbook_ABUnknownPersonViewController__
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

// @property(nonatomic) BOOL allowsAddingToAddressBook;
- (void) setAllowsAddingToAddressBook___boolean:(BOOL) allowsAddingToAddressBook 
{
    [self setAllowsAddingToAddressBook:allowsAddingToAddressBook];
}

// @property(nonatomic) BOOL allowsAddingToAddressBook;
- (BOOL) allowsAddingToAddressBook__
{
    return [self allowsAddingToAddressBook];
}

// @property(nonatomic, copy) NSString *alternateName;
- (void) setAlternateName___java_lang_String:(NSString*) alternateName 
{
    [self setAlternateName:(alternateName == JAVA_NULL ? nil : alternateName)];
}

// @property(nonatomic, copy) NSString *alternateName;
- (NSString*) alternateName__
{
    NSString* re$ult = [self alternateName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

// @property(nonatomic, copy) NSString *message;
- (void) setMessage___java_lang_String:(NSString*) message 
{
    [self setMessage:(message == JAVA_NULL ? nil : message)];
}

// @property(nonatomic, copy) NSString *message;
- (NSString*) message__
{
    NSString* re$ult = [self message];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, assign) id< ABUnknownPersonViewControllerDelegate > unknownPersonViewDelegate ;
- (void) setUnknownPersonViewDelegate___crossmobile_ios_addressbook_ABUnknownPersonViewControllerDelegate:(id<ABUnknownPersonViewControllerDelegate>) unknownPersonViewDelegate 
{
    objc_setAssociatedObject(self, @selector(setUnknownPersonViewDelegate:), unknownPersonViewDelegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setUnknownPersonViewDelegate:(unknownPersonViewDelegate == JAVA_NULL ? nil : unknownPersonViewDelegate)];
}

// @property(nonatomic, assign) id< ABUnknownPersonViewControllerDelegate > unknownPersonViewDelegate ;
- (id<ABUnknownPersonViewControllerDelegate>) unknownPersonViewDelegate__
{
    id<ABUnknownPersonViewControllerDelegate> re$ult = [self unknownPersonViewDelegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
