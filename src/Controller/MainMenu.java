/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author REDHAT
 */
public class MainMenu extends javax.swing.JFrame {
    Inventory frmInvent;
    Recipe frmRecipe;
    Order frmOrder;
    Supplier frmSupplier;
    Laporan frmLaporan;
    About frmAbout;
    SimpleDateFormat df;
    Date date;
    String format = "dd MMMMM yyyy";
    int mosX, mosY;
    public String UID;
    public String USER;
    /**
     * Creates new form MainMenu
     */
    public MainMenu() {   
        date = new Date();
        //UID = "N/A"; USER = "N/A";
        df = new SimpleDateFormat(format, new Locale("id", "ID"));
        df.format(date);
        initComponents();
        lblUser.setText(USER);
        lblUserPlaceHolder.setText("User ID : "+UID);
        setLocationRelativeTo(null);
    }
    public MainMenu(String User, String UID) {
        date = new Date();
        //UID = "N/A"; USER = "N/A";
        df = new SimpleDateFormat(format, new Locale("id", "ID"));
        df.format(date);
        initComponents();
        lblUser.setText(User);
        lblUserPlaceHolder.setText("User ID : "+UID);
        setLocationRelativeTo(null);
    }
    public void setUID(String aUID) {
        UID = aUID;
    }

    public void setUSER(String aUSER) {
        USER = aUSER;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblUserPlaceHolder = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        panelGradient1 = new Model.PanelGradient();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblLaporan1 = new javax.swing.JLabel();
        btnAbout = new javax.swing.JButton();
        lblLaporan2 = new javax.swing.JLabel();
        lblLaporan = new javax.swing.JLabel();
        btnReportMenu = new javax.swing.JButton();
        btnSupplierMenu = new javax.swing.JButton();
        lblSupplier = new javax.swing.JLabel();
        lblSupplier2 = new javax.swing.JLabel();
        btnOrderMenu = new javax.swing.JButton();
        btnRecipeMenu = new javax.swing.JButton();
        lblSupplier1 = new javax.swing.JLabel();
        btnInventMenu = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MakanDong");
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);

        sidePanel.setBackground(new java.awt.Color(0, 0, 51));
        sidePanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                sidePanelMouseDragged(evt);
            }
        });
        sidePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sidePanelMousePressed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/128/user128.png"))); // NOI18N

        lblUserPlaceHolder.setForeground(new java.awt.Color(255, 255, 255));
        lblUserPlaceHolder.setText("User ID :");
        lblUserPlaceHolder.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblUser.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setText(USER);
        lblUser.setToolTipText("Username");
        lblUser.setAlignmentY(0.0F);
        lblUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnLogout.setBackground(new java.awt.Color(255, 255, 255));
        btnLogout.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/16/logout16.png"))); // NOI18N
        btnLogout.setText("LOGOUT");
        btnLogout.setAlignmentY(0.0F);
        btnLogout.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnLogout.setIconTextGap(10);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUserPlaceHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUserPlaceHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        panelGradient1.setBackground(new java.awt.Color(0, 0, 102));
        panelGradient1.setGradientBackgroundColor(new java.awt.Color(0, 153, 255));
        panelGradient1.setGradientFocus(800);
        panelGradient1.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText(df.format(date));
        jLabel4.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("<html><a href=\"https://github.com/flashlf/MakanDong\" style=\"text-decoration:none; color:white;\">MakanDongs Apps Version 1.0</a></html>");

        lblLaporan1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblLaporan1.setForeground(new java.awt.Color(255, 255, 255));
        lblLaporan1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLaporan1.setText("Inventory");
        lblLaporan1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblLaporan1.setMaximumSize(new java.awt.Dimension(39, 14));
        lblLaporan1.setMinimumSize(new java.awt.Dimension(39, 14));
        lblLaporan1.setPreferredSize(new java.awt.Dimension(39, 14));

        btnAbout.setBackground(new java.awt.Color(255, 255, 255));
        btnAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/64/about64.png"))); // NOI18N
        btnAbout.setToolTipText("Info Aplikasi");
        btnAbout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAbout.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnAbout.setMaximumSize(new java.awt.Dimension(97, 97));
        btnAbout.setMinimumSize(new java.awt.Dimension(97, 97));
        btnAbout.setPreferredSize(new java.awt.Dimension(97, 97));
        btnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutActionPerformed(evt);
            }
        });

        lblLaporan2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblLaporan2.setForeground(new java.awt.Color(255, 255, 255));
        lblLaporan2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLaporan2.setText("Tentang Aplikasi");
        lblLaporan2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblLaporan2.setMaximumSize(new java.awt.Dimension(39, 14));
        lblLaporan2.setMinimumSize(new java.awt.Dimension(39, 14));
        lblLaporan2.setPreferredSize(new java.awt.Dimension(39, 14));

        lblLaporan.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblLaporan.setForeground(new java.awt.Color(255, 255, 255));
        lblLaporan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLaporan.setText("Laporan");
        lblLaporan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnReportMenu.setBackground(new java.awt.Color(204, 255, 204));
        btnReportMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/64/report64.png"))); // NOI18N
        btnReportMenu.setToolTipText("Menu Laporan");
        btnReportMenu.setAlignmentY(0.0F);
        btnReportMenu.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnReportMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReportMenu.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnReportMenu.setMaximumSize(new java.awt.Dimension(97, 97));
        btnReportMenu.setMinimumSize(new java.awt.Dimension(97, 97));
        btnReportMenu.setName(""); // NOI18N
        btnReportMenu.setPreferredSize(new java.awt.Dimension(97, 97));
        btnReportMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportMenuActionPerformed(evt);
            }
        });

        btnSupplierMenu.setBackground(new java.awt.Color(204, 255, 255));
        btnSupplierMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/64/product64.png"))); // NOI18N
        btnSupplierMenu.setToolTipText("Menu Supplier");
        btnSupplierMenu.setAlignmentY(0.0F);
        btnSupplierMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSupplierMenu.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnSupplierMenu.setMaximumSize(new java.awt.Dimension(97, 97));
        btnSupplierMenu.setMinimumSize(new java.awt.Dimension(97, 97));
        btnSupplierMenu.setPreferredSize(new java.awt.Dimension(97, 97));
        btnSupplierMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplierMenuActionPerformed(evt);
            }
        });

        lblSupplier.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblSupplier.setForeground(new java.awt.Color(255, 255, 255));
        lblSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSupplier.setText("Supplier");
        lblSupplier.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblSupplier.setMaximumSize(new java.awt.Dimension(39, 14));
        lblSupplier.setMinimumSize(new java.awt.Dimension(39, 14));
        lblSupplier.setPreferredSize(new java.awt.Dimension(39, 14));

        lblSupplier2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblSupplier2.setForeground(new java.awt.Color(255, 255, 255));
        lblSupplier2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSupplier2.setText("Pesanan");
        lblSupplier2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblSupplier2.setMaximumSize(new java.awt.Dimension(39, 14));
        lblSupplier2.setMinimumSize(new java.awt.Dimension(39, 14));
        lblSupplier2.setPreferredSize(new java.awt.Dimension(39, 14));

        btnOrderMenu.setBackground(new java.awt.Color(255, 204, 204));
        btnOrderMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/64/shopping64.png"))); // NOI18N
        btnOrderMenu.setToolTipText("Menu Pesan Makanan");
        btnOrderMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOrderMenu.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnOrderMenu.setMaximumSize(new java.awt.Dimension(97, 97));
        btnOrderMenu.setMinimumSize(new java.awt.Dimension(97, 97));
        btnOrderMenu.setPreferredSize(new java.awt.Dimension(97, 97));
        btnOrderMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderMenuActionPerformed(evt);
            }
        });

        btnRecipeMenu.setBackground(new java.awt.Color(255, 255, 204));
        btnRecipeMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/64/writer64.png"))); // NOI18N
        btnRecipeMenu.setToolTipText("Menu Pengelolaan Resep");
        btnRecipeMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRecipeMenu.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnRecipeMenu.setMaximumSize(new java.awt.Dimension(97, 97));
        btnRecipeMenu.setMinimumSize(new java.awt.Dimension(97, 97));
        btnRecipeMenu.setPreferredSize(new java.awt.Dimension(97, 97));
        btnRecipeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecipeMenuActionPerformed(evt);
            }
        });

        lblSupplier1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblSupplier1.setForeground(new java.awt.Color(255, 255, 255));
        lblSupplier1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSupplier1.setText("Resep");
        lblSupplier1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblSupplier1.setMaximumSize(new java.awt.Dimension(39, 14));
        lblSupplier1.setMinimumSize(new java.awt.Dimension(39, 14));
        lblSupplier1.setPreferredSize(new java.awt.Dimension(39, 14));

        btnInventMenu.setBackground(new java.awt.Color(204, 204, 204));
        btnInventMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/64/box64.png"))); // NOI18N
        btnInventMenu.setToolTipText("Menu Inventory Barang");
        btnInventMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInventMenu.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnInventMenu.setMaximumSize(new java.awt.Dimension(97, 97));
        btnInventMenu.setMinimumSize(new java.awt.Dimension(97, 97));
        btnInventMenu.setPreferredSize(new java.awt.Dimension(97, 97));
        btnInventMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventMenuActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Main Menu");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/32/cancel32.png"))); // NOI18N
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelGradient1Layout = new javax.swing.GroupLayout(panelGradient1);
        panelGradient1.setLayout(panelGradient1Layout);
        panelGradient1Layout.setHorizontalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGradient1Layout.createSequentialGroup()
                        .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGradient1Layout.createSequentialGroup()
                                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnInventMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRecipeMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblLaporan1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSupplier1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAbout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnOrderMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSupplier2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblLaporan2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnSupplierMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnReportMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelGradient1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(66, Short.MAX_VALUE))
                    .addGroup(panelGradient1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(32, 32, 32))))
        );
        panelGradient1Layout.setVerticalGroup(
            panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGradient1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnOrderMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRecipeMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSupplierMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSupplier1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSupplier2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAbout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInventMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReportMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLaporan1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLaporan2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(panelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelGradient1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrderMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderMenuActionPerformed
        frmOrder = new Order();
        frmOrder.setVisible(true);
        this.setState(ICONIFIED);
    }//GEN-LAST:event_btnOrderMenuActionPerformed

    private void btnRecipeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecipeMenuActionPerformed
        frmRecipe = new Recipe();
        frmRecipe.setVisible(true);
        this.setState(ICONIFIED);
    }//GEN-LAST:event_btnRecipeMenuActionPerformed

    private void btnInventMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventMenuActionPerformed
        frmInvent = Inventory.getInstance();
        frmInvent.setVisible(true);
        this.setState(ICONIFIED);
    }//GEN-LAST:event_btnInventMenuActionPerformed

    private void btnSupplierMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierMenuActionPerformed
        frmSupplier = new Supplier();
        frmSupplier.setVisible(true);
        this.setState(ICONIFIED);
    }//GEN-LAST:event_btnSupplierMenuActionPerformed

    private void btnReportMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportMenuActionPerformed
        frmLaporan = new Laporan();
        frmLaporan.setVisible(true);
        this.setState(ICONIFIED);
    }//GEN-LAST:event_btnReportMenuActionPerformed

    private void sidePanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidePanelMousePressed
        mosX = evt.getX();
        mosY = evt.getY();
    }//GEN-LAST:event_sidePanelMousePressed

    private void sidePanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidePanelMouseDragged
        int coordX = evt.getXOnScreen(), coordY = evt.getYOnScreen();
        this.setLocation(coordX-mosX, coordY-mosY);
    }//GEN-LAST:event_sidePanelMouseDragged

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        int ch = JOptionPane.showConfirmDialog(null, "Anda menekan tombol close.\nAplikasi akan berhenti total,\nseluruh perubahan data tidak akan tersimpan.\nApakah anda yakin?","Warning",2);
        if(ch== 0)
            System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        this.dispose();
        Login log = new Login(); log.setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAboutActionPerformed
        frmAbout = new About(); frmAbout.setVisible(true);
    }//GEN-LAST:event_btnAboutActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbout;
    private javax.swing.JButton btnInventMenu;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnOrderMenu;
    private javax.swing.JButton btnRecipeMenu;
    private javax.swing.JButton btnReportMenu;
    private javax.swing.JButton btnSupplierMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblLaporan;
    private javax.swing.JLabel lblLaporan1;
    private javax.swing.JLabel lblLaporan2;
    private javax.swing.JLabel lblSupplier;
    private javax.swing.JLabel lblSupplier1;
    private javax.swing.JLabel lblSupplier2;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUserPlaceHolder;
    private Model.PanelGradient panelGradient1;
    private javax.swing.JPanel sidePanel;
    // End of variables declaration//GEN-END:variables
}
