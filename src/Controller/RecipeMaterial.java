/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.HandlerComponent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author REDHAT
 */
public class RecipeMaterial extends javax.swing.JDialog {
    Database db = new Database();
    DefaultTableModel tbModelRM = new DefaultTableModel();
    HandlerComponent hComp;
    ResultSet RSET;
    public Object[] DATA;
    /**
     * Creates new form RecipeMaterial
     */
    public RecipeMaterial(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initViewTable();
        this.setLocationRelativeTo(super.rootPane);
    }
    void initViewTable() {
        try {
            String SQL = "SELECT mCode, Deskripsi, Harga From material";
            hComp = new HandlerComponent();
            tbModelRM = hComp.initTable(tblDialMat, SQL, db, tbModelRM);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    void resetAll(){
        txPrice.setText(""); txDesc.setText(""); 
        txMCode.setText(""); txQty.setText("");
        tblDialMat.clearSelection();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient1 = new Model.PanelGradient();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDialMat = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txMCode = new javax.swing.JTextField();
        txDesc = new javax.swing.JTextField();
        txPrice = new javax.swing.JTextField();
        txQty = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnAddtoRecipe = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Daftar Bahan Baku Resep");

        panelGradient1.setBackground(new java.awt.Color(83, 126, 197));
        panelGradient1.setGradientBackgroundColor(new java.awt.Color(41, 58, 128));
        panelGradient1.setMaximumSize(new java.awt.Dimension(383, 415));
        panelGradient1.setMinimumSize(new java.awt.Dimension(383, 415));

        tblDialMat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Bahan Baku", "Nama", "Harga/Satuan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDialMat.getTableHeader().setReorderingAllowed(false);
        tblDialMat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDialMatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDialMat);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bahan Baku");

        txMCode.setBackground(new java.awt.Color(1, 0, 56));
        txMCode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txMCode.setText("Code");
        txMCode.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txMCode.setEnabled(false);
        txMCode.setMargin(new java.awt.Insets(2, 7, 2, 7));

        txDesc.setBackground(new java.awt.Color(1, 0, 56));
        txDesc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txDesc.setText("Description");
        txDesc.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txDesc.setEnabled(false);
        txDesc.setMargin(new java.awt.Insets(2, 7, 2, 7));

        txPrice.setBackground(new java.awt.Color(1, 0, 56));
        txPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txPrice.setText("0");
        txPrice.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txPrice.setEnabled(false);
        txPrice.setMargin(new java.awt.Insets(2, 7, 2, 7));
        txPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPriceActionPerformed(evt);
            }
        });

        txQty.setBackground(new java.awt.Color(1, 0, 56));
        txQty.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txQty.setForeground(new java.awt.Color(243, 148, 34));
        txQty.setText("0");
        txQty.setMargin(new java.awt.Insets(2, 7, 2, 7));
        txQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txQtyActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Jumlah Bahan");

        btnAddtoRecipe.setBackground(new java.awt.Color(204, 204, 204));
        btnAddtoRecipe.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnAddtoRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/32/add32.png"))); // NOI18N
        btnAddtoRecipe.setText("Tambahkan");
        btnAddtoRecipe.setIconTextGap(10);
        btnAddtoRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddtoRecipeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGradient1Layout = new javax.swing.GroupLayout(panelGradient1);
        panelGradient1.setLayout(panelGradient1Layout);
        panelGradient1Layout.setHorizontalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGradient1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGradient1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradient1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txMCode, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelGradient1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txQty, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(16, 16, 16)
                                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txDesc)
                                    .addComponent(txPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelGradient1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(btnAddtoRecipe)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panelGradient1Layout.setVerticalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGradient1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txMCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(btnAddtoRecipe)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDialMatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDialMatMouseClicked
        if(evt.getClickCount() == 2 && !evt.isConsumed()) {
            txMCode.setText(tblDialMat.getValueAt(tblDialMat.getSelectedRow(), 0).toString());
            txDesc.setText(tblDialMat.getValueAt(tblDialMat.getSelectedRow(), 1).toString());
            txPrice.setText(String.valueOf(tblDialMat.getValueAt(tblDialMat.getSelectedRow(), 2)));            
        }
        if(evt.isConsumed())
            tblDialMat.clearSelection();
    }//GEN-LAST:event_tblDialMatMouseClicked

    private void btnAddtoRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddtoRecipeActionPerformed
        DATA = new Object[4];
        DATA[0] = txMCode.getText();
        DATA[1] = txDesc.getText();
        DATA[2] = Double.parseDouble(txQty.getText());
        DATA[3] = Double.valueOf(txPrice.getText());
        this.dispose();
    }//GEN-LAST:event_btnAddtoRecipeActionPerformed

    private void txQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txQtyActionPerformed

    private void txPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txPriceActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RecipeMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecipeMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecipeMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecipeMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RecipeMaterial dialog = new RecipeMaterial(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddtoRecipe;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private Model.PanelGradient panelGradient1;
    private javax.swing.JTable tblDialMat;
    private javax.swing.JTextField txDesc;
    private javax.swing.JTextField txMCode;
    private javax.swing.JTextField txPrice;
    private javax.swing.JTextField txQty;
    // End of variables declaration//GEN-END:variables
}
