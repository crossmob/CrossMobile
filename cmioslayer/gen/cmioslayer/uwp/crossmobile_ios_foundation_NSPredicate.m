// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSPredicate implementation

#import "crossmobile_ios_foundation_NSPredicate.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSPredicate$Ext

@end

@implementation NSPredicate (cm_crossmobile_ios_foundation_NSPredicate)

// + (NSPredicate *)predicateWithFormat:(NSString *)predicateFormat argumentArray:(NSArray *)arguments;
+ (NSPredicate*) predicateWithFormat___java_lang_String_java_util_List:(NSString*) predicateFormat :(NSArray*) arguments 
{
    NSPredicate* re$ult = [NSPredicate predicateWithFormat:(predicateFormat == JAVA_NULL ? nil : predicateFormat) argumentArray:(arguments == JAVA_NULL ? nil : arguments)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (NSPredicate *)predicateWithValue:(BOOL)value;
+ (NSPredicate*) predicateWithValue___boolean:(BOOL) value 
{
    NSPredicate* re$ult = [NSPredicate predicateWithValue:value];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_foundation_NSPredicate__
{
    return [self init];
}

// @property(readonly, copy) NSString *predicateFormat;
- (NSString*) predicateFormat__
{
    NSString* re$ult = [self predicateFormat];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)allowEvaluation;
- (void) allowEvaluation__
{
    [self allowEvaluation];
}

// - (BOOL)evaluateWithObject:(id)object;
- (BOOL) evaluateWithObject___java_lang_Object:(id) object 
{
    return [self evaluateWithObject:(object == JAVA_NULL ? nil : object)];
}

// - (BOOL)evaluateWithObject:(id)object substitutionVariables:(NSDictionary<NSString *,id> *)bindings;
- (BOOL) evaluateWithObject___java_lang_Object_java_util_Map:(id) object :(NSDictionary*) bindings 
{
    return [self evaluateWithObject:(object == JAVA_NULL ? nil : object) substitutionVariables:(bindings == JAVA_NULL ? nil : bindings)];
}

// - (instancetype)predicateWithSubstitutionVariables:(NSDictionary<NSString *,id> *)variables;
- (instancetype) predicateWithSubstitutionVariables___java_util_Map:(NSDictionary*) variables 
{
    id re$ult = [self predicateWithSubstitutionVariables:(variables == JAVA_NULL ? nil : variables)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
