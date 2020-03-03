/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"


// java.util.Random
//----------------------------------------------------------------------------
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_util_Random : java_lang_Object

- (instancetype) __init_java_util_Random__;
- (instancetype) __init_java_util_Random___long :(JAVA_LONG) seed;
- (int) nextBoolean__;
- (double) nextDouble__;
- (float) nextFloat__;
- (int) nextInt__;
- (int) nextInt___int :(int)n;
- (JAVA_LONG) nextLong__;
- (void) setSeed___long :(JAVA_LONG)seed;

@end
