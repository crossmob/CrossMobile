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
package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.*;

/**
 * NSRange class defines an object that represents a range defined by a location
 * and length.
 */
@CMStruct({"location", "length"})
public final class NSRange {

    /**
     * The index that represents the location of the NSRange.(starts with 0).
     */
    private int location;

    /**
     * The length of the NSRange.
     */
    private int length;

    /**
     * Constructs an NSRange object with the specified values for location and
     * length.
     *
     * @param location The location of the NSRange object.
     * @param length   The length of the NSRange object.
     */
    @CMConstructor(" NSRange NSMakeRange ( NSUInteger loc, NSUInteger len ); ")
    public NSRange(@CMRef("location") int location, @CMRef("length") int length) {
        this.location = location;
        this.length = length;
    }

    @CMGetter("NSUInteger location;")
    public int getLocation() {
        return location;
    }

    @CMSetter("NSUInteger location;")
    public void setLocation(int location) {
        this.location = location;
    }

    @CMGetter("NSUInteger length;")
    public int getLength() {
        return length;
    }

    @CMSetter("NSUInteger length;")
    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "NSRange from=" + location + " length=" + length;
    }
}
