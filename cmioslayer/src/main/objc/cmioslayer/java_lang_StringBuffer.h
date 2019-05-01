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
#import "java_lang_String.h"
#import "java_lang_CharSequence.h"


#define java_lang_StringBuffer NSMutableString

@interface NSMutableString (cat_java_lang_StringBuffer) //java_lang_String : java_lang_Object 

- (instancetype) __init_java_lang_StringBuilder__;
- (instancetype) __init_java_lang_StringBuilder___java_lang_String: (java_lang_String*) str;
- (instancetype) __init_java_lang_StringBuilder___java_lang_CharSequence: (id<java_lang_CharSequence>) str;
- (instancetype) __init_java_lang_StringBuffer__;
- (instancetype) __init_java_lang_StringBuffer___java_lang_String: (java_lang_String*) str;
- (java_lang_StringBuffer*) append___java_lang_String: (java_lang_String*) str;
- (java_lang_StringBuffer*) append___char_ARRAYTYPE: (XMLVMArray*) arr;
- (java_lang_StringBuffer*) append___java_lang_Object: (java_lang_Object*) obj;
- (java_lang_StringBuffer*) append___int: (int) i;
- (java_lang_StringBuffer*) append___long: (JAVA_LONG) l;
- (java_lang_StringBuffer*) append___char: (unichar) i;
- (java_lang_StringBuffer*) append___float: (float) f;
- (java_lang_StringBuffer*) append___double: (double) d;
- (java_lang_StringBuffer*) append___boolean: (BOOL) b;
- (java_lang_String*) substring___int_int: (int) from :(int) to;
- (java_lang_String*) substring___int: (int) from;
- (int) indexOf___java_lang_String: (java_lang_String*) s;
- (java_lang_StringBuffer*) delete___int_int: (int) start : (int) end;
- (java_lang_StringBuffer*) deleteCharAt___int: (int) n;
- (java_lang_StringBuffer*) replace___int_int_java_lang_String: (int) from :(int) to :(java_lang_String*) str;

@end
