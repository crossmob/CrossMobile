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

import com.panayotis.appenh.AFileChooser;
import com.panayotis.appenh.Enhancer;
import com.panayotis.hrgui.HiResButton;
import com.panayotis.hrgui.HiResDialog;
import org.crossmobile.gui.actives.ActiveLabel;
import org.crossmobile.gui.actives.ActivePanel;
import org.crossmobile.gui.actives.ActiveRadioButton;
import org.crossmobile.gui.actives.ActiveTextField;
import org.crossmobile.gui.parameters.impl.ArtifactIdParameter;
import org.crossmobile.gui.utils.NameConverter;
import org.crossmobile.prefs.Prefs;

import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.panayotis.appenh.AFileChooser.FileSelectionMode.DirectoriesOnly;
import static org.crossmobile.gui.project.TemplateType.*;

public final class NewProjectInfo extends HiResDialog {

    private static final Color error = Color.red;
    private static final String PROJECT_PREFIX = "project";
    private static final AFileChooser afc = new AFileChooser().setRememberSelection(true).setDirectory(Prefs.getCurrentDir()).setMode(DirectoriesOnly);

    private final Color def;
    private File parentpath;
    private boolean accepted = false;

    public NewProjectInfo() {
        super((Frame) null, true);
        initComponents();
        idT.setToolTipText(IdDocumentFilter.TOOLTIP);
        if (idT.getDocument() instanceof AbstractDocument)
            ((AbstractDocument) idT.getDocument()).setDocumentFilter(new IdDocumentFilter());
        def = appnameL.getForeground();

        parentpath = Prefs.getProjectsDir();

        appnameT.setText(getNextProjectName());
        idT.setText(ArtifactIdParameter.DEFAULT_ARTIFACT_ID);
        pack();
        setLocationRelativeTo(null);
        // Should be down here, to disable size manipulation of window
        locationT.setText(parentpath.getAbsolutePath());
    }

    public String getDisplayName() {
        return appnameT.getText().trim();
    }

    public String getId() {
        return idT.getText().trim();
    }

    public File getProjectPath() {
        return accepted ? new File(parentpath, getApplicationName()) : null;
    }

    public String getApplicationName() {
        return NameConverter.unicodeToAsciiID(appnameT.getText().trim()).toLowerCase();
    }

    public String getTemplateType() {
        return templateG.getSelection().getActionCommand();
    }

    private boolean checkStatus() {
        boolean status = true;
        appnameT.setText(appnameT.getText().trim());
        idT.setText(idT.getText().trim());
        if (appnameT.getText().isEmpty()) {
            status = false;
            appnameL.setForeground(error);
            appnameT.setForeground(error);
        } else {
            appnameL.setForeground(def);
            appnameT.setForeground(def);
        }
        if (!IdDocumentFilter.PATTERN.matcher(idT.getText()).matches()) {
            status = false;
            idL.setForeground(error);
            idT.setForeground(error);
        } else {
            idL.setForeground(def);
            idT.setForeground(def);
        }
        return status;
    }

    private String getNextProjectName() {
        int i = 1;
        try {
            Set<String> files = new HashSet<>(Arrays.asList(parentpath.list()));
            do {
                String fname = PROJECT_PREFIX + i;
                if (!files.contains(fname))
                    return fname;
                i++;
            } while (true);
        } catch (Exception e) {
            return PROJECT_PREFIX + 1;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        templateG = new javax.swing.ButtonGroup();
        themeBG = new javax.swing.ButtonGroup();
        themeRG = new javax.swing.ButtonGroup();
        BasePanel = new GradientPanel();
        jPanel10 = new ActivePanel();
        jPanel9 = new ActivePanel();
        jLabel1 = new ActiveLabel();
        locationT = new ActiveTextField();
        browseB = new HiResButton();
        jPanel1 = new ActivePanel();
        appnameT = new ActiveTextField();
        appnameL = new ActiveLabel();
        jPanel2 = new ActivePanel();
        idL = new ActiveLabel();
        idT = new ActiveTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel3 = new ActiveLabel();
        jPanel3 = new ActivePanel();
        buttonR = new ActiveRadioButton();
        buttonL = new javax.swing.JLabel();
        singleR = new ActiveRadioButton();
        singleL = new javax.swing.JLabel();
        navigationR = new ActiveRadioButton();
        nagivationL = new javax.swing.JLabel();
        tableR = new ActiveRadioButton();
        tableL = new javax.swing.JLabel();
        cameraR = new ActiveRadioButton();
        cameraL = new javax.swing.JLabel();
        mapR = new ActiveRadioButton();
        mapL = new javax.swing.JLabel();
        i18nR = new ActiveRadioButton();
        i18nL = new javax.swing.JLabel();
        storyboardR = new ActiveRadioButton();
        storyboardL = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        emptyR = new ActiveRadioButton();
        jPanel6 = new ActivePanel();
        createB = new HiResButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create new CrossMobile project");
        setResizable(false);
        setSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(new java.awt.BorderLayout());

        BasePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 4, 8));
        BasePanel.setLayout(new java.awt.BorderLayout());

        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.Y_AXIS));

        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 20, 0));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("<html>The location of the <b>parent</b> folder, where this project will be created");
        jPanel9.add(jLabel1, java.awt.BorderLayout.NORTH);

        locationT.setEditable(false);
        locationT.setColumns(30);
        jPanel9.add(locationT, java.awt.BorderLayout.CENTER);

        browseB.setText("Browse");
        browseB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseBActionPerformed(evt);
            }
        });
        jPanel9.add(browseB, java.awt.BorderLayout.EAST);

        jPanel10.add(jPanel9);

        jPanel1.setLayout(new java.awt.BorderLayout());

        appnameT.setToolTipText("");
        appnameT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                NewProjectInfo.this.focusLost(evt);
            }
        });
        appnameT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                appnameTKeyTyped(evt);
            }
        });
        jPanel1.add(appnameT, java.awt.BorderLayout.CENTER);

        appnameL.setText("Name");
        appnameL.setMaximumSize(new java.awt.Dimension(100, 16));
        appnameL.setMinimumSize(new java.awt.Dimension(100, 16));
        appnameL.setPreferredSize(new java.awt.Dimension(120, 16));
        jPanel1.add(appnameL, java.awt.BorderLayout.WEST);

        jPanel10.add(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 0, 20, 0));
        jPanel2.setLayout(new java.awt.BorderLayout());

        idL.setText("Organization ID");
        idL.setMaximumSize(new java.awt.Dimension(120, 16));
        idL.setMinimumSize(new java.awt.Dimension(120, 16));
        idL.setPreferredSize(new java.awt.Dimension(120, 16));
        jPanel2.add(idL, java.awt.BorderLayout.WEST);

        idT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                NewProjectInfo.this.focusLost(evt);
            }
        });
        idT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idTKeyTyped(evt);
            }
        });
        jPanel2.add(idT, java.awt.BorderLayout.CENTER);

        jPanel10.add(jPanel2);

        jPanel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 0, 12, 0));
        jPanel12.setOpaque(false);
        jPanel12.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("Please select code template");
        jPanel12.add(jLabel3, java.awt.BorderLayout.PAGE_START);

        jPanel10.add(jPanel12);

        jPanel3.setLayout(new java.awt.GridLayout(0, 4, 8, 12));

        templateG.add(buttonR);
        buttonR.setSelected(true);
        buttonR.setText("Button example");
        buttonR.setActionCommand(BUTTON_PROJECT.actual);
        buttonR.setOpaque(false);
        jPanel3.add(buttonR);

        buttonL.setIcon(BUTTON_PROJECT.icon());
        jPanel3.add(buttonL);

        templateG.add(singleR);
        singleR.setText("Empty view");
        singleR.setActionCommand(SINGLE_PROJECT.actual);
        singleR.setOpaque(false);
        jPanel3.add(singleR);

        singleL.setIcon(SINGLE_PROJECT.icon());
        jPanel3.add(singleL);

        templateG.add(navigationR);
        navigationR.setText("Navigation example");
        navigationR.setActionCommand(NAVIGATION_PROJECT.actual);
        navigationR.setOpaque(false);
        jPanel3.add(navigationR);

        nagivationL.setIcon(NAVIGATION_PROJECT.icon());
        jPanel3.add(nagivationL);

        templateG.add(tableR);
        tableR.setText("Table example");
        tableR.setActionCommand(TABLE_PROJECT.actual);
        tableR.setOpaque(false);
        jPanel3.add(tableR);

        tableL.setIcon(TABLE_PROJECT.icon());
        jPanel3.add(tableL);

        templateG.add(cameraR);
        cameraR.setText("Camera example");
        cameraR.setActionCommand(CAMERA_PROJECT.actual);
        cameraR.setOpaque(false);
        jPanel3.add(cameraR);

        cameraL.setIcon(CAMERA_PROJECT.icon());
        jPanel3.add(cameraL);

        templateG.add(mapR);
        mapR.setText("Map example");
        mapR.setActionCommand(MAP_PROJECT.actual);
        mapR.setOpaque(false);
        jPanel3.add(mapR);

        mapL.setIcon(MAP_PROJECT.icon());
        jPanel3.add(mapL);

        templateG.add(i18nR);
        i18nR.setText("Internationalization");
        i18nR.setActionCommand(I18N_PROJECT.actual);
        i18nR.setOpaque(false);
        jPanel3.add(i18nR);

        i18nL.setIcon(I18N_PROJECT.icon());
        jPanel3.add(i18nL);

        templateG.add(storyboardR);
        storyboardR.setText("Storyboard example");
        storyboardR.setActionCommand(STORYBOARD_PROJECT.actual);
        storyboardR.setOpaque(false);
        jPanel3.add(storyboardR);

        storyboardL.setIcon(STORYBOARD_PROJECT.icon());
        jPanel3.add(storyboardL);

        jPanel10.add(jPanel3);

        jPanel13.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 0, 0, 0));
        jPanel13.setOpaque(false);
        jPanel13.setLayout(new java.awt.BorderLayout());

        templateG.add(emptyR);
        emptyR.setText("Project with no source files");
        emptyR.setActionCommand(EMPTY_PROJECT.actual);
        emptyR.setOpaque(false);
        jPanel13.add(emptyR, java.awt.BorderLayout.WEST);

        jPanel10.add(jPanel13);

        BasePanel.add(jPanel10, java.awt.BorderLayout.NORTH);

        jPanel6.setLayout(new java.awt.FlowLayout(2));

        createB.setText("Create");
        createB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBActionPerformed(evt);
            }
        });
        jPanel6.add(createB);

        BasePanel.add(jPanel6, java.awt.BorderLayout.SOUTH);

        getContentPane().add(BasePanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBActionPerformed
        if (accepted = checkStatus())
            setVisible(false);
    }//GEN-LAST:event_createBActionPerformed

    private void appnameTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_appnameTKeyTyped
        appnameL.setForeground(def);
        appnameT.setForeground(def);
    }//GEN-LAST:event_appnameTKeyTyped

    private void idTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idTKeyTyped
        idL.setForeground(def);
        idT.setForeground(def);
    }//GEN-LAST:event_idTKeyTyped

    private void focusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_focusLost
        checkStatus();
    }//GEN-LAST:event_focusLost

    private void browseBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseBActionPerformed
        File current = Prefs.getCurrentDir();
        Prefs.setCurrentDir(Prefs.getProjectsDir());
        File path = afc.openSingle();
        if (path != null) {
            parentpath = path;
            if (parentpath.isFile() || !parentpath.exists())
                parentpath = parentpath.getParentFile();
            locationT.setText(parentpath.getAbsolutePath());
            Prefs.setProjectsDir(parentpath);
        }
    }//GEN-LAST:event_browseBActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BasePanel;
    private javax.swing.JLabel appnameL;
    private javax.swing.JTextField appnameT;
    private javax.swing.JButton browseB;
    private javax.swing.JLabel buttonL;
    private javax.swing.JRadioButton buttonR;
    private javax.swing.JLabel cameraL;
    private javax.swing.JRadioButton cameraR;
    private javax.swing.JButton createB;
    private javax.swing.JRadioButton emptyR;
    private javax.swing.JLabel i18nL;
    private javax.swing.JRadioButton i18nR;
    private javax.swing.JLabel idL;
    private javax.swing.JTextField idT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField locationT;
    private javax.swing.JLabel mapL;
    private javax.swing.JRadioButton mapR;
    private javax.swing.JLabel nagivationL;
    private javax.swing.JRadioButton navigationR;
    private javax.swing.JLabel singleL;
    private javax.swing.JRadioButton singleR;
    private javax.swing.JLabel storyboardL;
    private javax.swing.JRadioButton storyboardR;
    private javax.swing.JLabel tableL;
    private javax.swing.JRadioButton tableR;
    private javax.swing.ButtonGroup templateG;
    private javax.swing.ButtonGroup themeBG;
    private javax.swing.ButtonGroup themeRG;
    // End of variables declaration//GEN-END:variables

}
