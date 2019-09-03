/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 */

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

@end
