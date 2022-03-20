/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.mapkit;

import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.uikit.UIImage;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

import static crossmobile.ios.mapkit.MKPinAnnotationColor.*;

/**
 * MKPinAnnotationView class defines an object that represents the view of a pin
 * that is used to mark a point on a map.
 */
@CMClass
public class MKPinAnnotationView extends MKAnnotationView {

    private int pinColor = MKPinAnnotationColor.Red;
    private boolean animatesDrop = true;

    /**
     * Constructs a MKPinAnnotationView object initialized with the specified
     * annotation and id.
     *
     * @param annotation      The MKAnnotation object of this MKPinAnnotationView.
     * @param reuseIdentifier The id of this view in order to reuse it in the
     *                        future.
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public MKPinAnnotationView(MKAnnotation annotation, String reuseIdentifier) {
        super(annotation, reuseIdentifier);
        setPinColor(Red);
        setCenterOffset(new CGPoint(0, 13));    // 32/2 - 3 offset
    }

    /**
     * Returns a Boolean that shows whether the annotation view is animated or
     * not.
     *
     * @return TRUE the annotation view is animated.
     */
    @CMGetter("@property(nonatomic) BOOL animatesDrop;")
    public boolean animatesDrop() {
        return animatesDrop;
    }

    /**
     * Sets a Boolean that defines whether the annotation view is animated or
     * not.
     *
     * @param animatesDrop TRUE the annotation view is animated.
     */
    @CMSetter("@property(nonatomic) BOOL animatesDrop;")
    public void setAnimatesDrop(boolean animatesDrop) {
        this.animatesDrop = animatesDrop;
    }

    /**
     * Returns the color of the pin head.
     *
     * @return The color of the pin head.
     * @see crossmobile.ios.mapkit.MKPinAnnotationColor
     */
    @CMGetter("@property(nonatomic) MKPinAnnotationColor pinColor;")
    public int pinColor() {
        return pinColor;
    }

    /**
     * Sets the specified color for the pin head.
     *
     * @param MKPinAnnotationColor The color of the pin head.
     * @see crossmobile.ios.mapkit.MKPinAnnotationColor
     */
    @CMSetter("@property(nonatomic) MKPinAnnotationColor pinColor;")
    public void setPinColor(int MKPinAnnotationColor) {
        this.pinColor = MKPinAnnotationColor;
        switch (MKPinAnnotationColor) {
            case Purple:
                setImage(UIImage.imageWithContentsOfFile(Native.file().getSystemPrefix() + "pinpurple"));
                break;
            case Green:
                setImage(UIImage.imageWithContentsOfFile(Native.file().getSystemPrefix() + "pingreen"));
                break;
            case Red:
                setImage(UIImage.imageWithContentsOfFile(Native.file().getSystemPrefix() + "pinred"));
                break;
        }
    }
}
