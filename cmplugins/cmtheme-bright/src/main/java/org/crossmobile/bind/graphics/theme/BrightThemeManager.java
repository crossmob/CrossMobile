package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.uikit.UIButton;
import crossmobile.ios.uikit.UISwitch;
import crossmobile.ios.uikit.UIView;

public class BrightThemeManager implements ThemeManager {
    private SwitchPainter switchPainter;
    private ButtonPainter buttonPainter;

    @Override
    public ThemePainter<?, ?> getPainter(UIView view) {
        Class<? extends UIView> cls = view.getClass();
        if (UISwitch.class.isAssignableFrom(cls)) {
            if (switchPainter == null)
                switchPainter = new BrightSwitchPainter();
            return switchPainter;
        } else if (UIButton.class.isAssignableFrom(cls)) {
            if (buttonPainter == null)
                buttonPainter = new BrightButtonPainter();
            return buttonPainter;
        }
        return null;
    }
}
