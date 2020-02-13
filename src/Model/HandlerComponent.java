/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.Database;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
/**
 *
 * @author REDHAT
 */
public class HandlerComponent {
    private Connection CONN;
    
    public HandlerComponent() throws SQLException{
        CONN = new Database().inisiasiDB();
       
    }
    public void initTable(JTable TABLE, String SQL) {
        DefaultTableModel tbModel;
        TableColumnModel tcm;
        JTableHeader th;
        TableColumn tc;
        Vector row;
        try {
            java.sql.Statement stat = CONN.createStatement();
            java.sql.ResultSet hasil = stat.executeQuery(SQL);
            int count = hasil.getMetaData().getColumnCount();
            Object[] namaCol = new Object[count];
            for(int x=0; x<count; x++) {
                namaCol[x] = hasil.getMetaData().getColumnName(x+1);
                System.out.println("Nama Kolom "+(x+1)+" : "+namaCol[x]);
            }
            tbModel = new DefaultTableModel(null, namaCol);
            TABLE.setModel(tbModel);
            while(hasil.next())  {
                String[] data = new String[count];
                for(int y=0; y<count; y++) {
                    data[y] = hasil.getString(y+1);
                }
                tbModel.addRow(data);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
}
