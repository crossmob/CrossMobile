// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.storekit.SKPaymentTransaction implementation

#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSDate.h"
#import "crossmobile_ios_foundation_NSError.h"
#import "crossmobile_ios_storekit_SKPayment.h"
#import "crossmobile_ios_storekit_SKPaymentTransaction.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_storekit_SKPaymentTransaction$Ext

// (SKPaymentTransaction) @property(nonatomic, readonly) NSError *error;
- (NSError*) error__
{
    NSError* re$ult = [super error];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (SKPaymentTransaction) @property(nonatomic, readonly) SKPaymentTransaction *originalTransaction;
- (SKPaymentTransaction*) originalTransaction__
{
    SKPaymentTransaction* re$ult = [super originalTransaction];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (SKPaymentTransaction) @property(nonatomic, readonly) SKPayment *payment;
- (SKPayment*) payment__
{
    SKPayment* re$ult = [super payment];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (SKPaymentTransaction) @property(nonatomic, readonly) NSDate *transactionDate;
- (NSDate*) transactionDate__
{
    NSDate* re$ult = [super transactionDate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (SKPaymentTransaction) @property(nonatomic, readonly) NSString *transactionIdentifier;
- (NSString*) transactionIdentifier__
{
    NSString* re$ult = [super transactionIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (SKPaymentTransaction) @property(nonatomic, readonly) NSData *transactionReceipt;
- (NSData*) transactionReceipt__
{
    NSData* re$ult = [super transactionReceipt];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (SKPaymentTransaction) @property(nonatomic, readonly) SKPaymentTransactionState transactionState;
- (int) transactionState__
{
    return [super transactionState];
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

@implementation SKPaymentTransaction (cm_crossmobile_ios_storekit_SKPaymentTransaction)

// direct binding of: @property(nonatomic, readonly) NSError *error;
- (NSError*) error__
{
    NSError* re$ult = [self error];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) SKPaymentTransaction *originalTransaction;
- (SKPaymentTransaction*) originalTransaction__
{
    SKPaymentTransaction* re$ult = [self originalTransaction];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) SKPayment *payment;
- (SKPayment*) payment__
{
    SKPayment* re$ult = [self payment];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) NSDate *transactionDate;
- (NSDate*) transactionDate__
{
    NSDate* re$ult = [self transactionDate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) NSString *transactionIdentifier;
- (NSString*) transactionIdentifier__
{
    NSString* re$ult = [self transactionIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) NSData *transactionReceipt;
- (NSData*) transactionReceipt__
{
    NSData* re$ult = [self transactionReceipt];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) SKPaymentTransactionState transactionState;
- (int) transactionState__
{
    return [self transactionState];
}

@end
