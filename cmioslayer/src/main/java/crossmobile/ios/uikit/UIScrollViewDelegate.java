/*
 * (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * UIScrollViewDelegate interface is the delegate that handles scroll view
 * events.
 */
@CMClass
public interface UIScrollViewDelegate {

    /**
     * It is used when the user scrolls the content view.
     *
     * @param scrollView The scroll view that corresponds to this delegate.
     */
    @CMSelector("- (void)scrollViewDidScroll:(UIScrollView *)scrollView;")
    default void didScroll(UIScrollView scrollView) {
    }

    /**
     * It is used when the content of the view is about to begin scrolling.
     *
     * @param scrollView The scroll view that corresponds to this delegate.
     */
    @CMSelector("- (void)scrollViewWillBeginDragging:(UIScrollView *)scrollView;")
    default void willBeginDragging(UIScrollView scrollView) {
    }

    /**
     * It is used when the user stopped scrolling and lifted the finger.
     *
     * @param scrollView     The scroll view that corresponds to this delegate.
     * @param willDecelerate TRUE the scrolling continues after lifting finger.
     */
    @CMSelector("- (void)scrollViewDidEndDragging:(UIScrollView *)scrollView \n"
            + "                  willDecelerate:(BOOL)decelerate;")
    default void didEndDragging(UIScrollView scrollView, boolean willDecelerate) {
    }

    /**
     * It is used in order to control whether the scrolling should lasts till
     * the top of the content is reached.
     *
     * @param scrollView The scroll view that corresponds to this delegate.
     * @return TRUE it scrolls to the top.
     */
    @CMSelector("- (BOOL)scrollViewShouldScrollToTop:(UIScrollView *)scrollView;")
    default boolean shouldScrollToTop(UIScrollView scrollView) {
        return true;
    }

    /**
     * It is used when the scrolling reached the top of the content.
     *
     * @param scrollView The scroll view that corresponds to this delegate.
     */
    @CMSelector("- (void)scrollViewDidScrollToTop:(UIScrollView *)scrollView;")
    default void didScrollToTop(UIScrollView scrollView) {
    }

    /**
     * It is used when the scrolling starts to decelerate.
     *
     * @param scrollView The scroll view that corresponds to this delegate.
     */
    @CMSelector("- (void)scrollViewWillBeginDecelerating:(UIScrollView *)scrollView;")
    default void willBeginDecelerating(UIScrollView scrollView) {
    }

    /**
     * It is used when the scrolling stopped decelerating.
     *
     * @param scrollView The scroll view that corresponds to this delegate.
     */
    @CMSelector("- (void)scrollViewDidEndDecelerating:(UIScrollView *)scrollView;")
    default void didEndDecelerating(UIScrollView scrollView) {
    }

    /**
     * It is used when zooming gesture begins.
     *
     * @param scrollView The scroll view that corresponds to this delegate.
     * @return The part of the content to be zoomed.
     */
    @CMSelector("- (UIView *)viewForZoomingInScrollView:(UIScrollView *)scrollView;")
    default UIView viewForZoomingInScrollView(UIScrollView scrollView) {
        return null;
    }

    /**
     * It is used after the zooming gesture ends.
     *
     * @param scrollView The scroll view that corresponds to this delegate.
     * @param withView   The part of the content to be scaled.
     * @param atScale    The scale factor of the zooming.
     */
    @CMSelector("- (void)scrollViewDidEndZooming:(UIScrollView *)scrollView \n"
            + "                       withView:(UIView *)view \n"
            + "                        atScale:(CGFloat)scale;")
    default void didEndZooming(UIScrollView scrollView, UIView withView, double atScale) {
    }

    /**
     * It is used after the zooming of the scroll view ended.
     *
     * @param scrollView The scroll view that corresponds to this delegate.
     */
    @CMSelector("- (void)scrollViewDidEndScrollingAnimation:(UIScrollView *)scrollView;")
    default void didEndScrollingAnimation(UIScrollView scrollView) {
    }
}
