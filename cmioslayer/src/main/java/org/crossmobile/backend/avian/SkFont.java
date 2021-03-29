package org.crossmobile.backend.avian;

import crossmobile.ios.coregraphics.CGSize;
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
        if (!postInit(this.peer))
            throw new IllegalArgumentException("Unable to initialize font " + name + " with size " + size);
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
        return family;
    }

    public double getAscent() {
        return ascent;
    }

    public double getDescent() {
        return descent;
    }

    public double getLeading() {
        return leading;
    }

    public double getCapHeight() {
        return capHeight;
    }

    public double getXHeight() {
        return xHeight;
    }

    public CGSize measureText(String text) {
        return measureText(peer, text);
    }

    public double ascentText(String text) {
        return ascentText(peer, text);
    }

    @Override
    public String toString() {
        return "SkFont{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", family='" + family + '\'' +
                ", ascent=" + ascent +
                ", descent=" + descent +
                ", leading=" + leading +
                ", capHeight=" + capHeight +
                ", xHeight=" + xHeight +
                '}';
    }

    @Override
    protected native void destroy(long peer);

    private static native long init(String name, double size);

    private native boolean postInit(long peer);

    private static native CGSize measureText(long peer, String text);

    private static native double ascentText(long peer, String text);
}
