/*
 * This project was created with CrossMobile Framework.
 * More info at https://crossmobile.org
 */

package crossmobile.projects.simple;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.uikit.*;

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
        title.setText("Hello from Aroma!");
        title.setTextAlignment(UITextAlignment.Center);

//        UIButton button = UIButton.buttonWithType(UIButtonType.System);
//        button.setFrame(new CGRect(80, 340, 160, 30));
//        button.setAutoresizingMask(UIViewAutoresizing.FlexibleWidth);
//        button.setTitle("Click me!", UIControlState.Normal);
//        button.addTarget((delegate, events) -> title.setText("The button was clicked " + (++clickcount) +
//                (clickcount == 1 ? " time" : " times")), UIControlEvents.TouchUpInside);

        mainView.addSubview(img);
//        mainView.addSubview(button);
        mainView.addSubview(title);
        setView(mainView);
    }
}
