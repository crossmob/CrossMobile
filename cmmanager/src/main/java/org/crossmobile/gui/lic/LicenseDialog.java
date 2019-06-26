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
package org.crossmobile.gui.lic;

import com.panayotis.hrgui.HiResDialog;
import org.crossmobile.Version;
import org.crossmobile.gui.actives.*;
import org.crossmobile.gui.elements.FileChooser;
import org.crossmobile.gui.elements.GradientPanel;
import org.crossmobile.gui.elements.Theme;
import org.crossmobile.gui.project.ProjectLauncher;
import org.crossmobile.gui.utils.Paths;
import org.crossmobile.gui.utils.StreamQuality;
import org.crossmobile.prefs.Prefs;
import org.crossmobile.utils.*;
import org.crossmobile.utils.lic.LicenseManager;
import org.crossmobile.utils.lic.LicenseManager.UserPass;
import org.crossmobile.utils.launcher.Flavour;
import org.crossmobile.utils.lic.LicensedApplication;
import org.crossmobile.utils.lic.LicensedArtifact;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import static org.crossmobile.gui.lic.LicenseTreeRenderer.EMPTY;
import static org.crossmobile.gui.lic.LicenseTreeRenderer.ID;
import static org.crossmobile.gui.project.ProjectLauncher.getJavaEnv;

public class LicenseDialog extends HiResDialog {

    private static final String buttonLabel = "Get license";
    private static final String PRIVATE_AAR_PREFIX = "prv.crossmobile.aar.";

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public LicenseDialog(Frame owner) {
        super(owner, true);
        initComponents();
        setSize(480, 360);
        setLocationRelativeTo(null);
        updateTree();
        licenseT.setCellRenderer(new LicenseTreeRenderer());
        usernameT.requestFocus();
    }

    private void error(String error) {
        errorL.setText(error == null ? " " : error);
    }

    private void licenseUpdate(String username, String password) {
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        licenseB.setEnabled(false);
        usernameT.setEnabled(false);
        passwordT.setEnabled(false);
        updateB.setEnabled(false);
        viewB.setEnabled(false);
        licenseB.setText("Please wait...");
        new Thread(() -> {
            String error = LicenseManager.getLicense(new UserPass(username, password), true);
            SwingUtilities.invokeLater(() -> {
                licenseB.setEnabled(true);
                updateB.setEnabled(true);
                viewB.setEnabled(true);
                error(error == null ? "Update completed" : error);
                if (error == null) {
                    errorL.setForeground(Theme.current().text);
                    updateTree();
                    licenseB.setText("Close");
                } else {
                    usernameT.setEnabled(true);
                    passwordT.setEnabled(true);
                    licenseB.setText(buttonLabel);
                    passwordT.requestFocus();
                }
                setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            });
        }).start();
    }

    private void updateTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(EMPTY + "Application IDs");
        for (LicensedApplication application : LicenseManager.getRegistered()) {
            DefaultMutableTreeNode nodeid = new DefaultMutableTreeNode(ID + application.appId);
            root.add(nodeid);
            for (LicensedArtifact art : application.getArtifacts()) {
                DefaultMutableTreeNode nodeart = new DefaultMutableTreeNode(art.getDisplayName());
                nodeid.add(nodeart);
                if (art.ios)
                    nodeart.add(new DefaultMutableTreeNode(Flavour.IOS));
                if (art.android)
                    nodeart.add(new DefaultMutableTreeNode(Flavour.ANDROID));
                if (art.desktop)
                    nodeart.add(new DefaultMutableTreeNode(Flavour.DESKTOP));
            }
        }
        if (root.getChildCount() < 1)
            root.add(new DefaultMutableTreeNode(EMPTY + "No valid licenses found"));
        licenseT.setModel(new DefaultTreeModel(root));
        for (int i = 0; i < licenseT.getRowCount(); i++)
            licenseT.expandRow(i);
    }

    private void termTxt(String text, File tempDir) {
        addTxt(text);
        FileUtils.delete(tempDir);
        setEnabled(true);
    }

    private void addTxt(String text) {
        ((ActiveTextPane) pluginInfoT).addLine(text, StreamQuality.BASIC);
    }

    private void fixPomFile(File pomFile) {
        XMLWalker pom = XMLWalker.load(pomFile);
        if (pom == null)
            return;
        addTxt("Parsing " + pomFile.getAbsolutePath());
        if (!pom.nodeExists("project")
                || !pom.node("project").nodeExists("parent")
                || !pom.node("parent").nodeWithTextExists("groupId", "org.crossmobile")
                || !pom.nodeWithTextExists("artifactId", "env")) {
            addTxt("Not a valid CrossMobile plugin pom file");
            return;
        }

        pom.execIf(n -> n.nodeExists("version"), p -> p.add("version"));
        pom.node("version").setText(Version.VERSION);
        if (pom.pathExists("/project/dependencies")) {
            pom.path("/project/dependencies");
            pom.nodes("dependency", d -> {
                String prvGroupId = d.tag().nodeExists("groupId") ? d.node("groupId").text() : "";
                String artifactId = d.toTag().nodeExists("artifactId") ? d.node("artifactId").text() : "";
                String version = d.toTag().nodeExists("version") ? d.node("version").text() : "";
                if (prvGroupId.startsWith(PRIVATE_AAR_PREFIX) && !artifactId.isEmpty() && !version.isEmpty()) {
                    File tempDir = FileUtils.getTempDir();
                    if (tempDir == null) {
                        addTxt("Unable to create temporary directory");
                        return;
                    }
                    String origGroupId = prvGroupId.substring(PRIVATE_AAR_PREFIX.length());
                    String signature = origGroupId + ":" + artifactId + ":" + version + ":aar";
                    String targetSignature = prvGroupId + ":" + artifactId + ":" + version + ":" + "jar";
                    addTxt("Resolving " + signature);
                    addTxt("");
                    setEnabled(false);
                    ProjectLauncher.launch(new String[]{Paths.getMavenLocation(),
                            "dependency:copy", "org.apache.maven.plugins:maven-dependency-plugin:3.1.1:get", "-Dartifact=" + signature, "-Dtransitive=false", "-DoutputDirectory=."}, tempDir, (ActiveTextPane) pluginInfoT, (ActiveTextPane) pluginInfoT, r -> {
                        addTxt("");
                        if (r != 0) {
                            termTxt("Error while downloading " + signature, tempDir);
                            return;
                        }

                        File aar = new File(tempDir, artifactId + "-" + version + ".aar");
                        File outAar = new File(tempDir, "out");
                        if (!FileUtils.unzip(aar, outAar)) {
                            termTxt("Unable to unzip file " + aar.getAbsolutePath(), tempDir);
                            return;
                        }

                        Collection<File> jars = new ArrayList<>();
                        FileUtils.forEach(outAar, a -> a.getName().endsWith("jar"), (name, file) -> jars.add(file));
                        if (jars.isEmpty())
                            termTxt("No JARs found, aborting", tempDir);
                        else if (jars.size() > 1)
                            termTxt("More than one JAR found, aborting", tempDir);
                        else {
                            ProjectLauncher.launch(new String[]{Paths.getMavenLocation(),
                                            "install:install-file", "-Dfile=" + jars.iterator().next(), "-DgroupId=" + prvGroupId,
                                            "-DartifactId=" + artifactId, "-Dversion=" + version, "-Dpackaging=jar"},
                                    tempDir, (ActiveTextPane) pluginInfoT, (ActiveTextPane) pluginInfoT,
                                    r2 -> termTxt("\n" + (r2 == 0 ? "Successfully installed" : "Error while installing") + " " + signature + " into " + targetSignature, tempDir),
                                    getJavaEnv(), null, null, null);
                        }
                    }, getJavaEnv(), null, null, null);
                }
            });
        }
    }

    @Override
    public void setEnabled(boolean status) {
        super.setEnabled(status);
        pluginB.setEnabled(status);
        updateB.setEnabled(status);
        viewB.setEnabled(status);
        licenseB.setEnabled(status);
        browseB.setEnabled(status);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.ButtonGroup viewG = new javax.swing.ButtonGroup();
        javax.swing.JPanel jPanel1 = new GradientPanel();
        cardsP = new javax.swing.JPanel();
        javax.swing.JPanel updateP = new javax.swing.JPanel();
        javax.swing.JLabel infoL1 = new ActiveLabel();
        javax.swing.JPanel jPanel3 = new javax.swing.JPanel();
        javax.swing.JPanel jPanel6 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new ActiveLabel();
        javax.swing.JLabel jLabel4 = new ActiveLabel();
        javax.swing.JPanel jPanel5 = new javax.swing.JPanel();
        javax.swing.JPanel jPanel4 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel2 = new ActiveLabel();
        usernameT = new javax.swing.JTextField();
        javax.swing.JLabel jLabel3 = new ActiveLabel();
        passwordT = new javax.swing.JPasswordField();
        javax.swing.JPanel jPanel7 = new javax.swing.JPanel();
        errorL = new ActiveLabel();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        licenseB = new javax.swing.JButton();
        javax.swing.JPanel viewP = new javax.swing.JPanel();
        javax.swing.JLabel infoL2 = new ActiveLabel();
        javax.swing.JPanel jPanel9 = new javax.swing.JPanel();
        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        licenseT = new javax.swing.JTree();
        javax.swing.JPanel pluginP = new javax.swing.JPanel();
        javax.swing.JLabel infoL3 = new ActiveLabel();
        javax.swing.JPanel jPanel12 = new javax.swing.JPanel();
        javax.swing.JPanel jPanel14 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel5 = new ActiveLabel();
        pomT = new ActiveTextField();
        browseB = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        pluginInfoT = new ActiveTextPane();
        javax.swing.JPanel jPanel8 = new javax.swing.JPanel();
        updateB = new ActiveToggleButton("Update", null);
        viewB = new ActiveToggleButton("View", null);
        pluginB = new ActiveToggleButton("View", null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("License Manager");
        setResizable(false);

        jPanel1.setLayout(new java.awt.BorderLayout());

        cardsP.setOpaque(false);
        cardsP.setLayout(new java.awt.CardLayout());

        updateP.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 12));
        updateP.setOpaque(false);
        updateP.setLayout(new java.awt.BorderLayout());

        infoL1.setIcon(new ActiveIcon("images/licensewiz"));
        infoL1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 12, 40, 20));
        updateP.add(infoL1, java.awt.BorderLayout.WEST);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 0, 8, 0));
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.GridLayout(0, 1));

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getSize() + 1f));
        jLabel1.setText("Please provide your credentials");
        jPanel6.add(jLabel1);

        jLabel4.setFont(jLabel4.getFont().deriveFont(jLabel4.getFont().getSize() + 1f));
        jLabel4.setText(" to update license");
        jPanel6.add(jLabel4);

        jPanel3.add(jPanel6, java.awt.BorderLayout.NORTH);

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridLayout(0, 1));

        jLabel2.setText("Username");
        jPanel4.add(jLabel2);

        usernameT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usernameTKeyTyped(evt);
            }
        });
        jPanel4.add(usernameT);

        jLabel3.setText("Password");
        jPanel4.add(jLabel3);

        passwordT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordTKeyTyped(evt);
            }
        });
        jPanel4.add(passwordT);

        jPanel5.add(jPanel4, java.awt.BorderLayout.NORTH);

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.BorderLayout());

        errorL.setForeground(Theme.current().textError);
        errorL.setText(" ");
        jPanel7.add(errorL, java.awt.BorderLayout.NORTH);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        licenseB.setText(buttonLabel);
        licenseB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                licenseBActionPerformed(evt);
            }
        });
        jPanel2.add(licenseB);

        jPanel7.add(jPanel2, java.awt.BorderLayout.SOUTH);

        jPanel3.add(jPanel7, java.awt.BorderLayout.SOUTH);

        updateP.add(jPanel3, java.awt.BorderLayout.CENTER);

        cardsP.add(updateP, "update");

        viewP.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 12));
        viewP.setOpaque(false);
        viewP.setLayout(new java.awt.BorderLayout());

        infoL2.setIcon(new ActiveIcon("images/licensewiz"));
        infoL2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 12, 40, 20));
        viewP.add(infoL2, java.awt.BorderLayout.WEST);

        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 12, 0));
        jPanel9.setOpaque(false);
        jPanel9.setLayout(new java.awt.BorderLayout());

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        licenseT.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(licenseT);

        jPanel9.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        viewP.add(jPanel9, java.awt.BorderLayout.CENTER);

        cardsP.add(viewP, "view");

        pluginP.setOpaque(false);
        pluginP.setLayout(new java.awt.BorderLayout());

        infoL3.setIcon(new ActiveIcon("images/pluginfix"));
        infoL3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 12, 40, 20));
        pluginP.add(infoL3, java.awt.BorderLayout.WEST);

        jPanel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(18, 0, 12, 12));
        jPanel12.setOpaque(false);
        jPanel12.setLayout(new java.awt.BorderLayout(0, 8));

        jPanel14.setOpaque(false);
        jPanel14.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(jLabel5.getFont().deriveFont(jLabel5.getFont().getSize() + 1f));
        jLabel5.setText("Please select a plugin's pom.xml file");
        jPanel14.add(jLabel5, java.awt.BorderLayout.PAGE_START);

        pomT.setEditable(false);
        jPanel14.add(pomT, java.awt.BorderLayout.CENTER);

        browseB.setText("Browse");
        browseB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseBActionPerformed(evt);
            }
        });
        jPanel14.add(browseB, java.awt.BorderLayout.EAST);

        jPanel12.add(jPanel14, java.awt.BorderLayout.NORTH);

        jScrollPane1.setViewportView(pluginInfoT);

        jPanel12.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pluginP.add(jPanel12, java.awt.BorderLayout.CENTER);

        cardsP.add(pluginP, "plugin");

        jPanel1.add(cardsP, java.awt.BorderLayout.CENTER);

        jPanel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 16));
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 0, 4));

        viewG.add(updateB);
        updateB.setSelected(true);
        updateB.setText("Update");
        updateB.setActionCommand("update");
        updateB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeView(evt);
            }
        });
        jPanel8.add(updateB);

        viewG.add(viewB);
        viewB.setText("Licenses");
        viewB.setActionCommand("view");
        viewB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeView(evt);
            }
        });
        jPanel8.add(viewB);

        viewG.add(pluginB);
        pluginB.setText("Fix plugin");
        pluginB.setActionCommand("plugin");
        pluginB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeView(evt);
            }
        });
        jPanel8.add(pluginB);

        jPanel1.add(jPanel8, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void licenseBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_licenseBActionPerformed
        if (usernameT.isEnabled()) {
            error(null);
            String password = new String(passwordT.getPassword());
            if (usernameT.getText().contains(" "))
                error("Username should not contain spaces");
            else if (password.length() != password.trim().length())
                error("Password should not start or end with spaces");
            else if (usernameT.getText().trim().length() < 5)
                error("Too small username");
            else if (password.trim().length() < 5)
                error("Too small password");
            else
                licenseUpdate(usernameT.getText(), password);
        } else
            dispose();
    }//GEN-LAST:event_licenseBActionPerformed

    private void changeView(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeView
        ((CardLayout) cardsP.getLayout()).show(cardsP, evt.getActionCommand());
    }//GEN-LAST:event_changeView

    private void passwordTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordTKeyTyped
        if (evt.getKeyChar() == '\n' && passwordT.getPassword() != null && passwordT.getPassword().length > 3)
            licenseBActionPerformed(null);
    }//GEN-LAST:event_passwordTKeyTyped

    private void usernameTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameTKeyTyped
        if (evt.getKeyChar() == '\n' && !usernameT.getText().trim().isEmpty())
            passwordT.requestFocus();
    }//GEN-LAST:event_usernameTKeyTyped

    private void browseBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseBActionPerformed
        pluginInfoT.setText("");
        pomT.setText("");
        Collection<File> found = FileChooser.dialog("Please select a plugin pom file", "Open", false, new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().equals("pom.xml");
            }

            @Override
            public String getDescription() {
                return "POM files";
            }
        }, true);
        File pom;
        if (found.isEmpty() || !(pom = found.iterator().next()).getName().toLowerCase().equals("pom.xml"))
            return;
        pomT.setText(pom.getAbsolutePath());
        Prefs.setCurrentDir(pom.getParentFile());
        fixPomFile(pom);
    }//GEN-LAST:event_browseBActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseB;
    private javax.swing.JPanel cardsP;
    private javax.swing.JLabel errorL;
    private javax.swing.JButton licenseB;
    private javax.swing.JTree licenseT;
    private javax.swing.JPasswordField passwordT;
    private javax.swing.JToggleButton pluginB;
    private javax.swing.JTextPane pluginInfoT;
    private javax.swing.JTextField pomT;
    private javax.swing.JToggleButton updateB;
    private javax.swing.JTextField usernameT;
    private javax.swing.JToggleButton viewB;
    // End of variables declaration//GEN-END:variables

}
