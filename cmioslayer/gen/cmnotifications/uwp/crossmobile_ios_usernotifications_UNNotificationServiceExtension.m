// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.usernotifications.UNNotificationServiceExtension implementation

#import "crossmobile_ios_usernotifications_UNNotificationContent.h"
#import "crossmobile_ios_usernotifications_UNNotificationRequest.h"
#import "crossmobile_ios_usernotifications_UNNotificationServiceExtension.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "org_robovm_objc_block_VoidBlock1.h"

@implementation crossmobile_ios_usernotifications_UNNotificationServiceExtension$Ext

// (UNNotificationServiceExtension) - (void)serviceExtensionTimeWillExpire;
- (void) serviceExtensionTimeWillExpire__
{
    [super serviceExtensionTimeWillExpire];
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

@implementation UNNotificationServiceExtension (cm_crossmobile_ios_usernotifications_UNNotificationServiceExtension)

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_usernotifications_UNNotificationServiceExtension__
{
    return [self init];
}

// direct binding of: - (void)didReceiveNotificationRequest:(UNNotificationRequest *)request withContentHandler:(void (^)(UNNotificationContent *contentToDeliver))contentHandler;
- (void) didReceiveNotificationRequest___crossmobile_ios_usernotifications_UNNotificationRequest_org_robovm_objc_block_VoidBlock1:(UNNotificationRequest*) request :(id<org_robovm_objc_block_VoidBlock1>) contentHandler 
{
    [self didReceiveNotificationRequest:(request == JAVA_NULL ? nil : request) withContentHandler:(contentHandler == JAVA_NULL ? nil : ^(UNNotificationContent* contentToDeliver) {
        [contentHandler invoke___java_lang_Object:(contentToDeliver ? contentToDeliver : JAVA_NULL)];
    })];
}

// direct binding of: - (void)serviceExtensionTimeWillExpire;
- (void) serviceExtensionTimeWillExpire__
{
    [self serviceExtensionTimeWillExpire];
}

@end
