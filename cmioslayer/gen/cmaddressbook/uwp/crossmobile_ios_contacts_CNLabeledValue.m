// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_contacts_CNLabeledValue implementation

#import "crossmobile_ios_contacts_CNLabeledValue.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_contacts_CNLabeledValue$Ext

@end

@implementation CNLabeledValue (cm_crossmobile_ios_contacts_CNLabeledValue)

// + (NSString *)localizedStringForLabel:(NSString *)label;
+ (NSString*) localizedStringForLabel___java_lang_String:(NSString*) label 
{
    NSString* re$ult = [CNLabeledValue localizedStringForLabel:(label == JAVA_NULL ? nil : label)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (instancetype)initWithLabel:(NSString *)label value:(ValueType)value;
- (instancetype) __init_crossmobile_ios_contacts_CNLabeledValue___java_lang_String_java_lang_Object:(NSString*) label :(id) value 
{
    return [self initWithLabel:(label == JAVA_NULL ? nil : label) value:(value == JAVA_NULL ? nil : value)];
}

// @property(readonly, copy, nonatomic) NSString *label;
- (NSString*) label__
{
    NSString* re$ult = [self label];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) ValueType value;
- (id) value__
{
    id re$ult = [self value];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (instancetype)labeledValueBySettingLabel:(NSString *)label;
- (instancetype) labeledValueBySettingLabel___java_lang_String:(NSString*) label 
{
    id re$ult = [self labeledValueBySettingLabel:(label == JAVA_NULL ? nil : label)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
