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

import ch.technokrat.gecko.geckocircuits.allg.FormatJTextField;
import ch.technokrat.gecko.geckocircuits.datacontainer.DataContainerIntegralCalculatable;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class DialogDefineAvg extends javax.swing.JDialog {

    final List<JCheckBox> _checkBoxes = new ArrayList<JCheckBox>();
    private final DefinedMeanSignals _definedMeanSignals;

    /**
     * Creates new form DialogDefineAvg
     */
    public DialogDefineAvg(final java.awt.Frame parent, final boolean modal,
            final DataContainerIntegralCalculatable dataContainer) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        _definedMeanSignals = dataContainer.getDefinedMeanSignals();
        final Stack<AbstractScopeSignal> origScopeSignals = _definedMeanSignals.getOrigScopeSignals();
        final GridLayout gridLayout = new GridLayout(origScopeSignals.size() + 1, 2);

        jPanelBoxes.setLayout(gridLayout);
        jPanelBoxes.add("labelSignal", new JLabel("Signal name"));

        jPanelBoxes.add(new JLabel("Averaging time"));
        

        for (int i = 0; i < origScopeSignals.size(); i++) {
            final AbstractScopeSignal origSignal = origScopeSignals.get(i);

            final FormatJTextField textField = new FormatJTextField();
            textField.setNumberToField(1e-5);
            textField.setEnabled(false);
            
            final JCheckBox newCheckBox = new JCheckBox(origSignal.getSignalName());

            final ScopeSignalMean isDefined = _definedMeanSignals.findMeanSignal(origSignal);
            
            if (isDefined != null) {
                textField.setEnabled(true);
                newCheckBox.setSelected(true);
                textField.setNumberToField(isDefined.getAveragingTime());
            }


            textField.addKeyListener(new KeyListener() {

                @Override
                public void keyTyped(final KeyEvent evt) {
                    // nothing todo here!
                }

                @Override
                public void keyPressed(final KeyEvent evt) {
                    // nothing todo here!
                }

                @Override
                public void keyReleased(final KeyEvent evt) {
                    try {
                        final double newValue = textField.getNumberFromField();                        
                        _definedMeanSignals.findMeanSignal(origSignal).setAverageTime(newValue);
                    } catch (NumberFormatException ex) {
                        // nothing to do here.
                    }
                }
            });

            newCheckBox.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(final ActionEvent evt) {
                    final boolean isSelected = newCheckBox.isSelected();
                    textField.setEnabled(isSelected);
                    final double newValue = textField.getNumberFromField();
                    if (isSelected) {                                                
                        _definedMeanSignals.defineNewMeanSignal(origSignal, newValue);
                    } else {
                        _definedMeanSignals.unDefineMeanSignal(_definedMeanSignals.findMeanSignal(origSignal));
                    }

                }
            });
            jPanelBoxes.add("first", newCheckBox);
            jPanelBoxes.add(textField);
            _checkBoxes.add(newCheckBox);
        }

        jPanelBoxes.revalidate();
        this.pack();
        this.setResizable(false);

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of
     * this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBoxes = new javax.swing.JPanel();
        jButtonOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelBoxes.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanelBoxes.setLayout(new javax.swing.BoxLayout(jPanelBoxes, javax.swing.BoxLayout.LINE_AXIS));

        jButtonOk.setText("Ok");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBoxes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jButtonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelBoxes, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonOk)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
      dispose();
    }//GEN-LAST:event_jButtonOkActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOk;
    private javax.swing.JPanel jPanelBoxes;
    // End of variables declaration//GEN-END:variables
}
