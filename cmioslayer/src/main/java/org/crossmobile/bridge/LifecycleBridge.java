/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge;

import org.robovm.objc.block.Block0;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import static org.crossmobile.bridge.system.RuntimeCommons.CROSSMOBILE_PROPERTIES;

public interface LifecycleBridge extends Thread.UncaughtExceptionHandler {

    String UNKNOWN_NAME = "Unknown";
    String THEME_PROPERTIES = "theme.properties";

    /**
     * Load System properties BEFORE any initialization. It is the OS responsibility to properly initialize these valuees.
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
     * @param args user provided arguments which sould be passed to parseArguments
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

    /* The age of this application; when updating this age increases */
    long currentAgeInMillis();

    void notImplemented(String moreInfo);

    default void notImplemented() {
        notImplemented(null);
    }

    /**
     * Retrieve launch options from the environment and destroy them
     */
    Map<String, Object> consumeLaunchOptions();

    int getApplicationState();

    /**
     * Send a task to be executed once, when the system finds appropriate, i.e. after the current
     * drawing cycle, or immediately if no current drawing cycle is present.
     * <p>
     * The  uniqueness of the task is specified by the Runnable itself. It can be added more than
     * once, as long as the ""equality" of this class is taken into account
     * <p>
     * This command should exit as soon as possible, since it is run on the same thread as the
     * event/drawing thread. If you require tasks that take time and no visuals synchronization is
     * required, consider launching a new thread from inside the waiting task to perform the long
     * running process.
     *
     * @param task The task to run
     */
    void postWaitingTask(Runnable task);

    /**
     * Run a specific task in waiting task context. When the Block0 starts to run, all waiting tasks
     * are held for the block to continue.
     * <p>
     * When a method required to run something in context, and another thread is running, then this
     * thread is waiting for the other thread to finish first. Every time the run block is terminated,
     * the pending waiting tasks are run.
     *
     * @param commands A block of running commands to run in a waiting context
     * @param <T>      The optional return type
     * @return The result of this block of commands. Could be null.
     */
    <T> T runInContext(Block0<T> commands);
}
