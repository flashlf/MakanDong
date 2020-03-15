/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import Model.HandlerComponent.LimitInput;
import com.sun.glass.events.KeyEvent;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
/**
 *
 * @author REDHAT
 */
public class Order extends javax.swing.JFrame {
    Boolean status = false;
    Database db = new Database();
    Date date = new Date();
    DateFormat df;
    LimitInput LI;
    DefaultTableModel tbModOrder;
    HandlerComponent handlerComp;
    ImageIcon[] food = new ImageIcon[16], beve = new ImageIcon[5];
    ResultSet RSET;
    MainMenu mmInstance;
    int mosX, mosY;
    public String SQL;
    public static String[] DATAF = new String[50], DATAB = new String[50];
    public int noOrder=1;
    public static Double tCost=0.0;
    
    public static String[] 
        imgFood = {"/Img/nasiPutih.jpg","/Img/ayamGoreng.jpg",
            "/Img/ayamBakar.jpg","/Img/leleGoreng.jpg","/Img/leleBakar.jpg",
            "/Img/masGoreng.jpg","/Img/masBakar.jpg","/Img/bawalGoreng.jpg",
            "/Img/bawalBakar.jpg","/Img/atiAmpela.jpg","/Img/kulitAyam.jpg",
            "/Img/cekerAyam.jpg","/Img/terongGoreng.jpg","/Img/tahuTempe.jpg",
            "/Img/cahKangkung.jpg","/Img/ususAyam.jpg"},
        imgBeve = {"/Img/esTeh.jpg","/Img/esJeruk.jpg","/Img/aquaBotol.jpg",
            "/Img/freshTea.jpg","/Img/tehBotol.jpg"};
    /**
     * Creates new form Order
     */
    public Order() {
        initComponents();
        mmInstance = MainMenu.getInstance();
        df = new SimpleDateFormat("yyyy-MM-dd");
        dtChooser.setDateFormat(df);
        dtChooser.setText(date.getYear()+"-"+(date.getMonth()+1)+"-"+date.getDate());
        ((AbstractDocument) txOrderCode.getDocument()).setDocumentFilter(new HandlerComponent.LimitInput(4));
        gambarMenu();
        try {
            SQL = "SELECT *\n"+
                  "FROM foodbeve \n"+
                  "WHERE fbCode like 'F%'";
            handlerComp = new HandlerComponent();
            handlerComp.initComboBox(cbMenuFood, SQL, db, DATAF);
            SQL = "SELECT *\n"+
                  "FROM foodbeve \n"+
                  "WHERE fbCode like 'D%'";
            handlerComp.initComboBox(cbMenuBeve, SQL, db, DATAB);
            status = true;
            System.out.println(date.toString());
            txOrderCode.setText(db.generateOrderID());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        setLocationRelativeTo(null);
    }
    
    public void hitungCost() {
        int size = tblOrder.getRowCount();
        if(size != -1 || size != 0) {
            tCost = 0.0;
            for (int x=0; x<size; x++){
                String price = String.valueOf(tbModOrder.getValueAt(x, 4));
                tCost += Double.valueOf(price);
            }
            lblTotalCost.setText(""+tCost);
        }
    }
    public void gambarMenu() {
        for(int x=0; x<16; x++) {
            food[x] = new ImageIcon(new ImageIcon(getClass().getResource(imgFood[x])).getImage().getScaledInstance(fdContainer.getWidth(), fdContainer.getHeight(), Image.SCALE_SMOOTH));
        }
        for(int x=0; x<5; x++) {
            beve[x] = new ImageIcon(new ImageIcon(getClass().getResource(imgBeve[x])).getImage().getScaledInstance(fdContainer.getWidth(), fdContainer.getHeight(), Image.SCALE_SMOOTH));
        }
        fdContainer.setIcon(food[0]); bvContainer.setIcon(beve[0]);
    }
    public int cekInventory() {
        int result =0;
        SQL = "SELECT material.Deskripsi, inventory.stock, inventory.needRestock,\n" +
            "(SELECT COUNT(mCode) FROM (SELECT * FROM inventory\n" +
            "WHERE stock <= needRestock) Warn) \n" +
            "FROM inventory, material\n" +
            "WHERE inventory.mCode = material.mCode\n" +
            "AND inventory.stock <= inventory.needRestock";
        try {
            RSET = db.getSQL(SQL);
            while(RSET.next()) {
                result++;
                System.out.println("Bahan Baku "+RSET.getString(1)+" menipis\n"
                        + "Stock : "+RSET.getInt(2));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    void clearOrder() {
            txDownPayment.setText("");        
            txOrderCode.setText(db.generateOrderID());
            txOrderName.setText("");
            tbModOrder.setRowCount(0); lblTotalCost.setText("0.0");
            txQtyBeve.setText("1"); txQtyFood.setText("1");
            cbMenuBeve.setSelectedIndex(0); cbMenuFood.setSelectedIndex(0);
            noOrder = 1;            
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        orderType = new javax.swing.ButtonGroup();
        pnlMain = new Model.PanelGradient();
        jLabel10 = new javax.swing.JLabel();
        pnlFood = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txQtyFood = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbMenuFood = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnAddFood = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lPriceFood = new javax.swing.JLabel();
        fdContainer = new javax.swing.JLabel();
        pnlDrink = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbMenuBeve = new javax.swing.JComboBox<>();
        lMenuBeve = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnAddBeve = new javax.swing.JButton();
        txQtyBeve = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lPriceBeve = new javax.swing.JLabel();
        bvContainer = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        lblNomorOrder = new javax.swing.JLabel();
        txOrderCode = new javax.swing.JTextField();
        lblTanggal = new javax.swing.JLabel();
        dtChooser = new datechooser.beans.DateChooserCombo();
        jLabel11 = new javax.swing.JLabel();
        txOrderName = new javax.swing.JTextField();
        lblSumCost = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblTotalCost = new javax.swing.JLabel();
        lblTipeOrder = new javax.swing.JLabel();
        normal = new javax.swing.JRadioButton();
        catering = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        txDownPayment = new javax.swing.JTextField();
        btnConfirmItem = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnRemoveItem = new javax.swing.JButton();
        lblDaftarPesanan = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MakanDong | Form Pemesanan");
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlMain.setBackground(new java.awt.Color(157, 11, 11));
        pnlMain.setGradientBackgroundColor(new java.awt.Color(235, 130, 66));
        pnlMain.setGradientFocus(300);
        pnlMain.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlMainMouseDragged(evt);
            }
        });
        pnlMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlMainMousePressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Order Form");

        pnlFood.setBackground(new java.awt.Color(218, 45, 45));
        pnlFood.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(157, 11, 11), 1, true));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(246, 218, 99));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Qty");

        txQtyFood.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txQtyFood.setText("1");
        txQtyFood.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txQtyFoodKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(246, 218, 99));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Menu");
        jLabel3.setPreferredSize(new java.awt.Dimension(45, 20));

        cbMenuFood.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbMenuFood.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMenuFoodItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(246, 218, 99));
        jLabel5.setText("Makanan");

        btnAddFood.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/16/add16.png"))); // NOI18N
        btnAddFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFoodActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(246, 218, 99));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Rp.");

        lPriceFood.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lPriceFood.setForeground(new java.awt.Color(246, 218, 99));
        lPriceFood.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lPriceFood.setText("5000.0");

        fdContainer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fdContainer.setIconTextGap(0);

        javax.swing.GroupLayout pnlFoodLayout = new javax.swing.GroupLayout(pnlFood);
        pnlFood.setLayout(pnlFoodLayout);
        pnlFoodLayout.setHorizontalGroup(
            pnlFoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFoodLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(pnlFoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlFoodLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txQtyFood, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddFood, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbMenuFood, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFoodLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lPriceFood, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fdContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        pnlFoodLayout.setVerticalGroup(
            pnlFoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFoodLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fdContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lPriceFood))
                .addGap(6, 6, 6)
                .addComponent(cbMenuFood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(pnlFoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFoodLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addGroup(pnlFoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txQtyFood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddFood)))
                .addContainerGap())
        );

        pnlDrink.setBackground(new java.awt.Color(218, 45, 45));
        pnlDrink.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(157, 11, 11), 1, true));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(246, 218, 99));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Rp.");

        cbMenuBeve.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbMenuBeve.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMenuBeveItemStateChanged(evt);
            }
        });

        lMenuBeve.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lMenuBeve.setForeground(new java.awt.Color(246, 218, 99));
        lMenuBeve.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lMenuBeve.setText("Menu");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(246, 218, 99));
        jLabel6.setText("Minuman");

        btnAddBeve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/16/add16.png"))); // NOI18N
        btnAddBeve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBeveActionPerformed(evt);
            }
        });

        txQtyBeve.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txQtyBeve.setText("1");
        txQtyBeve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txQtyBeveActionPerformed(evt);
            }
        });
        txQtyBeve.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txQtyBeveKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(246, 218, 99));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Qty");

        lPriceBeve.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lPriceBeve.setForeground(new java.awt.Color(246, 218, 99));
        lPriceBeve.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lPriceBeve.setText("3000.0");

        bvContainer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlDrinkLayout = new javax.swing.GroupLayout(pnlDrink);
        pnlDrink.setLayout(pnlDrinkLayout);
        pnlDrinkLayout.setHorizontalGroup(
            pnlDrinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDrinkLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlDrinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bvContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbMenuBeve, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDrinkLayout.createSequentialGroup()
                        .addComponent(lMenuBeve, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lPriceBeve, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDrinkLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txQtyBeve, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddBeve, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        pnlDrinkLayout.setVerticalGroup(
            pnlDrinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDrinkLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bvContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDrinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lMenuBeve)
                    .addComponent(jLabel2)
                    .addComponent(lPriceBeve))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbMenuBeve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDrinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txQtyBeve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddBeve))
                .addContainerGap())
        );

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Desc", "Qty", "Price", "Total", "mCode"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrder.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblOrder);
        if (tblOrder.getColumnModel().getColumnCount() > 0) {
            tblOrder.getColumnModel().getColumn(0).setResizable(false);
            tblOrder.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblOrder.getColumnModel().getColumn(2).setMinWidth(25);
            tblOrder.getColumnModel().getColumn(2).setPreferredWidth(30);
            tblOrder.getColumnModel().getColumn(2).setMaxWidth(40);
            tblOrder.getColumnModel().getColumn(5).setMinWidth(0);
            tblOrder.getColumnModel().getColumn(5).setPreferredWidth(0);
            tblOrder.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        lblNomorOrder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNomorOrder.setForeground(new java.awt.Color(255, 255, 255));
        lblNomorOrder.setText("Nomor Order");

        txOrderCode.setColumns(4);
        txOrderCode.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txOrderCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txOrderCodeKeyTyped(evt);
            }
        });

        lblTanggal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTanggal.setForeground(new java.awt.Color(255, 255, 255));
        lblTanggal.setText("Tanggal");

        dtChooser.setCurrentView(new datechooser.view.appearance.AppearancesList("Light",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    dtChooser.setCalendarPreferredSize(new java.awt.Dimension(250, 200));
    try {
        dtChooser.setForbiddenPeriods(new datechooser.model.multiple.PeriodSet());
    } catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
        e1.printStackTrace();
    }
    dtChooser.setLocale(new java.util.Locale("in", "ID", ""));
    dtChooser.setMinDate(new java.util.GregorianCalendar(date.getYear(), date.getMonth(), date.getDate()));
    dtChooser.setNavigateFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 11));
    dtChooser.setShowOneMonth(true);

    jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel11.setForeground(new java.awt.Color(255, 255, 255));
    jLabel11.setText("Nama Pemesan");

    txOrderName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

    lblSumCost.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    lblSumCost.setForeground(new java.awt.Color(255, 255, 255));
    lblSumCost.setText("Total Cost");

    jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    jLabel13.setForeground(new java.awt.Color(255, 255, 255));
    jLabel13.setText("Rp.");

    lblTotalCost.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
    lblTotalCost.setForeground(new java.awt.Color(255, 255, 255));
    lblTotalCost.setText("1.234.567,00");
    lblTotalCost.setMaximumSize(new java.awt.Dimension(90, 16));
    lblTotalCost.setMinimumSize(new java.awt.Dimension(90, 16));
    lblTotalCost.setPreferredSize(new java.awt.Dimension(90, 16));

    lblTipeOrder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    lblTipeOrder.setForeground(new java.awt.Color(255, 255, 255));
    lblTipeOrder.setText("Tipe Order");

    orderType.add(normal);
    normal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    normal.setForeground(new java.awt.Color(255, 255, 255));
    normal.setSelected(true);
    normal.setText("Normal");
    normal.setOpaque(false);
    normal.addChangeListener(new javax.swing.event.ChangeListener() {
        public void stateChanged(javax.swing.event.ChangeEvent evt) {
            normalStateChanged(evt);
        }
    });

    orderType.add(catering);
    catering.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    catering.setForeground(new java.awt.Color(255, 255, 255));
    catering.setText("Catering");
    catering.setOpaque(false);
    catering.addChangeListener(new javax.swing.event.ChangeListener() {
        public void stateChanged(javax.swing.event.ChangeEvent evt) {
            cateringStateChanged(evt);
        }
    });

    jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel15.setForeground(new java.awt.Color(255, 255, 255));
    jLabel15.setText("Down Payment");

    txDownPayment.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    txDownPayment.setText("0.0");
    txDownPayment.setEnabled(false);
    txDownPayment.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txDownPaymentKeyTyped(evt);
        }
    });

    btnConfirmItem.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
    btnConfirmItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/32/order32.png"))); // NOI18N
    btnConfirmItem.setText("Pesan");
    btnConfirmItem.setIconTextGap(10);
    btnConfirmItem.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnConfirmItemActionPerformed(evt);
        }
    });

    btnCancel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
    btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/16/cancel16.png"))); // NOI18N
    btnCancel.setText("Batal");
    btnCancel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCancelActionPerformed(evt);
        }
    });

    btnRemoveItem.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
    btnRemoveItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/16/delete16.png"))); // NOI18N
    btnRemoveItem.setText("Hapus");
    btnRemoveItem.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRemoveItemActionPerformed(evt);
        }
    });

    lblDaftarPesanan.setFont(new java.awt.Font("Segoe UI Semibold", 2, 12)); // NOI18N
    lblDaftarPesanan.setForeground(new java.awt.Color(255, 255, 255));
    lblDaftarPesanan.setText(" Daftar Pesanan :");
    lblDaftarPesanan.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

    btnClose.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Icon/32/cancel32.png"))); // NOI18N
    btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btnCloseMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
    pnlMain.setLayout(pnlMainLayout);
    pnlMainLayout.setHorizontalGroup(
        pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnlMainLayout.createSequentialGroup()
            .addGap(32, 32, 32)
            .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlMainLayout.createSequentialGroup()
                    .addComponent(jLabel10)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(pnlMainLayout.createSequentialGroup()
                    .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txDownPayment, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblNomorOrder)
                                .addComponent(lblTanggal)
                                .addComponent(jLabel11)
                                .addComponent(txOrderCode, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(dtChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(txOrderName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblTipeOrder)
                                .addGroup(pnlMainLayout.createSequentialGroup()
                                    .addComponent(normal)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(catering))
                                .addComponent(jLabel15)))
                        .addComponent(lblSumCost)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnConfirmItem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMainLayout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTotalCost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)))
            .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                    .addComponent(pnlFood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(pnlDrink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlMainLayout.createSequentialGroup()
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemoveItem, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(lblDaftarPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnClose, javax.swing.GroupLayout.Alignment.TRAILING))
            .addContainerGap(32, Short.MAX_VALUE))
    );
    pnlMainLayout.setVerticalGroup(
        pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
            .addGap(32, 32, 32)
            .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
            .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                    .addComponent(lblNomorOrder)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txOrderCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblTipeOrder)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(normal)
                        .addComponent(catering))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel11)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txOrderName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(lblTanggal)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(dtChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlFood, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDrink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lblDaftarPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(pnlMainLayout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnRemoveItem)
                        .addComponent(btnCancel)))
                .addGroup(pnlMainLayout.createSequentialGroup()
                    .addComponent(jLabel15)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txDownPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(lblSumCost)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(lblTotalCost, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnConfirmItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGap(28, 28, 28))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbMenuFoodItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMenuFoodItemStateChanged
       if (evt.getStateChange() == ItemEvent.SELECTED && status == true) {
            int pointer = cbMenuFood.getSelectedIndex();
            System.out.println("Selected : "+DATAF[pointer]);
            String Query = "SELECT * FROM foodbeve\n"
                    + "WHERE fbCode='"+DATAF[pointer]+"'";
            try {
                RSET = db.getSQL(Query);
                RSET.first();
                lPriceFood.setText(""+RSET.getDouble("harga")); 
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            fdContainer.setIcon(food[cbMenuFood.getSelectedIndex()]);
       }
    }//GEN-LAST:event_cbMenuFoodItemStateChanged

    private void cbMenuBeveItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMenuBeveItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED && status == true) {
            int pointer = cbMenuBeve.getSelectedIndex();
            System.out.println("Selected : "+DATAB[pointer]);
            String Query = "SELECT * FROM foodbeve\n"
                    + "WHERE fbCode='"+DATAB[pointer]+"'";
            try {
                RSET = db.getSQL(Query);
                RSET.first();
                lPriceBeve.setText(""+RSET.getDouble("harga")); 
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            bvContainer.setIcon(beve[cbMenuBeve.getSelectedIndex()]);
       }
    }//GEN-LAST:event_cbMenuBeveItemStateChanged

    private void btnAddFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFoodActionPerformed
        Object[] container = new Object[6];
        container[0] = noOrder;
        container[1] = cbMenuFood.getSelectedItem();
        container[2] = txQtyFood.getText();
        container[3] = lPriceFood.getText();
        container[4] = (Double.parseDouble(lPriceFood.getText().trim())) * (Double.parseDouble(txQtyFood.getText().trim()));
        container[5] = DATAF[cbMenuFood.getSelectedIndex()];
        tbModOrder = (DefaultTableModel)tblOrder.getModel();
        tbModOrder.addRow(container);
        noOrder++;
        hitungCost();
    }//GEN-LAST:event_btnAddFoodActionPerformed

    private void btnAddBeveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBeveActionPerformed
        Object[] container = new Object[6];
        container[0] = noOrder;
        container[1] = cbMenuBeve.getSelectedItem();
        container[2] = txQtyBeve.getText();
        container[3] = lPriceBeve.getText();
        container[4] = (Double.parseDouble(lPriceBeve.getText().trim())) * (Double.parseDouble(txQtyBeve.getText().trim()));
        container[5] = DATAB[cbMenuBeve.getSelectedIndex()];
        tbModOrder = (DefaultTableModel)tblOrder.getModel();
        tbModOrder.addRow(container);
        noOrder++;
        hitungCost();
    }//GEN-LAST:event_btnAddBeveActionPerformed

    private void btnRemoveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveItemActionPerformed
        int size = tblOrder.getRowCount();
        if(size==0) {
            System.out.println("Table kosong woyyy");
        } else {
            int pointer = tblOrder.getSelectedRow();        
            System.out.println("baris ke-"+pointer+" dihapus");
            tbModOrder.removeRow(pointer);
            size = tblOrder.getRowCount();
            for(int x=0; x<size; x++)
                tbModOrder.setValueAt((x+1), x, 0);
            //System.out.println("data : "+tbModOrder.getValueAt(0, 0));
            noOrder--;  
            hitungCost();
        }
        
    }//GEN-LAST:event_btnRemoveItemActionPerformed

    private void btnConfirmItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmItemActionPerformed
        int ch = cekInventory();
        try {
            SQL = "INSERT INTO orderhead VALUES(?, ?, ?, ?, ?, ?)";
            Object[] CONT_ORDER = new Object[6], CONT_DETAIL = new Object[3];
            CONT_ORDER[0] = txOrderCode.getText().trim();
            CONT_ORDER[1] = (normal.isSelected()) ? "Normal" : "Cathering";
            CONT_ORDER[2] = txOrderName.getText().trim();
            CONT_ORDER[3] = dtChooser.getText();
            CONT_ORDER[4] = (catering.isSelected()) ? Double.valueOf(txDownPayment.getText()) : 0.0;
            CONT_ORDER[5] = tCost;
            db.setSTMT(SQL);
            if(ch!=0) {
                ch = JOptionPane.showConfirmDialog(this,"Bahan Baku Menipis, harap lakukan restock barang\n"
                        + "demi kenyamanan pelanggan.\nApakah anda ingin melanjutkan?","Info Bahan Baku",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
                if (ch == 0){
                    db.insertSQL(CONT_ORDER,"orderhead","orderID");
                    //input order detail
                    SQL = "INSERT INTO orderdetail VALUES(?, ?, ?)";
                    db.setSTMT(SQL);
                    int size = tblOrder.getRowCount();
                    for(int x=0; x<size; x++) {
                        CONT_DETAIL[0] = CONT_ORDER[0];
                        CONT_DETAIL[1] = tbModOrder.getValueAt(x, 5);
                        CONT_DETAIL[2] = tbModOrder.getValueAt(x, 2);;
                        db.insertSQL(CONT_DETAIL, "orderdetail", "orderID");
                    }
                }
            } else {
                db.insertSQL(CONT_ORDER,"orderhead","orderID");
                //input order detail
                SQL = "INSERT INTO orderdetail VALUES(?, ?, ?)";
                db.setSTMT(SQL);
                int size = tblOrder.getRowCount();
                for(int x=0; x<size; x++) {
                    CONT_DETAIL[0] = CONT_ORDER[0];
                    CONT_DETAIL[1] = tbModOrder.getValueAt(x, 5);
                    CONT_DETAIL[2] = tbModOrder.getValueAt(x, 2);;
                    db.insertSQL(CONT_DETAIL, "orderdetail", "orderID");
                }
            }
            
            Model.HandlerComponent.Report jReport = new HandlerComponent.Report();
            jReport.setFileName("STRUK_Order");
            jReport.setParam("noOrder", txOrderCode.getText());
            ch = JOptionPane.showConfirmDialog(null, "Apakah anda ingin melihat\nStruk Pesanan Pelanggan ?","Print", 0);
            if(ch==0) {
                jReport.printReport();
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        clearOrder();
        txOrderCode.requestFocus();
    }//GEN-LAST:event_btnConfirmItemActionPerformed

    private void txOrderCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txOrderCodeKeyTyped
        char vchar = evt.getKeyChar();
        if(!(Character.isDigit(vchar))
            || (vchar == KeyEvent.VK_BACKSPACE)
            || (vchar == KeyEvent.VK_DELETE)
            || (vchar == KeyEvent.VK_PERIOD))
            evt.consume();
    }//GEN-LAST:event_txOrderCodeKeyTyped

    private void txQtyFoodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txQtyFoodKeyTyped
        char vchar = evt.getKeyChar();
        if(!(Character.isDigit(vchar))
            || (vchar == KeyEvent.VK_BACKSPACE)
            || (vchar == KeyEvent.VK_DELETE)
            || (vchar == KeyEvent.VK_PERIOD))
            evt.consume();
    }//GEN-LAST:event_txQtyFoodKeyTyped

    private void txQtyBeveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txQtyBeveKeyTyped
        char vchar = evt.getKeyChar();
        if(!(Character.isDigit(vchar))
            || (vchar == KeyEvent.VK_BACKSPACE)
            || (vchar == KeyEvent.VK_DELETE)
            || (vchar == KeyEvent.VK_PERIOD))
            evt.consume();
    }//GEN-LAST:event_txQtyBeveKeyTyped

    private void txDownPaymentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDownPaymentKeyTyped
        char vchar = evt.getKeyChar();
        if(!(Character.isDigit(vchar))
            || (vchar == KeyEvent.VK_BACKSPACE)
            || (vchar == KeyEvent.VK_DELETE)
            || (vchar == KeyEvent.VK_PERIOD))
            evt.consume();
    }//GEN-LAST:event_txDownPaymentKeyTyped

    private void cateringStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cateringStateChanged
        if (catering.isSelected())
            txDownPayment.setEnabled(true);
    }//GEN-LAST:event_cateringStateChanged

    private void normalStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_normalStateChanged
        if(normal.isSelected()) {
            txDownPayment.setText("0.0");
            txDownPayment.setEnabled(false);            
        }
    }//GEN-LAST:event_normalStateChanged

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        clearOrder(); txOrderCode.requestFocus();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        mmInstance.setState(NORMAL); mmInstance.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void txQtyBeveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txQtyBeveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txQtyBeveActionPerformed

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        mmInstance.setState(NORMAL); mmInstance.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCloseMouseClicked

    private void pnlMainMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMainMousePressed
        mosX = evt.getX();
        mosY = evt.getY();
    }//GEN-LAST:event_pnlMainMousePressed

    private void pnlMainMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMainMouseDragged
        int coordX = evt.getXOnScreen(), coordY = evt.getYOnScreen();
        this.setLocation(coordX-mosX, coordY-mosY);
    }//GEN-LAST:event_pnlMainMouseDragged

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
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddBeve;
    private javax.swing.JButton btnAddFood;
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel btnClose;
    private javax.swing.JButton btnConfirmItem;
    private javax.swing.JButton btnRemoveItem;
    private javax.swing.JLabel bvContainer;
    private javax.swing.JRadioButton catering;
    private javax.swing.JComboBox<String> cbMenuBeve;
    private javax.swing.JComboBox<String> cbMenuFood;
    private datechooser.beans.DateChooserCombo dtChooser;
    private javax.swing.JLabel fdContainer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lMenuBeve;
    private javax.swing.JLabel lPriceBeve;
    private javax.swing.JLabel lPriceFood;
    private javax.swing.JLabel lblDaftarPesanan;
    private javax.swing.JLabel lblNomorOrder;
    private javax.swing.JLabel lblSumCost;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JLabel lblTipeOrder;
    private javax.swing.JLabel lblTotalCost;
    private javax.swing.JRadioButton normal;
    private javax.swing.ButtonGroup orderType;
    private javax.swing.JPanel pnlDrink;
    private javax.swing.JPanel pnlFood;
    private Model.PanelGradient pnlMain;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTextField txDownPayment;
    private javax.swing.JTextField txOrderCode;
    private javax.swing.JTextField txOrderName;
    private javax.swing.JTextField txQtyBeve;
    private javax.swing.JTextField txQtyFood;
    // End of variables declaration//GEN-END:variables
}
