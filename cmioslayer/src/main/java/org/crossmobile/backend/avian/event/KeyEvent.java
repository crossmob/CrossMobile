package org.crossmobile.backend.avian.event;

public class KeyEvent implements AvianEvent {

    public final char character;

    public KeyEvent(char character) {
        this.character = character;
    }
}
