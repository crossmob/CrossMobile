/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_lang_Number.h"

// java.lang.Short
//----------------------------------------------------------------------------
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_lang_Short : java_lang_Number

+ (java_lang_Class*) _GET_TYPE;
+ (short) parseShort___java_lang_String: (java_lang_String *) str;
+ (short) parseShort___java_lang_String_int: (java_lang_String*) str :(int) radix;
+ (java_lang_Short*) valueOf___short: (short) s;
- (id) init;
- (id) copyWithZone:(NSZone *)zone;
- (NSUInteger) hash;
- (instancetype) __init_java_lang_Short___short :(short) s;
- (short) unbox;

@end
