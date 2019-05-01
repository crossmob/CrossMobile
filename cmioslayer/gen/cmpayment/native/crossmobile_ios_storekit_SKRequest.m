// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.storekit.SKRequest implementation

#import "crossmobile_ios_storekit_SKRequest.h"
#import "crossmobile_ios_storekit_SKRequestDelegate.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_storekit_SKRequest$Ext

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

@implementation SKRequest (cm_crossmobile_ios_storekit_SKRequest)

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_storekit_SKRequest__
{
    return [self init];
}

// direct binding of: @property(nonatomic, assign) id<SKRequestDelegate> delegate;
- (void) setDelegate___crossmobile_ios_storekit_SKRequestDelegate:(id<SKRequestDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// direct binding of: @property(nonatomic, assign) id<SKRequestDelegate> delegate;
- (id<SKRequestDelegate>) delegate__
{
    id<SKRequestDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)cancel;
- (void) cancel__
{
    [self cancel];
}

// direct binding of: - (void)start;
- (void) start__
{
    [self start];
}

@end
