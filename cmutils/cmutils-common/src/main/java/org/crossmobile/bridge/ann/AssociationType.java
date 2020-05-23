/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge.ann;

@CMLib(target = CMLibTarget.APIJAVA)
public enum AssociationType {
    DEFAULT(false),
    ASSOCIATE(true),
    ADDSELF(true),
    REMOVESELF(true),
    WEAK(false);

    private final boolean needsAssociation;

    AssociationType(boolean strong) {
        this.needsAssociation = strong;
    }

    public boolean needsAccosiation() {
        return needsAssociation;
    }
}
