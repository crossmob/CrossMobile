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

#import "java_lang_Float.h"
#import "java_lang_NumberFormatException.h"

// java.lang.Float
//----------------------------------------------------------------------------
@implementation java_lang_Float

- (instancetype) __init_java_lang_Float___float :(float) f
{
    return [self initWithFloat:f];
}

- (java_lang_String*) toString__
{
	return [[self stringValue] retain];
}

+ (java_lang_String*) toString___float: (float) f
{
	return [[[NSNumber numberWithFloat: f] stringValue] retain];
}

+ (float) parseFloat___java_lang_String: (java_lang_String *) str
{
    char * end;
    float result = strtof([str UTF8String], &end);
    if (*end!='\0') {
        java_lang_NumberFormatException* ex = [[java_lang_NumberFormatException alloc] init];
        [ex __init_java_lang_NumberFormatException__];
        @throw ex;
    } else
        return result;
}


+ (java_lang_Float*) valueOf___float:(float) f {
    return [[java_lang_Float alloc] __init_java_lang_Float___float:f];
}

- (float) unbox
{
    return [self floatValue];
}


@end
