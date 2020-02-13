/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.mysql.jdbc.Driver;
import java.sql.Connection; import java.sql.DriverManager;
import java.sql.ResultSet; import java.sql.PreparedStatement;
import java.sql.Statement; import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author REDHAT
 */
public class Database {
    private static Connection config;
    private static Driver dm;
    private static String paramConnection;
    public static String DB_HOST, DB_PORT, DB_NAME, DB_USER, DB_PASS, STMT, LOG;
    public ResultSet RES;
    public Statement STM;
    public PreparedStatement PREP;
    
    public Database() {
        Database.setDB_HOST("localhost");
        Database.setDB_NAME("makandong");
        Database.setDB_USER("root");
        Database.setDB_PASS("123456");
        Database.setDB_PORT("3306");
    }
    
    public Database(String db_name, String user, String pass) {
        Database.DB_NAME = db_name; Database.DB_USER = user;
        Database.DB_PASS = pass;
    }
    
    public static void setDB_HOST(String DB_HOST) {
        Database.DB_HOST = DB_HOST;
    }

    public static void setDB_PORT(String DB_PORT) {
        Database.DB_PORT = DB_PORT;
    }

    public static void setDB_NAME(String DB_NAME) {
        Database.DB_NAME = DB_NAME;
    }

    public static void setDB_USER(String DB_USER) {
        Database.DB_USER = DB_USER;
    }

    public static void setDB_PASS(String DB_PASS) {
        Database.DB_PASS = DB_PASS;
    }

    public static void setConfig(Connection config) {
        Database.config = config;
    }

    public static void setSTMT(String STMT) {
        Database.STMT = STMT;
    }
    
    public Connection getConfig() {
        return config;
    }
    /**
     * Query Select untuk SQL 
     * dengan syarat harus memberikan query pada property STMT
     * e.g. "<i>SELECT * FROM <b>namaTable</b></i>"<br> atau "<i>SELECT * FROM <b>namaTable</b> WHERE <b>kolom</b> = "<u>kondisi</u>"</i>"
     * @return ResultSet executeQuery();
     * @throws SQLException 
     * @see setSTMT();
     */
    public ResultSet getSQL() throws SQLException {
        checkConnection();
        STM = Database.config.createStatement();
        LOG = Database.STMT;
        RES = STM.executeQuery(Database.STMT);
        System.out.println("\n\nQuery Performed for MySQL =========================================\n"
                + LOG
                + "\n========================================================\n");
        return RES;
    }
    
    /**
     * Query Select untuk SQL dengan Custom Parameter
     * @param Query String SQL
     * e.g. "<i>SELECT * FROM <b>namaTable</b></i>"<br> atau "<i>SELECT * FROM <b>namaTable</b> WHERE <b>kolom</b> = "<u>kondisi</u>"</i>"
     * @return ResultSet executeQuery();
     * @throws SQLException 
     */
    
    public ResultSet getSQL(String Query) throws SQLException {
        //checkConnection();
        STM = Database.config.createStatement();
        LOG = Query;
        System.out.println("\n\nQuery Performed for MySQL =========================================\n"
                + LOG
                + "\n============================================================\n");
        return (RES = STM.executeQuery(Query));
    }
    
    public static Connection inisiasiDB() throws SQLException {
        if ((Database.DB_NAME == null) || (Database.DB_USER == null) || (Database.DB_PASS == null) || (Database.DB_PORT == null) || (Database.DB_HOST == null)) {
            JOptionPane.showMessageDialog(null,"Database Belum disetting");
             if (Database.DB_NAME == null) {
                 String DBname = JOptionPane.showInputDialog("Nama Database");
                 Database.DB_NAME = DBname;
             }
             if (Database.DB_USER == null) setDB_USER(JOptionPane.showInputDialog("User"));
             if (Database.DB_PASS == null) Database.DB_PASS = JOptionPane.showInputDialog("Password");
             if (Database.DB_PORT == null) Database.DB_PORT = JOptionPane.showInputDialog("Port");
             if (Database.DB_HOST == null) Database.DB_HOST = JOptionPane.showInputDialog("Host");
             Database.paramConnection = "jdbc:mysql://"+Database.DB_HOST+":"+Database.DB_PORT+"/"+Database.DB_NAME;
        }
        try {
            Database.dm = new com.mysql.jdbc.Driver();
            Database.paramConnection = "jdbc:mysql://"+Database.DB_HOST+":"+Database.DB_PORT+"/"+Database.DB_NAME;
            DriverManager.registerDriver(dm);
            setConfig(DriverManager.getConnection(Database.paramConnection,Database.DB_USER, Database.DB_PASS));
            System.out.println("Koneksi Sukses ========================\n DB_NAME : "+DB_NAME);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Driver untuk Koneksi database tidak ada\nSilahkan nyalakan services MySQL pada XAMPP");
        }
        return config;
    }
    
    private void checkConnection() throws SQLException{
        if(getConfig() == null) {
            setConfig(inisiasiDB());
        }
    }
}
