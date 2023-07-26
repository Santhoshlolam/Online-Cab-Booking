
package cab_booking;


import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;


public class View_Booked_Package extends JFrame //implements ActionListener
{
    
    Font f;
    JTable t1;
    String x[]={"Book ID","Username","Name","Driver Name","Source","Destination","Weight","Truck","Distance","Price"};
    String y[][]=new String[20][10];
    int i=0,j=0;
    
    View_Booked_Package()
    {
        super("All  Booked Package Records");
        setSize(1300,400);
        setLocation(0,10);
        f=new Font("MS UI Gothic",Font.BOLD,17);
 
        try
        {
            connectionclass  obj=new connectionclass();
            String q="select * from intransport";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next())
            {
                y[i][j++]=rest.getString("BookId");
                y[i][j++]=rest.getString("username");
                y[i][j++]=rest.getString("name");
                y[i][j++]=rest.getString("drivername");
                
               
                y[i][j++]=rest.getString("source");
                y[i][j++]=rest.getString("destination");
                y[i][j++]=rest.getString("weight");
                y[i][j++]=rest.getString("truck");
                
                y[i][j++]=rest.getString("distance");
                y[i][j++]=rest.getString("price");
                i++;
                j=0;
            }
            // add(t1);
            t1=new JTable(y,x);
             add(t1);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        t1.setFont(f);
        t1.setBackground(Color.BLACK);
        t1.setForeground(Color.WHITE);
        
        
        JScrollPane js=new JScrollPane(t1);
        add(js);
      //  add(t1);
        
        
    }
    public static void main(String[] args)
    {
        new View_Booked_Package().setVisible(true);
    }
   
}
