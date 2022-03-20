/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.build;

import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

@CMLib(name = "cmioslayer", target = CMLibTarget.SOURCEONLY)
public final class AnnotationConfig {

    public static final String ANN_LOCATION = "ann";
    public static final String GENERATED_EXT = ".ibgenerated";
    public static final String OBJECTS_EXT = ".ibobjects";
    public static final String ACTION = "ACT";
    public static final String OUTLET = "OUT";
    public static final String NATIVE = "NTV";
    public static final String TARGET = "TGT";
    public static final String SEP = "\t";
    public static final String END = "\n";
}
