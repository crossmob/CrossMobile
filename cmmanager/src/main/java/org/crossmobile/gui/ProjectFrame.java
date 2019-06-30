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
package org.crossmobile.gui;

import com.panayotis.appenh.EnhancerManager;
import com.panayotis.hrgui.*;
import org.crossmobile.gui.actives.*;
import org.crossmobile.gui.elements.*;
import org.crossmobile.gui.parameters.ProjectParameter;
import org.crossmobile.gui.project.Project;
import org.crossmobile.gui.project.ProjectLoader;
import org.crossmobile.gui.project.PropertySheet;
import org.crossmobile.gui.utils.*;
import org.crossmobile.prefs.Prefs;
import org.crossmobile.utils.*;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

import static org.crossmobile.gui.actives.ActiveContextLabel.Context.*;
import static org.crossmobile.gui.elements.DebugInfo.streamsHaveTraces;
import static org.crossmobile.gui.utils.LaunchType.RELEASE;
import static org.crossmobile.prefs.Prefs.*;

public final class ProjectFrame extends RegisteredFrame implements DebugInfo.Consumer {

    private static final int KILL_RESULT = 143;
    private static final int NOT_SAVED = 144;

    private static final HiResIcon RUN_I = new ActiveIcon("images/run");
    private static final HiResIcon EXPAND_I = new ActiveIcon("images/expand");
    private static final HiResIcon BUILD_I = new ActiveIcon("images/build");
    private static final HiResIcon STOP_I = new ActiveIcon("images/stop");
    private static final HiResIcon STOP_D = STOP_I.getDisabledIcon();
    private static final HiResIcon SAVE_I = new ActiveIcon("images/save");
    private static final HiResIcon SAVE_TI = new ActiveIcon("images/saveT");
    private static final HiResIcon CLEAN_I = new ActiveIcon("images/clean");
    private static final HiResIcon CLEANPROJ_I = new ActiveIcon("images/cleanproj");
    private static final HiResIcon CLEAN_TI = new ActiveIcon("images/cleanT");
    private static final HiResIcon OPEN_I = new ActiveIcon("images/open");
    private static final HiResIcon DESKTOP_I = new ActiveIcon("images/desktop_small");
    private static final HiResIcon NETBEANS_I = new ActiveIcon("images/netbeans");
    private static final HiResIcon NETBEANS_D = NETBEANS_I.getDisabledIcon();
    private static final HiResIcon STUDIO_I = new ActiveIcon("images/studio");
    private static final HiResIcon STUDIO_D = STUDIO_I.getDisabledIcon();
    private static final HiResIcon INTELLIJ_I = new ActiveIcon("images/intellij");
    private static final HiResIcon INTELLIJ_D = INTELLIJ_I.getDisabledIcon();
    private static final HiResIcon XCODE_I = new ActiveIcon("images/xcode");
    private static final HiResIcon XCODE_D = XCODE_I.getDisabledIcon();
    private static final HiResIcon VSTUDIO_I = new ActiveIcon("images/vstudio");
    private static final HiResIcon VSTUDIO_D = VSTUDIO_I.getDisabledIcon();
    private static final HiResIcon JAR_I = new ActiveIcon("images/jar");
    private static final HiResIcon JAR_D = JAR_I.getDisabledIcon();
    private static final HiResIcon APK_I = new ActiveIcon("images/apk");
    private static final HiResIcon APK_D = APK_I.getDisabledIcon();
    private static final HiResIcon PROJECT_I = new ActiveIcon("images/project");
    private static final HiResIcon PROJECT_D = PROJECT_I.getDisabledIcon();
    private static final HiResIcon OUTPUT_I = new ActiveIcon("images/output");
    private static final HiResIcon OUTPUT_D = OUTPUT_I.getDisabledIcon();
    private static final HiResIcon STDERR_I = new ActiveIcon("images/stderr");
    private static final HiResIcon STDOUT_I = new ActiveIcon("images/stdout");

    private Project proj;
    private final Collection<JComponent> autoDisabled = new ArrayList<>();
    private boolean isProjectEnabled = false;
    private Consumer<Project> closeCallback;
    private Commander launch;
    private String taskName = null;
    private final AtomicReference<Runnable> solutionCallbackRef = new AtomicReference<>();
    private boolean currentlyShowsOutput = true;
    private ActiveButton magicWandB;
    private final Consumer<Integer> launchCallback = new Consumer<Integer>() {
        @Override
        public void accept(Integer result) {
            setLaunchButtonStatus(result, null);
            launch = null;
        }
    };

    @SuppressWarnings("LeakingThisInConstructor")
    public ProjectFrame(File path) {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Loading project " + path.getName() + "...");
        autoDisabled.add(iosT);
        autoDisabled.add(androidT);
        autoDisabled.add(desktopT);
        autoDisabled.add(uwpT);
        autoDisabled.add(cleanB);
        autoDisabled.add(expandCB);
        autoDisabled.add(expandRB);
        autoDisabled.add(projectB);
        autoDisabled.add(expandPB);
        magicWandB = Deguard.getWandButton(this);
        actionB.setEnabled(false);
        setProjectEnabled(false);
    }

    public void setCloseCallback(Consumer<Project> callBack) {
        this.closeCallback = callBack;
    }

    public void initVisuals(Project p) {
        proj = p;
        setTitle(proj.getName());
        getRootPane().putClientProperty("Window.documentFile", p.getPath());
        EnhancerManager.getDefault().updateFrameIcons(this, p.getIconFiles());
        if (!SystemDependent.canMakeUwp())
            vstudioM.setVisible(false);
        if (!SystemDependent.canMakeIos())
            xcodeM.setVisible(false);
        rightPanel.add(leftButtonPanel, BorderLayout.NORTH);
        ButtonGroup group = new ButtonGroup();
        ActionListener listener = (ActionEvent e) -> ((CardLayout) parameters.getLayout()).show(parameters, e.getActionCommand());
        for (PropertySheet sheet : proj.getSheets()) {
            HiResPanel boxed = new HiResPanel();
            boxed.setOpaque(false);
            boxed.setLayout(new BoxLayout(boxed, BoxLayout.Y_AXIS));
            for (ProjectParameter prop : sheet.getProperties()) {
                HiResComponent item = prop.getVisuals();
                if (item != null) {
                    HiResPanel cp = new HiResPanel(new BorderLayout());
                    cp.setOpaque(false);
                    cp.add(item.comp(), BorderLayout.CENTER);
                    boxed.add(cp);
                    cp.setBorder(new CompoundBorder(new HiResMatteBorder(0, 0, 1, 0, Theme.current().line), new HiResEmptyBorder(4, 0, 4, 0)));
                }
            }
            sheet.alignVisuals();
            boxed.setBorder(new HiResEmptyBorder(8, 8, 8, 8));

            HiResPanel overall = new GradientPanel();
            overall.setLayout(new BorderLayout());
            overall.add(boxed, BorderLayout.NORTH);
            HiResScrollPane scroll = new HiResScrollPane();
            scroll.setViewportView(overall);

            String sheetName = sheet.getName();
            ActivePanel bottomPanel = sheet.getBottomPanel();
            JComponent sheetVisuals;
            if (bottomPanel == null)
                sheetVisuals = scroll;
            else {
                if (bottomPanel instanceof BottomPanel)
                    ((BottomPanel) bottomPanel).setProjectFrame(this);
                ActivePanel container = new ActivePanel(new BorderLayout());
                container.add(scroll, BorderLayout.CENTER);
                container.add(bottomPanel, BorderLayout.SOUTH);
                scroll.setBorder(null);
                sheetVisuals = container;
            }
            parameters.add(sheetVisuals, sheetName);
            sheetVisuals.setBorder(new ActiveEtchedBorder());

            ActiveToggleButton button = new ActiveToggleButton(sheetName, new ActiveIcon("images/" + sheetName.toLowerCase()));
            button.setVerticalTextPosition(SwingConstants.BOTTOM);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setIconTextGap(0);
            button.setActionCommand(sheetName);
            button.addActionListener(listener);
            group.add(button);
            if (group.getButtonCount() == 1)
                button.setSelected(true);
            leftButtonPanel.add(button);
        }
        actionB.setActionCommand(Prefs.getSelectedLaunchAction(proj.getPath().getAbsolutePath()));
        updateLaunchVisuals();
        switch (Prefs.getSelectedLaunchTarget(proj.getPath().getAbsolutePath())) {
            case LAUNCH_TARGET_ANDROID:
                androidT.setSelected(true);
                break;
            case LAUNCH_TARGET_IOS:
                iosT.setSelected(true);
                break;
            case LAUNCH_TARGET_UWP:
                uwpT.setSelected(true);
                break;
            default:
            case LAUNCH_TARGET_DESKTOP:
                desktopT.setSelected(true);
                break;
        }
        actionB.setEnabled(true);
        setProjectEnabled(true);
        validate();
    }

    public DebugInfo getDebugInfo() {
        return new DebugInfo(outputTxt.getText(), errorTxt.getText(), proj.getArtifactID());
    }

    @Override
    public void updateTo(String outStream, String errorStream) {
        ((ActiveTextPane) outputTxt).setText(outStream, StreamQuality.INFO);
        ((ActiveTextPane) errorTxt).setText(errorStream, StreamQuality.INFO);
    }

    private void displayOutput() {
        ((CardLayout) contentP.getLayout()).show(contentP, "output");
        outputB.setSelected(true);
    }

    private void displayProject() {
        ((CardLayout) contentP.getLayout()).show(contentP, "project");
        projectB.setSelected(true);
    }

    private void setProjectEnabled(boolean status) {
        isProjectEnabled = status;
        for (JComponent button : autoDisabled)
            button.setEnabled(status);
    }

    private synchronized void setLaunchButtonStatus(Integer result, String currentTaskName) {
        Nullable.safeCall(solutionCallbackRef.get(), r -> {
            solutionCallbackRef.set(null);
            SwingUtilities.invokeLater(r);
        });

        // treat specifically kill callback: already registered so ignore
        if (result != null && result == KILL_RESULT && currentTaskName == null && taskName == null)
            return;

        boolean shouldShowSendTrace = false;
        boolean running;
        if (result != null) {
            boolean success = result == 0;
            boolean wasKilled = result == KILL_RESULT;
            boolean notSaved = result == NOT_SAVED;
            shouldShowSendTrace = !success && !wasKilled && streamsHaveTraces(outputTxt.getText(), errorTxt.getText());
            String oldTaskName = taskName;
            String tn = oldTaskName == null ? "Operation" : oldTaskName;
            tn += " : " + (success ? "success" : (wasKilled ? "interrupted" : (notSaved ? "not saved" : "failed, error code " + result)));
            outResult.setText(tn);
            ((ActiveContextLabel) outResult).setContext(success ? SUCCESS : (wasKilled ? ActiveContextLabel.Context.ERROR : WARNING));
            outputB.setText(success ? "Output" : "Output*");
            if (success || wasKilled || notSaved)
                displayProject();
            running = false;
            currentTaskName = null;
        } else {
            displayOutput();
            outputB.setText("Output");
            outResult.setText(currentTaskName);
            ((ActiveContextLabel) outResult).setContext(RUNNING);
            running = true;
        }

        setProjectEnabled(!running);
        updateToolButtons(shouldShowSendTrace, !running);
        actionB.setText(running ? "Stop" : "Start");
        actionB.setIcon(running ? STOP_I : RUN_I);
        outputB.setEnabled(true);
        expandOB.setEnabled(outputB.isEnabled());
        if (!running)
            updateLaunchVisuals();

        taskName = currentTaskName;
    }

    private void updateToolButtons(boolean shouldShowSendTrace, boolean couldShowMagicWand) {
        inoutP.removeAll();
        if (couldShowMagicWand && magicWandB != null)
            inoutP.add(magicWandB);
        if (shouldShowSendTrace && false)
            inoutP.add(SendStackTrace.getButton(this));
        inoutP.add(outputTB);
        inoutP.add(errorTB);
        inoutP.validate();
    }

    private void updateLaunchVisuals() {
        actionB.setText(TextUtils.capitalize(actionB.getActionCommand()));
        switch (actionB.getActionCommand()) {
            case LAUNCH_ACTION_BUILD:
                actionB.setIcon(BUILD_I);
                break;
            default:
            case LAUNCH_ACTION_RUN:
                actionB.setIcon(RUN_I);
        }
        Prefs.setSelectedLaunchAction(proj.getPath().getAbsolutePath(), actionB.getActionCommand());
    }

    private boolean saveProjectWithErrorMessage() {
        try {
            proj.save();
            return true;
        } catch (ProjectException ex) {
            Log.error("Unable to update project", ex);
            return false;
        }
    }

    @Override
    public void setVisible(boolean visible) {
        if (!visible)
            ProjectLoader.unregisterProject(this);
        super.setVisible(visible);
    }

    private void saveOutPut() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = chooser.showSaveDialog(this);
        System.out.println(chooser.getSelectedFile() + " " + result);
        if (result == 0)
            try (Writer writer = new OutputStreamWriter(new FileOutputStream(chooser.getSelectedFile()), SystemDependent.getEncoding())) {
                String text = currentlyShowsOutput ? outputTxt.getText() : errorTxt.getText();
                writer.write(text);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                        "Something went terribly wrong. :(  \n",
                        "Save Error",
                        JOptionPane.ERROR_MESSAGE);
            }
    }

    private String getCurrentTarget() {
        return targetG.getSelection().getActionCommand();
    }

    private ActiveTextPane initLaunchVisualsOut(String consoleText, String infoText) {
        setLaunchButtonStatus(null, infoText);
        ActiveTextPane out = (ActiveTextPane) outputTxt;
        out.setText("");
        if (!consoleText.isEmpty())
            out.addLine("\n" + consoleText + "\n", StreamQuality.INFO);
        errorTxt.setText("");
        showOutputView(true);
        outputTB.setText("Out");
        return out;
    }

    private ActiveTextPane initLaunchVisualsErr() {
        ActiveTextPane err = (ActiveTextPane) errorTxt;
        errorTxt.setText("");
        errorTB.setText("Error");
        return err;
    }

    private void buildAndRun() {
        if (taskName != null)
            EventUtils.postAction(() -> {
                Nullable.safeCall(launch, Commander::kill);
                setLaunchButtonStatus(KILL_RESULT, null);
            });
        else {
            String target = getCurrentTarget();
            ActiveTextPane outP = initLaunchVisualsOut("Launch " + target + " target", "Building product");
            EventUtils.postAction(() -> {
                if (saveProjectWithErrorMessage())
                    launch = execInConsole("install",
                            target
                                    + (LAUNCH_ACTION_BUILD.equals(actionB.getActionCommand()) ? "" : ",run")
                                    + (proj.getLaunchType() == RELEASE ? ",release" : ""),
                            proj, outP, initLaunchVisualsErr(), launchCallback);
                else
                    setLaunchButtonStatus(NOT_SAVED, "Unable to save project");
            });
        }
    }

    private void openTarget(String target) {
        String info = "Request to launch project in " + target;
        ActiveTextPane outP = initLaunchVisualsOut(info, "Open project in " + target);
        String preproc = OPEN_STUDIO.equals(target) ? LAUNCH_TARGET_ANDROID : (OPEN_XCODE.equals(target) ? LAUNCH_TARGET_IOS : (OPEN_VSTUDIO.equals(target) ? LAUNCH_TARGET_UWP : null));
        if (preproc != null)
            launch = execInConsole("process-classes", preproc, proj, outP, initLaunchVisualsErr(), result -> {
                if (result == 0)
                    postProcessCode(outP, "", target, outP);
                else
                    launchCallback.accept(result);
            });
        else
            postProcessCode(outP, info, target, outP);
    }

    public void installPrivateArtifact(String signature) {
        ActiveTextPane outP = initLaunchVisualsOut("Retrieving artifact " + signature, "Retrieve and convert AAR artifact");
        launch = execInConsole("org.apache.maven.plugins:maven-dependency-plugin:3.1.1:get", null, proj,
                outP, initLaunchVisualsErr(), result -> {
                    if (result == 0)
                        ExternalCommands.convertAARtoJAR(signature);
                    else
                        launchCallback.accept(result);
                }, "-Dartifact=" + signature, "-Dtransitive=false");
    }

    private void postProcessCode(ActiveTextPane txtPane, String info, String ide, ActiveTextPane out) {
        if (!info.isEmpty())
            txtPane.addLine("\n" + info + "\n", StreamQuality.INFO);
        ExternalCommands.openCode(ide, proj, out, launchCallback);
    }

    private Commander execInConsole(String goal, String profiles, Project proj, ActiveTextPane outP, ActiveTextPane errP, Consumer<Integer> launchCallback, String... params) {
        if (profiles != null && profiles.contains("uwp"))
            outP.addLine(" *** WARNING *** Universal Windows Platform support  is still in alpha stage\n", StreamQuality.ERROR);
        return CMMvnActions.callMaven(goal, profiles, proj.getPath(), outP, errP, launchCallback, solutionCallbackRef, proj.getLaunchType(),
                (l, q) -> outputTB.setText("Out*"), (l, q) -> errorTB.setText("Error*"), params);
    }

    private File getApkPath(boolean preferRelease) {
        File release_new = new File(proj.getPath(), "target/app/build/outputs/apk/release/" + proj.getPath().getName() + "-release.apk");
        File release_old = new File(proj.getPath(), "target/app/build/outputs/apk/" + proj.getPath().getName() + "-release.apk");
        File debug_new = new File(proj.getPath(), "target/app/build/outputs/apk/debug/" + proj.getPath().getName() + "-debug.apk");
        File debug_old = new File(proj.getPath(), "target/app/build/outputs/apk/" + proj.getPath().getName() + "-debug.apk");
        File pref1, pref2, pref3, pref4;
        if (preferRelease) {
            pref1 = release_new;
            pref2 = release_old;
            pref3 = debug_new;
            pref4 = debug_old;
        } else {
            pref1 = debug_new;
            pref2 = debug_old;
            pref3 = release_new;
            pref4 = release_old;
        }
        if (pref1.isFile())
            return pref1;
        else if (pref2.isFile())
            return pref2;
        else if (pref3.isFile())
            return pref3;
        else if (pref4.isFile())
            return pref4;
        else
            return null;
    }

    private File getJarPath() {
        File path = new File(proj.getPath(), "target" + File.separator + proj.getArtifactID() + "-desktop.jar");
        return path.exists() ? path : null;
    }

    private void showOutputView(boolean asOutput) {
        if (asOutput == currentlyShowsOutput) {
            if (asOutput)
                outputTB.setText("Out");
            else
                errorTB.setText("Error");
            return;
        }

        // Also clear other button
        outputTB.setText("Out");
        errorTB.setText("Error");

        currentlyShowsOutput = asOutput;
        ((CardLayout) outerrorP.getLayout()).show(outerrorP, asOutput ? "out" : "error");
        if (asOutput)
            outputTB.setSelected(true);
        else
            errorTB.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        targetG = new javax.swing.ButtonGroup();
        projectG = new javax.swing.ButtonGroup();
        outputG = new javax.swing.ButtonGroup();
        actionsM = new ActivePopupMenu();
        runM = new ActiveMenuItem();
        buildM = new ActiveMenuItem();
        projectM = new ActivePopupMenu();
        savePM = new ActiveMenuItem();
        outputM = new ActivePopupMenu();
        cleanOM = new ActiveMenuItem();
        saveOM = new ActiveMenuItem();
        openM = new ActivePopupMenu();
        intellijM = new ActiveMenuItem();
        netbeansM = new ActiveMenuItem();
        jSeparator3 = new ActiveMenuSeparator();
        desktopM = new ActiveMenuItem();
        jarM = new ActiveMenuItem();
        apkM = new ActiveMenuItem();
        jSeparator1 = new ActiveMenuSeparator();
        studioM = new ActiveMenuItem();
        xcodeM = new ActiveMenuItem();
        vstudioM = new ActiveMenuItem();
        cleanM = new ActivePopupMenu();
        cleanAllPM = new ActiveMenuItem();
        Background = new GradientPanel();
        controlP = new javax.swing.JPanel();
        controlP_R = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        projectB = new ActiveToggleButton("", null);
        expandPB = new ActiveButton();
        jPanel1 = new javax.swing.JPanel();
        outputB = new ActiveToggleButton("", null);
        expandOB = new ActiveButton();
        jLabel1 = new ActiveLabel();
        openB = new ActiveButton();
        controlP_L = new javax.swing.JPanel();
        targetP = new javax.swing.JPanel();
        iosT = new ActiveToggleButton("", new ActiveIcon("images/ios_small"));
        androidT = new ActiveToggleButton("", new ActiveIcon("images/android_small"));
        uwpT = new ActiveToggleButton("", new ActiveIcon("images/uwp_small"));
        desktopT = new ActiveToggleButton("", new ActiveIcon("images/desktop_small"));
        commandP = new javax.swing.JPanel();
        expandRB = new ActiveButton();
        actionB = new ActiveButton();
        jPanel3 = new javax.swing.JPanel();
        expandCB = new ActiveButton();
        cleanB = new ActiveButton();
        contentP = new HiResPanel();
        projectP = new HiResPanel();
        parameters = new GradientPanel();
        rightPanel = new javax.swing.JPanel();
        leftButtonPanel = new javax.swing.JPanel();
        javax.swing.JPanel outputP = new HiResPanel();
        outerrorP = new javax.swing.JPanel();
        scrollOutP = new javax.swing.JScrollPane();
        outputTxt = new ActiveTextPane();
        scrollErrP = new javax.swing.JScrollPane();
        errorTxt = new ActiveTextPane();
        infoP = new HiResPanel();
        outResult = new ActiveContextLabel();
        inoutP = new HiResPanel();
        outputTB = new ActiveToggleButton("", STDOUT_I, 8);
        errorTB = new ActiveToggleButton("", STDERR_I, 8);

        runM.setIcon(RUN_I);
        runM.setText("Run");
        runM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runMActionPerformed(evt);
            }
        });
        actionsM.add(runM);

        buildM.setIcon(BUILD_I);
        buildM.setText("Build");
        buildM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buildMActionPerformed(evt);
            }
        });
        actionsM.add(buildM);

        savePM.setIcon(SAVE_I);
        savePM.setText("Save");
        savePM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePMActionPerformed(evt);
            }
        });
        projectM.add(savePM);

        cleanOM.setIcon(CLEAN_TI);
        cleanOM.setText("Clean");
        cleanOM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanOMActionPerformed(evt);
            }
        });
        outputM.add(cleanOM);

        saveOM.setIcon(SAVE_TI);
        saveOM.setText("Save");
        saveOM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveOMActionPerformed(evt);
            }
        });
        outputM.add(saveOM);

        intellijM.setIcon(INTELLIJ_I);
        intellijM.setText(" in IntelliJ IDEA");
        intellijM.setActionCommand(OPEN_INTELLIJ);
        intellijM.setDisabledIcon(INTELLIJ_D);
        intellijM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openCommand(evt);
            }
        });
        openM.add(intellijM);

        netbeansM.setIcon(NETBEANS_I);
        netbeansM.setText(" in Netbeans");
        netbeansM.setActionCommand(OPEN_NETBEANS);
        netbeansM.setDisabledIcon(NETBEANS_D);
        netbeansM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openCommand(evt);
            }
        });
        openM.add(netbeansM);
        openM.add(jSeparator3);

        desktopM.setIcon(DESKTOP_I);
        desktopM.setText(" in Desktop");
        desktopM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desktopMActionPerformed(evt);
            }
        });
        openM.add(desktopM);

        jarM.setIcon(JAR_I);
        jarM.setText(" as Desktop JAR");
        jarM.setDisabledIcon(JAR_D);
        jarM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarMshowIDE(evt);
            }
        });
        openM.add(jarM);

        apkM.setIcon(APK_I);
        apkM.setText(" as Android APK");
        apkM.setDisabledIcon(APK_D);
        apkM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apkMshowIDE(evt);
            }
        });
        openM.add(apkM);
        openM.add(jSeparator1);

        studioM.setIcon(STUDIO_I);
        studioM.setText(" in Android Studio");
        studioM.setActionCommand(OPEN_STUDIO);
        studioM.setDisabledIcon(STUDIO_D);
        studioM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openCommand(evt);
            }
        });
        openM.add(studioM);

        xcodeM.setIcon(XCODE_I);
        xcodeM.setText(" in Xcode");
        xcodeM.setActionCommand(OPEN_XCODE);
        xcodeM.setDisabledIcon(XCODE_D);
        xcodeM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openCommand(evt);
            }
        });
        openM.add(xcodeM);

        vstudioM.setIcon(VSTUDIO_I);
        vstudioM.setText(" in Visual Studio");
        vstudioM.setActionCommand(OPEN_VSTUDIO);
        vstudioM.setDisabledIcon(VSTUDIO_D);
        vstudioM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openCommand(evt);
            }
        });
        openM.add(vstudioM);

        cleanAllPM.setIcon(CLEANPROJ_I);
        cleanAllPM.setText("Clean Project files");
        cleanAllPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanAllPMActionPerformed(evt);
            }
        });
        cleanM.add(cleanAllPM);

        setMinimumSize(new java.awt.Dimension(800, 620));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Background.setLayout(new java.awt.BorderLayout());

        controlP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, java.awt.Color.gray));
        controlP.setOpaque(false);
        controlP.setLayout(new java.awt.BorderLayout());

        controlP_R.setOpaque(false);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        projectG.add(projectB);
        projectB.setIcon(PROJECT_I);
        projectB.setSelected(true);
        projectB.setText("Project");
        projectB.setActionCommand(LAUNCH_TARGET_IOS);
        projectB.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 0, 8, 8));
        projectB.setDisabledIcon(PROJECT_D);
        projectB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectBtargetSelection(evt);
            }
        });
        jPanel2.add(projectB, java.awt.BorderLayout.CENTER);

        expandPB.setIcon(EXPAND_I);
        expandPB.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 24, 8, 2));
        expandPB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                expandPBMousePressed(evt);
            }
        });
        jPanel2.add(expandPB, java.awt.BorderLayout.WEST);

        controlP_R.add(jPanel2);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        projectG.add(outputB);
        outputB.setIcon(OUTPUT_I);
        outputB.setText("Output");
        outputB.setActionCommand(LAUNCH_TARGET_IOS);
        outputB.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 0, 8, 8));
        outputB.setDisabledIcon(OUTPUT_D);
        outputB.setEnabled(false);
        outputB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputBtargetSelection(evt);
            }
        });
        jPanel1.add(outputB, java.awt.BorderLayout.CENTER);

        expandOB.setIcon(EXPAND_I);
        expandOB.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 24, 8, 2));
        expandOB.setEnabled(false);
        expandOB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                expandOBMousePressed(evt);
            }
        });
        jPanel1.add(expandOB, java.awt.BorderLayout.WEST);

        controlP_R.add(jPanel1);

        jLabel1.setText("     ");
        controlP_R.add(jLabel1);

        openB.setIcon(OPEN_I);
        openB.setText("Open");
        openB.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 12, 8, 8));
        openB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                openBMousePressed(evt);
            }
        });
        controlP_R.add(openB);

        controlP.add(controlP_R, java.awt.BorderLayout.EAST);

        controlP_L.setToolTipText("");
        controlP_L.setOpaque(false);

        targetP.setOpaque(false);
        targetP.setLayout(new java.awt.GridLayout(1, 0));

        targetG.add(iosT);
        iosT.setToolTipText("iOS Project");
        iosT.setActionCommand(LAUNCH_TARGET_IOS);
        iosT.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        iosT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                targetSelection(evt);
            }
        });
        targetP.add(iosT);

        targetG.add(androidT);
        androidT.setToolTipText("Android Project");
        androidT.setActionCommand(LAUNCH_TARGET_ANDROID);
        androidT.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        androidT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                targetSelection(evt);
            }
        });
        targetP.add(androidT);

        targetG.add(uwpT);
        uwpT.setToolTipText("Windows Universal Platform Project");
        uwpT.setActionCommand(LAUNCH_TARGET_UWP);
        uwpT.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        uwpT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                targetSelection(evt);
            }
        });
        targetP.add(uwpT);

        targetG.add(desktopT);
        desktopT.setToolTipText("Desktop Project");
        desktopT.setActionCommand(LAUNCH_TARGET_DESKTOP);
        desktopT.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        desktopT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                targetSelection(evt);
            }
        });
        targetP.add(desktopT);

        controlP_L.add(targetP);

        commandP.setOpaque(false);
        commandP.setLayout(new java.awt.BorderLayout());

        expandRB.setIcon(EXPAND_I);
        expandRB.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 24, 8, 2));
        expandRB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                expandRBMousePressed(evt);
            }
        });
        commandP.add(expandRB, java.awt.BorderLayout.WEST);

        actionB.setIcon(RUN_I);
        actionB.setText("Run");
        actionB.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 0, 8, 8));
        actionB.setDisabledIcon(STOP_D);
        actionB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actOnProject(evt);
            }
        });
        commandP.add(actionB, java.awt.BorderLayout.CENTER);

        controlP_L.add(commandP);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.BorderLayout());

        expandCB.setIcon(EXPAND_I);
        expandCB.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 24, 8, 2));
        expandCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                expandCBMousePressed(evt);
            }
        });
        jPanel3.add(expandCB, java.awt.BorderLayout.WEST);

        cleanB.setIcon(CLEAN_I);
        cleanB.setText("Clean");
        cleanB.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 0, 8, 8));
        cleanB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanBactOnProject(evt);
            }
        });
        jPanel3.add(cleanB, java.awt.BorderLayout.CENTER);

        controlP_L.add(jPanel3);

        controlP.add(controlP_L, java.awt.BorderLayout.WEST);

        Background.add(controlP, java.awt.BorderLayout.NORTH);

        contentP.setOpaque(false);
        contentP.setLayout(new java.awt.CardLayout());

        projectP.setOpaque(false);
        projectP.setLayout(new java.awt.BorderLayout());

        parameters.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, java.awt.Color.lightGray));
        parameters.setOpaque(false);
        parameters.setLayout(new java.awt.CardLayout());
        projectP.add(parameters, java.awt.BorderLayout.CENTER);

        rightPanel.setOpaque(false);
        rightPanel.setLayout(new java.awt.BorderLayout());

        leftButtonPanel.setOpaque(false);
        leftButtonPanel.setLayout(new java.awt.GridLayout(0, 1));
        rightPanel.add(leftButtonPanel, java.awt.BorderLayout.CENTER);

        projectP.add(rightPanel, java.awt.BorderLayout.EAST);

        contentP.add(projectP, "project");

        outputP.setOpaque(false);
        outputP.setLayout(new java.awt.BorderLayout());

        outerrorP.setLayout(new java.awt.CardLayout());

        scrollOutP.setName("out"); // NOI18N

        outputTxt.setEditable(false);
        scrollOutP.setViewportView(outputTxt);

        outerrorP.add(scrollOutP, "out");

        scrollErrP.setName("error"); // NOI18N

        errorTxt.setEditable(false);
        scrollErrP.setViewportView(errorTxt);

        outerrorP.add(scrollErrP, "error");

        outputP.add(outerrorP, java.awt.BorderLayout.CENTER);

        infoP.setOpaque(false);
        infoP.setLayout(new java.awt.BorderLayout());

        outResult.setBorder(new com.panayotis.hrgui.HiResEmptyBorder(4, 8, 4, 0));
        outResult.setOpaque(true);
        infoP.add(outResult, java.awt.BorderLayout.CENTER);

        inoutP.setOpaque(false);
        inoutP.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 2, 0));

        outputG.add(outputTB);
        outputTB.setSelected(true);
        outputTB.setText("Out");
        outputTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputTBActionPerformed(evt);
            }
        });
        inoutP.add(outputTB);

        outputG.add(errorTB);
        errorTB.setText("Error");
        errorTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                errorTBActionPerformed(evt);
            }
        });
        inoutP.add(errorTB);

        infoP.add(inoutP, java.awt.BorderLayout.EAST);

        outputP.add(infoP, java.awt.BorderLayout.SOUTH);

        contentP.add(outputP, "output");

        Background.add(contentP, java.awt.BorderLayout.CENTER);

        getContentPane().add(Background, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actOnProject(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actOnProject
        buildAndRun();
    }//GEN-LAST:event_actOnProject

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            if (proj != null) {
                if (!proj.isSaved() && JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "Poject " + proj.getName() + " is not saved.\nDo you want to save it before proceeding?",
                        proj.getName() + " Project",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE))
                    try {
                        proj.save();
                    } catch (ProjectException ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Poject " + proj.getName() + " error", JOptionPane.ERROR_MESSAGE);
                    }
                Nullable.safeCall(launch, l -> l.kill());
                Nullable.safeCall(closeCallback, c -> c.accept(proj));
            }
            closeCallback = null;
        } catch (Throwable th) {
            String projectName = proj == null ? "" : " for project " + proj.getName();
            Log.error("A serious runtime error has occurred" + projectName, th);
        }
    }//GEN-LAST:event_formWindowClosing

    private void buildMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buildMActionPerformed
        actionB.setActionCommand(LAUNCH_ACTION_BUILD);
        updateLaunchVisuals();
        buildAndRun();
    }//GEN-LAST:event_buildMActionPerformed

    private void runMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runMActionPerformed
        actionB.setActionCommand(LAUNCH_ACTION_RUN);
        updateLaunchVisuals();
        buildAndRun();
    }//GEN-LAST:event_runMActionPerformed

    private void targetSelection(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_targetSelection
        Prefs.setSelectedLaunchTarget(proj.getPath().getAbsolutePath(), evt.getActionCommand());
    }//GEN-LAST:event_targetSelection

    private void expandRBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expandRBMousePressed
        if (expandRB.isEnabled())
            actionsM.show(expandRB, 0, expandRB.getHeight());
    }//GEN-LAST:event_expandRBMousePressed

    private void openBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openBMousePressed
        if (openB.isEnabled()) {
            netbeansM.setEnabled(!Prefs.getNetbeansLocation().isEmpty());
            intellijM.setEnabled(!Prefs.getIntelliJLocation().isEmpty());
            studioM.setEnabled(isProjectEnabled && !Prefs.getAndroidStudioLocation().isEmpty());
            vstudioM.setEnabled(isProjectEnabled && !Prefs.getVisualStudioLocation().isEmpty());
            xcodeM.setEnabled(isProjectEnabled && SystemDependent.canMakeIos());
            apkM.setEnabled(getApkPath(proj.getLaunchType() == RELEASE) != null);
            jarM.setEnabled(getJarPath() != null);
            openM.show(openB, 0, openB.getHeight());
        }
    }//GEN-LAST:event_openBMousePressed

    private void openCommand(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openCommand
        openTarget(evt.getActionCommand());
    }//GEN-LAST:event_openCommand

    private void projectBtargetSelection(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectBtargetSelection
        displayProject();
    }//GEN-LAST:event_projectBtargetSelection

    private void outputBtargetSelection(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputBtargetSelection
        displayOutput();
    }//GEN-LAST:event_outputBtargetSelection

    private void cleanOMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanOMActionPerformed
        if (currentlyShowsOutput)
            outputTxt.setText("");
        else
            errorTxt.setText("");
    }//GEN-LAST:event_cleanOMActionPerformed

    private void saveOMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveOMActionPerformed
        saveOutPut();
    }//GEN-LAST:event_saveOMActionPerformed

    private void savePMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePMActionPerformed
        saveProjectWithErrorMessage();
    }//GEN-LAST:event_savePMActionPerformed

    private void expandOBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expandOBMousePressed
        if (expandOB.isEnabled())
            outputM.show(expandOB, 0, expandOB.getHeight());
    }//GEN-LAST:event_expandOBMousePressed

    private void expandPBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expandPBMousePressed
        if (expandPB.isEnabled())
            projectM.show(expandPB, 0, expandPB.getHeight());
    }//GEN-LAST:event_expandPBMousePressed

    private void apkMshowIDE(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apkMshowIDE
        try {
            Desktop.getDesktop().open(getApkPath(proj.getLaunchType() == RELEASE).getParentFile());
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_apkMshowIDE

    private void jarMshowIDE(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarMshowIDE
        try {
            Desktop.getDesktop().open(getJarPath().getParentFile());
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_jarMshowIDE

    private void desktopMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desktopMActionPerformed
        try {
            Desktop.getDesktop().open(proj.getPath());
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_desktopMActionPerformed

    private void cleanBactOnProject(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanBactOnProject
        launch = execInConsole("clean", null, proj, initLaunchVisualsOut("Clean up project", "Cleaning project"), initLaunchVisualsErr(), launchCallback);
    }//GEN-LAST:event_cleanBactOnProject

    private void expandCBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expandCBMousePressed
        if (expandCB.isEnabled())
            cleanM.show(expandCB, 0, expandCB.getHeight());
    }//GEN-LAST:event_expandCBMousePressed

    private void cleanAllPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanAllPMActionPerformed
        launch = execInConsole("clean", "distclean", proj, initLaunchVisualsOut("Clean project and build files", "Clean project"), initLaunchVisualsErr(), res -> {
            if (res == 0)
                saveProjectWithErrorMessage();
            launchCallback.accept(res);
        });
    }//GEN-LAST:event_cleanAllPMActionPerformed

    private void outputTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputTBActionPerformed
        showOutputView(true);
    }//GEN-LAST:event_outputTBActionPerformed

    private void errorTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_errorTBActionPerformed
        showOutputView(false);
    }//GEN-LAST:event_errorTBActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JButton actionB;
    private javax.swing.JPopupMenu actionsM;
    private javax.swing.JToggleButton androidT;
    private javax.swing.JMenuItem apkM;
    private javax.swing.JMenuItem buildM;
    private javax.swing.JMenuItem cleanAllPM;
    private javax.swing.JButton cleanB;
    private javax.swing.JPopupMenu cleanM;
    private javax.swing.JMenuItem cleanOM;
    private javax.swing.JPanel commandP;
    private javax.swing.JPanel contentP;
    private javax.swing.JPanel controlP;
    private javax.swing.JPanel controlP_L;
    private javax.swing.JPanel controlP_R;
    private javax.swing.JMenuItem desktopM;
    private javax.swing.JToggleButton desktopT;
    private javax.swing.JToggleButton errorTB;
    private javax.swing.JTextPane errorTxt;
    private javax.swing.JButton expandCB;
    private javax.swing.JButton expandOB;
    private javax.swing.JButton expandPB;
    private javax.swing.JButton expandRB;
    private javax.swing.JPanel infoP;
    private javax.swing.JPanel inoutP;
    private javax.swing.JMenuItem intellijM;
    private javax.swing.JToggleButton iosT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuItem jarM;
    private javax.swing.JPanel leftButtonPanel;
    private javax.swing.JMenuItem netbeansM;
    private javax.swing.JButton openB;
    private javax.swing.JPopupMenu openM;
    private javax.swing.JLabel outResult;
    private javax.swing.JPanel outerrorP;
    private javax.swing.JToggleButton outputB;
    private javax.swing.ButtonGroup outputG;
    private javax.swing.JPopupMenu outputM;
    private javax.swing.JToggleButton outputTB;
    private javax.swing.JTextPane outputTxt;
    private javax.swing.JPanel parameters;
    private javax.swing.JToggleButton projectB;
    private javax.swing.ButtonGroup projectG;
    private javax.swing.JPopupMenu projectM;
    private javax.swing.JPanel projectP;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JMenuItem runM;
    private javax.swing.JMenuItem saveOM;
    private javax.swing.JMenuItem savePM;
    private javax.swing.JScrollPane scrollErrP;
    private javax.swing.JScrollPane scrollOutP;
    private javax.swing.JMenuItem studioM;
    private javax.swing.ButtonGroup targetG;
    private javax.swing.JPanel targetP;
    private javax.swing.JToggleButton uwpT;
    private javax.swing.JMenuItem vstudioM;
    private javax.swing.JMenuItem xcodeM;
    // End of variables declaration//GEN-END:variables

}
