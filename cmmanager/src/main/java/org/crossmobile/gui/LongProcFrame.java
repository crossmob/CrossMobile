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
package org.crossmobile.gui;

import org.crossmobile.gui.actives.ActiveCheckBox;
import org.crossmobile.gui.actives.ActiveLabel;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.function.Consumer;

public class LongProcFrame<S extends Enum, T> extends JDialog implements LongProcListener<S, T> {

    private Collection<T> success;
    private Consumer<Boolean> asynchronousFunction;
    private Runnable errorAction;
    private String errorButtonLabel;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public LongProcFrame(String title) {
        super((Frame) null, true);
        initComponents();
        setTitle(title);
        progressBar.setVisible(false);
        setSize(380, 200);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonP = new javax.swing.JPanel();
        actionB = new javax.swing.JButton();
        cancelB = new javax.swing.JButton();
        mainP = new javax.swing.JPanel();
        feedbackL = new ActiveLabel();
        jPanel1 = new javax.swing.JPanel();
        progressBar = new javax.swing.JProgressBar();
        toggleC = new ActiveCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        buttonP.setMaximumSize(new java.awt.Dimension(500, 300));
        buttonP.setMinimumSize(new java.awt.Dimension(500, 300));
        buttonP.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        actionB.setText("Continue");
        actionB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionBActionPerformed(evt);
            }
        });
        buttonP.add(actionB);

        cancelB.setText("Cancel");
        cancelB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBActionPerformed(evt);
            }
        });
        buttonP.add(cancelB);

        getContentPane().add(buttonP, java.awt.BorderLayout.SOUTH);

        mainP.setBorder(new com.panayotis.hrgui.HiResEmptyBorder(12, 12, 8, 12));
        mainP.setLayout(new java.awt.BorderLayout());

        feedbackL.setBorder(new com.panayotis.hrgui.HiResEmptyBorder(0, 0, 8, 0));
        mainP.add(feedbackL, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.BorderLayout(0, 8));
        jPanel1.add(progressBar, java.awt.BorderLayout.CENTER);

        toggleC.setSelected(true);
        jPanel1.add(toggleC, java.awt.BorderLayout.SOUTH);

        mainP.add(jPanel1, java.awt.BorderLayout.SOUTH);

        getContentPane().add(mainP, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actionBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionBActionPerformed
        if (success != null)
            setVisible(false);
        else {
            cancelB.setEnabled(false);
            actionB.setEnabled(false);
            toggleC.setEnabled(false);
            actionB.setText("Processing");
            if (errorAction != null)
                errorAction.run();
            else {
                progressBar.setVisible(true);
                if (asynchronousFunction != null)
                    new Thread() {
                        @Override
                        public void run() {
                            try {
                                asynchronousFunction.accept(toggleC.isSelected());
                            } catch (Exception ex) {
                                error(ex.getMessage());
                            }
                        }
                    }.start();
            }
        }
    }//GEN-LAST:event_actionBActionPerformed

    private void cancelBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBActionPerformed
        success = null;
        setVisible(false);
    }//GEN-LAST:event_cancelBActionPerformed

    @Override
    public void setVisible(boolean status) {
        if (!status)
            dispose();
        super.setVisible(status);
    }

    public LongProcFrame<S, T> setLastStep(Enum e) {
        progressBar.setMaximum(e.ordinal());
        return this;
    }

    public LongProcFrame<S, T> setToogleText(String text) {
        if (text == null || text.isEmpty())
            toggleC.setVisible(false);
        else {
            toggleC.setVisible(true);
            toggleC.setText(text);
        }
        return this;
    }

    public LongProcFrame<S, T> setWelcomeText(String text) {
        feedbackL.setText("<html>" + text + "</html>");
        return this;
    }

    public LongProcFrame<S, T> setAsynchronousFunction(Consumer<Boolean> asynchronousFunction) {
        this.asynchronousFunction = asynchronousFunction;
        return this;
    }

    @Override
    public void update(S level) {
        progressBar.setValue(level.ordinal());
        feedbackL.setText("<html>" + level.toString() + "</html>");
    }

    @Override
    public void error(String message) {
        feedbackL.setText("<html>" + message + "</html>");
        toggleC.setEnabled(true);
        resetVisuals(errorButtonLabel == null ? "Start again" : errorButtonLabel);
    }

    @Override
    public void success(Collection<T> result) {
        success = result;
        resetVisuals("Finish");
    }

    @Override
    public void setErrorCallback(String label, Runnable action) {
        this.errorButtonLabel = label;
        this.errorAction = action;
    }

    private void resetVisuals(String actionText) {
        actionB.setText(actionText);
        actionB.setEnabled(true);
        cancelB.setEnabled(true);
        progressBar.setVisible(false);
    }

    public Collection<T> getSuccessList() {
        return success;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actionB;
    private javax.swing.JPanel buttonP;
    private javax.swing.JButton cancelB;
    private javax.swing.JLabel feedbackL;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mainP;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JCheckBox toggleC;
    // End of variables declaration//GEN-END:variables

}
