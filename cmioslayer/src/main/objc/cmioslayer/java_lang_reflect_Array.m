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

#import "java_lang_reflect_Array.h"
#import "java_lang_Boolean.h"
#import "java_lang_Character.h"
#import "java_lang_Byte.h"
#import "java_lang_Short.h"
#import "java_lang_Integer.h"
#import "java_lang_Float.h"
#import "java_lang_Double.h"
#import "java_lang_Long.h"
#import "java_lang_RuntimeException.h"


// java.lang.reflect.Array
//----------------------------------------------------------------------------
@implementation java_lang_reflect_Array

+ (XMLVMArray*) newInstance___java_lang_Class_int_ARRAYTYPE:(java_lang_Class*)clazz :(XMLVMArray*)dimensions
{
	int baseTypeId = -1;

	if (clazz == [java_lang_Boolean _GET_TYPE]) {
		baseTypeId = 1;
	} else if (clazz == [java_lang_Character _GET_TYPE]) {
		baseTypeId = 2;
	} else if (clazz == [java_lang_Byte _GET_TYPE]) {
		baseTypeId = 3;
	} else if (clazz == [java_lang_Short _GET_TYPE]) {
		baseTypeId = 4;
	} else if (clazz == [java_lang_Integer _GET_TYPE]) {
		baseTypeId = 5;
	} else if (clazz == [java_lang_Float _GET_TYPE]) {
		baseTypeId = 6;
	} else if (clazz == [java_lang_Double _GET_TYPE]) {
		baseTypeId = 7;
	} else if (clazz == [java_lang_Long _GET_TYPE]) {
		baseTypeId = 8;
	} else {
		baseTypeId = 0;
	}
	
	return [XMLVMArray createMultiDimensionsWithType:baseTypeId dimensions:dimensions->array.data count:dimensions->length];
}

+ (void) set___java_lang_Object_int_java_lang_Object:(XMLVMArray*) array :(int) index :(java_lang_Object*) obj
{
	if (array->type == 0) {
		[obj retain];
		[array->array.o[index] release];
		array->array.o[index] = obj;
	}
	else {
		// TODO
		// primitive types need to be unwrapped
		@throw [[NSException alloc] init];
	}
}

@end
