/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_util_Set.h"
#import "java_util_Iterator.h"


// java.util.Map
//----------------------------------------------------------------------------
// For circular include:
@class java_util_Map;

@protocol java_util_Map
- (void) clear__;
- (java_util_Collection*) values__;
- (java_util_Iterator*) iterator__;
- (int) size__;
- (java_util_Set*) keySet__;
- (java_util_Set*) entrySet__;
- (java_lang_Object*) put___java_lang_Object_java_lang_Object:(java_lang_Object*) key : (java_lang_Object*) value;
- (java_lang_Object*) get___java_lang_Object:(java_lang_Object*) key;
- (BOOL) containsKey___java_lang_Object: (java_lang_Object*) key;
- (BOOL) containsValue___java_lang_Object: (java_lang_Object*) value;
- (java_lang_Object*) remove___java_lang_Object:(java_lang_Object*) key;
- (void) putAll___java_util_Map:(java_util_Map *) other;
@end
    

@interface java_util_Map : java_lang_Object <java_util_Map>
@end
