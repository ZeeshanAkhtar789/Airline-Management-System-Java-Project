
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener{
    
    JTextField tfAdhaar;
    JLabel tfName, tfNationality, tfAddress, labelGender, lblSource, lblDest, labelFname, labelFcode;
    JButton fetchDetails, fetchflight, bookFlight;
    Choice source, destination;
    JDateChooser dcDate;
    
    public BookFlight(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(350, 20, 300, 35);
        heading.setFont(new Font("Tahona", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel lblAdhaar = new JLabel("Adhaar Number");
        lblAdhaar.setBounds(80, 80, 150, 25);
        lblAdhaar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAdhaar);
        
        tfAdhaar = new JTextField();
        tfAdhaar.setBounds(240, 80, 150, 25);
        add(tfAdhaar);
        
        fetchDetails = new JButton("Fetch Details");
        fetchDetails.setBackground(Color.BLACK);
        fetchDetails.setForeground(Color.WHITE);
        fetchDetails.setBounds(400, 80, 150, 25);
        fetchDetails.addActionListener(this);
        add(fetchDetails);
        
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(80, 130, 150, 25);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblName);
        
        tfName = new JLabel();
        tfName.setBounds(240, 130, 150, 25);
        add(tfName);
        
        JLabel lblNationality = new JLabel("Nationality");
        lblNationality.setBounds(80, 180, 150, 25);
        lblNationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblNationality);
        
        tfNationality = new JLabel();
        tfNationality.setBounds(240, 180, 150, 25);
        add(tfNationality);
        
        
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(80, 230, 150, 25);
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAddress);
        
        tfAddress = new JLabel();
        tfAddress.setBounds(240, 230, 150, 25);
        add(tfAddress);
        
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(80, 280, 150, 25);
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblGender);
        
        labelGender = new JLabel();
        labelGender.setBounds(240, 280, 150, 25);
        add(labelGender);
        
        lblSource = new JLabel("Source");
        lblSource.setBounds(80, 330, 150, 25);
        lblSource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblSource);
        
        source = new Choice();
        source.setBounds(240, 330, 150, 25);
        add(source);
        
        lblDest = new JLabel("Destination");
        lblDest.setBounds(80, 380, 150, 25);
        lblDest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblDest);
        
        destination = new Choice();
        destination.setBounds(240, 380, 150, 25);
        add(destination);
        
        try{
            Conn c = new Conn();
            String query = "select * from flight";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        fetchflight = new JButton("Fetch Flight");
        fetchflight.setBackground(Color.BLACK);
        fetchflight.setForeground(Color.WHITE);
        fetchflight.setBounds(400, 380, 150, 25);
        fetchflight.addActionListener(this);
        add(fetchflight);
        
        JLabel lblFname = new JLabel("Fligh Name");
        lblFname.setBounds(80, 430, 150, 25);
        lblFname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblFname);
        
        labelFname = new JLabel();
        labelFname.setBounds(240, 430, 150, 25);
        add(labelFname);
        
        JLabel lblFcode = new JLabel("Fligh Code");
        lblFcode.setBounds(80, 480, 150, 25);
        lblFcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblFcode);
        
        labelFcode = new JLabel();
        labelFcode.setBounds(240, 480, 150, 25);
        add(labelFcode);
        
        JLabel lblDate = new JLabel("Date of Flight");
        lblDate.setBounds(80, 530, 150, 25);
        lblDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblDate);
        
        dcDate = new JDateChooser();
        dcDate.setBounds(240, 530, 150, 25);
        add(dcDate);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblImage = new JLabel(image);
        lblImage.setBounds(550, 80, 500, 410);
        add(lblImage);
        
        bookFlight = new JButton("Book Flight");
        bookFlight.setBackground(Color.BLACK);
        bookFlight.setForeground(Color.WHITE);
        bookFlight.setBounds(240, 580, 150, 25);
        bookFlight.addActionListener(this);
        add(bookFlight);
        
        setSize(1100, 700);
        setLocation(100, 30);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == fetchDetails){
            String adhaar = tfAdhaar.getText();
            
            try{
                Conn c = new Conn();
                String query = "select * from passenger where adhaar = '"+adhaar+"'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    tfName.setText(rs.getString("name")); 
                    tfNationality.setText(rs.getString("nationality")); 
                    tfAddress.setText(rs.getString("address")); 
                    labelGender.setText(rs.getString("gender"));
                }else{
                    JOptionPane.showMessageDialog(null, "User does not exists");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == fetchflight){
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            
            try{
                Conn c = new Conn();
                String query = "select * from flight where source = '"+src+"' and destination = '"+dest+"'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    labelFname.setText(rs.getString("f_name"));
                    labelFcode.setText(rs.getString("f_code"));
                }else{
                    JOptionPane.showMessageDialog(null, "No Flight Found");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            Random rd = new Random();
            String adhaar = tfAdhaar.getText();
            String name = tfName.getText();
            String nationality = tfNationality.getText();
            String flight_name = labelFname.getText();
            String flight_code = labelFcode.getText();
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            String date = ((JTextField)dcDate.getDateEditor().getUiComponent()).getText();
            try{
                Conn c = new Conn();
                String query = "insert into reservation values('PNR-"+rd.nextInt(1000000)+"', 'TIC-"+rd.nextInt(10000)+"', '"+adhaar+"', '"+name+"', '"+nationality+"', '"+flight_name+"', '"+flight_code+"', '"+src+"', '"+dest+"', '"+date+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }  
    }
    
    public static void main(String[] args){
        new BookFlight();
    }
}
