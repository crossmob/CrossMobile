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
#import "java_io_InputStream.h"
CM_EXPORT_CLASS
@interface java_io_ByteArrayInputStream : java_io_InputStream {
  char *buffer;
  int length;
  JAVA_LONG pos;
  JAVA_LONG marked;
}

- (instancetype) __init_java_io_ByteArrayInputStream___byte_ARRAYTYPE_int_int :(XMLVMArray*)buf :(int)from :(int)len;
- (instancetype) __init_java_io_ByteArrayInputStream___byte_ARRAYTYPE: (XMLVMArray*)buf;
- (void) dealloc;
- (int) read___char_ARRAYTYPE_int_int: (XMLVMArray *) buffer: (int) pos: (int) len;
- (java_lang_String *) readLine__;
@end
