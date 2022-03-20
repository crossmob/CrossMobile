/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIViewAnimationOptions class defines different animation options for views.
 */
@CMEnum
public final class UIViewAnimationOptions {

    /**
     * The subviews are animated along with their parent view.
     */
    public static final int LayoutSubviews = 1 << 0;

    /**
     * The user interacts with the view during the animation.
     */
    public static final int AllowUserInteraction = 1 << 1;

    /**
     * The animation of the view starts for the current view state.
     */
    public static final int BeginFromCurrentState = 1 << 2;

    /**
     * The animation of the view is being repeated.
     */
    public static final int Repeat = 1 << 3;

    /**
     * The animation of the view automatically reverses once it completes.
     */
    public static final int Autoreverse = 1 << 4;

    /**
     * The view uses the original duration value instead of the remaining
     * duration of the in-flight animation.
     */
    public static final int OverrideInheritedDuration = 1 << 5;

    /**
     * The view uses the original curve value for the animation.
     */
    public static final int OverrideInheritedCurve = 1 << 6;

    /**
     * The views are being animated by changing their properties dynamically.
     */
    public static final int AllowAnimatedContent = 1 << 7;

    /**
     * The views are shown or hidden instead of added or removed.
     */
    public static final int ShowHideTransitionViews = 1 << 8;

    /**
     * The view does not inherit animation options.
     */
    public static final int OverrideInheritedOptions = 1 << 9;

    /**
     * The animation of the view speeds up at the beginning and then slows down.
     */
    public static final int CurveEaseInOut = 0 << 16;

    /**
     * The animation of the view speeds up.
     */
    public static final int CurveEaseIn = 1 << 16;

    /**
     * The animation of the view slows down.
     */
    public static final int CurveEaseOut = 2 << 16;

    /**
     * A linear animation is used for the view.
     */
    public static final int CurveLinear = 3 << 16;

    /**
     * There is no transition specified for the view.
     */
    public static final int TransitionNone = 0 << 20;

    /**
     * The view flips around the vertical axis from left to right. In particular
     * the left side is moving forward and the right side is moving backward.
     */
    public static final int TransitionFlipFromLeft = 1 << 20;

    /**
     * The view flips around the vertical axis from right to left. In particular
     * the right side is moving forward and the left side is moving backward.
     */
    public static final int TransitionFlipFromRight = 2 << 20;

    /**
     * The view curls up from the bottom.
     */
    public static final int TransitionCurlUp = 3 << 20;

    /**
     * The view curls down from the top.
     */
    public static final int TransitionCurlDown = 4 << 20;

    /**
     * The current view dissolves and next one appears.
     */
    public static final int TransitionCrossDissolve = 5 << 20;

    /**
     * The view flips around the horizontal axis from top to bottom. In
     * particular the top is moving forward and the bottom is moving backward.
     */
    public static final int TransitionFlipFromTop = 6 << 20;

    /**
     * The view flips around the horizontal axis from bottom to top. In
     * particular bottom is moving forward and the top moving backward.
     */
    public static final int TransitionFlipFromBottom = 7 << 20;

    /**
     * Animation with default frames per second
     */
    public static final int PreferredFramesPerSecondDefault = 0 << 24;

    /**
     * Animation with 30 frames per second
     */
    public static final int PreferredFramesPerSecond30 = 7 << 24;

    /**
     * Animation with 60 frames per second
     */
    public static final int PreferredFramesPerSecond60 = 3 << 24;


    private UIViewAnimationOptions() {
    }

}
