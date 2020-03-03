/* Copyright (c) 2002-2011 by XMLVM.org
 *
 * Project Info:  http://www.xmlvm.org
 */

// SPDX-License-Identifier: LGPL-2.1-or-later

#import "java_util_Random.h"
#import "java_lang_System.h"


#define MAXIMUM     2147483647
#define MINNEGATIVE 1073741824

// java.util.Random
//----------------------------------------------------------------------------
@implementation java_util_Random

- (instancetype) __init_java_util_Random__ {
    return [self __init_java_util_Random___long:[java_lang_System currentTimeMillis__]];
}

- (instancetype) __init_java_util_Random___long :(JAVA_LONG) seed {
	[self setSeed___long:seed];
    return self;
}

/**
 * As per the Java API, do not return 1.0, which would occur if the returned value equaled the maximum value
 * @return a random value from 0.0 (inclusive) to 1.0 (exclusive)
 */
double fetchRandomExceptOne() {
    long val = MAXIMUM;
    while (val == MAXIMUM) {
        val = random();
    }
    return (double)val/MAXIMUM;
}

- (int) nextBoolean__
{
    return random()&01;
}

- (double) nextDouble__ {
    return fetchRandomExceptOne();
}

- (float) nextFloat__ {
    return (float)fetchRandomExceptOne();
}

- (int) nextInt__
{
    // random() returns a range of 0 to (2^31)-1, but we need the range of all possible 2^32 int values including negative numbers
    return (random()<<1)|[self nextBoolean__];
}

- (int) nextInt___int :(int)n {
    // TODO throw an IllegalArgumentException if n is negative
    return (int)(fetchRandomExceptOne() * n);
}

- (JAVA_LONG) nextLong__
{
    // This maximum value will overflow to a negative value
    JAVA_LONG result = 9223372036854775807; // 2^63-1
    result *= fetchRandomExceptOne();
    if ([self nextBoolean__]) {
        result *= -1;
    }
    return result;
}

- (void) setSeed___long :(JAVA_LONG)seed
{
    srandom(seed);
}

@end
