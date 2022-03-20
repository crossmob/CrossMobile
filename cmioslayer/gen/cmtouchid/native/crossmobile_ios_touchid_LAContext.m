// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_touchid_LAContext implementation

#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSError.h"
#import "crossmobile_ios_touchid_LAContext.h"
#import "crossmobile_rt_StrongReference.h"
#import "java_lang_Boolean.h"
#import "java_lang_String.h"
#import "org_robovm_objc_block_VoidBlock2.h"

@implementation crossmobile_ios_touchid_LAContext$Ext

@end

@implementation LAContext (cm_crossmobile_ios_touchid_LAContext)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_touchid_LAContext__
{
    return [self init];
}

// @property(nonatomic, readonly) LABiometryType biometryType;
- (int) biometryType__
{
    return [self biometryType];
}

// @property(nonatomic, readonly) NSData *evaluatedPolicyDomainState;
- (NSData*) evaluatedPolicyDomainState__
{
    NSData* re$ult = [self evaluatedPolicyDomainState];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) BOOL interactionNotAllowed;
- (void) setInteractionNotAllowed___boolean:(BOOL) interactionNotAllowed 
{
    [self setInteractionNotAllowed:interactionNotAllowed];
}

// @property(nonatomic) BOOL interactionNotAllowed;
- (BOOL) interactionNotAllowed__
{
    return [self interactionNotAllowed];
}

// @property(nonatomic, copy) NSString *localizedCancelTitle;
- (void) setLocalizedCancelTitle___java_lang_String:(NSString*) localizedCancelTitle 
{
    [self setLocalizedCancelTitle:(localizedCancelTitle == JAVA_NULL ? nil : localizedCancelTitle)];
}

// @property(nonatomic, copy) NSString *localizedCancelTitle;
- (NSString*) localizedCancelTitle__
{
    NSString* re$ult = [self localizedCancelTitle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy) NSString *localizedFallbackTitle;
- (void) setLocalizedFallbackTitle___java_lang_String:(NSString*) localizedFallbackTitle 
{
    [self setLocalizedFallbackTitle:(localizedFallbackTitle == JAVA_NULL ? nil : localizedFallbackTitle)];
}

// @property(nonatomic, copy) NSString *localizedFallbackTitle;
- (NSString*) localizedFallbackTitle__
{
    NSString* re$ult = [self localizedFallbackTitle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy) NSString *localizedReason;
- (void) setLocalizedReason___java_lang_String:(NSString*) localizedReason 
{
    [self setLocalizedReason:(localizedReason == JAVA_NULL ? nil : localizedReason)];
}

// @property(nonatomic, copy) NSString *localizedReason;
- (NSString*) localizedReason__
{
    NSString* re$ult = [self localizedReason];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) NSTimeInterval touchIDAuthenticationAllowableReuseDuration;
- (void) setTouchIDAuthenticationAllowableReuseDuration___double:(double) touchIDAuthenticationAllowableReuseDuration 
{
    [self setTouchIDAuthenticationAllowableReuseDuration:touchIDAuthenticationAllowableReuseDuration];
}

// @property(nonatomic) NSTimeInterval touchIDAuthenticationAllowableReuseDuration;
- (double) touchIDAuthenticationAllowableReuseDuration__
{
    return [self touchIDAuthenticationAllowableReuseDuration];
}

// -(BOOL)canEvaluatePolicy:(LAPolicy)policy error:(NSError * _Nullable *)error;
- (BOOL) canEvaluatePolicy___int_crossmobile_rt_StrongReference:(int) policy :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    BOOL re$ult = [self canEvaluatePolicy:policy error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return re$ult;
}

// - (void)evaluatePolicy:(LAPolicy)policy localizedReason:(NSString *)localizedReason reply:(void (^)(BOOL success, NSError *error))reply;
- (void) evaluatePolicy___int_java_lang_String_org_robovm_objc_block_VoidBlock2:(int) policy :(NSString*) localizedReason :(id<org_robovm_objc_block_VoidBlock2>) reply 
{
    [self evaluatePolicy:policy localizedReason:(localizedReason == JAVA_NULL ? nil : localizedReason) reply:(reply == JAVA_NULL ? nil : ^(BOOL success, NSError* error) {
        java_lang_Boolean* success$conv = [[java_lang_Boolean alloc] initWithBool:success];
        [reply invoke___java_lang_Object_java_lang_Object:success$conv :(error ? error : JAVA_NULL)];
        [success$conv release];
    })];
}

// - (void)invalidate;
- (void) invalidate__
{
    [self invalidate];
}

// - (BOOL)isCredentialSet:(LACredentialType)type;
- (BOOL) isCredentialSet___int:(int) type 
{
    return [self isCredentialSet:type];
}

// - (BOOL)setCredential:(NSData *)credential type:(LACredentialType)type;
- (BOOL) setCredential___crossmobile_ios_foundation_NSData_int:(NSData*) credential :(int) type 
{
    return [self setCredential:(credential == JAVA_NULL ? nil : credential) type:type];
}

@end
