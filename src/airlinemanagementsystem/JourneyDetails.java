
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener{
    
    JTable table;
    JLabel lblpnr;
    JTextField tfpnr;
    JButton btnShow;
    
    public JourneyDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        lblpnr = new JLabel("PNR Details");
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpnr.setBounds(50, 50, 100, 25);
        add(lblpnr);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(160, 50, 120, 25);
        add(tfpnr);
        
        btnShow = new JButton("Show Details");
        btnShow.setBounds(290, 50, 150, 25);
        btnShow.setBackground(Color.BLACK);
        btnShow.setForeground(Color.WHITE);
        btnShow.addActionListener(this);
        add(btnShow);
        
        table = new JTable();
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 800, 600);
        jsp.setBackground(Color.WHITE);
        add(jsp);
        
        setSize(800, 600);
        setLocation(200, 80);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        try{
            Conn c = new Conn();
            String query = "select * from reservation where PNR = '"+tfpnr.getText()+"'";
            ResultSet rs = c.s.executeQuery(query);
            if(!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "Invalid PNR Number");
                return;
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args){
        new JourneyDetails();
    }
}
