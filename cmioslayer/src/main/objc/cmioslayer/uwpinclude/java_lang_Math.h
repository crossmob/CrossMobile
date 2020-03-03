/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "xmlvm.h"
#import "java_lang_Object.h"

// java.lang.Math
//----------------------------------------------------------------------------
CM_EXPORT_CLASS
@interface java_lang_Math : java_lang_Object

+ (double) random__;
+ (float) pow___float_float: (float) x : (float) y;
+ (double) pow___double_double: (double) x : (double) y;
+ (double) sqrt___double: (double) x;
+ (double) asin___double: (double) x;
+ (double) sin___double: (double) a;
+ (double) cos___double: (double) a;
+ (double) tan___double: (double) a;
+ (double) atan2___double_double: (double) y :(double) x;
+ (int) abs___int: (int) i;
+ (float) abs___float: (float) f;
+ (float) max___float_float :(float) x :(float) y;
+ (double) max___double_double :(double) x :(double) y;
+ (int) max___int_int :(int) x :(int) y;
+ (int) max___long_long :(JAVA_LONG) x :(JAVA_LONG) y;
+ (float) min___float_float :(float) x :(float) y;
+ (double) min___double_double :(double) x :(double) y;
+ (int) min___int_int :(int) x :(int) y;
+ (int) min___long_long :(JAVA_LONG) x :(JAVA_LONG) y;
+ (float) round___float: (float) a;
+ (double) round___double: (double) a;
+ (double) floor___double:(double) a;
+ (double) ceil___double:(double) a;

@end

