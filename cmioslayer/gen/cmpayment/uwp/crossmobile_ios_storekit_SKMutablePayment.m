// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.storekit.SKMutablePayment implementation

#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_storekit_SKMutablePayment.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

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
