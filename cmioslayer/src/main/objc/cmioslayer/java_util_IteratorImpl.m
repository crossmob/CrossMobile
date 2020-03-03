/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

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
