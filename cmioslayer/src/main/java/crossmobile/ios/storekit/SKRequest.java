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
package crossmobile.ios.storekit;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;

/**
 * SKRequest abstract class defines methods for handling requests send to the
 * App Store.
 */
@CMClass
public abstract class SKRequest extends NSObject {

    SKRequestDelegate delegate;

    /**
     * Returns the delegate of this SKRequest.
     *
     * @return The delegate of this SKRequest.
     */
    @CMGetter("@property(nonatomic, assign) id<SKRequestDelegate> delegate;")
    public SKRequestDelegate delegate() {
        return delegate;
    }

    /**
     * Sets the specified delegate for this SKRequest.
     *
     * @param delegate The delegate for this SKRequest.
     */
    @CMSetter("@property(nonatomic, assign) id<SKRequestDelegate> delegate;")
    public void setDelegate(SKRequestDelegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Initiates request sending to the App Store.
     */
    @CMSelector("- (void)start;")
    public abstract void start();

    /**
     * Cancels request sending to the App Store.
     */
    @CMSelector("- (void)cancel;")
    public abstract void cancel();
}
