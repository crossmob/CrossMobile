package ${groupId}.${artifactId};

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMSelector;

@CMLib(includes = "<UIKit/UIDevice.h>")
@CMClass
public class UIDevice extends NSObject {
    private final static UIDevice CURRENT = new UIDevice();

    private UIDevice() {
    }

    @CMSelector("+ (UIDevice*) currentDevice;")
    public static UIDevice currentDevice() {
        return CURRENT;
    }

    @CMGetter("@property(nonatomic, readonly, strong) NSString *systemName;")
    public String systemName() {
        return System.getProperty("os.name");
    }
}
