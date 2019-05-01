/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 */

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

CM_EXPORT_CLASS
#define java_util_concurrent_CopyOnWriteArrayList NSMutableArray

@interface NSMutableArray (cat_java_util_concurrent_CopyOnWriteArrayList) <java_util_List>
- (instancetype) __init_java_util_concurrent_CopyOnWriteArrayList__;
- (instancetype) __init_java_util_concurrent_CopyOnWriteArrayList___int:(int)initialCapacity;
- (instancetype) __init_java_util_concurrent_CopyOnWriteArrayList___java_util_Collection:(java_util_Collection*)c;
@end
