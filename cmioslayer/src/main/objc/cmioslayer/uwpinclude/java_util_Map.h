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
#define java_util_Map NSDictionary
@interface NSDictionary (cat_java_util_Map)

- (java_lang_Object*) put___java_lang_Object_java_lang_Object :(java_lang_Object*) key
                                                              :(java_lang_Object*) value;
- (java_lang_Object*) get___java_lang_Object :(java_lang_Object*) key;
- (java_util_Set*) keySet__;
- (int) size__;

@end
