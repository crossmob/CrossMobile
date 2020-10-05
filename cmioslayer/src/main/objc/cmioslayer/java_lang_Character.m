/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_lang_Character.h"

// java.lang.Character
//----------------------------------------------------------------------------
@implementation java_lang_Character

+ (java_lang_String*) toString___char: (unichar) c
{
    return [[NSString alloc] initWithFormat:@"%C", c];
}

+ (java_lang_Character*) valueOf___char: (unichar) c
{
    return [[java_lang_Character alloc] __init_java_lang_Character___char:c];
}

+ (BOOL) isUpperCase___char:(unichar) c
{
    return [[NSCharacterSet uppercaseLetterCharacterSet] characterIsMember:c];
}

+ (BOOL) isUpperCase___int:(int) c
{
    return [[NSCharacterSet uppercaseLetterCharacterSet] characterIsMember:c];
}

+ (BOOL) isLowerCase___char:(unichar) c
{
    return [[NSCharacterSet lowercaseLetterCharacterSet] characterIsMember:c];
}

+ (BOOL) isLowerCase___int:(int) c
{
    return [[NSCharacterSet lowercaseLetterCharacterSet] characterIsMember:c];
}

+ (BOOL) isLetter___char:(unichar)c
{
    return [[NSCharacterSet letterCharacterSet] characterIsMember: c];
}

+ (BOOL) isLetter___int:(int)c
{
    return [[NSCharacterSet letterCharacterSet] characterIsMember: c];
}

+ (BOOL) isDigit___char:(unichar)c
{
    return [[NSCharacterSet decimalDigitCharacterSet] characterIsMember: c];
}

+ (BOOL) isDigit___int:(int)c
{
    return [[NSCharacterSet decimalDigitCharacterSet] characterIsMember: c];
}

+ (BOOL) isWhitespace___char:(unichar)c
{
    return [[NSCharacterSet whitespaceCharacterSet] characterIsMember:c];
}

+ (BOOL) isWhitespace___int:(int)c
{
    return [[NSCharacterSet whitespaceCharacterSet] characterIsMember:c];
}

- (instancetype) __init_java_lang_Character___char :(unichar) charParm {
    return [self initWithUnsignedShort:charParm];
}

- (unichar) unbox
{
    return [self unsignedShortValue];
}

- (java_lang_String*) toString__
{
    return [[NSString alloc] initWithFormat:@"%C", [self unsignedShortValue]];
}

- (int) equals___java_lang_Object: (java_lang_Object*) o
{
    if ([self class] != [o class])
        return false;
    return [self unbox] == [o unbox];
}

@end
