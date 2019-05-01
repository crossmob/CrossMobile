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

// java_nio_IntBuffer
//----------------------------------------------------------------------------
CM_EXPORT_CLASS
@interface java_nio_IntBuffer : java_lang_Object {
	@public int *data;
	@public int index;
}

- (float*) get_data;
- (void) set_data:(float*) data;
- (int) get_index;
- (void) set_index:(int) index;
+ (java_nio_IntBuffer*) allocate___int: (int) size;
- (instancetype) __init_java_nio_IntBuffer___int: (int) size;
- (java_nio_IntBuffer*) put___int: (int) value;
- (java_nio_IntBuffer*) put___int_int: (int) pos : (int) value;
- (int) get___int: (int) value;
- (java_nio_IntBuffer*) reset__;

@end
