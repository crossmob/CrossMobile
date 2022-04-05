package ${groupId}.${artifactId};

import org.crossmobile.bridge.ann.CMLib;

import static org.crossmobile.bridge.ann.CMLibTarget.SWING;

/**
 * This part of code is present <b>only</b> in the Desktop version of the plugin.
 */

@CMLib(target = SWING
// This is an example, how to define external requirements:
//      , depends = @CMLibDepends(groupId = "other.groupID", pluginName = "artifactId", version = "version")
)
public class PluginTestSwing {
    public static String getVersion() {
        return System.getProperty("os.version");
    }
}
