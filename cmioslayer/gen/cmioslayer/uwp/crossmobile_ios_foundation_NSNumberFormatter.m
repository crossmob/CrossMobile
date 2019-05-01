// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSNumberFormatter implementation

#import "crossmobile_ios_foundation_NSNumberFormatter.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_foundation_NSNumberFormatter$Ext

// (NSNumberFormatter) @property NSUInteger maximumFractionDigits;
- (void) setMaximumFractionDigits___int:(int) maximumFractionDigits 
{
    [super setMaximumFractionDigits:maximumFractionDigits];
}

// (NSNumberFormatter) @property NSUInteger maximumFractionDigits;
- (int) maximumFractionDigits__
{
    return [super maximumFractionDigits];
}

// (NSNumberFormatter) @property NSNumberFormatterStyle numberStyle;
- (void) setNumberStyle___int:(int) numberStyle 
{
    [super setNumberStyle:numberStyle];
}

// (NSNumberFormatter) @property NSNumberFormatterStyle numberStyle;
- (int) numberStyle__
{
    return [super numberStyle];
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

@implementation NSNumberFormatter (cm_crossmobile_ios_foundation_NSNumberFormatter)

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_foundation_NSNumberFormatter__
{
    return [self init];
}

// direct binding of: @property NSUInteger maximumFractionDigits;
- (void) setMaximumFractionDigits___int:(int) maximumFractionDigits 
{
    [self setMaximumFractionDigits:maximumFractionDigits];
}

// direct binding of: @property NSUInteger maximumFractionDigits;
- (int) maximumFractionDigits__
{
    return [self maximumFractionDigits];
}

// direct binding of: @property NSNumberFormatterStyle numberStyle;
- (void) setNumberStyle___int:(int) numberStyle 
{
    [self setNumberStyle:numberStyle];
}

// direct binding of: @property NSNumberFormatterStyle numberStyle;
- (int) numberStyle__
{
    return [self numberStyle];
}

@end
