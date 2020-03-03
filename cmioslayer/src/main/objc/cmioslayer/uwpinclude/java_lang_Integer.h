/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_lang_Comparable.h"
#import "java_lang_Number.h"

// java.lang.Integer
//----------------------------------------------------------------------------
CM_EXPORT_CLASS
@interface java_lang_Integer : java_lang_Number

+ (int) parseInt___java_lang_String: (java_lang_String *) str;
+ (java_lang_String*) toString___int: (int) i;
+ (java_lang_String*) toHexString___int: (int) i;
+ (java_lang_Integer*) valueOf___int: (int) i;
+ (int) parseInt___java_lang_String_int:(java_lang_String *) str : (int) radix;
- (instancetype) __init_java_lang_Integer___int :(int) i;
- (BOOL)equals___java_lang_Object:(java_lang_Object*)anObject;
- (int) compareTo___java_lang_Object: (java_lang_Object*) obj;
- (int) compareTo___java_lang_Integer: (java_lang_Integer*) i;
- (int) unbox;

@end
