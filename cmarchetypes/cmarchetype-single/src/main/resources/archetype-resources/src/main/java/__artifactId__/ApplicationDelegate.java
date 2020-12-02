/*
 * This project was created with CrossMobile Framework.
 * More info at https://crossmobile.org
 */

package ${groupId}.${artifactId};

import crossmobile.ios.uikit.UIApplication;
import crossmobile.ios.uikit.UIApplicationDelegate;
import crossmobile.ios.uikit.UIScreen;
import crossmobile.ios.uikit.UIWindow;
import java.util.Map;

public class ApplicationDelegate implements UIApplicationDelegate {

    @SuppressWarnings("FieldCanBeLocal")
    private UIWindow window;

    @Override
    public boolean didFinishLaunchingWithOptions(UIApplication app, Map<String, Object> launchOptions) {
        window = new UIWindow(UIScreen.mainScreen().bounds());
        window.setRootViewController(new ViewController());
        window.makeKeyAndVisible();
        return true;
    }
}
