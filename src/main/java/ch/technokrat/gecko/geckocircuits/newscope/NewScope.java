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

import ch.technokrat.gecko.geckocircuits.allg.DatenSpeicher;
import ch.technokrat.gecko.geckocircuits.circuit.TokenMap;
import ch.technokrat.gecko.geckocircuits.datacontainer.AbstractDataContainer;
import ch.technokrat.gecko.geckocircuits.newscope.SliderUtils.ExtremumType;
import ch.technokrat.gecko.geckocircuits.newscope.SliderUtils.FlankType;
import ch.technokrat.gecko.geckocircuits.newscope.SliderUtils.IterationDirection;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;

public final class NewScope extends javax.swing.JPanel {

    public final List<GraferV4> _grafer = new ArrayList<GraferV4>();
    private boolean _signalCrvSelected;
    private static final String CURSOR_FORWARD_INFO = "Forward/Backward mode for cursor search functions";
    private static final String ZOOM_INFO = "<html>Lock zoom to X-axis. Alternatively, press<br> CTRL button "
            + "when dragging the zoom window</html>";
    private final SliderContainer _sliderContainer;
    private GraferV4 _fourierPanel;

    /**
     * Creates new form NewScope
     */
    public NewScope() {

        super();
        initComponents();
        _grafer.clear();
        _sliderContainer = null;
        assert false;
    }

    public NewScope(final GraferV4 grafer) {
        super();

        initComponents();

        jToggleButtonZoomShift.setOpaque(false);
        jToggleButtonAuto.setOpaque(false);
        jToggleButtonCtrl.setOpaque(false);
        jToggleButtonOff.setOpaque(false);
        jToggleButtonSlider.setOpaque(false);
        jToggleButtonZoom.setOpaque(false);
        jButtonLoadZoom.setOpaque(false);
        jButtonNextEqual.setOpaque(false);
        jButtonNextMax.setOpaque(false);
        jButtonNextMin.setOpaque(false);
        jButtonShowAll.setOpaque(false);
        jButtonZoomBack.setOpaque(false);
        jButtonNextZero.setOpaque(false);
        jButtonSaveZoom.setOpaque(false);

        _signalCrvSelected = false;
        _grafer.add(grafer);
        _sliderContainer = _grafer.get(0)._sliderContainer;
        jPanelGraph.setLayout(new BorderLayout());
        jPanelGraph.add(_grafer.get(0), BorderLayout.CENTER);
                
        disableSliderButtons();
        enableZoomButtons();
    }

    public void additionalPanel(final GraferV4 fourierPanel) {

        if (_fourierPanel != null) {
            jPanelGraph.remove(_fourierPanel);
            _grafer.remove(fourierPanel);
        }
        _grafer.add(fourierPanel);
        _fourierPanel = fourierPanel;
        _fourierPanel.setPreferredSize(new Dimension(3000, 200));
        jPanelGraph.add(_fourierPanel, BorderLayout.SOUTH);
        this.validate();
        for (GraferV4 grafer : _grafer) {
            grafer.refreshComponentPane();
        }
    }

    public void setTabsInvisible() {
        GroupLayout layout = (GroupLayout) getLayout();
        layout.replace(jTabbedPane, jPanelGraph);
    }

    public void setDataContainer(final AbstractDataContainer dataContainer) {
        assert dataContainer != null;
        dataContainerTable1.setDataContainer(dataContainer);
        _grafer.get(0).setDataContainer(dataContainer);
    }

    public void setSignalCrvSelected(final boolean sCrvSel) {
        _signalCrvSelected = sCrvSel;
        if (jToggleButtonSlider.isSelected()) {
            enableSliderButtons();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //CHECKSTYLE:OFF
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBarLeft = new javax.swing.JToolBar();
        jToggleButtonOff = new javax.swing.JToggleButton();
        jToggleButtonZoom = new javax.swing.JToggleButton();
        jToggleButtonSlider = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButtonNextMax = new javax.swing.JButton();
        jButtonNextMin = new javax.swing.JButton();
        jButtonNextZero = new javax.swing.JButton();
        jButtonNextEqual = new javax.swing.JButton();
        jButtonShowAll = new javax.swing.JButton();
        jButtonZoomBack = new javax.swing.JButton();
        jToggleButtonCtrl = new javax.swing.JToggleButton();
        jToggleButtonZoomShift = new javax.swing.JToggleButton();
        jButtonSaveZoom = new javax.swing.JButton();
        jButtonLoadZoom = new javax.swing.JButton();
        jToggleButtonAuto = new javax.swing.JToggleButton();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanelGraph = new javax.swing.JPanel();
        dataContainerTable1 = new ch.technokrat.gecko.geckocircuits.datacontainer.DataContainerTable();
        jPanelInfo = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane = new javax.swing.JTextPane();

        setOpaque(false);

        jToolBarLeft.setFloatable(false);
        jToolBarLeft.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBarLeft.setRollover(true);
        jToolBarLeft.setOpaque(false);

        jToggleButtonOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gecko/geckocircuits/allg/iconOFF_off.png"))); // NOI18N
        jToggleButtonOff.setToolTipText("Disable cursors and zoom modus");
        jToggleButtonOff.setFocusPainted(false);
        jToggleButtonOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonOffActionPerformed(evt);
            }
        });
        jToolBarLeft.add(jToggleButtonOff);

        jToggleButtonZoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gecko/geckocircuits/allg/iconOFF_zoomFenster.png"))); // NOI18N
        jToggleButtonZoom.setSelected(true);
        jToggleButtonZoom.setToolTipText("<html>Activate zoom modus. Drag the mouse to zoom. Pressing Ctrl<br>\nor Shift during draggin enables zooming into a single axis direction.<br>\nAs alternative, you can use the mouse wheel for zooming. Alt-Drag<br>\nenables the pan modus.\n</html>");
        jToggleButtonZoom.setFocusable(false);
        jToggleButtonZoom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButtonZoom.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButtonZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonZoomActionPerformed(evt);
            }
        });
        jToolBarLeft.add(jToggleButtonZoom);

        jToggleButtonSlider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gecko/geckocircuits/allg/iconON_getXYschieber.png"))); // NOI18N
        jToggleButtonSlider.setToolTipText("<html>Activate sliders (cursors). You can use the mouse wheel for fine-<br>\nadjustment of the cursors. The second (green) cursor moves by dragging<br>\nthe right mouse button. The green cursor shows DIFFERENCES values w.r.t<br>\nthe first (red) cursor values.</html>");
        jToggleButtonSlider.setFocusable(false);
        jToggleButtonSlider.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButtonSlider.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButtonSlider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonSliderActionPerformed(evt);
            }
        });
        jToolBarLeft.add(jToggleButtonSlider);

        jSeparator1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jToolBarLeft.add(jSeparator1);

        jButtonNextMax.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gecko/geckocircuits/allg/icon_nextMax.png"))); // NOI18N
        jButtonNextMax.setToolTipText("Move active cursor to next (ctrl-previous) maximum");
        jButtonNextMax.setFocusable(false);
        jButtonNextMax.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNextMax.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonNextMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextMaxActionPerformed(evt);
            }
        });
        jToolBarLeft.add(jButtonNextMax);

        jButtonNextMin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gecko/geckocircuits/allg/icon_nextMin.png"))); // NOI18N
        jButtonNextMin.setToolTipText("Move active cursor to next (ctrl-previous) maximum");
        jButtonNextMin.setFocusable(false);
        jButtonNextMin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNextMin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonNextMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextMinActionPerformed(evt);
            }
        });
        jToolBarLeft.add(jButtonNextMin);

        jButtonNextZero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gecko/geckocircuits/allg/icon_nextZero.png"))); // NOI18N
        jButtonNextZero.setToolTipText("Move active cursor to next (ctrl-previous) zero crossing");
        jButtonNextZero.setFocusable(false);
        jButtonNextZero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNextZero.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonNextZero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextZeroActionPerformed(evt);
            }
        });
        jToolBarLeft.add(jButtonNextZero);

        jButtonNextEqual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gecko/geckocircuits/allg/icon_nextEqual.png"))); // NOI18N
        jButtonNextEqual.setToolTipText("<html>Move inactive cursor to next (ctrl-previous)<br>  value equal to the active cursor value</html>");
        jButtonNextEqual.setFocusable(false);
        jButtonNextEqual.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNextEqual.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonNextEqual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextEqualActionPerformed(evt);
            }
        });
        jToolBarLeft.add(jButtonNextEqual);

        jButtonShowAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gecko/geckocircuits/allg/iconOFF_zoomFit2.png"))); // NOI18N
        jButtonShowAll.setToolTipText("Auto-zoom to data in memory");
        jButtonShowAll.setFocusable(false);
        jButtonShowAll.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonShowAll.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShowAllActionPerformed(evt);
            }
        });
        jToolBarLeft.add(jButtonShowAll);

        jButtonZoomBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gecko/geckocircuits/allg/iconUnZoom.png"))); // NOI18N
        jButtonZoomBack.setToolTipText("Undo last zoom operation");
        jButtonZoomBack.setFocusable(false);
        jButtonZoomBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonZoomBack.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonZoomBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonZoomBackActionPerformed(evt);
            }
        });
        jToolBarLeft.add(jButtonZoomBack);

        jToggleButtonCtrl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gecko/geckocircuits/allg/ctrlForward.png"))); // NOI18N
        jToggleButtonCtrl.setFocusable(false);
        jToggleButtonCtrl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButtonCtrl.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButtonCtrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonCtrlActionPerformed(evt);
            }
        });
        jToolBarLeft.add(jToggleButtonCtrl);

        jToggleButtonZoomShift.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gecko/geckocircuits/allg/zoomY.png"))); // NOI18N
        jToggleButtonZoomShift.setToolTipText("<html>Lock zoom to Y-axis. Alternatively, press<br> SHIFT button when dragging the zoom window</html>");
        jToggleButtonZoomShift.setFocusable(false);
        jToggleButtonZoomShift.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButtonZoomShift.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButtonZoomShift.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonZoomShiftActionPerformed(evt);
            }
        });
        jToolBarLeft.add(jToggleButtonZoomShift);

        jButtonSaveZoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gecko/geckocircuits/allg/iconON_zoomFit2.png"))); // NOI18N
        jButtonSaveZoom.setToolTipText("Save currently selected zoom settings");
        jButtonSaveZoom.setFocusable(false);
        jButtonSaveZoom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSaveZoom.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSaveZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveZoomActionPerformed(evt);
            }
        });
        jToolBarLeft.add(jButtonSaveZoom);

        jButtonLoadZoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gecko/geckocircuits/allg/loadZoom.png"))); // NOI18N
        jButtonLoadZoom.setToolTipText("Load zoom settings that were saved last time");
        jButtonLoadZoom.setEnabled(false);
        jButtonLoadZoom.setFocusable(false);
        jButtonLoadZoom.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonLoadZoom.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonLoadZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadZoomActionPerformed(evt);
            }
        });
        jToolBarLeft.add(jButtonLoadZoom);

        jToggleButtonAuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gecko/geckocircuits/allg/autoScale.png"))); // NOI18N
        jToggleButtonAuto.setSelected(true);
        jToggleButtonAuto.setFocusable(false);
        jToggleButtonAuto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButtonAuto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButtonAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonAutoActionPerformed(evt);
            }
        });
        jToolBarLeft.add(jToggleButtonAuto);

        jTabbedPane.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jPanelGraph.setOpaque(false);
        jPanelGraph.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanelGraphComponentResized(evt);
            }
        });

        javax.swing.GroupLayout jPanelGraphLayout = new javax.swing.GroupLayout(jPanelGraph);
        jPanelGraph.setLayout(jPanelGraphLayout);
        jPanelGraphLayout.setHorizontalGroup(
            jPanelGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 734, Short.MAX_VALUE)
        );
        jPanelGraphLayout.setVerticalGroup(
            jPanelGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("Graph", jPanelGraph);

        dataContainerTable1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        dataContainerTable1.setOpaque(false);
        jTabbedPane.addTab("Data", dataContainerTable1);

        jPanelInfo.setOpaque(false);

        jTextPane.setText("The GeckoCIRCUITS Scope is a powerful tool for visualization of your simulation \nresults. The following hints may help you to use the Scope effectively.\n\n- Zooming: Select the 'Zoom' button on the left hand side panel.\n    Drag the mouse over the area where you like to zoom into.\n    Holding the Control keyboard button while zooming modifies\n    only the time-axis (x) settings.\n    Holding the Shift keyboard button while zooming modifies\n    only the value-axis (y) settings.\n    You can undo your last zoom operations via the 'Back'-button.\n- Using the Cursors for measurements: Select the 'x-y'-button\n    from the side panel. Click or drag into the graphs shows a\n    cursor, and the data values are displayed next to the graphs.\n    When you use the right mouse button, a second cursor (green) is\n    shown. The green cursor shows difference values to the previously\n    set red cursor (dt, value difference).\n- You can use labels for the input ports of the circuit schematic scope\n    Icon. The graphs within the scope are then titeled with the label names.\n- In the 'Graphs' menu, you can assign the input channels to different\n    graphs within the scope via an assignment matrix. The matrix entries\n    are toggeled via the right mouse button. Pressing the left mouse\n    button on a matrix entry allows you to change the curve properties,\n    for instance the curve color, stroke type, etc.");
        jScrollPane2.setViewportView(jTextPane);

        javax.swing.GroupLayout jPanelInfoLayout = new javax.swing.GroupLayout(jPanelInfo);
        jPanelInfo.setLayout(jPanelInfoLayout);
        jPanelInfoLayout.setHorizontalGroup(
            jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
        );
        jPanelInfoLayout.setVerticalGroup(
            jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("Info", jPanelInfo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBarLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBarLeft, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    //CHECKSTYLE:ON
private void jButtonShowAllActionPerformed(java.awt.event.ActionEvent evt) {//NOPMD//GEN-FIRST:event_jButtonShowAllActionPerformed
    for (GraferV4 grafer : _grafer) {
        grafer.doZoomAutoFit();
    }
}//GEN-LAST:event_jButtonShowAllActionPerformed

private void jToggleButtonOffActionPerformed(java.awt.event.ActionEvent evt) {//NOPMD//GEN-FIRST:event_jToggleButtonOffActionPerformed
    jToggleButtonOff.setSelected(true);
    jToggleButtonSlider.setSelected(false);
    jToggleButtonZoom.setSelected(false);

    for (GraferV4 grafer : _grafer) {
        grafer.setMausModus(GraferV4.MausModus.NONE);
    }

    disableZoomButtons();
    disableSliderButtons();
}//GEN-LAST:event_jToggleButtonOffActionPerformed

private void jToggleButtonSliderActionPerformed(java.awt.event.ActionEvent evt) {//NOPMD//GEN-FIRST:event_jToggleButtonSliderActionPerformed
    jToggleButtonOff.setSelected(false);
    jToggleButtonSlider.setSelected(true);
    jToggleButtonZoom.setSelected(false);
    for (GraferV4 grafer : _grafer) {
        grafer.setMausModus(GraferV4.MausModus.SLIDER);
        //grafer.setAxisPositions();
    }

    disableZoomButtons();
    enableSliderButtons();
}//GEN-LAST:event_jToggleButtonSliderActionPerformed

private void jToggleButtonZoomActionPerformed(java.awt.event.ActionEvent evt) {//NOPMD//GEN-FIRST:event_jToggleButtonZoomActionPerformed
    jToggleButtonOff.setSelected(false);
    jToggleButtonSlider.setSelected(false);
    jToggleButtonZoom.setSelected(true);
    for (GraferV4 grafer : _grafer) {
        grafer.setMausModus(GraferV4.MausModus.ZOOM_WINDOW);
    }

    disableSliderButtons();
    enableZoomButtons();

    for (GraferV4 grafer : _grafer) {
        for (AbstractDiagram diag : grafer.getManager().getDiagrams()) {
            diag._zoomWindow.setXZoomOn(jToggleButtonCtrl.isSelected());
            diag._zoomWindow.setYZoomOn(jToggleButtonZoomShift.isSelected());
        }
    }



}//GEN-LAST:event_jToggleButtonZoomActionPerformed

private void jButtonZoomBackActionPerformed(java.awt.event.ActionEvent evt) {//NOPMD//GEN-FIRST:event_jButtonZoomBackActionPerformed

    _grafer.get(0).undoZoom();
    jToggleButtonOff.setSelected(false);
    jToggleButtonSlider.setSelected(false);
    jToggleButtonZoom.setSelected(true);

    disableSliderButtons();
    enableZoomButtons();
}//GEN-LAST:event_jButtonZoomBackActionPerformed

private void jButtonNextMaxActionPerformed(java.awt.event.ActionEvent evt) {//NOPMD//GEN-FIRST:event_jButtonNextMaxActionPerformed

    try {
        final AbstractCurve selectedCurve = _grafer.get(0).getSelectedCurve();
        if (selectedCurve instanceof CurveSignal) {
            _sliderContainer.goToSignalFlank(getIterationDirection(), FlankType.ASCEND, _grafer.get(0));
        } else {
            _sliderContainer.goToExtrema(getIterationDirection(), ExtremumType.MAXIMUM, _grafer.get(0));
        }
        _grafer.get(0)._xSliderDrawer.setDisplayRanges(_sliderContainer.getSliderXRange());
    } catch (NoCurveSelectedException ex) {
        Logger.getLogger(NewScope.class.getName()).log(Level.WARNING, ex.getMessage());
    }
}//GEN-LAST:event_jButtonNextMaxActionPerformed

private void jToggleButtonCtrlActionPerformed(java.awt.event.ActionEvent evt) {//NOPMD//GEN-FIRST:event_jToggleButtonCtrlActionPerformed
    jToggleButtonZoomShift.setSelected(false);
    setCTRLCursors();
    for (GraferV4 grafer : _grafer) {
        for (AbstractDiagram diag : grafer.getManager().getDiagrams()) {
            diag._zoomWindow.setXZoomOn(jToggleButtonCtrl.isSelected());
            diag._zoomWindow.setYZoomOn(jToggleButtonZoomShift.isSelected());
        }
    }

}//GEN-LAST:event_jToggleButtonCtrlActionPerformed

private void jToggleButtonZoomShiftActionPerformed(java.awt.event.ActionEvent evt) {//NOPMD//GEN-FIRST:event_jToggleButtonZoomShiftActionPerformed
    jToggleButtonCtrl.setSelected(false);

    for (GraferV4 grafer : _grafer) {
        for (AbstractDiagram diag : grafer.getManager().getDiagrams()) {
            diag._zoomWindow.setXZoomOn(jToggleButtonCtrl.isSelected());
            diag._zoomWindow.setYZoomOn(jToggleButtonZoomShift.isSelected());
        }
    }
}//GEN-LAST:event_jToggleButtonZoomShiftActionPerformed

private void jButtonNextMinActionPerformed(java.awt.event.ActionEvent evt) {//NOPMD//GEN-FIRST:event_jButtonNextMinActionPerformed
    try {
        final AbstractCurve selectedCurve = _grafer.get(0).getSelectedCurve();
        if (selectedCurve instanceof CurveSignal) {
            _sliderContainer.goToSignalFlank(getIterationDirection(), FlankType.DESCEND, _grafer.get(0));
        } else {
            _sliderContainer.goToExtrema(getIterationDirection(), ExtremumType.MINIMUM, _grafer.get(0));
        }
    } catch (NoCurveSelectedException ex) {
        Logger.getLogger(NewScope.class.getName()).log(Level.WARNING, ex.getMessage());
    }
}//GEN-LAST:event_jButtonNextMinActionPerformed

private void jButtonNextZeroActionPerformed(java.awt.event.ActionEvent evt) {//NOPMD//GEN-FIRST:event_jButtonNextZeroActionPerformed
    try {
        _sliderContainer.goToZeroOrEqual(getIterationDirection(), true, _grafer.get(0));
    } catch (NoCurveSelectedException ex) {
        Logger.getLogger(NewScope.class.getName()).log(Level.WARNING, ex.getMessage());
    }
}//GEN-LAST:event_jButtonNextZeroActionPerformed

private void jButtonNextEqualActionPerformed(java.awt.event.ActionEvent evt) {//NOPMD//GEN-FIRST:event_jButtonNextEqualActionPerformed
    try {
        _sliderContainer.goToZeroOrEqual(getIterationDirection(), false, _grafer.get(0));
    } catch (NoCurveSelectedException ex) {
        Logger.getLogger(NewScope.class.getName()).log(Level.WARNING, ex.getMessage());
    }
}//GEN-LAST:event_jButtonNextEqualActionPerformed

    private void jButtonSaveZoomActionPerformed(java.awt.event.ActionEvent evt) {//NOPMD//GEN-FIRST:event_jButtonSaveZoomActionPerformed
        for (GraferV4 grafer : _grafer) {
            try {
                grafer.saveCurrentZoom();
                jButtonLoadZoom.setEnabled(true);
            } catch (NullPointerException ex) {
                Logger.getLogger(NewScope.class.getName()).log(Level.WARNING, ex.getMessage());

            }
        }
    }//GEN-LAST:event_jButtonSaveZoomActionPerformed

    private void jButtonLoadZoomActionPerformed(java.awt.event.ActionEvent evt) {//NOPMD//GEN-FIRST:event_jButtonLoadZoomActionPerformed
        for (GraferV4 grafer : _grafer) {
            grafer.loadSavedZoom();
        }
    }//GEN-LAST:event_jButtonLoadZoomActionPerformed

    private void jToggleButtonAutoActionPerformed(java.awt.event.ActionEvent evt) {//NOPMD//GEN-FIRST:event_jToggleButtonAutoActionPerformed
        for (GraferV4 grafer : _grafer) {
            grafer.setAutoScaleModus(jToggleButtonAuto.isSelected());
            if (jToggleButtonAuto.isSelected()) {
                grafer.doZoomAutoFit();
            }
        }

    }//GEN-LAST:event_jToggleButtonAutoActionPerformed

    private void jPanelGraphComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelGraphComponentResized
        for (GraferV4 grafer : _grafer) {
            grafer.setAxisPositions();
            this.repaint();
        }

    }//GEN-LAST:event_jPanelGraphComponentResized

    private void enableZoomButtons() {
        jToggleButtonCtrl.setVisible(true);
        jToggleButtonCtrl.setSelected(false);
        jToggleButtonZoomShift.setVisible(true);
        jToggleButtonZoomShift.setSelected(false);
        jButtonZoomBack.setVisible(true);
        jButtonShowAll.setVisible(true);
        jButtonLoadZoom.setVisible(true);
        jButtonSaveZoom.setVisible(true);
        jToggleButtonAuto.setVisible(true);
        setCTRLCursors();

    }

    private void disableZoomButtons() {
        jToggleButtonCtrl.setVisible(false);
        jToggleButtonZoomShift.setVisible(false);
        jButtonZoomBack.setVisible(false);
        jButtonShowAll.setVisible(false);
        jButtonLoadZoom.setVisible(false);
        jButtonSaveZoom.setVisible(false);
        jToggleButtonAuto.setVisible(false);

    }

    private void enableSliderButtons() {
        if (_signalCrvSelected) {
            jButtonNextMax.setIcon(new javax.swing.ImageIcon(getClass().
                    getResource("/gecko/geckocircuits/allg/icon_nextSIGAsc.png")));
            jButtonNextMin.setIcon(new javax.swing.ImageIcon(getClass().
                    getResource("/gecko/geckocircuits/allg/icon_nextSIGDesc.png")));
            jButtonNextMax.setVisible(true);
            jButtonNextMin.setVisible(true);
            jButtonNextZero.setVisible(false);
            jButtonNextEqual.setVisible(false);
        } else {
            jButtonNextMax.setIcon(new javax.swing.ImageIcon(getClass().
                    getResource("/gecko/geckocircuits/allg/icon_nextMax.png")));
            jButtonNextMin.setIcon(new javax.swing.ImageIcon(getClass().
                    getResource("/gecko/geckocircuits/allg/icon_nextMin.png")));
            jButtonNextMax.setVisible(true);
            jButtonNextMin.setVisible(true);
            jButtonNextZero.setVisible(true);
            jButtonNextEqual.setVisible(true);
        }

        jToggleButtonCtrl.setVisible(true);
        setCTRLCursors();

    }

    private void disableSliderButtons() {
        jButtonNextMax.setVisible(false);
        jButtonNextMin.setVisible(false);
        jButtonNextZero.setVisible(false);
        jButtonNextEqual.setVisible(false);
        jToggleButtonCtrl.setVisible(false);
    }
    //CHECKSTYLE:OFF
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ch.technokrat.gecko.geckocircuits.datacontainer.DataContainerTable dataContainerTable1;
    private javax.swing.JButton jButtonLoadZoom;
    private javax.swing.JButton jButtonNextEqual;
    private javax.swing.JButton jButtonNextMax;
    private javax.swing.JButton jButtonNextMin;
    private javax.swing.JButton jButtonNextZero;
    private javax.swing.JButton jButtonSaveZoom;
    private javax.swing.JButton jButtonShowAll;
    private javax.swing.JButton jButtonZoomBack;
    private javax.swing.JPanel jPanelGraph;
    private javax.swing.JPanel jPanelInfo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTextPane jTextPane;
    private javax.swing.JToggleButton jToggleButtonAuto;
    javax.swing.JToggleButton jToggleButtonCtrl;
    private javax.swing.JToggleButton jToggleButtonOff;
    private javax.swing.JToggleButton jToggleButtonSlider;
    private javax.swing.JToggleButton jToggleButtonZoom;
    private javax.swing.JToggleButton jToggleButtonZoomShift;
    public javax.swing.JToolBar jToolBarLeft;
    // End of variables declaration//GEN-END:variables

    private void setCTRLCursors() {

        if (jToggleButtonZoom.isSelected()) {
            jToggleButtonCtrl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gecko/geckocircuits/allg/zoomX.png")));
            jToggleButtonCtrl.setToolTipText(ZOOM_INFO);
        } else {
            jToggleButtonCtrl.setToolTipText(CURSOR_FORWARD_INFO);
            if (jToggleButtonCtrl.isSelected()) {
                jToggleButtonCtrl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gecko/geckocircuits/allg/ctrlBackward.png")));
            } else {
                jToggleButtonCtrl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gecko/geckocircuits/allg/ctrlForward.png")));
            }
        }
    }

    private IterationDirection getIterationDirection() {
        if (jToggleButtonCtrl.isSelected()) {
            return IterationDirection.BACKWARD;
        } else {
            return IterationDirection.FORWARD;
        }
    }

    public void exportInvidualControl(StringBuffer ascii) {
        boolean isSelected = jToggleButtonAuto.isSelected();
        DatenSpeicher.appendAsString(ascii.append("\nisAutoScaleWindowOn"), isSelected);
    }

    public void importIndividualCONTROL(final TokenMap settingsMap) {
        if (settingsMap.containsToken("isAutoScaleWindowOn")) {
            boolean isAutoScale = settingsMap.readDataLine("isAutoScaleWindowOn", true);
            jToggleButtonAuto.setSelected(isAutoScale);
        } else {
            jToggleButtonAuto.setSelected(true);
        }
        _grafer.get(0).setAutoScaleModus(jToggleButtonAuto.isSelected());
    }
}
