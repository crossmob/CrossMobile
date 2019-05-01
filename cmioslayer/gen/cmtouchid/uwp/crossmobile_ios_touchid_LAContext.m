// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.touchid.LAContext implementation

#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSError.h"
#import "crossmobile_ios_touchid_LAContext.h"
#import "crossmobile_rt_StrongReference.h"
#import "java_lang_Boolean.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "org_robovm_objc_block_VoidBlock2.h"

@implementation crossmobile_ios_touchid_LAContext$Ext

// (LAContext) @property(nonatomic, readonly) LABiometryType biometryType;
- (int) biometryType__
{
    return [super biometryType];
}

// (LAContext) @property(nonatomic, readonly) NSData *evaluatedPolicyDomainState;
- (NSData*) evaluatedPolicyDomainState__
{
    NSData* re$ult = [super evaluatedPolicyDomainState];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (LAContext) @property(nonatomic) BOOL interactionNotAllowed;
- (void) setInteractionNotAllowed___boolean:(BOOL) interactionNotAllowed 
{
    [super setInteractionNotAllowed:interactionNotAllowed];
}

// (LAContext) @property(nonatomic) BOOL interactionNotAllowed;
- (BOOL) interactionNotAllowed__
{
    return [super interactionNotAllowed];
}

// (LAContext) @property(nonatomic, copy) NSString *localizedCancelTitle;
- (void) setLocalizedCancelTitle___java_lang_String:(NSString*) localizedCancelTitle 
{
    [super setLocalizedCancelTitle:(localizedCancelTitle == JAVA_NULL ? nil : localizedCancelTitle)];
}

// (LAContext) @property(nonatomic, copy) NSString *localizedCancelTitle;
- (NSString*) localizedCancelTitle__
{
    NSString* re$ult = [super localizedCancelTitle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (LAContext) @property(nonatomic, copy) NSString *localizedFallbackTitle;
- (void) setLocalizedFallbackTitle___java_lang_String:(NSString*) localizedFallbackTitle 
{
    [super setLocalizedFallbackTitle:(localizedFallbackTitle == JAVA_NULL ? nil : localizedFallbackTitle)];
}

// (LAContext) @property(nonatomic, copy) NSString *localizedFallbackTitle;
- (NSString*) localizedFallbackTitle__
{
    NSString* re$ult = [super localizedFallbackTitle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (LAContext) @property(nonatomic, copy) NSString *localizedReason;
- (void) setLocalizedReason___java_lang_String:(NSString*) localizedReason 
{
    [super setLocalizedReason:(localizedReason == JAVA_NULL ? nil : localizedReason)];
}

// (LAContext) @property(nonatomic, copy) NSString *localizedReason;
- (NSString*) localizedReason__
{
    NSString* re$ult = [super localizedReason];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (LAContext) @property(nonatomic) NSTimeInterval touchIDAuthenticationAllowableReuseDuration;
- (void) setTouchIDAuthenticationAllowableReuseDuration___double:(double) touchIDAuthenticationAllowableReuseDuration 
{
    [super setTouchIDAuthenticationAllowableReuseDuration:touchIDAuthenticationAllowableReuseDuration];
}

// (LAContext) @property(nonatomic) NSTimeInterval touchIDAuthenticationAllowableReuseDuration;
- (double) touchIDAuthenticationAllowableReuseDuration__
{
    return [super touchIDAuthenticationAllowableReuseDuration];
}

// (LAContext) -(BOOL)canEvaluatePolicy:(LAPolicy)policy error:(NSError * _Nullable *)error;
- (BOOL) canEvaluatePolicy___int_crossmobile_rt_StrongReference:(int) policy :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    BOOL re$ult = [super canEvaluatePolicy:policy error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return re$ult;
}

// (LAContext) - (void)invalidate;
- (void) invalidate__
{
    [super invalidate];
}

// (LAContext) - (BOOL)isCredentialSet:(LACredentialType)type;
- (BOOL) isCredentialSet___int:(int) type 
{
    return [super isCredentialSet:type];
}

// (LAContext) - (BOOL)setCredential:(NSData *)credential type:(LACredentialType)type;
- (BOOL) setCredential___crossmobile_ios_foundation_NSData_int:(NSData*) credential :(int) type 
{
    return [super setCredential:(credential == JAVA_NULL ? nil : credential) type:type];
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

@implementation LAContext (cm_crossmobile_ios_touchid_LAContext)

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_touchid_LAContext__
{
    return [self init];
}

// direct binding of: @property(nonatomic, readonly) LABiometryType biometryType;
- (int) biometryType__
{
    return [self biometryType];
}

// direct binding of: @property(nonatomic, readonly) NSData *evaluatedPolicyDomainState;
- (NSData*) evaluatedPolicyDomainState__
{
    NSData* re$ult = [self evaluatedPolicyDomainState];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic) BOOL interactionNotAllowed;
- (void) setInteractionNotAllowed___boolean:(BOOL) interactionNotAllowed 
{
    [self setInteractionNotAllowed:interactionNotAllowed];
}

// direct binding of: @property(nonatomic) BOOL interactionNotAllowed;
- (BOOL) interactionNotAllowed__
{
    return [self interactionNotAllowed];
}

// direct binding of: @property(nonatomic, copy) NSString *localizedCancelTitle;
- (void) setLocalizedCancelTitle___java_lang_String:(NSString*) localizedCancelTitle 
{
    [self setLocalizedCancelTitle:(localizedCancelTitle == JAVA_NULL ? nil : localizedCancelTitle)];
}

// direct binding of: @property(nonatomic, copy) NSString *localizedCancelTitle;
- (NSString*) localizedCancelTitle__
{
    NSString* re$ult = [self localizedCancelTitle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, copy) NSString *localizedFallbackTitle;
- (void) setLocalizedFallbackTitle___java_lang_String:(NSString*) localizedFallbackTitle 
{
    [self setLocalizedFallbackTitle:(localizedFallbackTitle == JAVA_NULL ? nil : localizedFallbackTitle)];
}

// direct binding of: @property(nonatomic, copy) NSString *localizedFallbackTitle;
- (NSString*) localizedFallbackTitle__
{
    NSString* re$ult = [self localizedFallbackTitle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, copy) NSString *localizedReason;
- (void) setLocalizedReason___java_lang_String:(NSString*) localizedReason 
{
    [self setLocalizedReason:(localizedReason == JAVA_NULL ? nil : localizedReason)];
}

// direct binding of: @property(nonatomic, copy) NSString *localizedReason;
- (NSString*) localizedReason__
{
    NSString* re$ult = [self localizedReason];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic) NSTimeInterval touchIDAuthenticationAllowableReuseDuration;
- (void) setTouchIDAuthenticationAllowableReuseDuration___double:(double) touchIDAuthenticationAllowableReuseDuration 
{
    [self setTouchIDAuthenticationAllowableReuseDuration:touchIDAuthenticationAllowableReuseDuration];
}

// direct binding of: @property(nonatomic) NSTimeInterval touchIDAuthenticationAllowableReuseDuration;
- (double) touchIDAuthenticationAllowableReuseDuration__
{
    return [self touchIDAuthenticationAllowableReuseDuration];
}

// direct binding of: -(BOOL)canEvaluatePolicy:(LAPolicy)policy error:(NSError * _Nullable *)error;
- (BOOL) canEvaluatePolicy___int_crossmobile_rt_StrongReference:(int) policy :(crossmobile_rt_StrongReference*) error 
{
    error = error == JAVA_NULL ? nil : error;
    id error$conv = nil;
    BOOL re$ult = [self canEvaluatePolicy:policy error:(error ? &error$conv : nil)];
    if (error)
        [error set___java_lang_Object:(error$conv ? error$conv : JAVA_NULL)];
    return re$ult;
}

// direct binding of: - (void)evaluatePolicy:(LAPolicy)policy localizedReason:(NSString *)localizedReason reply:(void (^)(BOOL success, NSError *error))reply;
- (void) evaluatePolicy___int_java_lang_String_org_robovm_objc_block_VoidBlock2:(int) policy :(NSString*) localizedReason :(id<org_robovm_objc_block_VoidBlock2>) reply 
{
    [self evaluatePolicy:policy localizedReason:(localizedReason == JAVA_NULL ? nil : localizedReason) reply:(reply == JAVA_NULL ? nil : ^(BOOL success, NSError* error) {
        java_lang_Boolean* success$conv = [[java_lang_Boolean alloc] initWithBool:success];
        [reply invoke___java_lang_Object_java_lang_Object:success$conv :(error ? error : JAVA_NULL)];
        [success$conv release];
    })];
}

// direct binding of: - (void)invalidate;
- (void) invalidate__
{
    [self invalidate];
}

// direct binding of: - (BOOL)isCredentialSet:(LACredentialType)type;
- (BOOL) isCredentialSet___int:(int) type 
{
    return [self isCredentialSet:type];
}

// direct binding of: - (BOOL)setCredential:(NSData *)credential type:(LACredentialType)type;
- (BOOL) setCredential___crossmobile_ios_foundation_NSData_int:(NSData*) credential :(int) type 
{
    return [self setCredential:(credential == JAVA_NULL ? nil : credential) type:type];
}

@end
