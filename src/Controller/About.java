/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author REDHAT
 */
public class About extends javax.swing.JFrame {
    int mosX, mosY;
    /**
     * Creates new form About
     */
    public About() {
        initComponents();
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

        panelGradient1 = new Model.PanelGradient();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelGradient1.setBackground(new java.awt.Color(204, 255, 255));
        panelGradient1.setForeground(new java.awt.Color(204, 255, 255));
        panelGradient1.setBackgroundPainted(true);
        panelGradient1.setGradientBackgroundColor(new java.awt.Color(204, 255, 204));
        panelGradient1.setGradientFocus(500);
        panelGradient1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelGradient1MouseDragged(evt);
            }
        });
        panelGradient1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelGradient1MousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setText("<html>  <style>  b {      color: #d65a31; }  i{ padding-left:70px; display:block}  a:link, a:active, a {    text-decoration: none;    color: #d65a31;    font-weight: bold; }  </style>  <body> <b>MakanDong</b> merupakan Aplikasi Penjualan untuk Rumah Makan, Program ini dibuat untuk mempermudah pencatatan penjualan serta otomatisasi laporan dan pengelolaan bahan makanan<hr><br>  Software ini dibuat untuk memenuhi tugas matakuliah <b>Kuliah Kerja Praktek (KKP)</b> sebagai salah satu syarat untuk menempuh Skripsi S1<br><center><h2>Terima Kasih kepada <b>R.E dan R.F</b> angkatan 2016 atas segala kekompakan dan dukungannya</h2> Siti Nur Afifah 2016 4350 0317<br>Muhammad Imam Abdullah 2016 4350 0321<br>Majidatun Ni'mah 2016 4350 0326<br>Maulidhya 2016 4350 0329<br>Afrah Fatmawati 2016 4350 0355<br>Shofalina 2016 4350 0385<br>Rizka Lita Syahputri 2016 4350 0388<br>Ersa Putri Utami 2016 4350 0388 <br><br><br>  <i>\" Buka Mata, Buka Telinga \"- LUMEN*</i> </center><br><hr><b>CONTACT ME</b><br>  <b>Github</b> : https://github.com/flashlf<br>  <b>Facebook</b> : https://facebook.com/cmetamorph<br>  <b>Instagram</b> : @sohpos<br>  <b>E-Mail</b> : sanghyangismaya@merahputih.id<br><b>CREDIT Iconpack used</b><br> Icons made by <a href=\"https://www.flaticon.com/authors/gregor-cresnar\" title=\"Gregor Cresnar\">Gregor Cresnar</a> and <a href=\"https://www.flaticon.com/authors/freepik\" title=\"Freepik\">Freepik</a> from <a href=\"https://www.flaticon.com/\" title=\"Flaticon\"> www.flaticon.com</a>   </body> </html>");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel2.setText("ABOUT MakanDong App");

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/32/cancelClicked32.png"))); // NOI18N
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelGradient1Layout = new javax.swing.GroupLayout(panelGradient1);
        panelGradient1.setLayout(panelGradient1Layout);
        panelGradient1Layout.setHorizontalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelGradient1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClose))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        panelGradient1Layout.setVerticalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCloseMouseClicked

    private void panelGradient1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelGradient1MousePressed
        mosX = evt.getX();
        mosY = evt.getY();
    }//GEN-LAST:event_panelGradient1MousePressed

    private void panelGradient1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelGradient1MouseDragged
        int coordX = evt.getXOnScreen(), coordY = evt.getYOnScreen();
        this.setLocation(coordX-mosX, coordY-mosY);
    }//GEN-LAST:event_panelGradient1MouseDragged

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
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new About().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private Model.PanelGradient panelGradient1;
    // End of variables declaration//GEN-END:variables
}