// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.addressbook.ABUnknownPersonViewControllerDelegate definition

#import "xmlvm.h"
#import <Accounts/Accounts.h>
#import <AddressBook/AddressBook.h>
#import <AddressBookUI/AddressBookUI.h>
#import <Contacts/Contacts.h>
@class crossmobile_ios_addressbook_ABRecord;
@class crossmobile_ios_addressbook_ABUnknownPersonViewController;

@protocol crossmobile_ios_addressbook_ABUnknownPersonViewControllerDelegate
- (void) didResolveToPerson___crossmobile_ios_addressbook_ABUnknownPersonViewController_crossmobile_ios_addressbook_ABRecord:(ABUnknownPersonViewController*) unknownCardViewController :(crossmobile_ios_addressbook_ABRecord*) person ;
- (BOOL) shouldPerformDefaultActionForPerson___crossmobile_ios_addressbook_ABUnknownPersonViewController_crossmobile_ios_addressbook_ABRecord_int_int:(ABUnknownPersonViewController*) personViewController :(crossmobile_ios_addressbook_ABRecord*) person :(int) property :(int) identifier ;
@end
