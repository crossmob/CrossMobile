package org.crossmobile.backend.avian;

public class MouseEvent extends SDLEvent {
    public final int x;
    public final int y;

    public MouseEvent(int x, int y) {
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