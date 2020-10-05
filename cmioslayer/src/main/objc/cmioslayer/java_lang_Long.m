/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_lang_Long.h"
#import "java_lang_RuntimeException.h"
#import "java_lang_Integer.h"
#import "java_lang_NumberFormatException.h"

// java.lang.Long
//----------------------------------------------------------------------------
@implementation java_lang_Long

+ (JAVA_LONG) parseLong___java_lang_String: (java_lang_String *) str
{
	JAVA_LONG result = 0;
	if (str == JAVA_NULL || [str length__] == 0) {
		java_lang_NumberFormatException* ex = [[java_lang_NumberFormatException alloc] init];
		[ex __init_java_lang_NumberFormatException__];
		@throw ex;
	} else {
		result = atoll([str UTF8String]);
		// If the result was 0, there was probably an error
		// Every character before a decimal point should be '0' ('-' excluded) or we throw an exception
		if (result == 0) {
			BOOL ok = TRUE;
			int i = 0;
			if ([str charAt___int:0] == '-') {
				if ([str length__] == 1) {
					ok = FALSE;
				} else {
					i++;
				}
			}
			while (ok && i < [str length__]) {
				char c = [str charAt___int:i++];
				if (c != '0') {
					ok = FALSE;
				}
			}
			if (!ok) {
				java_lang_NumberFormatException* ex = [[java_lang_NumberFormatException alloc] init];
				[ex __init_java_lang_NumberFormatException__];
				@throw ex;
			}
		}
// TODO throw a NumberFormatException for e.g. values "1.0" and "-1.01" instead of returning 1 and -1 respectively
	}
	return result;
}

+ (JAVA_LONG) parseLong___java_lang_String_int: (java_lang_String*) str :(int) radix
{
// TODO throw NumberFormatException when appropriate
    return strtoll([str UTF8String], nil, radix);
}

+ (java_lang_String*) toString___long: (JAVA_LONG) l
{
    return [[[NSNumber numberWithLongLong: l] stringValue] retain];
}

+ (java_lang_Long*) valueOf___long: (JAVA_LONG) l {
    return [[java_lang_Long alloc] __init_java_lang_Long___long:l];
}

static BOOL instanceof(id obj, const char *className) {
	return obj != JAVA_NULL &&
		([obj isKindOfClass: objc_getClass(className)] ||
			[obj conformsToProtocol: objc_getProtocol(className)]);	
}

- (id) copyWithZone:(NSZone *)zone
{
    return [[[self class] allocWithZone:zone] __init_java_lang_Long___long:[self longLongValue]];
}

- (instancetype) __init_java_lang_Long___long :(JAVA_LONG) l
{
    return [self initWithLongLong:l];
}


//Signature from java_lang_Comparable
- (int) compareTo___java_lang_Object: (java_lang_Object*) obj {
	if (!instanceof(obj, "java_lang_Long")) {
//TODO throw a java_lang_ClassCastException (doesn't exist yet) instead of a java_lang_RuntimeException
		java_lang_RuntimeException* ex = [[java_lang_RuntimeException alloc] init];
		[ex __init_java_lang_RuntimeException___java_lang_String:[NSMutableString stringWithString:@"ClassCastException"]];
		@throw ex;
	}
	return [self compareTo___java_lang_Long:(java_lang_Long*)obj];
}

- (int) compareTo___java_lang_Long: (java_lang_Long*) l {
	JAVA_LONG thisVal = [self longValue__];
	JAVA_LONG anotherVal = [l longValue__];
	return (thisVal < anotherVal ? -1 : (thisVal == anotherVal ? 0 : 1));
}

- (int) equals___java_lang_Object: (java_lang_Object*) o
{
    if ([self class] != [o class])
        return false;
    return [self unbox] == [o unbox];
}

- (JAVA_LONG) unbox
{
    return [self longLongValue];
}

@end
