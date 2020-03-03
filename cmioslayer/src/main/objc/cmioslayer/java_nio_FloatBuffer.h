/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"

// java_nio_FloatBuffer
//----------------------------------------------------------------------------
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_nio_FloatBuffer : java_lang_Object {
	@public float *data;
	@public int index;
}

- (float*) get_data;
- (void) set_data:(float*) data;
- (int) get_index;
- (void) set_index:(int) index;
- (instancetype) __init_java_nio_FloatBuffer___int: (int) size;
- (java_nio_FloatBuffer*) put___float: (float) value;
- (float) get___float: (int) value;
- (java_nio_FloatBuffer*) reset__;

@end
