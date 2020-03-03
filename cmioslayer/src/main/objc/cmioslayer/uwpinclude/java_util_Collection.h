/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later


#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_lang_Iterable.h"
#import "java_util_Iterator.h"

// For circular include:
@class java_util_Collection;

CM_EXPORT_CLASS
@protocol java_util_Collection <java_lang_Iterable>
+ (void) initialize;
- (id) init;
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
- (int) removeAll___java_util_Collection :(java_util_Collection*)n1;
- (int) retainAll___java_util_Collection :(java_util_Collection*)n1;
- (void) clear__;
- (int) equals___java_lang_Object :(java_lang_Object*)n1;
- (int) hashCode__;
- (BOOL) isEqual:(id)o;

@end

@interface java_util_Collection : java_lang_Object <java_util_Collection>
@end
