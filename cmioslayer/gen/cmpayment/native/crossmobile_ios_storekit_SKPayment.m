// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.storekit.SKPayment implementation

#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_storekit_SKPayment.h"
#import "crossmobile_ios_storekit_SKProduct.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_storekit_SKPayment$Ext

// (SKPayment) @property(nonatomic, copy, readonly) NSString *productIdentifier;
- (NSString*) productIdentifier__
{
    NSString* re$ult = [super productIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (SKPayment) @property(nonatomic, readonly) NSInteger quantity;
- (int) quantity__
{
    return [super quantity];
}

// (SKPayment) @property(nonatomic, copy, readonly) NSData *requestData;
- (NSData*) requestData__
{
    NSData* re$ult = [super requestData];
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

@implementation SKPayment (cm_crossmobile_ios_storekit_SKPayment)

// direct binding of: + (instancetype)paymentWithProduct:(SKProduct *)product;
+ (instancetype) paymentWithProduct___crossmobile_ios_storekit_SKProduct:(SKProduct*) product 
{
    id re$ult = [SKPayment paymentWithProduct:(product == JAVA_NULL ? nil : product)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, copy, readonly) NSString *productIdentifier;
- (NSString*) productIdentifier__
{
    NSString* re$ult = [self productIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) NSInteger quantity;
- (int) quantity__
{
    return [self quantity];
}

// direct binding of: @property(nonatomic, copy, readonly) NSData *requestData;
- (NSData*) requestData__
{
    NSData* re$ult = [self requestData];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
