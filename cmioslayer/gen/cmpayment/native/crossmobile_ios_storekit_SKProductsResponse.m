// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.storekit.SKProductsResponse implementation

#import "crossmobile_ios_storekit_SKProductsResponse.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_storekit_SKProductsResponse$Ext

// (SKProductsResponse) @property(nonatomic, readonly) NSArray<NSString *> *invalidProductIdentifiers;
- (NSArray*) invalidProductIdentifiers__
{
    NSArray* re$ult = [super invalidProductIdentifiers];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (SKProductsResponse) @property(nonatomic, readonly) NSArray<SKProduct *> *products;
- (NSArray*) products__
{
    NSArray* re$ult = [super products];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation SKProductsResponse (cm_crossmobile_ios_storekit_SKProductsResponse)

// direct binding of: @property(nonatomic, readonly) NSArray<NSString *> *invalidProductIdentifiers;
- (NSArray*) invalidProductIdentifiers__
{
    NSArray* re$ult = [self invalidProductIdentifiers];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) NSArray<SKProduct *> *products;
- (NSArray*) products__
{
    NSArray* re$ult = [self products];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
