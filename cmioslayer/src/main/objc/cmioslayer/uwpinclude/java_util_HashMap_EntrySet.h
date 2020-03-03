/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_util_Set.h"
#import "java_util_Map_Entry.h"

@class java_util_HashMap;


// java.util.HashMap.EntrySet
//----------------------------------------------------------------------------
CM_EXPORT_CLASS
@interface java_util_HashMap_EntrySet : java_util_Set {
	java_util_HashMap* map;
}

- (instancetype) __init_java_util_HashMap_EntrySet___java_util_HashMap:(java_util_HashMap*)m;
- (java_util_Iterator*) iterator__;
- (int) size__;
- (void) clear__;

@end
