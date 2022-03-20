/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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