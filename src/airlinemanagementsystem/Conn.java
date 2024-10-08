
package airlinemanagementsystem;
import java.sql.*;
public class Conn {
    
    //Step-2 Create the connection String.
    Connection c;
    Statement s;
    
    public Conn(){
        try{
           Class.forName("com.mysql.cj.jdbc.Driver"); //Step-1 Registering the Driver
           c = DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem", "root", "Bilhaur@100"); // Step-2 Create the connection String
           s = c.createStatement(); //Step-3 Create the statement
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
