//
//  java_lang_Number.m
//  cmioslayer
//
//

#import "java_lang_Number.h"

#define INIT_NSNUMBER \
self = [super init]; if (self) { self.cmnumber = @(value); } return self;

@implementation java_lang_Number

- (instancetype) initWithNumber:(NSNumber*) number
{
    self = [super init];
    self.cmnumber = number;
    return self;
}

- (instancetype) __init_java_lang_Number__
{
    return [self initWithNumber:0];
}

- (const char*) objCType
{
    return [self.cmnumber objCType];
}

- (void)getValue:(void *)value
{
    return [self.cmnumber getValue:value];
}

- (id)initWithChar:(char)value
{
    INIT_NSNUMBER
}

- (id)initWithUnsignedChar:(unsigned char)value
{
    INIT_NSNUMBER
}

- (id)initWithShort:(short)value
{
    INIT_NSNUMBER
}

- (id)initWithUnsignedShort:(unsigned short)value
{
    INIT_NSNUMBER
}

- (id)initWithInt:(int)value
{
    INIT_NSNUMBER
}

- (id)initWithUnsignedInt:(unsigned int)value
{
    INIT_NSNUMBER
}

- (id)initWithLong:(long)value
{
    INIT_NSNUMBER
}

- (id)initWithUnsignedLong:(unsigned long)value
{
    INIT_NSNUMBER
}

- (id)initWithLongLong:(long long)value
{
    INIT_NSNUMBER
}

- (id)initWithUnsignedLongLong:(unsigned long long)value
{
    INIT_NSNUMBER
}

- (id)initWithFloat:(float)value
{
    INIT_NSNUMBER
}

- (id)initWithDouble:(double)value
{
    INIT_NSNUMBER
}

- (id)initWithBool:(BOOL)value
{
    INIT_NSNUMBER
}

- (id)initWithInteger:(NSInteger)value
{
    INIT_NSNUMBER
}

- (id)initWithUnsignedInteger:(NSUInteger)value
{
    INIT_NSNUMBER
}

- (char) charValue
{
    return [self.cmnumber charValue];
}

- (unsigned char) unsignedCharValue
{
    return [self.cmnumber unsignedCharValue];
}

- (short) shortValue
{
    return [self.cmnumber shortValue];
}

- (unsigned short) unsignedShortValue
{
    return [self.cmnumber unsignedShortValue];
}

- (int) intValue
{
    return [self.cmnumber intValue];
}

- (unsigned int) unsignedIntValue
{
    return [self.cmnumber unsignedIntValue];
}

- (long) longValue
{
    return [self.cmnumber longValue];
}

- (unsigned long) unsignedLongValue
{
    return [self.cmnumber unsignedLongValue];
}

- (long long) longLongValue
{
    return [self.cmnumber longLongValue];
}

- (unsigned long long) unsignedLongLongValue
{
    return [self.cmnumber unsignedLongLongValue];
}

- (float) floatValue
{
    return [self.cmnumber floatValue];
}

- (double) doubleValue
{
    return [self.cmnumber doubleValue];
}

- (BOOL) boolValue
{
    return [self.cmnumber boolValue];
}

- (NSInteger) integerValue
{
    return [self.cmnumber integerValue];
}

- (NSUInteger) unsignedIntegerValue
{
    return [self.cmnumber unsignedIntegerValue];
}

@end

@implementation NSNumber (cm_number)

- (char) byteValue__
{
    return [self charValue];
}

- (short) shortValue__
{
    return [self shortValue];
}

- (int) intValue__
{
    return (int)[self integerValue];
}

- (JAVA_LONG) longValue__
{
    return [self longLongValue];
}

- (float) floatValue__
{
    return [self floatValue];
}

- (double) doubleValue__
{
    return [self doubleValue];
}

- (BOOL) booleanValue__
{
    return [self boolValue];
}

- (unichar) charValue__ {
    return [self unsignedShortValue];
}

- (java_lang_String*) toString__
{
    return [[self stringValue] retain];
}

@end
