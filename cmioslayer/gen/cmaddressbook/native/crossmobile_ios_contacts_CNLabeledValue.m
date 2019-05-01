// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.contacts.CNLabeledValue implementation

#import "crossmobile_ios_contacts_CNLabeledValue.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_contacts_CNLabeledValue$Ext

// (CNLabeledValue) @property(readonly, copy, nonatomic) NSString *label;
- (NSString*) label__
{
    NSString* re$ult = [super label];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNLabeledValue) @property(readonly, copy, nonatomic) ValueType value;
- (id) value__
{
    id re$ult = [super value];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CNLabeledValue) - (instancetype)labeledValueBySettingLabel:(NSString *)label;
- (instancetype) labeledValueBySettingLabel___java_lang_String:(NSString*) label 
{
    id re$ult = [super labeledValueBySettingLabel:(label == JAVA_NULL ? nil : label)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation CNLabeledValue (cm_crossmobile_ios_contacts_CNLabeledValue)

// direct binding of: + (NSString *)localizedStringForLabel:(NSString *)label;
+ (NSString*) localizedStringForLabel___java_lang_String:(NSString*) label 
{
    NSString* re$ult = [CNLabeledValue localizedStringForLabel:(label == JAVA_NULL ? nil : label)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (instancetype)initWithLabel:(NSString *)label value:(ValueType)value;
- (instancetype) __init_crossmobile_ios_contacts_CNLabeledValue___java_lang_String_java_lang_Object:(NSString*) label :(id) value 
{
    return [self initWithLabel:(label == JAVA_NULL ? nil : label) value:(value == JAVA_NULL ? nil : value)];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *label;
- (NSString*) label__
{
    NSString* re$ult = [self label];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) ValueType value;
- (id) value__
{
    id re$ult = [self value];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (instancetype)labeledValueBySettingLabel:(NSString *)label;
- (instancetype) labeledValueBySettingLabel___java_lang_String:(NSString*) label 
{
    id re$ult = [self labeledValueBySettingLabel:(label == JAVA_NULL ? nil : label)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
