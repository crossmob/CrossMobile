// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.storekit.SKMutablePayment implementation

#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_storekit_SKMutablePayment.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_storekit_SKMutablePayment$Ext

// (SKMutablePayment) @property(nonatomic, copy, readwrite) NSString *productIdentifier;
- (void) setProductIdentifier___java_lang_String:(NSString*) productIdentifier 
{
    [super setProductIdentifier:(productIdentifier == JAVA_NULL ? nil : productIdentifier)];
}

// (SKPayment) @property(nonatomic, copy, readonly) NSString *productIdentifier;
- (NSString*) productIdentifier__
{
    NSString* re$ult = [super productIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (SKMutablePayment) @property(nonatomic, readwrite) NSInteger quantity;
- (void) setQuantity___int:(int) quantity 
{
    [super setQuantity:quantity];
}

// (SKPayment) @property(nonatomic, readonly) NSInteger quantity;
- (int) quantity__
{
    return [super quantity];
}

// (SKMutablePayment) @property(nonatomic, copy, readwrite) NSData *requestData;
- (void) setRequestData___crossmobile_ios_foundation_NSData:(NSData*) requestData 
{
    [super setRequestData:(requestData == JAVA_NULL ? nil : requestData)];
}

// (SKPayment) @property(nonatomic, copy, readonly) NSData *requestData;
- (NSData*) requestData__
{
    NSData* re$ult = [super requestData];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
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

@implementation SKMutablePayment (cm_crossmobile_ios_storekit_SKMutablePayment)

// direct binding of: @property(nonatomic, copy, readwrite) NSString *productIdentifier;
- (void) setProductIdentifier___java_lang_String:(NSString*) productIdentifier 
{
    [self setProductIdentifier:(productIdentifier == JAVA_NULL ? nil : productIdentifier)];
}

// direct binding of: @property(nonatomic, readwrite) NSInteger quantity;
- (void) setQuantity___int:(int) quantity 
{
    [self setQuantity:quantity];
}

// direct binding of: @property(nonatomic, copy, readwrite) NSData *requestData;
- (void) setRequestData___crossmobile_ios_foundation_NSData:(NSData*) requestData 
{
    [self setRequestData:(requestData == JAVA_NULL ? nil : requestData)];
}

@end
