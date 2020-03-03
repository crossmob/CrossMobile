/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_util_IteratorImpl.h"


// java.util.Stack
//----------------------------------------------------------------------------
CM_EXPORT_CLASS
@interface java_util_Stack : java_lang_Object {
	NSMutableArray* theStack;
}

- (instancetype) __init_java_util_Stack__;
- (void) dealloc;
- (java_util_Iterator*) iterator__;
- (int) size__;
- (java_lang_Object*) push___java_lang_Object :(java_lang_Object*) item;
- (java_lang_Object*) get___int :(int) idx;
- (java_lang_Object*) pop__;
- (java_lang_Object*) peek__;
- (java_lang_Object*) remove___int :(int) idx;
- (BOOL) remove___java_lang_Object :(java_lang_Object*) item;

@end
