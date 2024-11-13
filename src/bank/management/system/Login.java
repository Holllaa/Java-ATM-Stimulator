package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.awt.Color.black;
import static java.awt.Color.green;
import static java.awt.Color.white;
import java.sql.*;
public class Login extends JFrame implements ActionListener
{
	JButton login,clear,signup;
        JTextField cardTextField;
        JPasswordField pinTextField;
	Login()
	  {
		  
		  setTitle("Automated Teller Machine");
		  setLayout(null);
		  
		    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));
	          Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
	        ImageIcon i3 = new ImageIcon(i2);
	        JLabel l11 = new JLabel(i3);
	        l11.setBounds(70, 10, 100, 100);
	        add(l11);
		  
		  
                  login=new JButton("SIGN IN");
                  login.setBounds(300,300,100,30);
                  login.setBackground(black);
                  login.setForeground(white);
                  login.addActionListener(this);
                  add(login);
                  
                  clear=new JButton(" CLEAR ");
                  clear.setBounds(430,300,100,30);
                  clear.setBackground(white);
                  clear.setForeground(black);
                  clear.addActionListener(this);
                  add(clear);
                 
                  signup=new JButton("SIGN UP");
                  signup.setBounds(300,340,230,30);
                  signup.setBackground(green);
                  signup.setForeground(white);
                  signup.addActionListener(this);
                  add(signup);
                  
                  
                  pinTextField =new JPasswordField();
		  pinTextField.setBounds(250,220,150,40);
                  pinTextField.setFont(new Font("Times New Roman",Font.BOLD,30));
		  add(pinTextField);
                 

		  cardTextField =new JTextField();
		  cardTextField.setBounds(250,150,400,40);
                  cardTextField.setFont(new Font("Times New Roman",Font.BOLD,30));
		  add(cardTextField); 
                  
		  getContentPane().setBackground(Color.WHITE);
		  setSize(800,480);
		  setVisible(true);
		  setLocation(350,200);
		  
		  JLabel text=new JLabel("Welcome to ATM");
		  text.setFont(new Font("Times New Roman",Font.BOLD,36));
		  text.setBounds(200,40,400,40);
		  add(text);
		  
		  JLabel cardno=new JLabel("Card No:");
		  cardno.setFont(new Font("Times New Roman",Font.BOLD,30));
		  cardno.setBounds(120,150,150,40);
		  add(cardno);
                  
		  JLabel pin=new JLabel("PIN:");
		  pin.setFont(new Font("Times New Roman",Font.BOLD,30));
		  pin.setBounds(180,220,150,40);
		  add(pin);
                  	  
	  }
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==clear)
            {
                
                cardTextField.setText("");
                pinTextField.setText("");
            }
            else if(ae.getSource()==login)
            {
                String cardnumber=cardTextField.getText();
                String pin=pinTextField.getText();
                String query="select * from login where cardnumber ='"+cardnumber+"'and pin = '"+pin+"'";
                
                Conn c=new Conn();
                try{
                    ResultSet r=c.s.executeQuery(query);
                    if(r.next())
                    {
                        setVisible(false);
                        new Transactions(pin).setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Incorrect card Number or Pin");
                    }
                }catch(Exception e)
                {
                    System.out.println(e);
                }
                
            }
            else if(ae.getSource()==signup)
            {
                 setVisible(false);
                 new Signup1().setVisible(true);
            }
        }

        
        public static void main (String args[])
        {
    	  new Login();
      }
}