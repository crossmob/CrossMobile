// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.storekit.SKProductsRequest implementation

#import "crossmobile_ios_storekit_SKProductsRequest.h"
#import "crossmobile_ios_storekit_SKRequestDelegate.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Set.h"

@implementation crossmobile_ios_storekit_SKProductsRequest$Ext

// (SKRequest) @property(nonatomic, assign) id<SKRequestDelegate> delegate;
- (void) setDelegate___crossmobile_ios_storekit_SKRequestDelegate:(id<SKRequestDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [super setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// (SKRequest) @property(nonatomic, assign) id<SKRequestDelegate> delegate;
- (id<SKRequestDelegate>) delegate__
{
    id<SKRequestDelegate> re$ult = [super delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (SKRequest) - (void)cancel;
- (void) cancel__
{
    [super cancel];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (SKRequest) - (void)start;
- (void) start__
{
    [super start];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation SKProductsRequest (cm_crossmobile_ios_storekit_SKProductsRequest)

// direct binding of: - (instancetype)initWithProductIdentifiers:(NSSet<NSString *> *)productIdentifiers;
- (instancetype) __init_crossmobile_ios_storekit_SKProductsRequest___java_util_Set:(NSSet*) productIdentifiers 
{
    return [self initWithProductIdentifiers:(productIdentifiers == JAVA_NULL ? nil : productIdentifiers)];
}

// direct binding of: @property(nonatomic, assign) id<SKProductsRequestDelegate> delegate;
- (void) setDelegate___crossmobile_ios_storekit_SKProductsRequestDelegate:(id<SKProductsRequestDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// direct binding of: @property(nonatomic, assign) id<SKProductsRequestDelegate> delegate;
- (id<SKProductsRequestDelegate>) productsDelegate__
{
    id<SKProductsRequestDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
