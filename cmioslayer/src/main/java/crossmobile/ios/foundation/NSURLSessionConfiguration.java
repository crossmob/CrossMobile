/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;

@CMClass
public class NSURLSessionConfiguration extends NSObject {

    private String sharedContainerIdentifier;

    //    @property(class, readonly, strong) NSURLSessionConfiguration *defaultSessionConfiguration;
//    @property(class, readonly, strong) NSURLSessionConfiguration *ephemeralSessionConfiguration;
    @CMSelector("+ (NSURLSessionConfiguration *)backgroundSessionConfigurationWithIdentifier:(NSString *)identifier;")
    public static NSURLSessionConfiguration backgroundSessionConfigurationWithIdentifier(String identifier) {
        return null;
    }
//    @property(readonly, copy) NSString *identifier;
//    @property(copy) NSDictionary *HTTPAdditionalHeaders;
//    @property NSURLRequestNetworkServiceType networkServiceType;
//    @property BOOL allowsCellularAccess;
//    @property NSTimeInterval timeoutIntervalForRequest;
//    @property NSTimeInterval timeoutIntervalForResource;

    @CMGetter("@property(copy) NSString *sharedContainerIdentifier;")
    public String sharedContainerIdentifier() {
        return sharedContainerIdentifier;
    }

    @CMSetter("@property(copy) NSString *sharedContainerIdentifier;")
    public void setSharedContainerIdentifier(String sharedContainerIdentifier) {
        this.sharedContainerIdentifier = sharedContainerIdentifier;
    }
//    @property NSHTTPCookieAcceptPolicy HTTPCookieAcceptPolicy;
//    @property(retain) NSHTTPCookieStorage *HTTPCookieStorage;
//    @property BOOL HTTPShouldSetCookies;
//    @property SSLProtocol TLSMaximumSupportedProtocol;
//    @property SSLProtocol TLSMinimumSupportedProtocol;
//    @property(retain) NSURLCredentialStorage *URLCredentialStorage;
//    @property(retain) NSURLCache *URLCache;
//    @property NSURLRequestCachePolicy requestCachePolicy;
//    @property BOOL sessionSendsLaunchEvents;
//    @property(getter=isDiscretionary) BOOL discretionary;
//    @property(copy) NSArray<Class> *protocolClasses;
//    @property NSInteger HTTPMaximumConnectionsPerHost;
//    @property BOOL HTTPShouldUsePipelining;
//    @property(copy) NSDictionary *connectionProxyDictionary;
//    @Deprecated
//    + (NSURLSessionConfiguration *)backgroundSessionConfiguration:(NSString *)identifier;
//    @property BOOL shouldUseExtendedBackgroundIdleMode;
}
