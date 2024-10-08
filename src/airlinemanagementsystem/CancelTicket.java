
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class CancelTicket extends JFrame implements ActionListener{
    
    JTextField tfpnr;
    JLabel tfName, lblCancel, tfcode, lbldateOfTravel;
    JButton showDetails, cancelTicket;
    
    public CancelTicket(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("CANCELLATION");
        heading.setBounds(180, 20, 250, 35);
        heading.setFont(new Font("Tahona", Font.PLAIN, 32));
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblImage = new JLabel(image);
        lblImage.setBounds(470, 120, 250, 250);
        add(lblImage);
        
        JLabel lblAdhaar = new JLabel("PNR Number");
        lblAdhaar.setBounds(60, 80, 150, 25);
        lblAdhaar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAdhaar);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 80, 150, 25);
        add(tfpnr);
        
        showDetails = new JButton("Show Detail");
        showDetails.setBackground(Color.BLACK);
        showDetails.setForeground(Color.WHITE);
        showDetails.setBounds(400, 80, 150, 25);
        showDetails.addActionListener(this);
        add(showDetails);
        
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(60, 130, 150, 25);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblName);
        
        tfName = new JLabel();
        tfName.setBounds(220, 130, 150, 25);
        add(tfName);
        
        JLabel lblNationality = new JLabel("Cancellation No");
        lblNationality.setBounds(60, 180, 150, 25);
        lblNationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblNationality);
        
        Random random = new Random();
        
        lblCancel = new JLabel(""+random.nextInt(1000000));
        lblCancel.setBounds(220, 180, 150, 25);
        add(lblCancel);
        
        
        JLabel lblAddress = new JLabel("Flight Code");
        lblAddress.setBounds(60, 230, 150, 25);
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAddress);
        
        tfcode = new JLabel();
        tfcode.setBounds(220, 230, 150, 25);
        add(tfcode);
        
        JLabel lblGender = new JLabel("Date of Travel");
        lblGender.setBounds(60, 280, 150, 25);
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblGender);
        
        lbldateOfTravel = new JLabel();
        lbldateOfTravel.setBounds(220, 280, 150, 25);
        add(lbldateOfTravel);
        
        cancelTicket = new JButton("Cancel Ticket");
        cancelTicket.setBackground(Color.BLACK);
        cancelTicket.setForeground(Color.WHITE);
        cancelTicket.setBounds(220, 330, 150, 25);
        cancelTicket.addActionListener(this);
        add(cancelTicket);
        
        setSize(800, 450);
        setLocation(250, 150);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == showDetails){
            String pnr = tfpnr.getText();
            
            try{
                Conn c = new Conn();
                String query = "select * from reservation where PNR = '"+pnr+"'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    tfName.setText(rs.getString("name")); 
                    tfcode.setText(rs.getString("flight_code")); 
                    lbldateOfTravel.setText(rs.getString("date")); 
                }else{
                    JOptionPane.showMessageDialog(null, "User does not exists");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == cancelTicket){
            String pnr = tfpnr.getText();
            String name = tfName.getText();
            String cancelNo = lblCancel.getText();
            String fCode = tfcode.getText();
            String date = lbldateOfTravel.getText();
            
            try{
                Conn c = new Conn();
                String query = "insert into cancel values('"+pnr+"', '"+name+"', '"+cancelNo+"', '"+fCode+"', '"+date+"')";
                c.s.executeUpdate(query);
                c.s.executeUpdate("delete from reservation where PNR = '"+pnr+"'");
                JOptionPane.showMessageDialog(null, "Ticket Cancelled Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args){
        new CancelTicket();
    }
}
