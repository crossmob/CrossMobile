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

#import "java_util_IteratorImpl.h"



// java.util.IteratorImpl
//----------------------------------------------------------------------------
@implementation java_util_IteratorImpl

- (id) init :(NSEnumerator*) e
{
	[super init];
	self->enumerator = e;
	self->nextObj = [e nextObject];
	return self;
}

- (bool) hasNext__
{
	return self->nextObj != nil;
}

- (bool) hasMoreElements__
{
    return [self hasNext__];
}

- (java_lang_Object*) next__
{
	id next = [self->nextObj retain];
	self->nextObj = [enumerator nextObject];
	return (java_lang_Object*) next;
}

- (java_lang_Object*) nextElement__
{
    return [self next__];
}

@end
