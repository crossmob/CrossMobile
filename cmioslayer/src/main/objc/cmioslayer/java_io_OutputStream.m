/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_io_OutputStream.h"
#import "java_lang_IllegalArgumentException.h"

// java.io.OutputStream
//----------------------------------------------------------------------------
@implementation java_io_OutputStream

- (instancetype) __init_java_io_OutputStream__
{
    return [self init];
}

- (void) write___int: (int) i
{
	[self xmlvmSubclassResponsibility];
}

- (void) write___byte_ARRAYTYPE: (XMLVMArray *) data
{
	int arrlen = [data count];
	[self write___byte_ARRAYTYPE_int_int:data :0 :arrlen];
}

- (void) write___byte_ARRAYTYPE_int_int: (XMLVMArray *) data: (int) pos: (int) len
{
	int arrlen = [data count];
	if (arrlen < pos + len) {
		id exc_id = [[java_lang_IllegalArgumentException alloc] init];
		java_lang_IllegalArgumentException *exc = (java_lang_IllegalArgumentException*) exc_id;
		[exc __init_java_lang_IllegalArgumentException__];
		@throw exc_id;
	}
	for (int i = pos; i < len + pos; ++i) {
		int c = data->array.b[i];
		[self write___int: c];
	}
}

- (void) flush__
{
}

- (void) close__
{
}

@end

