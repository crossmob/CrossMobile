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
package crossmobile.ios.coregraphics;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * CGLineJoin class defines different types of joining stroked lines when they
 * shape an angle.
 */
@CMEnum
public final class CGLineJoin {

    /**
     * The bond of the two stroked lines shapes a sharp corner.
     */
    public static final int Miter = 0;

    /**
     * The bond of the two stroked lines shapes a rounded corner.
     */
    public static final int Round = 1;

    /**
     * The bond of the two stroked lines shapes a beveled corner.
     */
    public static final int Bevel = 2;

    private CGLineJoin() {
    }
}
