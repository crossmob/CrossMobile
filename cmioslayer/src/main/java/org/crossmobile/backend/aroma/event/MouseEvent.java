package org.crossmobile.backend.aroma.event;

public class MouseEvent implements AromaEvent {
    public static final int BUTTON_1 = 1;
    public static final int BUTTON_2 = 2;
    public static final int BUTTON_3 = 4;
    public static final int BUTTON_4 = 8;
    public static final int BUTTON_5 = 16;

    private final int x;
    private final int y;

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
