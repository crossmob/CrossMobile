// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.addressbook.ABMultiValue implementation

#import "crossmobile_ios_addressbook_ABMultiValue.h"
#import "crossmobile_ios_addressbook_ABMutableMultiValue.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_addressbook_ABMultiValue

// direct binding of: CFArrayRef ABMultiValueCopyArrayOfAllValues ( ABMultiValueRef multiValue );
- (NSArray*) copyArrayOfAllValues__
{
    NSArray* re$ult = ABMultiValueCopyArrayOfAllValues(self->$reference);
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: CFStringRef ABMultiValueCopyLabelAtIndex ( ABMultiValueRef multiValue, CFIndex index );
- (NSString*) copyLabelAtIndex___long:(JAVA_LONG) index 
{
    NSString* re$ult = ABMultiValueCopyLabelAtIndex(self->$reference, index);
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: CFTypeRef ABMultiValueCopyValueAtIndex ( ABMultiValueRef multiValue, CFIndex index );
- (crossmobile_ios_foundation_CFType*) copyValueAtIndex___long:(JAVA_LONG) index 
{
    return [[crossmobile_ios_foundation_CFType alloc] initWithCFType:ABMultiValueCopyValueAtIndex(self->$reference, index)];
}

// direct binding of: ABMutableMultiValueRef ABMultiValueCreateMutableCopy(ABMultiValueRef multiValue);
- (crossmobile_ios_addressbook_ABMutableMultiValue*) createMutableCopy__
{
    return [[crossmobile_ios_addressbook_ABMutableMultiValue alloc] initWithABMutableMultiValue:ABMultiValueCreateMutableCopy(self->$reference)];
}

// direct binding of: CFIndex ABMultiValueGetCount ( ABMultiValueRef multiValue );
- (JAVA_LONG) getCount__
{
    return ABMultiValueGetCount(self->$reference);
}

// direct binding of: CFIndex ABMultiValueGetFirstIndexOfValue ( ABMultiValueRef multiValue, CFTypeRef value );
- (JAVA_LONG) getFirstIndexOfValue___crossmobile_ios_foundation_CFType:(crossmobile_ios_foundation_CFType*) value 
{
    return ABMultiValueGetFirstIndexOfValue(self->$reference, value->$reference);
}

// direct binding of: ABMultiValueIdentifier ABMultiValueGetIdentifierAtIndex ( ABMultiValueRef multiValue, CFIndex index );
- (int) getIdentifierAtIndex___long:(JAVA_LONG) index 
{
    return ABMultiValueGetIdentifierAtIndex(self->$reference, index);
}

// direct binding of: CFIndex ABMultiValueGetIndexForIdentifier ( ABMultiValueRef multiValue, ABMultiValueIdentifier identifier );
- (JAVA_LONG) getIndexForIdentifier___int:(int) identifier 
{
    return ABMultiValueGetIndexForIdentifier(self->$reference, identifier);
}

// direct binding of: ABPropertyType ABMultiValueGetPropertyType ( ABMultiValueRef multiValue );
- (int) getPropertyType__
{
    return ABMultiValueGetPropertyType(self->$reference);
}

- (instancetype) initWithABMultiValue:(ABMultiValueRef) reference
{
    self = [super initWithCFType:reference];
    return self;
}

@end
