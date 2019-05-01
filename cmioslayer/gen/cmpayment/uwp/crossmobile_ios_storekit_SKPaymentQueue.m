// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.storekit.SKPaymentQueue implementation

#import "crossmobile_ios_storekit_SKPayment.h"
#import "crossmobile_ios_storekit_SKPaymentQueue.h"
#import "crossmobile_ios_storekit_SKPaymentTransaction.h"
#import "crossmobile_ios_storekit_SKPaymentTransactionObserver.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_storekit_SKPaymentQueue$Ext

// (SKPaymentQueue) @property(nonatomic, readonly) NSArray<SKPaymentTransaction *> *transactions;
- (NSArray*) transactions__
{
    NSArray* re$ult = [super transactions];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (SKPaymentQueue) - (void)addPayment:(SKPayment *)payment;
- (void) addPayment___crossmobile_ios_storekit_SKPayment:(SKPayment*) payment 
{
    [super addPayment:(payment == JAVA_NULL ? nil : payment)];
}

// (SKPaymentQueue) - (void)addTransactionObserver:(id<SKPaymentTransactionObserver>)observer;
- (void) addTransactionObserver___crossmobile_ios_storekit_SKPaymentTransactionObserver:(id<SKPaymentTransactionObserver>) observer 
{
    [super addTransactionObserver:(observer == JAVA_NULL ? nil : observer)];
}

// (SKPaymentQueue) - (void)finishTransaction:(SKPaymentTransaction *)transaction;
- (void) finishTransaction___crossmobile_ios_storekit_SKPaymentTransaction:(SKPaymentTransaction*) transaction 
{
    [super finishTransaction:(transaction == JAVA_NULL ? nil : transaction)];
}

// (SKPaymentQueue) - (void)removeTransactionObserver:(id<SKPaymentTransactionObserver>)observer;
- (void) removeTransactionObserver___crossmobile_ios_storekit_SKPaymentTransactionObserver:(id<SKPaymentTransactionObserver>) observer 
{
    [super removeTransactionObserver:(observer == JAVA_NULL ? nil : observer)];
}

// (SKPaymentQueue) - (void)restoreCompletedTransactions;
- (void) restoreCompletedTransactions__
{
    [super restoreCompletedTransactions];
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

@implementation SKPaymentQueue (cm_crossmobile_ios_storekit_SKPaymentQueue)

// direct binding of: + (BOOL)canMakePayments;
+ (BOOL) canMakePayments__
{
    return [SKPaymentQueue canMakePayments];
}

// direct binding of: + (instancetype)defaultQueue;
+ (instancetype) defaultQueue__
{
    id re$ult = [SKPaymentQueue defaultQueue];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) NSArray<SKPaymentTransaction *> *transactions;
- (NSArray*) transactions__
{
    NSArray* re$ult = [self transactions];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)addPayment:(SKPayment *)payment;
- (void) addPayment___crossmobile_ios_storekit_SKPayment:(SKPayment*) payment 
{
    [self addPayment:(payment == JAVA_NULL ? nil : payment)];
}

// direct binding of: - (void)addTransactionObserver:(id<SKPaymentTransactionObserver>)observer;
- (void) addTransactionObserver___crossmobile_ios_storekit_SKPaymentTransactionObserver:(id<SKPaymentTransactionObserver>) observer 
{
    [self addTransactionObserver:(observer == JAVA_NULL ? nil : observer)];
}

// direct binding of: - (void)finishTransaction:(SKPaymentTransaction *)transaction;
- (void) finishTransaction___crossmobile_ios_storekit_SKPaymentTransaction:(SKPaymentTransaction*) transaction 
{
    [self finishTransaction:(transaction == JAVA_NULL ? nil : transaction)];
}

// direct binding of: - (void)removeTransactionObserver:(id<SKPaymentTransactionObserver>)observer;
- (void) removeTransactionObserver___crossmobile_ios_storekit_SKPaymentTransactionObserver:(id<SKPaymentTransactionObserver>) observer 
{
    [self removeTransactionObserver:(observer == JAVA_NULL ? nil : observer)];
}

// direct binding of: - (void)restoreCompletedTransactions;
- (void) restoreCompletedTransactions__
{
    [self restoreCompletedTransactions];
}

@end
