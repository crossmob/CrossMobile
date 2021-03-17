package org.crossmobile.backend.avian;

import org.crossmobile.backend.avian.event.AvianEvent;

public class SDLEvent implements AvianEvent {
  public static final int WINDOWEVENT = 512;
  public static final int MOUSEMOTION = 1024;
  public static final int MOUSEBUTTON = 1025;

  private final long peer;

  public int type;
  public int mask;

  public SDLEvent() {
    peer = initSDLEvent();
  }

  public boolean pollEvent() {
    return pollEvent(peer);
  }

  public int getType() {
    return getType(peer);
  }

  public byte getWindowEvent() {
    return getWindowEvent(peer);
  }

  private static native long initSDLEvent();
  private static native boolean pollEvent(long peer);
  private static native int getType(long peer);
  private static native byte getWindowEvent(long peer);
}