/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
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
    
    public HandlerComponent() throws SQLException{
        CONN = new Database().inisiasiDB();
       
    }
    
    // The Old Way to Initiate Table
    /*
        Object[] baris = {"ID Supplier", "Nama Supplier", "Alamat"
                ,"No. Telepon"}; //buat di tabel form
        tabmode = new DefaultTableModel(null, baris);
        tabelsup.setModel(tabmode);
        String sql = "select * from datasup";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery (sql);
            while (hasil.next()){
                String skd = hasil.getString("id_sup"); //isi tabel database
                String snm = hasil.getString("nm_sup");
                String smerk = hasil.getString("almt_sup");
                String sharga = hasil.getString("no_telp");
                String[]data = {skd,snm,smerk,sharga,};
                tabmode.addRow(data);
            }
        } catch (Exception e){
        }
    */
    public void initTable(JTable TABLE, String SQL, Database DBClass) {
        DefaultTableModel tbModel;
        try {
            HANDLER_RES = DBClass.getSQL(SQL);
            int count = HANDLER_RES.getMetaData().getColumnCount();
            Object[] namaCol = new Object[count];
            for(int x=0; x<count; x++) {
                namaCol[x] = HANDLER_RES.getMetaData().getColumnName(x+1);
                System.out.println("Nama Kolom "+(x+1)+" : "+namaCol[x]);
            }
            tbModel = new DefaultTableModel(null, namaCol);
            TABLE.setModel(tbModel);
            while(HANDLER_RES.next())  {
                String[] data = new String[count];
                for(int y=0; y<count; y++) {
                    data[y] = HANDLER_RES.getString(y+1);
                }
                tbModel.addRow(data);
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
}
