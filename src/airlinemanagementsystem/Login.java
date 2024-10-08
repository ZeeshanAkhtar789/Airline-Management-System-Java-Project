
package airlinemanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton submit, reset, close;
    JTextField username; JPasswordField password;
    public Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(20, 20, 100, 20);
        add(lblUsername);
        
        username = new JTextField();
        username.setBounds(130, 20, 150, 20);
        add(username);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(20, 60, 100, 20);
        add(lblPassword);
        
        password = new JPasswordField();
        password.setBounds(130, 60, 150, 20);
        add(password);
        
        reset = new JButton("Reset");
        reset.setBounds(40, 120, 100, 20);
        reset.addActionListener(this);
        add(reset);
        
        submit = new JButton("Submit");
        submit.setBounds(180, 120, 100, 20);
        submit.addActionListener(this);
        add(submit);
        
        close = new JButton("Close");
        close.setBounds(115, 160, 100, 20);
        close.addActionListener(this);
        add(close);
        
        setSize(400, 250);
        setLocation(500, 250);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String uname = username.getText();
            String pass = password.getText();
            
            try{
               Conn c = new Conn();
               String query = "Select * from login where username = '"+uname+"' and password = '"+pass+"'";
               ResultSet rs = c.s.executeQuery(query);
               
               if(rs.next()){
                   new Home();
                   setVisible(false);
               }else{
                   JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                   setVisible(false);
               }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == reset){
            username.setText("");
            password.setText("");
        }else if(ae.getSource() == close){
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
}
