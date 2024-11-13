package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Signup3 extends JFrame implements ActionListener
{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    Signup3(String formno)
    {
        this.formno=formno;
        setLayout(null);
        setTitle("new Account form-Page 3");
        setVisible(true);
        setSize(850,820);
        setLocation(350,0);
        
        JLabel l1=new JLabel("Page  3:Account Details");
        l1.setFont(new Font("Times New Romman",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        JLabel l2=new JLabel("Account Type");
        l2.setFont(new Font("Times New Romman",Font.BOLD,22));
        l2.setBounds(100,140,200,30);
        add(l2);
        
        r1=new JRadioButton("Savings");
        r1.setFont(new Font("Times New Romman",Font.BOLD,22));
        r1.setBounds(100,180,200,30);
        add(r1);
        
        r2=new JRadioButton("Current");
        r2.setFont(new Font("Times New Romman",Font.BOLD,22));
        r2.setBounds(400,180,200,30);
        add(r2);
        
        r3=new JRadioButton("Fixed Deposit Account");
        r3.setFont(new Font("Times New Romman",Font.BOLD,22));
        r3.setBounds(100,230,300,30);
        add(r3);
        
        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Times New Romman",Font.BOLD,22));
        r4.setBounds(400,230,400,30);
        add(r4);
        
        ButtonGroup groupaccount=new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel card=new JLabel("Card Number");
        card.setFont(new Font("Times New Romman",Font.BOLD,22));
        card.setBounds(100,310,200,30);
        add(card);
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-1253");
        number.setFont(new Font("Times New Romman",Font.BOLD,22));
        number.setBounds(350,310,300,30);
        add(number);
        
        JLabel cardMessage=new JLabel("This your 16 digit card number");
        cardMessage.setFont(new Font("Times New Romman",Font.BOLD,14));
        cardMessage.setBounds(100,340,300,15);
        add(cardMessage);
        
        JLabel pin=new JLabel("PIN Number");
        pin.setFont(new Font("Times New Romman",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);
       
        JLabel pinMessage=new JLabel("This your 4 digit Password");
        pinMessage.setFont(new Font("Times New Romman",Font.BOLD,14));
        pinMessage.setBounds(100,400,300,15);
        add(pinMessage);
        
        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Times New Romman",Font.BOLD,22));
        pnumber.setBounds(350,370,300,30);
        add(pnumber);
        
        JLabel servicesRequired=new JLabel("Services Required:");
        servicesRequired.setFont(new Font("Times New Romman",Font.BOLD,22));
        servicesRequired.setBounds(100,440,400,30);
        add(servicesRequired);
        
        c1=new JCheckBox("Atm Card");
        c1.setFont(new Font("Times New Romman",Font.BOLD,20));
        c1.setBounds(100,500,200,30);
        add(c1);
        
        c2=new JCheckBox("Internet Banking");
        c2.setFont(new Font("Times New Romman",Font.BOLD,20));
        c2.setBounds(350,500,300,30);
        add(c2);
        
        c3=new JCheckBox("Mobile Banking");      
        c3.setFont(new Font("Times New Romman",Font.BOLD,20));
        c3.setBounds(100,550,200,30);
        add(c3);
        
        c4=new JCheckBox("Email and SMS Alerts");
        c4.setFont(new Font("Times New Romman",Font.BOLD,20));
        c4.setBounds(350,550,300,30);
        add(c4);
        
        c5=new JCheckBox("Cheque Book");
        c5.setFont(new Font("Times New Romman",Font.BOLD,20));
        c5.setBounds(100,600,200,30);
        add(c5);
        
        c6=new JCheckBox("E-Statement");
        c6.setFont(new Font("Times New Romman",Font.BOLD,20));
        c6.setBounds(350,600,300,30);
        add(c6);
        
        
        c7=new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setFont(new Font("Times New Romman",Font.BOLD,16));
        c7.setBounds(100,650,700,30);
        add(c7);
        
        submit =new JButton("Submit");
        submit.setBackground(Color.green);
        submit.setForeground(Color.BLACK);
        submit.setFont(new Font("Times New Romman",Font.BOLD,20));
        submit.setBounds(250, 700, 150, 30);
        submit.addActionListener(this);
        add(submit);
                
        
        cancel =new JButton("Cancel");
        cancel.setBackground(Color.red);
        cancel.setForeground(Color.BLACK);
        cancel.setFont(new Font("Times New Romman",Font.BOLD,20));
        cancel.setBounds(450, 700, 150, 30);
        cancel.addActionListener(this);
        add(cancel);
    }
    public static void main(String args[])
    {
        new Signup3("");
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String accounttype=null;
            if(r1.isSelected())
            {
                accounttype="Saving Account";
            }
            else if(r2.isSelected())
            {
                accounttype="Current Account";
            }
            else if(r3.isSelected())
            {
                accounttype="Fixed Deposit Account";
            }
            else if(r4.isSelected())
            {
                accounttype="Recurring Deposit Account";
            }
            
            Random ran=new Random();
            String cardnumber=""+Math.abs((ran.nextLong()%90000000L)+5040936000000000L);
            String pinnumber=""+Math.abs((ran.nextLong()%9000L)+1000L);
            String facility="";
            if(c1.isSelected())
            {
                facility=facility+" ATM Card";
            }
            else if(c2.isSelected())
            {
                facility=facility+" Internet Banking";
            }
            else if(c3.isSelected())
            {
                facility=facility+" Mobile Banking";
            }
            else if(c4.isSelected())
            {
                facility=facility+" Email and SMS Alerts";
            }
            else if(c5.isSelected())
            {
                facility=facility+" Cheque Book";
            }
            else if(c6.isSelected())
            {
                facility=facility+" Mobile Banking";
            }
            try
            {
                if(accounttype.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Account Type REQUIRED");
                    
                }
                else 
                {
                        Conn conn=new Conn();
                        String query1="insert into signupthree values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                        String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                        conn.s.executeUpdate(query1);
                        conn.s.executeUpdate(query2);
                        
                        JOptionPane.showMessageDialog(null,"Card Number:"+cardnumber+"\nPin:"+pinnumber);
                        setVisible(false);
                        new Deposit(pinnumber).setVisible(true);
                }
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }            
    }
}
