/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.mapkit;

import crossmobile.ios.coregraphics.CGContext;
import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.uikit.UIView;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * MKOverlayView class defines an object that represents customized visual
 * representation of MKOverlay objects.
 */
@CMClass
public class MKOverlayView extends UIView {

    private final MKOverlay overlay;

    /**
     * Constructs a MKOverlayView for the specified overlay.
     *
     * @param overlay The overlay of the view.
     */
    @Deprecated
    @CMConstructor("- (instancetype)initWithOverlay:(id<MKOverlay>)overlay;")
    public MKOverlayView(MKOverlay overlay) {
        this.overlay = overlay;
    }

    /**
     * Returns MKOverlay that corresponds to this MKOveralyView.
     *
     * @return The MKOverlay that corresponds to this MKOveralyView.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, readonly) id<MKOverlay> overlay;")
    public MKOverlay overlay() {
        return overlay;
    }

    /**
     * Returns the point in the overlay view for the specified map point.
     *
     * @param mapPoint The point of the map for which the corresponding point of
     *                 the overlay is requested.
     * @return The point of the overlay view for this map point.
     */
    @Deprecated
    @CMSelector("- (CGPoint)pointForMapPoint:(MKMapPoint)mapPoint;")
    public CGPoint pointForMapPoint(MKMapPoint mapPoint) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Returns the map point for the specified overlay point.
     *
     * @param point The overlay point for which the corresponding map point is
     *              requested.
     * @return The map point for the overlay point.
     */
    @Deprecated
    @CMSelector("- (MKMapPoint)mapPointForPoint:(CGPoint)point;")
    public MKMapPoint mapPointForPoint(CGPoint point) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Returns the rectangle of the overlay for the specified rectangle of the
     * map.
     *
     * @param mapRect The rectangle of the map of which the corresponding
     *                rectangle of the overlay is requested.
     * @return The rectangle of the overlay for this map rectangle.
     */
    @Deprecated
    @CMSelector("- (CGRect)rectForMapRect:(MKMapRect)mapRect;\n"
            + "")
    public CGRect rectForMapRect(MKMapRect mapRect) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Returns the map rectangle for this overlay rectangle .
     *
     * @param rect The rectangle of the overlay for which the corresponding
     *             rectangle of the overlay is requested.
     * @return The rectangle of the map for this overlay rectangle.
     */
    @Deprecated
    @CMSelector("- (MKMapRect)mapRectForRect:(CGRect)rect;")
    public MKMapRect mapRectForRect(CGRect rect) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Returns a Boolean that shows whether the overlay view of the specified
     * map rectangle is ready to draw its content.
     *
     * @param mapRect   The rectangle of the map.
     * @param zoomScale The zoom scale of the map.
     * @return TRUE then the overlay is ready to be drawn.
     */
    @Deprecated
    @CMSelector("- (BOOL)canDrawMapRect:(MKMapRect)mapRect zoomScale:(MKZoomScale)zoomScale;")
    public boolean canDrawMapRect(MKMapRect mapRect, double zoomScale) {
        Native.system().notImplemented();
        return false;
    }

    /**
     * Draws the overlay view for the specified mapRect, zoom and context
     * values.
     *
     * @param mapRect   The map rectangle of the overlay.
     * @param zoomScale The zoom scale of the overlay.
     * @param context   The context of the overlay.
     */
    @Deprecated
    @CMSelector("- (void)drawMapRect:(MKMapRect)mapRect zoomScale:(MKZoomScale)zoomScale inContext:(CGContextRef)context;")
    public void drawMapRect(MKMapRect mapRect, double zoomScale, CGContext context) {
        Native.system().notImplemented();
    }

    /**
     * Invalidates for the specified map view all zoom scales.
     *
     * @param mapRect The map view for which the zoom scales are invalidated.
     */
    @CMSelector("- (void)setNeedsDisplayInMapRect:(MKMapRect)mapRect;")
    public void setNeedsDisplayInMapRect(MKMapRect mapRect) {
        Native.system().notImplemented();
    }

    /**
     * Invalidates the zoom scale for the specified map view.
     *
     * @param mapRect   The map view for which the zoom scale is invalidated.
     * @param zoomScale The zoom scale to invalidate.
     */
    @CMSelector("- (void)setNeedsDisplayInMapRect:(MKMapRect)mapRect zoomScale:(MKZoomScale)zoomScale;")
    public void setNeedsDisplayInMapRect(MKMapRect mapRect, double zoomScale) {
        Native.system().notImplemented();
    }
}
