/*
 * This project was created with CrossMobile Framework.
 * More info at https://crossmobile.org
 */

package ${groupId}.${artifactId};

import crossmobile.ios.uikit.*;

import java.util.Map;

public class ApplicationDelegate implements UIApplicationDelegate {

    @SuppressWarnings("FieldCanBeLocal")
    private UIWindow window;

    @Override
    public boolean didFinishLaunchingWithOptions(UIApplication app, Map<String, Object> launchOptions) {
        window = new UIWindow(UIScreen.mainScreen().bounds());
        window.setRootViewController( new UINavigationController(new ViewController()));
        window.makeKeyAndVisible();
        return true;
    }
}
