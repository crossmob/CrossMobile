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

#import "java_util_ArrayList.h"
#import "java_lang_IllegalArgumentException.h"

@implementation NSMutableArray (cat_java_util_concurrent_CopyOnWriteArrayList)

- (instancetype) __init_java_util_concurrent_CopyOnWriteArrayList__ {
	return [self __init_java_util_concurrent_CopyOnWriteArrayList___int:10];
}

- (instancetype) __init_java_util_concurrent_CopyOnWriteArrayList___int:(int)initialCapacity {
    return [self initWithCapacity:initialCapacity];
}

- (instancetype) __init_java_util_concurrent_CopyOnWriteArrayList___java_util_Collection:(java_util_Collection*)c {
    self = [self initWithCapacity:[c size__]];
	[self addAll___java_util_Collection:c];
    return self;
}

@end
