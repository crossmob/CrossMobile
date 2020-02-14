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
package org.crossmobile.build;

import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

@CMLib(name = "cmioslayer", target = CMLibTarget.SOURCEONLY)
public final class AnnotationConfig {

    public static final String ANN_LOCATION = "ann";
    public static final String OUTLET_PGK = "org.crossmobile.sys";
    public static final String GENERATED_EXT = ".ibgenerated";
    public static final String OBJECTS_EXT = ".ibobjects";
    public static final String ACTION = "ACT";
    public static final String OUTLET = "OUT";
    public static final String NATIVE = "NTV";
    public static final String TARGET = "TGT";
    public static final String SEP = "\t";
    public static final String END = "\n";
}
