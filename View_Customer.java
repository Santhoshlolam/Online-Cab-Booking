
package cab_booking;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;

public class View_Customer extends JFrame
{   Font f;
    JTable t1;
    String x[]={"Username","Name","Age","Date Of Birth","Address","Phone","Email","Country","Gender","Aadhar_no"};
    String y[][]=new String[40][10];
    int i=0,j=0;
    View_Customer()
    {
        super("All Customer Details");
        setSize(1300,400);
        setLocation(0,10);
        f=new Font("MS UI Gothic",Font.BOLD,17);
        
        
        
        try
        {
            connectionclass  obj=new connectionclass();
            String q="select * from customer";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next())
            {
                y[i][j++]=rest.getString("username");
                y[i][j++]=rest.getString("name");
                y[i][j++]=rest.getString("age");
                y[i][j++]=rest.getString("dob");
                y[i][j++]=rest.getString("address");
                y[i][j++]=rest.getString("phone");
                y[i][j++]=rest.getString("email");
                y[i][j++]=rest.getString("country");
                y[i][j++]=rest.getString("gender");
                y[i][j++]=rest.getString("aadhar");
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
        new View_Customer().setVisible(true);
    }
    
}
