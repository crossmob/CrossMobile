package org.crossmobile.backend.avian.event;

public class WindowEvent implements AvianEvent {
    public static final int CLOSE = 14;

    public final int type;

    public WindowEvent(int type) {
        this.type = type;
    }
}
