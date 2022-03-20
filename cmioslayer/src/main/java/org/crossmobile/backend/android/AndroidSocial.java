/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import crossmobile.ios.coregraphics.GraphicsDrill;
import crossmobile.ios.foundation.FoundationDrill;
import crossmobile.ios.foundation.NSURL;
import crossmobile.ios.social.SLComposeViewControllerCompletionHandler;
import crossmobile.ios.social.SLComposeViewControllerResult;
import crossmobile.ios.social.SLServiceType;
import crossmobile.ios.uikit.UIImage;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMAndroidInjections;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibDepends;
import org.crossmobile.bridge.ann.CMLibParam;

import java.util.Iterator;

import static org.crossmobile.bridge.RuntimeKeys.FacebookSdkApplicationSignature;
import static org.crossmobile.bridge.ann.CMLibParam.ParamContext.Android;
import static org.crossmobile.bridge.ann.CMLibTarget.ANDROID;

@CMLib(name = "cmsocial", target = ANDROID,
        params = @CMLibParam(property = "facebookappid", description = "Facebook Application ID", meta = "com.facebook.sdk.ApplicationId", context = Android),
        androidInjections = @CMAndroidInjections(appSection = "<provider android:authorities=\"com.facebook.app.FacebookContentProvider${org.crossmobile.cmplugin-cmsocial.facebookappid}\"\n" +
                "          android:name=\"com.facebook.FacebookContentProvider\"\n" +
                "          android:exported=\"true\"/>"),
        depends = @CMLibDepends(groupId = "com.facebook.android", pluginName = "facebook-android-sdk", version = "7.+"))
public class AndroidSocial {
    private CallbackManager callbackManager;
    private ShareDialog shareDialog;
    private SLComposeViewControllerCompletionHandler feedback;

    public void initialize() {
        initializeTwitter();
        initializeFacebook();
        Native.system().debug("Social plugins initialized", null);
    }

    private void initializeTwitter() {
        if (resolveTwitter() != null) {
            Native.social().registerSocial(SLServiceType.Twitter, (text, images, urls, handler) -> {
                try {
                    Intent tweetIntent = resolveTwitter();
                    if (tweetIntent != null) {
                        tweetIntent.putExtra(Intent.EXTRA_TEXT, text == null ? "" : text);
                        MainActivity.current().getStateListener().launch((resultCode, intent) -> {
                            if (handler != null)
                                handler.invoke(resultCode == Activity.RESULT_OK ? SLComposeViewControllerResult.Done : SLComposeViewControllerResult.Cancelled);
                        }, tweetIntent);
                    }
                } catch (Exception e) {
                    Native.system().error("Unable to open Twitter: " + e.toString(), e);
                }
            });
        }
    }

    private Intent resolveTwitter() {
        try {
            Intent tweetIntent = new Intent(Intent.ACTION_SEND);
            tweetIntent.putExtra(Intent.EXTRA_TEXT, "");
            tweetIntent.setType("text/plain");
            PackageManager packManager = MainActivity.current().getPackageManager();
            for (ResolveInfo resolveInfo : packManager.queryIntentActivities(tweetIntent, PackageManager.MATCH_DEFAULT_ONLY)) {
                if (resolveInfo.activityInfo.packageName.startsWith("com.twitter.android")) {
                    tweetIntent.setClassName(
                            resolveInfo.activityInfo.packageName,
                            resolveInfo.activityInfo.name);
                    return tweetIntent;
                }
            }
            Native.system().error("Twitter not found", null);
        } catch (final Exception e) {
            Native.system().error("Unable to initialize Twitter: " + e.toString(), e);
        }
        return null;
    }

    @SuppressWarnings("deprecation")
    private void initializeFacebook() {
        try {
            FacebookSdk.setApplicationId(System.getProperty("org.crossmobile.cmplugin-cmsocial.facebookappid"));
            FacebookSdk.sdkInitialize(MainActivity.current());
            FoundationDrill.addVirtualUserDefault(FacebookSdkApplicationSignature,
                    () -> FacebookSdk.getApplicationSignature(MainActivity.current().getApplicationContext()));
            MainActivity.current().getStateListener().register(new ActivityLifecycleListener() {
                @Override
                public void onCreate(Bundle savedInstanceState) {
                    callbackManager = CallbackManager.Factory.create();
                    shareDialog = new ShareDialog(MainActivity.current());
                    shareDialog.registerCallback(callbackManager, new FacebookCallback<Sharer.Result>() {
                        @Override
                        public void onSuccess(Sharer.Result result) {
                            if (feedback != null)
                                feedback.invoke(SLComposeViewControllerResult.Done);
                            feedback = null;
                        }

                        @Override
                        public void onCancel() {
                            if (feedback != null)
                                feedback.invoke(SLComposeViewControllerResult.Cancelled);
                            feedback = null;
                        }

                        @Override
                        public void onError(FacebookException e) {
                            Native.system().error("Error on Facebook callback", e);
                        }
                    });
                }
            });
            Native.social().registerSocial(SLServiceType.Facebook, (text, images, urls, handler) -> {
                feedback = handler;
                ShareContent<?, ?> content;
                if (!images.isEmpty()) {
                    SharePhotoContent.Builder contentBuilder = new SharePhotoContent.Builder();
                    Iterator<NSURL> uit = urls.iterator();
                    for (UIImage image : images) {
                        SharePhoto.Builder photoContentBuilder = new SharePhoto.Builder();
                        photoContentBuilder.setBitmap(((AndroidBitmap) GraphicsDrill.bitmap(image.CGImage())).getBitmap());
                        if (uit.hasNext())
                            photoContentBuilder.setImageUrl(Uri.parse(uit.next().absoluteString()));
                        contentBuilder.addPhoto(photoContentBuilder.build());
                    }
                    content = contentBuilder.build();
                } else {
                    ShareLinkContent.Builder linkBuilder = new ShareLinkContent.Builder();
                    linkBuilder.setQuote(text);
                    if (!urls.isEmpty())
                        linkBuilder.setContentUrl(Uri.parse(urls.iterator().next().absoluteString()));
                    content = linkBuilder.build();
                }
                MainActivity.current().getStateListener().launch((requestCode, resultCode, data)
                                -> callbackManager.onActivityResult(requestCode, resultCode, data),
                        () -> shareDialog.show(content));
            });
        } catch (Exception e) {
            Native.system().error("Unable to initialize Facebook account: " + e.toString(), null);
        }
    }
}
