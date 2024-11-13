package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import static java.awt.Color.black;
import static java.awt.Color.white;

public class Signup1 extends JFrame implements ActionListener
{
    JTextField nameTextField,fnameTextField,addressTextField,emailTextField,cityTextField,stateTextField,pincodeTextField;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser dateChooser;
    long random;
    JButton next;
    Signup1()
    {
        setLayout(null);
        
        Random ran=new Random();
        random=Math.abs((ran.nextLong()%9000L+1000L));
        
        JLabel formno=new JLabel("APPLIVATION FOURM NO."+random);
        formno.setFont(new Font("Times New Roman",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personalDetails=new JLabel("Page 1:Personal Details");
        personalDetails.setFont(new Font("Times New Roman",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);
        
        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Times New Roman",Font.BOLD,30));
        name.setBounds(100,140,300,30);
        add(name);
        
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Times New Roman",Font.BOLD,30) );
        nameTextField.setBounds(350,140,440,30);
        add(nameTextField);
        
        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Times New Roman",Font.BOLD,30));
        fname.setBounds(100,190,300,30);
        add(fname);
        
        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Times New Roman",Font.BOLD,30) );
        fnameTextField.setBounds(350,190,440,30);
        add(fnameTextField);
        
        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Times New Roman",Font.BOLD,30));
        dob.setBounds(100,240,300,30);
        add(dob);
        
        dateChooser= new JDateChooser();
        dateChooser.setBounds(350,240,200,30);
        dateChooser.setForeground(black);
        add(dateChooser);
        
        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Times New Roman",Font.BOLD,30));
        gender.setBounds(100,290,300,30);
        add(gender);
        
        male= new JRadioButton("Male");
        male.setBounds(350,290,100,30);
        male.setBackground(white);
        add(male);
        
        female= new JRadioButton("Female");
        female.setBounds(500,290,100,30);
        female.setBackground(white);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email=new JLabel("E-mail Address:");
        email.setFont(new Font("Times New Roman",Font.BOLD,30));
        email.setBounds(100,340,300,30);
        add(email);
        
        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Times New Roman",Font.BOLD,30) );
        emailTextField.setBounds(350,340,440,30);
        add(emailTextField);
        
       
        JLabel marital=new JLabel("Marital status:");
        marital.setFont(new Font("Times New Roman",Font.BOLD,30));
        marital.setBounds(100,390,300,30);
        add(marital);
        
        married= new JRadioButton("Married");
        married.setBounds(350,390,100,30);
        married.setBackground(white);
        add(married);
        
        unmarried= new JRadioButton("Unmarried");
        unmarried.setBounds(500,390,100,30);
        unmarried.setBackground(white);
        add(unmarried);
        
        other= new JRadioButton("Other");
        other.setBounds(650,390,100,30);
        other.setBackground(white);
        add(other);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(male);
        maritalgroup.add(female);
        
        JLabel address=new JLabel("Address :");
        address.setFont(new Font("Times New Roman",Font.BOLD,30));
        address.setBounds(100,440,300,30);
        add(address);
        
        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Times New Roman",Font.BOLD,30) );
        addressTextField.setBounds(350,440,440,30);
        add(addressTextField);
        
        JLabel city=new JLabel("City:");
        city.setFont(new Font("Times New Roman",Font.BOLD,30));
        city.setBounds(100,490,300,30);
        add(city);
        
        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Times New Roman",Font.BOLD,30) );
        cityTextField.setBounds(350,490,440,30);
        add(cityTextField);
        
        
        JLabel state=new JLabel("State:");
        state.setFont(new Font("Times New Roman",Font.BOLD,30));
        state.setBounds(100,540,300,30);
        add(state);
        
        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Times New Roman",Font.BOLD,30) );
        stateTextField.setBounds(350,540,440,30);
        add(stateTextField);
        
        JLabel pincode=new JLabel("Pincode:");
        pincode.setFont(new Font("Times New Roman",Font.BOLD,30));
        pincode.setBounds(100,590,300,30);
        add(pincode);
        
        pincodeTextField=new JTextField();
        pincodeTextField.setFont(new Font("Times New Roman",Font.BOLD,30) );
        pincodeTextField.setBounds(350,590,440,30);
        add(pincodeTextField);
        
        getContentPane().setBackground(white);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
        next =new JButton("Next");
        next.setBackground(black);
        next.setForeground(white);
        next.setFont(new Font("Times New Roman",Font.BOLD,16));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String formno =""+random;
        String name=nameTextField.getText();
        String fname=fnameTextField.getText();
        String dob=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }
        else
        {
            gender="Female";
        }
        String email=emailTextField.getText();
        String marital=null;
        if(married.isSelected())
        {
            marital="married";
        }
        else if(unmarried.isSelected())
        {
            marital="Unmarried";
        }
        else
        {
            marital="Others";
        }
        String address=addressTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pin=pincodeTextField.getText();
        try{
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(rootPane,"Name is Required");
            }
            else{
                Conn c=new Conn();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new Signup2(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
            
        }
        
    }
    public static void main(String args[])
     {
         new Signup1();
     }
}
