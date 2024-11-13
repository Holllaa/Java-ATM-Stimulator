package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Deposit extends JFrame implements ActionListener {

    JTextField amount;
    JButton deposit, back;
    String pinnumber;

    Deposit(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        setSize(900, 900);
        add(image);

        JLabel text = new JLabel("Enter the Amount to be deposited");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        amount = new JTextField("");
        amount.setFont(new Font("Times New Romman", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Times New Romman", Font.BOLD, 20));
        deposit.setBounds(355, 485, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setFont(new Font("times New Romman", Font.BOLD, 20));
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setLocation(300, 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String Amount = amount.getText();
            Date date=new Date();
            if(Amount.equals(""))
            {
                JOptionPane.showMessageDialog( null,"Please Enter the Amount you want to deposit");
            }
            else
            {
                Conn conn=new Conn();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+Amount+"')";
                try {
                    conn.s.executeUpdate(query);
                } catch (SQLException ex) {
                    Logger.getLogger(Deposit.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null,"Rs "+Amount+" Amount deposited successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
        
            }
        }
        else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        // TODO code application logic here
        new Deposit("");
    }
}
