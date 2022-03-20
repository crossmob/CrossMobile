// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_usernotifications_UNNotificationServiceExtension implementation

#import "crossmobile_ios_usernotifications_UNNotificationContent.h"
#import "crossmobile_ios_usernotifications_UNNotificationRequest.h"
#import "crossmobile_ios_usernotifications_UNNotificationServiceExtension.h"
#import "org_robovm_objc_block_VoidBlock1.h"

@implementation crossmobile_ios_usernotifications_UNNotificationServiceExtension$Ext

@end

@implementation UNNotificationServiceExtension (cm_crossmobile_ios_usernotifications_UNNotificationServiceExtension)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_usernotifications_UNNotificationServiceExtension__
{
    return [self init];
}

// - (void)didReceiveNotificationRequest:(UNNotificationRequest *)request withContentHandler:(void (^)(UNNotificationContent *contentToDeliver))contentHandler;
- (void) didReceiveNotificationRequest___crossmobile_ios_usernotifications_UNNotificationRequest_org_robovm_objc_block_VoidBlock1:(UNNotificationRequest*) request :(id<org_robovm_objc_block_VoidBlock1>) contentHandler 
{
    [self didReceiveNotificationRequest:(request == JAVA_NULL ? nil : request) withContentHandler:(contentHandler == JAVA_NULL ? nil : ^(UNNotificationContent* contentToDeliver) {
        [contentHandler invoke___java_lang_Object:(contentToDeliver ? contentToDeliver : JAVA_NULL)];
    })];
}

// - (void)serviceExtensionTimeWillExpire;
- (void) serviceExtensionTimeWillExpire__
{
    [self serviceExtensionTimeWillExpire];
}

@end
