
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JTextField tfName, tfNationality, tfAdhaar, tfAddress, tfPhone;
    JRadioButton rbMale, rbFemale;
    
    public AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(220, 20, 500, 35);
        heading.setFont(new Font("Tahona", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(80, 80, 150, 25);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblName);
        
        tfName = new JTextField();
        tfName.setBounds(240, 80, 150, 25);
        add(tfName);
        
        JLabel lblNationality = new JLabel("Nationality");
        lblNationality.setBounds(80, 130, 150, 25);
        lblNationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblNationality);
        
        tfNationality = new JTextField();
        tfNationality.setBounds(240, 130, 150, 25);
        add(tfNationality);
        
        JLabel lblAdhaar = new JLabel("Adhaar Number");
        lblAdhaar.setBounds(80, 180, 150, 25);
        lblAdhaar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAdhaar);
        
        tfAdhaar = new JTextField();
        tfAdhaar.setBounds(240, 180, 150, 25);
        add(tfAdhaar);
        
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(80, 230, 150, 25);
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAddress);
        
        tfAddress = new JTextField();
        tfAddress.setBounds(240, 230, 150, 25);
        add(tfAddress);
        
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(80, 280, 150, 25);
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblGender);
        
        ButtonGroup genderGroup = new ButtonGroup();
        
        rbMale = new JRadioButton("Male");
        rbMale.setBounds(240, 280, 70, 25);
        rbMale.setBackground(Color.WHITE);
        add(rbMale);
        
        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(320, 280, 70, 25);
        rbFemale.setBackground(Color.WHITE);
        add(rbFemale);
        
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);
        
        JLabel lblPhone = new JLabel("Phone Number");
        lblPhone.setBounds(80, 330, 150, 25);
        lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblPhone);
        
        tfPhone = new JTextField();
        tfPhone.setBounds(240, 330, 150, 25);
        add(tfPhone);
        
        JButton btnSave = new JButton("Save");
        btnSave.setBackground(Color.BLACK);
        btnSave.setForeground(Color.WHITE);
        btnSave.setBounds(240, 420, 150, 30);
        btnSave.addActionListener(this);
        add(btnSave);
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel lblImage = new JLabel(image);
        lblImage.setBounds(500, 80, 280, 400);
        add(lblImage);
        
        setSize(900, 600);
        setLocation(200, 80);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        String name = tfName.getText();
        String nationality = tfNationality.getText();
        String adhaar = tfAdhaar.getText();
        String address = tfAddress.getText();
        String phone = tfPhone.getText();
        String gender = null;
        if(rbMale.isSelected()){
            gender = "Male";
        }else{
            gender = "Female";
        }
        try{
            Conn c = new Conn();
            String query = "insert into passenger values('"+name+"', '"+nationality+"', '"+adhaar+"', '"+address+"', '"+phone+"', '"+gender+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new AddCustomer();
    }
}
