/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_util_IteratorImpl.h"
#import "java_util_List.h"
#import "java_util_Collection.h"

/*
 * NOTE: This is not a proper implementation! The methods should be thread-safe, but
 * they are not! This is only used in Xokoban (via android.view.ViewTreeObserver)
 * and since Xokoban is single-threaded, this is OK. The C backend will handle
 * this correctly.
 */

#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
#define java_util_concurrent_CopyOnWriteArrayList NSMutableArray

@interface NSMutableArray (cat_java_util_concurrent_CopyOnWriteArrayList) <java_util_List>
- (instancetype) __init_java_util_concurrent_CopyOnWriteArrayList__;
- (instancetype) __init_java_util_concurrent_CopyOnWriteArrayList___int:(int)initialCapacity;
- (instancetype) __init_java_util_concurrent_CopyOnWriteArrayList___java_util_Collection:(java_util_Collection*)c;
@end
