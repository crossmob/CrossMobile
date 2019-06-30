/*
 * (c) 2019 by Panayotis Katsaloulis
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
package org.crossmobile.backend.swing;

import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.corelocation.CLLocationCoordinate2D;
import crossmobile.ios.mapkit.*;
import crossmobile.ios.uikit.UIEdgeInsets;
import crossmobile.ios.uikit.UIView;
import org.crossmobile.bind.wrapper.MapViewWrapper;
import org.crossmobile.bind.wrapper.WidgetWrapper;
import org.crossmobile.bridge.ann.CMLib;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Set;

import static org.crossmobile.bridge.ann.CMLibTarget.DESKTOP;

@CMLib(target = DESKTOP, name = "cmlocation")
public class SwingMapViewWrapper extends MapViewWrapper<SwingMapViewWrapper.NativeW, SwingGraphicsContext> {

    public SwingMapViewWrapper(MKMapView widg) {
        super(widg);
    }

    @Override
    public void setMapType(int MKMapType) {

    }

    @Override
    public boolean isScrollEnabled() {
        return false;
    }

    @Override
    public void setScrollEnabled(boolean scrollEnabled) {

    }

    @Override
    public void setZoomEnabled(boolean zoomEnabled) {

    }

    @Override
    public MKCoordinateRegion region() {
        return null;
    }

    @Override
    public void setRegion(MKCoordinateRegion region, boolean animated) {

    }

    @Override
    public CLLocationCoordinate2D centerCoordinate() {
        return null;
    }

    @Override
    public void setCenterCoordinate(CLLocationCoordinate2D centerCoordinate, boolean animated) {

    }

    @Override
    public void setShowsUserLocation(boolean showsUserLocation) {

    }

    @Override
    public CGPoint convertCoordinateToPointToView(CLLocationCoordinate2D coordinate, UIView view) {
        return null;
    }

    @Override
    public CLLocationCoordinate2D convertPointToCoordinateFromView(CGPoint point, UIView view) {
        return null;
    }

    @Override
    public CGRect convertRegionToRectToView(MKCoordinateRegion region, UIView view) {
        return null;
    }

    @Override
    public MKCoordinateRegion convertRectToRegionFromView(CGRect rect, UIView view) {
        return null;
    }

    @Override
    public MKCoordinateRegion regionThatFits(MKCoordinateRegion region) {
        return null;
    }

    @Override
    public MKMapRect mapRectThatFits(MKMapRect mapRect) {
        return null;
    }

    @Override
    public MKMapRect mapRectThatFits(MKMapRect mapRect, UIEdgeInsets insets) {
        return null;
    }

    @Override
    public List<MKAnnotation> annotations() {
        return null;
    }

    @Override
    public void addAnnotation(MKAnnotation annotation) {

    }

    @Override
    public void removeAnnotation(MKAnnotation annotation) {

    }

    @Override
    public MKAnnotationView viewForAnnotation(MKAnnotation annotation) {
        return null;
    }

    @Override
    public Set<MKAnnotation> annotationsInMapRect(MKMapRect rect) {
        return null;
    }

    @Override
    public CGRect annotationVisibleRect() {
        return null;
    }

    @Override
    public MKAnnotationView dequeueReusableAnnotationViewWithIdentifier(String id) {
        return null;
    }

    @Override
    public List<MKAnnotation> selectedAnnotations() {
        return null;
    }

    @Override
    public void setSelectedAnnotations(List<? extends MKAnnotation> selectedAnnotations) {

    }

    @Override
    public void selectAnnotation(MKAnnotation annotation, boolean animated) {

    }

    @Override
    public void deselectAnnotation(MKAnnotation annotation, boolean animated) {

    }

    @Override
    public List<MKOverlay> overlays() {
        return null;
    }

    @Override
    public void addOverlay(MKOverlay overlay) {

    }

    @Override
    public void addOverlays(List<MKOverlay> overlays) {

    }

    @Override
    public void removeOverlay(MKOverlay overlay) {

    }

    @Override
    public void removeOverlays(List<MKOverlay> overlays) {

    }

    @Override
    public void insertOverlay(MKOverlay overlay, int index) {

    }

    @Override
    public void exchangeOverlayAtIndex(int index1, int index2) {

    }

    @Override
    public void insertOverlayAboveOverlay(MKOverlay overlay, MKOverlay sibling) {

    }

    @Override
    public void insertOverlayBelowOverlay(MKOverlay overlay, MKOverlay sibling) {

    }

    @Override
    public boolean isShowsUserLocation() {
        return false;
    }

    @Override
    public boolean isUserLocationVisible() {
        return false;
    }

    @Override
    public NativeW newNativeWidget() {
        return new NativeW();
    }

    public class NativeW extends JComponent implements SwingNativeDispatcher.DesktopNativeWidget {
        {
            setBackground(Color.gray);
        }

        @Override
        public WidgetWrapper getWrapper() {
            return SwingMapViewWrapper.this;
        }

        @Override
        public void superDraw(SwingGraphicsContext cxt) {
            super.paint(cxt.g2);
        }

        @Override
        public void setUserInteraction(boolean status) {
        }
    }
}
