/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.webkit;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

/**
 * Configuration object for WKWebView
 */
@CMClass
public class WKWebViewConfiguration extends NSObject {

    private String applicationNameForUserAgent;
    private WKPreferences preferences;
    private WKUserContentController userContentController;

    public WKWebViewConfiguration() {
        this(null);
    }

    WKWebViewConfiguration(WKWebViewConfiguration other) {
        if (other != null) {
            this.applicationNameForUserAgent = other.applicationNameForUserAgent;
            if (other.preferences != null)
                this.preferences = new WKPreferences(other.preferences);
            if (other.userContentController != null)
                this.userContentController = new WKUserContentController(other.userContentController);
        }
    }

    @CMGetter("@property(nullable, nonatomic, copy) NSString *applicationNameForUserAgent;")
    public String applicationNameForUserAgent() {
        return applicationNameForUserAgent;
    }

    @CMSetter("@property(nullable, nonatomic, copy) NSString *applicationNameForUserAgent;")
    public void setApplicationNameForUserAgent(String applicationNameForUserAgent) {
        this.applicationNameForUserAgent = applicationNameForUserAgent;
    }

    @CMGetter("@property(nonatomic, strong) WKPreferences *preferences;")
    public WKPreferences preferences() {
        if (preferences == null)
            preferences = new WKPreferences();
        return preferences;
    }

    @CMSetter("@property(nonatomic, strong) WKPreferences *preferences;")
    public void setPreferences(WKPreferences preferences) {
        this.preferences = preferences;
    }

    @CMGetter("@property(nonatomic, strong) WKUserContentController *userContentController;")
    public WKUserContentController userContentController() {
        if (userContentController == null)
            userContentController = new WKUserContentController();
        return userContentController;
    }

    @CMSetter("@property(nonatomic, strong) WKUserContentController *userContentController;")
    public void setUserContentController(WKUserContentController userContentController) {
        this.userContentController = userContentController;
    }
}
