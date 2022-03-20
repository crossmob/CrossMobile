/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGBitmapContext;
import crossmobile.ios.coregraphics.CGContext;
import crossmobile.ios.coregraphics.CGSize;
import org.crossmobile.bridge.ann.CMBundle;
import org.crossmobile.bridge.ann.CMFunction;

import java.util.Stack;

import static crossmobile.ios.coregraphics.GraphicsDrill.destroy;
import static crossmobile.ios.coregraphics.GraphicsDrill.image;

/**
 * UIGraphics class defines methods for creating and displaying images to custom
 * views using bitmap image context stored in a stack.
 */
@CMBundle
public final class UIGraphics {

    private static final Stack<CGContext> contextStack = new Stack<>();

    private UIGraphics() {
    }

    /**
     * Returns the current graphics context.
     *
     * @return The current graphics context.
     */
    @CMFunction(" CGContextRef UIGraphicsGetCurrentContext ( void ); ")
    public static CGContext getCurrentContext() {
        synchronized (contextStack) {
            return contextStack.peek();
        }
    }

    /**
     * Pushes the specified context to the stack and makes it current graphics
     * context.
     *
     * @param context The new current context.
     */
    @CMFunction(" void UIGraphicsPushContext ( CGContextRef context ); ")
    public static void pushContext(CGContext context) {
        synchronized (contextStack) {
            contextStack.push(context);
        }
    }

    /**
     * Pops the top context from the stack and restores the previous as current
     * graphics context.
     */
    @CMFunction(" void UIGraphicsPopContext ( void ); ")
    public static void popContext() {
        synchronized (contextStack) {
            destroy(contextStack.pop());
            if (contextStack.isEmpty())
                throw new RuntimeException("Internal error: Context stack is empty");
        }
    }

    /**
     * Creates an bitmap-based image context of the specified option.
     *
     * @param size The size of the bitmap-based image.
     */
    @CMFunction(" void UIGraphicsBeginImageContext ( CGSize size ); ")
    public static void beginImageContext(CGSize size) {
        beginImageContextWithOptions(size, true, 1);
    }

    /**
     * Creates an bitmap-based image context using the specified parameters.
     *
     * @param size   The size of the image.
     * @param opaque TRUE the image is opaque.
     * @param scale  The scale of the image.
     */
    @CMFunction(" void UIGraphicsBeginImageContextWithOptions ( CGSize size, BOOL opaque, CGFloat scale ); ")
    public static void beginImageContextWithOptions(CGSize size, boolean opaque, double scale) {
        contextStack.push(CGBitmapContext.create(null, (int) (size.getWidth() + 0.5), (int) (size.getHeight() + 0.5), 0, 0, null, 0));
    }

    /**
     * Returns the content of the current context as an image.
     *
     * @return The content of the current context as an image.
     */
    @CMFunction(" UIImage * UIGraphicsGetImageFromCurrentImageContext ( void ); ")
    public static UIImage getImageFromCurrentImageContext() {
        CGContext current = getCurrentContext();
        return (current instanceof CGBitmapContext) ? image((CGBitmapContext) current) : null;
    }

    /**
     * Pops the current bitmap-based image context from the top of the stack.
     */
    @CMFunction(" void UIGraphicsEndImageContext ( void ); ")
    public static void endImageContext() {
        popContext();
    }
}
