/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGAffineTransform;
import crossmobile.ios.coregraphics.CGImage;
import crossmobile.ios.foundation.NSURL;
import crossmobile.ios.mobilecoreservices.UTType;
import org.crossmobile.bind.graphics.Geometry;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static crossmobile.ios.coregraphics.GraphicsDrill.filename;
import static org.crossmobile.bridge.ImageBridge.ImageSource.*;

/**
 * UIImagePickerController class defines an object that acts as an interface of
 * the available device's cameras. It also provides options for choosing saved
 * images and movies to use in an application. Its appearance depends on the
 * particular functionality settings.
 */
@CMClass
@CMLib(name = "cmimage", includes = "<UIKit/UIKit.h>")
public class UIImagePickerController extends UINavigationController {

    /**
     * The media type selected by the user.
     */
    public static final String MediaType = "UIImagePickerControllerMediaType";

    /**
     * The original image selected by the user.
     */
    public static final String OriginalImage = "UIImagePickerControllerOriginalImage";

    /**
     * An image edited by the user.
     */
    public static final String EditedImage = "UIImagePickerControllerEditedImage";

    /**
     * The cropping rectangle that was applied to the initial image.
     */
    public static final String CropRect = "UIImagePickerControllerCropRect";

    /**
     * The URL of the movie in the filesystem.
     */
    public static final String MediaURL = "UIImagePickerControllerMediaURL";

    /**
     * The Assets Library URL of the original version of the picked item.
     */
    public static final String ReferenceURL = "UIImagePickerControllerReferenceURL";

    /**
     * Metadata of a photograph.
     */
    public static final String MediaMetadata = "UIImagePickerControllerMediaMetadata";
    //
    private int sourceType = UIImagePickerControllerSourceType.PhotoLibrary;
    private boolean allowsEditing = false;
    private UIImagePickerControllerDelegate delegate = null;
    private List<String> mediaTypes = new ArrayList<>();
    private int videoQuality = UIImagePickerControllerQualityType.Medium;
    private double videoMaximumDuration = 600;
    private boolean showsCameraControls = true;
    private UIView cameraOverlayView = null;
    private CGAffineTransform cameraViewTransform = null;
    private int cameraDevice = UIImagePickerControllerCameraDevice.Rear;
    private int cameraCaptureMode = UIImagePickerControllerCameraCaptureMode.Photo;
    private int cameraFlashMode = UIImagePickerControllerCameraFlashMode.Auto;

    /**
     * Creates an object of UIImagePickerController.
     */
    public UIImagePickerController() {
        super(new UIViewController());
        mediaTypes.add(UTType.Image);
    }

    /**
     * Returns a Boolean that shows whether the specified source type is
     * available.
     *
     * @param UIImagePickerControllerSourceType The specified source type
     * @return True if the source type is available.
     */
    @CMSelector("+ (BOOL)isSourceTypeAvailable:(UIImagePickerControllerSourceType)sourceType;")
    public static boolean isSourceTypeAvailable(int UIImagePickerControllerSourceType) {
        switch (UIImagePickerControllerSourceType) {
            case crossmobile.ios.uikit.UIImagePickerControllerSourceType.Camera:
                return Native.image().supportsCamera(FRONT) || Native.image().supportsCamera(BACK);
            case crossmobile.ios.uikit.UIImagePickerControllerSourceType.PhotoLibrary:
                return Native.image().supportsCamera(LIBRARY);
            case crossmobile.ios.uikit.UIImagePickerControllerSourceType.SavedPhotosAlbum:
                return Native.image().supportsCamera(ALBUM);
            default:
                return false;
        }
    }

    /**
     * Returns a list with the available media types of the specified source
     * type.
     *
     * @param UIImagePickerControllerSourceType The specified source type.
     * @return The list with the available media types of the specified source
     * type.
     */
    @CMSelector("+ (NSArray<NSString *> *)availableMediaTypesForSourceType:(UIImagePickerControllerSourceType)sourceType;")
    public static List<String> availableMediaTypesForSourceType(int UIImagePickerControllerSourceType) {
        List<String> results = new ArrayList<>();
        results.add(UTType.Image);
        return results;
    }

    /**
     * Returns a Boolean that shows whether the specified camera is available.
     *
     * @param UIImagePickerControllerCameraDevice The camera of the device which
     *                                            is checked if it is available.
     * @return Returns true if the specified camera is available.
     */
    @CMSelector("+ (BOOL)isCameraDeviceAvailable:(UIImagePickerControllerCameraDevice)cameraDevice;")
    public static boolean isCameraDeviceAvailable(int UIImagePickerControllerCameraDevice) {
        switch (UIImagePickerControllerCameraDevice) {
            case crossmobile.ios.uikit.UIImagePickerControllerCameraDevice.Front:
                return Native.image().supportsCamera(FRONT);
            case crossmobile.ios.uikit.UIImagePickerControllerCameraDevice.Rear:
                return Native.image().supportsCamera(BACK);
            default:
                return false;
        }
    }

    /**
     * Returns a list with available capturing modes for the specified camera of
     * the device.
     *
     * @param UIImagePickerControllerCameraDevice The camera of the device for
     *                                            which the list is returned.
     * @return The list with available capturing modes for the enabled camera of
     * the device.
     */
    @CMSelector("+ (NSArray<NSNumber *> *)availableCaptureModesForCameraDevice:(UIImagePickerControllerCameraDevice)cameraDevice;")
    public static List<Integer> availableCaptureModesForCameraDevice(int UIImagePickerControllerCameraDevice) {
        return new ArrayList<>();
    }

    /**
     * Returns a Boolean that shows whether the enabled camera supports flash.
     *
     * @param UIImagePickerControllerCameraDevice A Boolean that shows whether
     *                                            the enabled camera supports flash.
     * @return TRUE then the camera supports flash.
     */
    @CMSelector("+ (BOOL)isFlashAvailableForCameraDevice:(UIImagePickerControllerCameraDevice)cameraDevice;")
    public static boolean isFlashAvailableForCameraDevice(int UIImagePickerControllerCameraDevice) {
        return false;
    }

    /**
     * Returns the type of picker interface displayed by the image picker
     * controller.
     *
     * @return The type of picker interface displayed by the image picker
     * controller.
     */
    @CMGetter("@property(nonatomic) UIImagePickerControllerSourceType sourceType;")
    public int sourceType() {
        return sourceType;
    }

    /**
     * Sets the type of picker interface displayed by the image picker
     * controller.
     *
     * @param UIImagePickerControllerSourceType The type of picker interface
     *                                          displayed by the image picker controller.
     */
    @CMSetter("@property(nonatomic) UIImagePickerControllerSourceType sourceType;")
    public void setSourceType(int UIImagePickerControllerSourceType) {
        this.sourceType = UIImagePickerControllerSourceType;
    }

    /**
     * Returns a Boolean that shows whether the use is allowed to edit the image
     * or video.
     *
     * @return A Boolean that shows whether the use is allowed to edit the image
     * or video.
     */
    @CMGetter("@property(nonatomic) BOOL allowsEditing;")
    public boolean allowsEditing() {
        return allowsEditing;
    }

    /**
     * Set a Boolean that defines whether the use is allowed to edit the image
     * or video.
     *
     * @param allowsEditing A Boolean that defines whether the use is allowed to
     *                      edit the image or video.
     */
    @CMSetter("@property(nonatomic) BOOL allowsEditing;")
    public void setAllowsEditing(boolean allowsEditing) {
        this.allowsEditing = allowsEditing;
    }

    @Override
    public UIImagePickerControllerDelegate delegate() {
        return delegate;
    }

    /**
     * Sets the delegate for this image picker controller.
     *
     * @param delegate The delegate for this image picker controller.
     */
    @Override
    @CMSetter("@property(nonatomic, weak) id<UINavigationControllerDelegate, UIImagePickerControllerDelegate> delegate;")
    public void setDelegate(UINavigationControllerDelegate delegate) {
        this.delegate = (UIImagePickerControllerDelegate) delegate;
    }

    /**
     * Returns the list with the supported media types.
     *
     * @return The supported media types.
     */
    @CMGetter("@property(nonatomic, copy) NSArray<NSString *> *mediaTypes;")
    public List<String> mediaTypes() {
        return mediaTypes;
    }

    /**
     * Sets the list with the media types that the image picker controller
     * supports.
     *
     * @param mediaTypes The supported media types.
     */
    @CMSetter("@property(nonatomic, copy) NSArray<NSString *> *mediaTypes;")
    public void setMediaTypes(List<String> mediaTypes) {
        this.mediaTypes = mediaTypes;
    }

    /**
     * Returns the maximum video length.
     *
     * @return The maximum video length.
     */
    @CMGetter("@property(nonatomic) NSTimeInterval videoMaximumDuration;")
    public double videoMaximumDuration() {
        return videoMaximumDuration;
    }

    /**
     * Sets the maximum video length.
     *
     * @param videoMaximumDuration The maximum video length.
     */
    @CMSetter("@property(nonatomic) NSTimeInterval videoMaximumDuration;")
    public void setVideoMaximumDuration(double videoMaximumDuration) {
        this.videoMaximumDuration = videoMaximumDuration;
    }

    /**
     * Returns the video quality.
     *
     * @return The video quality.
     */
    @CMGetter("@property(nonatomic) UIImagePickerControllerQualityType videoQuality;")
    public int videoQuality() {
        return videoQuality;
    }

    /**
     * Specifies video quality.
     *
     * @param UIImagePickerControllerQualityType The video quality.
     */
    @CMSetter("@property(nonatomic) UIImagePickerControllerQualityType videoQuality;")
    public void setVideoQuality(int UIImagePickerControllerQualityType) {
        this.videoQuality = UIImagePickerControllerQualityType;
    }

    /**
     * Returns the view that is displayed above the default image picker
     * interface.
     *
     * @return The view that is displayed above the default image picker
     * interface.
     */
    @CMGetter("@property(nonatomic, strong) __kindof UIView *cameraOverlayView;")
    public UIView cameraOverlayView() {
        return cameraOverlayView;
    }

    /**
     * Sets the view to be displayed above the default image picker interface.
     *
     * @param cameraOverlayView The view to be displayed above the default image
     *                          picker interface.
     */
    @CMSetter("@property(nonatomic, strong) __kindof UIView *cameraOverlayView;")
    public void setCameraOverlayView(UIView cameraOverlayView) {
        this.cameraOverlayView = cameraOverlayView;
    }

    /**
     * Returns the transformation that is applied to the image preview.
     *
     * @return The transformation that is applied to the image preview.
     */
    @CMGetter("@property(nonatomic) CGAffineTransform cameraViewTransform;")
    public CGAffineTransform cameraViewTransform() {
        return cameraViewTransform == null ? null : Geometry.copy(cameraViewTransform);
    }

    /**
     * Sets the transformation to be applied to the image preview.
     *
     * @param cameraViewTransform The transformation of the image preview.
     */
    @CMSetter("@property(nonatomic) CGAffineTransform cameraViewTransform;")
    public void setCameraViewTransform(CGAffineTransform cameraViewTransform) {
        if (cameraViewTransform == null)
            this.cameraViewTransform = null;
        else if (this.cameraViewTransform == null)
            this.cameraViewTransform = Geometry.copy(cameraViewTransform);
        else
            Geometry.set(this.cameraViewTransform, cameraViewTransform);
    }

    /**
     * Returns a Boolean that shows whether the camera displays the default
     * controls.
     *
     * @return A Boolean that shows whether the camera displays the default
     * controls.
     */
    @CMGetter("@property(nonatomic) BOOL showsCameraControls;")
    public boolean showsCameraControls() {
        return showsCameraControls;
    }

    /**
     * Sets a Boolean that defines whether the camera displays the default
     * controls.
     *
     * @param showsCameraControls A Boolean that defines whether the camera
     *                            displays the default controls.
     */
    @CMSetter("@property(nonatomic) BOOL showsCameraControls;")
    public void setShowsCameraControls(boolean showsCameraControls) {
        this.showsCameraControls = showsCameraControls;
    }

    /**
     * Returns the capture mode used by the camera.
     *
     * @return The capture mode used by the camera.
     */
    @CMGetter("@property(nonatomic) UIImagePickerControllerCameraCaptureMode cameraCaptureMode;")
    public int cameraCaptureMode() {
        return cameraCaptureMode;
    }

    /**
     * Sets the capture mode used by the camera.
     *
     * @param UIImagePickerControllerCameraCaptureMode The capture mode used by
     *                                                 the camera.
     */
    @CMSetter("@property(nonatomic) UIImagePickerControllerCameraCaptureMode cameraCaptureMode;")
    public void setCameraCaptureMode(int UIImagePickerControllerCameraCaptureMode) {
        this.cameraCaptureMode = UIImagePickerControllerCameraCaptureMode;
    }

    /**
     * Returns the camera that is used by the image picker controller.
     *
     * @return The camera that is used by the image picker controller.
     */
    @CMGetter("@property(nonatomic) UIImagePickerControllerCameraDevice cameraDevice;\n"
            + "")
    public int cameraDevice() {
        return cameraDevice;
    }

    /**
     * Sets the camera to be used by the image picker controller.
     *
     * @param UIImagePickerControllerCameraDevice The camera to be used by the
     *                                            image picker controller.
     */
    @CMSetter("@property(nonatomic) UIImagePickerControllerCameraDevice cameraDevice;\n"
            + "")
    public void setCameraDevice(int UIImagePickerControllerCameraDevice) {
        this.cameraDevice = UIImagePickerControllerCameraDevice;
    }

    /**
     * Returns the flash mode of the camera.
     *
     * @return The flash mode of the camera.
     */
    @CMGetter("@property(nonatomic) UIImagePickerControllerCameraFlashMode cameraFlashMode;")
    public int cameraFlashMode() {
        return cameraFlashMode;
    }

    /**
     * Sets the flash mode according to the specified value.
     *
     * @param UIImagePickerControllerCameraFlashMode The flash mode of the
     *                                               camera.
     */
    @CMSetter("@property(nonatomic) UIImagePickerControllerCameraFlashMode cameraFlashMode;")
    public void setCameraFlashMode(int UIImagePickerControllerCameraFlashMode) {
        this.cameraFlashMode = UIImagePickerControllerCameraFlashMode;
    }

    /**
     * Captures a picture.
     */
    @CMSelector("- (void)takePicture;")
    public void takePicture() {
        throw new RuntimeException("- (void)takePicture; not implemented for " + System.getProperty("os.name"));
    }

    /**
     * Starts video capturing.
     *
     * @return True if it was successful.
     */
    @CMSelector("- (BOOL)startVideoCapture;")
    public boolean startVideoCapture() {
        return false;
    }

    /**
     * Stops video capturing.
     */
    @CMSelector("- (void)stopVideoCapture;")
    public void stopVideoCapture() {
    }

    @Override
    public void dismissViewControllerAnimated(boolean flag, Runnable completion) {
        UINavigationController nav = navigationController();
        if (nav != null) {
            nav.popViewControllerAnimated(flag);
            return;
        }
        UIViewController viewController = UIImagePickerController.this.presentingViewController();
        if (viewController != null) viewController.dismissViewControllerAnimated(flag, null);
    }


    @Override
    public void viewWillAppear(boolean animated) {
        if (UIImagePickerController.this.sourceType == UIImagePickerControllerSourceType.Camera)
            Native.image().requestCamera(this::execDelegate);
        else Native.image().requestPhotoAlbum(this::execDelegate);
    }

    private void execDelegate(CGImage cgimage) {
        if (delegate == null)
            return;
        if (cgimage == null)
            delegate.didCancel(UIImagePickerController.this);
        else {
            Map<String, Object> info = new HashMap<>();
            UIImage image = UIImage.imageWithCGImage(cgimage);
            info.put(OriginalImage, image);
            info.put(EditedImage, image);
            info.put(MediaURL, NSURL.fileURLWithPath(filename(cgimage)));
            delegate.didFinishPickingMediaWithInfo(UIImagePickerController.this, info);
        }
    }
}
