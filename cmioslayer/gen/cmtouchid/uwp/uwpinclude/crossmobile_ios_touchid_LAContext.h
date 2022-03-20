// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_touchid_LAContext definition

#import "xmlvm.h"
#import <LocalAuthentication/LocalAuthentication.h>
@class crossmobile_ios_foundation_NSData;
@class crossmobile_ios_foundation_NSError;
@class crossmobile_rt_StrongReference;
@class java_lang_Boolean;
@class java_lang_String;
@protocol org_robovm_objc_block_VoidBlock2;

CM_EXPORT_CLASS
@interface crossmobile_ios_touchid_LAContext$Ext : LAContext
@end

#define crossmobile_ios_touchid_LAContext LAContext
@interface LAContext (cm_crossmobile_ios_touchid_LAContext)
- (instancetype) __init_crossmobile_ios_touchid_LAContext__;
- (int) biometryType__;
- (NSData*) evaluatedPolicyDomainState__;
- (void) setInteractionNotAllowed___boolean:(BOOL) interactionNotAllowed ;
- (BOOL) interactionNotAllowed__;
- (void) setLocalizedCancelTitle___java_lang_String:(NSString*) localizedCancelTitle ;
- (NSString*) localizedCancelTitle__;
- (void) setLocalizedFallbackTitle___java_lang_String:(NSString*) localizedFallbackTitle ;
- (NSString*) localizedFallbackTitle__;
- (void) setLocalizedReason___java_lang_String:(NSString*) localizedReason ;
- (NSString*) localizedReason__;
- (void) setTouchIDAuthenticationAllowableReuseDuration___double:(double) touchIDAuthenticationAllowableReuseDuration ;
- (double) touchIDAuthenticationAllowableReuseDuration__;
- (BOOL) canEvaluatePolicy___int_crossmobile_rt_StrongReference:(int) policy :(crossmobile_rt_StrongReference*) error ;
- (void) evaluatePolicy___int_java_lang_String_org_robovm_objc_block_VoidBlock2:(int) policy :(NSString*) localizedReason :(id<org_robovm_objc_block_VoidBlock2>) reply ;
- (void) invalidate__;
- (BOOL) isCredentialSet___int:(int) type ;
- (BOOL) setCredential___crossmobile_ios_foundation_NSData_int:(NSData*) credential :(int) type ;
@end
