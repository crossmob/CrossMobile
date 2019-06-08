// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.usernotifications.UNNotificationContent implementation

#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_usernotifications_UNNotificationContent.h"
#import "crossmobile_ios_usernotifications_UNNotificationSound.h"
#import "java_lang_Number.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_usernotifications_UNNotificationContent$Ext

// (UNNotificationContent) @property(readonly, copy, nonatomic) NSArray<UNNotificationAttachment *> *attachments;
- (NSArray*) attachments__
{
    NSArray* re$ult = [super attachments];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNNotificationContent) @property(readonly, copy, nonatomic) NSNumber *badge;
- (java_lang_Number*) badge__
{
    java_lang_Number* re$ult = [super badge];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNNotificationContent) @property(readonly, copy, nonatomic) NSString *body;
- (NSString*) body__
{
    NSString* re$ult = [super body];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNNotificationContent) @property(readonly, copy, nonatomic) NSString *categoryIdentifier;
- (NSString*) categoryIdentifier__
{
    NSString* re$ult = [super categoryIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNNotificationContent) @property(readonly, copy, nonatomic) NSString *launchImageName;
- (NSString*) launchImageName__
{
    NSString* re$ult = [super launchImageName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNNotificationContent) @property(readonly, copy, nonatomic) UNNotificationSound *sound;
- (UNNotificationSound*) sound__
{
    UNNotificationSound* re$ult = [super sound];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNNotificationContent) @property(readonly, copy, nonatomic) NSString *subtitle;
- (NSString*) subtitle__
{
    NSString* re$ult = [super subtitle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNNotificationContent) @property(readonly, copy, nonatomic) NSString *threadIdentifier;
- (NSString*) threadIdentifier__
{
    NSString* re$ult = [super threadIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNNotificationContent) @property(readonly, copy, nonatomic) NSString *title;
- (NSString*) title__
{
    NSString* re$ult = [super title];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNNotificationContent) @property(readonly, copy, nonatomic) NSDictionary *userInfo;
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

@implementation UNNotificationContent (cm_crossmobile_ios_usernotifications_UNNotificationContent)

// direct binding of: @property(readonly, copy, nonatomic) NSArray<UNNotificationAttachment *> *attachments;
- (NSArray*) attachments__
{
    NSArray* re$ult = [self attachments];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSNumber *badge;
- (java_lang_Number*) badge__
{
    java_lang_Number* re$ult = [self badge];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *body;
- (NSString*) body__
{
    NSString* re$ult = [self body];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *categoryIdentifier;
- (NSString*) categoryIdentifier__
{
    NSString* re$ult = [self categoryIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *launchImageName;
- (NSString*) launchImageName__
{
    NSString* re$ult = [self launchImageName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) UNNotificationSound *sound;
- (UNNotificationSound*) sound__
{
    UNNotificationSound* re$ult = [self sound];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *subtitle;
- (NSString*) subtitle__
{
    NSString* re$ult = [self subtitle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *threadIdentifier;
- (NSString*) threadIdentifier__
{
    NSString* re$ult = [self threadIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSString *title;
- (NSString*) title__
{
    NSString* re$ult = [self title];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) NSDictionary *userInfo;
- (NSDictionary*) userInfo__
{
    NSDictionary* re$ult = [self userInfo];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
