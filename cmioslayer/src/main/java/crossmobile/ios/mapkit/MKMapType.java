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
package crossmobile.ios.mapkit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * MKMapType class defines different types of displayed maps.
 */
@CMEnum
public final class MKMapType {

    /**
     * The default type of map that shows cartographic images of roads with
     * names.
     */
    public static final int Standard = 0;

    /**
     * The type of map that represents photos taken from space.
     */
    public static final int Satellite = 1;

    /**
     * The type of map that is a combination of the satellite images and
     * cartographic images.
     */
    public static final int Hybrid = 2;

    private MKMapType() {
    }
}
