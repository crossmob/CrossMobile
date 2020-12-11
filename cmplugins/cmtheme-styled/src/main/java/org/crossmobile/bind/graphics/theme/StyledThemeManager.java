package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.uikit.UISwitch;
import crossmobile.ios.uikit.UIView;

public class StyledThemeManager implements ThemeManager {
    private StyledSwitchPainter switchPainter;

    @Override
    public ThemePainter<?, ?> getPainter(UIView view) {
        Class<? extends UIView> cls = view.getClass();
        if (UISwitch.class.isAssignableFrom(cls)) {
            if (switchPainter == null)
                switchPainter = new StyledSwitchPainter();
            return switchPainter;
        } else if (UISwitch.class.isAssignableFrom(cls)) {
            if (switchPainter == null)
                switchPainter = new StyledSwitchPainter();
            return switchPainter;
        }
        return null;
    }
}
