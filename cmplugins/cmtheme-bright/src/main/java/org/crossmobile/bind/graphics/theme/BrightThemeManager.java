/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.uikit.*;

public class BrightThemeManager implements ThemeManager {
    private BrightButtonPainter buttonPainter;
    private BrightProgressPainter progressPainter;
    private BrightSliderPainter sliderPainter;
    private BrightSwitchPainter switchPainter;
    private final ThemeFont themeFont = new BrightThemeFont();

    @Override
    public ThemePainter<?, ?> getPainter(UIView view) {
        Class<? extends UIView> cls = view.getClass();
        ThemePainter<?, ?> painter;
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
        } else
            painter = null;
        return painter;
    }

    @Override
    public ThemeFont fonts() {
        return themeFont;
    }
}
