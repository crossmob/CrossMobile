// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.usernotifications.UNTimeIntervalNotificationTrigger implementation

#import "crossmobile_ios_foundation_NSDate.h"
#import "crossmobile_ios_usernotifications_UNTimeIntervalNotificationTrigger.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_usernotifications_UNTimeIntervalNotificationTrigger$Ext

// (UNNotificationTrigger) @property(readonly, nonatomic) BOOL repeats;
- (BOOL) repeats__
{
    return [super repeats];
}

// (UNTimeIntervalNotificationTrigger) @property(readonly, nonatomic) NSTimeInterval timeInterval;
- (double) timeInterval__
{
    return [super timeInterval];
}

// (UNTimeIntervalNotificationTrigger) - (NSDate *)nextTriggerDate;
- (NSDate*) nextTriggerDate__
{
    NSDate* re$ult = [super nextTriggerDate];
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

@implementation UNTimeIntervalNotificationTrigger (cm_crossmobile_ios_usernotifications_UNTimeIntervalNotificationTrigger)

// direct binding of: + (instancetype)triggerWithTimeInterval:(NSTimeInterval)timeInterval repeats:(BOOL)repeats;
+ (instancetype) triggerWithTimeInterval___double_boolean:(double) timeInterval :(BOOL) repeats 
{
    id re$ult = [UNTimeIntervalNotificationTrigger triggerWithTimeInterval:timeInterval repeats:repeats];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, nonatomic) NSTimeInterval timeInterval;
- (double) timeInterval__
{
    return [self timeInterval];
}

// direct binding of: - (NSDate *)nextTriggerDate;
- (NSDate*) nextTriggerDate__
{
    NSDate* re$ult = [self nextTriggerDate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
