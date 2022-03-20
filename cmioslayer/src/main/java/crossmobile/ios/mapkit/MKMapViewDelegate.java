/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.mapkit;

import crossmobile.ios.foundation.NSError;
import crossmobile.ios.uikit.UIControl;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

import java.util.List;

/**
 * MKMapViewDelegate interface is the delegate that is responsible for handling
 * operations related to mapviews.
 */
@CMClass
public interface MKMapViewDelegate {

    /**
     * It is used right before a change of the displayed map's region occurs
     * with animation or not.
     *
     * @param mapView  The mapview that corresponds to this delegate.
     * @param animated TRUE then the change will be animated.
     */
    @CMSelector("- (void)mapView:(MKMapView *)mapView \n"
            + "regionWillChangeAnimated:(BOOL)animated;")
    default void regionWillChangeAnimated(MKMapView mapView, boolean animated) {
    }

    /**
     * It is used right after a change of the displayed map's region occurred
     * with animation or not.
     *
     * @param mapView  The mapview that corresponds to this delegate.
     * @param animated TRUE then the change was animated.
     */
    @CMSelector("- (void)mapView:(MKMapView *)mapView \n"
            + "regionDidChangeAnimated:(BOOL)animated;")
    default void regionDidChangeAnimated(MKMapView mapView, boolean animated) {
    }

    /**
     * It is used right before the data retrieval of this map view.
     *
     * @param mapView The mapview that corresponds to this delegate.
     */
    @CMSelector("- (void)mapViewWillStartLoadingMap:(MKMapView *)mapView;\n"
            + "")
    default void willStartLoadingMap(MKMapView mapView) {
    }

    /**
     * It is used right after the data retrieval of this map view.
     *
     * @param mapView The mapview that corresponds to this delegate.
     */
    @CMSelector("- (void)mapViewDidFinishLoadingMap:(MKMapView *)mapView;")
    default void didFinishLoadingMap(MKMapView mapView) {
    }

    /**
     * It is used when there was an error during the data retrieval of this
     * mapview.
     *
     * @param mapView The mapview that corresponds to this delegate.
     * @param error   The error that occurred during retrieval.
     */
    @CMSelector("- (void)mapViewDidFailLoadingMap:(MKMapView *)mapView \n"
            + "                       withError:(NSError *)error;")
    default void didFailLoadingMap(MKMapView mapView, NSError error) {
    }

    /**
     * It is used right before the user's position tracking.
     *
     * @param mapView The mapview that corresponds to this delegate.
     */
    @CMSelector("- (void)mapViewWillStartLocatingUser:(MKMapView *)mapView;")
    default void willStartLocatingUser(MKMapView mapView) {
    }

    /**
     * It is used right after the end of user's position tracking.
     *
     * @param mapView The mapview that corresponds to this delegate.
     */
    @CMSelector("- (void)mapViewDidStopLocatingUser:(MKMapView *)mapView;\n"
            + "")
    default void didStopLocatingUser(MKMapView mapView) {
    }

    /**
     * It is used when user's location is updated.
     *
     * @param mapView      The mapview that corresponds to this delegate.
     * @param userLocation The new location of the user.
     */
    @CMSelector("- (void)mapView:(MKMapView *)mapView \n"
            + "didUpdateUserLocation:(MKUserLocation *)userLocation;")
    default void didUpdateUserLocation(MKMapView mapView, MKUserLocation userLocation) {
    }

    /**
     * It is used when there is an error during user's position tracking.
     *
     * @param mapView The mapview that corresponds to this delegate.
     * @param error   The error that occurred during tracking.
     */
    @CMSelector("- (void)mapView:(MKMapView *)mapView \n"
            + "didFailToLocateUserWithError:(NSError *)error;")
    default void didFailToLocateUserWithError(MKMapView mapView, NSError error) {
    }

    /**
     * Returns the annotation view of the specified annotation of this mapview.
     *
     * @param mapView    The mapview that corresponds to this delegate.
     * @param annotation The annotation for which the view is requested.
     * @return The annotation view of the specified annotation.
     */
    @CMSelector("- (MKAnnotationView *)mapView:(MKMapView *)mapView \n"
            + "            viewForAnnotation:(id<MKAnnotation>)annotation;")
    default MKAnnotationView viewForAnnotation(MKMapView mapView, MKAnnotation annotation) {
        return null;
    }

    /**
     * It is used when one or more annotations were added to the mapview.
     *
     * @param mapView The mapview that corresponds to this delegate.
     * @param views   The list of the added annotation views.
     */
    @CMSelector("- (void)mapView:(MKMapView *)mapView \n"
            + "didAddAnnotationViews:(NSArray<MKAnnotationView *> *)views;")
    default void didAddAnnotationViews(MKMapView mapView, List<MKAnnotationView> views) {
    }

    /**
     * It is used when the accessory button of the specified annotation view of
     * the related mapview was tapped.
     *
     * @param mapView        The mapview that corresponds to this delegate.
     * @param annotationView The annotation view of the accessory button.
     * @param control        The tapped control.
     */
    @CMSelector("- (void)mapView:(MKMapView *)mapView \n"
            + " annotationView:(MKAnnotationView *)view \n"
            + "calloutAccessoryControlTapped:(UIControl *)control;")
    default void annotationViewCalloutAccessoryControlTapped(MKMapView mapView, MKAnnotationView annotationView, UIControl control) {
    }

    /**
     * It is used when there was a change on the drag state of one annotation
     * view of this map view.
     *
     * @param mapView                      The mapview that corresponds to this delegate.
     * @param annotationView               The annotation view of whose drag state changed.
     * @param MKAnnotationViewDragStateNew The new drag state of the annotation
     *                                     view.
     * @param MKAnnotationViewDragStateOld The old drag state of the annotation
     *                                     view.
     */
    @CMSelector("- (void)mapView:(MKMapView *)mapView \n"
            + " annotationView:(MKAnnotationView *)view \n"
            + "didChangeDragState:(MKAnnotationViewDragState)newState \n"
            + "   fromOldState:(MKAnnotationViewDragState)oldState;")
    default void annotationViewDidChangeDragState(MKMapView mapView, MKAnnotationView annotationView, int MKAnnotationViewDragStateNew, int MKAnnotationViewDragStateOld) {
    }

    /**
     * It is used when one annotation view of the related map is selected.
     *
     * @param mapView        The mapview that corresponds to this delegate.
     * @param annotationView The selected annotation view.
     */
    @CMSelector("- (void)mapView:(MKMapView *)mapView \n"
            + "didSelectAnnotationView:(MKAnnotationView *)view;")
    default void didSelectAnnotationView(MKMapView mapView, MKAnnotationView annotationView) {
    }

    /**
     * It is used when one annotation view of the related map is deselected.
     *
     * @param mapView        The mapview that corresponds to this delegate.
     * @param annotationView The deselected annotation view.
     */
    @CMSelector("- (void)mapView:(MKMapView *)mapView \n"
            + "didDeselectAnnotationView:(MKAnnotationView *)view;")
    default void didDeselectAnnotationView(MKMapView mapView, MKAnnotationView annotationView) {
    }

    /**
     * It is used in order to return the overlay view of the specified overlay.
     *
     * @param mapView The mapview that corresponds to this delegate.
     * @param overlay The overlay for which the overlay view is requested.
     * @return The overlay view of the specified overlay.
     */
    @Deprecated
    @CMSelector("- (MKOverlayView *)mapView:(MKMapView *)mapView viewForOverlay:(id<MKOverlay>)overlay;")
    default MKOverlayView viewForOverlay(MKMapView mapView, MKOverlay overlay) {
        return null;
    }

    /**
     * It is used when one or more overlay views were added to the related map
     * view.
     *
     * @param mapView      The mapview that corresponds to this delegate.
     * @param overlayViews The overlay views that were added.
     */
    @Deprecated
    @CMSelector("- (void)mapView:(MKMapView *)mapView didAddOverlayViews:(NSArray *)overlayViews;")
    default void didAddOverlayViews(MKMapView mapView, List<MKOverlayView> overlayViews) {
    }
}
