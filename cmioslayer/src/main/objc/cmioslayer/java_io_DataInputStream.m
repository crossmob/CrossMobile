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

 
#import "java_io_DataInputStream.h"

// java.io.DataInputStream
//----------------------------------------------------------------------------
@implementation java_io_DataInputStream

- (instancetype) __init_java_io_DataInputStream___java_io_InputStream: (java_io_InputStream*) stream
{
	target = [stream retain];
    return self;
}

- (void) dealloc
{
	[target release];
	[super dealloc];
}

- (int) read__
{
	return [target read__];
}

- (void) close__
{
	[target close__];
}

- (int) readInt__
{
	int d;
	unsigned char* p = (unsigned char*) &d;
	
	for (int i = 0; i < 4; i++) {
		int v = [target read__];
		*p++ = (unsigned char) v;
	}
	return d;
}

- (int) readByte__
{
	return [target read__];
}

- (bool) readBoolean__
{
	return [target read__] != 0;
}

- (float) readFloat__
{
	float f;
	unsigned char* p = (unsigned char*) &f;
	
	for (int i = 0; i < 4; i++) {
		int v = [target read__];
		*p++ = (unsigned char) v;
	}
	return f;
}

- (double) readDouble__
{
	double d;
	unsigned char* p = (unsigned char*) &d;
	
	for (int i = 0; i < 8; i++) {
		int v = [target read__];
		*p++ = (unsigned char) v;
	}
	return d;
}

@end

