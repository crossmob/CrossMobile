package org.crossmobile.backend.avian;

public class SDLWindow extends NativeElement {

    public SDLWindow(String title) {
        super(init(title));
    }

    public void setSize(int width, int height) {
        setSize(peer, width, height);
    }

    public int getWidth() {
        return getWidth(peer);
    }

    public int getHeight() {
        return getHeight(peer);
    }

    public void update() {
        update(peer);
    }

    private static native long init(String title);

    private static native void setSize(long peer, int width, int height);

    protected native void destroy(long peer);

    private static native int getWidth(long peer);

    private static native int getHeight(long peer);

    private static native void update(long peer);
}