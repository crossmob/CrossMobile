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
package org.crossmobile.gui.init;

import com.panayotis.hrgui.HiResButton;
import com.panayotis.hrgui.HiResDialog;
import com.panayotis.hrgui.HiResIcon;
import org.crossmobile.gui.actives.ActiveCheckBox;
import org.crossmobile.gui.actives.ActiveLabel;
import org.crossmobile.gui.actives.ActiveTextPane;
import org.crossmobile.gui.elements.GradientPanel;
import org.crossmobile.gui.elements.JWait;
import org.crossmobile.gui.utils.StreamManager;
import org.crossmobile.gui.utils.StreamQuality;
import org.crossmobile.prefs.Prefs;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class InitializationWizard extends HiResDialog {

    private static final HiResIcon WAITICON = new HiResIcon("images/spin", false);

    private final Map<Card, CardAction> actions = new HashMap<>();
    private Runnable appsCallback;
    private Card currentCard = Card.Welcome;
    private final JWait waiting = new JWait(WAITICON);
    private final Collection<File> foundJDK = new LinkedHashSet<>();
    private final Collection<File> foundNetbeans = new LinkedHashSet<>();
    private final Collection<File> foundIntelliJ = new LinkedHashSet<>();
    private final Collection<File> foundStudio = new LinkedHashSet<>();
    private final Collection<File> foundAndroid = new LinkedHashSet<>();
    private final AtomicReference<File> fixedJDK = new AtomicReference<>();
    private final AtomicReference<File> fixedNetbeans = new AtomicReference<>();
    private final AtomicReference<File> fixedIntelliJ = new AtomicReference<>();
    private final AtomicReference<File> fixedStudio = new AtomicReference<>();
    private final AtomicReference<File> fixedAndroid = new AtomicReference<>();

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public InitializationWizard(Window parent) {
        super(parent, ModalityType.APPLICATION_MODAL);
        initComponents();
        jdkL.setIcon(new HiResIcon("images/wait", false));
        netbeansL.setIcon(new HiResIcon("images/wait", false));
        androidL.setIcon(new HiResIcon("images/wait", false));
        studioL.setIcon(new HiResIcon("images/wait", false));
        intellijL.setIcon(new HiResIcon("images/wait", false));
        jdkB.setVisible(false);
        androidB.setVisible(false);
        netbeansB.setVisible(false);
        intellijB.setVisible(false);
        studioB.setVisible(false);
        ((ActiveLabel) titleL).setIcon("images/logo-small", false);
        subP.add(waiting, BorderLayout.WEST);
        setLocationRelativeTo(null);
    }

    public void goToCard(Card c) {
        if (currentCard == c)
            return;
        currentCard = c;
        CardAction ca = actions.get(currentCard);
        if (ca != null) {
            if (ca.actionButton != null)
                actionB.setText(ca.actionButton);
            actionB.setEnabled(ca.action != null);
        }
        ((CardLayout) cards.getLayout()).show(cards, c.name());
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public void setMainTitle(String title) {
        titleL.setText(title);
    }

    public void setSubtitle(String subtitle) {
        subtitleL.setText(subtitle);
    }

    public void setWelcomeInfo(String info) {
        infoL.setText(info);
    }

    public void setRunning(boolean isWorking) {
        waiting.setRunning(isWorking);
        scrollLockB.setVisible(false);
    }

    public StreamManager getStreamManager() {
        return ((ActiveTextPane) detailT).getStreamManager();
    }

    public void appendText(String txt) {
        ((ActiveTextPane) detailT).addLine(txt, StreamQuality.INFO);
    }

    public void hideActionButton() {
        actionB.setVisible(false);
    }

    public void setAction(Card card, String buttonLabel, Runnable action) {
        if (card == null)
            return;
        buttonLabel = buttonLabel == null ? "" : buttonLabel;
        actions.put(card, new CardAction(action, buttonLabel));
        if (currentCard == card) {
            actionB.setText(buttonLabel);
            actionB.setEnabled(action != null);
        }
    }

    public void foundJDK(File found) {
        updateVisualsIfFound(jdkL, null, null, foundJDK, found);
    }

    public void foundNetbeans(File found) {
        updateVisualsIfFound(netbeansL, null, null, foundNetbeans, found);
    }

    public void foundIntelliJ(File found) {
        updateVisualsIfFound(intellijL, null, null, foundIntelliJ, found);
    }

    public void foundStudio(File found) {
        updateVisualsIfFound(studioL, null, null, foundStudio, found);
    }

    public void foundAndroid(File found) {
        updateVisualsIfFound(androidL, null, null, foundAndroid, found);
    }

    private boolean updateVisualsIfFound(JLabel widget, JButton resolve, AtomicReference<File> fixedRef, Collection<File> where, File found) {
        if (found != null)
            where.add(found);
        if (resolve != null && where.size() > 1)
            resolve.setVisible(true);
        boolean didFound = (fixedRef != null && fixedRef.get() != null) || where.size() == 1;
        widget.setIcon(new HiResIcon(didFound ? "images/found" : (where.isEmpty() ? "images/notfound" : "images/warning"), false));
        return didFound;
    }

    private boolean couldBeaccepted(AtomicReference<File> ref, Collection<File> col) {
        return ref.get() != null || col.size() < 2;
    }

    public void resolveApps() {
        resolveApps(null, "Continue");
    }

    public void resolveApps(Runnable appsAreResolvedCallback, String label) {
        boolean allAppsAreResolved = updateVisualsIfFound(jdkL, jdkB, fixedJDK, foundJDK, null)
                & updateVisualsIfFound(netbeansL, netbeansB, fixedNetbeans, foundNetbeans, null)
                & updateVisualsIfFound(intellijL, intellijB, fixedIntelliJ, foundIntelliJ, null)
                & updateVisualsIfFound(studioL, studioB, fixedStudio, foundStudio, null)
                & updateVisualsIfFound(androidL, androidB, fixedAndroid, foundAndroid, null);
        if (allAppsAreResolved)
            if (appsAreResolvedCallback != null) {
                appsAreResolvedCallback.run();
                return;
            }
        if (appsAreResolvedCallback != null)
            appsCallback = appsAreResolvedCallback;
        boolean couldGoOn = couldBeaccepted(fixedJDK, foundJDK)
                & couldBeaccepted(fixedNetbeans, foundNetbeans)
                & couldBeaccepted(fixedIntelliJ, foundIntelliJ)
                & couldBeaccepted(fixedStudio, foundStudio)
                & couldBeaccepted(fixedAndroid, foundAndroid);
        setAction(currentCard, label, !couldGoOn ? null : () -> {
            Prefs.setJDKLocation(resolveUnique(fixedJDK, foundJDK));
            Prefs.setAndroidSDKLocation(resolveUnique(fixedAndroid, foundAndroid));
            Prefs.setNetbeansLocation(resolveUnique(fixedNetbeans, foundNetbeans));
            Prefs.setIntelliJLocation(resolveUnique(fixedIntelliJ, foundIntelliJ));
            Prefs.setStudioLocation(resolveUnique(fixedStudio, foundStudio));
            appsCallback.run();
        });
        subtitleL.setText(couldGoOn ? (allAppsAreResolved ? "All applications have been sucessfully resolved" : "Please open Settings after initialization to solve unresolved applications.") : "Please resolve external applications");
    }

    private void popupDisplay(JButton parent, AtomicReference<File> fixedRef, Collection<File> execs) {
        execsM.removeAll();
        for (File f : execs) {
            JMenuItem m = new JMenuItem(f.getAbsolutePath());
            m.setActionCommand(f.getAbsolutePath());
            m.addActionListener(e -> {
                fixedRef.set(f);
                resolveApps();
            });
            execsM.add(m);
        }
        execsM.show(parent, -20, (int) (parent.getHeight() * 0.8));
    }

    private String resolveUnique(AtomicReference<File> ref, Collection<File> collection) {
        return ref.get() == null ? (collection.size() > 0 ? collection.iterator().next().getAbsolutePath() : null) : ref.get().getAbsolutePath();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        execsM = new javax.swing.JPopupMenu();
        jPanel4 = new GradientPanel();
        titleL = new ActiveLabel();
        mainP = new javax.swing.JPanel();
        subP = new javax.swing.JPanel();
        subtitleL = new ActiveLabel();
        cards = new javax.swing.JPanel();
        welcomeP = new javax.swing.JPanel();
        infoL = new ActiveLabel();
        externalsP = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jdkL = new ActiveLabel();
        jPanel9 = new javax.swing.JPanel();
        jdkB = new HiResButton();
        jPanel6 = new javax.swing.JPanel();
        androidL = new ActiveLabel();
        jPanel10 = new javax.swing.JPanel();
        androidB = new HiResButton();
        jPanel3 = new javax.swing.JPanel();
        netbeansL = new ActiveLabel();
        jPanel11 = new javax.swing.JPanel();
        netbeansB = new HiResButton();
        jPanel5 = new javax.swing.JPanel();
        intellijL = new ActiveLabel();
        jPanel12 = new javax.swing.JPanel();
        intellijB = new HiResButton();
        jPanel8 = new javax.swing.JPanel();
        studioL = new ActiveLabel();
        jPanel13 = new javax.swing.JPanel();
        studioB = new HiResButton();
        infoP = new javax.swing.JPanel();
        detailsButtonP = new javax.swing.JPanel();
        detailsB = new HiResButton();
        detailS = new javax.swing.JScrollPane();
        detailT = new ActiveTextPane();
        jPanel7 = new javax.swing.JPanel();
        scrollLockP = new javax.swing.JPanel();
        scrollLockB = new ActiveCheckBox();
        jPanel1 = new javax.swing.JPanel();
        actionB = new HiResButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 400));
        setResizable(false);

        jPanel4.setLayout(new java.awt.BorderLayout());

        titleL.setFont(titleL.getFont().deriveFont((float) 20));
        titleL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleL.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 0, 16, 0));
        jPanel4.add(titleL, java.awt.BorderLayout.NORTH);

        mainP.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 20));
        mainP.setOpaque(false);
        mainP.setLayout(new java.awt.BorderLayout(0, 8));

        subP.setOpaque(false);
        subP.setLayout(new java.awt.BorderLayout(4, 0));
        subP.add(subtitleL, java.awt.BorderLayout.CENTER);

        mainP.add(subP, java.awt.BorderLayout.NORTH);

        cards.setOpaque(false);
        cards.setLayout(new java.awt.CardLayout());

        welcomeP.setOpaque(false);
        welcomeP.setLayout(new java.awt.BorderLayout());

        infoL.setFont(infoL.getFont().deriveFont((infoL.getFont().getStyle() | java.awt.Font.ITALIC)));
        welcomeP.add(infoL, java.awt.BorderLayout.NORTH);

        cards.add(welcomeP, "Welcome");

        externalsP.setOpaque(false);
        externalsP.setLayout(new javax.swing.BoxLayout(externalsP, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        jdkL.setText("Java Development Environment");
        jdkL.setIconTextGap(8);
        jPanel2.add(jdkL, java.awt.BorderLayout.WEST);

        jPanel9.setOpaque(false);
        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 0, 0));

        jdkB.setText("Choose");
        jdkB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdkBActionPerformed(evt);
            }
        });
        jPanel9.add(jdkB);

        jPanel2.add(jPanel9, java.awt.BorderLayout.EAST);

        externalsP.add(jPanel2);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.BorderLayout());

        androidL.setText("Android SDK");
        androidL.setIconTextGap(8);
        jPanel6.add(androidL, java.awt.BorderLayout.WEST);

        jPanel10.setOpaque(false);
        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        androidB.setText("Choose");
        androidB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                androidBActionPerformed(evt);
            }
        });
        jPanel10.add(androidB);

        jPanel6.add(jPanel10, java.awt.BorderLayout.EAST);

        externalsP.add(jPanel6);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.BorderLayout());

        netbeansL.setText("Netbeans");
        netbeansL.setIconTextGap(8);
        jPanel3.add(netbeansL, java.awt.BorderLayout.WEST);

        jPanel11.setOpaque(false);
        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        netbeansB.setText("Choose");
        netbeansB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                netbeansBActionPerformed(evt);
            }
        });
        jPanel11.add(netbeansB);

        jPanel3.add(jPanel11, java.awt.BorderLayout.EAST);

        externalsP.add(jPanel3);

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.BorderLayout());

        intellijL.setText("IntelliJ Idea");
        intellijL.setIconTextGap(8);
        jPanel5.add(intellijL, java.awt.BorderLayout.WEST);

        jPanel12.setOpaque(false);
        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        intellijB.setText("Choose");
        intellijB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intellijBActionPerformed(evt);
            }
        });
        jPanel12.add(intellijB);

        jPanel5.add(jPanel12, java.awt.BorderLayout.EAST);

        externalsP.add(jPanel5);

        jPanel8.setOpaque(false);
        jPanel8.setLayout(new java.awt.BorderLayout());

        studioL.setText("Android Studio");
        studioL.setIconTextGap(8);
        jPanel8.add(studioL, java.awt.BorderLayout.WEST);

        jPanel13.setOpaque(false);
        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        studioB.setText("Choose");
        studioB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studioBActionPerformed(evt);
            }
        });
        jPanel13.add(studioB);

        jPanel8.add(jPanel13, java.awt.BorderLayout.EAST);

        externalsP.add(jPanel8);

        cards.add(externalsP, "Externals");

        infoP.setOpaque(false);
        infoP.setLayout(new java.awt.BorderLayout());

        detailsButtonP.setOpaque(false);
        detailsButtonP.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        detailsB.setText("Details");
        detailsB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsBActionPerformed(evt);
            }
        });
        detailsButtonP.add(detailsB);

        infoP.add(detailsButtonP, java.awt.BorderLayout.CENTER);

        cards.add(infoP, "Info");

        detailT.setEditable(false);
        detailS.setViewportView(detailT);

        cards.add(detailS, "Details");

        mainP.add(cards, java.awt.BorderLayout.CENTER);

        jPanel4.add(mainP, java.awt.BorderLayout.CENTER);

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.BorderLayout());

        scrollLockP.setOpaque(false);

        scrollLockB.setText("Pause scrolling");
        scrollLockB.setOpaque(false);
        scrollLockB.setVisible(false);
        scrollLockB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scrollLockBActionPerformed(evt);
            }
        });
        scrollLockP.add(scrollLockB);

        jPanel7.add(scrollLockP, java.awt.BorderLayout.WEST);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 0, 12, 8));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        actionB.setText("Cancel");
        actionB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionBActionPerformed(evt);
            }
        });
        jPanel1.add(actionB);

        jPanel7.add(jPanel1, java.awt.BorderLayout.EAST);

        jPanel4.add(jPanel7, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void detailsBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsBActionPerformed
        goToCard(Card.Details);
        scrollLockB.setVisible(true);
    }//GEN-LAST:event_detailsBActionPerformed

    private void actionBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionBActionPerformed
        CardAction action = actions.get(currentCard);
        if (action != null && action.action != null)
            action.action.run();
    }//GEN-LAST:event_actionBActionPerformed

    private void jdkBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdkBActionPerformed
        popupDisplay(jdkB, fixedJDK, foundJDK);
    }//GEN-LAST:event_jdkBActionPerformed

    private void androidBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_androidBActionPerformed
        popupDisplay(androidB, fixedAndroid, foundAndroid);
    }//GEN-LAST:event_androidBActionPerformed

    private void netbeansBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_netbeansBActionPerformed
        popupDisplay(netbeansB, fixedNetbeans, foundNetbeans);
    }//GEN-LAST:event_netbeansBActionPerformed

    private void intellijBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intellijBActionPerformed
        popupDisplay(intellijB, fixedIntelliJ, foundIntelliJ);
    }//GEN-LAST:event_intellijBActionPerformed

    private void studioBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studioBActionPerformed
        popupDisplay(studioB, fixedStudio, foundStudio);
    }//GEN-LAST:event_studioBActionPerformed

    private void scrollLockBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scrollLockBActionPerformed
        ((ActiveTextPane) detailT).setShouldMoveToBottom(!scrollLockB.isSelected());
    }//GEN-LAST:event_scrollLockBActionPerformed

    public static enum Card {
        Welcome,
        Externals,
        Info,
        Details
    }

    private static final class CardAction {

        private final Runnable action;
        private final String actionButton;

        public CardAction(Runnable action, String actionButton) {
            this.action = action;
            this.actionButton = actionButton;
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actionB;
    private javax.swing.JButton androidB;
    private javax.swing.JLabel androidL;
    private javax.swing.JPanel cards;
    private javax.swing.JScrollPane detailS;
    private javax.swing.JTextPane detailT;
    private javax.swing.JButton detailsB;
    private javax.swing.JPanel detailsButtonP;
    private javax.swing.JPopupMenu execsM;
    private javax.swing.JPanel externalsP;
    private javax.swing.JLabel infoL;
    private javax.swing.JPanel infoP;
    private javax.swing.JButton intellijB;
    private javax.swing.JLabel intellijL;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jdkB;
    private javax.swing.JLabel jdkL;
    private javax.swing.JPanel mainP;
    private javax.swing.JButton netbeansB;
    private javax.swing.JLabel netbeansL;
    private javax.swing.JCheckBox scrollLockB;
    private javax.swing.JPanel scrollLockP;
    private javax.swing.JButton studioB;
    private javax.swing.JLabel studioL;
    private javax.swing.JPanel subP;
    private javax.swing.JLabel subtitleL;
    private javax.swing.JLabel titleL;
    private javax.swing.JPanel welcomeP;
    // End of variables declaration//GEN-END:variables

}
