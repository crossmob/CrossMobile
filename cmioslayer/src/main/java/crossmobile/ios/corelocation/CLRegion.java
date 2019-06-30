/*
 * (c) 2019 by Panayotis Katsaloulis
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
package crossmobile.ios.corelocation;

import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.foundation.NSSecureCoding;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * CLRegion class defines an object that represents an abstract trackable
 * region.
 */
@CMClass
public class CLRegion extends NSObject implements NSSecureCoding {

    private final CLLocationCoordinate2D center;
    private final double radius;
    private final String identifier;

    /**
     * Constructs a CLRegion object with specified parameters.
     *
     * @param center     The center of the region.
     * @param radius     The radius of the region.
     * @param identifier The String id of the region.
     */
    @Deprecated
    @CMConstructor("- (instancetype)initCircularRegionWithCenter:(CLLocationCoordinate2D)center \n"
            + "                                      radius:(CLLocationDistance)radius \n"
            + "                                  identifier:(NSString *)identifier;")
    public CLRegion(CLLocationCoordinate2D center, double radius, String identifier) {
        this.center = center;
        this.radius = radius;
        this.identifier = identifier;
    }

    /**
     * Returns the center of this region.
     *
     * @return The center of this region.
     */
    @Deprecated
    @CMGetter("@property(readonly, nonatomic) CLLocationCoordinate2D center;\n"
            + "")
    public CLLocationCoordinate2D center() {
        return center;
    }

    /**
     * Returns the String id of this region.
     *
     * @return The String id of this region.
     */
    @CMGetter("@property(readonly, nonatomic, copy) NSString *identifier;")
    public String identifier() {
        return identifier;
    }

    /**
     * Returns the outer boundary of this region expressed in meters.
     *
     * @return The outer boundary of this region expressed in meters.
     */
    @Deprecated
    @CMGetter("@property(readonly, nonatomic) CLLocationDistance radius;")
    public double radius() {
        return radius;
    }

    /**
     * Returns a Boolean that shows whether the specified coordinate is within
     * the bounds of this region.
     *
     * @param coordinate The coordinate that is checked.
     * @return TRUE if the specified coordinate is within the bounds of this
     * region.
     */
    @Deprecated
    @CMSelector("- (BOOL)containsCoordinate:(CLLocationCoordinate2D)coordinate;")
    public boolean containsCoordinate(CLLocationCoordinate2D coordinate) {
        return center.distanceFromCoordinates(coordinate) < radius;
    }
}
