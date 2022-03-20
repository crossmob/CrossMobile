/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.wrapper;

import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.corelocation.CLLocationCoordinate2D;
import crossmobile.ios.mapkit.*;
import crossmobile.ios.uikit.UIEdgeInsets;
import crossmobile.ios.uikit.UIView;
import org.crossmobile.bind.graphics.GraphicsContext;

import java.util.List;
import java.util.Set;

public abstract class MapViewWrapper<NWIDG extends NativeWrapper<GCX>, GCX extends GraphicsContext<?>> extends WidgetWrapper<MKMapView, NWIDG, GCX> {

    public MapViewWrapper(MKMapView widg) {
        super(widg);
    }

    public abstract void setMapType(int MKMapType);

    public abstract boolean isScrollEnabled();

    public abstract void setScrollEnabled(boolean scrollEnabled);

    public abstract void setZoomEnabled(boolean zoomEnabled);

    public abstract MKCoordinateRegion region();

    public abstract void setRegion(MKCoordinateRegion region, boolean animated);

    public abstract CLLocationCoordinate2D centerCoordinate();

    public abstract void setCenterCoordinate(CLLocationCoordinate2D centerCoordinate, boolean animated);

    public abstract CGPoint convertCoordinateToPointToView(CLLocationCoordinate2D coordinate, UIView view);

    public abstract CLLocationCoordinate2D convertPointToCoordinateFromView(CGPoint point, UIView view);

    public abstract CGRect convertRegionToRectToView(MKCoordinateRegion region, UIView view);

    public abstract MKCoordinateRegion convertRectToRegionFromView(CGRect rect, UIView view);

    public abstract MKCoordinateRegion regionThatFits(MKCoordinateRegion region);

    public abstract MKMapRect mapRectThatFits(MKMapRect mapRect);

    public abstract MKMapRect mapRectThatFits(MKMapRect mapRect, UIEdgeInsets insets);

    public abstract List<MKAnnotation> annotations();

    public abstract void addAnnotation(MKAnnotation annotation);

    public abstract void removeAnnotation(MKAnnotation annotation);

    public abstract MKAnnotationView viewForAnnotation(MKAnnotation annotation);

    public abstract Set<MKAnnotation> annotationsInMapRect(MKMapRect rect);

    public abstract CGRect annotationVisibleRect();

    public abstract MKAnnotationView dequeueReusableAnnotationViewWithIdentifier(String id);

    public abstract List<MKAnnotation> selectedAnnotations();

    public abstract void setSelectedAnnotations(List<? extends MKAnnotation> selectedAnnotations);

    public abstract void selectAnnotation(MKAnnotation annotation, boolean animated);

    public abstract void deselectAnnotation(MKAnnotation annotation, boolean animated);

    public abstract List<MKOverlay> overlays();

    public abstract void addOverlay(MKOverlay overlay);

    public abstract void addOverlays(List<MKOverlay> overlays);

    public abstract void removeOverlay(MKOverlay overlay);

    public abstract void removeOverlays(List<MKOverlay> overlays);

    public abstract void insertOverlay(MKOverlay overlay, int index);

    public abstract void exchangeOverlayAtIndex(int index1, int index2);

    public abstract void insertOverlayAboveOverlay(MKOverlay overlay, MKOverlay sibling);

    public abstract void insertOverlayBelowOverlay(MKOverlay overlay, MKOverlay sibling);

    public abstract void setShowsUserLocation(boolean showsUserLocation);

    public abstract boolean isShowsUserLocation();

    public abstract boolean isUserLocationVisible();

    @Override
    public abstract NWIDG newNativeWidget();
}
