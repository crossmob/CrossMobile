/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_util_List.h"
#import "java_util_Comparator.h"
#import "java_util_List.h"
#import "java_util_Set.h"
#import "java_util_Map.h"
#import "java_util_Enumeration.h"
#import "java_util_Iterator.h"
#import "java_util_ListIterator.h"
#import "java_util_SortedMap.h"
#import "java_util_SortedSet.h"

#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_util_Collections : java_lang_Object

+ (java_util_List*) _GET_EMPTY_LIST;
+ (java_util_Set*) _GET_EMPTY_SET;
+ (java_util_Map*) _GET_EMPTY_MAP;
+ (java_util_Map*) emptyMap__;
+ (java_util_List*) emptyList__;
+ (java_util_Set*) emptySet__;
+ (java_util_Enumeration*) emptyEnumeration__;
+ (java_util_Iterator*) emptyIterator__;
+ (java_util_ListIterator*) emptyListIterator__;
+ (java_util_Map*) emptyNavigableMap__;
+ (java_util_Set*) emptyNavigableSet__;
+ (java_util_SortedMap*) emptySortedMap__;
+ (java_util_SortedSet*) emptySortedSet__;
+ (java_util_Set*) singleton___java_lang_Object:(java_lang_Object*) item;
+ (java_util_List*) singletonList___java_lang_Object:(java_lang_Object*) item;
+ (java_util_Map*) singletonMap___java_lang_Object_java_lang_Object:(java_lang_Object*) key :(java_lang_Object*) value;

+ (void) sort___java_util_List: (java_util_List*) list;
+ (void) sort___java_util_List_java_util_Comparator: (java_util_List*) list: (java_util_Comparator*) c;
+ (BOOL) addAll___java_util_Collection_java_lang_Object_ARRAYTYPE:(java_util_Collection*) c :(XMLVMArray*) elements;
@end
