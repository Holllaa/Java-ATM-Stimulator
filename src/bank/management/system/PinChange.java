package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener{
    JButton change,back;
    JPasswordField pin,repin;
    String pinnumber;
    PinChange(String pinnumber)
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
        
        JLabel text=new JLabel("Change Your PIN");
        text.setForeground(Color.WHITE);
        text.setBounds(250,280,500,35);
        text.setFont(new Font("Times New Roman",Font.BOLD,20));
        image.add(text);
        
        JLabel pintext=new JLabel("New PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(165,320,180,25);
        pintext.setFont(new Font("Times New Roman",Font.BOLD,16));
        image.add(pintext);
        
        pin=new JPasswordField();
        pin.setFont(new Font("Times ew Roman",Font.BOLD,25));
        pin.setBounds(330,320,180,25);
        image.add(pin);
        
        JLabel repintext=new JLabel("New PIN");
        repintext.setForeground(Color.WHITE);
        repintext.setBounds(165,360,180,25);
        repintext.setFont(new Font("Times New Roman",Font.BOLD,16));
        image.add(repintext);
        
        repin=new JPasswordField();
        repin.setFont(new Font("Times new Roman",Font.BOLD,25));
        repin.setBounds(330,360,180,25);
        image.add(repin);
        
        change=new JButton("Chnage");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);
        
        back=new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
       
        
    }
    public void actionPerformed(ActionEvent at){
        if(at.getSource()==change)
        {
        try{
            String npin=pin.getText();
            String rpin=repin.getText();
            if(!npin.equals(rpin))
            {
                JOptionPane.showMessageDialog(null,"Entered pin doesnot match" );
                return; 
            }
            if(npin.equals(""))
                {
                JOptionPane.showMessageDialog(null,"Please Enter pin" );
                return; 
            }
            if(rpin.equals(""))
                {
                JOptionPane.showMessageDialog(null,"Please Enter Re-renter pin" );
                return; 
            }
            Conn c=new Conn();
            String querry1="update bank set pin ='"+rpin+"'where pin='"+pinnumber+"'";
            String querry2="update login set pin ='"+rpin+"'where pin='"+pinnumber+"'";
            String querry3="update signupthree set pin ='"+rpin+"'where pin='"+pinnumber+"'";
            c.s.executeUpdate(querry1);
            c.s.executeUpdate(querry2);
            c.s.executeUpdate(querry3);
            JOptionPane.showMessageDialog(null,"Pin Changed Successfully" );
            setVisible(false);
            new Transactions(npin).setVisible(true);
            
            
            

        }
       
    
        catch(Exception e)
        {
            System.out.println(e);
        }
        }
        else
               setVisible(false);
             {
                new Transactions(pinnumber).setVisible(true);
            }
        
    }
    public static void main(String args[])
    {
        new PinChange("").setVisible(true);
    }
    
    
}
