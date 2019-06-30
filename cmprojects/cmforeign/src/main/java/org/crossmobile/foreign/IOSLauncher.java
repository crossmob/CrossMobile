/*
 * (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
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
            System.out.println("Unable to launch project " + project.getName());
            System.exit(-1);
        }
    }

}
