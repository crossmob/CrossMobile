package org.crossmobile.bind.graphics.theme;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.uikit.UIButton;
import org.crossmobile.bind.graphics.GraphicsContext;

public class BrightButtonPainter implements ButtonPainter {
    @Override
    public void draw(UIButton entity, CGRect rect, GraphicsContext<?> gcx, Object metaData) {
    }

    @Override
    public int getFixedWidth() {
        return -1;
    }

    @Override
    public int getFixedHeight() {
        return -1;
    }
}
