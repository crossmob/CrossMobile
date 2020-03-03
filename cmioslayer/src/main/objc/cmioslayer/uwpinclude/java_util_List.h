/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_util_Iterator.h"
#import "java_util_Collection.h"
#import "java_util_ListIterator.h"
// java.util.List
//----------------------------------------------------------------------------
CM_EXPORT_CLASS
@protocol java_util_List <java_util_Collection>

- (int) size__;
- (int) isEmpty__;
- (int) contains___java_lang_Object :(java_lang_Object*)n1;
- (java_util_Iterator*) iterator__;
- (XMLVMArray*) toArray__;
- (XMLVMArray*) toArray___java_lang_Object_ARRAYTYPE :(XMLVMArray*)n1;
- (int) add___java_lang_Object :(java_lang_Object*)n1;
- (int) remove___java_lang_Object :(java_lang_Object*)n1;
- (int) containsAll___java_util_Collection :(java_util_Collection*)n1;
- (int) addAll___java_util_Collection :(java_util_Collection*)n1;
- (int) addAll___int_java_util_Collection :(int)n1 :(java_util_Collection*)n2;
- (int) removeAll___java_util_Collection :(java_util_Collection*)n1;
- (int) retainAll___java_util_Collection :(java_util_Collection*)n1;
- (void) clear__;
- (int) equals___java_lang_Object :(java_lang_Object*)n1;
- (int) hashCode__;
- (java_lang_Object*) get___int :(int)n1;
- (java_lang_Object*) set___int_java_lang_Object :(int)n1 :(java_lang_Object*)n2;
- (void) add___int_java_lang_Object :(int)n1 :(java_lang_Object*)n2;
- (java_lang_Object*) remove___int :(int)n1;
- (int) indexOf___java_lang_Object :(java_lang_Object*)n1;
- (int) lastIndexOf___java_lang_Object :(java_lang_Object*)n1;
- (java_util_ListIterator*) listIterator__;
- (java_util_ListIterator*) listIterator___int :(int)n1;
- (BOOL) isEqual:(id)o;

@end
CM_EXPORT_CLASS
@interface java_util_List : java_lang_Object <java_util_List>
- (java_util_List*) subList___int_int :(int)n1 :(int)n2;
@end
