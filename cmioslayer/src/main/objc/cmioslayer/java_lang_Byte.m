/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_lang_Byte.h"

@implementation java_lang_Byte : java_lang_Number

- (instancetype) __init_java_lang_Byte___byte :(char) b
{
    return [self initWithChar:b];
}

+ (char) parseByte___java_lang_String: (java_lang_String *) str
{
	return (char) atoi([str UTF8String]);
}

+ (char) parseByte___java_lang_String_int: (java_lang_String*) str :(int) radix
{
    return (char) strtol([str UTF8String], nil, radix);
}

+ (java_lang_String*) toString___byte: (char) b
{
    return [[[NSNumber numberWithInt:b] stringValue] retain];
}

+ (java_lang_Byte*) valueOf___byte: (char) c
{
    return [[java_lang_Byte alloc] initWithChar:c];
}

- (int) equals___java_lang_Object: (java_lang_Object*) o
{
    if ([self class] != [o class])
        return false;
    return [self unbox] == [o unbox];
}

- (char) unbox
{
    return [self charValue];
}

@end
