/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_lang_Math.h"
#import "java_util_Random.h"


// java.lang.Math
//----------------------------------------------------------------------------
@implementation java_lang_Math;

+ (double) random__
{
    static java_util_Random* random = nil;
    if (random == nil)
        random = [[java_util_Random alloc] __init_java_util_Random__];
    return [random nextDouble__];
}

+ (float) pow___float_float: (float) x : (float) y
{
    return pow(x, y);
}

+ (double) pow___double_double: (double) x : (double) y
{
    return pow(x, y);
}

+ (double) sqrt___double: (double) x
{
    return sqrt(x);
}

+ (double) sin___double: (double) a
{
	return sin(a);
}

+ (double) cos___double: (double) a
{
	return cos(a);
}

+ (double) tan___double: (double) a
{
    return tan(a);
}

+ (double) atan___double: (double) a
{
    return atan(a);
}

+ (double) atan2___double_double: (double) y :(double) x
{
	return atan2(y,x);
}

+ (double) asin___double: (double) x
{
    return asin(x);
}

+ (int) abs___int: (int) i
{
    return i < 0 ? i * -1 : i;
}

+ (float) abs___float: (float) f
{
    return f < 0.0 ? f * -1.0 : f;
}

+ (float) max___float_float :(float) x :(float) y
{
	return x < y ? y : x;
}

+ (double) max___double_double :(double) x :(double) y
{
	return x < y ? y : x;
}

+ (int) max___int_int :(int) x :(int) y
{
	return x < y ? y : x;
}

+ (JAVA_LONG) max___long_long :(JAVA_LONG) x :(JAVA_LONG) y
{
	return x < y ? y : x;
}

+ (float) min___float_float :(float) x :(float) y
{
	return x >  y ? y : x;
}

+ (double) min___double_double :(double) x :(double) y
{
	return x >  y ? y : x;
}

+ (int) min___int_int :(int) x :(int) y
{
	return x >  y ? y : x;
}

+ (JAVA_LONG) min___long_long :(JAVA_LONG) x :(JAVA_LONG) y
{
	return x >  y ? y : x;
}

+ (float) round___float: (float) a
{
	return roundf(a);
}

+ (double) round___double: (double) a
{
	return round(a);
}

+ (double) floor___double:(double) a
{
	return floor(a);
}

+ (double) ceil___double:(double) a
{
	return ceil(a);
}

+ (double ) expm1___double:(double) a
{
    return expm1(a);
}

+ (double) sinh___double:(double) a
{
    return sinh(a);
}

+ (double) cbrt___double:(double) a
{
    return cbrt(a);
}

+ (double) abs___double:(double) a
{
    return fabs(a);
}

+ (double) acos___double:(double) a
{
    return acos(a);
}

+ (double) cosh___double:(double) a
{
    return cosh(a);
}

+ (double) log1p___double:(double) a
{
    return log1p(a);
}

+ (double) log___double:(double) a
{
    return log(a);
}

+ (double) exp___double:(double) a
{
    return exp(a);
}

+ (double) tanh___double:(double) a
{
    return tanh(a);
}

+ (double) log10___double:(double) a
{
    return log10(a);
}

@end
