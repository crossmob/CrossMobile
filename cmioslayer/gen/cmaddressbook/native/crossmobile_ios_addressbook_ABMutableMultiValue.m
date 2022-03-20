// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_addressbook_ABMutableMultiValue implementation

#import "crossmobile_ios_addressbook_ABMutableMultiValue.h"
#import "crossmobile_ios_foundation_CFType.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_addressbook_ABMutableMultiValue

// ABMutableMultiValueRef ABMultiValueCreateMutable ( ABPropertyType type );
- (crossmobile_ios_addressbook_ABMutableMultiValue*) __init_crossmobile_ios_addressbook_ABMutableMultiValue___int:(int) type 
{
    return [self initWithABMutableMultiValue:ABMultiValueCreateMutable(type)];
}

// bool ABMultiValueAddValueAndLabel ( ABMutableMultiValueRef multiValue, CFTypeRef value, CFStringRef label, ABMultiValueIdentifier *outIdentifier );
- (BOOL) addValueAndLabel___crossmobile_ios_foundation_CFType_java_lang_String_int_ARRAYTYPE:(crossmobile_ios_foundation_CFType*) value :(NSString*) label :(XMLVMArray*) outIdentifier 
{
    return ABMultiValueAddValueAndLabel(self->$reference, value->$reference, (label == JAVA_NULL ? nil : label), (outIdentifier == JAVA_NULL ? NULL : outIdentifier->array.data));
}

// bool ABMultiValueInsertValueAndLabelAtIndex ( ABMutableMultiValueRef multiValue, CFTypeRef value, CFStringRef label, CFIndex index, ABMultiValueIdentifier *outIdentifier );
- (BOOL) insertValueAndLabelAtIndex___crossmobile_ios_foundation_CFType_java_lang_String_long_int_ARRAYTYPE:(crossmobile_ios_foundation_CFType*) value :(NSString*) label :(JAVA_LONG) index :(XMLVMArray*) outIdentifier 
{
    return ABMultiValueInsertValueAndLabelAtIndex(self->$reference, value->$reference, (label == JAVA_NULL ? nil : label), index, (outIdentifier == JAVA_NULL ? NULL : outIdentifier->array.data));
}

// bool ABMultiValueRemoveValueAndLabelAtIndex ( ABMutableMultiValueRef multiValue, CFIndex index );
- (BOOL) removeValueAndLabelAtIndex___long:(JAVA_LONG) index 
{
    return ABMultiValueRemoveValueAndLabelAtIndex(self->$reference, index);
}

// bool ABMultiValueReplaceLabelAtIndex ( ABMutableMultiValueRef multiValue, CFStringRef label, CFIndex index );
- (BOOL) replaceLabelAtIndex___java_lang_String_long:(NSString*) label :(JAVA_LONG) index 
{
    return ABMultiValueReplaceLabelAtIndex(self->$reference, (label == JAVA_NULL ? nil : label), index);
}

// bool ABMultiValueReplaceValueAtIndex ( ABMutableMultiValueRef multiValue, CFTypeRef value, CFIndex index );
- (BOOL) replaceValueAtIndex___crossmobile_ios_foundation_CFType_long:(crossmobile_ios_foundation_CFType*) value :(JAVA_LONG) index 
{
    return ABMultiValueReplaceValueAtIndex(self->$reference, value->$reference, index);
}

- (instancetype) initWithABMutableMultiValue:(ABMutableMultiValueRef) reference
{
    self = [super initWithABMultiValue:reference];
    return self;
}

@end
