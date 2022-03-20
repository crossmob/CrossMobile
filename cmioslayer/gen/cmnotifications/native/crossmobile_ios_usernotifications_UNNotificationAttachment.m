// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_usernotifications_UNNotificationAttachment implementation

#import "crossmobile_ios_foundation_NSURL.h"
#import "crossmobile_ios_usernotifications_UNNotificationAttachment.h"
#import "crossmobile_rt_StrongReference.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_usernotifications_UNNotificationAttachment$Ext

@end

@implementation UNNotificationAttachment (cm_crossmobile_ios_usernotifications_UNNotificationAttachment)

// + (instancetype)attachmentWithIdentifier:(NSString *)identifier URL:(NSURL *)URL options:(NSDictionary *)options error:(NSError * _Nullable *)error;
+ (instancetype) attachmentWithIdentifier___java_lang_String_crossmobile_ios_foundation_NSURL_java_util_Map_crossmobile_rt_StrongReference:(NSString*) identifier :(NSURL*) URL :(NSDictionary*) options :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    id re$ult = [UNNotificationAttachment attachmentWithIdentifier:(identifier == JAVA_NULL ? nil : identifier) URL:(URL == JAVA_NULL ? nil : URL) options:(options == JAVA_NULL ? nil : options) error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, copy) NSURL *URL;
- (NSURL*) URL__
{
    NSURL* re$ult = [self URL];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [self identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, copy) NSString *type;
- (NSString*) type__
{
    NSString* re$ult = [self type];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
