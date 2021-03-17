package org.crossmobile.backend.avian;

public class SDLMouseEvent extends SDLEvent {
    public static final int LEFT_BUTTON = 1;
    public static final int MIDDLE_BUTTON = 2;
    public static final int RIGHT_BUTTON = 3;

    public final int x;
    public final int y;

    public SDLMouseEvent(int type, int mask, int x, int y) {
        this.type = type;
        this.mask = mask;
        this.x = x;
        this.y = y;
    }

    public SDLMouseEvent(int type, int x, int y) {
        this.type = type;
        this.mask = 0;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}