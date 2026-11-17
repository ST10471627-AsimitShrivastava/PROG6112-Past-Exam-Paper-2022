
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.hospitalinspections;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author emeris
 */
public class HospitalInspectionsGUI extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger
            = java.util.logging.Logger.getLogger(HospitalInspectionsGUI.class.getName());

    // I create an object to manage the hospital inspections.
    private HospitalInspectionManager inspectionManager
            = new HospitalInspectionManager();

    // I create a model to display the inspections in the list box.
    private DefaultListModel<String> inspectionListModel
            = new DefaultListModel<>();

    /**
     * Creates new form HospitalInspectionsGUI
     */

    // I save the hospital details entered by the user.
    private void saveInspection() {

        // I collect the information entered on the form.
        String hospitalName = txtHospitalName.getText().trim();
        String hospitalLocation = txtHospitalLocation.getText().trim();

        // I check that the required fields are not empty.
        if (hospitalName.isEmpty() || hospitalLocation.isEmpty()
                || cmbYearsSinceInspection.getSelectedIndex() == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter the hospital name, location and years.",
                    "Missing Information",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        // I get the selected number of years.
        int years = cmbYearsSinceInspection.getSelectedIndex() + 1;

        // I create an object containing the inspection details.
        HospitalInspection inspection = new HospitalInspection(
                hospitalName, hospitalLocation, years
        );

        // I check whether the inspection can be saved.
        if (!inspectionManager.addInspection(inspection)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Maximum inspection count reached!",
                    "Message",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        // I confirm that the inspection has been saved.
        JOptionPane.showMessageDialog(
                this,
                "Hospital inspection saved successfully.",
                "Message",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // I print the saved hospital details in the list box.
    private void printInspections() {

        // I clear the list before displaying the saved inspections.
        inspectionListModel.clear();

        // I check whether there are any saved inspections.
        if (inspectionManager.getInspectionCount() == 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "No hospital inspections have been saved.",
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE
            );

            return;
        }

        // I go through the array and display each inspection.
        for (HospitalInspection inspection
                : inspectionManager.getAllInspections()) {

            String details = "<html>"
                    + "Hospital Name: "
                    + escapeHtml(inspection.getHospitalName()) + "<br>"
                    + "Hospital Location: "
                    + escapeHtml(inspection.getHospitalLocation()) + "<br>"
                    + "Years Since Inspection: "
                    + inspection.getYearsSinceInspection()
                    + (inspection.getYearsSinceInspection() == 1
                            ? " year" : " years")
                    + "</html>";

            // I add the hospital details to the list box.
            inspectionListModel.addElement(details);
        }
    }

    // I protect special characters when displaying hospital details.
    private String escapeHtml(String value) {

        return value.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
    }

    // I clear the form controls.
    private void clearControls() {

        // I clear the hospital name.
        txtHospitalName.setText("");

        // I clear the hospital location.
        txtHospitalLocation.setText("");

        // I return the combo box to its first option.
        cmbYearsSinceInspection.setSelectedIndex(0);

        // I clear the displayed inspection list.
        inspectionListModel.clear();
    }

    public HospitalInspectionsGUI() {

        initComponents();

        // I connect the list model to the inspection list.
        lstHospitalInspections.setModel(inspectionListModel);

        // I make the form appear in the centre of the screen.
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        lblHospitalName = new javax.swing.JLabel();
        lblHospitalLocation = new javax.swing.JLabel();
        lblYearsSinceInspection = new javax.swing.JLabel();
        txtHospitalName = new javax.swing.JTextField();
        txtHospitalLocation = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        lblHospitalInspections = new javax.swing.JLabel();
        cmbYearsSinceInspection = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstHospitalInspections = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuExit = new javax.swing.JMenuItem();
        mnuTools = new javax.swing.JMenu();
        mnuSave = new javax.swing.JMenuItem();
        mnuPrint = new javax.swing.JMenuItem();
        mnuClear = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hospital Inspections");
        setResizable(false);

        lblHospitalName.setText("Hospital Name:");

        lblHospitalLocation.setText("Hospital Location:");

        lblYearsSinceInspection.setText("Years since inspection:");

        txtHospitalName.addActionListener(this::txtHospitalNameActionPerformed);

        btnSave.setText("SAVE");
        btnSave.addActionListener(this::btnSaveActionPerformed);

        btnPrint.setText("PRINT");
        btnPrint.addActionListener(this::btnPrintActionPerformed);

        btnClear.setText("CLEAR");
        btnClear.addActionListener(this::btnClearActionPerformed);

        lblHospitalInspections.setText("Hospital Inspections:");

        cmbYearsSinceInspection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 Year", "2 Years", "3 Years", "4 Years", "5 Years" }));

        lstHospitalInspections.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstHospitalInspections);

        mnuFile.setText("File");

        mnuExit.setText("Exit");
        mnuExit.addActionListener(this::mnuExitActionPerformed);
        mnuFile.add(mnuExit);

        jMenuBar1.add(mnuFile);

        mnuTools.setText("Tools");

        mnuSave.setText("Save");
        mnuSave.addActionListener(this::mnuSaveActionPerformed);
        mnuTools.add(mnuSave);

        mnuPrint.setText("Print");
        mnuPrint.addActionListener(this::mnuPrintActionPerformed);
        mnuTools.add(mnuPrint);

        mnuClear.setText("Clear");
        mnuClear.addActionListener(this::mnuClearActionPerformed);
        mnuTools.add(mnuClear);

        jMenuBar1.add(mnuTools);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblHospitalName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtHospitalName, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblHospitalLocation)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtHospitalLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblYearsSinceInspection)
                                        .addGap(66, 66, 66)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbYearsSinceInspection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblHospitalInspections, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 113, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHospitalName)
                    .addComponent(txtHospitalName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHospitalLocation)
                    .addComponent(txtHospitalLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblYearsSinceInspection)
                    .addComponent(cmbYearsSinceInspection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnPrint)
                    .addComponent(btnClear))
                .addGap(18, 18, 18)
                .addComponent(lblHospitalInspections)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
            // I save the hospital inspection details.
    saveInspection();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
    // I display the saved hospital inspections.
    printInspections();
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
            // I clear the form controls.
    clearControls();
    }//GEN-LAST:event_btnClearActionPerformed

    private void mnuPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPrintActionPerformed
            // I display the saved hospital inspections.
    printInspections();
    }//GEN-LAST:event_mnuPrintActionPerformed

    private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed
            // I close the application.
    System.exit(0);
    }//GEN-LAST:event_mnuExitActionPerformed

    private void mnuSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSaveActionPerformed
            // I save the hospital inspection details.
    saveInspection();
    }//GEN-LAST:event_mnuSaveActionPerformed

    private void mnuClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuClearActionPerformed
        // I clear the form controls.
    clearControls();
    }//GEN-LAST:event_mnuClearActionPerformed

    private void txtHospitalNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHospitalNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHospitalNameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new HospitalInspectionsGUI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbYearsSinceInspection;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHospitalInspections;
    private javax.swing.JLabel lblHospitalLocation;
    private javax.swing.JLabel lblHospitalName;
    private javax.swing.JLabel lblYearsSinceInspection;
    private javax.swing.JList<String> lstHospitalInspections;
    private javax.swing.JMenuItem mnuClear;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenuItem mnuPrint;
    private javax.swing.JMenuItem mnuSave;
    private javax.swing.JMenu mnuTools;
    private javax.swing.JTextField txtHospitalLocation;
    private javax.swing.JTextField txtHospitalName;
    // End of variables declaration//GEN-END:variables
}
