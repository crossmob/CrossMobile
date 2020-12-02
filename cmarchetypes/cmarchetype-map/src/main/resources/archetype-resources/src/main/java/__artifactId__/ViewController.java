/*
 * This project was created with CrossMobile Framework.
 * More info at https://crossmobile.org
 */

package ${groupId}.${artifactId};

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.corelocation.CLLocationCoordinate2D;
import crossmobile.ios.mapkit.MKAnnotation;
import crossmobile.ios.mapkit.MKCoordinateRegion;
import crossmobile.ios.mapkit.MKCoordinateSpan;
import crossmobile.ios.mapkit.MKMapView;
import crossmobile.ios.uikit.*;

import java.util.List;

public class ViewController extends UIViewController {

    @Override
    public void loadView() {
        UIView base = new UIView(new CGRect(0, 0, 320, 480));
        base.setBackgroundColor(UIColor.whiteColor());

        MKAnnotation annotationAthens = new MKAnnotation() {
            final CLLocationCoordinate2D location = new CLLocationCoordinate2D(51.477806, -0.001472);

            @Override
            public String title() {
                return "Greenwich";
            }

            @Override
            public CLLocationCoordinate2D coordinate() {
                return location;
            }
        };

        MKMapView map = new MKMapView(new CGRect(0, 0, 320, 400));
        map.setAutoresizingMask(UIViewAutoresizing.FlexibleHeight | UIViewAutoresizing.FlexibleWidth);
        map.setShowsUserLocation(true);
        map.addAnnotation(annotationAthens);
        map.setRegion(new MKCoordinateRegion(annotationAthens.coordinate(), new MKCoordinateSpan(0.10, 0.10)));

        UIButton cameraToAthens = UIButton.buttonWithType(UIButtonType.System);
        cameraToAthens.setAutoresizingMask(UIViewAutoresizing.FlexibleTopMargin);
        cameraToAthens.setFrame(new CGRect(0, 400, 160, 40));
        cameraToAthens.setTitle("Go to Greenwich", UIControlState.Normal);
        cameraToAthens.addTarget((uic, uie) -> map.setCenterCoordinate(annotationAthens.coordinate(), true), UIControlEvents.TouchUpInside);

        UIButton cameraToUser = UIButton.buttonWithType(UIButtonType.System);
        cameraToUser.setAutoresizingMask(UIViewAutoresizing.FlexibleTopMargin);
        cameraToUser.setFrame(new CGRect(160, 400, 160, 40));
        cameraToUser.setTitle("Go to User location", UIControlState.Normal);
        cameraToUser.addTarget((uic, uie) -> map.setRegion(new MKCoordinateRegion(map.userLocation().coordinate(), new MKCoordinateSpan(0.005f, 0.005f)), true), UIControlEvents.TouchUpInside);

        base.addSubview(map);
        base.addSubview(cameraToAthens);
        base.addSubview(cameraToUser);
        setView(base);
    }
}
