package org.crossmobile.backend.avian;

public class SDLWindowEvent extends SDLEvent {
  public static final int CLOSE = 14;

  public SDLWindowEvent(int type, int mask) {
    this.type = type;
    this.mask = mask;
  }
}
