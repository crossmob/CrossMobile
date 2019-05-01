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
#import "java_lang_String.h"

#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_io_Writer : java_lang_Object {
	java_lang_Object* lock;
	XMLVMArray* writeBuffer;
}

- (java_lang_Object*) protectedLock;

- (instancetype) __init_java_io_Writer__;
- (instancetype) __init_java_io_Writer__java_lang_Object: (java_lang_Object*)lockObject;

- (void) close__;
- (void) flush__;
- (void) write___char_ARRAYTYPE: (XMLVMArray *) cbuf;
- (void) write___char_ARRAYTYPE_int_int: (XMLVMArray *) cbuf: (int) off: (int) len;
- (void) write___int: (int) c;
- (void) write___java_lang_String: (java_lang_String*) str;
- (void) write___java_lang_String_int_int: (java_lang_String*) str: (int) off: (int) len;

@end
