package org.crossmobile.backend.avian;

public abstract class NativeElement {
    final long peer;

    NativeElement(long peer) {
        this.peer = peer;
    }

    final long getPeer() {
        return peer;
    }

    @Override
    protected final void finalize() throws Throwable {
        destroy(peer);
    }

    protected abstract void destroy(long peer);
}
