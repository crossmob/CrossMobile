package ${groupId}.${artifactId};

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMSelector;

@CMLib(includes = "PluginTest.h")
@CMClass
public class PluginTest extends NSObject {

    @CMSelector("+ (int) getANumber;")
    public static int getANumber() {
        return 5;
    }

    @CMSelector("- (NSString*) doubleString:(NSString*) input;")
    public String doubleString(String input) {
        return input + input;
    }

    @CMSelector("- (NSString*) systemVersion;")
    public String systemVersion() {
        return Native.isAndroid() ? PluginTestAndroid.getAndroidVersion() : PluginTestSwing.getVersion();
    }
}
