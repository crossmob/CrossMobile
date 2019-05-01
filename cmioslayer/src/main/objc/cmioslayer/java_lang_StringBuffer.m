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

#import "java_lang_StringBuffer.h"


// java.lang.StringBuffer
//----------------------------------------------------------------------------
@implementation NSMutableString (cat_java_lang_StringBuffer)


- (instancetype) __init_java_lang_StringBuilder__
{
    return [self init];
}

- (instancetype) __init_java_lang_StringBuilder___java_lang_String: (java_lang_String*) str
{
    return [self initWithString:str];
}

- (instancetype) __init_java_lang_StringBuilder___java_lang_CharSequence: (id<java_lang_CharSequence>) str
{
	// TODO Implement this
    return [self init];
}

- (instancetype) __init_java_lang_StringBuffer__
{
    return [self init];
}

- (instancetype) __init_java_lang_StringBuffer___java_lang_String: (java_lang_String*) str
{
    return [self initWithString:str];
}

- (java_lang_StringBuffer*) append___java_lang_String: (java_lang_String*) str
{
	if (str==JAVA_NULL)
		str = @"null";
    [self appendString: str];
    [self retain];
    return self;
}

- (java_lang_StringBuffer*) append___char_ARRAYTYPE: (XMLVMArray*) arr
{
	java_lang_StringBuffer* r;
	for (int i = 0; i < arr->length; i++) {
		r = [self append___char:arr->array.c[i]];
		[r release];
	}
    [self retain];
    return self;
}

- (java_lang_StringBuffer*) append___java_lang_Object: (java_lang_Object*) obj
{
	if (obj==JAVA_NULL)
		[self appendString:@"null"];
	else {
		NSString * toS = [obj toString__];
		[self appendString: toS];
		[toS release];
	}
    [self retain];
    return self;
}

- (java_lang_StringBuffer*) append___int: (int) i
{
	NSNumber* n = [NSNumber numberWithInt: i];
	[self appendString: [n stringValue]];
    [self retain];
	return self;
}


- (java_lang_StringBuffer*) append___long: (JAVA_LONG) l
{
	NSNumber* n = [NSNumber numberWithLongLong: l];
	[self appendString: [n stringValue]];
    [self retain];
	return self;
}

- (java_lang_StringBuffer*) append___char: (unichar) i
{
	char temp[10];
	sprintf(temp, "%C", i);
	[self appendString: [NSString stringWithUTF8String: temp]];
    [self retain];
	return self;
}

- (java_lang_StringBuffer*) append___float: (float) f
{
	[self appendString: [NSString stringWithFormat: @"%1.1f", f]];
    [self retain];
	return self;
}

- (java_lang_StringBuffer*) append___double: (double) d
{
	[self appendString: [NSString stringWithFormat: @"%f", d]];
    [self retain];
	return self;
}

- (java_lang_StringBuffer*) append___boolean: (BOOL) b;
{
	[self appendString: b ? @"true" : @"false"];
	[self retain];
	return self;
}

- (java_lang_String*) substring___int_int: (int) from :(int) to
{
	NSRange range;
	range.location = from;
	range.length = to - from;
	return [[NSString alloc] initWithString: [self substringWithRange: range]];
}

- (java_lang_String*) substring___int: (int) from
{
	return [[NSString alloc] initWithString: [self substringFromIndex: from]];
}

- (java_lang_String*) toString__
{
    return [[NSString alloc] initWithString: self];
}

- (int) indexOf___java_lang_String: (java_lang_String*) s {
	NSRange range = [self rangeOfString: s];
	if (range.location == NSNotFound) {
		return -1;
	}
	return range.location;
}

- (java_lang_StringBuffer*) deleteCharAt___int: (int) n
{
    return [self delete___int_int:n:n+1];
}

- (java_lang_StringBuffer*) delete___int_int: (int) start : (int) end
{
    NSRange range;
    range.location = start;
    range.length = end-start;
    [self deleteCharactersInRange:range];
    return [self retain];
}

- (java_lang_StringBuffer*) replace___int_int_java_lang_String: (int) from :(int) to :(java_lang_String*) str
{
	NSRange range;
	range.location = from;
	range.length = to-from;
	[self replaceCharactersInRange:range withString:str];
	return [self retain];
}
@end

