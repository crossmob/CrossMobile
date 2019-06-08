// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UILocalNotification implementation

#import "crossmobile_ios_foundation_NSCalendar.h"
#import "crossmobile_ios_foundation_NSDate.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_foundation_NSTimeZone.h"
#import "crossmobile_ios_uikit_UILocalNotification.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_uikit_UILocalNotification$Ext

// (UILocalNotification) @property(nonatomic, copy) NSString *alertAction;
- (void) setAlertAction___java_lang_String:(NSString*) alertAction 
{
    [super setAlertAction:(alertAction == JAVA_NULL ? nil : alertAction)];
}

// (UILocalNotification) @property(nonatomic, copy) NSString *alertAction;
- (NSString*) alertAction__
{
    NSString* re$ult = [super alertAction];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UILocalNotification) @property(nonatomic, copy) NSString *alertBody;
- (void) setAlertBody___java_lang_String:(NSString*) alertBody 
{
    [super setAlertBody:(alertBody == JAVA_NULL ? nil : alertBody)];
}

// (UILocalNotification) @property(nonatomic, copy) NSString *alertBody;
- (NSString*) alertBody__
{
    NSString* re$ult = [super alertBody];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UILocalNotification) @property(nonatomic, copy) NSString *alertLaunchImage;
- (void) setAlertLaunchImage___java_lang_String:(NSString*) alertLaunchImage 
{
    [super setAlertLaunchImage:(alertLaunchImage == JAVA_NULL ? nil : alertLaunchImage)];
}

// (UILocalNotification) @property(nonatomic, copy) NSString *alertLaunchImage;
- (NSString*) alertLaunchImage__
{
    NSString* re$ult = [super alertLaunchImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UILocalNotification) @property(nonatomic) NSInteger applicationIconBadgeNumber;
- (void) setApplicationIconBadgeNumber___int:(int) applicationIconBadgeNumber 
{
    [super setApplicationIconBadgeNumber:applicationIconBadgeNumber];
}

// (UILocalNotification) @property(nonatomic) NSInteger applicationIconBadgeNumber;
- (int) applicationIconBadgeNumber__
{
    return [super applicationIconBadgeNumber];
}

// (UILocalNotification) @property(nonatomic, copy) NSDate *fireDate;
- (void) setFireDate___crossmobile_ios_foundation_NSDate:(NSDate*) fireDate 
{
    [super setFireDate:(fireDate == JAVA_NULL ? nil : fireDate)];
}

// (UILocalNotification) @property(nonatomic, copy) NSDate *fireDate;
- (NSDate*) fireDate__
{
    NSDate* re$ult = [super fireDate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UILocalNotification) @property(nonatomic) BOOL hasAction;
- (void) setHasAction___boolean:(BOOL) hasAction 
{
    [super setHasAction:hasAction];
}

// (UILocalNotification) @property(nonatomic) BOOL hasAction;
- (BOOL) hasAction__
{
    return [super hasAction];
}

// (UILocalNotification) @property(nonatomic, copy) NSCalendar *repeatCalendar;
- (void) setRepeatCalendar___crossmobile_ios_foundation_NSCalendar:(NSCalendar*) repeatCalendar 
{
    [super setRepeatCalendar:(repeatCalendar == JAVA_NULL ? nil : repeatCalendar)];
}

// (UILocalNotification) @property(nonatomic, copy) NSCalendar *repeatCalendar;
- (NSCalendar*) repeatCalendar__
{
    NSCalendar* re$ult = [super repeatCalendar];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UILocalNotification) @property(nonatomic) NSCalendarUnit repeatInterval;
- (void) setRepeatInterval___int:(int) repeatInterval 
{
    [super setRepeatInterval:repeatInterval];
}

// (UILocalNotification) @property(nonatomic) NSCalendarUnit repeatInterval;
- (int) repeatInterval__
{
    return [super repeatInterval];
}

// (UILocalNotification) @property(nonatomic, copy) NSString *soundName;
- (void) setSoundName___java_lang_String:(NSString*) soundName 
{
    [super setSoundName:(soundName == JAVA_NULL ? nil : soundName)];
}

// (UILocalNotification) @property(nonatomic, copy) NSString *soundName;
- (NSString*) soundName__
{
    NSString* re$ult = [super soundName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UILocalNotification) @property(nonatomic, copy) NSTimeZone *timeZone;
- (void) setTimeZone___crossmobile_ios_foundation_NSTimeZone:(NSTimeZone*) timeZone 
{
    [super setTimeZone:(timeZone == JAVA_NULL ? nil : timeZone)];
}

// (UILocalNotification) @property(nonatomic, copy) NSTimeZone *timeZone;
- (NSTimeZone*) timeZone__
{
    NSTimeZone* re$ult = [super timeZone];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UILocalNotification) @property(nonatomic, copy) NSDictionary *userInfo;
- (void) setUserInfo___java_util_Map:(NSDictionary*) userInfo 
{
    [super setUserInfo:(userInfo == JAVA_NULL ? nil : userInfo)];
}

// (UILocalNotification) @property(nonatomic, copy) NSDictionary *userInfo;
- (NSDictionary*) userInfo__
{
    NSDictionary* re$ult = [super userInfo];
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

@implementation UILocalNotification (cm_crossmobile_ios_uikit_UILocalNotification)

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UILocalNotification__
{
    return [self init];
}

// direct binding of: @property(nonatomic, copy) NSString *alertAction;
- (void) setAlertAction___java_lang_String:(NSString*) alertAction 
{
    [self setAlertAction:(alertAction == JAVA_NULL ? nil : alertAction)];
}

// direct binding of: @property(nonatomic, copy) NSString *alertAction;
- (NSString*) alertAction__
{
    NSString* re$ult = [self alertAction];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, copy) NSString *alertBody;
- (void) setAlertBody___java_lang_String:(NSString*) alertBody 
{
    [self setAlertBody:(alertBody == JAVA_NULL ? nil : alertBody)];
}

// direct binding of: @property(nonatomic, copy) NSString *alertBody;
- (NSString*) alertBody__
{
    NSString* re$ult = [self alertBody];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, copy) NSString *alertLaunchImage;
- (void) setAlertLaunchImage___java_lang_String:(NSString*) alertLaunchImage 
{
    [self setAlertLaunchImage:(alertLaunchImage == JAVA_NULL ? nil : alertLaunchImage)];
}

// direct binding of: @property(nonatomic, copy) NSString *alertLaunchImage;
- (NSString*) alertLaunchImage__
{
    NSString* re$ult = [self alertLaunchImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic) NSInteger applicationIconBadgeNumber;
- (void) setApplicationIconBadgeNumber___int:(int) applicationIconBadgeNumber 
{
    [self setApplicationIconBadgeNumber:applicationIconBadgeNumber];
}

// direct binding of: @property(nonatomic) NSInteger applicationIconBadgeNumber;
- (int) applicationIconBadgeNumber__
{
    return [self applicationIconBadgeNumber];
}

// direct binding of: @property(nonatomic, copy) NSDate *fireDate;
- (void) setFireDate___crossmobile_ios_foundation_NSDate:(NSDate*) fireDate 
{
    [self setFireDate:(fireDate == JAVA_NULL ? nil : fireDate)];
}

// direct binding of: @property(nonatomic, copy) NSDate *fireDate;
- (NSDate*) fireDate__
{
    NSDate* re$ult = [self fireDate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic) BOOL hasAction;
- (void) setHasAction___boolean:(BOOL) hasAction 
{
    [self setHasAction:hasAction];
}

// direct binding of: @property(nonatomic) BOOL hasAction;
- (BOOL) hasAction__
{
    return [self hasAction];
}

// direct binding of: @property(nonatomic, copy) NSCalendar *repeatCalendar;
- (void) setRepeatCalendar___crossmobile_ios_foundation_NSCalendar:(NSCalendar*) repeatCalendar 
{
    [self setRepeatCalendar:(repeatCalendar == JAVA_NULL ? nil : repeatCalendar)];
}

// direct binding of: @property(nonatomic, copy) NSCalendar *repeatCalendar;
- (NSCalendar*) repeatCalendar__
{
    NSCalendar* re$ult = [self repeatCalendar];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic) NSCalendarUnit repeatInterval;
- (void) setRepeatInterval___int:(int) repeatInterval 
{
    [self setRepeatInterval:repeatInterval];
}

// direct binding of: @property(nonatomic) NSCalendarUnit repeatInterval;
- (int) repeatInterval__
{
    return [self repeatInterval];
}

// direct binding of: @property(nonatomic, copy) NSString *soundName;
- (void) setSoundName___java_lang_String:(NSString*) soundName 
{
    [self setSoundName:(soundName == JAVA_NULL ? nil : soundName)];
}

// direct binding of: @property(nonatomic, copy) NSString *soundName;
- (NSString*) soundName__
{
    NSString* re$ult = [self soundName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, copy) NSTimeZone *timeZone;
- (void) setTimeZone___crossmobile_ios_foundation_NSTimeZone:(NSTimeZone*) timeZone 
{
    [self setTimeZone:(timeZone == JAVA_NULL ? nil : timeZone)];
}

// direct binding of: @property(nonatomic, copy) NSTimeZone *timeZone;
- (NSTimeZone*) timeZone__
{
    NSTimeZone* re$ult = [self timeZone];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, copy) NSDictionary *userInfo;
- (void) setUserInfo___java_util_Map:(NSDictionary*) userInfo 
{
    [self setUserInfo:(userInfo == JAVA_NULL ? nil : userInfo)];
}

// direct binding of: @property(nonatomic, copy) NSDictionary *userInfo;
- (NSDictionary*) userInfo__
{
    NSDictionary* re$ult = [self userInfo];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
