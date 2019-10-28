/*  This file is part of GeckoCIRCUITS. Copyright (C) ETH Zurich, Gecko-Simulations GmbH
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
package ch.technokrat.gecko.geckocircuits.newscope;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author andy
 */
public class JPanelSymbProps extends javax.swing.JPanel {

    private SymbolSettable _symbSettable;
    private Component _redrawComponent;

    /**
     * Creates new form JPanelSymbProps
     */
    public JPanelSymbProps() {
        initComponents();
    }

    public JPanelSymbProps(SymbolSettable lineSettable, final Component redrawComponent) {                
        initComponents();
        _symbSettable = lineSettable;

        for (GeckoColor color : GeckoColor.values()) {
            jComboBoxSymbColor.addItem(color);
        }

        for (GeckoSymbol shape : GeckoSymbol.values()) {
            jComboBoxShape.addItem(shape);
        }



        jComboBoxShape.setSelectedIndex(_symbSettable.getSymbol().ordinal());
        jComboBoxSymbColor.setSelectedIndex(_symbSettable.getSymbolColor().ordinal());

        jCheckBoxShow.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                enableDisable();
            }
        });

        jCheckBoxShow.setSelected(_symbSettable.isSymbolEnabled());
        enableDisable();
        jSpinnerSkip.setValue(_symbSettable.getSkipNumber());
        // careful: this is by intention the last assignment!
        _redrawComponent = redrawComponent;
    }

    private void enableDisable() {
        jComboBoxShape.setEnabled(jCheckBoxShow.isSelected());
        jComboBoxSymbColor.setEnabled(jCheckBoxShow.isSelected());
        jSpinnerSkip.setEnabled(jCheckBoxShow.isSelected());
    }

    private void repaintComponent() {
        if (_redrawComponent != null) {
            _redrawComponent.repaint();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of
     * this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jCheckBoxShow = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSpinnerSkip = new javax.swing.JSpinner();
        jComboBoxShape = new javax.swing.JComboBox();
        jComboBoxSymbColor = new javax.swing.JComboBox();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Symbol on Data-Points", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        jCheckBoxShow.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCheckBoxShow.setText("Show Symbol");
        jCheckBoxShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxShowActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Skip:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Shape:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Color:");

        jSpinnerSkip.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jSpinnerSkip.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jSpinnerSkip.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerSkipStateChanged(evt);
            }
        });

        jComboBoxShape.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBoxShape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxShapeActionPerformed(evt);
            }
        });

        jComboBoxSymbColor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBoxSymbColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSymbColorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxShow)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSpinnerSkip, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(jComboBoxSymbColor, 0, 110, Short.MAX_VALUE)
                            .addComponent(jComboBoxShape, javax.swing.GroupLayout.Alignment.LEADING, 0, 110, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jCheckBoxShow)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerSkip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxShape, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxSymbColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBoxShape, jComboBoxSymbColor, jSpinnerSkip});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxSymbColorActionPerformed(java.awt.event.ActionEvent evt) {//NOPMD//GEN-FIRST:event_jComboBoxSymbColorActionPerformed
        if (_redrawComponent != null) {
            _symbSettable.setSymbolColor(GeckoColor.getFromOrdinal(jComboBoxSymbColor.getSelectedIndex()));
        }
        repaintComponent();
    }//GEN-LAST:event_jComboBoxSymbColorActionPerformed

    private void jComboBoxShapeActionPerformed(java.awt.event.ActionEvent evt) {//NOPMD//GEN-FIRST:event_jComboBoxShapeActionPerformed
        if (_redrawComponent != null) {
            _symbSettable.setSymbol(GeckoSymbol.getFromOrdinal(jComboBoxShape.getSelectedIndex()));
        }
        repaintComponent();
    }//GEN-LAST:event_jComboBoxShapeActionPerformed

    private void jCheckBoxShowActionPerformed(java.awt.event.ActionEvent evt) {//NOPMD//GEN-FIRST:event_jCheckBoxShowActionPerformed
        
        if (_redrawComponent != null) {
            _symbSettable.setSymbolEnabled(jCheckBoxShow.isSelected());
        }
        repaintComponent();
    }//GEN-LAST:event_jCheckBoxShowActionPerformed

    private void jSpinnerSkipStateChanged(javax.swing.event.ChangeEvent evt) {//NOPMD//GEN-FIRST:event_jSpinnerSkipStateChanged

        if (_redrawComponent != null) {
            _symbSettable.setSkipNumber((Integer) jSpinnerSkip.getValue());
        }
        repaintComponent();

    }//GEN-LAST:event_jSpinnerSkipStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBoxShow;
    private javax.swing.JComboBox jComboBoxShape;
    private javax.swing.JComboBox jComboBoxSymbColor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinnerSkip;
    // End of variables declaration//GEN-END:variables
}