/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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
