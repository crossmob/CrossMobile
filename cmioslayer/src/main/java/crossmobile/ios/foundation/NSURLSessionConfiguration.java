/*
 * (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
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
