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
#import "java_lang_Object.h"
#import "java_util_IteratorImpl.h"
#import "java_util_Collection.h"


#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_util_TreeSet : java_lang_Object {
@private
    NSMutableOrderedSet * set;
    BOOL isDirty;
}

- (id) init;

- (instancetype) __init_java_util_TreeSet__;
- (instancetype) __init_java_util_TreeSet___java_util_Collection:(java_util_Collection*)c;

- (BOOL) add___java_lang_Object:(java_lang_Object*)e;
- (BOOL) addAll___java_util_Collection: (java_util_Collection*) c;
- (int) size__;
- (void) clear__;
- (java_util_Iterator*) iterator__;
- (BOOL) contains___java_lang_Object: (java_lang_Object*) o;

- (java_lang_Object * ) first__;
- (java_lang_Object * ) last__;

@end
