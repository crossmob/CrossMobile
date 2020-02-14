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
package org.crossmobile.utils.images;

import java.text.DecimalFormat;

public final class IconSize {
    private final DecimalFormat sizeFormat = new DecimalFormat("#.#");
    private final double size;

    public final String name;
    public final int pixels;
    public final double scale;
    public final boolean required;

    private IconSize(double size, double scale, String name, boolean required) {
        this.size = size;
        this.scale = scale;
        this.required = required;
        this.pixels = (int) Math.round(size * scale);
        this.name = name == null ? "" : name;
    }

    public IconSize(double size) {
        this(size, null);
    }

    public IconSize(double size, String name) {
        this(size, 1, name, true);
    }

    public IconSize scale(double scale, String sizeName) {
        return new IconSize(size, this.scale * scale, sizeName, false);
    }

    public IconSize scale(double scale, boolean required) {
        return new IconSize(size, this.scale * scale, name, required);
    }

    public String pixels() {
        return String.valueOf(pixels);
    }

    public String size() {
        return sizeFormat.format(size);
    }
}