// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.usernotifications.UNCalendarNotificationTrigger implementation

#import "crossmobile_ios_foundation_NSDate.h"
#import "crossmobile_ios_foundation_NSDateComponents.h"
#import "crossmobile_ios_usernotifications_UNCalendarNotificationTrigger.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_usernotifications_UNCalendarNotificationTrigger$Ext

// (UNCalendarNotificationTrigger) @property(readonly, copy, nonatomic) NSDateComponents *dateComponents;
- (NSDateComponents*) dateComponents__
{
    NSDateComponents* re$ult = [super dateComponents];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNNotificationTrigger) @property(readonly, nonatomic) BOOL repeats;
- (BOOL) repeats__
{
    return [super repeats];
}

// (UNCalendarNotificationTrigger) - (NSDate *)nextTriggerDate;
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

@implementation UNCalendarNotificationTrigger (cm_crossmobile_ios_usernotifications_UNCalendarNotificationTrigger)

// direct binding of: + (instancetype)triggerWithDateMatchingComponents:(NSDateComponents *)dateComponents repeats:(BOOL)repeats;
+ (instancetype) triggerWithDateMatchingComponents___crossmobile_ios_foundation_NSDateComponents_boolean:(NSDateComponents*) dateComponents :(BOOL) repeats 
{
    id re$ult = [UNCalendarNotificationTrigger triggerWithDateMatchingComponents:(dateComponents == JAVA_NULL ? nil : dateComponents) repeats:repeats];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSDateComponents *dateComponents;
- (NSDateComponents*) dateComponents__
{
    NSDateComponents* re$ult = [self dateComponents];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (NSDate *)nextTriggerDate;
- (NSDate*) nextTriggerDate__
{
    NSDate* re$ult = [self nextTriggerDate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
