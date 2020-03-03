/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"

// java_nio_IntBuffer
//----------------------------------------------------------------------------
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
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
