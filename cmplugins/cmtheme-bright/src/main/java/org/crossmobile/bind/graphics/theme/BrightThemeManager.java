package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.uikit.UIButton;
import crossmobile.ios.uikit.UISlider;
import crossmobile.ios.uikit.UISwitch;
import crossmobile.ios.uikit.UIView;

public class BrightThemeManager implements ThemeManager {
    private SwitchPainter switchPainter;
    private SliderPainter sliderPainter;
    private ButtonPainter buttonPainter;

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
        } else
            painter = null;
        return painter;
    }
}
