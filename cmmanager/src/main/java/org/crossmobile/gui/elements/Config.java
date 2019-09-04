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
package org.crossmobile.gui.elements;

import com.panayotis.hrgui.*;
import org.crossmobile.gui.actives.ActiveLabel;
import org.crossmobile.gui.actives.ActiveRadioButton;
import org.crossmobile.gui.actives.ActiveTextField;
import org.crossmobile.prefs.Prefs;
import org.crossmobile.utils.LocationTarget;
import org.crossmobile.utils.UIUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static org.crossmobile.utils.SystemDependent.Execs.*;

public class Config extends HiResDialog {

    public static final LocationTarget Netbeans = new LocationTarget(NETBEANS);
    public static final LocationTarget Studio = new LocationTarget(STUDIO, STUDIO64.filename());
    public static final LocationTarget IntelliJ = new LocationTarget(IDEA);
    public static final LocationTarget Android = new LocationTarget("tools/bin/sdkmanager.bat", "tools/bin/sdkmanager", "platform-tools/adb", "platform-tools/adb.exe");
    public static final LocationTarget JDK = new LocationTarget("lib/dt.jar", "lib/tools.jar", "jmods/jdk.compiler.jmod");

    private final static Config INSTANCE = new Config();

    public static void showConfig() {
        INSTANCE.setVisible(true);
        INSTANCE.setResizable(false);
    }

    @SuppressWarnings("OverridableMethodCallInConstructor")
    private Config() {
        super((Dialog) null, true);
        initComponents();
        themeGroup.setSelected(Theme.current() == Theme.dark() ? darkB.getModel() : lightB.getModel(), true);

        UIUtils.syncWidth(Arrays.asList(jdkL, androidL, netbeansL, intellijL, studioL, keystoreL));
        UIUtils.syncWidth(Arrays.asList(jdkB, androidB, netbeansB, intellijB, studioB, keystoreB));

        try {
            setIconImage(ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/logo-small.png")));
        } catch (IOException ex) {
        }
        setLocationRelativeTo(null);
    }

    @Override
    public void setVisible(boolean b) {
        netbeansT.setText(Prefs.getNetbeansLocation());
        intellijT.setText(Prefs.getIntelliJLocation());
        jdkT.setText(Prefs.getJDKLocation());
        androidT.setText(Prefs.getAndroidSDKLocation());
        studioT.setText(Prefs.getAndroidStudioLocation());
        keyT.setText(Prefs.getAndroidKeyLocation());
        super.setVisible(b);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        keyChooser = new javax.swing.JFileChooser();
        themeGroup = new javax.swing.ButtonGroup();
        jPanel4 = new GradientPanel();
        jPanel10 = new HiResPanel();
        jLabel3 = new ActiveLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jdkL = new ActiveLabel();
        androidL = new ActiveLabel();
        jPanel13 = new javax.swing.JPanel();
        jdkT = new ActiveTextField();
        androidT = new ActiveTextField();
        jPanel12 = new javax.swing.JPanel();
        jdkB = new HiResButton();
        androidB = new HiResButton();
        jPanel5 = new HiResPanel();
        jLabel2 = new ActiveLabel();
        jPanel6 = new javax.swing.JPanel();
        eselectP = new HiResPanel();
        netbeansL = new ActiveLabel();
        intellijL = new ActiveLabel();
        etextP = new HiResPanel();
        netbeansT = new ActiveTextField();
        intellijT = new ActiveTextField();
        ebuttonP = new HiResPanel();
        netbeansB = new HiResButton();
        intellijB = new HiResButton();
        jPanel11 = new HiResPanel();
        jLabel6 = new ActiveLabel();
        jPanel17 = new HiResPanel();
        jPanel15 = new HiResPanel();
        studioL = new ActiveLabel();
        keystoreL = new ActiveLabel();
        jPanel18 = new HiResPanel();
        studioT = new ActiveTextField();
        keyT = new ActiveTextField();
        jPanel19 = new HiResPanel();
        studioB = new HiResButton();
        keystoreB = new HiResButton();
        jPanel20 = new HiResPanel();
        jLabel7 = new ActiveLabel();
        jPanel22 = new HiResPanel();
        lightB = new ActiveRadioButton();
        darkB = new ActiveRadioButton();
        jPanel1 = new HiResPanel();
        closeB = new HiResButton();

        keyChooser.setDialogTitle("Default key file");
        keyChooser.setSelectedFile(new File(Prefs.getAndroidKeyLocation()));

        setTitle("CrossMobile Configuration");
        setResizable(false);

        jPanel4.setBorder(new HiResEmptyBorder(12, 12, 0, 12));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.Y_AXIS));

        jPanel10.setBorder(new HiResEmptyBorder(8, 0, 8, 0));
        jPanel10.setOpaque(false);
        jPanel10.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(jLabel3.getFont().deriveFont(jLabel3.getFont().getStyle() | java.awt.Font.BOLD));
        jLabel3.setText("Development Environments");
        jPanel10.add(jLabel3, java.awt.BorderLayout.NORTH);

        jPanel16.setOpaque(false);
        jPanel16.setLayout(new java.awt.BorderLayout());

        jPanel14.setOpaque(false);
        jPanel14.setLayout(new java.awt.GridLayout(0, 1));

        jdkL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jdkL.setText("Java JDK");
        jPanel14.add(jdkL);

        androidL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        androidL.setText("Android SDK");
        jPanel14.add(androidL);

        jPanel16.add(jPanel14, java.awt.BorderLayout.WEST);

        jPanel13.setOpaque(false);
        jPanel13.setLayout(new java.awt.GridLayout(0, 1));

        jdkT.setEditable(false);
        jdkT.setColumns(28);
        jPanel13.add(jdkT);

        androidT.setEditable(false);
        androidT.setColumns(28);
        jPanel13.add(androidT);

        jPanel16.add(jPanel13, java.awt.BorderLayout.CENTER);

        jPanel12.setOpaque(false);
        jPanel12.setLayout(new java.awt.GridLayout(0, 1));

        jdkB.setText("Locate");
        jdkB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdkBActionPerformed(evt);
            }
        });
        jPanel12.add(jdkB);

        androidB.setText("Locate");
        androidB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                androidBActionPerformed(evt);
            }
        });
        jPanel12.add(androidB);

        jPanel16.add(jPanel12, java.awt.BorderLayout.EAST);

        jPanel10.add(jPanel16, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel10);

        jPanel5.setBorder(javax.swing.BorderFactory.createCompoundBorder(new HiResMatteBorder(1, 0, 0, 0, Theme.current().line), new HiResEmptyBorder(8, 0, 8, 0)));
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(jLabel2.getFont().deriveFont(jLabel2.getFont().getStyle() | java.awt.Font.BOLD));
        jLabel2.setText("IDE Editors");
        jPanel5.add(jLabel2, java.awt.BorderLayout.NORTH);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.BorderLayout());

        eselectP.setOpaque(false);
        eselectP.setLayout(new java.awt.GridLayout(0, 1));

        netbeansL.setText("Netbeans");
        eselectP.add(netbeansL);

        intellijL.setText("IntelliJ IDEA");
        eselectP.add(intellijL);

        jPanel6.add(eselectP, java.awt.BorderLayout.WEST);

        etextP.setOpaque(false);
        etextP.setLayout(new java.awt.GridLayout(0, 1));

        netbeansT.setEditable(false);
        netbeansT.setColumns(28);
        etextP.add(netbeansT);

        intellijT.setEditable(false);
        intellijT.setColumns(28);
        etextP.add(intellijT);

        jPanel6.add(etextP, java.awt.BorderLayout.CENTER);

        ebuttonP.setOpaque(false);
        ebuttonP.setLayout(new java.awt.GridLayout(0, 1));

        netbeansB.setText("Locate");
        netbeansB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                netbeansBActionPerformed(evt);
            }
        });
        ebuttonP.add(netbeansB);

        intellijB.setText("Locate");
        intellijB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intellijBActionPerformed(evt);
            }
        });
        ebuttonP.add(intellijB);

        jPanel6.add(ebuttonP, java.awt.BorderLayout.EAST);

        jPanel5.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel5);

        jPanel11.setBorder(javax.swing.BorderFactory.createCompoundBorder(new HiResMatteBorder(1, 0, 1, 0, Theme.current().line), javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        jPanel11.setOpaque(false);
        jPanel11.setLayout(new java.awt.BorderLayout());

        jLabel6.setFont(jLabel6.getFont().deriveFont(jLabel6.getFont().getStyle() | java.awt.Font.BOLD));
        jLabel6.setText("Android tools");
        jPanel11.add(jLabel6, java.awt.BorderLayout.NORTH);

        jPanel17.setOpaque(false);
        jPanel17.setLayout(new java.awt.BorderLayout());

        jPanel15.setOpaque(false);
        jPanel15.setLayout(new java.awt.GridLayout(0, 1));

        studioL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        studioL.setText("Android Studio");
        jPanel15.add(studioL);

        keystoreL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        keystoreL.setText("Default Keystore");
        jPanel15.add(keystoreL);

        jPanel17.add(jPanel15, java.awt.BorderLayout.WEST);

        jPanel18.setOpaque(false);
        jPanel18.setLayout(new java.awt.GridLayout(0, 1));

        studioT.setEditable(false);
        studioT.setColumns(28);
        jPanel18.add(studioT);

        keyT.setEditable(false);
        keyT.setColumns(28);
        jPanel18.add(keyT);

        jPanel17.add(jPanel18, java.awt.BorderLayout.CENTER);

        jPanel19.setOpaque(false);
        jPanel19.setLayout(new java.awt.GridLayout(0, 1));

        studioB.setText("Locate");
        studioB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studioBActionPerformed(evt);
            }
        });
        jPanel19.add(studioB);

        keystoreB.setText("Browse");
        keystoreB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keystoreBActionPerformed(evt);
            }
        });
        jPanel19.add(keystoreB);

        jPanel17.add(jPanel19, java.awt.BorderLayout.EAST);

        jPanel11.add(jPanel17, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel11);

        jPanel20.setBorder(new HiResEmptyBorder(8, 0, 8, 0));
        jPanel20.setOpaque(false);
        jPanel20.setLayout(new java.awt.BorderLayout());

        jLabel7.setFont(jLabel7.getFont().deriveFont(jLabel7.getFont().getStyle() | java.awt.Font.BOLD));
        jLabel7.setText("Theme");
        jPanel20.add(jLabel7, java.awt.BorderLayout.NORTH);

        jPanel22.setOpaque(false);
        jPanel22.setLayout(new java.awt.GridLayout(0, 2));

        themeGroup.add(lightB);
        lightB.setSelected(true);
        lightB.setText("Light");
        lightB.setActionCommand("light");
        lightB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themeActionPerformed(evt);
            }
        });
        jPanel22.add(lightB);

        themeGroup.add(darkB);
        darkB.setText("Dark");
        darkB.setActionCommand("dark");
        darkB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themeActionPerformed(evt);
            }
        });
        jPanel22.add(darkB);

        jPanel20.add(jPanel22, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel20);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        closeB.setText("Close");
        closeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBActionPerformed(evt);
            }
        });
        jPanel1.add(closeB);

        jPanel4.add(jPanel1);

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void netbeansBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_netbeansBActionPerformed
        netbeansB.setEnabled(false);
        JWizard wiz = new JWizard("Netbeans");
        wiz.setCallback((String fname) -> {
            if (fname != null) {
                Prefs.setNetbeansLocation(fname);
                netbeansT.setText(fname);
            }
            netbeansB.setEnabled(true);
        });

        wiz.fire(Netbeans, Prefs.getNetbeansLocation());
    }//GEN-LAST:event_netbeansBActionPerformed

    private void closeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBActionPerformed
        setVisible(false);
    }//GEN-LAST:event_closeBActionPerformed

    private void jdkBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdkBActionPerformed
        jdkB.setEnabled(false);
        JWizard wiz = new JWizard("Java Development Kit Home");
        wiz.setCallback((String fname) -> {
            if (fname != null) {
                Prefs.setJDKLocation(fname);
                jdkT.setText(fname);
            }
            jdkB.setEnabled(true);
        });
        wiz.fire(JDK, Prefs.getJDKLocation());
    }//GEN-LAST:event_jdkBActionPerformed

    private void androidBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_androidBActionPerformed
        androidB.setEnabled(false);
        JWizard wiz = new JWizard("Android SDK Home");
        wiz.setCallback((String fname) -> {
            if (fname != null) {
                Prefs.setAndroidSDKLocation(fname);
                androidT.setText(fname);
            }
            androidB.setEnabled(true);
        });
        wiz.fire(Android, Prefs.getAndroidSDKLocation());
    }//GEN-LAST:event_androidBActionPerformed

    private void keystoreBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keystoreBActionPerformed
        String newkey = KeystoreManager.browseKeystore();
        if (newkey != null) {
            keyT.setText(newkey);
            Prefs.setAndroidKeyLocation(newkey);
        }
    }//GEN-LAST:event_keystoreBActionPerformed

    private void studioBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studioBActionPerformed
        studioB.setEnabled(false);
        JWizard wiz = new JWizard("Android Studio");
        wiz.setCallback((String fname) -> {
            if (fname != null) {
                Prefs.setStudioLocation(fname);
                studioT.setText(fname);
            }
            studioB.setEnabled(true);
        });
        wiz.fire(Studio, Prefs.getAndroidStudioLocation());
    }//GEN-LAST:event_studioBActionPerformed

    private void intellijBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intellijBActionPerformed
        JWizard wiz = new JWizard("IntelliJ IDEA");
        wiz.setCallback((String fname) -> {
            if (fname != null) {
                Prefs.setIntelliJLocation(fname);
                intellijT.setText(fname);
            }
        });
        wiz.fire(IntelliJ, Prefs.getIntelliJLocation());
    }//GEN-LAST:event_intellijBActionPerformed

    private void themeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themeActionPerformed
        switch (((ActiveRadioButton) evt.getSource()).getActionCommand()) {
            case "dark":
                Theme.setDark();
                break;
            default:
                Theme.setBright();
        }
    }//GEN-LAST:event_themeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton androidB;
    private javax.swing.JLabel androidL;
    private javax.swing.JTextField androidT;
    private javax.swing.JButton closeB;
    private javax.swing.JRadioButton darkB;
    private javax.swing.JPanel ebuttonP;
    private javax.swing.JPanel eselectP;
    private javax.swing.JPanel etextP;
    private javax.swing.JButton intellijB;
    private javax.swing.JLabel intellijL;
    private javax.swing.JTextField intellijT;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JButton jdkB;
    private javax.swing.JLabel jdkL;
    private javax.swing.JTextField jdkT;
    private javax.swing.JFileChooser keyChooser;
    private javax.swing.JTextField keyT;
    private javax.swing.JButton keystoreB;
    private javax.swing.JLabel keystoreL;
    private javax.swing.JRadioButton lightB;
    private javax.swing.JButton netbeansB;
    private javax.swing.JLabel netbeansL;
    private javax.swing.JTextField netbeansT;
    private javax.swing.JButton studioB;
    private javax.swing.JLabel studioL;
    private javax.swing.JTextField studioT;
    private javax.swing.ButtonGroup themeGroup;
    // End of variables declaration//GEN-END:variables
}
