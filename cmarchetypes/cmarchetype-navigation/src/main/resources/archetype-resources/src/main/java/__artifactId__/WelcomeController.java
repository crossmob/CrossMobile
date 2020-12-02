/*
 * This project was created with CrossMobile Framework.
 * More info at https://crossmobile.org
 */

package ${groupId}.${artifactId};

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.uikit.UIButton;
import crossmobile.ios.uikit.UIButtonType;
import crossmobile.ios.uikit.UIColor;
import crossmobile.ios.uikit.UIControlEvents;
import crossmobile.ios.uikit.UIControlState;
import crossmobile.ios.uikit.UILabel;
import crossmobile.ios.uikit.UITextAlignment;
import crossmobile.ios.uikit.UIView;
import crossmobile.ios.uikit.UIViewAutoresizing;
import crossmobile.ios.uikit.UIViewController;

public class WelcomeController extends UIViewController {

    @Override
    public void loadView() {
        setTitle("Welcome");

        UIView mainView = new UIView(new CGRect(0, 0, 320, 400));
        mainView.setBackgroundColor(UIColor.colorWithWhiteAlpha(0.9f, 1));

        UIButton button = UIButton.buttonWithType(UIButtonType.System);
        button.setFrame(new CGRect(80, 180, 160, 30));
        button.setAutoresizingMask(UIViewAutoresizing.FlexibleWidth);
        button.setTitle("Go to next controller", UIControlState.Normal);
        button.addTarget((delegate, events) -> navigationController().pushViewController(new ChildController(), true),
                UIControlEvents.TouchUpInside);

        mainView.addSubview(button);
        setView(mainView);
    }
}
