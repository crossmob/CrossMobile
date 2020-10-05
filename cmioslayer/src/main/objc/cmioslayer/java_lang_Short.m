/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_lang_Short.h"

@interface PrimitiveShort : java_lang_Object
@end

@implementation PrimitiveShort
@end

static PrimitiveShort* primitiveShort;
static java_lang_Class* primitiveShortClass;


// java.lang.Short
//----------------------------------------------------------------------------
@implementation java_lang_Short


+ (void) initialize
{
	primitiveShort = [[PrimitiveShort alloc] init];
	primitiveShortClass = [primitiveShort getClass__];
}

+ (java_lang_Class*) _GET_TYPE
{
	return primitiveShortClass;
}

- (id) copyWithZone:(NSZone *)zone
{
    return [[[self class] allocWithZone:zone] __init_java_lang_Short___short:[self shortValue]];
}

- (instancetype) __init_java_lang_Short___short :(short) s
{
    return [self initWithShort:s];
}

+ (short) parseShort___java_lang_String: (java_lang_String *) str
{
	return (short) atol([str UTF8String]);
}

+ (short) parseShort___java_lang_String_int: (java_lang_String*) str :(int) radix
{
    return (short) strtoul([str UTF8String], nil, radix);
}

+ (java_lang_Short*) valueOf___short: (short) s
{
    return [[java_lang_Short alloc] __init_java_lang_Short___short:s];
}

- (int) equals___java_lang_Object: (java_lang_Object*) o
{
    if ([self class] != [o class])
        return false;
    return [self unbox] == [o unbox];
}

- (short) unbox
{
    return [self shortValue];
}

@end
