// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSUserDefaults implementation

#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSUserDefaults.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_foundation_NSUserDefaults$Ext

@end

@implementation NSUserDefaults (cm_crossmobile_ios_foundation_NSUserDefaults)

// + (NSUserDefaults *)standardUserDefaults;
+ (NSUserDefaults*) standardUserDefaults__
{
    NSUserDefaults* re$ult = [NSUserDefaults standardUserDefaults];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (instancetype)initWithSuiteName:(NSString *)suitename;
- (instancetype) __init_crossmobile_ios_foundation_NSUserDefaults___java_lang_String:(NSString*) suitename 
{
    return [self initWithSuiteName:(suitename == JAVA_NULL ? nil : suitename)];
}

// - (BOOL)boolForKey:(NSString *)defaultName;
- (BOOL) boolForKey___java_lang_String:(NSString*) defaultName 
{
    return [self boolForKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// - (NSData *)dataForKey:(NSString *)defaultName;
- (NSData*) dataForKey___java_lang_String:(NSString*) defaultName 
{
    NSData* re$ult = [self dataForKey:(defaultName == JAVA_NULL ? nil : defaultName)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (double)doubleForKey:(NSString *)defaultName;
- (double) doubleForKey___java_lang_String:(NSString*) defaultName 
{
    return [self doubleForKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// - (float)floatForKey:(NSString *)defaultName;
- (float) floatForKey___java_lang_String:(NSString*) defaultName 
{
    return [self floatForKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// - (NSInteger)integerForKey:(NSString *)defaultName;
- (int) integerForKey___java_lang_String:(NSString*) defaultName 
{
    return [self integerForKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// - (id)objectForKey:(NSString *)defaultName;
- (id) objectForKey___java_lang_String:(NSString*) defaultName 
{
    id re$ult = [self objectForKey:(defaultName == JAVA_NULL ? nil : defaultName)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)removeObjectForKey:(NSString *)defaultName;
- (void) removeObjectForKey___java_lang_String:(NSString*) defaultName 
{
    [self removeObjectForKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// - (void)setBool:(BOOL)value forKey:(NSString *)defaultName;
- (void) setBool___boolean_java_lang_String:(BOOL) value :(NSString*) defaultName 
{
    [self setBool:value forKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// - (void)setDouble:(double)value forKey:(NSString *)defaultName;
- (void) setDouble___double_java_lang_String:(double) value :(NSString*) defaultName 
{
    [self setDouble:value forKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// - (void)setFloat:(float)value forKey:(NSString *)defaultName;
- (void) setFloat___float_java_lang_String:(float) value :(NSString*) defaultName 
{
    [self setFloat:value forKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// - (void)setInteger:(NSInteger)value forKey:(NSString *)defaultName;
- (void) setInteger___int_java_lang_String:(int) value :(NSString*) defaultName 
{
    [self setInteger:value forKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// - (void)setObject:(id)value forKey:(NSString *)defaultName;
- (void) setObject___java_lang_Object_java_lang_String:(id) value :(NSString*) defaultName 
{
    [self setObject:(value == JAVA_NULL ? nil : value) forKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// - (NSString *)stringForKey:(NSString *)defaultName;
- (NSString*) stringForKey___java_lang_String:(NSString*) defaultName 
{
    NSString* re$ult = [self stringForKey:(defaultName == JAVA_NULL ? nil : defaultName)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (BOOL)synchronize;
- (BOOL) synchronize__
{
    return [self synchronize];
}

@end
