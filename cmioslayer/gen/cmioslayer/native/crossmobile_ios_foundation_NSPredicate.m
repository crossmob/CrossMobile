// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSPredicate implementation

#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_foundation_NSPredicate.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSPredicate$Ext

// (NSPredicate) @property(readonly, copy) NSString *predicateFormat;
- (NSString*) predicateFormat__
{
    NSString* re$ult = [super predicateFormat];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (NSPredicate) - (void)allowEvaluation;
- (void) allowEvaluation__
{
    [super allowEvaluation];
}

// (NSPredicate) - (BOOL)evaluateWithObject:(id)object;
- (BOOL) evaluateWithObject___java_lang_Object:(id) object 
{
    return [super evaluateWithObject:(object == JAVA_NULL ? nil : object)];
}

// (NSPredicate) - (BOOL)evaluateWithObject:(id)object substitutionVariables:(NSDictionary<NSString *,id> *)bindings;
- (BOOL) evaluateWithObject___java_lang_Object_java_util_Map:(id) object :(NSDictionary*) bindings 
{
    return [super evaluateWithObject:(object == JAVA_NULL ? nil : object) substitutionVariables:(bindings == JAVA_NULL ? nil : bindings)];
}

// (NSObject) - (void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary<NSKeyValueChangeKey, id> *)change context:(void *)context;
- (void) observeValueForKeyPath___java_lang_String_java_lang_Object_java_util_Map_java_lang_Object:(NSString*) keyPath :(id) object :(NSDictionary*) change :(id) context 
{
    [super observeValueForKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) ofObject:(object == JAVA_NULL ? nil : object) change:(change == JAVA_NULL ? nil : change) context:(context == JAVA_NULL ? nil : context)];
}

// (NSPredicate) - (instancetype)predicateWithSubstitutionVariables:(NSDictionary<NSString *,id> *)variables;
- (instancetype) predicateWithSubstitutionVariables___java_util_Map:(NSDictionary*) variables 
{
    id re$ult = [super predicateWithSubstitutionVariables:(variables == JAVA_NULL ? nil : variables)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)removeObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String:(NSObject*) observer :(NSString*) keyPath 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath)];
}

// (NSObject) - (void)removeObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath context:(void *)context;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(id) context 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) context:(context == JAVA_NULL ? nil : context)];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValueForKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (void)setValue:(id)value forUndefinedKey:(NSString *)key;
- (void) setValueForUndefinedKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forUndefinedKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (id)valueForUndefinedKey:(NSString *)key;
- (id) valueForUndefinedKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForUndefinedKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation NSPredicate (cm_crossmobile_ios_foundation_NSPredicate)

// direct binding of: + (NSPredicate *)predicateWithFormat:(NSString *)predicateFormat argumentArray:(NSArray *)arguments;
+ (NSPredicate*) predicateWithFormat___java_lang_String_java_util_List:(NSString*) predicateFormat :(NSArray*) arguments 
{
    NSPredicate* re$ult = [NSPredicate predicateWithFormat:(predicateFormat == JAVA_NULL ? nil : predicateFormat) argumentArray:(arguments == JAVA_NULL ? nil : arguments)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (NSPredicate *)predicateWithValue:(BOOL)value;
+ (NSPredicate*) predicateWithValue___boolean:(BOOL) value 
{
    NSPredicate* re$ult = [NSPredicate predicateWithValue:value];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_foundation_NSPredicate__
{
    return [self init];
}

// direct binding of: @property(readonly, copy) NSString *predicateFormat;
- (NSString*) predicateFormat__
{
    NSString* re$ult = [self predicateFormat];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)allowEvaluation;
- (void) allowEvaluation__
{
    [self allowEvaluation];
}

// direct binding of: - (BOOL)evaluateWithObject:(id)object;
- (BOOL) evaluateWithObject___java_lang_Object:(id) object 
{
    return [self evaluateWithObject:(object == JAVA_NULL ? nil : object)];
}

// direct binding of: - (BOOL)evaluateWithObject:(id)object substitutionVariables:(NSDictionary<NSString *,id> *)bindings;
- (BOOL) evaluateWithObject___java_lang_Object_java_util_Map:(id) object :(NSDictionary*) bindings 
{
    return [self evaluateWithObject:(object == JAVA_NULL ? nil : object) substitutionVariables:(bindings == JAVA_NULL ? nil : bindings)];
}

// direct binding of: - (instancetype)predicateWithSubstitutionVariables:(NSDictionary<NSString *,id> *)variables;
- (instancetype) predicateWithSubstitutionVariables___java_util_Map:(NSDictionary*) variables 
{
    id re$ult = [self predicateWithSubstitutionVariables:(variables == JAVA_NULL ? nil : variables)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
