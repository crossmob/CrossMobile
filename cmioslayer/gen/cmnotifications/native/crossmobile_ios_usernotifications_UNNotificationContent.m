// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.usernotifications.UNNotificationContent implementation

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
