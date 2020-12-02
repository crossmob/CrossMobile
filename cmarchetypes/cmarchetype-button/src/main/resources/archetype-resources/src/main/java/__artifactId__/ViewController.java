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
import crossmobile.ios.uikit.UIImage;
import crossmobile.ios.uikit.UIImageView;
import crossmobile.ios.uikit.UILabel;
import crossmobile.ios.uikit.UITextAlignment;
import crossmobile.ios.uikit.UIView;
import crossmobile.ios.uikit.UIViewAutoresizing;
import crossmobile.ios.uikit.UIViewController;

public class ViewController extends UIViewController {
    private int clickcount = 0;

    @Override
    public void loadView() {
        UIView mainView = new UIView(new CGRect(0, 0, 320, 400));
        mainView.setBackgroundColor(UIColor.colorWithWhiteAlpha(0.9f, 1));

        UIImageView img = new UIImageView(new CGRect(80, 80, 159, 220));
        img.setAutoresizingMask(UIViewAutoresizing.FlexibleLeftMargin | UIViewAutoresizing.FlexibleRightMargin);
        img.setImage(UIImage.imageNamed("logo"));

        UILabel title = new UILabel(new CGRect(0, 390, 320, 40));
        title.setAutoresizingMask(UIViewAutoresizing.FlexibleWidth);
        title.setText("Hello World!");
        title.setTextAlignment(UITextAlignment.Center);

        UIButton button = UIButton.buttonWithType(UIButtonType.System);
        button.setFrame(new CGRect(80, 340, 160, 30));
        button.setAutoresizingMask(UIViewAutoresizing.FlexibleWidth);
        button.setTitle("Click me!", UIControlState.Normal);
        button.addTarget((delegate, events) -> title.setText("The button was clicked " + (++clickcount) +
                (clickcount == 1 ? " time" : " times")), UIControlEvents.TouchUpInside);

        mainView.addSubview(img);
        mainView.addSubview(button);
        mainView.addSubview(title);
        setView(mainView);
    }
}
