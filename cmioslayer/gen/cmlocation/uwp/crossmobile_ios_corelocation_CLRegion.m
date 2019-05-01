// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.corelocation.CLRegion implementation

#import "crossmobile_ios_corelocation_CLLocationCoordinate2D.h"
#import "crossmobile_ios_corelocation_CLRegion.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_corelocation_CLRegion$Ext

// (CLRegion) @property(readonly, nonatomic) CLLocationCoordinate2D center;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) center__
{
    return [[crossmobile_ios_corelocation_CLLocationCoordinate2D alloc] initWithCLLocationCoordinate2D:[super center]];
}

// (CLRegion) @property(readonly, nonatomic, copy) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [super identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (CLRegion) @property(readonly, nonatomic) CLLocationDistance radius;
- (double) radius__
{
    return [super radius];
}

// (CLRegion) - (BOOL)containsCoordinate:(CLLocationCoordinate2D)coordinate;
- (BOOL) containsCoordinate___crossmobile_ios_corelocation_CLLocationCoordinate2D:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate 
{
    return [super containsCoordinate:[coordinate getCLLocationCoordinate2D]];
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

@implementation CLRegion (cm_crossmobile_ios_corelocation_CLRegion)

// direct binding of: - (instancetype)initCircularRegionWithCenter:(CLLocationCoordinate2D)center radius:(CLLocationDistance)radius identifier:(NSString *)identifier;
- (instancetype) __init_crossmobile_ios_corelocation_CLRegion___crossmobile_ios_corelocation_CLLocationCoordinate2D_double_java_lang_String:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) center :(double) radius :(NSString*) identifier 
{
    return [self initCircularRegionWithCenter:[center getCLLocationCoordinate2D] radius:radius identifier:(identifier == JAVA_NULL ? nil : identifier)];
}

// direct binding of: @property(readonly, nonatomic) CLLocationCoordinate2D center;
- (crossmobile_ios_corelocation_CLLocationCoordinate2D*) center__
{
    return [[crossmobile_ios_corelocation_CLLocationCoordinate2D alloc] initWithCLLocationCoordinate2D:[self center]];
}

// direct binding of: @property(readonly, nonatomic, copy) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [self identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, nonatomic) CLLocationDistance radius;
- (double) radius__
{
    return [self radius];
}

// direct binding of: - (BOOL)containsCoordinate:(CLLocationCoordinate2D)coordinate;
- (BOOL) containsCoordinate___crossmobile_ios_corelocation_CLLocationCoordinate2D:(crossmobile_ios_corelocation_CLLocationCoordinate2D*) coordinate 
{
    return [self containsCoordinate:[coordinate getCLLocationCoordinate2D]];
}

@end
