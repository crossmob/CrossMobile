// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_addressbook_ABRecord implementation

#import "crossmobile_ios_addressbook_ABRecord.h"
#import "crossmobile_rt_StrongReference.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_addressbook_ABRecord

// CFStringRef ABRecordCopyCompositeName ( ABRecordRef record );
- (NSString*) copyCompositeName__
{
    NSString* re$ult = ABRecordCopyCompositeName(self->$reference);
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// CFTypeRef ABRecordCopyValue ( ABRecordRef record, ABPropertyID property );
- (crossmobile_ios_foundation_CFType*) copyValue___int:(int) property 
{
    return [[crossmobile_ios_foundation_CFType alloc] initWithCFType:ABRecordCopyValue(self->$reference, property)];
}

// ABRecordID ABRecordGetRecordID ( ABRecordRef record );
- (int) getRecordID__
{
    return ABRecordGetRecordID(self->$reference);
}

// ABRecordType ABRecordGetRecordType ( ABRecordRef record );
- (int) getRecordType__
{
    return ABRecordGetRecordType(self->$reference);
}

// bool ABRecordRemoveValue ( ABRecordRef record, ABPropertyID property, CFErrorRef *error );
- (BOOL) removeValue___int_crossmobile_rt_StrongReference:(int) property :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    BOOL re$ult = ABRecordRemoveValue(self->$reference, property, (error ? &error$conv : nil));
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return re$ult;
}

// bool ABRecordSetValue ( ABRecordRef record, ABPropertyID property, CFTypeRef value, CFErrorRef *error );
- (BOOL) setValue___int_crossmobile_ios_foundation_CFType_crossmobile_rt_StrongReference:(int) property :(crossmobile_ios_foundation_CFType*) value :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    BOOL re$ult = ABRecordSetValue(self->$reference, property, value->$reference, (error ? &error$conv : nil));
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return re$ult;
}

- (instancetype) initWithABRecord:(ABRecordRef) reference
{
    self = [super initWithCFType:reference];
    return self;
}

@end
