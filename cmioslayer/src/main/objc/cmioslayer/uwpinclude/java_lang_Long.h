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

// java.lang.Long
//----------------------------------------------------------------------------
CM_EXPORT_CLASS
@interface java_lang_Long : java_lang_Number

+ (JAVA_LONG) parseLong___java_lang_String: (java_lang_String *) str;
+ (JAVA_LONG) parseLong___java_lang_String_int: (java_lang_String*) str :(int) radix;
+ (java_lang_String*) toString___long: (JAVA_LONG) l;
+ (java_lang_Long*) valueOf___long: (JAVA_LONG) l;
- (instancetype) __init_java_lang_Long___long :(JAVA_LONG) l;
- (int) compareTo___java_lang_Object: (java_lang_Object*) obj;
- (int) compareTo___java_lang_Long: (java_lang_Long*) l;
- (JAVA_LONG) unbox;

@end
