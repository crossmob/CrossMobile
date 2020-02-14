/*
 * (c) 2020 by Panayotis Katsaloulis
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
package org.crossmobile.gui.utils;

import org.crossmobile.gui.actives.ActiveTextPane;
import org.crossmobile.gui.project.Project;
import org.crossmobile.gui.project.ProjectLauncher;
import org.crossmobile.prefs.Prefs;

import java.io.File;
import java.util.function.Consumer;

import static org.crossmobile.prefs.Prefs.*;

public class ExternalCommands {

    public static void openCode(String ide, Project proj, ActiveTextPane txtPane, Consumer<Integer> launchCallback) {
        String[] args;
        switch (ide) {
            case OPEN_NETBEANS:
                args = new String[]{Prefs.getNetbeansLocation(),
                        "--open",
                        proj.getPath().getAbsolutePath()};
                break;
            case OPEN_INTELLIJ:
                args = new String[]{Prefs.getIntelliJLocation(),
                        proj.getPom().getAbsolutePath()};
                break;
            case OPEN_STUDIO:
                args = new String[]{Prefs.getAndroidStudioLocation(),
                        proj.getPath().getAbsolutePath()};
                break;
            case OPEN_XCODE:
                args = new String[]{"/usr/bin/open",
                        proj.getPath().getAbsolutePath() + File.separator + proj.getArtifactID() + ".xcodeproj"};
                break;
            case OPEN_VSTUDIO:
                args = new String[]{"cmd.exe", "/C", "start",
                        proj.getPath().getAbsolutePath() + File.separator + proj.getArtifactID() + "-WinStore10.sln"};
                break;
            default:
                txtPane.appendText("\nNo IDE is selected.\n", null);
                launchCallback.accept(-1);
                return;
        }
        if (!new File(args[0]).isFile()) {
            txtPane.appendText("\nUnable to locate '" + args[0] + "' when invoking " + ide + ", probably a misconfiguration error.\n", null);
            launchCallback.accept(-1);
            return;
        }
        ProjectLauncher.launch(args, proj);
        launchCallback.accept(0);
    }

    public static void convertAARtoJAR(String signature) {
        System.out.println("convert to AAR");
    }
}
