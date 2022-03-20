// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSJSONSerialization implementation

#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSJSONSerialization.h"
#import "crossmobile_rt_StrongReference.h"
#import "java_lang_Object.h"

@implementation crossmobile_ios_foundation_NSJSONSerialization$Ext

@end

@implementation NSJSONSerialization (cm_crossmobile_ios_foundation_NSJSONSerialization)

// + (id)JSONObjectWithData:(NSData *)data options:(NSJSONReadingOptions)opt error:(NSError * _Nullable *)error;
+ (id) JSONObjectWithData___crossmobile_ios_foundation_NSData_int_crossmobile_rt_StrongReference:(NSData*) data :(int) opt :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    id re$ult = [NSJSONSerialization JSONObjectWithData:(data == JAVA_NULL ? nil : data) options:opt error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (NSData *)dataWithJSONObject:(id)obj options:(NSJSONWritingOptions)opt error:(NSError * _Nullable *)error;
+ (NSData*) dataWithJSONObject___java_lang_Object_int_crossmobile_rt_StrongReference:(id) obj :(int) opt :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    NSData* re$ult = [NSJSONSerialization dataWithJSONObject:(obj == JAVA_NULL ? nil : obj) options:opt error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (BOOL)isValidJSONObject:(id)obj;
+ (BOOL) isValidJSONObject___java_lang_Object:(id) obj 
{
    return [NSJSONSerialization isValidJSONObject:(obj == JAVA_NULL ? nil : obj)];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_foundation_NSJSONSerialization__
{
    return [self init];
}

@end
