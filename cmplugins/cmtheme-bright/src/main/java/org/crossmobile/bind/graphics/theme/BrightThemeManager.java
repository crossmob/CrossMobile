/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.uikit.*;

public class BrightThemeManager implements ThemeManager {
    private BrightActivityIndicatorPainter activityIndicatorPainter;
    private BrightButtonPainter buttonPainter;
    private BrightPageControlPainter pageControlPainter;
    private BrightProgressPainter progressPainter;
    private BrightScrollPainter scrollPainter;
    private BrightSegmentedPainter segmentedPainter;
    private BrightSliderPainter sliderPainter;
    private BrightSwitchPainter switchPainter;
    private final ThemeFont themeFont = new BrightThemeFont();

    @Override
    public ThemePainter<?> getPainter(UIView view) {
        Class<? extends UIView> cls = view.getClass();
        ThemePainter<?> painter;

        // This huge if/else is slightly faster than a Map<Class<?>,ThemePainter>
        if (UISwitch.class.isAssignableFrom(cls)) {
            if (switchPainter == null)
                switchPainter = new BrightSwitchPainter();
            painter = switchPainter;
        } else if (UIButton.class.isAssignableFrom(cls)) {
            if (buttonPainter == null)
                buttonPainter = new BrightButtonPainter();
            painter = buttonPainter;
        } else if (UISlider.class.isAssignableFrom(cls)) {
            if (sliderPainter == null)
                sliderPainter = new BrightSliderPainter();
            painter = sliderPainter;
        } else if (UIProgressView.class.isAssignableFrom(cls)) {
            if (progressPainter == null)
                progressPainter = new BrightProgressPainter();
            painter = progressPainter;
        } else if (UIPageControl.class.isAssignableFrom(cls)) {
            if (pageControlPainter == null)
                pageControlPainter = new BrightPageControlPainter();
            painter = pageControlPainter;
        } else if (UIActivityIndicatorView.class.isAssignableFrom(cls)) {
            if (activityIndicatorPainter == null)
                activityIndicatorPainter = new BrightActivityIndicatorPainter();
            painter = activityIndicatorPainter;
        } else if (UIScrollView.class.isAssignableFrom(cls)) {
            if (scrollPainter == null)
                scrollPainter = new BrightScrollPainter();
            painter = scrollPainter;
        } else if (UISegmentedControl.class.isAssignableFrom(cls)) {
            if (segmentedPainter == null)
                segmentedPainter = new BrightSegmentedPainter();
            painter = segmentedPainter;
        } else
            painter = null;
        return painter;
    }

    @Override
    public ThemeFont fonts() {
        return themeFont;
    }
}
