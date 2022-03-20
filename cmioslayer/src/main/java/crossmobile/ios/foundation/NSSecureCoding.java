/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;

@CMClass
public interface NSSecureCoding {
    @CMGetter("@property(class, readonly) BOOL supportsSecureCoding;")
    default boolean supportsSecureCoding() {
        return true;
    }
}
