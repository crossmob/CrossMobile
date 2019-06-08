// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.storekit.SKPaymentQueue implementation

#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_storekit_SKPayment.h"
#import "crossmobile_ios_storekit_SKPaymentQueue.h"
#import "crossmobile_ios_storekit_SKPaymentTransaction.h"
#import "crossmobile_ios_storekit_SKPaymentTransactionObserver.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_storekit_SKPaymentQueue$Ext

// (SKPaymentQueue) @property(nonatomic, readonly) NSArray<SKPaymentTransaction *> *transactions;
- (NSArray*) transactions__
{
    NSArray* re$ult = [super transactions];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
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
