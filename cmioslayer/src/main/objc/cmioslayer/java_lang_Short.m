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
    java_lang_Short* val = [[java_lang_Short alloc]init];
    [val __init_java_lang_Short___short:s];
    return val;
}

- (short) unbox
{
    return [self shortValue];
}

@end
