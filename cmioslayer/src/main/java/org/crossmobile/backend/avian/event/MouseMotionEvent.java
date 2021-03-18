package org.crossmobile.backend.avian.event;

public class MouseMotionEvent extends MouseEvent {
    private final int buttonMask;

    public MouseMotionEvent(int x, int y, int buttonMask) {
        super(x, y);
        this.buttonMask = buttonMask;
    }

    public int getButtonMask() {
        return buttonMask;
    }
}
