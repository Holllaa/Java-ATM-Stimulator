package bank.management.system;
import javax.swing.*;
import static java.awt.Color.WHITE;
import java.sql.*;

public class MiniStatement extends JFrame
{
    MiniStatement(String pinnumber)
    {
        
        setLayout(null);
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(WHITE);
        
        JLabel bank=new JLabel("Yashas Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel mini=new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);
        
        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance=new JLabel();
        balance.setBounds(20,400,300,25);
        add(balance);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from login where pin='"+pinnumber+"'");
            while(rs.next())
            {
                card.setText("Card Number: "+rs.getString("cardnumber").substring(0,4)+"XXXXXXX"+rs.getString("cardnumber").substring(12));
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        try
        {
            Conn c=new Conn();
            int bal=0;
            ResultSet rs=c.s.executeQuery("Select * from bank where pin='"+pinnumber+"'");
            while(rs.next())
            {
                mini.setText(mini.getText()+"<HTML>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br>"+"<HTML>");
                    if(rs.getString("type").equals("Deposit"))
                    {
                        bal+=Integer.parseInt(rs.getString("amount"));
                    }
                    else
                    {
                        bal-=Integer.parseInt(rs.getString("amount"));
                    }
            }
            balance.setText("Your account Balance is Rs."+bal);
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static void main(String args)
    {
        new MiniStatement("");
        
    }
}
