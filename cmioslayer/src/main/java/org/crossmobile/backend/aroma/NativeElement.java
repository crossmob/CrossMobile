package org.crossmobile.backend.aroma;

public abstract class NativeElement {
    final long peer;

    NativeElement(long peer) {
        if (peer == 0)
            throw new NullPointerException("Unable to initialize " + getClass().getName());
        this.peer = peer;
    }

    final long getPeer() {
        return peer;
    }

    @Override
    protected final void finalize() {
        destroy(peer);
    }

    protected abstract void destroy(long peer);
}
