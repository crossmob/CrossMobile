package org.crossmobile.backend.aroma.event;

public class KeyEvent implements AromaEvent {
    private final char character;

    public KeyEvent(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}
