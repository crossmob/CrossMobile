// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.addressbook.ABUnknownPersonViewController implementation

#import "crossmobile_ios_addressbook_ABAddressBook.h"
#import "crossmobile_ios_addressbook_ABRecord.h"
#import "crossmobile_ios_addressbook_ABUnknownPersonViewController.h"
#import "crossmobile_ios_addressbook_ABUnknownPersonViewControllerDelegate.h"
#import "crossmobile_ios_coregraphics_CGSize.h"
#import "crossmobile_ios_foundation_NSExtensionContext.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_uikit_UIBarButtonItem.h"
#import "crossmobile_ios_uikit_UIEdgeInsets.h"
#import "crossmobile_ios_uikit_UIEvent.h"
#import "crossmobile_ios_uikit_UILayoutSupport.h"
#import "crossmobile_ios_uikit_UINavigationController.h"
#import "crossmobile_ios_uikit_UINavigationItem.h"
#import "crossmobile_ios_uikit_UIResponder.h"
#import "crossmobile_ios_uikit_UISplitViewController.h"
#import "crossmobile_ios_uikit_UIStoryboard.h"
#import "crossmobile_ios_uikit_UIStoryboardSegue.h"
#import "crossmobile_ios_uikit_UIStoryboardUnwindSegueSource.h"
#import "crossmobile_ios_uikit_UITabBarController.h"
#import "crossmobile_ios_uikit_UITabBarItem.h"
#import "crossmobile_ios_uikit_UIView.h"
#import "crossmobile_ios_uikit_UIViewController.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"
#import "java_util_Set.h"

@implementation ABUnknownPersonViewController (cm_crossmobile_ios_addressbook_ABUnknownPersonViewController)

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_addressbook_ABUnknownPersonViewController__
{
    return [self init];
}

// direct binding of: @property(nonatomic, readwrite) ABAddressBookRef addressBook;
- (void) setAddressBook___crossmobile_ios_addressbook_ABAddressBook:(crossmobile_ios_addressbook_ABAddressBook*) addressBook 
{
    [self setAddressBook:addressBook->$reference];
}

// direct binding of: @property(nonatomic, readwrite) ABAddressBookRef addressBook;
- (crossmobile_ios_addressbook_ABAddressBook*) addressBook__
{
    return [[crossmobile_ios_addressbook_ABAddressBook alloc] initWithABAddressBook:[self addressBook]];
}

// direct binding of: @property(nonatomic) BOOL allowsActions;
- (void) setAllowsActions___boolean:(BOOL) allowsActions 
{
    [self setAllowsActions:allowsActions];
}

// direct binding of: @property(nonatomic) BOOL allowsActions;
- (BOOL) allowsActions__
{
    return [self allowsActions];
}

// direct binding of: @property(nonatomic) BOOL allowsAddingToAddressBook;
- (void) setAllowsAddingToAddressBook___boolean:(BOOL) allowsAddingToAddressBook 
{
    [self setAllowsAddingToAddressBook:allowsAddingToAddressBook];
}

// direct binding of: @property(nonatomic) BOOL allowsAddingToAddressBook;
- (BOOL) allowsAddingToAddressBook__
{
    return [self allowsAddingToAddressBook];
}

// direct binding of: @property(nonatomic, copy) NSString *alternateName;
- (void) setAlternateName___java_lang_String:(NSString*) alternateName 
{
    [self setAlternateName:(alternateName == JAVA_NULL ? nil : alternateName)];
}

// direct binding of: @property(nonatomic, copy) NSString *alternateName;
- (NSString*) alternateName__
{
    NSString* re$ult = [self alternateName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readwrite) ABRecordRef displayedPerson;
- (void) setDisplayedPerson___crossmobile_ios_addressbook_ABRecord:(crossmobile_ios_addressbook_ABRecord*) displayedPerson 
{
    [self setDisplayedPerson:displayedPerson->$reference];
}

// direct binding of: @property(nonatomic, readwrite) ABRecordRef displayedPerson;
- (crossmobile_ios_addressbook_ABRecord*) displayedPerson__
{
    return [[crossmobile_ios_addressbook_ABRecord alloc] initWithABRecord:[self displayedPerson]];
}

// direct binding of: @property(nonatomic, copy) NSString *message;
- (void) setMessage___java_lang_String:(NSString*) message 
{
    [self setMessage:(message == JAVA_NULL ? nil : message)];
}

// direct binding of: @property(nonatomic, copy) NSString *message;
- (NSString*) message__
{
    NSString* re$ult = [self message];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, assign) id< ABUnknownPersonViewControllerDelegate > unknownPersonViewDelegate ;
- (void) setUnknownPersonViewDelegate___crossmobile_ios_addressbook_ABUnknownPersonViewControllerDelegate:(id<ABUnknownPersonViewControllerDelegate>) unknownPersonViewDelegate 
{
    objc_setAssociatedObject(self, @selector(setUnknownPersonViewDelegate:), unknownPersonViewDelegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setUnknownPersonViewDelegate:(unknownPersonViewDelegate == JAVA_NULL ? nil : unknownPersonViewDelegate)];
}

// direct binding of: @property(nonatomic, assign) id< ABUnknownPersonViewControllerDelegate > unknownPersonViewDelegate ;
- (id<ABUnknownPersonViewControllerDelegate>) unknownPersonViewDelegate__
{
    id<ABUnknownPersonViewControllerDelegate> re$ult = [self unknownPersonViewDelegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
