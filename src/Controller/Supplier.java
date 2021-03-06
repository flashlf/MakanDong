/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.HandlerComponent;
import Model.Database;
import com.sun.javafx.util.Utils;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.Document;
/**
 *
 * @author REDHAT
 */
public class Supplier extends javax.swing.JFrame {
    Document SCDoc;
    DefaultTableModel tabmode;
    HandlerComponent handlerComp;
    HandlerComponent.LimitInput LI;
    ReStockInventory reInvent;
    MainMenu mm;
    Database db = new Database();
    Boolean status = false;
    public String SQL;
    public static String[] MCODE = new String[50];
    int mosX, mosY;
    /**
     * Creates new form Supplier
     */
    public Supplier() {
        initComponents();
        ((AbstractDocument) txSCode.getDocument()).setDocumentFilter(new HandlerComponent.LimitInput(4));
        try {
            SQL = "SELECT * FROM Supplier";
            handlerComp = new HandlerComponent();
            tabmode = handlerComp.initTable(tableSupplier, SQL, db, tabmode);
            SQL = "SELECT *\n"+
                  "FROM material";
            handlerComp.initComboBox(cbMCode, SQL, db, MCODE);
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftPanel = new Model.PanelGradient();
        btnRestock = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSupplier = new javax.swing.JTable();
        txSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        rightPanel = new Model.PanelGradient();
        jLabel6 = new javax.swing.JLabel();
        txMCode = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txSCode = new javax.swing.JTextField();
        cbMCode = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txDesc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txAddress = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txTelephone = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        lblClose = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MakanDong | Supplier");
        setMaximizedBounds(new java.awt.Rectangle(756, 449, 449, 449));
        setMaximumSize(new java.awt.Dimension(756, 449));
        setUndecorated(true);
        setResizable(false);

        leftPanel.setBackground(new java.awt.Color(0, 153, 204));
        leftPanel.setGradientBackgroundColor(new java.awt.Color(0, 0, 102));
        leftPanel.setGradientFocus(500);
        leftPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                leftPanelMouseDragged(evt);
            }
        });
        leftPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                leftPanelMousePressed(evt);
            }
        });

        btnRestock.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnRestock.setText("Restock Bahan Baku");
        btnRestock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestockActionPerformed(evt);
            }
        });

        tableSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Supplier", "Supplier", "Kode Bahan Baku", "Alamat", "Telephone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSupplier.setShowHorizontalLines(false);
        tableSupplier.getTableHeader().setReorderingAllowed(false);
        tableSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSupplierMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSupplier);
        tableSupplier.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tableSupplier.getColumnModel().getColumnCount() > 0) {
            tableSupplier.getColumnModel().getColumn(0).setResizable(false);
        }

        txSearch.setText("Search Value......");
        txSearch.setMargin(new java.awt.Insets(2, 7, 2, 2));
        txSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txSearchFocusGained(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/16/search16.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Supplier");

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnRestock)
                        .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(leftPanelLayout.createSequentialGroup()
                                .addComponent(txSearch)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRestock, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        rightPanel.setBackground(new java.awt.Color(0, 0, 102));
        rightPanel.setGradientBackgroundColor(new java.awt.Color(10, 10, 112));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Kode Bahan Baku");

        txMCode.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txMCode.setForeground(new java.awt.Color(153, 255, 255));
        txMCode.setText("M001");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Kode Supplier");

        txSCode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txSCode.setMargin(new java.awt.Insets(2, 7, 2, 7));
        txSCode.setMaximumSize(new java.awt.Dimension(16, 21));

        cbMCode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMCodeItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama Supplier");

        txDesc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txDesc.setText("Lorem Ipsum");
        txDesc.setMargin(new java.awt.Insets(2, 7, 2, 7));
        txDesc.setMaximumSize(new java.awt.Dimension(87, 21));
        txDesc.setMinimumSize(new java.awt.Dimension(87, 21));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Alamat");

        txAddress.setColumns(20);
        txAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txAddress.setLineWrap(true);
        txAddress.setRows(5);
        txAddress.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. \nSed sit amet urna consequat, pellentesque quam quis, pulvinar ipsum. \nAliquam dapibus augue vitae ex mattis, quis consequat lectus accumsan. \nMaecenas ultrices sem libero. Pellentesque a dignissim libero. \nPhasellus risus mi, commodo vitae dui vitae, porta cursus odio. \nAenean rutrum nisi interdum arcu tincidunt vehicula. \nSed cursus augue a sagittis ultrices. \nInteger congue erat efficitur, efficitur arcu non, lacinia tellus.");
        txAddress.setWrapStyleWord(true);
        txAddress.setMargin(new java.awt.Insets(2, 7, 2, 7));
        txAddress.setMaximumSize(new java.awt.Dimension(254, 164));
        txAddress.setMinimumSize(new java.awt.Dimension(254, 164));
        jScrollPane2.setViewportView(txAddress);

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("No Telepon");

        txTelephone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txTelephone.setText("081234567890");
        txTelephone.setMargin(new java.awt.Insets(2, 7, 2, 7));

        btnAdd.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/16/add16.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/16/delete16.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/16/update16.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/32/cancel32.png"))); // NOI18N
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txTelephone)
                            .addComponent(txDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(rightPanelLayout.createSequentialGroup()
                                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txSCode, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(rightPanelLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addGap(12, 12, 12)
                                        .addComponent(txMCode))
                                    .addComponent(cbMCode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(rightPanelLayout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate))
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(rightPanelLayout.createSequentialGroup()
                                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(32, 32, 32))
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblClose, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(txMCode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbMCode)
                    .addComponent(txSCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        SQL = "DELETE FROM supplier WHERE sCode = ?;";
        int ch = JOptionPane.showConfirmDialog(this,"Data akan Dihapus ?","Hapus Data",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
        if (ch == 0){
            try {
                int delrow = db.searchIndexDB(txSCode.getText(),"sCode","supplier");
                db.setSTMT(SQL);
                int del = db.deleteSQL(txSCode.getText());
                if(del == 1) {
                    tabmode.removeRow(delrow);
                    System.out.println("Baris "+(delrow+1)+" Berhasil Dihapus");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        SQL = "INSERT INTO supplier VALUES(?, ?, ?, ?, ?)";
        Object[] container = new Object[5];
        container[0] = txSCode.getText().trim();
        container[1] = txDesc.getText().trim();
        container[2] = txMCode.getText().trim();
        container[3] = txAddress.getText();
        container[4] = txTelephone.getText();
        try {
            db.setSTMT(SQL);
            db.insertSQL(container,"supplier","sCode");
            tabmode.addRow(container);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void cbMCodeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMCodeItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED && status == true) {
            int pointer = cbMCode.getSelectedIndex();
            System.out.println("Selected : "+MCODE[pointer]);
            String Query = "SELECT * FROM material\n"
                    + "WHERE mCode='"+MCODE[pointer]+"'";
            try {
                java.sql.ResultSet HASIL = db.getSQL(Query);
                HASIL.first();
                txMCode.setText(HASIL.getString(1)); 
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
       }
    }//GEN-LAST:event_cbMCodeItemStateChanged

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        SQL = "UPDATE supplier SET sCode=?, Deskripsi=?, mCode=?,Alamat=?,Telephone=? WHERE sCode=? AND mCode=?";
        Object[] container = new Object[7];
        container[0] = txSCode.getText().trim();
        container[1] = txDesc.getText().trim();
        container[2] = txMCode.getText().trim();
        container[3] = txAddress.getText();
        container[4] = txTelephone.getText();
        container[5] = txSCode.getText().trim();
        container[6] = txMCode.getText().trim();
        try {            
            int y = db.searchIndexDB(txSCode.getText(), "sCode", "supplier");
            db.setSTMT(SQL);
            db.insertSQL(container,"supplier","sCode");
            tableSupplier.setValueAt(txSCode.getText(), y, 0);
            tableSupplier.setValueAt(txDesc.getText(), y, 1);
            tableSupplier.setValueAt(txMCode.getText(), y, 2);
            tableSupplier.setValueAt(txAddress.getText(), y, 3);
            tableSupplier.setValueAt(txTelephone.getText(), y, 4);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tableSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSupplierMouseClicked
        if(evt.getClickCount() == 2 && !evt.isConsumed()) {
            txSCode.setText(tableSupplier.getValueAt(tableSupplier.getSelectedRow(),0).toString());
            txDesc.setText(tableSupplier.getValueAt(tableSupplier.getSelectedRow(),1).toString());
            txMCode.setText(tableSupplier.getValueAt(tableSupplier.getSelectedRow(),2).toString());
            txAddress.setText(tableSupplier.getValueAt(tableSupplier.getSelectedRow(),3).toString());
            txTelephone.setText(tableSupplier.getValueAt(tableSupplier.getSelectedRow(),4).toString());
            int pointer = Integer.parseInt(txMCode.getText().substring(1));
            cbMCode.setSelectedIndex(pointer-1); 
        }
    }//GEN-LAST:event_tableSupplierMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String cari = txSearch.getText();
        try {
            SQL = "SELECT * FROM Supplier WHERE sCode like '%"+cari+"%' "
                + "OR mCode like '%"+cari+"%' "
                + "OR Deskripsi like '%"+cari+"%' "
                + "OR Alamat like '%"+cari+"%' "
                + "OR Telephone like '%"+cari+"%' ";
            tabmode.setRowCount(0);
            tabmode = handlerComp.initTable(tableSupplier, SQL, db, tabmode);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnRestockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestockActionPerformed
        if(txSCode.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Pilih Supplier Terlebih dahulu");
        } else {
            reInvent = new ReStockInventory(this, true);
            reInvent.CONT_RESUPPLY = new Object[3];
            reInvent.CONT_RESUPPLY[0] = txSCode.getText().trim();
            reInvent.CONT_RESUPPLY[1] = cbMCode.getSelectedItem().toString();
            reInvent.CONT_RESUPPLY[2] = txDesc.getText();
            reInvent.setVisible(true);
            if(reInvent.CONFIRMED) {
                int ch = JOptionPane.showConfirmDialog(null, "Restock barang berhasil\nApakah anda ingin melihat laporan supply barang ?");
                if(ch == 0) {
                    System.out.println("Lihat Laporan");
                    Model.HandlerComponent.Report jReport = new HandlerComponent.Report();
                    jReport.setFileName("REPORT_HeadReInvent");
                    jReport.setParam("KodeSupplier",reInvent.CONT_RESUPPLY[0].toString());
                    String tgl[] = Utils.split(reInvent.CONT_RESUPPLY[1].toString(), "-");
                    jReport.setParam("Bulan", Integer.valueOf(tgl[1]));
                    jReport.setParam("Tahun", Integer.valueOf(tgl[0]));
                    jReport.printReport();
                } else {
                    System.out.println("Gajadi liat");
                }
                reInvent.CONFIRMED = false;
            }
        }
    }//GEN-LAST:event_btnRestockActionPerformed

    private void txSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txSearchFocusGained
        txSearch.selectAll();
    }//GEN-LAST:event_txSearchFocusGained

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        mm = MainMenu.getInstance();
        mm.setState(JFrame.NORMAL);
        mm.setVisible(true);
        mm.requestFocusInWindow();
        dispose();
    }//GEN-LAST:event_lblCloseMouseClicked

    private void leftPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftPanelMousePressed
        mosX = evt.getX();
        mosY = evt.getY();
    }//GEN-LAST:event_leftPanelMousePressed

    private void leftPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftPanelMouseDragged
        int coordX = evt.getXOnScreen(), coordY = evt.getYOnScreen();
        this.setLocation(coordX-mosX, coordY-mosY);
    }//GEN-LAST:event_leftPanelMouseDragged

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
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Supplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRestock;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbMCode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblClose;
    private Model.PanelGradient leftPanel;
    private Model.PanelGradient rightPanel;
    private javax.swing.JTable tableSupplier;
    private javax.swing.JTextArea txAddress;
    private javax.swing.JTextField txDesc;
    private javax.swing.JLabel txMCode;
    private javax.swing.JTextField txSCode;
    private javax.swing.JTextField txSearch;
    private javax.swing.JTextField txTelephone;
    // End of variables declaration//GEN-END:variables
}
