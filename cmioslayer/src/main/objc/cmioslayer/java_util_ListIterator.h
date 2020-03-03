/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_util_Iterator.h"


// java.util.ListIterator
//----------------------------------------------------------------------------
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@protocol java_util_ListIterator <java_util_Iterator>

- (bool) hasNext__;
- (java_lang_Object*) next__;

@end

@interface java_util_ListIterator : java_util_Iterator <java_util_ListIterator>
@end
