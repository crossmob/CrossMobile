/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.contacts;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;

@CMClass
public class CNContainer extends NSObject {

    private String identifier;
    private String name;
    private CNContainerType type;

    private CNContainer() {
    }

}
