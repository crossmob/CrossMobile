/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_util_Set.h"
#import "java_util_Collection.h"

// java.util.HashSet
//----------------------------------------------------------------------------
#define java_util_HashSet NSMutableSet

@interface NSMutableSet (cat_java_util_HashSet)

- (instancetype) __init_java_util_HashSet__;
- (instancetype) __init_java_util_HashSet___java_util_Collection:(java_util_Collection*)c;

- (BOOL) add___java_lang_Object:(java_lang_Object*)e;
- (BOOL) addAll___java_util_Collection: (java_util_Collection*) c;
- (int) size__;
- (void) clear__;
- (java_util_Iterator*) iterator__;
- (BOOL) contains___java_lang_Object: (java_lang_Object*) o;

@end
