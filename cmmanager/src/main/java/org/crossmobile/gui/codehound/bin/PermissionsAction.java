/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.crossmobile.gui.codehound.bin;

import org.crossmobile.gui.LongProcFrame;
import org.crossmobile.gui.LongProcListener;
import org.crossmobile.gui.project.Project;
import org.crossmobile.gui.project.ProjectLauncher;
import org.crossmobile.gui.utils.Paths;
import org.crossmobile.utils.Commander;

import java.util.Collection;
import java.util.EnumSet;

public class PermissionsAction {

    public static Collection<Permissions> findPermissions(final Project proj) {
        final LongProcFrame<PermissionsFinderLevel, Permissions> frame = new LongProcFrame("Recalculating dependencies").
                setLastStep(PermissionsFinderLevel.FINISH).
                setToogleText("Calculate dependencies for plugins also").
                setWelcomeText("This procedure will need to <b>clean</b> the current project and rebuild it using a java-only target. If you want to go on press the <i>Continue</i> button.");
        frame.setAsynchronousFunction((final Boolean data) -> {
            findImpl(frame, proj, data);
        });
        frame.setVisible(true);
        // wait for the window to finish
        return frame.getSuccessList();
    }

    @SuppressWarnings({"UseSpecificCatch"})
    private static void findImpl(LongProcListener<PermissionsFinderLevel, Permissions> listener, Project proj, boolean plugins) {
        Commander launcher;

        listener.update(PermissionsFinderLevel.CLEAN);
        launcher = ProjectLauncher.launch(new String[]{
                Paths.getMavenLocation(),
                "clean"
        }, proj);
        launcher.waitFor();
        if (launcher.exitValue() != 0) {
            listener.error("Unable to clean up project");
            return;
        }

        listener.update(PermissionsFinderLevel.COMPILE);
        launcher = ProjectLauncher.launch(new String[]{
                Paths.getMavenLocation(),
                "install",
                "-Pdesktop"
        }, proj);
        launcher.waitFor();
        if (launcher.exitValue() != 0) {
            listener.error("Unable to compile project");
            return;
        }

        Collection<Permissions> permissions;
        listener.update(PermissionsFinderLevel.PARSE);
        try {
            permissions = convertImportToPermissions(ImportsFinder.findAllImports(proj.getClasspath(plugins)));
            if (permissions == null)
                throw new RuntimeException("Unable to parse permissions");
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            listener.error("Unable to parse project");
            return;
        }

        listener.update(PermissionsFinderLevel.CLEAN2);
        launcher = ProjectLauncher.launch(new String[]{
                Paths.getMavenLocation(),
                "clean"
        }, proj);
        launcher.waitFor();
        if (launcher.exitValue() != 0) {
            listener.error("Unable to clean up project");
            return;
        }

        listener.update(PermissionsFinderLevel.FINISH);
        listener.success(permissions);
    }

    private static Collection<Permissions> convertImportToPermissions(Collection<String> imports) {
        EnumSet<Permissions> perms = EnumSet.noneOf(Permissions.class);
        for (Permissions perm : Permissions.values())
            if (perm.requires(imports))
                perms.add(perm);
        return perms;
    }

}
