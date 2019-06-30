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
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;

/**
 * NSURLResponse class defines an object that represents a response to an HTTP
 * URL load request and it used in collaboration with the NSURLRequest objects.
 */
@CMClass
public class NSURLResponse extends NSObject {

    /**
     * The length of URL is unknown. Used for error handling.
     */
    public static final long UnknownLength = -1;
    //
    private final NSURL URL;
    private final String MIMEType;
    private final int expectedContentLength;
    private final String textEncodingName;

    /**
     * Constructs a NSURLResponse object with the specified parameters.
     *
     * @param URL                   The URL of the new NSURLResponse.
     * @param MIMEType              The MIME type.
     * @param expectedContentLength The content length.
     * @param textEncodingName      The text encoding name.
     */
    @CMConstructor("- (instancetype)initWithURL:(NSURL *)URL \n"
            + "                   MIMEType:(NSString *)MIMEType \n"
            + "      expectedContentLength:(NSInteger)length \n"
            + "           textEncodingName:(NSString *)name;")
    public NSURLResponse(NSURL URL, String MIMEType, int expectedContentLength, String textEncodingName) {
        this(URL, MIMEType + ";" + textEncodingName, expectedContentLength);
    }

    NSURLResponse(NSURL URL, String mime_enc, int expectedContentLength) {
        this.URL = URL;
        this.expectedContentLength = expectedContentLength;

        if (mime_enc == null) {
            MIMEType = null;
            textEncodingName = null;
        } else {
            int semicolon = mime_enc.indexOf(';');
            if (semicolon < 0) {
                MIMEType = mime_enc;
                textEncodingName = null;
            } else {
                MIMEType = mime_enc.substring(0, semicolon);
                textEncodingName = mime_enc.substring(semicolon + 1).trim();
            }
        }
    }

    /**
     * Returns a default NSURL object.
     *
     * @return The default NSURL object.
     */
    @CMGetter("@property(readonly, copy) NSURL *URL;")
    public NSURL URL() {
        return URL;
    }

    /**
     * Returns the MIME type of the response.
     *
     * @return The MIME type of the response.
     */
    @CMGetter("@property(readonly, copy) NSString *MIMEType;")
    public String MIMEType() {
        return MIMEType;
    }

    /**
     * Returns the expected length of the response.
     *
     * @return The expected length of the response.
     */
    @CMGetter("@property(readonly) long long expectedContentLength;")
    public long expectedContentLength() {
        return expectedContentLength;
    }

    /**
     * Returns the name of the text encoding that is used.
     *
     * @return The name of the text encoding that is used.
     */
    @CMGetter("@property(readonly, copy) NSString *textEncodingName;")
    public String textEncodingName() {
        return textEncodingName;
    }
}
