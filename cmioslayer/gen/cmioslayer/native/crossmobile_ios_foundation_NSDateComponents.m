// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSDateComponents implementation

#import "crossmobile_ios_foundation_NSDateComponents.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSDateComponents$Ext

// (NSDateComponents) @property NSInteger day;
- (void) setDay___int:(int) day 
{
    [super setDay:day];
}

// (NSDateComponents) @property NSInteger day;
- (int) day__
{
    return [super day];
}

// (NSDateComponents) @property NSInteger era;
- (void) setEra___int:(int) era 
{
    [super setEra:era];
}

// (NSDateComponents) @property NSInteger era;
- (int) era__
{
    return [super era];
}

// (NSDateComponents) @property NSInteger hour;
- (void) setHour___int:(int) hour 
{
    [super setHour:hour];
}

// (NSDateComponents) @property NSInteger hour;
- (int) hour__
{
    return [super hour];
}

// (NSDateComponents) @property NSInteger minute;
- (void) setMinute___int:(int) minute 
{
    [super setMinute:minute];
}

// (NSDateComponents) @property NSInteger minute;
- (int) minute__
{
    return [super minute];
}

// (NSDateComponents) @property NSInteger month;
- (void) setMonth___int:(int) month 
{
    [super setMonth:month];
}

// (NSDateComponents) @property NSInteger month;
- (int) month__
{
    return [super month];
}

// (NSDateComponents) @property NSInteger second;
- (void) setSecond___int:(int) second 
{
    [super setSecond:second];
}

// (NSDateComponents) @property NSInteger second;
- (int) second__
{
    return [super second];
}

// (NSDateComponents) @property NSInteger weekday;
- (void) setWeekday___int:(int) weekday 
{
    [super setWeekday:weekday];
}

// (NSDateComponents) @property NSInteger weekday;
- (int) weekday__
{
    return [super weekday];
}

// (NSDateComponents) @property NSInteger weekdayOrdinal;
- (void) setWeekdayOrdinal___int:(int) weekdayOrdinal 
{
    [super setWeekdayOrdinal:weekdayOrdinal];
}

// (NSDateComponents) @property NSInteger weekdayOrdinal;
- (int) weekdayOrdinal__
{
    return [super weekdayOrdinal];
}

// (NSDateComponents) @property NSInteger year;
- (void) setYear___int:(int) year 
{
    [super setYear:year];
}

// (NSDateComponents) @property NSInteger year;
- (int) year__
{
    return [super year];
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

// (NSDateComponents) - (void)setWeek:(NSInteger)v;
- (void) setWeek___int:(int) v 
{
    [super setWeek:v];
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

// (NSDateComponents) - (NSInteger)week;
- (int) week__
{
    return [super week];
}

@end

@implementation NSDateComponents (cm_crossmobile_ios_foundation_NSDateComponents)

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_foundation_NSDateComponents__
{
    return [self init];
}

// direct binding of: @property NSInteger day;
- (void) setDay___int:(int) day 
{
    [self setDay:day];
}

// direct binding of: @property NSInteger day;
- (int) day__
{
    return [self day];
}

// direct binding of: @property NSInteger era;
- (void) setEra___int:(int) era 
{
    [self setEra:era];
}

// direct binding of: @property NSInteger era;
- (int) era__
{
    return [self era];
}

// direct binding of: @property NSInteger hour;
- (void) setHour___int:(int) hour 
{
    [self setHour:hour];
}

// direct binding of: @property NSInteger hour;
- (int) hour__
{
    return [self hour];
}

// direct binding of: @property NSInteger minute;
- (void) setMinute___int:(int) minute 
{
    [self setMinute:minute];
}

// direct binding of: @property NSInteger minute;
- (int) minute__
{
    return [self minute];
}

// direct binding of: @property NSInteger month;
- (void) setMonth___int:(int) month 
{
    [self setMonth:month];
}

// direct binding of: @property NSInteger month;
- (int) month__
{
    return [self month];
}

// direct binding of: @property NSInteger second;
- (void) setSecond___int:(int) second 
{
    [self setSecond:second];
}

// direct binding of: @property NSInteger second;
- (int) second__
{
    return [self second];
}

// direct binding of: @property NSInteger weekday;
- (void) setWeekday___int:(int) weekday 
{
    [self setWeekday:weekday];
}

// direct binding of: @property NSInteger weekday;
- (int) weekday__
{
    return [self weekday];
}

// direct binding of: @property NSInteger weekdayOrdinal;
- (void) setWeekdayOrdinal___int:(int) weekdayOrdinal 
{
    [self setWeekdayOrdinal:weekdayOrdinal];
}

// direct binding of: @property NSInteger weekdayOrdinal;
- (int) weekdayOrdinal__
{
    return [self weekdayOrdinal];
}

// direct binding of: @property NSInteger year;
- (void) setYear___int:(int) year 
{
    [self setYear:year];
}

// direct binding of: @property NSInteger year;
- (int) year__
{
    return [self year];
}

// direct binding of: - (void)setWeek:(NSInteger)v;
- (void) setWeek___int:(int) v 
{
    [self setWeek:v];
}

// direct binding of: - (NSInteger)week;
- (int) week__
{
    return [self week];
}

@end
