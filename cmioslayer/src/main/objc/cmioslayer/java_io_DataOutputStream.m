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
 
#import "java_io_DataOutputStream.h"

// java.io.DataOutputStream
//----------------------------------------------------------------------------
@implementation java_io_DataOutputStream

- (instancetype) __init_java_io_DataOutputStream___java_io_OutputStream: (java_io_OutputStream*) stream
{
	target = [stream retain];
    return self;
}

- (void) dealloc
{
	[target release];
	[super dealloc];
}

- (void) writeInt___int: (int) v
{
	unsigned char* p = (unsigned char*) &v;
	for (int i = 0; i < 4; i++) {
		[target write___int:*p++];
	}
}

- (void) writeDouble___double: (double) v
{
	unsigned char* p = (unsigned char*) &v;
	for (int i = 0; i < 8; i++) {
		[target write___int:*p++];
	}
}

- (void) writeByte___int: (int) v
{
	[target write___int:v];
}

- (void) writeBoolean___boolean: (int) v
{
	[target write___int:v];
}

- (void) write___int: (int) i
{
	[target write___int: i];
}

- (void) close__
{
	[target close__];
}

- (void) flush__
{
	[target flush__];
}

@end

