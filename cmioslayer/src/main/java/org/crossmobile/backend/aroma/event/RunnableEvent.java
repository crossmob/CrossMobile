package org.crossmobile.backend.aroma.event;

public class RunnableEvent implements AromaEvent, Runnable {
    private final Runnable runnable;

    public RunnableEvent(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void run() {
        runnable.run();
    }
}
