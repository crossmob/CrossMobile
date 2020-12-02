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

    private UIWindow window;

    @Override
    public UIWindow window() {
        return window;
    }

    @Override
    public void setWindow(UIWindow window) {
        this.window = window;
    }

    @Override
    public boolean didFinishLaunchingWithOptions(UIApplication app, Map<String, Object> launchOptions) {
        return true;
    }
}
