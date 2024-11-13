package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transactions extends JFrame implements ActionListener {
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pinnumber;
    Transactions(String pin)
    {
        pinnumber=pin;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0,900,900);
        setSize(900,900);
        add(image);

        
        JLabel text=new JLabel("Please select your Transiction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("Times New Romman",Font.BOLD,16));
        image.add(text);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        image.add(deposit);
        deposit.addActionListener(this);
        
        withdrawl=new JButton("Cash Withdraw");
        withdrawl.setBounds(355,415,150,30);
        image.add(withdrawl);
        withdrawl.addActionListener(this);
        
        fastcash=new JButton("Fast cash");
        fastcash.setBounds(170,450,150,30);
        image.add(fastcash);
        fastcash.addActionListener(this);
        
        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(355,450,150,30);
        image.add(ministatement);
        ministatement.addActionListener(this);
        
        pinchange=new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        image.add(pinchange);
        pinchange.addActionListener(this);
        
        balanceenquiry=new JButton("Balance Enquiry");
        balanceenquiry.setBounds(355,485,150,30);
        image.add(balanceenquiry);
        balanceenquiry.addActionListener(this);
        
        
        exit=new JButton("Exit");
        exit.setBounds(355,520,150,30);
        image.add(exit);
        exit.addActionListener(this);
        
        
        setLocation(300,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        {
            System.exit(0);
        }
        else if(ae.getSource()==deposit)
        {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawl)
        {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash)
        {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinchange)
        {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balanceenquiry)
        {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==ministatement)
        {
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]) {
        // TODO code application logic here
        new Transactions("");
    }
}
