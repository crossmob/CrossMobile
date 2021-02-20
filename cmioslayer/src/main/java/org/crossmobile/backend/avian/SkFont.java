package org.crossmobile.backend.avian;

import org.crossmobile.bind.graphics.NativeFont;

public class SkFont extends NativeElement implements NativeFont {
    private final String name;
    private final double size;

    private String family;
    private double ascent;
    private double descent;
    private double leading;
    private double capHeight;
    private double xHeight;

    public SkFont() {
        this("Palatino", 16.0);
    }

    public SkFont(String name, double size) {
        super(init(name, size));
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    public String getFamily() {
        return getFamily(peer);
    }

    public double getAscent() {
        return getAscent(peer);
    }

    public double getDescent() {
        return getDescent(peer);
    }

    public double getLeading() {
        return getLeading(peer);
    }

    public double getCapHeight() {
        return getCapHeight(peer);
    }

    public double getXHeight() {
        return getXHeight(peer);
    }

    @Override
    protected native void destroy(long peer);

    private static native long init(String name, double size);

    private static native String getFamily(long peer);

    private static native double getAscent(long peer);

    private static native double getDescent(long peer);

    private static native double getLeading(long peer);

    private static native double getCapHeight(long peer);

    private static native double getXHeight(long peer);
}
