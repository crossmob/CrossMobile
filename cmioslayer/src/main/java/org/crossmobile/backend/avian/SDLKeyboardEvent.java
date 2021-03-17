package org.crossmobile.backend.avian;

public class SDLKeyboardEvent extends SDLEvent {
  public SDLKeyboardEvent (int type, int mask) {
    this.type = type;
    this.mask = mask;
  }
}
