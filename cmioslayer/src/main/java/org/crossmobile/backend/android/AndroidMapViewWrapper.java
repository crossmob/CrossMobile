/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.corelocation.CLLocationCoordinate2D;
import crossmobile.ios.mapkit.*;
import crossmobile.ios.uikit.UIEdgeInsets;
import crossmobile.ios.uikit.UIView;
import org.crossmobile.backend.android.AndroidNativeDispatcher.AndroidNativeWidget;
import org.crossmobile.bind.graphics.Geometry;
import org.crossmobile.bind.wrapper.MapViewWrapper;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibDepends;

import java.util.*;

import static org.crossmobile.bridge.ann.CMLibTarget.ANDROID;

@CMLib(target = ANDROID, name = "cmlocation",
        depends = @CMLibDepends(groupId = "com.google.android.gms", pluginName = "play-services-maps", version = "17.0.0"))
public class AndroidMapViewWrapper extends MapViewWrapper<AndroidMapViewWrapper.NativeW, AndroidGraphicsContext> {

    private Map<MKAnnotation, Marker> markers = new HashMap<>();
    private GoogleMap currentmap;
    private Queue<Runnable> deferAction = new ArrayDeque<>();
    private final Object lock = new Object[0];
    private boolean firstTime = true;

    public AndroidMapViewWrapper(MKMapView widg) {
        super(widg);
    }

    private void defer(Runnable action) {
        synchronized (lock) {
            if (isReadyToAcceptChanges()) {
                Native.lifecycle().runOnEventThread(() -> {
                    action.run();
                    NativeW nativeWidget = getNativeWidget();
                    if (nativeWidget != null && firstTime) {
                        firstTime = false;
                        nativeWidget.getLifecycleListener().onResume();
                    }
                });
            } else
                deferAction.add(action);
        }
    }

    @Override
    public void setMapType(final int MKMapType) {
        defer(() -> {
            switch (MKMapType) {
                case 0:
                    getNativeMap().setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    break;
                case 1:
                    getNativeMap().setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                    break;
                case 2:
                    getNativeMap().setMapType(GoogleMap.MAP_TYPE_HYBRID);
                    break;
            }
        });

    }

    @Override
    public boolean isScrollEnabled() {
        return getNativeMap().getUiSettings().isScrollGesturesEnabled();
    }

    @Override
    public void setScrollEnabled(final boolean scrollEnabled) {
        defer(() -> getNativeMap().getUiSettings().setScrollGesturesEnabled(scrollEnabled));
    }

    @Override
    public void setZoomEnabled(final boolean zoomEnabled) {
        defer(() -> getNativeMap().getUiSettings().setZoomGesturesEnabled(zoomEnabled));
    }

    @Override
    public MKCoordinateRegion region() {
        CameraPosition cameraPosition = getNativeMap().getCameraPosition();
        LatLngBounds bounds = getNativeMap().getProjection().getVisibleRegion().latLngBounds;
        MKCoordinateSpan span = new MKCoordinateSpan(2 * (cameraPosition.target.latitude - bounds.southwest.latitude), 2 * (cameraPosition.target.longitude - bounds.southwest.longitude));
        return new MKCoordinateRegion(new CLLocationCoordinate2D(cameraPosition.target.latitude, cameraPosition.target.longitude), span);
    }

    @Override
    public void setRegion(MKCoordinateRegion region, final boolean animated) {
        double centerLat = region.getCenter().getLatitude();
        double centerLong = region.getCenter().getLongitude();
        double latitudeDelta = region.getSpan().getLatitudeDelta();
        double longitudeDelta = region.getSpan().getLongitudeDelta();
        LatLng SW = new LatLng(centerLat - latitudeDelta / 2, centerLong - longitudeDelta / 2);
        LatLng NE = new LatLng(centerLat + latitudeDelta / 2, centerLong + longitudeDelta / 2);
        CameraUpdate camera = CameraUpdateFactory.newLatLngBounds(new LatLngBounds(SW, NE), 0);
        defer(() -> {
            if (animated)
                getNativeMap().animateCamera(camera);
            else
                getNativeMap().moveCamera(camera);
        });
    }

    @Override
    public CLLocationCoordinate2D centerCoordinate() {
        double latitude = getNativeMap().getCameraPosition().target.latitude;
        double longitude = getNativeMap().getCameraPosition().target.longitude;
        return new CLLocationCoordinate2D(latitude, longitude);
    }

    @Override
    public void setCenterCoordinate(CLLocationCoordinate2D centerCoordinate, final boolean animated) {
        LatLng latlng = new LatLng(centerCoordinate.getLatitude(), centerCoordinate.getLongitude());
        final CameraUpdate camera = CameraUpdateFactory.newLatLng(latlng);
        defer(() -> {
            if (animated)
                getNativeMap().animateCamera(camera);
            else
                getNativeMap().moveCamera(camera);
        });

    }

    @Override
    public boolean isShowsUserLocation() {
        return getNativeMap().isMyLocationEnabled();
    }

    @Override
    public void setShowsUserLocation(final boolean showsUserLocation) {
        AndroidPermissions.current().requestPermissions(notGranted -> {
            if (notGranted.size() < 2) // at least one
                defer(() -> getNativeMap().setMyLocationEnabled(showsUserLocation));
        }, AndroidPermission.ACCESS_COARSE_LOCATION, AndroidPermission.ACCESS_FINE_LOCATION);
    }

    @Override
    public CGPoint convertCoordinateToPointToView(final CLLocationCoordinate2D coordinate, UIView view) {
        CGPoint point;
        android.graphics.Point ap = getNativeMap().getProjection().toScreenLocation(new LatLng(coordinate.getLatitude(), coordinate.getLongitude()));
        point = Native.graphics().metrics().getHardwareToVirtual(ap.x, ap.y);
        return view.convertPointToView(point, view);
    }

    @Override
    public CLLocationCoordinate2D convertPointToCoordinateFromView(CGPoint point, UIView view) {
        CGPoint p;
        p = view.convertPointFromView(point, view);
        p = Native.graphics().metrics().getVirtualToHardware(p.getX(), p.getY());
        android.graphics.Point ap = new android.graphics.Point((int) (p.getX() + 0.5), (int) (p.getY() + 0.5));
        if (getNativeMap() == null)
            return new CLLocationCoordinate2D(0, 0);
        LatLng ll = getNativeMap().getProjection().fromScreenLocation(ap);
        return new CLLocationCoordinate2D(ll.latitude, ll.longitude);
    }

    @Override
    public CGRect convertRegionToRectToView(MKCoordinateRegion region, UIView view) {
        Native.system().notImplemented();
        return null;
    }

    @Override
    public MKCoordinateRegion convertRectToRegionFromView(CGRect rect, UIView view) {
        Native.system().notImplemented();
        return null;
    }

    @Override
    public MKCoordinateRegion regionThatFits(MKCoordinateRegion region) {
        Native.system().notImplemented();
        return null;
    }

    @Override
    public MKMapRect mapRectThatFits(MKMapRect mapRect) {
        Native.system().notImplemented();
        return null;
    }

    @Override
    public MKMapRect mapRectThatFits(MKMapRect mapRect, UIEdgeInsets insets) {
        Native.system().notImplemented();
        return null;
    }

    @Override
    public List<MKAnnotation> annotations() {
        return new ArrayList<>(markers.keySet());
    }

    @Override
    public void addAnnotation(final MKAnnotation annotation) {
        defer(() -> markers.put(annotation, getNativeMap().addMarker(new MarkerOptions().title(annotation.title()).position(new LatLng(annotation.coordinate().getLatitude(), annotation.coordinate().getLongitude())))));
    }

    @Override
    public void removeAnnotation(MKAnnotation annotation) {
        Marker tobeRemoved;
        if ((tobeRemoved = markers.remove(annotation)) != null)
            tobeRemoved.remove();
    }

    @Override
    public MKAnnotationView viewForAnnotation(MKAnnotation annotation) {
        Native.system().notImplemented();
        return null;
    }

    @Override
    public Set<MKAnnotation> annotationsInMapRect(MKMapRect rect) {
        Native.system().notImplemented();
        return null;
    }

    @Override
    public CGRect annotationVisibleRect() {
        Native.system().notImplemented();
        return null;
    }

    @Override
    public MKAnnotationView dequeueReusableAnnotationViewWithIdentifier(String id) {
        Native.system().notImplemented();
        return null;
    }

    @Override
    public List<MKAnnotation> selectedAnnotations() {
        Native.system().notImplemented();
        return null;
    }

    @Override
    public void setSelectedAnnotations(List<? extends MKAnnotation> selectedAnnotations) {
        Native.system().notImplemented();
    }

    @Override
    public void selectAnnotation(MKAnnotation annotation, boolean animated) {
        Native.system().notImplemented();
    }

    @Override
    public void deselectAnnotation(MKAnnotation annotation, boolean animated) {
        Native.system().notImplemented();
    }

    @Override
    public List<MKOverlay> overlays() {
        Native.system().notImplemented();
        return null;
    }

    @Override
    public void addOverlay(MKOverlay overlay) {
        Native.system().notImplemented();
    }

    @Override
    public void addOverlays(List<MKOverlay> overlays) {
        Native.system().notImplemented();
    }

    @Override
    public void removeOverlay(MKOverlay overlay) {
        Native.system().notImplemented();
    }

    @Override
    public void removeOverlays(List<MKOverlay> overlays) {
        Native.system().notImplemented();
    }

    @Override
    public void insertOverlay(MKOverlay overlay, int index) {
        Native.system().notImplemented();
    }

    @Override
    public void exchangeOverlayAtIndex(int index1, int index2) {
        Native.system().notImplemented();
    }

    @Override
    public void insertOverlayAboveOverlay(MKOverlay overlay, MKOverlay sibling) {
        Native.system().notImplemented();
    }

    @Override
    public void insertOverlayBelowOverlay(MKOverlay overlay, MKOverlay sibling) {
        Native.system().notImplemented();
    }

    @Override
    public NativeW newNativeWidget() {
        return new NativeW();
    }

    @Override
    public boolean isUserLocationVisible() {
        if (getNativeMap() != null)
            return getNativeMap().isMyLocationEnabled();
        return false;
    }


    private GoogleMap getNativeMap() {
        return currentmap;
    }

    @Override
    public void setFrame(double x, double y, double width, double height) {
        super.setFrame(x, y, width, height);
        synchronized (lock) {
            if (isReadyToAcceptChanges()) {
                Native.lifecycle().runOnEventThread(() -> {
                    for (Runnable r : deferAction)
                        r.run();
                    deferAction.clear();
                });
            }
        }
    }

    private boolean isReadyToAcceptChanges() {
        return currentmap != null && !Geometry.isZero(getIOSWidget().frame().getSize());
    }

    @CMLib(target = ANDROID, name = "cmlocation")
    public class NativeW extends MapView implements AndroidNativeWidget {

        private final ActivityLifecycleListener lifecycle = new ActivityLifecycleListener() {
            @Override
            public void onPause() {
                NativeW.this.onPause();
            }

            @Override
            public void onResume() {
                NativeW.this.onResume();
            }

            @Override
            public void onDestroy() {
                NativeW.this.onDestroy();
            }

            @Override
            public void onLowMemory() {
                NativeW.this.onLowMemory();
            }

            @Override
            public void onCreate(Bundle savedInstanceState) {
                NativeW.this.onCreate(savedInstanceState);
            }

            @Override
            public void onSaveInstanceState(Bundle outState) {
                NativeW.this.onSaveInstanceState(outState);
            }
        };

        public NativeW() {
            super(MainActivity.current);
            MapsInitializer.initialize(MainActivity.current);
            getMapAsync(map -> {
                currentmap = map;
                synchronized (lock) {
                    if (!Geometry.isZero(getIOSWidget().frame().getSize())) {
                        for (Runnable r : deferAction)
                            r.run();
                        deferAction.clear();
                    }
                }
            });
        }

        @Override
        public ActivityLifecycleListener getLifecycleListener() {
            return lifecycle;
        }

        @Override
        public void invalidate() {
            AndroidMapViewWrapper.NativeW.super.invalidate();
            getIOSWidget().setNeedsDisplay();
        }

        @SuppressWarnings("deprecation")
        @Override
        public void invalidate(Rect dirty) {
            super.invalidate(dirty);
            getIOSWidget().setNeedsDisplay();
        }

        @SuppressWarnings("deprecation")
        @Override
        public void invalidate(final int l, final int t, final int r, final int b) {
            super.invalidate(l, t, r, b);
            getIOSWidget().setNeedsDisplay();
        }

        @Override
        public void invalidateDrawable(Drawable drawable) {
            super.invalidateDrawable(drawable);
            getIOSWidget().setNeedsDisplay();
        }

        @Override
        public void superDraw(AndroidGraphicsContext cxt) {
            if (!useNativeDrawPipeline)
                try {
                    super.draw(cxt.cv);
                } catch (Throwable th) {
                    Native.system().error("Unable to paint TextField component", th);
                }
        }

        @Override
        public void setUserInteraction(boolean status) {
            Native.system().notImplemented();
        }

    }

}
