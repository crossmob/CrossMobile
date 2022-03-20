/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.content.DialogInterface;
import android.os.Build;
import android.os.CancellationSignal;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyPermanentlyInvalidatedException;
import android.security.keystore.KeyProperties;
import android.widget.ImageView;
import android.widget.LinearLayout;
import crossmobile.ios.foundation.NSError;
import crossmobile.ios.touchid.LAContext;
import crossmobile.ios.touchid.LAError;
import crossmobile.rt.StrongReference;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.SecurityBridge;
import org.crossmobile.bridge.ann.CMLib;
import org.robovm.objc.block.VoidBlock2;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static android.content.Context.FINGERPRINT_SERVICE;
import static android.content.Context.KEYGUARD_SERVICE;
import static crossmobile.ios.foundation.NSError.Domain.LAErrorDomain;
import static org.crossmobile.bridge.ann.CMLibTarget.ANDROID;

@SuppressWarnings("deprecation")
@CMLib(target = ANDROID, name = "cmtouchid")
public class AndroidSecurityBridge implements SecurityBridge {

    private static final String KEY_NAME = "TOUCHKEY";
    private Cipher cipher;
    @SuppressWarnings("deprecation")
    private android.hardware.fingerprint.FingerprintManager fingerprintManager;
    private KeyStore keyStore;
    private AlertDialog dialog;

    private Map<String, Object> getUserInfo(String description) {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("NSLocalizedDescription", description);
        return userInfo;
    }

    @Override
    public boolean supportsFingerprint(StrongReference<NSError> error) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            KeyguardManager keyguardManager
                    = (KeyguardManager) MainActivity.current().getSystemService(KEYGUARD_SERVICE);
            fingerprintManager
                    = (android.hardware.fingerprint.FingerprintManager) MainActivity.current().getSystemService(FINGERPRINT_SERVICE);

            if (!fingerprintManager.isHardwareDetected()) {
                error.set(new NSError(LAErrorDomain, LAError.TouchIDNotAvailable, getUserInfo("Device has no fingerprint sensor")));
                return false;
            }

            if (!fingerprintManager.hasEnrolledFingerprints()) {
                error.set(new NSError(LAErrorDomain, LAError.TouchIDNotEnrolled, getUserInfo("No identities are enrolled")));
                return false;
            }

            if (!keyguardManager.isKeyguardSecure()) {
                error.set(new NSError(LAErrorDomain, LAError.PasscodeNotSet, getUserInfo("A passcode isn’t set on the device.")));
//                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public void requestFingerprint(VoidBlock2<Boolean, NSError> callback, final LAContext context) {
        if (initCipher()) {
            android.hardware.fingerprint.FingerprintManager.CryptoObject cryptoObject = new android.hardware.fingerprint.FingerprintManager.CryptoObject(cipher);
            fingerprintManager.authenticate(cryptoObject, new CancellationSignal(), 0, new FingerPrintCallback(callback), null);
            Native.lifecycle().runAndWaitOnEventThread(() -> {
                dialog = new AlertDialog.Builder(MainActivity.current).create();
                dialog.setTitle("Sign in for " + context.localizedReason());
                dialog.setMessage("Confirm fingerprint to continue");
                dialog.setButton(AlertDialog.BUTTON_NEGATIVE, context.localizedCancelTitle() == null ? "Cancel" : context.localizedCancelTitle(), (DialogInterface di, int i) -> {
                    di.cancel();
                    callback.invoke(false, new NSError(LAErrorDomain, LAError.UserCancel, getUserInfo("Canceled by user.")));
                });
                LinearLayout linear = new LinearLayout(MainActivity.current);
                linear.setOrientation(LinearLayout.VERTICAL);
                ImageView imageView = new ImageView(MainActivity.current());
                imageView.setImageBitmap(((AndroidBitmap) Native.image().lookup(Native.file().getSystemPrefix() + "fingerpint_android").bitmap).bitmap);
                linear.addView(imageView);
                dialog.setView(linear);
                dialog.show();
            });
        }
    }

    private void generateKey() throws FingerprintException {
        try {
            // Obtain a reference to the Keystore using the standard Android keystore container identifier (“AndroidKeystore”)//
            keyStore = KeyStore.getInstance("AndroidKeyStore");

            //Generate the key//
            KeyGenerator keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore");

            try {
                //Initialize an empty KeyStore//
                keyStore.load(null);
            } catch (IOException ex) {
                Logger.getLogger(AndroidSecurityBridge.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Initialize the KeyGenerator//
            keyGenerator.init(new //Specify the operation(s) this key can be used for//
                    KeyGenParameterSpec.Builder(KEY_NAME,
                    KeyProperties.PURPOSE_ENCRYPT
                            | KeyProperties.PURPOSE_DECRYPT)
                    .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                    //Configure this key so that the user has to confirm their identity with a fingerprint each time they want to use it//
                    .setUserAuthenticationRequired(true)
                    .setEncryptionPaddings(
                            KeyProperties.ENCRYPTION_PADDING_PKCS7)
                    .build());

            //Generate the key//
            keyGenerator.generateKey();

        } catch (KeyStoreException
                | NoSuchAlgorithmException
                | NoSuchProviderException
                | InvalidAlgorithmParameterException
                | CertificateException exc) {
            exc.printStackTrace();
            throw new FingerprintException(exc);
        }
    }

    public boolean initCipher() {
        try {
            //Obtain a cipher instance and configure it with the properties required for fingerprint authentication//
            cipher = Cipher.getInstance(
                    KeyProperties.KEY_ALGORITHM_AES + "/"
                            + KeyProperties.BLOCK_MODE_CBC + "/"
                            + KeyProperties.ENCRYPTION_PADDING_PKCS7);
        } catch (NoSuchAlgorithmException
                | NoSuchPaddingException e) {
            throw new RuntimeException("Failed to get Cipher", e);
        }

        if (keyStore == null) {
            try {
                generateKey();
            } catch (FingerprintException e) {
                e.printStackTrace();
            }
        }
        try {
            keyStore.load(null);
            SecretKey key = (SecretKey) keyStore.getKey(KEY_NAME,
                    null);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //Return true if the cipher has been initialized successfully//
            return true;
        } catch (KeyPermanentlyInvalidatedException e) {

            //Return false if cipher initialization failed//
            return false;
        } catch (KeyStoreException | CertificateException
                | UnrecoverableKeyException | IOException
                | NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException("Failed to init Cipher", e);
        }
    }

    private class FingerprintException extends Exception {

        public FingerprintException(Exception e) {
            super(e);
        }
    }

    @SuppressWarnings("deprecation")
    private class FingerPrintCallback extends android.hardware.fingerprint.FingerprintManager.AuthenticationCallback {

        VoidBlock2<Boolean, NSError> callback;

        public FingerPrintCallback(VoidBlock2<Boolean, NSError> callback) {
            this.callback = callback;
        }

        @Override
        public void onAuthenticationError(int errorCode, CharSequence errString) {
            System.out.println("Error " + errorCode + " : " + errString);
            NSError error;
            switch (errorCode) {
                case android.hardware.fingerprint.FingerprintManager.FINGERPRINT_ERROR_HW_UNAVAILABLE:
                    error = new NSError(LAErrorDomain, LAError.TouchIDNotAvailable, getUserInfo(errString.toString()));
                    break;
                case android.hardware.fingerprint.FingerprintManager.FINGERPRINT_ERROR_UNABLE_TO_PROCESS:
                    error = new NSError(LAErrorDomain, LAError.AuthenticationFailed, getUserInfo(errString.toString()));
                    break;
                case android.hardware.fingerprint.FingerprintManager.FINGERPRINT_ERROR_TIMEOUT:
                case android.hardware.fingerprint.FingerprintManager.FINGERPRINT_ERROR_CANCELED:
                    error = new NSError(LAErrorDomain, LAError.SystemCancel, getUserInfo(errString.toString()));
                    break;
                case android.hardware.fingerprint.FingerprintManager.FINGERPRINT_ERROR_LOCKOUT:
                    error = new NSError(LAErrorDomain, LAError.TouchIDLockout, getUserInfo(errString.toString()));
            }
        }

        @Override
        public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
            System.out.println("Help " + helpCode + " : " + helpString);
        }

        @Override
        public void onAuthenticationSucceeded(android.hardware.fingerprint.FingerprintManager.AuthenticationResult result) {
            dialog.cancel();
            callback.invoke(true, null);
        }

        @Override
        public void onAuthenticationFailed() {
            dialog.cancel();
            System.out.println("failed");
            callback.invoke(false, new NSError(LAErrorDomain, LAError.AuthenticationFailed, getUserInfo("Authentication Failed")));
        }
    }

}
