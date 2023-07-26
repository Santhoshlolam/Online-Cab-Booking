
package cab_booking;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;


public class Book_Package extends JFrame implements ActionListener 
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
    JButton bt1,bt2;
    JPanel p1,p2,p3;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9;
    Font f,f1;
    Choice ch1,ch2,ch3,ch4;
    
    Book_Package()
    {
        super("Book Truck");
        setLocation(50,10);
        setSize(1000,700);
        
        f=new Font("Arial",Font.BOLD,25);
        f1=new Font("Arial",Font.BOLD,18);
        
        ch1=new Choice();
        ch2=new Choice();
        ch3=new Choice();
        ch4=new Choice();
        
        
         try
        {
            connectionclass obj=new connectionclass();
            String q="select DISTINCT source from transport_driver";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next())
            {
                ch1.add(rest.getString("source"));
                
            }
            rest.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
         
         try
        {
            connectionclass obj=new connectionclass();
            String q="select username from customer";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next())
            {
                ch3.add(rest.getString("username"));
            }
            rest.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
         
           ch4.add("0 - 10 KG");
           ch4.add("10 - 50 KG");
           ch4.add("50 - 100 KG");
           ch4.add("100 - 500 KG");
           ch4.add("500 - 1000 KG");
           ch4.add(">1000 KG");
           
           l1=new JLabel("Book Truck Package");
           l2=new JLabel("Book ID");
           l3=new JLabel("Source");
           l4=new JLabel("Destination");
           l5=new JLabel("Username");
           l6=new JLabel("Name");
           l7=new JLabel("Driver Name");
           l8=new JLabel("Truck");
           l9=new JLabel("Destination From");
           l10=new JLabel("Destination To");
           l11=new JLabel("Price");
           l13=new JLabel("Weight");
           l14=new JLabel("Distance");
          
            l1.setHorizontalAlignment(JLabel.CENTER);
           
           tf1=new JTextField();
           tf2=new JTextField();
           tf3=new JTextField();
           tf4=new JTextField();
           tf5=new JTextField();
           tf6=new JTextField();
           tf7=new JTextField();
           tf8=new JTextField();
           tf9=new JTextField();
           
          Random ram=new Random();
          tf1.setText(""+Math.abs(ram.nextInt()%100000));
          tf1.setForeground(Color.RED);
           
       bt1=new JButton("Book Truck");
       bt2=new JButton("Back");
       
       bt1.addActionListener(this);
       bt2.addActionListener(this);
        
       bt1.setBackground(Color.YELLOW);
       bt2.setBackground(Color.RED);
       
       bt1.setForeground(Color.BLACK);
       bt2.setForeground(Color.WHITE); 
       
       l1.setFont(f);
       l2.setFont(f1);
       l3.setFont(f1);
       l4.setFont(f1);
       l5.setFont(f1);
       l6.setFont(f1);
       l7.setFont(f1);
       l8.setFont(f1);
       l9.setFont(f1);
       l10.setFont(f1);
       l11.setFont(f1);
       l13.setFont(f1);
       l14.setFont(f1);
       ch1.setFont(f1);
       ch2.setFont(f1);
       ch3.setFont(f1);
       ch4.setFont(f1);
       
       tf1.setFont(f1);
       tf2.setFont(f1);
       tf3.setFont(f1);
       tf4.setFont(f1);
       tf5.setFont(f1);
       tf6.setFont(f1);
       tf7.setFont(f1);
       tf8.setFont(f1);
       tf9.setFont(f1);
       
       bt1.setFont(f1);
       bt2.setFont(f1);
       
        p1=new JPanel();
       p1.setLayout(new GridLayout(1,1,10,10));
       p1.add(l1);
       
       
        p2=new JPanel();
       p2.setLayout(new GridLayout(13,2,10,10));
       p2.add(l2);
       p2.add(tf1);
       p2.add(l3);
       p2.add(ch1);
       p2.add(l4);
       p2.add(ch2);
       p2.add(l5);
       p2.add(ch3);
       p2.add(l6);
       p2.add(tf3);
       p2.add(l7);
       p2.add(tf4);
       p2.add(l8);
       p2.add(tf5);
       p2.add(l9);
       p2.add(tf6);
       p2.add(l10);
       p2.add(tf7);
       p2.add(l11);
       p2.add(tf8);
       p2.add(l13);
      // p2.add(ch4);
      p2.add(tf9);
       p2.add(l14);
       p2.add(tf2);
       p2.add(bt1);
       p2.add(bt2);
    ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("cab_booking/icons/profile.jpg"));
       Image img=ic.getImage().getScaledInstance(900,600,Image.SCALE_DEFAULT);
       ImageIcon ic1=new ImageIcon(img);
       l12=new JLabel(ic1);
       
       p3=new JPanel();
       p3.setLayout(new GridLayout(1,1,10,10));
       p3.add(l12);
       
       setLayout(new BorderLayout(10,10));
       add(p1,"North");
       add(p2,"Center");
       add(p3,"West");

        ch3.addMouseListener(new MouseAdapter()
       {
          // @override
           public void mouseClicked(MouseEvent arg0)
           {
               try
               {
                   connectionclass obj=new connectionclass();
                   String username=ch3.getSelectedItem();
                   String q1="select name from customer where username='"+username+"'";
                   ResultSet rest1=obj.stm.executeQuery(q1);
                   while(rest1.next())
                   {
                       tf3.setText(rest1.getString("name"));
                       
                   }
                   rest1.close();
                   
               }
               catch(Exception ex)
               {
                   ex.printStackTrace();
               }
               
           }
           
       });
      ch1.addMouseListener(new MouseAdapter()
       {
         //  @override
           public void mouseClicked(MouseEvent arg0)
           {
               ch2.removeAll();
               
               try
               {
                   connectionclass obj=new connectionclass();
                   String source=ch1.getSelectedItem();
                   String q1="select DISTINCT destination from transport_driver where source='"+source+"'";
                   ResultSet rest1=obj.stm.executeQuery(q1);
                   while(rest1.next())
                   {
                       ch2.add(rest1.getString("destination"));
                   }
                   rest1.close();
               }
               catch(Exception e)
               {
                   e.printStackTrace();
               }
           }
       });

    ch2.addMouseListener(new MouseAdapter()
       {
         //  @override
           public void mouseClicked(MouseEvent arg0)
           {
               ch4.removeAll();
               try
               {
                   connectionclass obj=new connectionclass();
                   String source=ch1.getSelectedItem();
                   String destination=ch2.getSelectedItem();
                   String q1="select * from transport_driver where source='"+source+"' and destination='"+destination+"'";
                   ResultSet rest1=obj.stm.executeQuery(q1);
                   while(rest1.next())
                   {    
                        
                       tf4.setText(rest1.getString("driver"));
                       tf5.setText(rest1.getString("truck"));
                       tf6.setText(rest1.getString("source"));
                       tf7.setText(rest1.getString("destination"));
                       tf8.setText(rest1.getString("price"));
                      // ch4.getSelectedItem();
                       tf2.setText(rest1.getString("distance"));
                   }
                   rest1.close();
               }
               catch(Exception e)
               {
                   e.printStackTrace();
               }
               
               
           }
           
       });
      
       
    }
    
    public void actionPerformed(ActionEvent ee)
    {
         if(ee.getSource()==bt1)
        {
            String bid=tf1.getText();
            String username=ch3.getSelectedItem();
            String dname=tf4.getText();
            String truck=tf5.getText();
            String source=tf6.getText();
            String destination=tf7.getText();
            String price=tf8.getText();
            String name=tf3.getText();
            String distance=tf2.getText();
          //  String weight=ch4.getSelectedItem();
          String weight=tf9.getText();
            try
            {
                connectionclass obj=new connectionclass();
                String q1="insert into intransport values('"+bid+"','"+username+"','"+name+"','"+dname+"','"+source+"','"+destination+"','"+weight+"','"+truck+"','"+distance+"','"+price+"')";
                int aa=obj.stm.executeUpdate(q1);
                if(aa==1)
                {
                    JOptionPane.showMessageDialog(null,"Cab Booked Successfully");
                    this.setVisible(false);
                    new Update_Customer();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please fill the detais Carefully");
                    
                }
            }
            catch(Exception exe)
            {
                exe.printStackTrace();
                
            }
        }
        if(ee.getSource()==bt2)
        {
            this.setVisible(false); 
        }

    }
    public  static void main(String[] args)
    {
      new Book_Package().setVisible(true);  
    }
}
