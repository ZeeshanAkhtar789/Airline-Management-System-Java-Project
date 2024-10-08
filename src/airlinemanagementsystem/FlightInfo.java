
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FlightInfo extends JFrame{
    
    public FlightInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JTable table = new JTable();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from flight");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 20, 900, 600);
        add(jsp);
        
        setSize(900, 600);
        setLocation(200, 80);
        setVisible(true);
    }
    
    
    public static void main(String[] args){
        new FlightInfo();
    }
}
