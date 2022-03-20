/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.storekit;

import crossmobile.ios.foundation.NSError;
import org.crossmobile.bind.io.InAppBridgeExt.ProductList;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

import java.util.ArrayList;
import java.util.Set;

import static org.crossmobile.bind.system.AbstractLifecycleBridge.errorFromInfo;
import static org.crossmobile.bind.system.i18n.I18NSelf.ℑ;

/**
 * SKProductsRequest class defines an object that is used in order to request
 * local information about products of the App Store.
 */
@CMClass
public class SKProductsRequest extends SKRequest {

    private SKProductsRequestDelegate productsDelegate;
    private final Set<String> productIdentifiers;

    /**
     * Constructs a SKProductsRequest object with the specified identifiers.
     *
     * @param productIdentifiers The identifiers of the SKProductsRequest object
     */
    @CMConstructor("- (instancetype)initWithProductIdentifiers:(NSSet<NSString *> *)productIdentifiers;")
    public SKProductsRequest(Set<String> productIdentifiers) {
        this.productIdentifiers = productIdentifiers;
    }

    /**
     * Returns the delegate of this SKProductsRequest object.
     *
     * @return The delegate of this SKProductsRequest object.
     */
    @CMGetter("@property(nonatomic, assign) id<SKProductsRequestDelegate> delegate;")
    public SKProductsRequestDelegate productsDelegate() {
        return productsDelegate;
    }

    /**
     * Sets the specified delegate for this SKProductsRequest object.
     *
     * @param delegate The delegate of this SKProductsRequest object.
     */
    @CMSetter("@property(nonatomic, assign) id<SKProductsRequestDelegate> delegate;")
    public void setDelegate(SKProductsRequestDelegate delegate) {
        this.productsDelegate = delegate;
    }

    @Override
    public void start() {
        Native.inapp().requestValidProducts(productIdentifiers, (ProductList result) -> {
            if (result == null || result.error != null) {
                String error = result == null ? ℑ("Unable to connect") : result.error;
                if (delegate != null)
                    delegate.didFailWithError(SKProductsRequest.this, NSError.errorWithDomain(NSError.Domain.SKError, SKError.ClientInvalid, errorFromInfo(error)));
                if (productsDelegate != null)
                    productsDelegate.didReceiveResponse(SKProductsRequest.this, new SKProductsResponse(new ArrayList<>(productIdentifiers), new ArrayList<>()));
            } else {
                if (delegate != null)
                    delegate.didFinish(SKProductsRequest.this);
                if (productsDelegate != null)
                    productsDelegate.didReceiveResponse(SKProductsRequest.this,
                            new SKProductsResponse(
                                    result.invalidIDs == null ? new ArrayList<>(productIdentifiers) : result.invalidIDs,
                                    result.products == null ? new ArrayList<>() : result.products));
            }
        });
    }

    @Override
    public void cancel() {
        Native.system().notImplemented();
    }
}
