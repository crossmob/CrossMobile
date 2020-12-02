/*
 * This project was created with CrossMobile Framework.
 * More info at https://crossmobile.org
 */

package ${groupId}.${artifactId};

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.foundation.NSData;
import crossmobile.ios.uikit.*;

import java.util.Map;

public class ViewController extends UIViewController {
    @Override
    public void loadView() {
        UIView mainView = new UIView(new CGRect(0, 0, 320, 400));
        mainView.setBackgroundColor(UIColor.colorWithWhiteAlpha(0.9f, 1));

        UIImageView img = new UIImageView(new CGRect(80, 80, 159, 220));
        img.setAutoresizingMask(UIViewAutoresizing.FlexibleLeftMargin | UIViewAutoresizing.FlexibleRightMargin);
        img.setContentMode(UIViewContentMode.ScaleAspectFit);
        img.setImage(UIImage.imageNamed("logo"));

        UIButton button = UIButton.buttonWithType(UIButtonType.System);
        button.setFrame(new CGRect(80, 340, 160, 30));
        button.setAutoresizingMask(UIViewAutoresizing.FlexibleWidth);
        button.setTitle("Open camera", UIControlState.Normal);
        button.addTarget((delegate, events) -> {
            if (!UIImagePickerController.isSourceTypeAvailable(UIImagePickerControllerSourceType.Camera)) {
                error("A camera is not present in this device");
                return;
            }
            UIImagePickerController imgpicker = new UIImagePickerController();
            imgpicker.setSourceType(UIImagePickerControllerSourceType.Camera);
            imgpicker.setDelegate(new UIImagePickerControllerDelegate() {
                @Override
                public void didFinishPickingMediaWithInfo(UIImagePickerController picker, Map<String, Object> info) {
                    picker.dismissViewControllerAnimated(true, null);
                    UIImage photo = (UIImage) info.get(UIImagePickerController.OriginalImage);
                    img.setImage(photo);
                    // convert to binary data
                    // photo.JPEGRepresentation(1);
                }

                @Override
                public void didCancel(UIImagePickerController picker) {
                    error("Unable to pick image");
                }
            });
            presentViewController(imgpicker, true, null);
        }, UIControlEvents.TouchUpInside);

        mainView.addSubview(img);
        mainView.addSubview(button);
        setView(mainView);
    }

    private void error(String message) {
        UIAlertController controller = UIAlertController.alertControllerWithTitle("Error", message, UIAlertControllerStyle.Alert);
        controller.addAction(UIAlertAction.actionWithTitle("Acknowledge", UIAlertActionStyle.Default, null));
        presentViewController(controller, true, null);
    }
}
