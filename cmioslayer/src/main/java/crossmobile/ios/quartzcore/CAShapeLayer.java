/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.quartzcore;

import crossmobile.ios.coregraphics.CGPath;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

/**
 * A CALayer which defines a path to use as a drawing layer
 */
@CMClass
public class CAShapeLayer extends CALayer {
    private CGPath path;

    @CMGetter("@property CGPathRef path;")
    public CGPath path() {
        return path;
    }

    @CMSetter("@property CGPathRef path;")
    public void setPath(CGPath path) {
        this.path = path;
    }
}
