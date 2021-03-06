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
package ch.technokrat.gecko.geckocircuits.allg;

import ch.technokrat.gecko.GeckoSim;

public class DialogUpdateSettings extends javax.swing.JFrame {
    
    public DialogUpdateSettings() {
        initComponents();        
        this.setVisible(true);
        
        String updateFreq = GeckoSim.applicationProps.getProperty("UPDATE_FREQ", "NEVER");
        
        if(updateFreq.equals("NEVER")) {
            jRadioButtonNever.setSelected(true);
        }
        
        if(updateFreq.equals("DAILY")) {
            jRadioButtonDaily.setSelected(true);
        }
        
        if(updateFreq.equals("WEEKLY")) {
            jRadioButtonWeekly.setSelected(true);
        }
        
        String updateLevel = GeckoSim.applicationProps.getProperty("UPDATE_LEVEL", "MINOR");
        
        if(updateLevel.equals("MINOR")) {
            jRadioButtonMinor.setSelected(true);
        }
        
        if(updateLevel.equals("MAJOR")) {
            jRadioButtonMajor.setSelected(true);
        }
    }    

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of
     * this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jButtonOk = new javax.swing.JButton();
        jRadioButtonNever = new javax.swing.JRadioButton();
        jRadioButtonDaily = new javax.swing.JRadioButton();
        jRadioButtonWeekly = new javax.swing.JRadioButton();
        jRadioButtonMajor = new javax.swing.JRadioButton();
        jRadioButtonMinor = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GeckoCIRCUITS Memory");
        setLocationByPlatform(true);

        jButtonOk.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButtonOk.setText("Ok");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButtonNever);
        jRadioButtonNever.setSelected(true);
        jRadioButtonNever.setText("Never check for updates");

        buttonGroup2.add(jRadioButtonDaily);
        jRadioButtonDaily.setText("Daily check for updates");

        buttonGroup2.add(jRadioButtonWeekly);
        jRadioButtonWeekly.setText("Weekly check for updates");

        buttonGroup1.add(jRadioButtonMajor);
        jRadioButtonMajor.setSelected(true);
        jRadioButtonMajor.setText("Notify only major version numbers");

        buttonGroup1.add(jRadioButtonMinor);
        jRadioButtonMinor.setText("Notify all updates");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jRadioButtonNever))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jRadioButtonDaily))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jRadioButtonWeekly))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jRadioButtonMajor))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jRadioButtonMinor))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jButtonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonNever)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonDaily)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonWeekly)
                .addGap(43, 43, 43)
                .addComponent(jRadioButtonMajor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButtonMinor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonOk)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//NOPMD//GEN-FIRST:event_jButtonOkActionPerformed
        
        if(jRadioButtonNever.isSelected()) {
            GeckoSim.applicationProps.setProperty("UPDATE_FREQ", "NEVER");
        }
    
        if(jRadioButtonDaily.isSelected()) {
            GeckoSim.applicationProps.setProperty("UPDATE_FREQ", "DAILY");
        }
        
        if(jRadioButtonWeekly.isSelected()) {
            GeckoSim.applicationProps.setProperty("UPDATE_FREQ", "WEEKLY");
        }     
        
        if(jRadioButtonMinor.isSelected()) {
            GeckoSim.applicationProps.setProperty("UPDATE_LEVEL", "MINOR");
        }
        
        if(jRadioButtonMajor.isSelected()) {
            GeckoSim.applicationProps.setProperty("UPDATE_LEVEL", "MAJOR");
        }
        
        GeckoSim.saveProperties();
        this.dispose();
    }//GEN-LAST:event_jButtonOkActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JRadioButton jRadioButtonDaily;
    private javax.swing.JRadioButton jRadioButtonMajor;
    private javax.swing.JRadioButton jRadioButtonMinor;
    private javax.swing.JRadioButton jRadioButtonNever;
    private javax.swing.JRadioButton jRadioButtonWeekly;
    // End of variables declaration//GEN-END:variables
}
