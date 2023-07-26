
package cab_booking;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.io.*;
//import java.lang.*;
public class connectionclass
{ 
  Connection   con;
    Statement stm;
    connectionclass()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_management","root","123456@Sa");
            stm=con.createStatement();
          if(con.isClosed())
          System.out.println("yes");
          else
              System.out.println("No");
          
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
            
    }
    public static void main(String[] args)
    {
        new connectionclass();
        
    }
}  


/*class ok
{
    public static void main(String[] args)
    {
        System.out.println("ok)");
    }
}*/
    
