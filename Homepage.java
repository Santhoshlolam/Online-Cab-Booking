
package cab_booking;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;


public class Homepage extends JFrame implements ActionListener
{
    JLabel l1;
    Font f,f1,f2;
    JPanel p1,p2;
    JFrame ff;
    
    Homepage()
    {
       super("Cab Booking Home Page");
       // ff=new JFrame("Cab Booking Home Page");
        setLocation(0,0);
        setSize(1550,800);
        
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("cab_booking/icons/profile.jpg"));
        Image img=ic.getImage().getScaledInstance(1550,800,Image.SCALE_DEFAULT);
        ImageIcon ic1=new ImageIcon(img);
        l1=new JLabel(ic1);
        
        f=new Font("Lucida Fax",Font.BOLD,20);
        f1=new Font("Gadugi",Font.BOLD,35);
        f2=new Font("MS UI Gothic",Font.BOLD,10);
        
        JMenuBar m1=new JMenuBar();
        JMenu men1=new JMenu("Customer Profile");
        JMenuItem ment1=new JMenuItem("Add Customer Profile");
        JMenuItem ment2=new JMenuItem("View Customer Profile");
        men1.add(ment1);
        men1.add(ment2);
        
        JMenu men2=new JMenu("Manage Customer");
        JMenuItem ment3=new JMenuItem("Update Customer Profile");
        men2.add(ment3);
        
        JMenu men3=new JMenu("Book Intracity Cab");
        JMenuItem ment5=new JMenuItem("Book Cab");
        JMenuItem ment6=new JMenuItem("View Booked Cab");
        men3.add(ment5);
        men3.add(ment6);
        
        JMenu men4=new JMenu("Book Intercity Cab");
        JMenuItem ment7=new JMenuItem("Book Intercity Cab");
        JMenuItem ment8=new JMenuItem("View Intercity Booked Cab");
        men4.add(ment7);
        men4.add(ment8);
        
        JMenu men5=new JMenu("Transport");
        JMenuItem ment9=new JMenuItem("Book Package");
        JMenuItem ment10=new JMenuItem("View Booked Package");
        men5.add(ment9);
        men5.add(ment10);
        
        JMenu men6=new JMenu("Bill");
        JMenuItem ment11=new JMenuItem("Check Bill");
        men6.add(ment11);
        
        JMenu men7=new JMenu("Delete");
        JMenuItem ment12=new JMenuItem("Delete Customer");
        men7.add(ment12);
        
        JMenu men8=new JMenu("About");
        JMenuItem ment13=new JMenuItem("About");
        JMenuItem ment14=new JMenuItem("Exit");
        men8.add(ment13);
        men8.add(ment14);
        
        m1.add(men1);
        m1.add(men2);
        m1.add(men3);
        m1.add(men4);
        m1.add(men5);
        m1.add(men6);
        m1.add(men7);
        m1.add(men8);
       
        m1.setBackground(Color.WHITE);
        
        men1.setForeground(Color.GRAY);
        men2.setForeground(Color.GRAY);
        men3.setForeground(Color.GRAY);
        men4.setForeground(Color.GRAY);
        men5.setForeground(Color.GRAY);
        men6.setForeground(Color.GRAY);
        men7.setForeground(Color.GRAY);        
        men8.setForeground(Color.RED);
        
        
        ment1.setForeground(Color.YELLOW);
        ment2.setForeground(Color.YELLOW);
        ment3.setForeground(Color.YELLOW);
        ment5.setForeground(Color.YELLOW);
        ment6.setForeground(Color.YELLOW);
        ment7.setForeground(Color.YELLOW);
        ment8.setForeground(Color.YELLOW);
        ment9.setForeground(Color.YELLOW);
        ment10.setForeground(Color.YELLOW);
        ment11.setForeground(Color.YELLOW);
        ment12.setForeground(Color.YELLOW);
        ment13.setForeground(Color.RED);
        ment14.setForeground(Color.RED);
                
       ment1.setBackground(Color.BLACK);
       ment2.setBackground(Color.BLACK);
       ment3.setBackground(Color.BLACK); 
       //ment4.setBackground(Color.BLACK); 
       ment5.setBackground(Color.BLACK);
       ment6.setBackground(Color.BLACK);
       ment7.setBackground(Color.BLACK);
       ment8.setBackground(Color.BLACK);
       ment9.setBackground(Color.BLACK);
       ment10.setBackground(Color.BLACK);
       ment11.setBackground(Color.BLACK);
       ment12.setBackground(Color.BLACK);
       ment13.setBackground(Color.BLACK);
       ment14.setBackground(Color.BLACK);
             
        setJMenuBar(m1);
        add(l1);
        //addActionListener(this);
        
    }
     public void actionPerformed(ActionEvent e) {
       String comnd=e.getActionCommand();
        if(comnd.equals("Add Customer Profile"))
        {
            new Add_Customer();
        }
        else if(comnd.equals("View Customer Profile"))
        { //System.out.println("okokokokok");
            new View_Customer().setVisible(true);
            
        }   
        else if(comnd.equals("Update Customer Profile"))
        {
        //    new Update_Customer().setVisible(true);
        }
        else if(comnd.equals("Book Cab"))
        {
          //  new Book_Cab().setVisible(true);
            
        }
        else if(comnd.equals("View Booked Cab"))
        {
          //  new View_BookedCab().setVisibel(true);
        }
        else if(comnd.equals("Book Intercity Cab"))
        {
           // new Book_IntercityCab().setVisible(true);
            
        }
        else if(comnd.equals("View Intercity Booked Cab"))
        {
          //  new View_IntercityBookedCab().setVisisble(true);
        }
        else if(comnd.equals("Book Package"))
        {
         //   new Book_Package().setVisible(true);
        }
        else if(comnd.equals("View Booked Package"))
        {
           // new View_BookedPackage().setVisible();
        }
        else if(comnd.equals("Check Bill"))
        {
            System.out.println("ok");
         //   new Check_Bill().setVisibel(true);
        }
        else if(comnd.equals("Delete Customer"))
        {
          //  new Delete_Customer().setVisibel();
        }
        else if(comnd.equals("About"))
        {
            
          //  new About().setVisible(true);
            
        }
        else if(comnd.equals("Exit"))
        {
          //  System.out.println("ok");
            System.exit(0);
           // System.out.println("ok");
         //  this.setVisible(false); 
        }
    }
    
    public static void main(String[] args)
    {
    
        new Homepage().setVisible(true);
    }
   
    
}
