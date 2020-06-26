@CMLib(name = "${artifactId}", target = CMLibTarget.API,
        displayName = "Plugin Test",
        description = "Demo plugin for CrossMobile© framework",
        // This is an example of CrossMobile plugin dependencies.
        // At least the core cmioslayer plugin should be defined.
        // For example on external plugins, see each target explicitly.
        depends = @CMLibDepends(pluginName = "cmioslayer"))
package ${groupId}.${artifactId};

import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibDepends;
import org.crossmobile.bridge.ann.CMLibTarget;
