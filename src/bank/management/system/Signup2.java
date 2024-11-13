package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.awt.Color.black;
import static java.awt.Color.white;
//import static java.awt.Color.white;

public class Signup2 extends JFrame implements ActionListener
{
    JTextField nameTextField,fnameTextField,panTextField,emailTextField,aadharTextField,stateTextField,pincodeTextField;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religionTextField,categoryTextField,incomeTextField,educationTextField,occupationTextField;
    String formno;
    JButton next;
    Signup2(String formno)
    {
        this.formno=formno;
        setLayout(null);
        setTitle("new Account form-Page 2");
      
        JLabel additionalDetails=new JLabel("Page 1:Additional Details");
        additionalDetails.setFont(new Font("Times New Roman",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel religion=new JLabel("Religion:");
        religion.setFont(new Font("Times New Roman",Font.BOLD,30));
        religion.setBounds(100,140,300,30);
        add(religion);
        
        String valreligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        religionTextField = new JComboBox(valreligion);
        religionTextField.setBounds(350,140,440,30);
        religionTextField.setBackground(white);
        add(religionTextField);
        
        JLabel category=new JLabel("Category:");
        category.setFont(new Font("Times New Roman",Font.BOLD,30));
        category.setBounds(100,190,300,30);
        add(category);
        
        String valcategory[]={"General","OBC","SC","ST","Other"};
        categoryTextField = new JComboBox(valcategory);
        categoryTextField.setBounds(350,190,440,30);
        categoryTextField.setBackground(white);
        add(categoryTextField);
        
        JLabel income=new JLabel("Income:");
        income.setFont(new Font("Times New Roman",Font.BOLD,30));
        income.setBounds(100,240,300,30);
        add(income);
        
        String valincome[]={"Null","<1,50,000","<3,00,000","<5,00,000",">5,00,000"};
        incomeTextField = new JComboBox(valincome);
        incomeTextField.setBounds(350,240,440,30);
        incomeTextField.setBackground(white);
        add(incomeTextField);
        
        
        JLabel educatoinl=new JLabel("Educationl");
        educatoinl.setFont(new Font("Times New Roman",Font.BOLD,30));
        educatoinl.setBounds(100,290,300,30);
        add(educatoinl);
        
        JLabel qualification=new JLabel("Qualification:");
        qualification.setFont(new Font("Times New Roman",Font.BOLD,30));
        qualification.setBounds(100,340,300,30);
        add(qualification);
        
        
        String valeducation[]={"Non-Graduate","Graduate","Post-Graduation","Doctrate","Others"};
        educationTextField = new JComboBox(valeducation);
        educationTextField.setBounds(350,315,440,30);
        educationTextField.setBackground(white);
        add(educationTextField);
       
        JLabel occupation=new JLabel("Occupation:");
        occupation.setFont(new Font("Times New Roman",Font.BOLD,30));
        occupation.setBounds(100,390,300,30);
        add(occupation);
        
        String valoccupation[]={"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
        occupationTextField = new JComboBox(valoccupation);
        occupationTextField.setBounds(350,390,440,30);
        occupationTextField.setBackground(white);
        add(occupationTextField);
        
        JLabel pan=new JLabel("Pan number :");
        pan.setFont(new Font("Times New Roman",Font.BOLD,30));
        pan.setBounds(100,440,300,30);
        add(pan);
        
        panTextField=new JTextField();
        panTextField.setFont(new Font("Times New Roman",Font.BOLD,30) );
        panTextField.setBounds(350,440,440,30);
        add(panTextField);
        
        JLabel aadhar=new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Times New Roman",Font.BOLD,30));
        aadhar.setBounds(100,490,300,30);
        add(aadhar);
        
        aadharTextField=new JTextField();
        aadharTextField.setFont(new Font("Times New Roman",Font.BOLD,30) );
        aadharTextField.setBounds(350,490,440,30);
        add(aadharTextField);
        
        
        JLabel seniorcitizen=new JLabel("Senior Citizen:");
        seniorcitizen.setFont(new Font("Times New Roman",Font.BOLD,30));
        seniorcitizen.setBounds(100,540,300,30);
        add(seniorcitizen);
        
        syes= new JRadioButton("Yes");
        syes.setBounds(350,540,100,30);
        syes.setBackground(white);
        add(syes);
        
        sno= new JRadioButton("No");
        sno.setBounds(500,540,100,30);
        sno.setBackground(white);
        add(sno);
        
        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);
        
        JLabel exisitingAccount=new JLabel("Exisiting Account:");
        exisitingAccount.setFont(new Font("Times New Roman",Font.BOLD,30));
        exisitingAccount.setBounds(100,590,300,30);
        add(exisitingAccount);
        
        
        eyes= new JRadioButton("Yes");
        eyes.setBounds(350,590,100,30);
        eyes.setBackground(white);
        add(eyes);
        
        eno= new JRadioButton("No");
        eno.setBounds(500,590,100,30);
        eno.setBackground(white);
        add(eno);
        
        ButtonGroup existinggroup = new ButtonGroup();
        existinggroup.add(eyes);
        existinggroup.add(eno);
       
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
        String sreligion=(String) religionTextField.getSelectedItem();
        String scategory=(String)categoryTextField.getSelectedItem();
        String sincome=(String)incomeTextField.getSelectedItem();;
        String seducation=(String)educationTextField.getSelectedItem();
        String soccupation=(String)occupationTextField.getSelectedItem();
        String seniorcitizen=null;
        if(syes.isSelected()){
            seniorcitizen="Yes";
        }
        else
        {
            seniorcitizen="No";
        }
        String exisitingaccount=null;
        if(eyes.isSelected())
        {
            exisitingaccount="Yes";
        }
        else
        {
            exisitingaccount="No";
        }
        String span=panTextField.getText();
        String saadhar=aadharTextField.getText();
        try{
                Conn c=new Conn();
                String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+exisitingaccount+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new Signup3(formno).setVisible(true);
                
            
        }catch(Exception e){
            System.out.println(e);
            
        }
        
    }
    public static void main(String args[])
     {
         new Signup2("");
     }
}
