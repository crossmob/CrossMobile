// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.corelocation.CLPlacemark implementation

#import "crossmobile_ios_corelocation_CLLocation.h"
#import "crossmobile_ios_corelocation_CLPlacemark.h"
#import "crossmobile_ios_corelocation_CLRegion.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_foundation_NSTimeZone.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_corelocation_CLPlacemark$Ext

// (CLPlacemark) @property(nonatomic, readonly, copy) NSString *ISOcountryCode;
- (NSString*) ISOcountryCode__
{
    NSString* re$ult = [super ISOcountryCode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CLPlacemark) @property(nonatomic, readonly, copy) NSDictionary *addressDictionary;
- (NSDictionary*) addressDictionary__
{
    NSDictionary* re$ult = [super addressDictionary];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CLPlacemark) @property(nonatomic, readonly, copy) NSString *administrativeArea;
- (NSString*) administrativeArea__
{
    NSString* re$ult = [super administrativeArea];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CLPlacemark) @property(nonatomic, readonly, copy) NSArray <NSString *> *areasOfInterest;
- (NSArray*) areasOfInterest__
{
    NSArray* re$ult = [super areasOfInterest];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CLPlacemark) @property(nonatomic, readonly, copy) NSString *country;
- (NSString*) country__
{
    NSString* re$ult = [super country];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CLPlacemark) @property(nonatomic, readonly, copy) NSString *inlandWater;
- (NSString*) inlandWater__
{
    NSString* re$ult = [super inlandWater];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CLPlacemark) @property(nonatomic, readonly, copy) NSString *locality;
- (NSString*) locality__
{
    NSString* re$ult = [super locality];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CLPlacemark) @property(nonatomic, readonly, copy) CLLocation *location;
- (CLLocation*) location__
{
    CLLocation* re$ult = [super location];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CLPlacemark) @property(nonatomic, readonly, copy) NSString *ocean;
- (NSString*) ocean__
{
    NSString* re$ult = [super ocean];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CLPlacemark) @property(nonatomic, readonly, copy) NSString *postalCode;
- (NSString*) postalCode__
{
    NSString* re$ult = [super postalCode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CLPlacemark) @property(nonatomic, readonly, copy) CLRegion *region;
- (CLRegion*) region__
{
    CLRegion* re$ult = [super region];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CLPlacemark) @property(nonatomic, readonly, copy) NSString *subAdministrativeArea;
- (NSString*) subAdministrativeArea__
{
    NSString* re$ult = [super subAdministrativeArea];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CLPlacemark) @property(nonatomic, readonly, copy) NSString *subLocality;
- (NSString*) subLocality__
{
    NSString* re$ult = [super subLocality];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CLPlacemark) @property(nonatomic, readonly, copy) NSString *subThoroughfare;
- (NSString*) subThoroughfare__
{
    NSString* re$ult = [super subThoroughfare];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CLPlacemark) @property(nonatomic, readonly, copy) NSString *thoroughfare;
- (NSString*) thoroughfare__
{
    NSString* re$ult = [super thoroughfare];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CLPlacemark) @property(nonatomic, readonly, copy) NSTimeZone *timeZone;
- (NSTimeZone*) timeZone__
{
    NSTimeZone* re$ult = [super timeZone];
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

@implementation CLPlacemark (cm_crossmobile_ios_corelocation_CLPlacemark)

// direct binding of: - (instancetype)initWithPlacemark:(CLPlacemark *)placemark;
- (instancetype) __init_crossmobile_ios_corelocation_CLPlacemark___crossmobile_ios_corelocation_CLPlacemark:(CLPlacemark*) placemark 
{
    return [self initWithPlacemark:(placemark == JAVA_NULL ? nil : placemark)];
}

// direct binding of: @property(nonatomic, readonly, copy) NSString *ISOcountryCode;
- (NSString*) ISOcountryCode__
{
    NSString* re$ult = [self ISOcountryCode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, copy) NSDictionary *addressDictionary;
- (NSDictionary*) addressDictionary__
{
    NSDictionary* re$ult = [self addressDictionary];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, copy) NSString *administrativeArea;
- (NSString*) administrativeArea__
{
    NSString* re$ult = [self administrativeArea];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, copy) NSArray <NSString *> *areasOfInterest;
- (NSArray*) areasOfInterest__
{
    NSArray* re$ult = [self areasOfInterest];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, copy) NSString *country;
- (NSString*) country__
{
    NSString* re$ult = [self country];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, copy) NSString *inlandWater;
- (NSString*) inlandWater__
{
    NSString* re$ult = [self inlandWater];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, copy) NSString *locality;
- (NSString*) locality__
{
    NSString* re$ult = [self locality];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, copy) CLLocation *location;
- (CLLocation*) location__
{
    CLLocation* re$ult = [self location];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, copy) NSString *ocean;
- (NSString*) ocean__
{
    NSString* re$ult = [self ocean];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, copy) NSString *postalCode;
- (NSString*) postalCode__
{
    NSString* re$ult = [self postalCode];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, copy) CLRegion *region;
- (CLRegion*) region__
{
    CLRegion* re$ult = [self region];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, copy) NSString *subAdministrativeArea;
- (NSString*) subAdministrativeArea__
{
    NSString* re$ult = [self subAdministrativeArea];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, copy) NSString *subLocality;
- (NSString*) subLocality__
{
    NSString* re$ult = [self subLocality];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, copy) NSString *subThoroughfare;
- (NSString*) subThoroughfare__
{
    NSString* re$ult = [self subThoroughfare];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, copy) NSString *thoroughfare;
- (NSString*) thoroughfare__
{
    NSString* re$ult = [self thoroughfare];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, copy) NSTimeZone *timeZone;
- (NSTimeZone*) timeZone__
{
    NSTimeZone* re$ult = [self timeZone];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
