package org.crossmobile.backend.aroma.event;

public class MouseButtonEvent extends MouseEvent {
    private final int button;
    private final boolean pressDown;

    public MouseButtonEvent(int button, int x, int y, boolean pressDown) {
        super(x, y);
        this.button = button;
        this.pressDown = pressDown;
    }

    public int getButton() {
        return button;
    }

    public boolean isPressDown() {
        return pressDown;
    }
}
