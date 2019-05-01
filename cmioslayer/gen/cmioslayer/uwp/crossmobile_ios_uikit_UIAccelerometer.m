// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIAccelerometer implementation

#import "crossmobile_ios_uikit_UIAccelerometer.h"
#import "crossmobile_ios_uikit_UIAccelerometerDelegate.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_uikit_UIAccelerometer$Ext

// (UIAccelerometer) @property(nonatomic, weak) id<UIAccelerometerDelegate> delegate;
- (void) setDelegate___crossmobile_ios_uikit_UIAccelerometerDelegate:(id<UIAccelerometerDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [super setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// (UIAccelerometer) @property(nonatomic) NSTimeInterval updateInterval;
- (void) setUpdateInterval___double:(double) updateInterval 
{
    [super setUpdateInterval:updateInterval];
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

@implementation UIAccelerometer (cm_crossmobile_ios_uikit_UIAccelerometer)

// direct binding of: + (UIAccelerometer *)sharedAccelerometer;
+ (UIAccelerometer*) sharedAccelerometer__
{
    UIAccelerometer* re$ult = [UIAccelerometer sharedAccelerometer];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, weak) id<UIAccelerometerDelegate> delegate;
- (void) setDelegate___crossmobile_ios_uikit_UIAccelerometerDelegate:(id<UIAccelerometerDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// direct binding of: @property(nonatomic) NSTimeInterval updateInterval;
- (void) setUpdateInterval___double:(double) updateInterval 
{
    [self setUpdateInterval:updateInterval];
}

@end
