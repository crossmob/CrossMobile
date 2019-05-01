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

#import "xmlvm.h"
#import "java_lang_Number.h"
#import "java_lang_Class.h"
#import "java_lang_String.h"


// java.lang.Boolean
//----------------------------------------------------------------------------
CM_EXPORT_CLASS
@interface java_lang_Boolean : java_lang_Number

+ (java_lang_Class*) _GET_TYPE;
+ (BOOL) parseBoolean___java_lang_String:(java_lang_String*) str;
+ (java_lang_Boolean*) _GET_FALSE;
+ (java_lang_Boolean*) _GET_TRUE;
+ (java_lang_Boolean*) valueOf___java_lang_String:(java_lang_String*) s;
+ (java_lang_Boolean*) valueOf___boolean:(int)b;
+ (java_lang_String*) toString___boolean:(BOOL) b;
- (instancetype) __init_java_lang_Boolean___boolean :(BOOL) b;
- (BOOL) unbox;

@end
