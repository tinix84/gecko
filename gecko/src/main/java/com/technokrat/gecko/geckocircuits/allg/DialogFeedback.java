/*  This file is part of GeckoCIRCUITS. Copyright (C) ETH Zurich, Gecko-Simulations AG
 *
 *  GeckoCIRCUITS is free software: you can redistribute it and/or modify it under 
 *  the terms of the GNU General Public License as published by the Free Software 
 *  Foundation, either version 3 of the License, or (at your option) any later version.
 *
 *  GeckoCIRCUITS is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 *  PURPOSE.  See the GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along with
 *  GeckoCIRCUITS.  If not, see <http://www.gnu.org/licenses/>.
 */
/*
 * DialogFeedback.java
 *
 * Created on 21.01.2011, 10:31:33
 */
package gecko.geckocircuits.allg;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DialogFeedback extends javax.swing.JDialog {

    private static final String BUGZILLA_URL = "www.bugs.gecko-simulations.org";
    
    public DialogFeedback(final JFrame parentFrame) {
        super(parentFrame, true);
        try {
            this.setIconImage(new ImageIcon(new URL(GlobalFilePathes.PFAD_PICS_URL, "gecko.gif")).getImage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.setTitle("Gecko-Simulations Bug-Reporting / Feedback");
        initComponents();
        this.setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    //CHECKSTYLE:OFF
    @SuppressWarnings("PMD")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonClose = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabelURL = new javax.swing.JLabel();
        jButtonLaunch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jButtonClose.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButtonClose.setText("Close Window");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("<html>We want to improve our software! If you would like to submit a bug-report, <br>give us suggestions about features that we should implement in the software, <br>or you have other issues, then please visit our bugtracking homepage:");

        jLabelURL.setText("<html><a href=\"www.bugs.gecko-simulations.org\">www.bugs.gecko-simulations.org</a></html>");
        jLabelURL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelURLMouseClicked(evt);
            }
        });

        jButtonLaunch.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButtonLaunch.setText("Launch Browser");
        jButtonLaunch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLaunchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLaunch, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelURL, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClose)
                    .addComponent(jButtonLaunch))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //CHECKSTYLE:ON
    
    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//NOPMD//GEN-FIRST:event_jButtonCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonLaunchActionPerformed(java.awt.event.ActionEvent evt) {//NOPMD//GEN-FIRST:event_jButtonLaunchActionPerformed
        LaunchBrowser.launch(BUGZILLA_URL);
    }//GEN-LAST:event_jButtonLaunchActionPerformed

    private void jLabelURLMouseClicked(java.awt.event.MouseEvent evt) {//NOPMD//GEN-FIRST:event_jLabelURLMouseClicked
        LaunchBrowser.launch(BUGZILLA_URL);
    }//GEN-LAST:event_jLabelURLMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonLaunch;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelURL;
    // End of variables declaration//GEN-END:variables
}
