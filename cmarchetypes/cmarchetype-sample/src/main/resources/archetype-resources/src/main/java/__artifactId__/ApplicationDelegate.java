/*
 * This project was created with CrossMobile library.
 * More info at https://crossmobile.tech
 */

package ${groupId}.${artifactId};

import crossmobile.ios.uikit.UIApplication;
import crossmobile.ios.uikit.UIApplicationDelegate;
import crossmobile.ios.uikit.UIScreen;
import crossmobile.ios.uikit.UIWindow;
import java.util.Map;

public class ApplicationDelegate implements UIApplicationDelegate {

    private UIWindow window;

    @Override
    public boolean didFinishLaunchingWithOptions(UIApplication app, Map<String, Object> launchOptions) {
        window = new UIWindow(UIScreen.mainScreen().bounds());
        window.setRootViewController(new ViewController());
        window.makeKeyAndVisible();
        return true;
    }
}
