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

@CMClass
public class WKPreferences extends NSObject {
    private double minimumFontSize = 0;
    private boolean tabFocusesLinks = false;
    private boolean javaScriptCanOpenWindowsAutomatically = false;
    private boolean fraudulentWebsiteWarningEnabled = true;

    public WKPreferences() {
        this(null);
    }

    WKPreferences(WKPreferences other) {
        if (other != null) {
            this.minimumFontSize = other.minimumFontSize;
            this.tabFocusesLinks = other.tabFocusesLinks;
            this.javaScriptCanOpenWindowsAutomatically = other.javaScriptCanOpenWindowsAutomatically;
            this.fraudulentWebsiteWarningEnabled = other.fraudulentWebsiteWarningEnabled;
        }
    }

    @CMGetter("@property(nonatomic) CGFloat minimumFontSize;")
    public double minimumFontSize() {
        return minimumFontSize;
    }

    @CMSetter("@property(nonatomic) CGFloat minimumFontSize;")
    public void setMinimumFontSize(double minimumFontSize) {
        this.minimumFontSize = minimumFontSize;
    }

    @CMGetter("@property(nonatomic) BOOL tabFocusesLinks;")
    public boolean tabFocusesLinks() {
        return tabFocusesLinks;
    }

    @CMSetter("@property(nonatomic) BOOL tabFocusesLinks;")
    public void setTabFocusesLinks(boolean tabFocusesLinks) {
        this.tabFocusesLinks = tabFocusesLinks;
    }

    @CMGetter("@property(nonatomic) BOOL javaScriptCanOpenWindowsAutomatically;")
    public boolean javaScriptCanOpenWindowsAutomatically() {
        return javaScriptCanOpenWindowsAutomatically;
    }

    @CMSetter("@property(nonatomic) BOOL javaScriptCanOpenWindowsAutomatically;")
    public void setJavaScriptCanOpenWindowsAutomatically(boolean javaScriptCanOpenWindowsAutomatically) {
        this.javaScriptCanOpenWindowsAutomatically = javaScriptCanOpenWindowsAutomatically;
    }

    @CMGetter("@property(nonatomic, getter=isFraudulentWebsiteWarningEnabled) BOOL fraudulentWebsiteWarningEnabled;")
    public boolean isFraudulentWebsiteWarningEnabled() {
        return fraudulentWebsiteWarningEnabled;
    }

    @CMSetter("@property(nonatomic, getter=isFraudulentWebsiteWarningEnabled) BOOL fraudulentWebsiteWarningEnabled;")
    public void setFraudulentWebsiteWarningEnabled(boolean fraudulentWebsiteWarningEnabled) {
        this.fraudulentWebsiteWarningEnabled = fraudulentWebsiteWarningEnabled;
    }
}
