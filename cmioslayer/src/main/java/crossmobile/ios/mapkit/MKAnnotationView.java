/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.mapkit;

import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.uikit.*;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

/**
 * MKAnnotationView class defines an object that represents the corresponding
 * view of an annotation object displayed on a map.
 */
@CMClass
public class MKAnnotationView extends UIView {

    private boolean enabled;
    private UIImage image;
    private boolean highlighted;
    private CGPoint centerOffset;
    private CGPoint calloutOffset;
    private final String reuseIdentifier;
    private boolean selected;
    private boolean canShowCallout;
    private UIView leftCalloutAccessoryView;
    private UIView rightCalloutAccessoryView;
    private boolean draggable;
    private int dragState;
    //
//       private cmEventDispatcher dispatcher = new cmEventDispatcher(this);
    private final UILabel title;
    private final UILabel subtitle;
    private final UIButton close;
    //
    // TODO :    private WeakReference<Dialog> dialogref;
    //
    MKAnnotation annotation;

    /**
     * Constructs a MKAnnotationView with the specified parameters.
     *
     * @param annotation      The MKAnnotation object of the view.
     * @param reuseIdentifier An id of this view in order to reuse it in the
     *                        future.
     */
    @CMConstructor("- (instancetype)initWithAnnotation:(id<MKAnnotation>)annotation \n"
            + "                   reuseIdentifier:(NSString *)reuseIdentifier;")
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public MKAnnotationView(MKAnnotation annotation, String reuseIdentifier) {
        super(new CGRect(60, 60, 200, 70));
        this.annotation = annotation;
        this.reuseIdentifier = reuseIdentifier;

        title = new UILabel(new CGRect(0, 0, 200, 26));
        title.setFont(UIFont.boldSystemFontOfSize(18));
        title.setTextColor(UIColor.whiteColor());
        addSubview(title);

        subtitle = new UILabel(new CGRect(0, 30, 200, 20));
        subtitle.setTextColor(UIColor.whiteColor());
        addSubview(subtitle);

        close = UIButton.buttonWithType(UIButtonType.Custom);
        close.setFrame(new CGRect(184, 0, 24, 24));
        close.setImage(UIImage.imageWithContentsOfFile(Native.file().getSystemPrefix() + "close"), UIControlState.Normal);
        close.addTarget((UIControl sender, UIEvent event) -> {
            // TODO : implement
//                if (dialogref == null)
//                    return;
//                Dialog dialog = dialogref.get();
//                if (dialog == null)
//                    dialogref = null;
//                else
//                    dialog.dismiss();
        }, UIControlEvents.TouchUpInside);
        addSubview(close);

        centerOffset = new CGPoint(0, 0);
    }

    /**
     * Called when the view is about to be used again.
     */
    @CMSelector("- (void)prepareForReuse;\n"
            + "")
    public void prepareForReuse() {
    }

    /**
     * Returns a Boolean that shows whether the annotation is enabled.
     *
     * @return A Boolean that shows whether the annotation is enabled.
     */
    @CMGetter("@property(nonatomic, getter=isEnabled) BOOL enabled;")
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Returns a Boolean that defines whether the annotation is enabled.
     *
     * @param enabled A Boolean that defines whether the annotation is enabled.
     */
    @CMSetter("@property(nonatomic, getter=isEnabled) BOOL enabled;")
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Returns the annotation object of this view.
     *
     * @return The annotation object of this view.
     */
    @CMGetter("@property(nonatomic, strong) id<MKAnnotation> annotation;")
    public MKAnnotation annotation() {
        return annotation;
    }

    /**
     * Sets annotation object of this view.
     *
     * @param annotation The annotation object of this view
     */
    @CMSetter("@property(nonatomic, strong) id<MKAnnotation> annotation;")
    public void setAnnotation(MKAnnotation annotation) {
        this.annotation = annotation;
    }

    /**
     * Returns the offset of the default map accessory view expressed in points.
     *
     * @return The offset of the default map accessory view expressed in points
     */
    @CMGetter("@property(nonatomic) CGPoint calloutOffset;")
    public CGPoint calloutOffset() {
        return calloutOffset;
    }

    /**
     * Sets the offset of the default map accessory view expressed in points.
     *
     * @param calloutOffset The offset of the default map accessory view
     *                      expressed in points.
     */
    @CMSetter("@property(nonatomic) CGPoint calloutOffset;")
    public void setCalloutOffset(CGPoint calloutOffset) {
        this.calloutOffset = calloutOffset;
    }

    /**
     * Returns the offset of the annotation view expressed in points.
     *
     * @return The offset of the annotation view expressed in points.
     */
    @CMGetter("@property(nonatomic) CGPoint centerOffset;")
    public CGPoint centerOffset() {
        return centerOffset;
    }

    /**
     * Sets the offset of the annotation view expressed in points.
     *
     * @param centerOffset The offset of the annotation view expressed in
     *                     points.
     */
    @CMSetter("@property(nonatomic) CGPoint centerOffset;")
    public void setCenterOffset(CGPoint centerOffset) {
        this.centerOffset = centerOffset;
    }

    /**
     * Returns a Boolean that defines whether the annotation view is
     * highlighted.
     *
     * @return A Boolean that defines whether the annotation view is
     * highlighted.
     */
    @CMGetter("@property(nonatomic, getter=isHighlighted) BOOL highlighted;\n"
            + "")
    public boolean isHighlighted() {
        return highlighted;
    }

    /**
     * Sets a Boolean that defines whether the annotation view is highlighted.
     *
     * @param highlighted A Boolean that defines whether the annotation view is
     *                    highlighted.
     */
    @CMSetter("@property(nonatomic, getter=isHighlighted) BOOL highlighted;\n"
            + "")
    public void setHighlighted(boolean highlighted) {
        this.highlighted = highlighted;
    }

    /**
     * Returns the image of the annotation view.
     *
     * @return The image of the annotation view.
     */
    @CMGetter("@property(nonatomic, strong) UIImage *image;")
    public UIImage image() {
        return image;
    }

    /**
     * Sets the image of the annotation view.
     *
     * @param image The image of the annotation view.
     */
    @CMSetter("@property(nonatomic, strong) UIImage *image;")
    public void setImage(UIImage image) {
        this.image = image;
    }

    /**
     * Returns a String that defines whether the visibility of this annotation.
     *
     * @return A String that defines whether the visibility of this annotation.
     */
    @CMGetter("@property(nonatomic, readonly) NSString *reuseIdentifier;")
    public String reuseIdentifier() {
        return reuseIdentifier;
    }

    /**
     * Returns the selection state of the annotation view.
     *
     * @return The selection state of the annotation view.
     */
    @CMGetter("@property(nonatomic, getter=isSelected) BOOL selected;")
    public boolean isSelected() {
        return selected;
    }

    /**
     * Sets the selection state of the annotation view.
     *
     * @param selected The selection state of the annotation view.
     */
    @CMSetter("@property(nonatomic, getter=isSelected) BOOL selected;")
    public void setSelected(boolean selected) {
        setSelected(selected, false);
    }

    /**
     * Sets the selection state of the annotation view using animation or not.
     *
     * @param selected The selection state of the annotation view.
     * @param animated TRUE the change is done using animation.
     */
    @CMSelector("- (void)setSelected:(BOOL)selected \n"
            + "           animated:(BOOL)animated;")
    public void setSelected(boolean selected, boolean animated) {
        this.selected = selected;
    }

    /**
     * Returns a Boolean that defines whether the annotation view can display
     * additional information on the default map accessory view.
     *
     * @return TRUE then the default map accessory view can display additional
     * information on the default accessory view.
     */
    @CMGetter("@property(nonatomic) BOOL canShowCallout;")
    public boolean canShowCallout() {
        return canShowCallout;
    }

    /**
     * Returns a Boolean that defines whether the annotation view can display
     * additional information on the default map accessory view.
     *
     * @param canShowCallout TRUE then the default map accessory view can
     *                       display additional information on the default accessory view.
     */
    @CMSetter("@property(nonatomic) BOOL canShowCallout;")
    public void setCanShowCallout(boolean canShowCallout) {
        this.canShowCallout = canShowCallout;
    }

    /**
     * Returns the view that is displayed on the left side of the default map
     * accessory view.
     *
     * @return The view that is displayed on the left side of the default map
     * accessory view.
     */
    @CMGetter("@property(strong, nonatomic) UIView *leftCalloutAccessoryView;\n"
            + "")
    public UIView leftCalloutAccessoryView() {
        return leftCalloutAccessoryView;
    }

    /**
     * Sets the view to be displayed on the left side of the default map
     * accessory view.
     *
     * @param leftCalloutAccessoryView The view to be displayed on the left side
     *                                 of the default map accessory view.
     */
    @CMSetter("@property(strong, nonatomic) UIView *leftCalloutAccessoryView;\n"
            + "")
    public void setLeftCalloutAccessoryView(UIView leftCalloutAccessoryView) {
        this.leftCalloutAccessoryView = leftCalloutAccessoryView;
    }

    /**
     * Returns the view that is displayed on the right side of the default map
     * accessory view.
     *
     * @return The view that is displayed on the right side of the default map
     * accessory view.
     */
    @CMGetter("@property(strong, nonatomic) UIView *rightCalloutAccessoryView;")
    public UIView rightCalloutAccessoryView() {
        return rightCalloutAccessoryView;
    }

    /**
     * Sets the view to be displayed on the right side of the default map
     * accessory view.
     *
     * @param rightCalloutAccessoryView The view to be displayed on the right
     *                                  side of the default map accessory view.
     */
    @CMSetter("@property(strong, nonatomic) UIView *rightCalloutAccessoryView;")
    public void setRightCalloutAccessoryView(UIView rightCalloutAccessoryView) {
        this.rightCalloutAccessoryView = rightCalloutAccessoryView;
        CGRect frame = frame();
        rightCalloutAccessoryView.setFrame(new CGRect(180, 30, frame.getSize().getWidth(), frame.getSize().getHeight()));
        addSubview(rightCalloutAccessoryView);
    }

    /**
     * Returns the current drag state of the annotation.
     *
     * @return The current drag state of the annotation.
     * @see crossmobile.ios.mapkit.MKAnnotationViewDragState
     */
    @CMGetter("@property(nonatomic) MKAnnotationViewDragState dragState;")
    public int dragState() {
        return dragState;
    }

    /**
     * Sets the current drag state of the annotation.
     *
     * @param MKAnnotationViewDragState The current drag state of the
     *                                  annotation.
     */
    @CMSetter("@property(nonatomic) MKAnnotationViewDragState dragState;")
    public void setDragState(int MKAnnotationViewDragState) {
        setDragState(dragState, false);
    }

    /**
     * Sets the current drag state of the annotation using animation or not.
     *
     * @param MKAnnotationViewDragState The new current drag state of the
     *                                  annotation.
     * @param animated                  TRUE the change is animated.
     * @see crossmobile.ios.mapkit.MKAnnotationViewDragState
     */
    @CMSelector("- (void)setDragState:(MKAnnotationViewDragState)newDragState \n"
            + "            animated:(BOOL)animated;")
    public void setDragState(int MKAnnotationViewDragState, boolean animated) {
        this.dragState = MKAnnotationViewDragState;
    }

    /**
     * Returns a Boolean that shows whether the annotation is draggable.
     *
     * @return TRUE the annotation is draggable.
     */
    @CMGetter("@property(nonatomic, getter=isDraggable) BOOL draggable;")
    public boolean isDraggable() {
        return draggable;
    }

    /**
     * Sets a Boolean that defines whether the annotation is draggable.
     *
     * @param draggable TRUE the annotation is draggable.
     */
    @CMSetter("@property(nonatomic, getter=isDraggable) BOOL draggable;")
    public void setDraggable(boolean draggable) {
        this.draggable = draggable;
    }

    // TODO : implement
//    final OverlayItem createOverlayItem(MKMapView.AnnotationsOverlay aover) {
//        OverlayItem overlay = annotation == null
//                ? new OverlayItem(new GeoPoint(0, 0), "", "")
//                :null; // TODO      : new OverlayItem(annotation.coordinate().geoPoint(), annotation.title(), annotation.subtitle());
//        if (image != null) {
//            Drawable icon = null; // TODO: new BitmapDrawable(image.cm_model());
//            int width = icon.intrinsicWidth();
//            int height = icon.intrinsicHeight();
//            int deltax = (int) (width / 2f + centerOffset.x + 0.5);
//            int deltay = (int) (height / 2f + centerOffset.y + 0.5);
//            icon.setBounds(-deltax, -deltay, width - deltax, height - deltay);
//            overlay.setMarker(icon);
//        }
//        return overlay;
//    }
    // TODO  a mess
//    final boolean onTap() {
//        if (!canShowCallout())
//            return false;
//        Dialog dialog = null;// TODO new Dialog(AndroidGraphicsBridge.context);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//        title.setText(annotation.title());
//        subtitle.setText(annotation.subtitle());
//
//        if (cm_base().parent() != null)
//            ((ViewGroup) cm_base().parent()).removeView(cm_base());
//        dialog.setContentView(cm_base());
//        dialogref = new WeakReference<Dialog>(dialog);
//        dialog.show();
//
//        return true;
//    }
// TODO: a mess again
//    @Override
//    cmView createBaseObject(Context cx) {
//        return new cmView(cx) {
//
//            @Override
//            public boolean dispatchTouchEvent(MotionEvent ev) {
//                dispatcher.sendEvent(dispatcher.createEvent(ev, true));
//                return super.dispatchTouchEvent(ev);   // For other native widgets to work
//            }
//        };
//    }
}
