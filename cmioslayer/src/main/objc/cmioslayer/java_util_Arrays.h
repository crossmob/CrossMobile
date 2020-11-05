/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_util_Comparator.h"
#import "java_util_List.h"

#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_util_Arrays : java_lang_Object

//Private
+ (void) mergeSort:(XMLVMArray*) src: (XMLVMArray*) dest: (int) low: (int) high: (int) off;
+ (void) mergeSortWithComparator:(XMLVMArray*) src: (XMLVMArray*) dest: (int) low: (int) high: (int) off: (java_util_Comparator*)c;

//Public
+ (void) sort___int_ARRAYTYPE: (XMLVMArray*) a;
+ (void) sort___java_lang_Object_ARRAYTYPE: (XMLVMArray*) a;
+ (void) sort___java_lang_Object_ARRAYTYPE_java_util_Comparator: (XMLVMArray*) a: (java_util_Comparator*) c;
+ (void) sort___java_lang_Object_ARRAYTYPE_int_int_java_util_Comparator:(XMLVMArray*) a :(int) fromIndex :(int) toIndex :(java_util_Comparator*) c;
+ (void) fill___boolean_ARRAYTYPE_boolean:(XMLVMArray*) a :(BOOL) v;
+ (void) fill___byte_ARRAYTYPE_byte:(XMLVMArray*) a :(char) v;
+ (void) fill___short_ARRAYTYPE_short:(XMLVMArray*) a :(short) v;
+ (void) fill___int_ARRAYTYPE_int:(XMLVMArray*) a :(int) v;
+ (void) fill___long_ARRAYTYPE_long:(XMLVMArray*) a :(JAVA_LONG) v;
+ (void) fill___float_ARRAYTYPE_float:(XMLVMArray*) a :(float) v;
+ (void) fill___double_ARRAYTYPE_double:(XMLVMArray*) a :(double) v;
+ (void) fill___char_ARRAYTYPE_char:(XMLVMArray*) a :(unichar) v;
+ (void) fill___java_lang_Object_ARRAYTYPE_java_lang_Object:(XMLVMArray*) a :(java_lang_Object*) v;
+ (java_lang_String*) toString___boolean_ARRAYTYPE:(XMLVMArray*) a;
+ (java_lang_String*) toString___byte_ARRAYTYPE:(XMLVMArray*) a;
+ (java_lang_String*) toString___short_ARRAYTYPE:(XMLVMArray*) a;
+ (java_lang_String*) toString___int_ARRAYTYPE:(XMLVMArray*) a;
+ (java_lang_String*) toString___long_ARRAYTYPE:(XMLVMArray*) a;
+ (java_lang_String*) toString___float_ARRAYTYPE:(XMLVMArray*) a;
+ (java_lang_String*) toString___double_ARRAYTYPE:(XMLVMArray*) a;
+ (java_lang_String*) toString___char_ARRAYTYPE:(XMLVMArray*) a;
+ (java_lang_String*) toString___java_lang_Object_ARRAYTYPE    :(XMLVMArray*) a;
+ (java_util_List*) asList___java_lang_Object_ARRAYTYPE:(XMLVMArray*) a;
+ (XMLVMArray*) copyOf___int_ARRAYTYPE_int:(XMLVMArray*) original :(int) newLength;
+ (XMLVMArray*) copyOfRange___int_ARRAYTYPE_int_int:(XMLVMArray*) original :(int) from :(int) to;

@end
