
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class BoardingPass extends JFrame implements ActionListener{
    
    JTextField tfpnr;
    JLabel tfName, tfNationality, tfSource, tfDest, dcDate, lblSource, lblDest, labelFname, labelFcode;
    JButton fetchDetails, fetchflight, bookFlight;
    Choice source, destination;
    
    public BoardingPass(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Air India");
        heading.setBounds(380, 10, 450, 35);
        heading.setFont(new Font("Tahona", Font.PLAIN, 32));
        add(heading);
        
        JLabel subHeading = new JLabel("Boarding Pass");
        subHeading.setBounds(360, 50, 300, 30);
        subHeading.setFont(new Font("Tahona", Font.PLAIN, 24));
        subHeading.setForeground(Color.BLUE);
        add(subHeading);
        
        JLabel lblAdhaar = new JLabel("PNR Number");
        lblAdhaar.setBounds(80, 100, 150, 25);
        lblAdhaar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAdhaar);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(240, 100, 150, 25);
        add(tfpnr);
        
        fetchDetails = new JButton("Enter");
        fetchDetails.setBackground(Color.BLACK);
        fetchDetails.setForeground(Color.WHITE);
        fetchDetails.setBounds(400, 100, 150, 25);
        fetchDetails.addActionListener(this);
        add(fetchDetails);
        
        JLabel lblName = new JLabel("NAME");
        lblName.setBounds(80, 140, 150, 25);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblName);
        
        tfName = new JLabel();
        tfName.setBounds(240, 140, 150, 25);
        add(tfName);
        
        JLabel lblNationality = new JLabel("NATIONALITY");
        lblNationality.setBounds(80, 180, 150, 25);
        lblNationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblNationality);
        
        tfNationality = new JLabel();
        tfNationality.setBounds(240, 180, 150, 25);
        add(tfNationality);
        
        
        JLabel lblAddress = new JLabel("FROM");
        lblAddress.setBounds(80, 220, 150, 25);
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAddress);
        
        tfSource = new JLabel();
        tfSource.setBounds(240, 220, 150, 25);
        add(tfSource);
        
        JLabel lblGender = new JLabel("TO");
        lblGender.setBounds(400, 220, 150, 25);
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblGender);
        
        tfDest = new JLabel();
        tfDest.setBounds(560, 220, 150, 25);
        add(tfDest);
        
        JLabel lblFname = new JLabel("Fligh Name");
        lblFname.setBounds(80, 260, 150, 25);
        lblFname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblFname);
        
        labelFname = new JLabel();
        labelFname.setBounds(240, 260, 150, 25);
        add(labelFname);
        
        JLabel lblFcode = new JLabel("Fligh Code");
        lblFcode.setBounds(400, 260, 150, 25);
        lblFcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblFcode);
        
        labelFcode = new JLabel();
        labelFcode.setBounds(560, 260, 150, 25);
        add(labelFcode);
        
        JLabel lblDate = new JLabel("Date");
        lblDate.setBounds(80, 300, 150, 25);
        lblDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblDate);
        
        dcDate = new JLabel();
        dcDate.setBounds(240, 300, 150, 25);
        add(dcDate);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblImage = new JLabel(image);
        lblImage.setBounds(600, 0, 300, 300);
        add(lblImage);
        
        setSize(1000, 450);
        setLocation(150, 150);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == fetchDetails){
            String pnr = tfpnr.getText();
            
            try{
                Conn c = new Conn();
                String query = "select * from reservation where PNR = '"+pnr+"'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    tfName.setText(rs.getString("name")); 
                    tfNationality.setText(rs.getString("nationality")); 
                    tfSource.setText(rs.getString("source")); 
                    tfDest.setText(rs.getString("destination"));
                    labelFname.setText(rs.getString("flight_name"));
                    labelFcode.setText(rs.getString("flight_code"));
                    dcDate.setText(rs.getString("date"));
                    
                }else{
                    JOptionPane.showMessageDialog(null, "User does not exists");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args){
        new BoardingPass();
    }
}

