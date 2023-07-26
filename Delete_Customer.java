
package cab_booking;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;



public class Delete_Customer  extends JFrame implements ActionListener 
{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JButton bt1,bt2;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9;
    Font f,f1;
    Choice ch;
    JPanel p1,p2,p3;
    
    Delete_Customer()
    {
                
    super("Delete Customer");
    setSize(740,700);
    setLocation(50,50);
        
    f=new Font("Arial",Font.BOLD,25);
    f1=new Font("Arial",Font.BOLD,18);
    ch=new Choice();
 
    try
    {
        connectionclass obj =new connectionclass();
        String q="select username from customer";
        ResultSet rest1=obj.stm.executeQuery(q);
        while(rest1.next())
        {
            ch.add(rest1.getString("username"));
        }
        rest1.close();
    }
    catch(Exception ee)
    {
        ee.printStackTrace();
    }
    l1=new JLabel("Delete Customer");
    l1.setHorizontalAlignment(JLabel.CENTER);
    l2=new JLabel("Username");
    l3=new JLabel("Name");
    l4=new JLabel("Age");
    l5=new JLabel("Date Of Birth");
    l6=new JLabel("Address");
    l7=new JLabel("Phone");
    l8=new JLabel("Email");
    l9=new JLabel("Country");
    l10=new JLabel("Gender");
    l11=new JLabel("Aadhar");
    
     tf1=new JTextField();
    tf2=new JTextField();
    tf3=new JTextField();
    tf4=new JTextField();
    tf5=new JTextField();
    tf6=new JTextField();
    tf7=new JTextField();
    tf8=new JTextField();
    tf9=new JTextField();

    tf1.setEditable(false);
    tf2.setEditable(false);
    tf3.setEditable(false);
    tf4.setEditable(false);
    tf5.setEditable(false);
    tf6.setEditable(false);
    tf7.setEditable(false);
    tf8.setEditable(false);
    tf9.setEditable(false);
    
     bt1=new JButton("Delete Customer");
    bt2=new JButton("Back");
    
    bt1.addActionListener(this);
    bt2.addActionListener(this);
        
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
    
    
    tf1.setFont(f1);
    tf2.setFont(f1);
    tf3.setFont(f1);
    tf4.setFont(f1);
    tf5.setFont(f1);
    tf6.setFont(f1);
    tf7.setFont(f1);
    tf8.setFont(f1);
    tf9.setFont(f1);
    
    ch.setFont(f1);
   
    bt1.setForeground(Color.WHITE);
    bt1.setBackground(Color.BLACK);
    
    bt2.setForeground(Color.WHITE);
    bt2.setBackground(Color.RED);
  
    ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("cab_booking/icons/profile.jpg"));
    Image img=ic.getImage().getScaledInstance(900,600,Image.SCALE_DEFAULT);
    ImageIcon ic1=new ImageIcon(img);
    l12=new JLabel(ic1);    
    
    p1=new JPanel();
    p1.setLayout(new GridLayout(1,1,10,10));
    p1.add(l1);
    
    p2=new JPanel();
    p2.setLayout(new GridLayout(1,1,10,10));
    p2.add(l12);
   
    
    p3=new JPanel();
    p3.setLayout(new GridLayout(11,2,10,10));
    p3.add(l2);
    p3.add(ch);
    p3.add(l3);
    p3.add(tf1);
    p3.add(l4);
    p3.add(tf2);
    p3.add(l5);
    p3.add(tf3);
    p3.add(l6);
    p3.add(tf4);
    p3.add(l7);
    p3.add(tf5);
    p3.add(l8);
    p3.add(tf6);
    p3.add(l9);
    p3.add(tf7);
    p3.add(l10);
    p3.add(tf8);
    p3.add(l11);
    p3.add(tf9);
    p3.add(bt1);
    p3.add(bt2);
    
    setLayout(new BorderLayout(10,10));
    add(p1,"North");
    add(p2,"West");
    add(p3,"Center");

    
    
     ch.addMouseListener(new MouseAdapter()
    {         
            public void mouseClicked(MouseEvent arg0)
    {
        try
        {
            connectionclass obj2=new connectionclass();
            String username= ch.getSelectedItem();
            String q1="select * from customer where username='"+username+"'";
            ResultSet rest1=obj2.stm.executeQuery(q1);
            while(rest1.next())
            {
                tf1.setText(rest1.getString("name"));
                tf2.setText(rest1.getString("age"));
                tf3.setText(rest1.getString("dob"));
                tf4.setText(rest1.getString("address"));
                tf5.setText(rest1.getString("phone"));
                tf6.setText(rest1.getString("email"));
                tf7.setText(rest1.getString("country"));
                tf8.setText(rest1.getString("gender"));
                tf9.setText(rest1.getString("aadhar"));
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
           String username=ch.getSelectedItem();
           
           try
           {
               connectionclass obj3=new connectionclass();
               String q="delete from customer where username='"+username+"'";
               String q1="delete from intransport where username='"+username+"'";   
               String q2="delete from intercitycab where username='"+username+"'";
               String q3="delete from intracitycab where username='"+username+"'";
               int aa=obj3.stm.executeUpdate(q);
               if(aa==1)
               {
                   JOptionPane.showMessageDialog(null,"your records deleted successfully");
                   obj3.stm.executeUpdate(q1);
                   obj3.stm.executeUpdate(q2);
                   obj3.stm.executeUpdate(q3);
                   this.setVisible(false);
                   new View_Customer().setVisible(true);
               }
               else
               {
                   JOptionPane.showMessageDialog(null,"Please!,check all details  carefully");
               }
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }
    }
    if(ee.getSource()==bt2)
    {
        this.setVisible(false);
    }
    
    
    
    }
    public static void main(String[] args)
    {
        new Delete_Customer().setVisible(true);
    }
    
    
}
