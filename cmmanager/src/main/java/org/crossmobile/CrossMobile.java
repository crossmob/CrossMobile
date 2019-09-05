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
package org.crossmobile;

import com.panayotis.appenh.Enhancer;
import com.panayotis.appenh.EnhancerManager;
import com.panayotis.jupidator.Updater;
import org.crossmobile.gui.RegisteredFrame;
import org.crossmobile.gui.WelcomeFrame;
import org.crossmobile.gui.elements.About;
import org.crossmobile.gui.elements.Config;
import org.crossmobile.gui.init.InitializationWizard;
import org.crossmobile.gui.init.InitializationWizard.Card;
import org.crossmobile.gui.project.ProjectInfo;
import org.crossmobile.gui.project.ProjectLoader;
import org.crossmobile.gui.utils.Paths;
import org.crossmobile.prefs.Prefs;
import org.crossmobile.utils.Log;
import org.crossmobile.utils.ProjectException;
import org.crossmobile.utils.TreeWalker;
import org.crossmobile.utils.LocationRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collection;

import static java.util.Arrays.asList;
import static org.crossmobile.Version.VERSION;
import static org.crossmobile.gui.elements.Config.*;
import static org.crossmobile.gui.init.ApplicationRequirements.*;

public class CrossMobile {

    public static void main(final String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                initialize(args, null);
            } catch (IllegalStateException | ProjectException ex) {
                JOptionPane.showConfirmDialog(null, ex.getMessage(), "Initialization error", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
            }
        });
    }

    private static void initialize(String[] args, Runnable finishCallback) throws IllegalStateException, ProjectException {
        RegisteredFrame.setFinishCallback(finishCallback);
        if (args == null || args.length == 0 || args[0].startsWith("-psn_")) {
            initEnhancer();
            Log.register(new Log.Default() {
                @Override
                public void info(String message) {
                    JOptionPane.showMessageDialog(null, message, "CrossMobile", JOptionPane.INFORMATION_MESSAGE);
                }

                @Override
                public void warning(String message) {
                    JOptionPane.showMessageDialog(null, message, "CrossMobile", JOptionPane.WARNING_MESSAGE);
                }

                @Override
                public void error(String message, Throwable th) {
                    if (message != null || th != null) {
                        if (message != null)
                            System.err.println(message);
                        th.printStackTrace(System.err);

                        if (message == null)
                            message = th.toString();
                        JOptionPane.showMessageDialog(null, message, "CrossMobile", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            WelcomeFrame frame = new WelcomeFrame();
            frame.setVisible(true);
            frame.setResizable(false);
            SwingUtilities.invokeLater(() -> postInit(frame));
        } else if (args.length == 2 && args[0].equals("--project"))
            ProjectLoader.showProject(ProjectInfo.load(args[1]), null);
        else if (args.length == 1 && args[0].equals("--help"))
            showHelp(0);
        else
            showError(args);
    }

    private static void initEnhancer() {
        Enhancer enhancer = EnhancerManager.getDefault();
        enhancer.setSafeLookAndFeel();
        enhancer.registerPreferences(Config::showConfig);
        enhancer.registerAbout(About::showAbout);
        enhancer.setApplicationIcons("images/logo-frame.png");
        enhancer.registerApplication("CrossMobile", "create native iOS, Android, Windows 10 and Desktop Applications from a singe code base", "Development", "Building", "IDE", "Java");
    }

    private static void postInit(WelcomeFrame frame) {
        if (!Prefs.isWizardExecuted()) {
            InitializationWizard initW = new InitializationWizard(frame);
            initW.setMainTitle("Welcome to CrossMobile");
            initW.setSubtitle("Before we begin, it is required to check your system for installed components");
            initW.setWelcomeInfo("<html>When you click on \"Continue\" the wizard will try to find installations of required applications to run CrossMobile.<br/>" +
                    "These applications are Java JDK 1.8, Android SDK, IntelliJ, Android Studio, and Netbeans.<br/>&nbsp;<br/>Please press \"Continue\" to start searching for these applications.</html>");
            Runnable skip = () -> {
                initW.setActive(false);
                if (initW.isVisible())
                    initW.setVisible(false);
                frame.setVisible(true);
            };
            initW.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    skip.run();
                }
            });
            initW.setAction("Continue", () -> {
                initW.gotoCard(Card.Externals);
                initW.setAction("Cancel", skip);
                initW.setSubtitle("Looking for installed components");
                initW.setRunning(true);
                Collection<LocationRequest> entries = asList(
                        Netbeans.makeRequest(initW::foundNetbeans),
                        JDK.makeRequest(initW::foundJDK),
                        IntelliJ.makeRequest(initW::foundIntelliJ),
                        Studio.makeRequest(initW::foundStudio),
                        Android.makeRequest(initW::foundAndroid)
                );
                new Thread(() -> {
                    TreeWalker.searchExecutable(entries, null, true, initW);
                    if (initW.isVisible())
                        initW.setTreeWalking(false);
                }).start();
            });
            initW.setVisible(true);
        } else if (!isAndroidConfigured() && !isJDKconfigured() && JOptionPane.showConfirmDialog(frame, "CrossMobile environment hasn't been properly configured.\nDo you want to configure it now?", "Configure CrossMobile", JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION)
            Config.showConfig();
        else if (!isAndroidConfigured() && JOptionPane.showConfirmDialog(frame, "Android SDK environment hasn't been properly configured.\nDo you want to configure it now?", "Configure CrossMobile", JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION)
            Config.showConfig();
        else if (!isJDKconfigured() && JOptionPane.showConfirmDialog(frame, "JDK environment hasn't been properly configured.\nDo you want to configure it now?", "Configure CrossMobile", JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION)
            Config.showConfig();
        frame.updateProjects(null);
        EnhancerManager.getDefault().registerUpdate(() -> showUpdate(frame, true));
        checkJavaVersion(frame, () -> showUpdate(frame, false));
    }

    private static void showHelp(int exitCode) {
        System.err.println("CrossMobile frontend");
        System.err.println("Arguments:");
        System.err.println("  --help              : This help message");
        System.err.println("  --project [PROJECT] : Open a project at the specified location");
        SplashScreen ss = SplashScreen.getSplashScreen();
        if (ss != null)
            ss.close();
        System.exit(exitCode);
    }

    private static void showError(String[] args) {
        System.err.print("Unable to understand arguments: ");
        for (String arg : args)
            System.err.print("'" + arg + "' ");
        System.err.println();
        System.err.println();
        showHelp(1);
    }

    private static void showUpdate(WelcomeFrame app, boolean force) {
        new Thread(() -> {
            Updater updater = Updater.start("https://crossmobile.tech/versions/release/crossmobile.xml", Paths.getApplicationPath(), 2, VERSION, app, force);
            if (force && updater == null)
                JOptionPane.showMessageDialog(app, "Unable to connect to Update Center", "CrossMobile Update", JOptionPane.WARNING_MESSAGE);
        }).start();
    }
}
