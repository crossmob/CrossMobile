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
package org.crossmobile.gui.codehound.bin;

import org.crossmobile.gui.LongProcFrame;
import org.crossmobile.gui.project.Project;
import org.crossmobile.gui.utils.Paths;
import org.crossmobile.utils.Commander;

import java.util.Collection;
import java.util.EnumSet;
import java.util.TreeSet;

import static org.crossmobile.utils.ClasspathUtils.CLASS_USAGE_SIGNATURE;

public class PermissionsAction {

    public static Collection<Permissions> findPermissions(final Project proj) {
        final LongProcFrame frame = new LongProcFrame("Recalculating dependencies",
                "This procedure will need to <b>clean</b> the current project and rebuild it using a java-only target. If you want to go on press the <i>Continue</i> button.",
                "Calculate dependencies for plugins also", "Please wait while compiling project...");
        Collection<Permissions> permissions = new TreeSet<>();

        Commander launcher = new Commander(Paths.getMavenLocation(), "clean", "compile", "-Pdesktop,findclasses");
        launcher.setCurrentDir(proj.getPath());
        launcher.setOutListener(line -> {
            int idx = line.indexOf(CLASS_USAGE_SIGNATURE);
            if (idx >= 0)
                permissions.addAll(convertImportToPermissions(line.substring(idx + CLASS_USAGE_SIGNATURE.length()).trim()));
            else
                System.out.println(line);
        });
        launcher.setErrListener(System.err::println);
        launcher.setEndListener(result -> frame.invoke(result == 0
                ? "Process terminated successfully"
                : "Unable to clean up project"));

        frame.setExecuteCallback((withOptions) -> launcher.exec());
        frame.setCancelCallback(launcher::kill);

        frame.setVisible(true);
        // wait for the window to finish
        return permissions;
    }

    private static Collection<Permissions> convertImportToPermissions(String className) {
        EnumSet<Permissions> perms = EnumSet.noneOf(Permissions.class);
        for (Permissions perm : Permissions.values())
            if (perm.requires(className))
                perms.add(perm);
        return perms;
    }

}
