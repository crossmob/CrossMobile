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

- (char) unbox
{
    return [self charValue];
}

@end
