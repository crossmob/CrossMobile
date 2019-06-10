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

import org.crossmobile.Version;
import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.gui.codehound.source.FileHit;
import org.crossmobile.gui.codehound.source.SourceParser;
import org.crossmobile.gui.codehound.source.SourcePattern;
import org.crossmobile.gui.codehound.source.SourcePatternFactory;
import org.crossmobile.gui.elements.PrivateArtifactForm;
import org.crossmobile.gui.elements.SendStackTrace;
import org.crossmobile.gui.parameters.DependenciesParameter;
import org.crossmobile.gui.parameters.ProjectParameter;
import org.crossmobile.gui.parameters.ScreenScaleParameter;
import org.crossmobile.gui.parameters.impl.*;
import org.crossmobile.gui.utils.LaunchType;
import org.crossmobile.gui.utils.Paths;
import org.crossmobile.prefs.Prefs;
import org.crossmobile.utils.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import static org.crossmobile.gui.project.ProjectInfo.OLD_ANT;
import static org.crossmobile.gui.project.ProjectInfo.OLD_XMLVM;
import static org.crossmobile.prefs.Config.MATERIALS_PATH;
import static org.crossmobile.utils.ParamsCommon.*;
import static org.crossmobile.utils.TemplateUtils.updateProperties;

public class Project {

    private final File basedir;
    private final ParamList params;
    private final List<PropertySheet> sheets;
    private final List<File> appicons;
    private final boolean asOldCrossmobile;
    ProjectPlugins plugins;
    //private Consumer<String> appNameListener;
    private boolean asOldXMLVMProject;
    private LaunchType launchType;
    private final GlobalParamListener listener = new GlobalParamListener();
    private Consumer<Project> saveCallback;

    @SuppressWarnings("LeakingThisInConstructor")
    public Project(ProjectInfo projinf) throws ProjectException {
        basedir = projinf.getPath();
        params = new ParamList();
        params.updateFromProperties(new File(basedir, OLD_XMLVM));
        params.updateFromProperties(new File(basedir, OLD_ANT));
        params.updateFromProperties(new File(basedir, "nbproject/project.properties"));
        params.updateFromProperties(new File(basedir, "ant.properties"));
        params.updateFromProperties(new File(basedir, "local.properties"));
        boolean correctPom = params.updateFromPom(new File(basedir, "pom.xml"));
        ProjectUpdator.updateOldToNew(params.getProperties());    // just in case... should be last to properly support themes

        asOldXMLVMProject = new File(basedir, OLD_XMLVM).exists();
        asOldCrossmobile = !asOldXMLVMProject && new File(basedir, OLD_ANT).exists();
        if (!correctPom && !asOldCrossmobile)
            throw new ProjectException("Unable to parse POM file");

        launchType = LaunchType.safeValueOf(Prefs.getLaunchType(basedir.getAbsolutePath()));
        plugins = new ProjectPlugins(params);
        appicons = projinf.getIconFiles();

        // Update main class
        SourceParser parser = new SourceParser(basedir.getAbsolutePath() + "/src/main/java");
        parser.setPattern(SourcePatternFactory.getMainClassPattern());
        List<SourcePattern> patterns = parser.parse();
        if (!patterns.isEmpty()) {
            SourcePattern sourcepattern = patterns.get(0);

            Set<String> found = new HashSet<>();
            for (FileHit hit : sourcepattern.getFileHits()) {
                String classname = hit.getClassName();
                if (!classname.startsWith("org.xmlvm.iphone.")
                        && !classname.startsWith("org.crossmobile.backend."))
                    found.add(classname);
            }
            if (found.isEmpty())
                Log.warning("Main class could not be found");
            else {
                String which = found.iterator().next();
                params.put(MAIN_CLASS.tag(), which);
                if (found.size() > 1)
                    Log.warning("More than one main classes found, using " + which);
            }
        }

        Prefs.setCurrentDir(basedir.getParentFile());

        sheets = new ArrayList<>();
        PropertySheet csheet;

        csheet = new PropertySheet("General", listener);
        DisplayNameParameter projname = new DisplayNameParameter(params);
        projname.addParameterListener(property -> listener.updateTitle(property.getValue()));
        listener.updateTitle(projname.getValue());
        csheet.add(projname);
        csheet.add(new ArtifactIdParameter(params));
        csheet.add(new GroupIdParameter(params));
        csheet.add(new VersionParameter(params));
        csheet.add(new MainClassParameter(params));
        ReleaseParameter releaseP = new ReleaseParameter(params, launchType);
        csheet.add(releaseP);
        releaseP.addParameterListener(prop -> Prefs.setLaunchType(basedir.getAbsolutePath(), (launchType = LaunchType.safeValueOf(prop.getValue())).name().toLowerCase()));
        csheet.add(new JavacSourceParameter(params));
        csheet.add(new JavacTargetParameter(params));
        sheets.add(csheet);

        csheet = new PropertySheet("Plugins", listener);
        csheet.add(new DependenciesParameter(params));
        sheets.add(csheet);

        InitialOrientationParameter init_orientation;
        SupportedOrientationsParameter supp_orientation;
        csheet = new PropertySheet("Visuals", listener);
        csheet.add(new StoryboardParameter(params, new File(basedir, MATERIALS_PATH)));
        csheet.add(new LaunchStoryboardParameter(params, new File(basedir, MATERIALS_PATH)));
        csheet.add(new ScreenScaleParameter(params));
        csheet.add(new ProjectTypeParameter(params));
        csheet.add(init_orientation = new InitialOrientationParameter(params));
        csheet.add(supp_orientation = new SupportedOrientationsParameter(params));
        supp_orientation.addParameterListener(p -> init_orientation.check(supp_orientation.getValue()));
        init_orientation.addParameterListener(p -> supp_orientation.setOrientation(p.getValue()));
//        csheet.add(new NibPhoneParameter(params));
//        csheet.add(new NibPadParameter(params));
        csheet.add(new StatusBarHiddenParameter(params));
        csheet.add(new ViewControlledStatusBarParameter(params));
        csheet.add(new SplashDelayParameter(params));
        sheets.add(csheet);

        csheet = new PropertySheet("iOS", listener);
        csheet.add(new InjectedInfoParameter(params));
        csheet.add(new HideIncludesParameter(params));
        csheet.add(new FileSharingParameter(params));
        csheet.add(new SafeMembersParameter(params));
        sheets.add(csheet);

        csheet = new PropertySheet("Android", listener);
        AndroidKeyStoreParameter ks = new AndroidKeyStoreParameter(params);
        csheet.add(ks);
        AndroidKeyAliasParameter ka = new AndroidKeyAliasParameter(params);
        csheet.add(ka);
        ks.addParameterListener(ka);
        csheet.add(new AndroidKeystorePasswordParameter(params));
        csheet.add(new AndroidAliasPasswordParameter(params));
        csheet.add(new AndroidPermissionsParameter(params, this));
        //csheet.add(new AndroidProGuard(params));
        csheet.add(new AndroidSDKParameter(params));
        csheet.add(new AndroidTargetParameter(params));
        csheet.add(new AndroidTargetNumericParameter(params));
        csheet.setBottomPanel(PrivateArtifactForm.getPanel());
        sheets.add(csheet);

        csheet = new PropertySheet("Desktop", listener);
//        csheet.add(new DesktopFrameworkParameter(params));
        csheet.add(new SkinListParameter(params));
        csheet.add(new KeyboardSupportParameter(params));
        csheet.setBottomPanel(SendStackTrace.getPanel());
        sheets.add(csheet);
    }

    public void setApplicationNameListener(Consumer<String> listener) {
        this.listener.setApplicationNameListener(listener);
    }

    public String getName() {
        return params.get(DISPLAY_NAME.tag());
    }

    public String getArtifactID() {
        return params.get(ARTIFACT_ID.tag());
    }

    public String getMainClass() {
        return params.get(MAIN_CLASS.tag());
    }

    public String getClasspath(boolean withPlugins) {
        StringBuilder out = new StringBuilder();
        if (withPlugins) {
            out.append(plugins.getAbsolutePaths());
            if (out.length() > 0)
                out.append(File.pathSeparator);
        }
        out.append(Paths.getAbsolutePath(new File("target" + File.separator + "classes"), basedir));
        return out.toString();
    }

    public File getPath() {
        return basedir;
    }

    public File getPom() {
        return new File(basedir, "pom.xml");
    }

    public List<File> getIconFiles() {
        return appicons;
    }

    public boolean isSaved() {
        return !listener.isDirty();
    }

    public void save() throws ProjectException {
        try {
            for (PropertySheet sheet : sheets)
                for (ProjectParameter prop : sheet.getProperties())
                    prop.updatePropertyList();

            if (asOldXMLVMProject || asOldCrossmobile) {
                OldSourceParser.updateSources(basedir, new File(basedir, params.dereferenceProperty("src.java.dir")), asOldCrossmobile ? "CrossMobile" : "XMLVM");
                asOldXMLVMProject = false;
            }
            ProjectUpdator.update(basedir, params);

            // Update project properties
            Pom updatedPom = new Pom(new File(basedir, "pom.xml")).updatePomFromProperties(params.getParamset(), params.getProperties());
            updatedPom.setParentProject(Version.VERSION);
            updatedPom.save();
            updateProperties("local.properties", new File(basedir, "local.properties"), params, null);
            listener.updateDefaults();
            Nullable.safeCall(saveCallback, s -> s.accept(this));
        } catch (Throwable th) {
            if (th instanceof ProjectException)
                BaseUtils.throwException(th);
            else
                throw new ProjectException(th);
        }
    }

    public void setSaveCallback(Consumer<Project> callback) {
        this.saveCallback = callback;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Project other = (Project) obj;
        return this.basedir == other.basedir || (this.basedir != null && Paths.getPath(basedir, null).equals(Paths.getPath(other.basedir, null)));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (this.basedir != null ? this.basedir.getAbsolutePath().hashCode() : 0);
        return hash;
    }

    public Iterable<PropertySheet> getSheets() {
        return sheets;
    }

    public LaunchType getLaunchType() {
        return launchType;
    }

}
