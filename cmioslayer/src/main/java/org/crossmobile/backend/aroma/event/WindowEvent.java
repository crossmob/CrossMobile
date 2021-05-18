package org.crossmobile.backend.aroma.event;

public class WindowEvent implements AromaEvent {
    public static final int NONE = 0;
    public static final int SHOWN = 1;
    public static final int HIDDEN = 2;
    public static final int EXPOSED = 3;
    public static final int MOVED = 4;
    public static final int RESIZED = 5;
    public static final int SIZE_CHANGED = 6;
    public static final int MINIMIZED = 7;
    public static final int MAXIMIZED = 8;
    public static final int RESTORED = 9;
    public static final int ENTER = 10;
    public static final int LEAVE = 11;
    public static final int FOCUS_GAINED = 12;
    public static final int FOCUS_LOST = 13;
    public static final int CLOSE = 14;
    public static final int TAKE_FOCUS = 15;
    public static final int HIT_TEST = 16;

    public final int type;

    public WindowEvent(int type) {
        this.type = type;
    }

    public int getEventType() {
        return type;
    }
}
