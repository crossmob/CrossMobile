/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

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
