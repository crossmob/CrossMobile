/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.*;
import org.robovm.objc.block.VoidBlock1;

/**
 * NSTimer class defines an object that represents a timer that is used for
 * scheduling actions.
 */
@CMClass
public class NSTimer extends NSObject {

    private final double timerInterval;
    private final NSTimerDelegate target;
    private final Object userInfo;
    private boolean valid;
    private long fireMillis;
    final boolean repeats;

    // These variables are used for increased precision when calculating executable time
    private double start;
    private long timeTicks;

    @CMConstructor("- (instancetype)initWithFireDate:(NSDate *)date \n" +
            "                        interval:(NSTimeInterval)interval \n" +
            "                         repeats:(BOOL)repeats \n" +
            "                           block:(void (^)(NSTimer *timer))block;")
    public NSTimer(NSDate date, double interval, boolean repeats, VoidBlock1<NSTimer> block) {
        this(date, interval, block::invoke, null, repeats);
    }

    @CMConstructor("- (instancetype)initWithFireDate:(NSDate *)date \n" +
            "                        interval:(NSTimeInterval)ti \n" +
            "                          target:(id)t \n" +
            "                        selector:(SEL)s \n" +
            "                        userInfo:(id)ui \n" +
            "                         repeats:(BOOL)rep;")
    public NSTimer(NSDate date, double ti, @CMJoinSEL(selector = "s", target = "t") NSTimerDelegate target, Object ui, boolean rep) {
        this.userInfo = ui;
        this.valid = true;
        this.timerInterval = rep || ti >= 0 ? ti : 0;
        start = System.currentTimeMillis() / 1000d + ti;
        this.fireMillis = Math.round(start * 1000);
        timeTicks = 0;
        if (date != null)
            setFireDate(date);
        this.repeats = rep;
        this.target = target;
    }

    /**
     * Constructs and returns a new timer with the specified parameter values
     * and schedules it on the current run loop.
     *
     * @param seconds  The seconds between repetitions.
     * @param target   The delegate object that is related to this timer.
     * @param userinfo User information incorporated into this timer.
     * @param repeats  TRUE then the timer triggering is repeated.
     * @return A new timer with the specified parameter values.
     */
    @CMSelector("+ (NSTimer *)timerWithTimeInterval:(NSTimeInterval)ti\n"
            + "                            target:(id)target\n"
            + "                          selector:(SEL)aSelector\n"
            + "                          userInfo:(id)userInfo\n"
            + "                           repeats:(BOOL)repeats")
    public static NSTimer timerWithTimeInterval(double seconds, @CMJoinSEL(selector = "aSelector", target = "target") NSTimerDelegate target, Object userinfo, boolean repeats) {
        return new NSTimer(null, seconds, target, userinfo, repeats);
    }

    /**
     * Constructs and returns a new timer with the specified parameter values.
     *
     * @param seconds  The seconds between repetitions.
     * @param target   The delegate object that is related to this timer.
     * @param userinfo User information incorporated into this timer.
     * @param repeats  TRUE then the timer triggering is repeated.
     * @return A new timer with the specified parameter values.
     */
    @CMSelector("+ (NSTimer *)scheduledTimerWithTimeInterval:(NSTimeInterval)ti\n"
            + "                                     target:(id)target\n"
            + "                                   selector:(SEL)aSelector\n"
            + "                                   userInfo:(id)userInfo\n"
            + "                                    repeats:(BOOL)repeats")
    public static NSTimer scheduledTimerWithTimeInterval(double seconds, @CMJoinSEL(selector = "aSelector", target = "target") NSTimerDelegate target, Object userinfo, boolean repeats) {
        NSTimer timer = timerWithTimeInterval(seconds, target, userinfo, repeats);
        NSRunLoop.mainRunLoop().addTimer(timer, NSRunLoopMode.Default);
        return timer;
    }

    /**
     * Returns a Boolean that shows whether the timer is currently active.
     *
     * @return TRUE the timer is currently active.
     */
    @CMGetter("@property(readonly, getter=isValid) BOOL valid;")
    public boolean isValid() {
        return valid;
    }

    /**
     * Returns the date at which this timer fires.
     *
     * @return The date at which this timer fires.
     */
    @CMGetter("@property(copy) NSDate *fireDate;")
    public NSDate fireDate() {
        return NSDate.dateWithTimeIntervalSince1970(fireMillis / 1000d);
    }

    long fireMillis() {
        return fireMillis;
    }

    /**
     * Sets the date at which this timer fires.
     *
     * @param date The date at which this timer fires.
     */
    @CMSetter("@property(copy) NSDate *fireDate;")
    public void setFireDate(NSDate date) {
        fireMillis = Math.max(Math.round(date.secondsSince1970 * 1000), System.currentTimeMillis());
        timeTicks = 0;
        start = fireMillis / 1000d;
    }

    /**
     * Returns the time interval of the timer.
     *
     * @return The time between two successive calls of the timer.
     */
    @CMGetter("@property(readonly) NSTimeInterval timeInterval;")
    public double timeInterval() {
        return timerInterval;
    }

    /**
     * Returns the user information of the timer.
     *
     * @return The user information of the timer.
     */
    @CMGetter("@property(readonly, retain) id userInfo;")
    public Object userInfo() {
        return userInfo;
    }

    /**
     * Cancels this timer permanently.
     */
    @CMSelector("- (void)invalidate;")
    public void invalidate() {
        valid = false;
    }

    /**
     * Triggers this timer.
     */
    @CMSelector("- (void)fire;")
    public void fire() {
        if (!valid)
            return;
        if (target != null)
            target.fireMethod(this);
        if (!repeats)
            invalidate();
        else {
            long now = System.currentTimeMillis();
            do {
                fireMillis = Math.round(1000 * (timeTicks * timerInterval + start));
                timeTicks++;
            } while (fireMillis < now);
        }
    }
}
