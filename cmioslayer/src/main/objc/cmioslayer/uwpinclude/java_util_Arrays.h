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
