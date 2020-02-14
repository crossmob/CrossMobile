/*
 * (c) 2020 by Panayotis Katsaloulis
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

import org.crossmobile.gui.ProjectFrame;
import org.crossmobile.gui.actives.ActiveButton;
import org.crossmobile.gui.actives.ActiveCheckBox;
import org.crossmobile.gui.actives.ActivePanel;
import org.crossmobile.gui.actives.ActiveTextArea;

public class SendStackTrace extends javax.swing.JDialog {

    public static ActivePanel getPanel() {
        BottomPanel bpanel = new BottomPanel("Send stack trace", "images/send", SendStackTrace::new);
        bpanel.setEnabled(false);
        return bpanel;
    }

    public static ActiveButton getButton(ProjectFrame provider) {
        ActiveButton button = new ActiveButton();
        button.setText("Send stack trace");
        button.setIcon("images/send");
        button.addActionListener(e -> new SendStackTrace(provider).setVisible(true));
        button.setEnabled(false);
        return button;
    }

    private SendStackTrace(ProjectFrame frame) {
        super(frame, true);
        initComponents();
        DebugInfo info = frame.getDebugInfo();
        outA.setText(info.output);
        errorA.setText(info.error);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundP = new GradientPanel();
        actionP = new ActivePanel();
        sendB = new javax.swing.JButton();
        componentP = new ActivePanel();
        sendInfoB = new ActiveCheckBox();
        outerrorP = new ActivePanel();
        outP = new ActivePanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outA = new ActiveTextArea();
        errorP = new ActivePanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        errorA = new ActiveTextArea();
        userP = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        userinfoA = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Send stack trace");

        backgroundP.setLayout(new java.awt.BorderLayout());

        actionP.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 12, 8, 12));
        actionP.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        sendB.setText("Send");
        sendB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBActionPerformed(evt);
            }
        });
        actionP.add(sendB);

        backgroundP.add(actionP, java.awt.BorderLayout.SOUTH);

        componentP.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 0, 12));
        componentP.setLayout(new java.awt.BorderLayout(0, 8));

        sendInfoB.setSelected(true);
        sendInfoB.setText("Send system information (strongly suggested)");
        componentP.add(sendInfoB, java.awt.BorderLayout.NORTH);

        outerrorP.setLayout(new java.awt.GridLayout(0, 2));

        outP.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Output Stream");
        outP.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        outA.setColumns(30);
        outA.setRows(15);
        jScrollPane1.setViewportView(outA);

        outP.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        outerrorP.add(outP);

        errorP.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Error Stream");
        errorP.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        errorA.setColumns(30);
        errorA.setRows(15);
        jScrollPane2.setViewportView(errorA);

        errorP.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        outerrorP.add(errorP);

        componentP.add(outerrorP, java.awt.BorderLayout.CENTER);

        userP.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("Please add any additional information");
        userP.add(jLabel3, java.awt.BorderLayout.NORTH);

        userinfoA.setColumns(20);
        userinfoA.setRows(4);
        jScrollPane3.setViewportView(userinfoA);

        userP.add(jScrollPane3, java.awt.BorderLayout.SOUTH);

        componentP.add(userP, java.awt.BorderLayout.SOUTH);

        backgroundP.add(componentP, java.awt.BorderLayout.CENTER);

        getContentPane().add(backgroundP, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBActionPerformed
        setVisible(false);
    }//GEN-LAST:event_sendBActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionP;
    private javax.swing.JPanel backgroundP;
    private javax.swing.JPanel componentP;
    private javax.swing.JTextArea errorA;
    private javax.swing.JPanel errorP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea outA;
    private javax.swing.JPanel outP;
    private javax.swing.JPanel outerrorP;
    private javax.swing.JButton sendB;
    private javax.swing.JCheckBox sendInfoB;
    private javax.swing.JPanel userP;
    private javax.swing.JTextArea userinfoA;
    // End of variables declaration//GEN-END:variables

}
