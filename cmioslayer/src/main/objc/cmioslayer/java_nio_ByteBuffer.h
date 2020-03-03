/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"

// java_nio_ByteBuffer
//----------------------------------------------------------------------------
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_nio_ByteBuffer : java_lang_Object {
	@public unsigned char *data;
	@public int index;
}

- (float*) get_data;
- (void) set_data:(float*) data;
- (int) get_index;
- (void) set_index:(int) index;
- (instancetype) __init_java_nio_ByteBuffer___int: (int) size;
- (java_nio_ByteBuffer*) put___int: (int) value;
- (java_nio_ByteBuffer*) put___int_int: (int) pos: (int) value;
- (int) get___int: (int) value;
- (java_nio_ByteBuffer*) reset__;

@end
