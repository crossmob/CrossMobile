// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.NSLayoutYAxisAnchor implementation

#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_uikit_NSLayoutAnchor.h"
#import "crossmobile_ios_uikit_NSLayoutConstraint.h"
#import "crossmobile_ios_uikit_NSLayoutYAxisAnchor.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_uikit_NSLayoutYAxisAnchor$Ext

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (NSLayoutAnchor) - (NSLayoutConstraint *)constraintEqualToAnchor:(NSLayoutAnchor *)anchor;
- (NSLayoutConstraint*) constraintEqualToAnchor___crossmobile_ios_uikit_NSLayoutAnchor:(NSLayoutAnchor*) anchor 
{
    NSLayoutConstraint* re$ult = [super constraintEqualToAnchor:(anchor == JAVA_NULL ? nil : anchor)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSLayoutAnchor) - (NSLayoutConstraint *)constraintEqualToAnchor:(NSLayoutAnchor *)anchor constant:(CGFloat)c;
- (NSLayoutConstraint*) constraintEqualToAnchor___crossmobile_ios_uikit_NSLayoutAnchor_double:(NSLayoutAnchor*) anchor :(double) c 
{
    NSLayoutConstraint* re$ult = [super constraintEqualToAnchor:(anchor == JAVA_NULL ? nil : anchor) constant:c];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSLayoutAnchor) - (NSLayoutConstraint *)constraintGreaterThanOrEqualToAnchor:(NSLayoutAnchor *)anchor;
- (NSLayoutConstraint*) constraintGreaterThanOrEqualToAnchor___crossmobile_ios_uikit_NSLayoutAnchor:(NSLayoutAnchor*) anchor 
{
    NSLayoutConstraint* re$ult = [super constraintGreaterThanOrEqualToAnchor:(anchor == JAVA_NULL ? nil : anchor)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSLayoutAnchor) - (NSLayoutConstraint *)constraintGreaterThanOrEqualToAnchor:(NSLayoutAnchor *)anchor constant:(CGFloat)c;
- (NSLayoutConstraint*) constraintGreaterThanOrEqualToAnchor___crossmobile_ios_uikit_NSLayoutAnchor_double:(NSLayoutAnchor*) anchor :(double) c 
{
    NSLayoutConstraint* re$ult = [super constraintGreaterThanOrEqualToAnchor:(anchor == JAVA_NULL ? nil : anchor) constant:c];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSLayoutAnchor) - (NSLayoutConstraint *)constraintLessThanOrEqualToAnchor:(NSLayoutAnchor *)anchor;
- (NSLayoutConstraint*) constraintLessThanOrEqualToAnchor___crossmobile_ios_uikit_NSLayoutAnchor:(NSLayoutAnchor*) anchor 
{
    NSLayoutConstraint* re$ult = [super constraintLessThanOrEqualToAnchor:(anchor == JAVA_NULL ? nil : anchor)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSLayoutAnchor) - (NSLayoutConstraint *)constraintLessThanOrEqualToAnchor:(NSLayoutAnchor *)anchor constant:(CGFloat)c;
- (NSLayoutConstraint*) constraintLessThanOrEqualToAnchor___crossmobile_ios_uikit_NSLayoutAnchor_double:(NSLayoutAnchor*) anchor :(double) c 
{
    NSLayoutConstraint* re$ult = [super constraintLessThanOrEqualToAnchor:(anchor == JAVA_NULL ? nil : anchor) constant:c];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary<NSKeyValueChangeKey, id> *)change context:(void *)context;
- (void) observeValueForKeyPath___java_lang_String_java_lang_Object_java_util_Map_java_lang_Object:(NSString*) keyPath :(id) object :(NSDictionary*) change :(id) context 
{
    [super observeValueForKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) ofObject:(object == JAVA_NULL ? nil : object) change:(change == JAVA_NULL ? nil : change) context:(context == JAVA_NULL ? nil : context)];
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

@implementation NSLayoutYAxisAnchor (cm_crossmobile_ios_uikit_NSLayoutYAxisAnchor)

@end
