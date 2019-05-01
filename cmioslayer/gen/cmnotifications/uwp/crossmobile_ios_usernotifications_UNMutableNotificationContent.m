// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.usernotifications.UNMutableNotificationContent implementation

#import "crossmobile_ios_usernotifications_UNMutableNotificationContent.h"
#import "crossmobile_ios_usernotifications_UNNotificationSound.h"
#import "java_lang_Number.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_usernotifications_UNMutableNotificationContent$Ext

// (UNMutableNotificationContent) @property(copy, nonatomic) NSArray<UNNotificationAttachment *> *attachments;
- (void) setAttachments___java_util_List:(NSArray*) attachments 
{
    [super setAttachments:(attachments == JAVA_NULL ? nil : attachments)];
}

// (UNNotificationContent) @property(readonly, copy, nonatomic) NSArray<UNNotificationAttachment *> *attachments;
- (NSArray*) attachments__
{
    NSArray* re$ult = [super attachments];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNMutableNotificationContent) @property(copy, nonatomic) NSNumber *badge;
- (void) setBadge___java_lang_Number:(java_lang_Number*) badge 
{
    [super setBadge:(badge == JAVA_NULL ? nil : badge)];
}

// (UNNotificationContent) @property(readonly, copy, nonatomic) NSNumber *badge;
- (java_lang_Number*) badge__
{
    java_lang_Number* re$ult = [super badge];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNMutableNotificationContent) @property(copy, nonatomic) NSString *body;
- (void) setBody___java_lang_String:(NSString*) body 
{
    [super setBody:(body == JAVA_NULL ? nil : body)];
}

// (UNNotificationContent) @property(readonly, copy, nonatomic) NSString *body;
- (NSString*) body__
{
    NSString* re$ult = [super body];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNMutableNotificationContent) @property(copy, nonatomic) NSString *categoryIdentifier;
- (void) setCategoryIdentifier___java_lang_String:(NSString*) categoryIdentifier 
{
    [super setCategoryIdentifier:(categoryIdentifier == JAVA_NULL ? nil : categoryIdentifier)];
}

// (UNNotificationContent) @property(readonly, copy, nonatomic) NSString *categoryIdentifier;
- (NSString*) categoryIdentifier__
{
    NSString* re$ult = [super categoryIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNMutableNotificationContent) @property(copy, nonatomic) NSString *launchImageName;
- (void) setLaunchImageName___java_lang_String:(NSString*) launchImageName 
{
    [super setLaunchImageName:(launchImageName == JAVA_NULL ? nil : launchImageName)];
}

// (UNNotificationContent) @property(readonly, copy, nonatomic) NSString *launchImageName;
- (NSString*) launchImageName__
{
    NSString* re$ult = [super launchImageName];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNMutableNotificationContent) @property(copy, nonatomic) UNNotificationSound *sound;
- (void) setSound___crossmobile_ios_usernotifications_UNNotificationSound:(UNNotificationSound*) sound 
{
    [super setSound:(sound == JAVA_NULL ? nil : sound)];
}

// (UNNotificationContent) @property(readonly, copy, nonatomic) UNNotificationSound *sound;
- (UNNotificationSound*) sound__
{
    UNNotificationSound* re$ult = [super sound];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNMutableNotificationContent) @property(copy, nonatomic) NSString *subtitle;
- (void) setSubtitle___java_lang_String:(NSString*) subtitle 
{
    [super setSubtitle:(subtitle == JAVA_NULL ? nil : subtitle)];
}

// (UNNotificationContent) @property(readonly, copy, nonatomic) NSString *subtitle;
- (NSString*) subtitle__
{
    NSString* re$ult = [super subtitle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNMutableNotificationContent) @property(copy, nonatomic) NSString *threadIdentifier;
- (void) setThreadIdentifier___java_lang_String:(NSString*) threadIdentifier 
{
    [super setThreadIdentifier:(threadIdentifier == JAVA_NULL ? nil : threadIdentifier)];
}

// (UNNotificationContent) @property(readonly, copy, nonatomic) NSString *threadIdentifier;
- (NSString*) threadIdentifier__
{
    NSString* re$ult = [super threadIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNMutableNotificationContent) @property(copy, nonatomic) NSString *title;
- (void) setTitle___java_lang_String:(NSString*) title 
{
    [super setTitle:(title == JAVA_NULL ? nil : title)];
}

// (UNNotificationContent) @property(readonly, copy, nonatomic) NSString *title;
- (NSString*) title__
{
    NSString* re$ult = [super title];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNMutableNotificationContent) @property(copy, nonatomic) NSDictionary *userInfo;
- (void) setUserInfo___java_util_Map:(NSDictionary*) userInfo 
{
    [super setUserInfo:(userInfo == JAVA_NULL ? nil : userInfo)];
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

@implementation UNMutableNotificationContent (cm_crossmobile_ios_usernotifications_UNMutableNotificationContent)

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_usernotifications_UNMutableNotificationContent__
{
    return [self init];
}

// direct binding of: @property(copy, nonatomic) NSArray<UNNotificationAttachment *> *attachments;
- (void) setAttachments___java_util_List:(NSArray*) attachments 
{
    [self setAttachments:(attachments == JAVA_NULL ? nil : attachments)];
}

// direct binding of: @property(copy, nonatomic) NSNumber *badge;
- (void) setBadge___java_lang_Number:(java_lang_Number*) badge 
{
    [self setBadge:(badge == JAVA_NULL ? nil : badge)];
}

// direct binding of: @property(copy, nonatomic) NSString *body;
- (void) setBody___java_lang_String:(NSString*) body 
{
    [self setBody:(body == JAVA_NULL ? nil : body)];
}

// direct binding of: @property(copy, nonatomic) NSString *categoryIdentifier;
- (void) setCategoryIdentifier___java_lang_String:(NSString*) categoryIdentifier 
{
    [self setCategoryIdentifier:(categoryIdentifier == JAVA_NULL ? nil : categoryIdentifier)];
}

// direct binding of: @property(copy, nonatomic) NSString *launchImageName;
- (void) setLaunchImageName___java_lang_String:(NSString*) launchImageName 
{
    [self setLaunchImageName:(launchImageName == JAVA_NULL ? nil : launchImageName)];
}

// direct binding of: @property(copy, nonatomic) UNNotificationSound *sound;
- (void) setSound___crossmobile_ios_usernotifications_UNNotificationSound:(UNNotificationSound*) sound 
{
    [self setSound:(sound == JAVA_NULL ? nil : sound)];
}

// direct binding of: @property(copy, nonatomic) NSString *subtitle;
- (void) setSubtitle___java_lang_String:(NSString*) subtitle 
{
    [self setSubtitle:(subtitle == JAVA_NULL ? nil : subtitle)];
}

// direct binding of: @property(copy, nonatomic) NSString *threadIdentifier;
- (void) setThreadIdentifier___java_lang_String:(NSString*) threadIdentifier 
{
    [self setThreadIdentifier:(threadIdentifier == JAVA_NULL ? nil : threadIdentifier)];
}

// direct binding of: @property(copy, nonatomic) NSString *title;
- (void) setTitle___java_lang_String:(NSString*) title 
{
    [self setTitle:(title == JAVA_NULL ? nil : title)];
}

// direct binding of: @property(copy, nonatomic) NSDictionary *userInfo;
- (void) setUserInfo___java_util_Map:(NSDictionary*) userInfo 
{
    [self setUserInfo:(userInfo == JAVA_NULL ? nil : userInfo)];
}

@end
