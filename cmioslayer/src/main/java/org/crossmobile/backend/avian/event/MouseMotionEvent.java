package org.crossmobile.backend.avian.event;

public class MouseMotionEvent implements AvianEvent {
    public final int x;
    public final int y;

    public MouseMotionEvent(int x, int y) {
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
