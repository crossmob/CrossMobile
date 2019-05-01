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
package org.crossmobile.gui.project;

import com.panayotis.hrgui.HiResIcon;
import com.panayotis.hrgui.ScreenUtils;
import org.crossmobile.gui.elements.NewProjectInfo;
import org.crossmobile.gui.init.InitializationWizard;
import org.crossmobile.gui.init.InitializationWizard.Card;
import org.crossmobile.gui.utils.CMMvnActions;
import org.crossmobile.utils.*;
import org.crossmobile.utils.images.ImageSet;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.crossmobile.prefs.Config.ICONS;
import static org.crossmobile.utils.ParamsCommon.ARTIFACT_ID;
import static org.crossmobile.utils.ParamsCommon.DISPLAY_NAME;

public class ProjectInfo {

    public static final String MAVEN_SIGNATURE = "pom.xml";
    public static final String OLD_ANT = "project.crossmobile";
    public static final String OLD_XMLVM = "xmlvm.properties";
    private final static String INITIAL_VERSION = "1.0.0.0";

    private Icon iconThumb;
    private List<File> iconFiles;
    private String name;
    private final File basedir;

    public static ProjectInfo load(String path) throws ProjectException {
        return new ProjectInfo(path, null);
    }

    public static ProjectInfo create(String path, NewProjectInfo project) throws ProjectException {
        return new ProjectInfo(path, project);
    }

    private static File findProjectDir(String givenPath, boolean baseLevel) throws ProjectException {
        File dir = new File(givenPath);
        if (!dir.exists())
            dir = dir.getParentFile();
        if (!dir.exists())
            throw new ProjectException("Unable to find project location");

        if (dir.isFile())
            dir = dir.getParentFile();
        dir = dir.getAbsoluteFile();
        if (!FileUtils.isWritable(dir))
            throw new ProjectException("Path " + dir.getPath() + " is not writable.");

        if (!new File(dir, MAVEN_SIGNATURE).isFile() && !new File(dir, OLD_XMLVM).isFile() && !new File(dir, OLD_ANT).isFile())
            if (baseLevel && dir.getName().toLowerCase().equals(dir.getParentFile().getName().toLowerCase()))
                dir = findProjectDir(dir.getParent(), false);
            else
                throw new ProjectException("Unrecognized project location", dir);
        return dir;
    }

    private ProjectInfo(String pathname, NewProjectInfo newProjectInfo) throws ProjectException {
        if (pathname == null)
            throw new ProjectException("Invalid path provided");

        if (newProjectInfo != null) {
            File projectDir = new File(pathname);
            if (projectDir.exists())
                throw new ProjectException("Project location already exists");
            projectDir.mkdirs();
            if (!projectDir.isDirectory())
                throw new ProjectException("Unable to create project location");
            InitializationWizard initW = new InitializationWizard(newProjectInfo);
            initW.setMainTitle("Creating project '" + newProjectInfo.getDisplayName() + "'");
            initW.setSubtitle("A new project will be created under: " + pathname);
            initW.goToCard(Card.Info);
            initW.hideActionButton();
            initW.setRunning(true);
            AtomicBoolean fail = new AtomicBoolean(false);
            initW.addWindowListener(new WindowAdapter() {
                @Override
                public void windowOpened(WindowEvent e) {
                    Commander cmd = CMMvnActions.createProject(newProjectInfo.getTemplateType(), newProjectInfo.getDisplayName(), newProjectInfo.getApplicationName(), newProjectInfo.getId(), INITIAL_VERSION, newProjectInfo.getProjectPath());
                    cmd.setCharOutListener(initW.getStreamManager()::incomingOutChar);
                    cmd.setCharErrListener(initW.getStreamManager()::incomingOutChar);
                    cmd.setEndListener(code -> {
                        initW.setRunning(false);
                        if (!code.equals(0)) {
                            initW.setMainTitle("Error while creating project");
                            initW.goToCard(Card.Details);
                            fail.set(true);
                        } else
                            initW.setVisible(false);
                    });
                    cmd.exec();
                }
            });
            initW.setVisible(true);
            if (fail.get())
                throw new ProjectException("Unable to create project");
        }
        this.basedir = findProjectDir(pathname, true);
        refesh(newProjectInfo);
    }

    public void refesh(NewProjectInfo newProjectInfo) {
        Properties props = new Properties();
        if (new File(basedir, MAVEN_SIGNATURE).exists())
            new Pom(new File(basedir, MAVEN_SIGNATURE)).updatePropertiesFromPom(props);
        else
            try {
                props.load(new InputStreamReader(new FileInputStream(new File(basedir, "nbproject" + File.separator + "project.properties")), StandardCharsets.UTF_8));
            } catch (IOException ex) {
            }
        props.computeIfAbsent(ARTIFACT_ID.tag().name, k -> newProjectInfo != null ? newProjectInfo.getApplicationName() : NameConvertor.unicodeToAsciiID(basedir.getAbsolutePath()));
        props.computeIfAbsent(DISPLAY_NAME.tag().name, k -> newProjectInfo != null ? newProjectInfo.getDisplayName() : basedir.getName());
        name = props.get(DISPLAY_NAME.tag().name).toString();

        int multiplier = ScreenUtils.isHiDPI() ? 2 : 1;
        ImageSet imageSet = new ImageSet("/images/logo-icon@2x.png", new File(basedir, ICONS), new File(basedir, "src/main/artwork"));
        iconFiles = imageSet.getImageFiles();
        iconThumb = new HiResIcon(imageSet.find(32 * multiplier, true).image);
    }

    public Icon getIcon() {
        return iconThumb;
    }

    public List<File> getIconFiles() {
        return iconFiles;
    }

    public String getName() {
        return name;
    }

    public File getPath() {
        return basedir;
    }

    public boolean isValid() {
        return new File(basedir, OLD_ANT).isFile() || new File(basedir, OLD_XMLVM).isFile() || new Pom(new File(basedir, MAVEN_SIGNATURE)).isValid();
    }

    @Override
    public int hashCode() {
        return basedir.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final ProjectInfo other = (ProjectInfo) obj;
        return !(this.basedir != other.basedir && (this.basedir == null || !this.basedir.equals(other.basedir)));
    }

}
