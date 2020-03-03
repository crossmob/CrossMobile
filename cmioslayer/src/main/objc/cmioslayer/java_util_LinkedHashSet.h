/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_util_IteratorImpl.h"
#import "java_util_Collection.h"


#define java_util_LinkedHashSet NSMutableOrderedSet

@interface NSMutableOrderedSet (cat_java_util_LinkedHashSet)

- (instancetype) __init_java_util_LinkedHashSet__;
- (instancetype) __init_java_util_LinkedHashSet___java_util_Collection:(java_util_Collection*)c;
- (instancetype) __init_java_util_LinkedHashSet___int: (int) size;

- (BOOL) add___java_lang_Object:(java_lang_Object*)e;
- (BOOL) addAll___java_util_Collection: (java_util_Collection*) c;
- (int) size__;
- (void) clear__;
- (java_util_Iterator*) iterator__;
- (BOOL) contains___java_lang_Object: (java_lang_Object*) o;

@end
