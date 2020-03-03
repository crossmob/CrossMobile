/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

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
