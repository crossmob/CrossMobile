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
package org.crossmobile.gui.elements;

import org.crossmobile.gui.actives.ActiveButton;
import org.crossmobile.gui.actives.ActiveIcon;
import org.crossmobile.gui.actives.ActiveLabel;
import org.crossmobile.gui.parameters.FreeTextParameter;
import org.crossmobile.utils.Dependency;
import org.crossmobile.utils.DependencyParam;
import org.crossmobile.utils.ParamList;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import static org.crossmobile.bridge.ann.CMLibParam.ParamContext.XcodeTarget;

public class DependencyEntry extends JPanel implements Comparable<DependencyEntry> {

    private Runnable deleteCallback;
    public final Dependency dependency;
    private Collection<Component> visualParams;
    private final Map<DependencyParam, FreeTextParameter> parammap = new WeakHashMap<>();

    public DependencyEntry(Dependency dep) {
        this.dependency = dep;
    }

    void init(ParamList list) {
        initComponents();
        visualParams = new ArrayList<>();
        nameL.setText(dependency.getDisplayName());
        nameL.setToolTipText(dependency.getInformation());
        for (DependencyParam param : dependency.getConfigParams()) {
            FreeTextParameter pparam = new FreeTextParameter(list, param.param) {
                @Override
                public String getVisualTag() {
                    return param.description;
                }
            };
            if (param.context == XcodeTarget)
                pparam.setTooltip("<html>In case a target is required, please provide the target name here.<br/>Otherwise no target will be created.");
            paramP.add(pparam.getVisuals().comp());
            visualParams.add(pparam.getIndentedComponent().comp());
            parammap.put(param, pparam);
        }
    }

    public void setDeleteCallback(Runnable deleteCallback) {
        this.deleteCallback = deleteCallback;
    }

    public Collection<Component> getIndentVisuals() {
        return visualParams;
    }

    public String getValue(DependencyParam param) {
        FreeTextParameter ftp = parammap.get(param);
        return ftp == null ? "" : ftp.getValue();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerP = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        documentationB = new ActiveButton();
        nameL = new ActiveLabel();
        documentationP = new javax.swing.JPanel();
        removeB = new ActiveButton();
        paramP = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, Theme.current().line));
        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        headerP.setOpaque(false);
        headerP.setLayout(new java.awt.BorderLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        documentationB.setIcon(new ActiveIcon("images/info"));
        documentationB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                documentationBActionPerformed(evt);
            }
        });
        jPanel1.add(documentationB);
        jPanel1.add(nameL);

        headerP.add(jPanel1, java.awt.BorderLayout.CENTER);

        documentationP.setOpaque(false);

        removeB.setIcon(new ActiveIcon("images/trash"));
        removeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBActionPerformed(evt);
            }
        });
        documentationP.add(removeB);

        headerP.add(documentationP, java.awt.BorderLayout.EAST);

        add(headerP, java.awt.BorderLayout.NORTH);

        paramP.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 40, 0, 0));
        paramP.setOpaque(false);
        paramP.setLayout(new javax.swing.BoxLayout(paramP, javax.swing.BoxLayout.Y_AXIS));
        add(paramP, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void removeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBActionPerformed
        if (deleteCallback != null)
            deleteCallback.run();
    }//GEN-LAST:event_removeBActionPerformed

    private void documentationBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_documentationBActionPerformed
        DependencyCreator.showInfo(this, dependency.description, dependency.url, "Plugin");
    }//GEN-LAST:event_documentationBActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton documentationB;
    private javax.swing.JPanel documentationP;
    private javax.swing.JPanel headerP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nameL;
    private javax.swing.JPanel paramP;
    private javax.swing.JButton removeB;
    // End of variables declaration//GEN-END:variables

    @Override
    public int compareTo(DependencyEntry o) {
        return dependency.getDisplayName().compareTo(o.dependency.getDisplayName());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.dependency);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final DependencyEntry other = (DependencyEntry) obj;
        return Objects.equals(this.dependency, other.dependency);
    }

}
