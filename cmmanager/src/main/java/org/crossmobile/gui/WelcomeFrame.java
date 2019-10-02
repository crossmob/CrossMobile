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

import com.panayotis.appenh.AFileChooser;
import com.panayotis.appenh.EnhancerManager;
import com.panayotis.hrgui.HiResEmptyBorder;
import com.panayotis.hrgui.HiResIcon;
import com.panayotis.hrgui.HiResMatteBorder;
import com.panayotis.hrgui.ScreenUtils;
import com.panayotis.jupidator.UpdatedApplication;
import org.crossmobile.Version;
import org.crossmobile.gui.actives.ActiveButton;
import org.crossmobile.gui.actives.ActiveIcon;
import org.crossmobile.gui.actives.ActiveLabel;
import org.crossmobile.gui.actives.ActiveList;
import org.crossmobile.gui.elements.*;
import org.crossmobile.gui.lic.LicenseDialog;
import org.crossmobile.gui.project.ProjectInfo;
import org.crossmobile.gui.project.ProjectListModel;
import org.crossmobile.gui.project.ProjectLoader;
import org.crossmobile.gui.project.RecentsProjectManager;
import org.crossmobile.gui.utils.Paths;
import org.crossmobile.gui.utils.Paths.HomeReference;
import org.crossmobile.prefs.Prefs;
import org.crossmobile.utils.Log;
import org.crossmobile.utils.ProjectException;

import javax.swing.*;
import javax.swing.JPopupMenu.Separator;
import javax.swing.border.CompoundBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Collection;

import static com.panayotis.appenh.AFileChooser.FileSelectionMode.FilesAndDirectories;

public class WelcomeFrame extends RegisteredFrame implements UpdatedApplication {

    private static final AFileChooser afc = new AFileChooser().setDirectory(Prefs.getCurrentDir()).setMode(FilesAndDirectories);

    private ProjectListModel projlist;
    private boolean textualVersion = true;

    static {
        ScreenUtils.setTint(Theme.current().icontop, Theme.current().iconbottom);
    }

    @SuppressWarnings({"unchecked", "LeakingThisInConstructor", "OverridableMethodCallInConstructor"})
    public WelcomeFrame() {
        initComponents();
        updateVersion();
        ProjectsL.setCellRenderer(new CustomListRenderer());
        EnhancerManager.getDefault().updateFrameIcons(this);
        licenseB.setVisible(Prefs.CHECK_LICENSE);
        setSize(640, 520);
        setLocationRelativeTo(null);
        ProjectsL.setTransferHandler(new DnDFileHandler(this::addProjectSilently));
        setEnabled(false);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        ProjectsL.setEnabled(enabled);
        licenseB.setEnabled(enabled);
        newProjectB.setEnabled(enabled);
        openProjectB.setEnabled(enabled);
        settingsB.setEnabled(enabled);
        aboutB.setEnabled(enabled);
        openB.setEnabled(enabled);
        clearAllB.setEnabled(enabled);
    }

    public final void updateProjects(ProjectInfo defaultProject) {
        if (!isEnabled())
            setEnabled(true);
        if (projlist == null) {
            projlist = new ProjectListModel();
            ProjectsL.setModel(projlist);
        } else
            projlist.reload();
        if (defaultProject == null)
            ProjectsL.setSelectedIndex(0);
        else {
            RecentsProjectManager.addProject(defaultProject, false);
            ProjectsL.setSelectedIndex(projlist.getIndex(defaultProject));
            repaint();
        }
    }

    private void showProject(int index) {
        if (index >= 0 && index < projlist.getSize())
            ProjectLoader.showProject(projlist.getElementAt(index), this);
    }

    @Override
    public boolean requestRestart() {
        return true;
    }

    @Override
    public void receiveMessage(String message) {
        Log.debug(message);
    }

    public int getIndexFromPoint(Point p) {
        if (p != null) {
            Rectangle r = ProjectsL.getCellBounds(0, ProjectsL.getLastVisibleIndex());
            if (r != null && r.contains(p))
                return ProjectsL.locationToIndex(p);
        }
        return -1;
    }

    private void updateVersion() {
        versionL.setText(textualVersion ? "version " + Version.VERSION + " " : "release " + Version.RELEASE + " ");
    }

    private void addProjectSilently(File file) {
        try {
            addProject(file);
        } catch (ProjectException ignored) {
        }
    }

    private void addProjectWithMessage(File file) {
        try {
            addProject(file);
        } catch (ProjectException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error while opening project", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addProject(File file) throws ProjectException {
        ProjectLoader.showProject(ProjectInfo.load(file.getAbsolutePath()), this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        itemPopUp = new JPopupMenu();
        openM = new JMenuItem();
        jSeparator1 = new Separator();
        removeM = new JMenuItem();
        Background = new GradientPanel();
        jPanel3 = new JPanel();
        ProjectsSP = new JScrollPane();
        ProjectsL = new ActiveList();
        jLabel2 = new ActiveLabel();
        jPanel10 = new JPanel();
        openB = new ActiveButton();
        clearAllB = new ActiveButton();
        jPanel8 = new JPanel();
        jPanel4 = new JPanel();
        jPanel1 = new JPanel();
        jLabel3 = new ActiveLabel();
        jLabel4 = new ActiveLabel();
        versionL = new ActiveLabel();
        jLabel1 = new ActiveLabel();
        jPanel5 = new JPanel();
        jPanel2 = new JPanel();
        licenseB = new ActiveButton();
        jPanel7 = new JPanel();
        newProjectB = new ActiveButton();
        openProjectB = new ActiveButton();
        jPanel9 = new JPanel();
        settingsB = new ActiveButton();
        aboutB = new ActiveButton();

        openM.setText("Open project");
        openM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                openMActionPerformed(evt);
            }
        });
        itemPopUp.add(openM);
        itemPopUp.add(jSeparator1);

        removeM.setText("Remove from list");
        removeM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                removeMActionPerformed(evt);
            }
        });
        itemPopUp.add(removeM);

        setTitle("CrossMobile Manager");
        setMinimumSize(new Dimension(640, 408));

        Background.setLayout(new BorderLayout());

        jPanel3.setBorder(new HiResEmptyBorder(2, 2, 2, 24));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new BorderLayout(0, 2));

        ProjectsSP.setMinimumSize(new Dimension(260, 400));
        ProjectsSP.setPreferredSize(ProjectsSP.getMinimumSize());

        ProjectsL.setFont(ProjectsL.getFont().deriveFont(ProjectsL.getFont().getSize() + 1f));
        ProjectsL.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ProjectsLMouseClicked(evt);
            }
        });
        ProjectsL.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {
                ProjectsLValueChanged(evt);
            }
        });
        ProjectsSP.setViewportView(ProjectsL);

        jPanel3.add(ProjectsSP, BorderLayout.CENTER);

        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel2.setText("Recent Projects  ");
        jLabel2.setBorder(new HiResEmptyBorder(4, 0, 4, 0));
        jPanel3.add(jLabel2, BorderLayout.NORTH);

        jPanel10.setOpaque(false);
        jPanel10.setLayout(new FlowLayout(FlowLayout.RIGHT));

        openB.setIcon(new ActiveIcon("images/arrow"));
        openB.setText("Open");
        openB.setEnabled(false);
        openB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                openBActionPerformed(evt);
            }
        });
        jPanel10.add(openB);

        clearAllB.setIcon(new ActiveIcon("images/trash"));
        clearAllB.setText("Clear all");
        clearAllB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                clearAllBActionPerformed(evt);
            }
        });
        jPanel10.add(clearAllB);

        jPanel3.add(jPanel10, BorderLayout.SOUTH);

        Background.add(jPanel3, BorderLayout.CENTER);

        jPanel8.setBorder(new HiResEmptyBorder(16, 8, 8, 4));
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new BorderLayout());

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new BorderLayout(0, 2));

        jPanel1.setBorder(BorderFactory.createEmptyBorder(0, 0, 12, 0));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new GridLayout(0, 1));

        jLabel3.setFont(jLabel3.getFont().deriveFont(jLabel3.getFont().getStyle() | Font.BOLD, jLabel3.getFont().getSize() + 15));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("Welcome to");
        jPanel1.add(jLabel3);

        jLabel4.setFont(jLabel4.getFont().deriveFont(jLabel4.getFont().getStyle() | Font.BOLD, jLabel4.getFont().getSize() + 15));
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setText("CrossMobile");
        jPanel1.add(jLabel4);

        jPanel4.add(jPanel1, BorderLayout.NORTH);

        versionL.setFont(versionL.getFont().deriveFont((versionL.getFont().getStyle() | Font.ITALIC), versionL.getFont().getSize() - 1));
        versionL.setHorizontalAlignment(SwingConstants.CENTER);
        versionL.setText("release");
        versionL.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                versionLMousePressed(evt);
            }
        });
        jPanel4.add(versionL, BorderLayout.SOUTH);

        jPanel8.add(jPanel4, BorderLayout.NORTH);

        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setIcon(new HiResIcon("images/logo", false));
        jLabel1.setBorder(new HiResEmptyBorder(16, 0, 30, 0));
        jPanel8.add(jLabel1, BorderLayout.CENTER);

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new BoxLayout(jPanel5, BoxLayout.Y_AXIS));

        jPanel2.setOpaque(false);

        licenseB.setIcon(new ActiveIcon("images/license"));
        licenseB.setText("Licenses & tools");
        licenseB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                licenseBActionPerformed(evt);
            }
        });
        jPanel2.add(licenseB);

        jPanel5.add(jPanel2);

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new GridLayout(0, 2, 0, 8));

        newProjectB.setIcon(new ActiveIcon("images/new"));
        newProjectB.setText("New Project");
        newProjectB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newProjectBActionPerformed(evt);
            }
        });
        jPanel7.add(newProjectB);

        openProjectB.setIcon(new ActiveIcon("images/open"));
        openProjectB.setText("Open Project");
        openProjectB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                openProjectBActionPerformed(evt);
            }
        });
        jPanel7.add(openProjectB);

        jPanel5.add(jPanel7);

        jPanel9.setOpaque(false);
        jPanel9.setLayout(new GridLayout(0, 2, 0, 8));

        settingsB.setIcon(new ActiveIcon("images/configure"));
        settingsB.setText("Settings");
        settingsB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                settingsBActionPerformed(evt);
            }
        });
        jPanel9.add(settingsB);

        aboutB.setIcon(new ActiveIcon("images/help"));
        aboutB.setText("About");
        aboutB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                aboutBActionPerformed(evt);
            }
        });
        jPanel9.add(aboutB);

        jPanel5.add(jPanel9);

        jPanel8.add(jPanel5, BorderLayout.SOUTH);

        Background.add(jPanel8, BorderLayout.WEST);

        getContentPane().add(Background, BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void newProjectBActionPerformed(ActionEvent evt) {//GEN-FIRST:event_newProjectBActionPerformed
        try {
            NewProjectInfo projectInfo = new NewProjectInfo();
            projectInfo.setVisible(true);
            if (projectInfo.getProjectPath() != null)
                ProjectLoader.showProject(ProjectInfo.create(projectInfo.getProjectPath().getAbsolutePath(), projectInfo), this);
        } catch (ProjectException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error while opening project", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_newProjectBActionPerformed

    private void ProjectsLValueChanged(ListSelectionEvent evt) {//GEN-FIRST:event_ProjectsLValueChanged
        openB.setEnabled(true);
    }//GEN-LAST:event_ProjectsLValueChanged

    private void openProjectBActionPerformed(ActionEvent evt) {//GEN-FIRST:event_openProjectBActionPerformed
        Collection<File> result = afc.setDirectory(Prefs.getCurrentDir()).openMulti();
        for (File selected : result) {
            addProjectWithMessage(selected);
            Prefs.setCurrentDir(selected.getParentFile());
        }
    }//GEN-LAST:event_openProjectBActionPerformed

    private void openBActionPerformed(ActionEvent evt) {//GEN-FIRST:event_openBActionPerformed
        showProject(ProjectsL.getSelectedIndex());
    }//GEN-LAST:event_openBActionPerformed

    private void ProjectsLMouseClicked(MouseEvent evt) {//GEN-FIRST:event_ProjectsLMouseClicked
        if (!ProjectsL.isEnabled())
            return;
        int sel = getIndexFromPoint(evt.getPoint());
        if (evt.getButton() == MouseEvent.BUTTON3 && evt.getClickCount() == 1) {
            if (sel >= 0 && sel < projlist.getSize()) {
                ProjectsL.setSelectedIndex(sel);
                itemPopUp.show(evt.getComponent(), evt.getX() - 10, evt.getY() - 10);
            }
        } else if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2)
            showProject(sel);
    }//GEN-LAST:event_ProjectsLMouseClicked

    private void clearAllBActionPerformed(ActionEvent evt) {//GEN-FIRST:event_clearAllBActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Do you really want to clear all recent projects?", "Clear projects", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE)
                == JOptionPane.OK_OPTION) {
            RecentsProjectManager.clearProjects();
            updateProjects(null);
        }
    }//GEN-LAST:event_clearAllBActionPerformed

    private void aboutBActionPerformed(ActionEvent evt) {//GEN-FIRST:event_aboutBActionPerformed
        About.showAbout();
    }//GEN-LAST:event_aboutBActionPerformed

    private void settingsBActionPerformed(ActionEvent evt) {//GEN-FIRST:event_settingsBActionPerformed
        Config.showConfig();
    }//GEN-LAST:event_settingsBActionPerformed

    private void openMActionPerformed(ActionEvent evt) {//GEN-FIRST:event_openMActionPerformed
        showProject(ProjectsL.getSelectedIndex());
    }//GEN-LAST:event_openMActionPerformed

    private void removeMActionPerformed(ActionEvent evt) {//GEN-FIRST:event_removeMActionPerformed
        int index = ProjectsL.getSelectedIndex();
        if (index >= 0 && index < projlist.getSize()) {
            RecentsProjectManager.deleteProject(projlist.getElementAt(index));
            updateProjects(null);
        }
    }//GEN-LAST:event_removeMActionPerformed

    private void versionLMousePressed(MouseEvent evt) {//GEN-FIRST:event_versionLMousePressed
        if (evt.getButton() == MouseEvent.BUTTON1) {
            textualVersion = !textualVersion;
            updateVersion();
        }
    }//GEN-LAST:event_versionLMousePressed

    private void licenseBActionPerformed(ActionEvent evt) {//GEN-FIRST:event_licenseBActionPerformed
        new LicenseDialog(this).setVisible(true);
    }//GEN-LAST:event_licenseBActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JPanel Background;
    public JList ProjectsL;
    private JScrollPane ProjectsSP;
    private JButton aboutB;
    private JButton clearAllB;
    private JPopupMenu itemPopUp;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JPanel jPanel10;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private Separator jSeparator1;
    private JButton licenseB;
    private JButton newProjectB;
    private JButton openB;
    private JMenuItem openM;
    private JButton openProjectB;
    private JMenuItem removeM;
    private JButton settingsB;
    private JLabel versionL;
    // End of variables declaration//GEN-END:variables

}

final class CustomListRenderer implements ListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object item, int index, boolean isSelected, boolean cellHasFocus) {
        JPanel CellRenderer = new JPanel();
        JPanel TextPart = new JPanel();
        ActiveLabel icon = new ActiveLabel();
        ActiveLabel name = new ActiveLabel();
        ActiveLabel location = new ActiveLabel();
        Font font = list.getFont();
        ProjectInfo value = (ProjectInfo) item;

        icon.setIcon(value.getIcon());
        icon.setBorder(new HiResEmptyBorder(4, 4, 4, 8));

        name.setText(value.getName());
        name.setEnabled(list.isEnabled());
        name.setForeground(isSelected ? Theme.current().textSelCell : Theme.current().text);
        name.setFont(font);

        location.setText(Paths.getPath(value.getPath(), HomeReference.PATH_STYLE));
        location.setEnabled(list.isEnabled());
        location.setFont(font.deriveFont(font.getSize() - 1f).deriveFont(Font.ITALIC));
        location.setForeground(isSelected ? Theme.current().infoSelCell : Theme.current().subinfo);

        TextPart.setOpaque(false);
        TextPart.setLayout(new BorderLayout());
        TextPart.add(name, BorderLayout.CENTER);
        TextPart.add(location, BorderLayout.SOUTH);

        CellRenderer.setLayout(new BorderLayout());
        CellRenderer.setBorder(new CompoundBorder(new HiResMatteBorder(0, 0, 1, 0, Theme.current().tableLine), new HiResEmptyBorder(3, 2, 3, 2)));
        CellRenderer.setBackground(isSelected ? Theme.current().backCellSelected : Theme.current().backCell);
        CellRenderer.add(icon, BorderLayout.WEST);
        CellRenderer.add(TextPart, BorderLayout.CENTER);
        return CellRenderer;
    }
}
