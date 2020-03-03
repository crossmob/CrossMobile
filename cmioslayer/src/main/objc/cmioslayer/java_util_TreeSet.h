/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_util_IteratorImpl.h"
#import "java_util_Collection.h"


#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_util_TreeSet : java_lang_Object {
@private
    NSMutableOrderedSet * set;
    BOOL isDirty;
}

- (id) init;

- (instancetype) __init_java_util_TreeSet__;
- (instancetype) __init_java_util_TreeSet___java_util_Collection:(java_util_Collection*)c;

- (BOOL) add___java_lang_Object:(java_lang_Object*)e;
- (BOOL) addAll___java_util_Collection: (java_util_Collection*) c;
- (int) size__;
- (void) clear__;
- (java_util_Iterator*) iterator__;
- (BOOL) contains___java_lang_Object: (java_lang_Object*) o;

- (java_lang_Object * ) first__;
- (java_lang_Object * ) last__;

@end
