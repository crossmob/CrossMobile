/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_util_Iterator.h"
#import "java_util_Enumeration.h"


// java.util.IteratorImpl
// Implement Iterator as well as Enumeration
//----------------------------------------------------------------------------
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_util_IteratorImpl : java_lang_Object <java_util_Iterator,java_util_Enumeration> {

NSEnumerator* enumerator;
id nextObj;

}

- (id) init :(NSEnumerator*) e;
- (bool) hasNext__;
- (bool) hasMoreElements__;
- (java_lang_Object*) next__;
- (java_lang_Object*) nextElement__;

@end
