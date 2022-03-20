// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_contacts_CNContactStore implementation

#import "crossmobile_ios_contacts_CNContact.h"
#import "crossmobile_ios_contacts_CNContactStore.h"
#import "crossmobile_ios_contacts_CNSaveRequest.h"
#import "crossmobile_ios_foundation_NSError.h"
#import "crossmobile_ios_foundation_NSPredicate.h"
#import "crossmobile_rt_StrongReference.h"
#import "java_lang_Boolean.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "org_robovm_objc_block_VoidBlock2.h"

@implementation crossmobile_ios_contacts_CNContactStore$Ext

@end

@implementation CNContactStore (cm_crossmobile_ios_contacts_CNContactStore)

// + (CNAuthorizationStatus)authorizationStatusForEntityType:(CNEntityType)entityType;
+ (int) authorizationStatusForEntityType___int:(int) entityType 
{
    return [CNContactStore authorizationStatusForEntityType:entityType];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_contacts_CNContactStore__
{
    return [self init];
}

// - (NSArray<CNContainer *> *)containersMatchingPredicate:(NSPredicate *)predicate error:(NSError * _Nullable *)error;
- (NSArray*) containersMatchingPredicate___crossmobile_ios_foundation_NSPredicate_crossmobile_rt_StrongReference:(NSPredicate*) predicate :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    NSArray* re$ult = [self containersMatchingPredicate:(predicate == JAVA_NULL ? nil : predicate) error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSString *)defaultContainerIdentifier;
- (NSString*) defaultContainerIdentifier__
{
    NSString* re$ult = [self defaultContainerIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (BOOL)executeSaveRequest:(CNSaveRequest *)saveRequest error:(NSError * _Nullable *)error;
- (BOOL) executeSaveRequest___crossmobile_ios_contacts_CNSaveRequest_crossmobile_rt_StrongReference:(CNSaveRequest*) saveRequest :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    BOOL re$ult = [self executeSaveRequest:(saveRequest == JAVA_NULL ? nil : saveRequest) error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return re$ult;
}

// - (NSArray<CNGroup *> *)groupsMatchingPredicate:(NSPredicate *)predicate error:(NSError * _Nullable *)error;
- (NSArray*) groupsMatchingPredicate___crossmobile_ios_foundation_NSPredicate_crossmobile_rt_StrongReference:(NSPredicate*) predicate :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    NSArray* re$ult = [self groupsMatchingPredicate:(predicate == JAVA_NULL ? nil : predicate) error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)requestAccessForEntityType:(CNEntityType)entityType completionHandler:(void (^)(BOOL granted, NSError *error))completionHandler;
- (void) requestAccessForEntityType___int_org_robovm_objc_block_VoidBlock2:(int) entityType :(id<org_robovm_objc_block_VoidBlock2>) completionHandler 
{
    [self requestAccessForEntityType:entityType completionHandler:(completionHandler == JAVA_NULL ? nil : ^(BOOL granted, NSError* error) {
        java_lang_Boolean* granted$conv = [[java_lang_Boolean alloc] initWithBool:granted];
        [completionHandler invoke___java_lang_Object_java_lang_Object:granted$conv :(error ? error : JAVA_NULL)];
        [granted$conv release];
    })];
}

// - (CNContact *)unifiedContactWithIdentifier:(NSString *)identifier keysToFetch:(NSArray<id<CNKeyDescriptor>> *)keys error:(NSError * _Nullable *)error;
- (CNContact*) unifiedContactWithIdentifier___java_lang_String_java_util_List_crossmobile_rt_StrongReference:(NSString*) identifier :(NSArray*) keys :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    CNContact* re$ult = [self unifiedContactWithIdentifier:(identifier == JAVA_NULL ? nil : identifier) keysToFetch:(keys == JAVA_NULL ? nil : keys) error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSArray<CNContact *> *)unifiedContactsMatchingPredicate:(NSPredicate *)predicate keysToFetch:(NSArray<id<CNKeyDescriptor>> *)keys error:(NSError * _Nullable *)error;
- (NSArray*) unifiedContactsMatchingPredicate___crossmobile_ios_foundation_NSPredicate_java_util_List_crossmobile_rt_StrongReference:(NSPredicate*) predicate :(NSArray*) keys :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    NSArray* re$ult = [self unifiedContactsMatchingPredicate:(predicate == JAVA_NULL ? nil : predicate) keysToFetch:(keys == JAVA_NULL ? nil : keys) error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
