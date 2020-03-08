/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/**
 * Class untuk membantu konfigurasi setiap COMPONENT
 * yang terdapat pada java dengan koneksi Database.
 * Instansiasi class terlebih dahulu ketika menggunakan 
 * HandlerComponent ini.
 * @author REDHAT
 * @version 0.1a
 */
public class HandlerComponent {
    protected Connection CONN;
    protected ResultSet HANDLER_RES;
    public String[] COLUMN_TYPE, COLUMN_NAME;
    public Object[] RES_OBJ;
    
    public HandlerComponent() throws SQLException{
        CONN = new Database().inisiasiDB();
       
    }
    
    // The Old Way to Initiate Table
    /*
        Object[] baris = {"ID Supplier", "Nama Supplier", "Alamat","No. Telepon"}; //buat di tabel form
        tabmode = new DefaultTableModel(null, baris);
        tabelsup.setModel(tabmode);
        String sql = "select * from datasup";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery (sql);
            while (hasil.next()){
                String skd = hasil.getString("id_sup"); 
                String snm = hasil.getString("nm_sup");
                String smerk = hasil.getString("almt_sup");
                String sharga = hasil.getString("no_telp");
                String[]data = {skd,snm,smerk,sharga,};
                tabmode.addRow(data);
            }
        } catch (Exception e){
        }
    */
    public DefaultTableModel initTable(JTable TABLE, String SQL, Database DBClass,DefaultTableModel MODEL) {
        try {
            HANDLER_RES = DBClass.getSQL(SQL);
            int count = HANDLER_RES.getMetaData().getColumnCount();
            COLUMN_NAME = new String[count];
            COLUMN_TYPE = new String[count];
            RES_OBJ = new Object[count];
            for(int x=0; x<count; x++) {
                COLUMN_NAME[x] = HANDLER_RES.getMetaData().getColumnName(x+1);
                COLUMN_TYPE[x] = HANDLER_RES.getMetaData().getColumnTypeName(x+1);
                System.out.println("Nama Kolom "+(x+1)+" : "+COLUMN_NAME[x]+"\t| Tipe : "+COLUMN_TYPE[x]);
            }
            MODEL = (DefaultTableModel) TABLE.getModel();
            TABLE.setModel(MODEL);
            while(HANDLER_RES.next())  {
                for(int y=0; y<count; y++) {
                    switch(COLUMN_TYPE[y]) {
                        case "INT" :
                            RES_OBJ[y] = HANDLER_RES.getInt(y+1);
                            break;
                        case "DOUBLE" :
                            RES_OBJ[y] = HANDLER_RES.getDouble(y+1);
                            break;
                        case "FLOAT" :
                            RES_OBJ[y] = HANDLER_RES.getFloat(y+1);
                            break;
                        case "VARCHAR" :
                            RES_OBJ[y] = HANDLER_RES.getString(y+1);
                            break;
                        case "TEXT" :
                            RES_OBJ[y] = HANDLER_RES.getString(y+1);
                            break;
                        case "DATE" :
                            RES_OBJ[y] = HANDLER_RES.getString(y+1);
                            break;
                        default :
                            RES_OBJ[y] = "GAGAL (HandlerComponent.Java)";
                            break;
                    }
                }
                MODEL.addRow(RES_OBJ);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return MODEL;
    }
    
    public void initTable(JTable TABLE, String SQL, Database DBClass) {
        DefaultTableModel MODEL;
        try {
            HANDLER_RES = DBClass.getSQL(SQL);
            int count = HANDLER_RES.getMetaData().getColumnCount();
            COLUMN_NAME = new String[count];
            COLUMN_TYPE = new String[count];
            RES_OBJ = new Object[count];
            for(int x=0; x<count; x++) {
                COLUMN_NAME[x] = HANDLER_RES.getMetaData().getColumnName(x+1);
                COLUMN_TYPE[x] = HANDLER_RES.getMetaData().getColumnTypeName(x+1);
                System.out.println("Nama Kolom "+(x+1)+" : "+COLUMN_NAME[x]+"\t| Tipe : "+COLUMN_TYPE[x]);
            }
            MODEL = new DefaultTableModel(null, COLUMN_NAME);
            TABLE.setModel(MODEL);
            while(HANDLER_RES.next())  {
                for(int y=0; y<count; y++) {
                    switch(COLUMN_TYPE[y]) {
                        case "INT" :
                            RES_OBJ[y] = HANDLER_RES.getInt(y+1);
                            break;
                        case "DOUBLE" :
                            RES_OBJ[y] = HANDLER_RES.getDouble(y+1);
                            break;
                        case "FLOAT" :
                            RES_OBJ[y] = HANDLER_RES.getFloat(y+1);
                            break;
                        case "VARCHAR" :
                            RES_OBJ[y] = HANDLER_RES.getString(y+1);
                            break;
                        case "TEXT" :
                            RES_OBJ[y] = HANDLER_RES.getString(y+1);
                            break;
                        case "DATE" :
                            RES_OBJ[y] = HANDLER_RES.getString(y+1);
                            break;
                        default :
                            RES_OBJ[y] = "GAGAL (HandlerComponent.Java)";
                            break;
                    }
                }
                MODEL.addRow(RES_OBJ);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void initComboBox(JComboBox JCOMBO, String SQL, Database DBClass, String[] DATA) {
        try {
            HANDLER_RES = DBClass.getSQL(SQL);
            HANDLER_RES.last();
            int size = HANDLER_RES.getRow();
            System.out.println("\n\nTotal Row : "+size);
            HANDLER_RES.beforeFirst();
            size=0;
            while(HANDLER_RES.next()) {
                DATA[size] = HANDLER_RES.getString(1);
                JCOMBO.addItem(HANDLER_RES.getString(2));
                size++;
            }
        } catch (SQLException Ex) {
            Ex.printStackTrace();
        }
    }
    
    public static class LimitInput extends DocumentFilter {
        public static int LIMIT;
        
        public LimitInput(int limit) {
            if (limit <= 0) {
                throw new IllegalArgumentException("Limit can not be <= 0");
            }
            LimitInput.LIMIT = limit;
        }
        
        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attr) throws BadLocationException{
            int curLength = fb.getDocument().getLength();
            int overLim = (curLength + text.length()) - LIMIT - length;
            if(overLim > 0) 
                text = text.substring(0, text.length() - overLim);
            if(text.length() > 0)
                super.replace(fb, offset, length, text, attr);
        }
    }
    
    public static class Report {
        private static String fileName;
        public static Map param;
        private Connection conn;
        Database DB;
        public Report() {
            fileName = "";
            param = new HashMap();
        }
        
        public static void setFileName(String aFileName) {
            fileName = aFileName;
        }
        
        public static void setParam(String paramName, String paramValue) {
            param.put(paramName, paramValue);
        }
        
        public static void setParam(String paramName, Integer paramValue) {
            param.put(paramName, paramValue);
        }
        
        public static void setParam(String paramName, Double paramValue) {
            param.put(paramName, paramValue);
        }
        
        public static void setParam(String paramName, Float paramValue) {
            param.put(paramName, paramValue);
        }
        
        public static void setParam(String paramName, Date paramValue) {
            param.put(paramName, paramValue);
        }
        
        public void printReport() {
            String fName = "src/view/"+fileName+".jrxml";
            String fFill = "src/view/"+fileName+".jasper";
            try {
                DB = new Database();
                conn = DB.inisiasiDBnoStatic();
                JasperCompileManager.compileReport(fName);
                JasperFillManager.fillReport(fFill, param, conn);
                JasperPrint jp = JasperFillManager.fillReport(fFill, param, conn);
                JasperViewer.viewReport(jp, false);
            } catch (SQLException | JRException ex) {
                ex.printStackTrace();
            }
        }
    }
}
