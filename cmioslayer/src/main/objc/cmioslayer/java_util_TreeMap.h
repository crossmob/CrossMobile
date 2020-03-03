/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_util_Collection.h"
#import "java_util_Iterator.h"
#import "java_util_Set.h"
#import "java_lang_Object.h"
#import "java_util_Map.h"


#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_util_TreeMap : NSMutableDictionary {
    @private
    NSMutableDictionary * dict;
    NSMutableArray * keys;
    BOOL isDirty;
}

- (id) init;

- (instancetype) __init_java_util_TreeMap__;
- (instancetype) __init_java_util_TreeMap___int: (int) size;
- (void) clear__;
- (java_util_Collection*) values__;
- (java_util_Iterator*) iterator__;
- (int) size__;
- (java_util_Set*) keySet__;
- (java_util_Set*) entrySet__;
- (java_lang_Object*) put___java_lang_Object_java_lang_Object:(java_lang_Object*) key: (java_lang_Object*) value;
- (java_lang_Object*) get___java_lang_Object:(java_lang_Object*) key;
- (BOOL) containsKey___java_lang_Object: (java_lang_Object*) key;
- (java_lang_Object*) remove___java_lang_Object:(java_lang_Object*) key;
- (BOOL) containsValue___java_lang_Object: (java_lang_Object*) value;

- (java_lang_Object *) firstKey__;
- (java_lang_Object *) lastKey__;
@end
