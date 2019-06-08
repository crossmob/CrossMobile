// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.usernotifications.UNNotificationCategory implementation

#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_usernotifications_UNNotificationCategory.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_usernotifications_UNNotificationCategory$Ext

// (UNNotificationCategory) @property(readonly, copy, nonatomic) NSArray<UNNotificationAction *> *actions;
- (NSArray*) actions__
{
    NSArray* re$ult = [super actions];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNNotificationCategory) @property(readonly, copy, nonatomic) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [super identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNNotificationCategory) @property(readonly, copy, nonatomic) NSArray<NSString *> *intentIdentifiers;
- (NSArray*) intentIdentifiers__
{
    NSArray* re$ult = [super intentIdentifiers];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNNotificationCategory) @property(readonly, nonatomic) UNNotificationCategoryOptions options;
- (JAVA_LONG) options__
{
    return [super options];
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

@implementation UNNotificationCategory (cm_crossmobile_ios_usernotifications_UNNotificationCategory)

// direct binding of: + (instancetype)categoryWithIdentifier:(NSString *)identifier actions:(NSArray<UNNotificationAction *> *)actions intentIdentifiers:(NSArray<NSString *> *)intentIdentifiers options:(UNNotificationCategoryOptions)options;
+ (instancetype) categoryWithIdentifier___java_lang_String_java_util_List_java_util_List_long:(NSString*) identifier :(NSArray*) actions :(NSArray*) intentIdentifiers :(JAVA_LONG) options 
{
    id re$ult = [UNNotificationCategory categoryWithIdentifier:(identifier == JAVA_NULL ? nil : identifier) actions:(actions == JAVA_NULL ? nil : actions) intentIdentifiers:(intentIdentifiers == JAVA_NULL ? nil : intentIdentifiers) options:options];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSArray<UNNotificationAction *> *actions;
- (NSArray*) actions__
{
    NSArray* re$ult = [self actions];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [self identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSArray<NSString *> *intentIdentifiers;
- (NSArray*) intentIdentifiers__
{
    NSArray* re$ult = [self intentIdentifiers];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, nonatomic) UNNotificationCategoryOptions options;
- (JAVA_LONG) options__
{
    return [self options];
}

@end
