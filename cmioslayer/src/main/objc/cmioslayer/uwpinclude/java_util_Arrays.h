/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_util_Comparator.h"
#import "java_util_List.h"

CM_EXPORT_CLASS
@interface java_util_Arrays : java_lang_Object

//Private
+ (void) mergeSort:(XMLVMArray*) src: (XMLVMArray*) dest: (int) low: (int) high: (int) off;
+ (void) mergeSortWithComparator:(XMLVMArray*) src: (XMLVMArray*) dest: (int) low: (int) high: (int) off: (java_util_Comparator*)c;

//Public
+ (void) sort___int_ARRAYTYPE: (XMLVMArray*) a;
+ (void) sort___java_lang_Object_ARRAYTYPE: (XMLVMArray*) a;
+ (void) sort___java_lang_Object_ARRAYTYPE_java_util_Comparator: (XMLVMArray*) a: (java_util_Comparator*) c;
+ (void) sort___java_lang_Object_ARRAYTYPE_int_int_java_util_Comparator:(XMLVMArray*) a :(int) fromIndex :(int) toIndex :(java_util_Comparator*) c;
+ (java_util_List*) asList___java_lang_Object_ARRAYTYPE:(XMLVMArray*) a;
+ (XMLVMArray*) copyOf___int_ARRAYTYPE_int:(XMLVMArray*) original :(int) newLength;
+ (XMLVMArray*) copyOfRange___int_ARRAYTYPE_int_int:(XMLVMArray*) original :(int) from :(int) to;
+ (void) fill___char_ARRAYTYPE_char:(XMLVMArray*) arr :(int) ch;
+ (java_lang_String*) toString___int_ARRAYTYPE:(XMLVMArray*) array;

@end
