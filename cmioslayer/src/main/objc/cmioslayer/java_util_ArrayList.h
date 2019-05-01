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

// java.util.ArrayList
//----------------------------------------------------------------------------

#define java_util_ArrayList NSMutableArray

@interface NSArray (cat_java_util_ArrayList)
- (int) size__;
- (int) contains___java_lang_Object :(java_lang_Object*) item;
- (BOOL) isEmpty__;
- (java_util_Iterator*) iterator__;
- (int) indexOf___java_lang_Object :(java_lang_Object*) item;
- (java_lang_Object*) get___int :(int) idx;
- (XMLVMArray*) toArray__;
- (XMLVMArray*) toArray___java_lang_Object_ARRAYTYPE:(XMLVMArray*) contents;
@end

@interface NSMutableArray (cat_java_util_ArrayList) <java_util_List>
- (instancetype) __init_java_util_ArrayList__;
- (instancetype) __init_java_util_ArrayList___int:(int)initialCapacity;
- (instancetype) __init_java_util_ArrayList___java_util_Collection:(java_util_Collection*)c;
- (BOOL) add___java_lang_Object :(java_lang_Object*) item;
- (void) add___int_java_lang_Object :(int) idx :(java_lang_Object*) item;
- (BOOL) addAll___java_util_Collection:(java_util_Collection*)c;
- (java_lang_Object*) set___int_java_lang_Object :(int) idx: (java_lang_Object*) item;
- (java_lang_Object*) remove___int :(int) idx;
- (BOOL) remove___java_lang_Object :(java_lang_Object*) item;
- (BOOL) removeAll___java_util_Collection:(java_util_Collection*) c;
- (void) clear__;

// Missing
- (int) lastIndexOf___java_lang_Object :(java_lang_Object*)n1;
- (int) addAll___int_java_util_Collection :(int)n1 :(java_util_Collection*)n2;

@end
