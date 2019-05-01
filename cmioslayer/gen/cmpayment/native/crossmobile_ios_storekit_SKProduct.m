// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.storekit.SKProduct implementation

#import "crossmobile_ios_foundation_NSLocale.h"
#import "crossmobile_ios_storekit_SKProduct.h"
#import "java_lang_Number.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_storekit_SKProduct$Ext

// (SKProduct) @property(nonatomic, readonly) NSString *localizedDescription;
- (NSString*) localizedDescription__
{
    NSString* re$ult = [super localizedDescription];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (SKProduct) @property(nonatomic, readonly) NSString *localizedTitle;
- (NSString*) localizedTitle__
{
    NSString* re$ult = [super localizedTitle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (SKProduct) @property(nonatomic, readonly) NSDecimalNumber *price;
- (java_lang_Number*) price__
{
    java_lang_Number* re$ult = [super price];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (SKProduct) @property(nonatomic, readonly) NSLocale *priceLocale;
- (NSLocale*) priceLocale__
{
    NSLocale* re$ult = [super priceLocale];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (SKProduct) @property(nonatomic, readonly) NSString *productIdentifier;
- (NSString*) productIdentifier__
{
    NSString* re$ult = [super productIdentifier];
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

@implementation SKProduct (cm_crossmobile_ios_storekit_SKProduct)

// direct binding of: @property(nonatomic, readonly) NSString *localizedDescription;
- (NSString*) localizedDescription__
{
    NSString* re$ult = [self localizedDescription];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) NSString *localizedTitle;
- (NSString*) localizedTitle__
{
    NSString* re$ult = [self localizedTitle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) NSDecimalNumber *price;
- (java_lang_Number*) price__
{
    java_lang_Number* re$ult = [self price];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) NSLocale *priceLocale;
- (NSLocale*) priceLocale__
{
    NSLocale* re$ult = [self priceLocale];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) NSString *productIdentifier;
- (NSString*) productIdentifier__
{
    NSString* re$ult = [self productIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
