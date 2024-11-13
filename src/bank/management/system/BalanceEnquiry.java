
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener 
{
    String pinnumber;
    JButton back;
    
    BalanceEnquiry(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0,900,900);
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        add(image);
        
        
        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
       
            Conn c=new Conn();
            int balance=0;
            try
            {
                ResultSet rs=c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
                
                while(rs.next())
                {
                    if(rs.getString("type").equals("Deposit"))
                    {
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }
                    else
                    {
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
            }catch(Exception e)
            {
                System.out.println(e);
            }
            JLabel text1=new JLabel("Your Current Balance is");
            text1.setForeground(Color.white);
            text1.setBounds(170, 300, 400, 45);
            text1.setFont(new Font("Times New Romman",Font.BOLD,25));
            image.add(text1);
            
            JLabel text=new JLabel("RS."+balance);
            text.setForeground(Color.white);
            text.setBounds(200, 350, 400, 45);
            text.setFont(new Font("Times New Romman",Font.BOLD,25));
            image.add(text);
        
         
    }
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
       
           
        
    }
    public static void main(String args[])
    {
        new BalanceEnquiry("");
    }
    
}
