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
package org.crossmobile.gui;

import org.crossmobile.gui.actives.ActiveCheckBox;
import org.crossmobile.gui.actives.ActiveLabel;
import org.crossmobile.gui.elements.GradientPanel;
import org.robovm.objc.block.VoidBlock1;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class LongProcFrame extends JDialog implements VoidBlock1<String> {

    private Consumer<Boolean> executeCallback;
    private final String workingText;
    private Runnable cancelCallback;
    private boolean hasStarted = false;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public LongProcFrame(String title, String welcomeText, String optionText, String workingText) {
        super((Frame) null, true);
        this.workingText = workingText;
        initComponents();
        setTitle(title);
        progressBar.setVisible(false);
        toggleC.setText(optionText);
        updateText(welcomeText);
        setSize(380, 200);
        setLocationRelativeTo(null);
    }

    public void setExecuteCallback(Consumer<Boolean> executeCallback) {
        this.executeCallback = executeCallback;
    }

    public void setCancelCallback(Runnable cancelCallback) {
        this.cancelCallback = cancelCallback;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundP = new GradientPanel();
        mainP = new javax.swing.JPanel();
        feedbackL = new ActiveLabel();
        jPanel1 = new javax.swing.JPanel();
        progressBar = new javax.swing.JProgressBar();
        toggleC = new ActiveCheckBox();
        buttonP = new javax.swing.JPanel();
        cancelB = new javax.swing.JButton();
        actionB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        backgroundP.setLayout(new java.awt.BorderLayout());

        mainP.setBorder(new com.panayotis.hrgui.HiResEmptyBorder(12,12,8,12));
        mainP.setOpaque(false);
        mainP.setLayout(new java.awt.BorderLayout());

        feedbackL.setBorder(new com.panayotis.hrgui.HiResEmptyBorder(0,0,8,0));
        mainP.add(feedbackL, java.awt.BorderLayout.CENTER);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout(0, 8));

        progressBar.setIndeterminate(true);
        jPanel1.add(progressBar, java.awt.BorderLayout.CENTER);

        toggleC.setSelected(true);
        jPanel1.add(toggleC, java.awt.BorderLayout.SOUTH);

        mainP.add(jPanel1, java.awt.BorderLayout.SOUTH);

        backgroundP.add(mainP, java.awt.BorderLayout.CENTER);

        buttonP.setMaximumSize(new java.awt.Dimension(500, 300));
        buttonP.setMinimumSize(new java.awt.Dimension(500, 300));
        buttonP.setOpaque(false);
        buttonP.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        cancelB.setText("Cancel");
        cancelB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBActionPerformed(evt);
            }
        });
        buttonP.add(cancelB);

        actionB.setText("Continue");
        actionB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionBActionPerformed(evt);
            }
        });
        buttonP.add(actionB);

        backgroundP.add(buttonP, java.awt.BorderLayout.SOUTH);

        getContentPane().add(backgroundP, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actionBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionBActionPerformed
        actionB.setEnabled(false);
        if (hasStarted)
            setVisible(false);
        else {
            toggleC.setEnabled(false);
            progressBar.setVisible(true);
            hasStarted = true;
            updateText(workingText);
            executeCallback.accept(toggleC.isSelected());
        }
    }//GEN-LAST:event_actionBActionPerformed

    private void cancelBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBActionPerformed
        if (hasStarted)
            cancelCallback.run();
        setVisible(false);
    }//GEN-LAST:event_cancelBActionPerformed

    @Override
    public void setVisible(boolean status) {
        if (!status)
            dispose();
        super.setVisible(status);
    }

    private void updateText(String message) {
        feedbackL.setText("<html>" + message + "</html>");
    }

    @Override
    public void invoke(String message) {
        updateText(message);
        progressBar.setVisible(false);
        actionB.setText("Close");
        actionB.setEnabled(true);
        cancelB.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actionB;
    private javax.swing.JPanel backgroundP;
    private javax.swing.JPanel buttonP;
    private javax.swing.JButton cancelB;
    private javax.swing.JLabel feedbackL;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mainP;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JCheckBox toggleC;
    // End of variables declaration//GEN-END:variables

}
