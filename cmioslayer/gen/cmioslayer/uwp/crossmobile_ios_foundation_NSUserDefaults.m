// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSUserDefaults implementation

#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSUserDefaults.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_foundation_NSUserDefaults$Ext

// (NSUserDefaults) - (BOOL)boolForKey:(NSString *)defaultName;
- (BOOL) boolForKey___java_lang_String:(NSString*) defaultName 
{
    return [super boolForKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// (NSUserDefaults) - (NSData *)dataForKey:(NSString *)defaultName;
- (NSData*) dataForKey___java_lang_String:(NSString*) defaultName 
{
    NSData* re$ult = [super dataForKey:(defaultName == JAVA_NULL ? nil : defaultName)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSUserDefaults) - (double)doubleForKey:(NSString *)defaultName;
- (double) doubleForKey___java_lang_String:(NSString*) defaultName 
{
    return [super doubleForKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// (NSUserDefaults) - (float)floatForKey:(NSString *)defaultName;
- (float) floatForKey___java_lang_String:(NSString*) defaultName 
{
    return [super floatForKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// (NSUserDefaults) - (NSInteger)integerForKey:(NSString *)defaultName;
- (int) integerForKey___java_lang_String:(NSString*) defaultName 
{
    return [super integerForKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// (NSUserDefaults) - (id)objectForKey:(NSString *)defaultName;
- (id) objectForKey___java_lang_String:(NSString*) defaultName 
{
    id re$ult = [super objectForKey:(defaultName == JAVA_NULL ? nil : defaultName)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSUserDefaults) - (void)removeObjectForKey:(NSString *)defaultName;
- (void) removeObjectForKey___java_lang_String:(NSString*) defaultName 
{
    [super removeObjectForKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// (NSUserDefaults) - (void)setBool:(BOOL)value forKey:(NSString *)defaultName;
- (void) setBool___boolean_java_lang_String:(BOOL) value :(NSString*) defaultName 
{
    [super setBool:value forKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// (NSUserDefaults) - (void)setDouble:(double)value forKey:(NSString *)defaultName;
- (void) setDouble___double_java_lang_String:(double) value :(NSString*) defaultName 
{
    [super setDouble:value forKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// (NSUserDefaults) - (void)setFloat:(float)value forKey:(NSString *)defaultName;
- (void) setFloat___float_java_lang_String:(float) value :(NSString*) defaultName 
{
    [super setFloat:value forKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// (NSUserDefaults) - (void)setInteger:(NSInteger)value forKey:(NSString *)defaultName;
- (void) setInteger___int_java_lang_String:(int) value :(NSString*) defaultName 
{
    [super setInteger:value forKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// (NSUserDefaults) - (void)setObject:(id)value forKey:(NSString *)defaultName;
- (void) setObject___java_lang_Object_java_lang_String:(id) value :(NSString*) defaultName 
{
    [super setObject:(value == JAVA_NULL ? nil : value) forKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSUserDefaults) - (NSString *)stringForKey:(NSString *)defaultName;
- (NSString*) stringForKey___java_lang_String:(NSString*) defaultName 
{
    NSString* re$ult = [super stringForKey:(defaultName == JAVA_NULL ? nil : defaultName)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSUserDefaults) - (BOOL)synchronize;
- (BOOL) synchronize__
{
    return [super synchronize];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation NSUserDefaults (cm_crossmobile_ios_foundation_NSUserDefaults)

// direct binding of: + (NSUserDefaults *)standardUserDefaults;
+ (NSUserDefaults*) standardUserDefaults__
{
    NSUserDefaults* re$ult = [NSUserDefaults standardUserDefaults];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (instancetype)initWithSuiteName:(NSString *)suitename;
- (instancetype) __init_crossmobile_ios_foundation_NSUserDefaults___java_lang_String:(NSString*) suitename 
{
    return [self initWithSuiteName:(suitename == JAVA_NULL ? nil : suitename)];
}

// direct binding of: - (BOOL)boolForKey:(NSString *)defaultName;
- (BOOL) boolForKey___java_lang_String:(NSString*) defaultName 
{
    return [self boolForKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// direct binding of: - (NSData *)dataForKey:(NSString *)defaultName;
- (NSData*) dataForKey___java_lang_String:(NSString*) defaultName 
{
    NSData* re$ult = [self dataForKey:(defaultName == JAVA_NULL ? nil : defaultName)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (double)doubleForKey:(NSString *)defaultName;
- (double) doubleForKey___java_lang_String:(NSString*) defaultName 
{
    return [self doubleForKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// direct binding of: - (float)floatForKey:(NSString *)defaultName;
- (float) floatForKey___java_lang_String:(NSString*) defaultName 
{
    return [self floatForKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// direct binding of: - (NSInteger)integerForKey:(NSString *)defaultName;
- (int) integerForKey___java_lang_String:(NSString*) defaultName 
{
    return [self integerForKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// direct binding of: - (id)objectForKey:(NSString *)defaultName;
- (id) objectForKey___java_lang_String:(NSString*) defaultName 
{
    id re$ult = [self objectForKey:(defaultName == JAVA_NULL ? nil : defaultName)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)removeObjectForKey:(NSString *)defaultName;
- (void) removeObjectForKey___java_lang_String:(NSString*) defaultName 
{
    [self removeObjectForKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// direct binding of: - (void)setBool:(BOOL)value forKey:(NSString *)defaultName;
- (void) setBool___boolean_java_lang_String:(BOOL) value :(NSString*) defaultName 
{
    [self setBool:value forKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// direct binding of: - (void)setDouble:(double)value forKey:(NSString *)defaultName;
- (void) setDouble___double_java_lang_String:(double) value :(NSString*) defaultName 
{
    [self setDouble:value forKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// direct binding of: - (void)setFloat:(float)value forKey:(NSString *)defaultName;
- (void) setFloat___float_java_lang_String:(float) value :(NSString*) defaultName 
{
    [self setFloat:value forKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// direct binding of: - (void)setInteger:(NSInteger)value forKey:(NSString *)defaultName;
- (void) setInteger___int_java_lang_String:(int) value :(NSString*) defaultName 
{
    [self setInteger:value forKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// direct binding of: - (void)setObject:(id)value forKey:(NSString *)defaultName;
- (void) setObject___java_lang_Object_java_lang_String:(id) value :(NSString*) defaultName 
{
    [self setObject:(value == JAVA_NULL ? nil : value) forKey:(defaultName == JAVA_NULL ? nil : defaultName)];
}

// direct binding of: - (NSString *)stringForKey:(NSString *)defaultName;
- (NSString*) stringForKey___java_lang_String:(NSString*) defaultName 
{
    NSString* re$ult = [self stringForKey:(defaultName == JAVA_NULL ? nil : defaultName)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (BOOL)synchronize;
- (BOOL) synchronize__
{
    return [self synchronize];
}

@end
