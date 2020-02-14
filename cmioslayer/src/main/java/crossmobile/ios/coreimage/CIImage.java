/*
 * (c) 2020 by Panayotis Katsaloulis
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
package crossmobile.ios.coreimage;

import crossmobile.ios.coregraphics.CGImage;
import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.foundation.NSSecureCoding;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * CIImage class defines an object that is used by the CIFilter class.
 */
@CMClass
public class CIImage extends NSObject implements NSSecureCoding {

    private final CGImage img;

    /**
     * Constructs and returns an empty CIImage object.
     *
     * @return An empty CIImage object.
     */
    @CMSelector("+ (CIImage *)emptyImage;")
    public static CIImage emptyImage() {
        return new CIImage(null);
    }

    /**
     * Constructs a CIImage object using the specified CGImage.
     *
     * @param img The CGImage object used.
     */
    @CMConstructor("- (instancetype)initWithCGImage:(CGImageRef)image;")
    public CIImage(CGImage img) {
        this.img = img;
    }

    private CIImage() {
        this(null);
    }

    /**
     * Constructs and returns a CGImage object.
     *
     * @return A CGImage object.
     */
    @CMGetter("@property(nonatomic, readonly) CGImageRef CGImage;")
    public CGImage CGImage() {
        return img;
    }

}
