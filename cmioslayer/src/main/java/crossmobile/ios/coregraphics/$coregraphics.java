/*
 * (c) 2020 by Panayotis Katsaloulis
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
package crossmobile.ios.coregraphics;

import crossmobile.ios.uikit.UIImage;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bind.graphics.NativeBitmap;
import org.crossmobile.bind.graphics.NativeFont;

public class $coregraphics {

    public static int color(CGColor c) {
        return c.color;
    }

    public static GraphicsContext context(CGContext c) {
        return c.context;
    }

    public static NativeFont font(CGFont f) {
        return f.nfont;
    }

    public static NativeBitmap bitmap(CGImage i) {
        return i.bitmap();
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

    public static CGContext convertBaseContextToCGContext(GraphicsContext context) {
        context.setAntialias(true);
        return new CGContext(context);
    }

    public static void trashCGImageMemory(CGImage img) {
        img.trash();
    }

}
