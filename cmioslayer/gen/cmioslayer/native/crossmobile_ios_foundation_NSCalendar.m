// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSCalendar implementation

#import "crossmobile_ios_foundation_NSCalendar.h"
#import "crossmobile_ios_foundation_NSDate.h"
#import "crossmobile_ios_foundation_NSDateComponents.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSCalendar$Ext

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (NSCalendar) - (NSDateComponents *)components:(NSCalendarUnit)unitFlags fromDate:(NSDate *)date;
- (NSDateComponents*) components___int_crossmobile_ios_foundation_NSDate:(int) unitFlags :(NSDate*) date 
{
    NSDateComponents* re$ult = [super components:unitFlags fromDate:(date == JAVA_NULL ? nil : date)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSCalendar) - (NSDateComponents *)components:(NSCalendarUnit)unitFlags fromDate:(NSDate *)startingDate toDate:(NSDate *)resultDate options:(NSCalendarOptions)opts;
- (NSDateComponents*) components___int_crossmobile_ios_foundation_NSDate_crossmobile_ios_foundation_NSDate_int:(int) unitFlags :(NSDate*) startingDate :(NSDate*) resultDate :(int) opts 
{
    NSDateComponents* re$ult = [super components:unitFlags fromDate:(startingDate == JAVA_NULL ? nil : startingDate) toDate:(resultDate == JAVA_NULL ? nil : resultDate) options:opts];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSCalendar) - (NSDate *)dateByAddingComponents:(NSDateComponents *)comps toDate:(NSDate *)date options:(NSCalendarOptions)opts;
- (NSDate*) dateByAddingComponents___crossmobile_ios_foundation_NSDateComponents_crossmobile_ios_foundation_NSDate_int:(NSDateComponents*) comps :(NSDate*) date :(int) opts 
{
    NSDate* re$ult = [super dateByAddingComponents:(comps == JAVA_NULL ? nil : comps) toDate:(date == JAVA_NULL ? nil : date) options:opts];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSCalendar) - (NSDate *)dateFromComponents:(NSDateComponents *)comps;
- (NSDate*) dateFromComponents___crossmobile_ios_foundation_NSDateComponents:(NSDateComponents*) comps 
{
    NSDate* re$ult = [super dateFromComponents:(comps == JAVA_NULL ? nil : comps)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
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

@implementation NSCalendar (cm_crossmobile_ios_foundation_NSCalendar)

// direct binding of: + (NSCalendar *)currentCalendar;
+ (NSCalendar*) currentCalendar__
{
    NSCalendar* re$ult = [NSCalendar currentCalendar];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (NSDateComponents *)components:(NSCalendarUnit)unitFlags fromDate:(NSDate *)date;
- (NSDateComponents*) components___int_crossmobile_ios_foundation_NSDate:(int) unitFlags :(NSDate*) date 
{
    NSDateComponents* re$ult = [self components:unitFlags fromDate:(date == JAVA_NULL ? nil : date)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (NSDateComponents *)components:(NSCalendarUnit)unitFlags fromDate:(NSDate *)startingDate toDate:(NSDate *)resultDate options:(NSCalendarOptions)opts;
- (NSDateComponents*) components___int_crossmobile_ios_foundation_NSDate_crossmobile_ios_foundation_NSDate_int:(int) unitFlags :(NSDate*) startingDate :(NSDate*) resultDate :(int) opts 
{
    NSDateComponents* re$ult = [self components:unitFlags fromDate:(startingDate == JAVA_NULL ? nil : startingDate) toDate:(resultDate == JAVA_NULL ? nil : resultDate) options:opts];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (NSDate *)dateByAddingComponents:(NSDateComponents *)comps toDate:(NSDate *)date options:(NSCalendarOptions)opts;
- (NSDate*) dateByAddingComponents___crossmobile_ios_foundation_NSDateComponents_crossmobile_ios_foundation_NSDate_int:(NSDateComponents*) comps :(NSDate*) date :(int) opts 
{
    NSDate* re$ult = [self dateByAddingComponents:(comps == JAVA_NULL ? nil : comps) toDate:(date == JAVA_NULL ? nil : date) options:opts];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (NSDate *)dateFromComponents:(NSDateComponents *)comps;
- (NSDate*) dateFromComponents___crossmobile_ios_foundation_NSDateComponents:(NSDateComponents*) comps 
{
    NSDate* re$ult = [self dateFromComponents:(comps == JAVA_NULL ? nil : comps)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
