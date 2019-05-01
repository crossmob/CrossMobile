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
#import "java_lang_Object.h"

// java.lang.Math
//----------------------------------------------------------------------------
#if defined(_WIN32) || defined(WIN32)
__declspec(dllexport)
#endif
@interface java_lang_Math : java_lang_Object

+ (double) random__;
+ (float) pow___float_float: (float) x : (float) y;
+ (double) pow___double_double: (double) x : (double) y;
+ (double) sqrt___double: (double) x;
+ (double) asin___double: (double) x;
+ (double) sin___double: (double) a;
+ (double) cos___double: (double) a;
+ (double) tan___double: (double) a;
+ (double ) expm1___double:(double) a;
+ (double) atan___double: (double) a;
+ (double) sinh___double: (double) a;
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
+ (double) cbrt___double:(double) a;
+ (double) abs___double:(double) a;
+ (double) acos___double:(double) a;
+ (double) cosh___double:(double) a;
+ (double) log1p___double:(double) a;
+ (double) log___double:(double) a;
+ (double) exp___double:(double) a;
+ (double) tanh___double:(double) a;
+ (double) log10___double:(double) a;

@end

