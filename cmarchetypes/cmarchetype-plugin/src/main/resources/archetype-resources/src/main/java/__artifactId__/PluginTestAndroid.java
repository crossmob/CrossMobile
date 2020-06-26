package ${groupId}.${artifactId};

import android.os.Build;
import org.crossmobile.bridge.ann.CMLib;

import static org.crossmobile.bridge.ann.CMLibTarget.ANDROID;

@CMLib(target = ANDROID
// This is an example, how to define external requirements for Android:
//      , depends = @CMLibDepends(groupId = "other.groupID", pluginName = "artifactId", version = "version", type = "aar")
)
public class PluginTestAndroid {
    public static String getAndroidVersion() {
        return Build.VERSION.RELEASE;
    }
}
