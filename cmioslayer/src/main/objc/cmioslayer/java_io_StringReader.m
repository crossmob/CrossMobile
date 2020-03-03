/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_io_StringReader.h"

// java.io.StringReader
//----------------------------------------------------------------------------
@implementation java_io_StringReader

- (instancetype) __init_java_io_StringReader___java_lang_String:(java_lang_String*)s
{
	self->str = s;
	self->pos = 0;
    return self;
}

- (int) read__
{
	if ([str length] == pos) {
		return -1;
	}
	return [str charAt___int:pos++];
}

@end

