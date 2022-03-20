/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.mapkit;

import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.corelocation.CLLocation;
import crossmobile.ios.corelocation.CLLocationCoordinate2D;
import crossmobile.ios.uikit.UIEdgeInsets;
import crossmobile.ios.uikit.UIView;
import org.crossmobile.bind.wrapper.MapViewWrapper;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * MKMapView class defines a particular type of view that represents an
 * embeddable and interactive map for the application.
 */
@CMClass
public class MKMapView extends UIView {

    private static final String MAP_ACTIVITY = "";// TODO  AndroidGraphicsBridge.context.getClass().package().name() + ".XMMAP";
    private static int last_id = 0;
    private static final Object population_lock = new Object();
    //
    private String currentID;
    private int mapType = 0;
    private boolean zoomEnabled;
    private MKMapViewDelegate delegate;
    //
    private MKCoordinateRegion region;
    private CLLocationCoordinate2D centerCoordinate;
    private MKMapRect visibleMapRect;
    //
    private boolean showsUserLocation;
    private boolean userLocationVisible;
    private MKUserLocation userLocation;
    //
    // TODO private AnnotationsOverlay annotations;
    private boolean isPopulated = false;
    private List<MKAnnotation> selectedAnnotations = new ArrayList<>();
    private final List<MKOverlay> overlays = new ArrayList<>();

    /**
     * Constructs a default MKMapView object located at (0,0) with 0 weight and
     * 0 height.
     */
    public MKMapView() {
        this(CGRect.zero());
    }

    /**
     * Constructs a MKMapView object initialized with the dimensions and
     * position specified in the frame parameter.
     *
     * @param frame CGRect that defines dimension and position of the MKMapView.
     */
    @SuppressWarnings({"OverridableMethodCallInConstructor", "LeakingThisInConstructor", "unchecked"})
    public MKMapView(CGRect frame) {
        super(frame);
        registerWidget(Native.mapWidget().mapView(this));
        setScrollEnabled(true);
        setZoomEnabled(true);
    }

    @SuppressWarnings("rawtypes")
    private MapViewWrapper widget() {
        return (MapViewWrapper) getWidget();
    }

    /**
     * Returns the type of the map.
     *
     * @return The type of the map.
     * @see crossmobile.ios.mapkit.MKMapType
     */
    @CMGetter("@property(nonatomic) MKMapType mapType;")
    public int mapType() {
        return mapType;
    }

    /**
     * Sets the type of the map.
     *
     * @param MKMapType The type of the map.
     * @see crossmobile.ios.mapkit.MKMapType
     */
    @CMSetter("@property(nonatomic) MKMapType mapType;")
    public void setMapType(int MKMapType) {
        mapType = MKMapType;
        widget().setMapType(MKMapType);
    }

    /**
     * Returns a Boolean that shows whether scrolling of the map is enabled.
     *
     * @return A Boolean that shows whether scrolling of the map is enabled.
     */
    @CMGetter("@property(nonatomic, getter=isScrollEnabled) BOOL scrollEnabled;\n"
            + "")
    public boolean isScrollEnabled() {
        return widget().isScrollEnabled();
    }

    /**
     * Sets a Boolean that defines whether scrolling of the map is enabled.
     *
     * @param scrollEnabled A Boolean that shows whether scrolling of the map is
     *                      enabled.
     */
    @CMSetter("@property(nonatomic, getter=isScrollEnabled) BOOL scrollEnabled;\n"
            + "")
    public void setScrollEnabled(boolean scrollEnabled) {
        widget().setScrollEnabled(scrollEnabled);
    }

    /**
     * Returns a Boolean that shows whether zooming of the map is enabled.
     *
     * @return A Boolean that shows whether zooming of the map is enabled.
     */
    @CMGetter("@property(nonatomic, getter=isZoomEnabled) BOOL zoomEnabled;")
    public boolean isZoomEnabled() {
        return widget().isScrollEnabled();
    }

    /**
     * Sets a Boolean that defines whether zooming of the map is enabled.
     *
     * @param zoomEnabled A Boolean that shows whether zooming of the map is
     *                    enabled.
     */
    @CMSetter("@property(nonatomic, getter=isZoomEnabled) BOOL zoomEnabled;")
    public void setZoomEnabled(boolean zoomEnabled) {
        widget().setZoomEnabled(zoomEnabled);
    }

    /**
     * Returns the corresponding delegate for the map view.
     *
     * @return The delegate of the map view.
     */
    @CMGetter("@property(nonatomic, weak) id<MKMapViewDelegate> delegate;")
    public MKMapViewDelegate delegate() {
        return delegate;
    }

    /**
     * Sets the delegate for the map view.
     *
     * @param delegate The delegate of the map view.
     */
    @CMSetter("@property(nonatomic, weak) id<MKMapViewDelegate> delegate;")
    public void setDelegate(MKMapViewDelegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Returns the area that is currently displayed by the map view.
     *
     * @return The area that is currently displayed by the map view.
     */
    @CMGetter("@property(nonatomic) MKCoordinateRegion region;")
    public MKCoordinateRegion region() {
        return widget().region();
    }

    /**
     * Set the area to be displayed by the map view.
     *
     * @param region The area displayed by the map view.
     */
    @CMSetter("@property(nonatomic) MKCoordinateRegion region;")
    public void setRegion(MKCoordinateRegion region) {
        setRegion(region, false);
    }

    /**
     * Set the area to be displayed by the map view using animation or not.
     *
     * @param region   The area displayed by the map view.
     * @param animated TRUE the display is animated.
     */
    @CMSelector("- (void)setRegion:(MKCoordinateRegion)region \n"
            + "         animated:(BOOL)animated;")
    public void setRegion(MKCoordinateRegion region, boolean animated) {
        widget().setRegion(region, animated);
    }

    /**
     * Returns the coordinates of the map's center.
     *
     * @return The coordinates of the map's center.
     */
    @CMGetter("@property(nonatomic) CLLocationCoordinate2D centerCoordinate;")
    public CLLocationCoordinate2D centerCoordinate() {
        return widget().centerCoordinate();
    }

    /**
     * Sets the coordinates of the map's center.
     *
     * @param centerCoordinate The coordinates of the map's center.
     */
    @CMSetter("@property(nonatomic) CLLocationCoordinate2D centerCoordinate;")
    public void setCenterCoordinate(CLLocationCoordinate2D centerCoordinate) {
        setCenterCoordinate(centerCoordinate, false);
    }

    /**
     * Sets the coordinates of the map's center using animation or not.
     *
     * @param centerCoordinate The coordinates of the center.
     * @param animated         TRUE the change is animated.
     */
    @CMSelector("- (void)setCenterCoordinate:(CLLocationCoordinate2D)coordinate \n"
            + "                   animated:(BOOL)animated;")
    public void setCenterCoordinate(CLLocationCoordinate2D centerCoordinate, boolean animated) {
        widget().setCenterCoordinate(centerCoordinate, animated);
    }

    /**
     * Returns the area currently displayed by the map.
     *
     * @return The area currently displayed by the map.
     */
    @CMGetter("@property(nonatomic) MKMapRect visibleMapRect;")
    public MKMapRect visibleMapRect() {
        return visibleMapRect;
    }

    /**
     * Sets the area displayed by the map view.
     *
     * @param visibleMapRect The area displayed by the map view.
     */
    @CMSetter("@property(nonatomic) MKMapRect visibleMapRect;")
    public void setVisibleMapRect(MKMapRect visibleMapRect) {
        setVisibleMapRect(visibleMapRect, false);
    }

    /**
     * Sets the area displayed by the map view using animation or not.
     *
     * @param visibleMapRect The visible are of the map.
     * @param animated       TRUE the change is animated.
     */
    @CMSelector("- (void)setVisibleMapRect:(MKMapRect)mapRect \n"
            + "                 animated:(BOOL)animate;")
    public void setVisibleMapRect(MKMapRect visibleMapRect, boolean animated) {
        setVisibleMapRect(visibleMapRect, new UIEdgeInsets(0, 0, 0, 0), animated);
    }

    /**
     * Sets the visible area of the map with the specified insets using
     * animation or not.
     *
     * @param visibleMapRect The visible area of the map.
     * @param edgePadding    The insets of the area.
     * @param animated       TRUE then the change is animated.
     */
    @CMSelector("- (void)setVisibleMapRect:(MKMapRect)mapRect \n"
            + "              edgePadding:(UIEdgeInsets)insets \n"
            + "                 animated:(BOOL)animate;")
    public void setVisibleMapRect(MKMapRect visibleMapRect, UIEdgeInsets edgePadding,
                                  boolean animated) {
        this.visibleMapRect = visibleMapRect;
    }

    /**
     * Returns a Boolean that shows whether the location of the user is visible.
     *
     * @return TRUE then user location is visible.
     */
    @CMGetter("@property(nonatomic) BOOL showsUserLocation;")
    public boolean showsUserLocation() {
        return widget().isShowsUserLocation();
    }

    /**
     * Sets a Boolean that defines whether the location of the user is visible.
     *
     * @param showsUserLocation TRUE then user location is visible.
     */
    @CMSetter("@property(nonatomic) BOOL showsUserLocation;\n"
            + "")
    public void setShowsUserLocation(boolean showsUserLocation) {
        if (showsUserLocation)
            initUserLocation();
        else userLocation = null;
        widget().setShowsUserLocation(showsUserLocation);
    }

    /**
     * Returns the user location.
     *
     * @return The user location.
     */
    @CMGetter("@property(nonatomic, readonly) MKUserLocation *userLocation;")
    public MKUserLocation userLocation() {
        initUserLocation();
        return userLocation;
    }

    /**
     * Returns a Boolean that shows whether user's location is visible on the
     * map with annotation.
     *
     * @return TRUE then user location is visible.
     */
    @CMGetter("@property(nonatomic, readonly, getter=isUserLocationVisible) BOOL userLocationVisible;")
    public boolean isUserLocationVisible() {
        return widget().isUserLocationVisible();
    }

    void initUserLocation() {
        if (userLocation == null)
            userLocation = new MKUserLocation();
    }

    /**
     * Converts the specified coordinates to a point in the specified view.
     *
     * @param coordinate The coordinates to be converted.
     * @param view       The view into which the conversion will take place.
     * @return The point that is the result of the conversion.
     */
    @CMSelector("- (CGPoint)convertCoordinate:(CLLocationCoordinate2D)coordinate \n"
            + "               toPointToView:(UIView *)view;")
    public CGPoint convertCoordinate(CLLocationCoordinate2D coordinate, UIView view) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Converts the specified point of the given view to this map's coordinates.
     *
     * @param point The point to be converted.
     * @param view  The view into which the conversion will take place.
     * @return The coordinates of the point.
     */
    @CMSelector("- (CLLocationCoordinate2D)convertPoint:(CGPoint)point \n"
            + "                  toCoordinateFromView:(UIView *)view;")
    public CLLocationCoordinate2D convertPoint(CGPoint point, UIView view) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Converts the specified region of this map to a rectangle in the specified
     * view.
     *
     * @param region The region to be converted.
     * @param view   The view into which the conversion will take place.
     * @return The final rectangle.
     */
    @CMSelector("- (CGRect)convertRegion:(MKCoordinateRegion)region \n"
            + "           toRectToView:(UIView *)view;")
    public CGRect convertRegion(MKCoordinateRegion region, UIView view) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Converts the specified rectangle of the given view to a map region.
     *
     * @param rect The rectangle to be converted.
     * @param view The view into which the conversion will take place.
     * @return The final map's region.
     */
    @CMSelector("- (MKCoordinateRegion)convertRect:(CGRect)rect \n"
            + "                 toRegionFromView:(UIView *)view;")
    public MKCoordinateRegion convertRect(CGRect rect, UIView view) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Adjust the given region so that it fits in the map view.
     *
     * @param region The region to be adjusted.
     * @return The final adjusted region.
     */
    @CMSelector("- (MKCoordinateRegion)regionThatFits:(MKCoordinateRegion)region;")
    public MKCoordinateRegion regionThatFits(MKCoordinateRegion region) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Adjusts the specified map rectangle so that it fits in the map view.
     *
     * @param mapRect The map rectangle to be adjusted.
     * @return The final adjusted rectangle.
     */
    @CMSelector("- (MKMapRect)mapRectThatFits:(MKMapRect)mapRect;")
    public MKMapRect mapRectThatFits(MKMapRect mapRect) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Adjusts the specified map rectangle according to the given insets values.
     *
     * @param mapRect The map rectangle to be adjusted.
     * @param insets  The insets to be incorporated to the final map rectangle.
     * @return The final adjusted rectangle.
     */
    @CMSelector("- (MKMapRect)mapRectThatFits:(MKMapRect)mapRect\n"
            + "                 edgePadding:(UIEdgeInsets)insets")
    public MKMapRect mapRectThatFits(MKMapRect mapRect, UIEdgeInsets insets) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Returns the list of annotations for this map.
     *
     * @return The list of annotations for this map.
     */
    @SuppressWarnings("unchecked")
    @CMGetter("@property(nonatomic, readonly) NSArray<id<MKAnnotation>> *annotations;\n"
            + "")
    public List<MKAnnotation> annotations() {
        return widget().annotations();
    }

    /**
     * Adds the specified annotation to the map.
     *
     * @param annotation The annotation to be added.
     */
    @CMSelector("- (void)addAnnotation:(id<MKAnnotation>)annotation;")
    public void addAnnotation(MKAnnotation annotation) {
        widget().addAnnotation(annotation);
    }

    /**
     * Adds the list of annotations to the map.
     *
     * @param annotations The list of annotations to be added to the map.
     */
    @CMSelector("- (void)addAnnotations:(NSArray<id<MKAnnotation>> *)annotations;")
    public void addAnnotations(List<? extends MKAnnotation> annotations) {
        for (MKAnnotation annotation : annotations)
            addAnnotation(annotation);
    }

    /**
     * Removes the specified annotation from the map.
     *
     * @param annotation The annotation to be removed.
     */
    @CMSelector("- (void)removeAnnotation:(id<MKAnnotation>)annotation;")
    public void removeAnnotation(MKAnnotation annotation) {
        widget().removeAnnotation(annotation);
    }

    /**
     * Removes the specified list of annotations from the map.
     *
     * @param annotations The list of annotations to be removed.
     */
    @CMSelector("- (void)removeAnnotations:(NSArray<id<MKAnnotation>> *)annotations;")
    public void removeAnnotations(List<? extends MKAnnotation> annotations) {
        for (MKAnnotation annotation : annotations)
            removeAnnotation(annotation);
    }

    /**
     * Returns the annotation view of the specified annotation object.
     *
     * @param annotation The annotation object for which the annotation view is
     *                   requested.
     * @return The annotation view of the specified annotation object, NULL if
     * there is none.
     */
    @CMSelector("- (MKAnnotationView *)viewForAnnotation:(id<MKAnnotation>)annotation;")
    public MKAnnotationView viewForAnnotation(MKAnnotation annotation) {
        return null;
    }

    /**
     * Returns the annotations that are located in the specified rectangle of
     * the map.
     *
     * @param rect The rectangle of the map for which the enclosed annotations
     *             are requested.
     * @return The annotations of the rectangle.
     */
    @CMSelector("- (NSSet<id<MKAnnotation>> *)annotationsInMapRect:(MKMapRect)mapRect;")
    public Set<MKAnnotation> annotationsInMapRect(MKMapRect rect) {
        // TODO: Java implementation
        return new HashSet<>();
    }

    /**
     * Returns the rectangle that encloses the visible annotations.
     *
     * @return The rectangle that encloses the visible annotations.
     */
    @CMGetter("@property(nonatomic, readonly) CGRect annotationVisibleRect;")
    public CGRect annotationVisibleRect() {
        // TODO: Java implementation
        return null;
    }

    /**
     * Returns the reusable annotation that corresponds to the specified id.
     *
     * @param id The id of the requested annotation.
     * @return The annotation of the specified id.
     */
    @CMSelector("- (MKAnnotationView *)dequeueReusableAnnotationViewWithIdentifier:(NSString *)identifier;")
    public MKAnnotationView dequeueReusableAnnotationViewWithIdentifier(String id) {
        // No reusable pin-points supported for Android.
        // No support for this functionality in the API.
        // Lazy initialization is used instead (which should not be enough).
        return null;
    }

    /**
     * Returns a list with all the selected annotations.
     *
     * @return A list with all the selected annotations.
     */
    @CMGetter("@property(nonatomic, copy) NSArray<id<MKAnnotation>> *selectedAnnotations;")
    public List<MKAnnotation> selectedAnnotations() {
        return selectedAnnotations;
    }

    /**
     * Sets a list with the currently selected annotations.
     *
     * @param selectedAnnotations A list with the currently selected
     *                            annotations.
     */
    @CMSetter("@property(nonatomic, copy) NSArray<id<MKAnnotation>> *selectedAnnotations;")
    public void setSelectedAnnotations(List<? extends MKAnnotation> selectedAnnotations) {
        this.selectedAnnotations = new ArrayList<>();
        if (selectedAnnotations != null && selectedAnnotations.size() > 0)
            this.selectedAnnotations.add(selectedAnnotations.get(0));
    }

    /**
     * Selects the specified annotation using animation or not.
     *
     * @param annotation The annotation to be selected.
     * @param animated   TRUE then the selection is animated.
     */
    @CMSelector("- (void)selectAnnotation:(id<MKAnnotation>)annotation \n"
            + "                animated:(BOOL)animated;")
    public void selectAnnotation(MKAnnotation annotation, boolean animated) {
//        if (annotations.contains(annotation))
        selectedAnnotations.add(annotation); // TODO : update visuals
    }

    /**
     * Deselects the specified annotation using animation or not.
     *
     * @param annotation The annotation to be deselected.
     * @param animated   TRUE then the deselection is animated.
     */
    @CMSelector("- (void)deselectAnnotation:(id<MKAnnotation>)annotation \n"
            + "                  animated:(BOOL)animated;")
    public void deselectAnnotation(MKAnnotation annotation, boolean animated) {
        selectedAnnotations.remove(annotation);
        // TODO : update visuals
    }

    /**
     * Return a list of overlays.
     *
     * @return A list of overlays.
     */
    @CMGetter("@property(nonatomic, readonly) NSArray<id<MKOverlay>> *overlays;\n"
            + "")
    public List<MKOverlay> overlays() {
        return overlays;
    }

    /**
     * Adds the specified overlay to the map.
     *
     * @param overlay The overlay to be added to the map.
     */
    @CMSelector("- (void)addOverlay:(id<MKOverlay>)overlay;")
    public void addOverlay(MKOverlay overlay) {
        overlays.add(overlay);
    }

    /**
     * Adds the list of overlays to the map.
     *
     * @param overlays The list of overlays to be added.
     */
    @CMSelector("- (void)addOverlays:(NSArray<id<MKOverlay>> *)overlays;")
    public void addOverlays(List<MKOverlay> overlays) {
        this.overlays.addAll(overlays);
    }

    /**
     * Removes the specified overlay from the map.
     *
     * @param overlay The overlay to be removed.
     */
    @CMSelector("- (void)removeOverlay:(id<MKOverlay>)overlay;")
    public void removeOverlay(MKOverlay overlay) {
        overlays.remove(overlay);
    }

    /**
     * Removes the list of overlays from the map.
     *
     * @param overlays The list of overlays to be removed.
     */
    @CMSelector("- (void)removeOverlays:(NSArray<id<MKOverlay>> *)overlays;\n"
            + "")
    public void removeOverlays(List<MKOverlay> overlays) {
        this.overlays.removeAll(overlays);
    }

    /**
     * Relocates the specified overlay to the given index position.
     *
     * @param overlay The overlay that is relocated.
     * @param index   The new index of the overlay.
     */
    @CMSelector("- (void)insertOverlay:(id<MKOverlay>)overlay \n"
            + "              atIndex:(NSUInteger)index;")
    public void insertOverlay(MKOverlay overlay, int index) {
        overlays.add(index, overlay);
    }

    /**
     * Exchanges the two overlays specified by their indices.
     *
     * @param index1 The index of the first overlay.
     * @param index2 The index of the second overlay.
     */
    @CMSelector("- (void)exchangeOverlayAtIndex:(NSUInteger)index1 \n"
            + "            withOverlayAtIndex:(NSUInteger)index2;")
    public void exchangeOverlayAtIndex(int index1, int index2) {
        MKOverlay ol1 = overlays.get(index1);
        MKOverlay ol2 = overlays.get(index2);
        overlays.set(index2, ol1);
        overlays.set(index1, ol2);
    }

    /**
     * Inserts first overlay above the second overlay.
     *
     * @param overlay The overlay to be inserted.
     * @param sibling The overlay above which the new is inserted.
     */
    @CMSelector("- (void)insertOverlay:(id<MKOverlay>)overlay \n"
            + "         aboveOverlay:(id<MKOverlay>)sibling;")
    public void insertOverlayAboveOverlay(MKOverlay overlay, MKOverlay sibling) {
        int pos = overlays.indexOf(overlay);
        insertOverlay(sibling, pos + 1);
    }

    /**
     * Inserts first overlay below the second overlay.
     *
     * @param overlay The overlay to be inserted.
     * @param sibling The overlay below which the new is inserted.
     */
    @CMSelector("- (void)insertOverlay:(id<MKOverlay>)overlay \n"
            + "         belowOverlay:(id<MKOverlay>)sibling;")
    public void insertOverlayBelowOverlay(MKOverlay overlay, MKOverlay sibling) {
        int pos = overlays.indexOf(overlay);
        insertOverlay(sibling, pos);
    }

    /**
     * Returns the view associated with the specified overlay.
     *
     * @param overlay The overlay whose view is requested.
     * @return The view of the specified overlay.
     */
    @Deprecated
    @CMSelector("- (MKOverlayView *)viewForOverlay:(id<MKOverlay>)overlay;")
    public MKOverlayView viewForOverlay(MKOverlay overlay) {
        // TODO : Java implementation
        return null;
    }

    // TODO: implement
//    @Override
//    View createModelObject(Context cx) {
//        currentID = "map" + (last_id++);
//
//        /// This should be initialized guarandeed before the annotations object
//        if (userLocation == null)
//            userLocation = new MKUserLocation();
//        // Create the annotations overlay
//        // TODO:     annotations = new AnnotationsOverlay(FileBridge.drawable("empty"));
//
//        /* TODO: We need to create a new MapActivity for every MapView.
//         * There should be a way to properly destroy this view, when the MapView is not required any more
//         * We can't simply relay on the GC mechanism, since we currently use ActivityGroup, which
//         * keeps track of all activities.
//         * The only thing is done right now, is to kill all map activities, when the core activity gets killed
//         * It is strange though, although a new activity is launched for every map object, all
//         * map objects have sunchronized views
//         */
//        LocalActivityManager mng = ((ActivityGroup) cx).localActivityManager();
//        mng.startActivity(currentID, new Intent(MAP_ACTIVITY));
//        Activity cma = mng.activity(currentID);
//        //TODO:     AndroidLifecycle.register(cma);
//        MapView mv = new MapView(cma, System.getProperty("cm.map.apikey"));
//        mv.overlays().add(annotations);
//        return mv;
//    }
    @Override
    public void willMoveToSuperview(UIView newSuperview) {
        if (newSuperview != null && !isPopulated)
            isPopulated = true; // TODO : implement
        //       annotations.doPopulate();
    }

    void updateUserLocation(CLLocation newLocation) {
        // TODO : implement
        userLocation.setLocation(newLocation);
//        annotations.userview.setImage(UIImage.imageWithContentsOfFile(Native.file().getSystemPrefix() + "bluedot"));
//        annotations.doPopulate();
    }
    // TODO : implement
//    class AnnotationsOverlay extends ItemizedOverlay {
//
//        private List<MKAnnotation> annotations = new ArrayList<MKAnnotation>();
//        private List<MKAnnotationView> views = new ArrayList<MKAnnotationView>();
//        private MKUserLocationView userview = new MKUserLocationView(userLocation, null);
//
//        public AnnotationsOverlay(Drawable drawable) {
//            super(boundCenterBottom(drawable));
//        }
//
//        @Override
//        protected OverlayItem createItem(int i) {
//            // ID 0 reserved for self location
//            if (i == 0)
//                return userview.overlayItem(this, showsUserLocation);
//
//            i--;
//            MKAnnotationView view = views.get(i);
//            if (view == null) {
//                MKAnnotation an = annotations.get(i);
//                if (delegate != null)
//                    view = delegate.viewForAnnotation(MKMapView.this, an);
//                if (view == null)
//                    view = viewForAnnotation(an);
//                if (view == null)
//                    view = new MKPinAnnotationView(an, null);
//                views.set(i, view);
//            }
//            return view.createOverlayItem(this);
//        }
//
//        @Override
//        public int size() {
//            return annotations.size() + 1;
//        }
//
//        public List<MKAnnotation> annotations() {
//            return annotations;
//        }
//
//        public void add(MKAnnotation annotation) {
//            annotations.add(annotation);
//            views.add(null);    // Lazy initialization, to give time for the delegate to be defined
//            doPopulate();
//        }
//
//        public void addAll(List<MKAnnotation> annotations) {
//            this.annotations.addAll(annotations);
//            for (int i = 0; i < annotations.size(); i++)
//                views.add(null);    // Lazy initialization, to give time for the delegate to be defined
//            doPopulate();
//        }
//
//        public void remove(MKAnnotation annotation) {
//            int which = annotations.indexOf(annotation);
//            if (which >= 0) {
//                annotations.remove(which);
//                views.remove(which);
//            }
//            doPopulate();
//        }
//
//        public void removeAll(List<MKAnnotation> annotations) {
//            int which;
//            for (MKAnnotation an : annotations) {
//                which = this.annotations.indexOf(an);
//                if (which >= 0) {
//                    this.annotations.remove(which);
//                    views.remove(which);
//                }
//            }
//            doPopulate();
//        }
//
//        @Override
//        /* Remove shadow on all items */
//        public void draw(Canvas c, MapView m, boolean shadow) {
//            if (shadow)
//                return;
//            super.draw(c, m, false);
//        }
//
//        @Override
//        protected boolean onTap(int index) {
//            // ID 0 reserved for self location
//            if (index == 0)
//                return userview.onTap();
//            index--;
//            return views.get(index).onTap();
//        }
//
//        void doPopulate() {
//            if (isPopulated)
//                synchronized (population_lock) {
//                    populate();
//                }
//        }
//    }
}
