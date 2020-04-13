// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: LGPL-3.0-only

package org.crossmobile.foreign;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class IOSLauncher {

    public static void launch(Properties props) {
        File userdir = new File(System.getProperty("user.dir"));
        String app = props.getProperty("appId");
        File xcworkspace = new File(userdir, app + ".xcworkspace");
        File xcodeproj = new File(userdir, app + ".xcodeproj");
        File project = new File(xcworkspace, "contents.xcworkspacedata").exists() ? xcworkspace : xcodeproj;
        try {
            Runtime.getRuntime().exec(new String[]{"open", project.getAbsolutePath()});
        } catch (IOException ex) {
            Log.error("Unable to launch project " + project.getName());
            System.exit(1);
        }
    }

}
