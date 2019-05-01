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

#import "java_io_OutputStreamWriter.h"

// java.io.OutputStreamWriter
//----------------------------------------------------------------------------
@implementation java_io_OutputStreamWriter

- (id) init
{
	[super init];
	outputStream = (java_io_OutputStream*) JAVA_NULL;
	return self;
}

- (id) initWithOutputStream:(java_io_OutputStream*)outStream
{
	self = [super init];
	[self __init_java_io_OutputStreamWriter___java_io_OutputStream:outStream];
	return self;
}

- (instancetype) __init_java_io_OutputStreamWriter___java_io_OutputStream: (java_io_OutputStream*)outStream
{
    [self init];
	[outStream retain];
	self->outputStream = outStream;
	[super __init_java_io_Writer__java_lang_Object:outStream];
    return self;
}

- (void) write___java_lang_String_int_int: (java_lang_String*)str: (int)off: (int)len
{
	[super write___java_lang_String_int_int:str:off:len];
}

- (void) write___char_ARRAYTYPE_int_int: (XMLVMArray *) cbuf: (int) off: (int) len
{
	[outputStream write___byte_ARRAYTYPE_int_int:cbuf:off:len];
}

- (void) write___int: (int) c
{
	[super write___int:c];
}

- (void) close__
{
	//StreamEncoder close
	[outputStream close__];
}

- (void) flush__
{
	//StreamEncoder flush
	[outputStream flush__];
}

- (void)dealloc
{
	[outputStream release];
	[super dealloc];
}

@end
