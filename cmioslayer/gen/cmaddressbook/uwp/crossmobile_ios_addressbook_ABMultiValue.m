// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_addressbook_ABMultiValue implementation

#import "crossmobile_ios_addressbook_ABMultiValue.h"
#import "crossmobile_ios_addressbook_ABMutableMultiValue.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_addressbook_ABMultiValue

// CFArrayRef ABMultiValueCopyArrayOfAllValues ( ABMultiValueRef multiValue );
- (NSArray*) copyArrayOfAllValues__
{
    NSArray* re$ult = ABMultiValueCopyArrayOfAllValues(self->$reference);
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// CFStringRef ABMultiValueCopyLabelAtIndex ( ABMultiValueRef multiValue, CFIndex index );
- (NSString*) copyLabelAtIndex___long:(JAVA_LONG) index 
{
    NSString* re$ult = ABMultiValueCopyLabelAtIndex(self->$reference, index);
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// CFTypeRef ABMultiValueCopyValueAtIndex ( ABMultiValueRef multiValue, CFIndex index );
- (crossmobile_ios_foundation_CFType*) copyValueAtIndex___long:(JAVA_LONG) index 
{
    return [[crossmobile_ios_foundation_CFType alloc] initWithCFType:ABMultiValueCopyValueAtIndex(self->$reference, index)];
}

// ABMutableMultiValueRef ABMultiValueCreateMutableCopy(ABMultiValueRef multiValue);
- (crossmobile_ios_addressbook_ABMutableMultiValue*) createMutableCopy__
{
    return [[crossmobile_ios_addressbook_ABMutableMultiValue alloc] initWithABMutableMultiValue:ABMultiValueCreateMutableCopy(self->$reference)];
}

// CFIndex ABMultiValueGetCount ( ABMultiValueRef multiValue );
- (JAVA_LONG) getCount__
{
    return ABMultiValueGetCount(self->$reference);
}

// CFIndex ABMultiValueGetFirstIndexOfValue ( ABMultiValueRef multiValue, CFTypeRef value );
- (JAVA_LONG) getFirstIndexOfValue___crossmobile_ios_foundation_CFType:(crossmobile_ios_foundation_CFType*) value 
{
    return ABMultiValueGetFirstIndexOfValue(self->$reference, value->$reference);
}

// ABMultiValueIdentifier ABMultiValueGetIdentifierAtIndex ( ABMultiValueRef multiValue, CFIndex index );
- (int) getIdentifierAtIndex___long:(JAVA_LONG) index 
{
    return ABMultiValueGetIdentifierAtIndex(self->$reference, index);
}

// CFIndex ABMultiValueGetIndexForIdentifier ( ABMultiValueRef multiValue, ABMultiValueIdentifier identifier );
- (JAVA_LONG) getIndexForIdentifier___int:(int) identifier 
{
    return ABMultiValueGetIndexForIdentifier(self->$reference, identifier);
}

// ABPropertyType ABMultiValueGetPropertyType ( ABMultiValueRef multiValue );
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
