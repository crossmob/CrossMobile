// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_contacts_CNInstantMessageAddress implementation

#import "crossmobile_ios_contacts_CNInstantMessageAddress.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_contacts_CNInstantMessageAddress$Ext

@end

@implementation CNInstantMessageAddress (cm_crossmobile_ios_contacts_CNInstantMessageAddress)

// - (instancetype)initWithUsername:(NSString *)username service:(NSString *)service;
- (instancetype) __init_crossmobile_ios_contacts_CNInstantMessageAddress___java_lang_String_java_lang_String:(NSString*) username :(NSString*) service 
{
    return [self initWithUsername:(username == JAVA_NULL ? nil : username) service:(service == JAVA_NULL ? nil : service)];
}

// @property(readonly, copy, nonatomic) NSString *service;
- (NSString*) service__
{
    NSString* re$ult = [self service];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy, nonatomic) NSString *username;
- (NSString*) username__
{
    NSString* re$ult = [self username];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
