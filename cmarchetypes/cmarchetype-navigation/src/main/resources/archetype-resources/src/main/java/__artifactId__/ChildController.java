/*
 * This project was created with CrossMobile Framework.
 * More info at https://crossmobile.org
 */

package ${groupId}.${artifactId};

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.uikit.UIColor;
import crossmobile.ios.uikit.UILabel;
import crossmobile.ios.uikit.UITextAlignment;
import crossmobile.ios.uikit.UIView;
import crossmobile.ios.uikit.UIViewAutoresizing;
import crossmobile.ios.uikit.UIViewController;

public class ChildController extends UIViewController {
    @Override
    public void loadView() {
        setTitle("Child");

        UIView mainView = new UIView(new CGRect(0, 0, 320, 400));
        mainView.setBackgroundColor(UIColor.colorWithWhiteAlpha(0.9f, 1));

        UILabel title = new UILabel(new CGRect(0, 390, 320, 40));
        title.setAutoresizingMask(UIViewAutoresizing.FlexibleWidth);
        title.setText("This is a child controller");
        title.setTextAlignment(UITextAlignment.Center);

        mainView.addSubview(title);
        setView(mainView);
    }
}
