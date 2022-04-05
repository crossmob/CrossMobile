/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge;

import crossmobile.ios.foundation.NSTimer;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import static org.crossmobile.bridge.system.RuntimeCommons.CROSSMOBILE_PROPERTIES;

public interface LifecycleBridge extends Thread.UncaughtExceptionHandler {

    String THEME_PROPERTIES = "theme.properties";

    /**
     * Load System properties BEFORE any initialization. It is the OS responsibility to properly initialize these values.
     */
    default void loadSystemProperties() {
        try {
            System.getProperties().load(new InputStreamReader(Native.file().getFileStream(Native.file().getApplicationPrefix() + "/" + CROSSMOBILE_PROPERTIES), "UTF-8"));
        } catch (IOException ex) {
            Native.lifecycle().quit("Corrupted CrossMobile application: " + ex.toString(), ex);
            return;
        }
        try {
            System.getProperties().load(new InputStreamReader(Native.file().getFileStream(Native.file().getApplicationPrefix() + "/" + THEME_PROPERTIES), "UTF-8"));
        } catch (Exception ignored) {
        }
    }

    /**
     * Initialize bridge. This method should guarantee to call the parseArguments method.
     *
     * @param args user provided arguments which should be passed to parseArguments
     */
    void init(String[] args);

    /**
     * Parse command line arguments. This method is called from inside init method
     *
     * @param args user provided arguments as passed by init
     */
    void parseArguments(String[] args);

    void splashTerminated();

    void activate();

    void deactivate();

    void quit(String error, Throwable throwable);

    /**
     * The age of this application; when updating this age increases
     */
    long currentAgeInMillis();

    /**
     * Retrieve launch options from the environment and destroy them
     */
    Map<String, Object> consumeLaunchOptions();

    int getApplicationState();

    /**
     * Use this method to run some code to the event thread as fast as possible.
     * If this is already the event thread, directly run this code and then
     * return.
     * <p>
     * MAKE SURE that this method will run & return IMMEDIATELY when run from
     * the dispatch thread; else, the UIRunner will block.
     *
     * @param runnable The code to run
     */
    void runOnEventThread(Runnable runnable);

    /**
     * Run some code on the event thread as fast as possible,
     * and wait for this process to finish.
     *
     * @param runnable The code to run
     */
    void runAndWaitOnEventThread(Runnable runnable);

    /**
     * Use this method to run some code in later time, in the event thread. Even
     * if this is the event thread, do not run directly but run after the
     * current event cycle.
     *
     * @param runnable The code to run
     */
    void postOnEventThread(Runnable runnable);

    /**
     * Run without throwing any exceptions
     *
     * @param r the runnable to run
     */
    default void safeRun(Runnable r) {
        try {
            r.run();
        } catch (Throwable th) {
            Native.system().error("Unable to safely run routine", th);
        }
    }

    boolean isEventThread();

    /**
     * Send a task to be executed once on the event thread, when the system finds appropriate,
     * i.e. after the current drawing or event handling cycle, or immediately if no current
     * event thread working is performed.
     * <p>
     * The  uniqueness of the task is specified by the Runnable itself. It can be added more than
     * once, as long as the "equality" of this class is taken into account
     * <p>
     * This command should exit as soon as possible, since it is run on the same thread as the
     * event/drawing thread. If you require tasks that take time and no visuals synchronization is
     * required, consider launching a new thread from inside the waiting task to perform the long
     * running process.
     *
     * @param task The task to run
     */
    void runLaterOnceOnEventThread(Runnable task);

    /**
     * Run all postponed tasks right now. This method should be called from the event thread.
     *
     * @see #runLaterOnceOnEventThread(Runnable)
     */
    void drainWaitingTasks();

    /**
     * Run a specific task in waiting task context. THIS METHOD SHOULD ONLY BE CALLED FROM THE EVENT THREAD.
     * <p>
     * When a method required to run something in context, and another thread is running, then this
     * thread is waiting for the other thread to finish first. Every time the run block is terminated,
     * the pending waiting tasks are run.
     *
     * @param commands A block of running commands to run in a waiting context
     */
    void encapsulateContext(Runnable commands);

    /**
     * Create the system timer which is responsible to post NSTimer events.
     * This is the equivalent of retrieving the NSRunLoop of current system.
     * <p>
     * By default a new Thread will be spawned which will run and forward
     * events the the actual run thread. It is highly advisable to override
     * this method and provide a system-native implementation of delayed
     * post events.
     *
     * @return the {@link SystemTimerHandler} of current system.
     */
    SystemTimerHandler createSystemTimer();

    /**
     * Inform animation mechanism that animations are still active.
     * It is <b>required</b> to call this method after each frame, to inform the system
     * that more animation frames are available.
     * <p>
     * This method should only be called from the event thread.
     *
     * @param enabled Toggle animation mechanism on and off.
     */
    void hasAnimationFrames(boolean enabled);

    default void requireEventThread() {
        if (!isEventThread())
            throw new RuntimeException("This method should be called on the event thread");
    }

    /**
     * Do whatever it takes to make current thread the main event loop thread.
     * Usually this is done automatically by the system and this method should be empty.
     * <p>
     * In the rare case that current java implementation doesn't really have a main event loop,
     * then this method should trigger the event loop mechanism (i.e. under SDL and related technologies).
     */
    void handleEventLoop();

    interface SystemTimerHandler {

        void addTimer(NSTimer timer);

        void quitTimers();
    }
}
