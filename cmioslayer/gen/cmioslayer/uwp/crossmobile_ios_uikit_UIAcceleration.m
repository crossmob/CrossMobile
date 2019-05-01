// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIAcceleration implementation

#import "crossmobile_ios_uikit_UIAcceleration.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_uikit_UIAcceleration$Ext

// (UIAcceleration) @property(nonatomic, readonly) NSTimeInterval timestamp;
- (double) timestamp__
{
    return [super timestamp];
}

// (UIAcceleration) @property(nonatomic, readonly) UIAccelerationValue x;
- (double) x__
{
    return [super x];
}

// (UIAcceleration) @property(nonatomic, readonly) UIAccelerationValue y;
- (double) y__
{
    return [super y];
}

// (UIAcceleration) @property(nonatomic, readonly) UIAccelerationValue z;
- (double) z__
{
    return [super z];
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

@implementation UIAcceleration (cm_crossmobile_ios_uikit_UIAcceleration)

// direct binding of: @property(nonatomic, readonly) NSTimeInterval timestamp;
- (double) timestamp__
{
    return [self timestamp];
}

// direct binding of: @property(nonatomic, readonly) UIAccelerationValue x;
- (double) x__
{
    return [self x];
}

// direct binding of: @property(nonatomic, readonly) UIAccelerationValue y;
- (double) y__
{
    return [self y];
}

// direct binding of: @property(nonatomic, readonly) UIAccelerationValue z;
- (double) z__
{
    return [self z];
}

@end
