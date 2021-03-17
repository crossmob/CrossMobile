package org.crossmobile.backend.avian.event;

public class MouseButtonEvent implements AvianEvent {
    public static final int LEFT_BUTTON = 1;
    public static final int MIDDLE_BUTTON = 2;
    public static final int RIGHT_BUTTON = 3;

    public final int x;
    public final int y;
    public final int mask;

    public MouseButtonEvent(int mask, int x, int y) {
        this.mask = mask;
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
