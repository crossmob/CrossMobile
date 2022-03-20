/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.touchid;

import crossmobile.ios.foundation.NSData;
import crossmobile.ios.foundation.NSError;
import crossmobile.ios.foundation.NSObject;
import crossmobile.rt.StrongReference;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;
import org.robovm.objc.block.VoidBlock2;

@CMClass
public class LAContext extends NSObject {

    private NSData evaluatedPolicyDomainState = null;
    private double touchIDAuthenticationAllowableReuseDuration = 0;
    private String localizedFallbackTitle;
    private String localizedReason = "";
    private String localizedCancelTitle;
    private boolean interactionNotAllowed = false;
    private int biometryType = LABiometryType.None;

    @CMGetter("@property(nonatomic, readonly) NSData *evaluatedPolicyDomainState;")
    public NSData evaluatedPolicyDomainState() {
        return evaluatedPolicyDomainState;
    }

    @CMGetter("@property(nonatomic, readonly) LABiometryType biometryType;")
    public int biometryType() {
        return biometryType;
    }

    @CMGetter("@property(nonatomic) NSTimeInterval touchIDAuthenticationAllowableReuseDuration;")
    public double touchIDAuthenticationAllowableReuseDuration() {
        return touchIDAuthenticationAllowableReuseDuration;
    }

    @CMSetter("@property(nonatomic) NSTimeInterval touchIDAuthenticationAllowableReuseDuration;")
    public void setTouchIDAuthenticationAllowableReuseDuration(double numberOfLoops) {
        this.touchIDAuthenticationAllowableReuseDuration = numberOfLoops;
    }

    @CMGetter("@property(nonatomic, copy) NSString *localizedReason;")
    public String localizedReason() {
        return localizedReason;
    }

    @CMSetter("@property(nonatomic, copy) NSString *localizedReason;")
    public void setLocalizedReason(String localizedReason) {
        this.localizedReason = localizedReason;
    }

    @CMGetter("@property(nonatomic, copy) NSString *localizedFallbackTitle;")
    public String localizedFallbackTitle() {
        return localizedFallbackTitle;
    }

    @CMSetter("@property(nonatomic, copy) NSString *localizedFallbackTitle;")
    public void setLocalizedFallbackTitle(String localizedFallbackTitle) {
        this.localizedFallbackTitle = localizedFallbackTitle;
    }

    @CMGetter("@property(nonatomic, copy) NSString *localizedCancelTitle;")
    public String localizedCancelTitle() {
        return localizedCancelTitle;
    }

    @CMSetter("@property(nonatomic, copy) NSString *localizedCancelTitle;")
    public void setLocalizedCancelTitle(String localizedCancelTitle) {
        this.localizedCancelTitle = localizedCancelTitle;
    }

    @CMGetter("@property(nonatomic) BOOL interactionNotAllowed;")
    public boolean interactionNotAllowed() {
        return true;
    }

    @CMSetter("@property(nonatomic) BOOL interactionNotAllowed;")
    public void setInteractionNotAllowed(boolean interactionNotAllowed) {
        this.interactionNotAllowed = interactionNotAllowed;
    }

    @CMSelector("-(BOOL)canEvaluatePolicy:(LAPolicy)policy \n"
            + "error:(NSError * _Nullable *)error;")
    public boolean canEvaluatePolicy(int LAPolicy, StrongReference<NSError> error) {
        if (LAPolicy == crossmobile.ios.touchid.LAPolicy.DeviceOwnerAuthenticationWithBiometrics)
            return Native.security().supportsFingerprint(error);
        return false;
    }

    @CMSelector("- (void)evaluatePolicy:(LAPolicy)policy \n"
            + "       localizedReason:(NSString *)localizedReason \n"
            + "                 reply:(void (^)(BOOL success, NSError *error))reply;")
    public void evaluatePolicy(int LAPolicy, String localizedReason, VoidBlock2<Boolean, NSError> completionHandler) {
        this.localizedReason = localizedReason;
        if (LAPolicy == crossmobile.ios.touchid.LAPolicy.DeviceOwnerAuthenticationWithBiometrics)
            Native.security().requestFingerprint(completionHandler, this);
    }

    @CMSelector("- (BOOL)setCredential:(NSData *)credential \n"
            + "type:(LACredentialType)type;")
    public boolean setCredential(NSData credential, int type) {
        return true;
    }

    @CMSelector("- (BOOL)isCredentialSet:(LACredentialType)type;")
    public boolean isCredentialSet(int type) {
        return true;
    }

//TODO
//    @CMSelector("- (void)evaluateAccessControl:(SecAccessControlRef)accessControl \n" +
//            "                    operation:(LAAccessControlOperation)operation \n" +
//            "              localizedReason:(NSString *)localizedReason \n" +
//            "                        reply:(void (^)(BOOL success, NSError *error))reply;")
//    public void evaluateAccessControl()

    @CMSelector("- (void)invalidate;")
    public void invalidate() {

    }

}
