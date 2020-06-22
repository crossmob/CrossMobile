package crossmobile.ios.coregraphics;

import org.crossmobile.bind.graphics.NativeBitmap;
import org.crossmobile.bind.graphics.NativeFont;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

@CMLib(target = CMLibTarget.RUNTIME_PLUGIN)
public class CoreGraphicsDrill {

    public static NativeFont font(CGFont f) {
        return f.nfont;
    }

    public static NativeBitmap bitmap(CGImage i) {
        return i.bitmap();
    }
}
