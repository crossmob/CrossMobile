/*
 * This project was created with CrossMobile Framework.
 * More info at https://crossmobile.org
 */

package ${groupId}.${artifactId};

import crossmobile.ios.uikit.UIColor;
import crossmobile.ios.uikit.UIView;
import crossmobile.ios.uikit.UIViewController;

public class ViewController extends UIViewController {

    @Override
    public void loadView() {
        UIView mainView = new UIView();
        mainView.setBackgroundColor(UIColor.whiteColor());
        setView(mainView);
    }
}
