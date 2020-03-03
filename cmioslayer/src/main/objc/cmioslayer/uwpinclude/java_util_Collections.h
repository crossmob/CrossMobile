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

CM_EXPORT_CLASS
@interface java_util_Collections : java_lang_Object

+ (java_util_List*) _GET_EMPTY_LIST;
+ (java_util_Set*) _GET_EMPTY_SET;
+ (java_util_Map*) _GET_EMPTY_MAP;
+ (void) sort___java_util_List: (java_util_List*) list;
+ (void) sort___java_util_List_java_util_Comparator: (java_util_List*) list: (java_util_Comparator*) c;

@end
