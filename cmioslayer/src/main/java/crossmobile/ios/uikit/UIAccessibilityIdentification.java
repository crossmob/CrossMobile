/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

/**
 * Class to help automated tests
 */
@CMClass
public interface UIAccessibilityIdentification {
    /**
     * Set an id to this instance to be discoverable
     *
     * @param accessibilityIdentifier the proposed ID
     */
    @CMSetter("@property(nonatomic, copy) NSString *accessibilityIdentifier;")
    void setAccessibilityIdentifier(String accessibilityIdentifier);

    /**
     * Retrieve the assigned ID of this instance
     *
     * @return the assigned ID
     */
    @CMGetter("@property(nonatomic, copy) NSString *accessibilityIdentifier;")
    String accessibilityIdentifier();
}
