// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.addressbook.ABMutableMultiValue implementation

#import "crossmobile_ios_addressbook_ABMutableMultiValue.h"
#import "crossmobile_ios_foundation_CFType.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_addressbook_ABMutableMultiValue

// direct binding of: ABMutableMultiValueRef ABMultiValueCreateMutable ( ABPropertyType type );
- (crossmobile_ios_addressbook_ABMutableMultiValue*) __init_crossmobile_ios_addressbook_ABMutableMultiValue___int:(int) type 
{
    return [self initWithABMutableMultiValue:ABMultiValueCreateMutable(type)];
}

// direct binding of: bool ABMultiValueAddValueAndLabel ( ABMutableMultiValueRef multiValue, CFTypeRef value, CFStringRef label, ABMultiValueIdentifier *outIdentifier );
- (BOOL) addValueAndLabel___crossmobile_ios_foundation_CFType_java_lang_String_int_ARRAYTYPE:(crossmobile_ios_foundation_CFType*) value :(NSString*) label :(XMLVMArray*) outIdentifier 
{
    return ABMultiValueAddValueAndLabel(self->$reference, value->$reference, (label == JAVA_NULL ? nil : label), (outIdentifier == JAVA_NULL ? NULL : outIdentifier->array.data));
}

// direct binding of: bool ABMultiValueInsertValueAndLabelAtIndex ( ABMutableMultiValueRef multiValue, CFTypeRef value, CFStringRef label, CFIndex index, ABMultiValueIdentifier *outIdentifier );
- (BOOL) insertValueAndLabelAtIndex___crossmobile_ios_foundation_CFType_java_lang_String_long_int_ARRAYTYPE:(crossmobile_ios_foundation_CFType*) value :(NSString*) label :(JAVA_LONG) index :(XMLVMArray*) outIdentifier 
{
    return ABMultiValueInsertValueAndLabelAtIndex(self->$reference, value->$reference, (label == JAVA_NULL ? nil : label), index, (outIdentifier == JAVA_NULL ? NULL : outIdentifier->array.data));
}

// direct binding of: bool ABMultiValueRemoveValueAndLabelAtIndex ( ABMutableMultiValueRef multiValue, CFIndex index );
- (BOOL) removeValueAndLabelAtIndex___long:(JAVA_LONG) index 
{
    return ABMultiValueRemoveValueAndLabelAtIndex(self->$reference, index);
}

// direct binding of: bool ABMultiValueReplaceLabelAtIndex ( ABMutableMultiValueRef multiValue, CFStringRef label, CFIndex index );
- (BOOL) replaceLabelAtIndex___java_lang_String_long:(NSString*) label :(JAVA_LONG) index 
{
    return ABMultiValueReplaceLabelAtIndex(self->$reference, (label == JAVA_NULL ? nil : label), index);
}

// direct binding of: bool ABMultiValueReplaceValueAtIndex ( ABMutableMultiValueRef multiValue, CFTypeRef value, CFIndex index );
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
