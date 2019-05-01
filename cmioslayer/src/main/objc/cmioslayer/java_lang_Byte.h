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

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_lang_Number.h"
#import "java_lang_String.h"

// java.lang.Byte
//----------------------------------------------------------------------------
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_lang_Byte : java_lang_Number

+ (char) parseByte___java_lang_String: (java_lang_String *) str;
+ (char) parseByte___java_lang_String_int: (java_lang_String*) str :(int) radix;
+ (java_lang_String*) toString___byte: (char) b;
+ (java_lang_Byte*) valueOf___byte: (char) c;
- (instancetype) __init_java_lang_Byte___byte :(char) b;
- (char) unbox;

@end
