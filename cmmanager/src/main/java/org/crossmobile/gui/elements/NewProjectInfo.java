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

import com.panayotis.hrgui.HiResButton;
import com.panayotis.hrgui.HiResDialog;
import org.crossmobile.gui.actives.ActiveLabel;
import org.crossmobile.gui.actives.ActivePanel;
import org.crossmobile.gui.actives.ActiveRadioButton;
import org.crossmobile.gui.actives.ActiveTextField;
import org.crossmobile.gui.parameters.impl.ArtifactIdParameter;
import org.crossmobile.prefs.Prefs;
import org.crossmobile.utils.NameConvertor;

import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.crossmobile.gui.project.TemplateType.*;

public final class NewProjectInfo extends HiResDialog {

    private static final Color error = Color.red;
    private static final String PROJECT_PREFIX = "project";

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
        return NameConvertor.unicodeToAsciiID(appnameT.getText().trim()).toLowerCase();
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
        jPanel3 = new ActivePanel();
        jLabel3 = new ActiveLabel();
        sampleR = new ActiveRadioButton();
        singleR = new ActiveRadioButton();
        navigationR = new ActiveRadioButton();
        storyboardR = new ActiveRadioButton();
        emptyR = new ActiveRadioButton();
        jPanel6 = new ActivePanel();
        createB = new HiResButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create new CrossMobile project");
        setResizable(false);
        setSize(new java.awt.Dimension(500, 400));

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

        jPanel3.setLayout(new java.awt.GridLayout(0, 1, 0, 6));

        jLabel3.setText("Please select code template");
        jPanel3.add(jLabel3);

        templateG.add(sampleR);
        sampleR.setSelected(true);
        sampleR.setText("Sample project");
        sampleR.setActionCommand(SAMPLE_PROJECT.actual);
        sampleR.setOpaque(false);
        jPanel3.add(sampleR);

        templateG.add(singleR);
        singleR.setText("Single view project");
        singleR.setActionCommand(SINGLE_PROJECT.actual);
        singleR.setOpaque(false);
        jPanel3.add(singleR);

        templateG.add(navigationR);
        navigationR.setText("Navigation based project");
        navigationR.setActionCommand(NAVIGATION_PROJECT.actual);
        navigationR.setOpaque(false);
        jPanel3.add(navigationR);

        templateG.add(storyboardR);
        storyboardR.setText("Storyboard project");
        storyboardR.setActionCommand(STORYBOARD_PROJECT.actual);
        storyboardR.setOpaque(false);
        jPanel3.add(storyboardR);

        templateG.add(emptyR);
        emptyR.setText("Project with no source files");
        emptyR.setActionCommand(EMPTY_PROJECT.actual);
        emptyR.setOpaque(false);
        jPanel3.add(emptyR);

        jPanel10.add(jPanel3);

        BasePanel.add(jPanel10, java.awt.BorderLayout.NORTH);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

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
        Collection<File> result = FileChooser.dialog("Create Project", "Select", false, true);
        if (result != null && !result.isEmpty()) {
            parentpath = result.iterator().next();
            if (parentpath.isFile() || !parentpath.exists())
                parentpath = parentpath.getParentFile();
            locationT.setText(parentpath.getAbsolutePath());
            Prefs.setProjectsDir(parentpath);
        }
        Prefs.setCurrentDir(current);
    }//GEN-LAST:event_browseBActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BasePanel;
    private javax.swing.JLabel appnameL;
    private javax.swing.JTextField appnameT;
    private javax.swing.JButton browseB;
    private javax.swing.JButton createB;
    private javax.swing.JRadioButton emptyR;
    private javax.swing.JLabel idL;
    private javax.swing.JTextField idT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField locationT;
    private javax.swing.JRadioButton navigationR;
    private javax.swing.JRadioButton sampleR;
    private javax.swing.JRadioButton singleR;
    private javax.swing.JRadioButton storyboardR;
    private javax.swing.ButtonGroup templateG;
    private javax.swing.ButtonGroup themeBG;
    private javax.swing.ButtonGroup themeRG;
    // End of variables declaration//GEN-END:variables

}
