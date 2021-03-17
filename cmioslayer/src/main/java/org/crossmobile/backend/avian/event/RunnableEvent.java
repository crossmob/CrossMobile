package org.crossmobile.backend.avian.event;

public class RunnableEvent implements AvianEvent, Runnable {
    private final Runnable runnable;

    public RunnableEvent(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void run() {
        runnable.run();
    }
}
