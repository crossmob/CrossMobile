/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.coregraphics;

import crossmobile.ios.uikit.UIImage;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bind.graphics.NativeBitmap;
import org.crossmobile.bind.graphics.NativeFont;
import org.crossmobile.bind.graphics.NativePath;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

@CMLib(target = CMLibTarget.RUNTIME)
public class GraphicsDrill {

    public static int color(CGColor c) {
        return c.color;
    }

    public static GraphicsContext<?> context(CGContext c) {
        return c.context;
    }

    public static CGImage cgimage(String filename, NativeBitmap bitmap) {
        return new CGImage(filename, bitmap);
    }

    public static String filename(CGImage i) {
        return i.getFilename();
    }

    public static UIImage image(CGBitmapContext b) {
        return b.image();
    }

    public static CGColor cgcolor(int color) {
        return new CGColor(color);
    }

    public static CGFont cgfont(NativeFont font) {
        return new CGFont(font);
    }

    public static NativeFont font(CGFont f) {
        return f.nativeFont;
    }

    public static NativeBitmap bitmap(CGImage i) {
        return i.bitmap();
    }

    public static NativePath path(CGPath p) {
        return p.path;
    }

    public static CGAffineTransform selfRotateScaleTranslate(CGAffineTransform self, double alpha, double sx, double sy, double dx, double dy) {
        return self.identitySelf().
                rotateSelf(alpha).
                scaleSelf(sx, sy).
                translateSelf(dx, dy);
    }

    public static CGAffineTransform translateConcatTranslate(CGAffineTransform self, double dx1, double dy1, CGAffineTransform concat, double dx2, double dy2) {
        return self.translateSelf(dx1, dy1).concatSelf(concat).translateSelf(dx2, dy2);
    }

    public static void destroy(CGContext ctx) {
        if (ctx instanceof CGBitmapContext)
            ((CGBitmapContext) ctx).destroy();
    }

    public static CGContext convertBaseContextToCGContext(GraphicsContext<?> context) {
        context.setAntialias(true);
        return new CGContext(context);
    }

    public static void trashCGImageMemory(CGImage img) {
        img.trash();
    }
}
