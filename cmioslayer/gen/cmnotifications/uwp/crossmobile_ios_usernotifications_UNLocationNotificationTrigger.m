// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.usernotifications.UNLocationNotificationTrigger implementation

#import "crossmobile_ios_corelocation_CLRegion.h"
#import "crossmobile_ios_usernotifications_UNLocationNotificationTrigger.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_usernotifications_UNLocationNotificationTrigger$Ext

// (UNLocationNotificationTrigger) @property(readonly, copy, nonatomic) CLRegion *region;
- (CLRegion*) region__
{
    CLRegion* re$ult = [super region];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNNotificationTrigger) @property(readonly, nonatomic) BOOL repeats;
- (BOOL) repeats__
{
    return [super repeats];
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

@implementation UNLocationNotificationTrigger (cm_crossmobile_ios_usernotifications_UNLocationNotificationTrigger)

// direct binding of: + (instancetype)triggerWithRegion:(CLRegion *)region repeats:(BOOL)repeats;
+ (instancetype) triggerWithRegion___crossmobile_ios_corelocation_CLRegion_boolean:(CLRegion*) region :(BOOL) repeats 
{
    id re$ult = [UNLocationNotificationTrigger triggerWithRegion:(region == JAVA_NULL ? nil : region) repeats:repeats];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) CLRegion *region;
- (CLRegion*) region__
{
    CLRegion* re$ult = [self region];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
