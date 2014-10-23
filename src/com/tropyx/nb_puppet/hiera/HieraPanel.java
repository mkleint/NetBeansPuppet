/*
 * Copyright (C) 2014 mkleint
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.tropyx.nb_puppet.hiera;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.AuxiliaryProperties;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;

/**
 *
 * @author mkleint
 */
public class HieraPanel extends javax.swing.JPanel {
    private ProjectCustomizer.Category category;
    private Project project;
    private AuxiliaryProperties prefs;
    public static final String HIERALOCATION = "hiera.location";
    

    public HieraPanel() {
        initComponents();
    }
    
    HieraPanel(ProjectCustomizer.Category category, Project lookup) {
        this();
        this.category = category;
        this.project = lookup;
        category.setOkButtonListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                doSave();
            }
        });
        prefs = project.getLookup().lookup(AuxiliaryProperties.class);
        String value = prefs.get(HIERALOCATION, true);
        if (value == null) {
            value = "hiera.yaml";
        }
        txtHieraLocation.setText(value);
        
    }

    private void doSave() {
         prefs.put(HIERALOCATION, txtHieraLocation.getText(), true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHiera = new javax.swing.JLabel();
        txtHieraLocation = new javax.swing.JTextField();

        org.openide.awt.Mnemonics.setLocalizedText(lblHiera, org.openide.util.NbBundle.getMessage(HieraPanel.class, "HieraPanel.lblHiera.text")); // NOI18N

        txtHieraLocation.setText(org.openide.util.NbBundle.getMessage(HieraPanel.class, "HieraPanel.txtHieraLocation.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHiera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHieraLocation, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHiera)
                    .addComponent(txtHieraLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(266, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblHiera;
    private javax.swing.JTextField txtHieraLocation;
    // End of variables declaration//GEN-END:variables
}
