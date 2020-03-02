/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.HandlerComponent;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author REDHAT
 */
public class Recipe extends javax.swing.JFrame {
    Boolean updateState = false;
    Database db = new Database();
    DefaultTableModel tabmode = new DefaultTableModel();
    HandlerComponent hComp;
    HandlerComponent.LimitInput LIMITER;
    ResultSet RSET;
    RecipeMaterial RMDialog;
    RecipeList RLDialog;
    Inventory FrmInvent;
    
    public static Double SPrice = 0.0;
    public String SQL;
    /**
     * Creates new form Recipe
     */
    public Recipe() {
        initComponents();
        ((AbstractDocument) txFCode.getDocument()).setDocumentFilter(new HandlerComponent.LimitInput(4));
        RMDialog = new RecipeMaterial(this, true);
        RLDialog = new RecipeList(this, true);
    }
    
    public void hitungCost() {
        int size = tabmode.getRowCount();
        if(size != -1 || size != 0) {
            SPrice = 0.0;
            for (int x=0; x<size; x++){
                String qty = String.valueOf(tabmode.getValueAt(x, 2)) ,price = String.valueOf(tabmode.getValueAt(x, 3));
                SPrice += Double.valueOf(qty)* Double.valueOf(price);
            }
            lblSPrice.setText(""+SPrice);
        }
    }
    protected void lookupFBCode() {
        SQL = "SELECT material.mCode, material.deskripsi, recipe.qty, material.harga \n"
            + "FROM recipe, material, foodbeve \n"
            + "WHERE recipe.fbCode ='"+txFCode.getText()+"' \n"
            + "AND recipe.fbCode = foodbeve.fbCode \n"
            + "AND recipe.mCode = material.mCode \n"
            + "ORDER BY recipe.mCode ASC"; 
            try {
                hComp = new HandlerComponent();
                tabmode = hComp.initTable(tblMateria, SQL, db, tabmode); 
                System.out.println("Resep "+txFCode.getText()+" : description here...");
                txFCode.setEnabled(false);
                lblSelectedCode.setText(txFCode.getText());
                if(db.searchIndexDB(txFCode.getText(), "fbCode", "foodbeve") != -1)
                    updateState = true;
                if(updateState) {
                    SQL = "SELECT * FROM foodbeve \n"
                        + "WHERE fbCode ='"+txFCode.getText()+"'";
                    RSET = db.getSQL(SQL);
                    RSET.first();
                    txDesc.setText(RSET.getString(2));
                    txPrice.setText(String.valueOf(RSET.getDouble(3)));  
                    hitungCost();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLabel5 = new javax.swing.JLabel();
        txDesc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txPrice = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMateria = new javax.swing.JTable();
        btnRemoveMateria = new javax.swing.JButton();
        btnAddMateria = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        sugestPrice = new javax.swing.JLabel();
        btnConfirmRecipe = new javax.swing.JButton();
        btnClearRecipe = new javax.swing.JButton();
        txFCode = new javax.swing.JTextField();
        lblSelectedDescription = new javax.swing.JLabel();
        lblSelectedCode = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblSPrice = new javax.swing.JLabel();
        btnList = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MakanDong | Recipe Form");
        setResizable(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Recipe Code");

        txDesc.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txDesc.setText("jTextField1");
        txDesc.setMargin(new java.awt.Insets(2, 7, 2, 7));
        txDesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txDescKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Description");

        txPrice.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txPrice.setText("jTextField1");
        txPrice.setMargin(new java.awt.Insets(2, 7, 2, 7));
        txPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txPriceKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Price");

        tblMateria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblMateria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "mCode", "Desc", "Qty", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMateria.setShowVerticalLines(false);
        tblMateria.getTableHeader().setResizingAllowed(false);
        tblMateria.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblMateria);
        if (tblMateria.getColumnModel().getColumnCount() > 0) {
            tblMateria.getColumnModel().getColumn(0).setMinWidth(20);
            tblMateria.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblMateria.getColumnModel().getColumn(0).setMaxWidth(70);
            tblMateria.getColumnModel().getColumn(2).setMinWidth(10);
            tblMateria.getColumnModel().getColumn(2).setPreferredWidth(70);
            tblMateria.getColumnModel().getColumn(2).setMaxWidth(70);
            tblMateria.getColumnModel().getColumn(3).setMinWidth(80);
            tblMateria.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblMateria.getColumnModel().getColumn(3).setMaxWidth(150);
        }

        btnRemoveMateria.setText("Remove");
        btnRemoveMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveMateriaActionPerformed(evt);
            }
        });

        btnAddMateria.setText("Add");
        btnAddMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMateriaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Production Cost");

        sugestPrice.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        sugestPrice.setText("Rp.");

        btnConfirmRecipe.setText("Confirm Recipe");
        btnConfirmRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmRecipeActionPerformed(evt);
            }
        });

        btnClearRecipe.setText("Reset");
        btnClearRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearRecipeActionPerformed(evt);
            }
        });

        txFCode.setBackground(new java.awt.Color(51, 51, 51));
        txFCode.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        txFCode.setForeground(new java.awt.Color(0, 255, 255));
        txFCode.setCaretColor(new java.awt.Color(255, 255, 255));
        txFCode.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txFCode.setMargin(new java.awt.Insets(2, 7, 2, 7));
        txFCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txFCodeKeyTyped(evt);
            }
        });

        lblSelectedDescription.setFont(new java.awt.Font("Segoe UI Semilight", 2, 14)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, txDesc, org.jdesktop.beansbinding.ELProperty.create("${text}"), lblSelectedDescription, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lblSelectedCode.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lblSelectedCode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSelectedCode.setAlignmentX(0.5F);
        lblSelectedCode.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, txFCode, org.jdesktop.beansbinding.ELProperty.create("${text}"), lblSelectedCode, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Selected Recipe");

        lblSPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSPrice.setText(SPrice.toString());

        btnList.setText("List");
        btnList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(txDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(btnConfirmRecipe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txFCode, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sugestPrice)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSPrice))
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAddMateria)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveMateria))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClearRecipe))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblSelectedCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSelectedDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnClearRecipe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSelectedDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(lblSelectedCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txFCode))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sugestPrice)
                            .addComponent(lblSPrice))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAddMateria)
                        .addComponent(btnRemoveMateria))
                    .addComponent(btnConfirmRecipe))
                .addGap(32, 32, 32))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMateriaActionPerformed
//        if(FrmInvent != null) {
//            if(FrmInvent.isVisible() == false)
//                FrmInvent.setVisible(true);
//            else {
//                FrmInvent.requestFocus();
//            }
//        } else {
//            FrmInvent = Inventory.getInstance();            
//            FrmInvent.setVisible(true);            
//        }
        RMDialog.setVisible(true);
        if(RMDialog.DATA == null) {
            System.out.println("Gak jadi masukin");
            RMDialog.resetAll();
        }else {
            addMateriaToTable(RMDialog.DATA);
            RMDialog.dispose();
            RMDialog.resetAll();
        }
    }//GEN-LAST:event_btnAddMateriaActionPerformed

    private void btnClearRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearRecipeActionPerformed
        tabmode = (DefaultTableModel) tblMateria.getModel();
        tblMateria.setModel(tabmode);
        tabmode.setRowCount(0);
        txFCode.setEnabled(true);
        txFCode.setText("\r");
        lblSelectedCode.setText("");
        lblSelectedDescription.setText("");
        txDesc.setText("");
        txPrice.setText("");
        txDesc.setEnabled(true);
        txPrice.setEnabled(true);
        btnList.setEnabled(true);
        updateState = false;
    }//GEN-LAST:event_btnClearRecipeActionPerformed

    private void txFCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txFCodeKeyTyped
        char vchar = evt.getKeyChar();
        if(vchar == KeyEvent.VK_ENTER) {            
            lookupFBCode();
        }        
    }//GEN-LAST:event_txFCodeKeyTyped

    private void btnRemoveMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveMateriaActionPerformed
        tabmode.removeRow(tblMateria.getSelectedRow());
        tblMateria.clearSelection();
        hitungCost();
    }//GEN-LAST:event_btnRemoveMateriaActionPerformed

    private void txDescKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDescKeyTyped
        if(evt.getKeyChar() == KeyEvent.VK_ENTER) {
            lookupFBCode();
            txDesc.setEnabled(false);
        }
    }//GEN-LAST:event_txDescKeyTyped

    private void btnConfirmRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmRecipeActionPerformed
        Object[] CONT_RECIPE, CONT_FOODB;
        if(updateState) {
            int ch = JOptionPane.showConfirmDialog(this,"Data sebelumnya akan terhapus dan tidak bisa\n"
                + "dikembalikan lagi. Apakah anda yakin?","Update Data",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
            if (ch == 0){
                SQL = "UPDATE foodbeve SET Deskripsi=?, Harga=? \n"
                    + "WHERE fbCode=? ";
                CONT_FOODB = new Object[3]; CONT_RECIPE = new Object[3];
                CONT_FOODB[0] = txDesc.getText();
                CONT_FOODB[1] = Double.valueOf(txPrice.getText());
                CONT_FOODB[2] = txFCode.getText();
                try {
                    db.setSTMT(SQL);
                    db.insertSQL(CONT_FOODB, "foodBeve", "fbCode");
                    SQL = "DELETE FROM recipe WHERE fbCode=?";
                    db.deleteSQL(txFCode.getText(), SQL);
                    //update new recipe table
                    SQL = "INSERT INTO recipe VALUES(?, ?, ?)";
                    int totalRow = tabmode.getRowCount();
                    for(int x=0; x<totalRow; x++) {
                        CONT_RECIPE[0] = txFCode.getText();
                        CONT_RECIPE[1] = tabmode.getValueAt(x, 0);
                        CONT_RECIPE[2] = tabmode.getValueAt(x, 2);
                        db.setSTMT(SQL);
                        db.insertSQL(CONT_RECIPE, "recipe", "fbCode");
                    }
                } catch(SQLException ex) {
                    ex.printStackTrace();
                }
                System.out.println("Yah di Update dong");
                RLDialog.initTableView();
                updateState = false;
            }
        } else {
            System.out.println("Oke data baruuu");
        }
    }//GEN-LAST:event_btnConfirmRecipeActionPerformed

    private void txPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPriceKeyTyped
        char vchar = evt.getKeyChar();
        if(!(Character.isDigit(vchar))
            || (vchar == KeyEvent.VK_BACKSPACE)
            || (vchar == KeyEvent.VK_DELETE)
            || (vchar == KeyEvent.VK_PERIOD))
            evt.consume();
    }//GEN-LAST:event_txPriceKeyTyped

    private void btnListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListActionPerformed
        RLDialog.setVisible(true);
        if(RLDialog.DATA == null) {
            System.out.println("Gak jadi masukin");            
        }else {            
            txFCode.setText(RLDialog.DATA[0].toString());
            lookupFBCode();
            txFCode.setEnabled(false);
            btnList.setEnabled(false);
        }
        RLDialog.dispose();
        RLDialog.initTableView();
    }//GEN-LAST:event_btnListActionPerformed

    public void addMateriaToTable(Object[] DATA){
        tabmode.addRow(DATA);
        hitungCost();
    }
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
            java.util.logging.Logger.getLogger(Recipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recipe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMateria;
    private javax.swing.JButton btnClearRecipe;
    private javax.swing.JButton btnConfirmRecipe;
    private javax.swing.JButton btnList;
    private javax.swing.JButton btnRemoveMateria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSPrice;
    private javax.swing.JLabel lblSelectedCode;
    private javax.swing.JLabel lblSelectedDescription;
    private javax.swing.JLabel sugestPrice;
    private javax.swing.JTable tblMateria;
    private javax.swing.JTextField txDesc;
    private javax.swing.JTextField txFCode;
    private javax.swing.JTextField txPrice;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
