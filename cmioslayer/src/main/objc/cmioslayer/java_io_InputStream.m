/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_io_InputStream.h"

// java.io.InputStream
//----------------------------------------------------------------------------
@implementation java_io_InputStream

- (instancetype) __init_java_io_InputStream__
{	
    return [self init];
}

- (int) available__
{
	return 0;
}

- (bool) markSupported__
{
	return false;
}

- (void) mark___int: (int) readlimit
{
}

- (void) mark___long: (JAVA_LONG) readlimit
{
}

- (int) read__
{
	[self xmlvmSubclassResponsibility];
	return -1;
}

- (int) read___byte_ARRAYTYPE: (XMLVMArray *) buffer
{
	return [self read___byte_ARRAYTYPE_int_int: buffer : 0 : [buffer count]];
}

- (int) read___byte_ARRAYTYPE_int_int: (XMLVMArray *) buffer: (int) pos: (int) len 
{
	int i = 0;
	for (i = 0; i < len; ++i) {
		int c = [self read__];
		if (c == -1) {
			break;
		}
		buffer->array.b[pos + i] = c;
	}
	return i > 0 ? i : -1;
}

- (void) close__
{
}

- (void) reset__
{
}

- (JAVA_LONG) skip___long: (JAVA_LONG) n
{
	return 0;
}


@end
