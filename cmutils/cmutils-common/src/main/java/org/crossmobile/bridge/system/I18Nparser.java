/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge.system;

import org.crossmobile.bridge.ann.CMLib;

import static org.crossmobile.bridge.ann.CMLibTarget.SOURCEONLY;

@CMLib(target = SOURCEONLY)
public class I18Nparser {
    public static final String FORMAT="%";
    public static final String TYPE="?";

    public static final String ZERO = "z";
    public static final String ONE = "o";
    public static final String TWO = "t";
    public static final String FEW = "f";
    public static final String MANY = "m";
    public static final String OTHER = "*";
}
