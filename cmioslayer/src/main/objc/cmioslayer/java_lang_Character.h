/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"


// java.lang.Character
//----------------------------------------------------------------------------
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_lang_Character : NSNumber

- (instancetype) __init_java_lang_Character___char :(unichar) c;
+ (java_lang_String*) toString___char: (unichar) c;
+ (java_lang_Character*) valueOf___char: (unichar) c;
+ (BOOL) isUpperCase___char:(unichar) c;
+ (BOOL) isUpperCase___int:(int) c;
+ (BOOL) isLowerCase___char:(unichar) c;
+ (BOOL) isLowerCase___int:(int) c;
+ (BOOL) isLetter___char:(unichar)c;
+ (BOOL) isLetter___int:(int)c;
+ (BOOL) isDigit___char:(unichar)c;
+ (BOOL) isDigit___int:(int)c;
+ (BOOL) isWhitespace___char:(unichar)c;
+ (BOOL) isWhitespace___int:(int)c;
- (unichar) unbox;

@end
