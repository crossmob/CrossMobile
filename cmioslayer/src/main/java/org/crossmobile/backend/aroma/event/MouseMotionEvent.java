package org.crossmobile.backend.aroma.event;

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
