package org.crossmobile.backend.avian.event;

public class KeyEvent implements AvianEvent {
    private final char character;

    public KeyEvent(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}
