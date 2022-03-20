/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.social;

import crossmobile.ios.foundation.NSURL;
import crossmobile.ios.uikit.UIImage;
import crossmobile.ios.uikit.UIViewController;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.SocialBridge.Handler;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;

import java.util.HashSet;
import java.util.Set;

/**
 * SLComposeViewController class defines a view that is used for the composition
 * of a post for one of the supported social networks.
 */
@CMClass
public class SLComposeViewController extends UIViewController {

    private final String serviceType;
    private final Handler handler;

    private SLComposeViewControllerCompletionHandler chandler;
    private Set<UIImage> images;
    private Set<NSURL> urls;
    private String initialText = "";
    private boolean isMutable = true;

    // Disabled due to block issues
//    /**
//     * Returns the handler that is called after the user has composed a post.
//     *
//     * @return The handler that is called after the user has composed a post.
//     */
//    @CMGetter("@property(nonatomic, copy) SLComposeViewControllerCompletionHandler* completionHandler")
//     SLComposeViewControllerCompletionHandler completionHandler() {
//        return chandler;
//    }

    /**
     * Sets the handler to be called after the user has composed a post.
     *
     * @param completionHandler The handler to be called after the user has
     *                          composed a post.
     */
    @CMSetter("@property(nonatomic, copy) SLComposeViewControllerCompletionHandler completionHandler;")
    public void setCompletionHandler(SLComposeViewControllerCompletionHandler completionHandler) {
        this.chandler = completionHandler;
    }

    /**
     * Returns a Boolean that shows whether you can send a request of the
     * particular type.
     *
     * @param serviceType The social networking service.
     * @return A Boolean that shows whether you can send a request of the
     * particular type.
     */
    @CMSelector("+ (BOOL)isAvailableForServiceType:(NSString *)serviceType")
    public static boolean isAvailableForServiceType(String serviceType) {
        return Native.social().getHandler(serviceType) != null;
    }

    /**
     * Creates and returns a new social compose view controller of the specified
     * type.
     *
     * @param serviceType The type of the social networking service.
     * @return A social compose view controller or NULL in case of failure.
     */
    @CMSelector("+ (SLComposeViewController*)composeViewControllerForServiceType:(NSString *)serviceType")
    public static SLComposeViewController composeViewControllerForServiceType(String serviceType) {
        Handler handler = Native.social().getHandler(serviceType);
        if (handler == null)
            return null;
        return new SLComposeViewController(serviceType, handler);
    }

    private SLComposeViewController(String serviceType, Handler handler) {
        this.serviceType = serviceType;
        this.handler = handler;
    }

    /**
     * Returns the social networking service.
     *
     * @return The social networking service.
     */
    @CMGetter("@property(nonatomic, readonly) NSString *serviceType")
    public String serviceType() {
        return serviceType;
    }

    /**
     * Sets the initial text to be posted.
     *
     * @param text The initial text.
     * @return TRUE if the operation was successfully completed.
     */
    @CMSelector("- (BOOL)setInitialText:(NSString *)text")
    public boolean setInitialText(String text) {
        if (isMutable)
            this.initialText = text == null ? "" : text;
        return isMutable;
    }

    /**
     * Adds the specified image to the post.
     *
     * @param image The image to be added to the post.
     * @return TRUE if the operation was successfully completed.
     */
    @CMSelector("- (BOOL)addImage:(UIImage *)image")
    public boolean addImage(UIImage image) {
        if (isMutable) {
            if (images == null)
                images = new HashSet<>();
            images.add(image);
        }
        return isMutable;
    }

    /**
     * Removes all images from the post.
     *
     * @return TRUE if the operation was successfully completed.
     */
    @CMSelector("- (BOOL)removeAllImages")
    public boolean removeAllImages() {
        if (isMutable)
            images = null;
        return isMutable;
    }

    /**
     * Adds the specified URL to the post.
     *
     * @param url The URL to be added to the post.
     * @return TRUE if the operation was successfully completed.
     */
    @CMSelector("- (BOOL)addURL:(NSURL *)url")
    public boolean addURL(NSURL url) {
        if (isMutable) {
            if (urls == null)
                urls = new HashSet<>();
            urls.add(url);
        }
        return isMutable;
    }

    /**
     * Removes all URLs from the post.
     *
     * @return TRUE if the URLs were successfully removed.
     */
    @CMSelector("- (BOOL)removeAllURLs")
    public boolean removeAllURLs() {
        if (isMutable)
            urls = null;
        return isMutable;
    }

    @Override
    public void viewWillAppear(boolean animated) {
        super.viewWillAppear(animated);
        isMutable = false;
        handler.launchSocial(initialText, images, urls, chandler);
    }
}
