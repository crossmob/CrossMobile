/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.quartzcore;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

/**
 * CAMediaTiming interface consists a protocol that incorporates timing
 * properties related to CAAnimation objects like duration, beginTime and
 * repeatCount .
 */
@CMClass
public interface CAMediaTiming {

    /**
     * Returns a Boolean value that determines whether the animation will play
     * in reverse after completion.
     *
     * @return TRUE then the animation will play in reverse after completion.
     */
    @CMGetter("@property BOOL autoreverses;")
    public boolean autoreverses();

    /**
     * Sets a Boolean value that determines whether the animation will play in
     * reverse after completion.
     *
     * @param autoreverses TRUE then the animation will play in reverse after
     *                     completion.
     */
    @CMSetter("@property BOOL autoreverses;")
    public void setAutoreverses(boolean autoreverses);

    /**
     * Returns the beginning time of the animation.
     *
     * @return The beginning time of the animation.
     */
    @CMGetter("@property CFTimeInterval beginTime;")
    public double beginTime();

    /**
     * Sets the beginning time of the animation.
     *
     * @param beginTime The beginning time of the animation.
     */
    @CMSetter("@property CFTimeInterval beginTime;")
    public void setBeginTime(double beginTime);

    /**
     * Returns the animation duration in seconds.
     *
     * @return The animation duration in seconds.
     */
    @CMGetter("@property CFTimeInterval duration;")
    public double duration();

    /**
     * Sets the animation duration in seconds.
     *
     * @param duration The animation duration in seconds.
     */
    @CMSetter("@property CFTimeInterval duration;")
    public void setDuration(double duration);

    /**
     * Returns a String that represents the state of the animation after its
     * completion.
     *
     * @return The state of the animation after its completion.
     */
    @CMGetter("@property(copy) NSString *fillMode;")
    public String fillMode();

    /**
     * Sets the state of the animation after its completion.
     *
     * @param fillMode The state of the animation after its completion.
     */
    @CMSetter("@property(copy) NSString *fillMode;")
    public void setFillMode(String fillMode);

    /**
     * Returns the number of repeats of the animation.
     *
     * @return The number of repeats of the animation.
     */
    @CMGetter("@property float repeatCount;")
    public float repeatCount();

    /**
     * Sets the number of repeats of the animation.
     *
     * @param repeatCount The number of repeats of the animation.
     */
    @CMSetter("@property float repeatCount;")
    public void setRepeatCount(float repeatCount);

    /**
     * Returns the duration of the animation repeat.
     *
     * @return The duration of the animation repeat.
     */
    @CMGetter("@property CFTimeInterval repeatDuration;")
    public double repeatDuration();

    /**
     * Sets the duration of the animation repeat.
     *
     * @param repeatDuration The duration of the animation repeat.
     */
    @CMSetter("@property CFTimeInterval repeatDuration;")
    public void setRepeatDuration(double repeatDuration);

    /**
     * Returns the number that represents how time is mapped to the current time space from the parent time space.
     *
     * @return A number that represents how time is mapped to the current time space from the parent time space.
     */
    @CMGetter("@property float speed;")
    public float speed();

    /**
     * Sets a number that represents how time is mapped to the current time space from the parent time space.
     *
     * @param speed A number that represents how time is mapped to the current time space from the parent time space.
     */
    @CMSetter("@property float speed;")
    public void setSpeed(float speed);

    /**
     * Returns the time offset of the local time.
     *
     * @return The time offset of the local time.
     */
    @CMGetter("@property CFTimeInterval timeOffset;")
    public double timeOffset();

    /**
     * Sets the time offset of the local time.
     *
     * @param timeOffset The time offset of the local time.
     */
    @CMSetter("@property CFTimeInterval timeOffset;")
    public void setTimeOffset(double timeOffset);
}
