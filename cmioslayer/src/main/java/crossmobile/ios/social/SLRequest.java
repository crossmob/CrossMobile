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
package crossmobile.ios.social;

import crossmobile.ios.accounts.ACAccount;
import crossmobile.ios.foundation.NSData;
import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.foundation.NSURL;
import crossmobile.ios.foundation.NSURLRequest;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;

import java.util.Map;

/**
 * SLRequest class defines an object that represents a request made to a social
 * service.
 */
@CMClass
public class SLRequest extends NSObject {

    /**
     * Constructs a SLRequest object with the specified parameter values.
     *
     * @param serviceType   The service type of the social network.
     * @param requestMethod The HTTP request method.
     * @param url           The URL of the request.
     * @param parameters    The parameters of the request.
     * @return The SLRequest object that is created.
     */
    @CMSelector("+ (SLRequest *)requestForServiceType:(NSString *)serviceType \n"
            + "                       requestMethod:(SLRequestMethod)requestMethod \n"
            + "                                 URL:(NSURL *)url \n"
            + "                          parameters:(NSDictionary *)parameters;")
    public static SLRequest requestForServiceType(String serviceType, int requestMethod, NSURL url, Map parameters) {
        Native.lifecycle().notImplemented();
        return null;
    }

    /**
     * Returns corresponding account object for this request.
     *
     * @return The account for this request.
     */
    @CMGetter("@property(retain, nonatomic) ACAccount *account;")
    public ACAccount account() {
        Native.lifecycle().notImplemented();
        return null;
    }

    /**
     * Sets the account for this request.
     *
     * @param account The account for this request.
     */
    @CMSetter("@property(retain, nonatomic) ACAccount *account;")
    public void setAccount(ACAccount account) {
        Native.lifecycle().notImplemented();
    }

    /**
     * Returns method for this request.
     *
     * @return The method for this request.
     */
    @CMGetter("@property(readonly, nonatomic) SLRequestMethod requestMethod;\n"
            + "")
    public int requestMethod() {
        Native.lifecycle().notImplemented();
        return 0;
    }

    /**
     * The URL of this request.
     *
     * @return The URL of this request.
     */
    @CMGetter("@property(readonly, nonatomic) NSURL *URL;")
    public NSURL URL() {
        Native.lifecycle().notImplemented();
        return null;
    }

    /**
     * Returns a map containing the parameters of this request.
     *
     * @return The map that contains the parameters of this request.
     */
    @CMGetter("@property(readonly, nonatomic) NSDictionary *parameters;")
    public Map parameters() {
        Native.lifecycle().notImplemented();
        return null;
    }

    /**
     * Adds a multipart POST with the specified parameters.
     *
     * @param data     The data of the multipart POST.
     * @param name     The name of the multipart POST.
     * @param type     The type of the multipart POST.
     * @param filename The filename of the multipart POST.
     */
    @CMSelector("- (void)addMultipartData:(NSData *)data \n"
            + "                withName:(NSString *)name \n"
            + "                    type:(NSString *)type \n"
            + "                filename:(NSString *)filename;")
    public void addMultipartData(NSData data, String name, String type, String filename) {
        Native.lifecycle().notImplemented();
    }

    /**
     * Returns a prepared URL request.
     *
     * @return The prepared URL request.
     */
    @CMSelector("- (NSURLRequest *)preparedURLRequest;\n"
            + "")
    public NSURLRequest preparedURLRequest() {
        Native.lifecycle().notImplemented();
        return null;
    }

    /**
     * Calls the specified handler for this request.
     *
     * @param handler The handler for this request.
     */
    @CMSelector("- (void)performRequestWithHandler:(SLRequestHandler)handler;\n"
            + "")
    public void performRequestWithHandler(SLRequestHandler handler) {
        Native.lifecycle().notImplemented();
    }
}
