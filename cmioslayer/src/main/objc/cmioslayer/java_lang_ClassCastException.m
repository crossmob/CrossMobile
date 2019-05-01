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


#import "java_lang_ClassCastException.h"

// java.lang.ClassCastException
//----------------------------------------------------------------------------
@implementation NSException (cm_java_lang_ClassCastException)

- (instancetype) __init_java_lang_ClassCastException__
{
    return [self initWithName: @"java_lang_ClassCastException" reason: nil userInfo: nil];
}

- (instancetype) __init_java_lang_ClassCastException___java_lang_String: (java_lang_String*) msg
{
    return [self init];
}

- (instancetype) __init_java_lang_ClassCastException___java_lang_String_java_lang_Throwable: (java_lang_String*) msg : (java_lang_Throwable*) cause
{
    return [self init];
}

- (java_lang_ClassCastException *) initCause___java_lang_Throwable: (java_lang_Throwable*) cause
{
	[self retain];
	return self;
}

@end
