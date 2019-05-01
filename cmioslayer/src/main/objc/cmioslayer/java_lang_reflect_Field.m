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

#import "java_lang_reflect_Field.h"
#import "java_lang_Class.h"


// java.lang.reflect.Field
//----------------------------------------------------------------------------
@implementation java_lang_reflect_Field;

- (id) initWithName: (java_lang_String*) n isStatic: (BOOL) flag
{
	self = [super init];
	self->name = [n retain];
	self->isStatic = flag;
	return self;
}

- (void) dealloc
{
	[self->name release];
	[super dealloc];
}

- (instancetype) __init_java_lang_reflect_Field__
{
    return self;
}

- (java_lang_String*) getName__
{
	java_lang_String* n = self->name;
	[n retain];
	return n;
}

- (int) getInt___java_lang_Object: (java_lang_Object*) obj
{
	int val = 0;
	if (isStatic) {
		NSMutableString* mangledFieldName = [[NSMutableString alloc] initWithString: @"_GET_"];
		[mangledFieldName appendString: name];
		SEL sel = NSSelectorFromString(mangledFieldName);
		val = (int) [((java_lang_Class*) obj)->clazz performSelector: sel];
		[mangledFieldName release];
	} else {
		// TODO non-static fields
	}
	return val;
}

@end
