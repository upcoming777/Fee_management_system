import  java.sql.*;
import javax.swing.*;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Dimension;
public class Fee_management_system  {
    void Strating(){
        JFrame j = new JFrame();
        j.getContentPane().setBackground(new Color(72,61,139));
        j.setUndecorated(true);
        j.setSize(600,400);
        j.setLocationRelativeTo(null);
        JLabel l1 = new JLabel("MITRC");
        JLabel l3 = new JLabel("FEE");
        JLabel l2 = new JLabel("MANAG");
        JLabel l4 = new JLabel("EMENT");
        JLabel l5 = new JLabel("SYSTE");
        JLabel l6 = new JLabel("M");
        JButton b = new JButton("ENTER");
        JButton exit = new JButton("EXIT");
        l1.setFont(new Font(l1.getFont().getName(), l1.getFont().getStyle(), 40));
        l2.setFont(new Font(l2.getFont().getName(), l2.getFont().getStyle(), 40));
        l3.setFont(new Font(l3.getFont().getName(), l3.getFont().getStyle(), 40));
        l4.setFont(new Font(l4.getFont().getName(), l4.getFont().getStyle(), 40));
        l5.setFont(new Font(l5.getFont().getName(), l5.getFont().getStyle(), 40));
        l6.setFont(new Font(l6.getFont().getName(), l6.getFont().getStyle(), 40));
        b.setBounds(200,250,150,40);
        b.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
                j.setVisible(false);
                Fee_management_system f = new Fee_management_system();
                f.Menu();
            }
            });
            exit.setBounds(200,350,150,40);
            exit.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.exit(0);
                }
            });
        l1.setBounds(150,50,150,40);
        l3.setBounds(300,50,150,40);
        l2.setBounds(20,150,150,40);
        l4.setBounds(170,150,150,40);
        l5.setBounds(350,150,150,40);
        l6.setBounds(480,150,150,40);
        j.add(l1);
        j.add(exit);
        j.add(l3);
        j.add(l2);
        j.add(l4);
        j.add(l5);
        j.add(l6);
        j.add(b);
        j.getRootPane().setBorder(BorderFactory.createMatteBorder(8,8,8,8,Color.BLACK));
        j.setLayout(null);
        j.setVisible(true);
        
    }
    void SignDataBase(String name , String password, JFrame j){
     try{
            StringBuffer query = new StringBuffer();
            StringBuffer q = new StringBuffer();
            q.append("select count(1) from login ;");
            String str = String.valueOf(q);
            System.out.println(str);
             java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/Test","root",null); 
Statement stmt=con.createStatement(); 
 ResultSet rs = stmt.executeQuery(str);
 rs.next();
 int count = rs.getInt(1);
 System.out.println(count);
 count++;
 String c = String.valueOf(count);
            query.append("insert into login values( "); 
            query.append(c);
            query.append(" , '");
        query.append(name);
        query.append("' , '");
        query.append(password);
        query.append("');");
        System.out.println(query);
        String q1= new String(query);
        Statement stmt1=con.createStatement();  
stmt1.executeUpdate(q1);  
System.out.println("ACCOUNT CREATION SUCCESS!!");
 JOptionPane.showMessageDialog(j,"ACCOUNT CREATED SUCCESSFULLY!"+ "YOUR ACCOUNT ID IS :" + c);
                 j.setVisible(false);
                 Fee_management_system f = new Fee_management_system();
                 f.Menu();
        }catch(Exception e){
            System.out.println("Error:"+e);
        }
    }
    void SIGNUP(){
        JFrame j = new JFrame("CRETAE ACCOUNT");
        j.setUndecorated(true);
        j.getContentPane().setBackground(new Color(72,61,139));
        JLabel l = new JLabel("ENTER DETAILS");
        JLabel l1 , l2 , l3 ;
         l1 = new JLabel("NAME:");
         l2 = new JLabel("PASSWORD:");
         l3 = new JLabel("CONFIRM PASSWORD:");
        JTextField name = new JTextField();
        JPasswordField pass , confirm ;
        pass = new JPasswordField();
        confirm = new JPasswordField();
        JButton SIGN = new JButton("SIGN_UP");
        JButton BACK = new JButton("BACK");
         l.setFont(new Font(l.getFont().getName(), l.getFont().getStyle(), 40));
         l.setBounds(100,0,450,50);
         BACK.setBounds(200,500,100,50);
         BACK.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
                 j.setVisible(false);
                 Fee_management_system f = new Fee_management_system();
                 f.Menu();
             }
         });
         name.setBounds(150,100,200,30);
         pass.setBounds(150,200,200,30);
         confirm.setBounds(150,300,200,30);
         SIGN.setBounds(200,400,100,50);
         SIGN.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
                String n = name.getText();
                char[] pa1 = pass.getPassword();
                char[] pa2 = confirm.getPassword();
                String str1 , str2;
                str1 =String.valueOf(pa1);
                str2 =String.valueOf(pa2);
                if(str1.equals(str2)==true){
                 Fee_management_system f = new Fee_management_system();
                 f.SignDataBase(n , str1 , j);
                }
                else
                 JOptionPane.showMessageDialog(j,"TRY AGAIN!!");
                 j.setVisible(false);
                 Fee_management_system f = new Fee_management_system();
                 f.Menu();
             }
         });
         l1.setBounds(20,100,200,30);
         l2.setBounds(20,200,200,30);
         l3.setBounds(20,300,200,30);
         j.add(l);
         j.add(name);
         j.add(BACK);
         j.add(pass);
         j.add(confirm);
         j.add(SIGN);
         j.add(l1);
         j.add(l2);
         j.add(l3);
         j.setSize(500,600);
         j.setLocationRelativeTo(null);
         j.getRootPane().setBorder(BorderFactory.createMatteBorder(8,8,8,8,Color.BLACK));
         j.setLayout(null);
         j.setVisible(true);
    }
    void Menu(){
        JFrame j = new JFrame("MENU");
        j.setUndecorated(true);
        j.getContentPane().setBackground(new Color(72,61,139));
        JLabel m = new JLabel("MENU");
         m.setFont(new Font(m.getFont().getName(), m.getFont().getStyle(), 40));
        JButton b1 = new JButton("ADMIN");
        JButton b2 = new JButton("LOGIN");
        JButton b3 = new JButton("SIGN UP");
        JButton b4 = new JButton("BACK");
        j.setSize(400,500);
        j.setLocationRelativeTo(null);
        m.setBounds(150,50,150,40);
        b1.setBounds(150,100,100,40);
        b4.setBounds(150,400,100,40);
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                j.setVisible(false);
                Fee_management_system f = new Fee_management_system();
                f.Strating();
            }
        });
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                j.setVisible(false);
                Fee_management_system f = new Fee_management_system();
                f.Admin();
            }
        });
        b2.setBounds(150,200,100,40);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                j.setVisible(false);
                Fee_management_system f = new Fee_management_system();
                f.Main_page1();
            }
        });
        b3.setBounds(150,300,100,40);
         b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                j.setVisible(false);
                Fee_management_system f = new Fee_management_system();
                f.SIGNUP();
            }
        });
        j.add(m);
        j.add(b1);
        j.add(b2);
        j.add(b3);
        j.add(b4);
        j.getRootPane().setBorder(BorderFactory.createMatteBorder(8,8,8,8,Color.BLACK));
        j.setLayout(null);
        j.setVisible(true);
    }
    void Admin(){
        JFrame j = new JFrame("ADMIN_PORTAL");
        j.setUndecorated(true);
        JTextField t1 = new JTextField();
        JPasswordField t2 = new JPasswordField();
        j.setSize(400,400);
        j.setLocationRelativeTo(null);
        JButton b = new JButton("LOGIN");
        JButton BACK = new JButton("BACK");
        j.getContentPane().setBackground(new Color(72,61,139));
        JLabel l1 = new JLabel("Enter username:");
        JLabel l2 = new JLabel("Enter password");
        JLabel l3 = new JLabel("ADMIN PORTAL");
        l3.setFont(new Font(l3.getFont().getName(), l3.getFont().getStyle(), 40));
    l1.setBounds(50,75,100,100);
    l2.setBounds(50,125,100,100);
    l3.setBounds(40,0,400,50);
    t1.setBounds(150,100,100,40);
    t2.setBounds(150,150,100,40);
    BACK.setBounds(150,300,100,40);
    BACK.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            j.setVisible(false);
            Fee_management_system f= new Fee_management_system();
            f.Menu();
        }
    });
    b.setBounds(150,250,100,40);
    b.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
             String name ;
    String pass;
    name = t1.getText();
    char[] pa = t2.getPassword();
    pass = String.valueOf(pa);
    Fee_management_system f = new Fee_management_system();
    f.AdminDataBase(name , pass,j);
        }
    });
    j.add(t1);
    j.add(t2);
    j.add(l1);
    j.add(l2);
    j.add(b);
    j.add(BACK);
    j.add(l3);
    j.getRootPane().setBorder(BorderFactory.createMatteBorder(8,8,8,8,Color.BLACK));
    j.setLayout(null);
    j.setVisible(true);
    }
    void fetchDataBase(){
        try{
        StringBuffer str = new StringBuffer("select * from login");
        String s = String.valueOf(str);
        java.sql.Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3307/Test","root",null); 
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery(s);
JFrame j = new JFrame();
j.getRootPane().setBorder(BorderFactory.createMatteBorder(8,8,8,8,Color.BLACK));
j.setUndecorated(true);
j.getContentPane().setBackground(new Color(72,61,139));
JPanel p = new JPanel();
p.setBounds(0,0,700,600);
p.setBackground(Color.GREEN);
JTextArea t = new JTextArea();
t.setBounds(0,0,700,600);
t.setBackground(Color.GREEN);
t.setEditable(false);
ImageIcon ii = new ImageIcon("download.jfif");
JButton b = new JButton(ii);
b.setBounds(570,470,100,100);
b.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent evt){
        j.setVisible(false);
        Fee_management_system f = new Fee_management_system();
        f.AdminPage();
    }
});
j.add(b);
j.add(t);
t.append("ID:");
t.append("\t\t");
t.append("NAME:");
t.append("\t\t");
t.append("PASSWORD:");
t.append("\t\t");
t.append("fees Submitted");
t.append("\n\n");
while(rs.next()){
    t.append(String.valueOf(rs.getInt(1)));
    t.append("\t\t");
    t.append(rs.getString(2));
    t.append("\t\t");
    t.append(rs.getString(3));
    t.append("\t\t");
    t.append(rs.getString(4));
    t.append("\n");
}
j.setSize(700,600);
j.setLocationRelativeTo(null);
j.setLayout(null);
j.setVisible(true);
    }catch(Exception e){
        System.out.print("Error:"+e);
    }
}
void Last(){
    try{
        JFrame k = new JFrame();
        k.setUndecorated(true);
        k.getRootPane().setBorder(BorderFactory.createMatteBorder(8,8,8,8,Color.BLACK));
        JLabel l = new JLabel("LAST 10 TRANSECTION");
        ImageIcon ii = new ImageIcon("download.jfif");
        JTextArea t = new JTextArea();
        t.setEditable(false);
        JButton b = new JButton(ii);
        JPanel p = new JPanel();
        t.setBackground(Color.GREEN);
        p.setBackground(Color.BLUE);
        l.setFont(new Font(l.getFont().getName(),l.getFont().getStyle(),40));
        l.setBounds(75,0,500,50);
        t.setBounds(0,100,600,500);
        p.setBounds(0,0,600,600);    
        b.setBounds(500,500,100,100);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                k.setVisible(false);
                Fee_management_system f = new Fee_management_system();
                f.AdminPage();
            }
        });
            String q="select * from LAST";
    java.sql.Connection con=DriverManager.getConnection(  
        "jdbc:mysql://localhost:3307/Test","root",null); 
        Statement stmt=con.createStatement();  
        ResultSet rs=stmt.executeQuery(q);
    k.add(l);
    k.add(b);
    k.add(t);
        t.append("NUMBER\t\t");
        t.append("NAME\t\t");
        t.append("FEES\t\t\n");
        while(rs.next()){
            t.append(String.valueOf(rs.getInt(1)));
            t.append("\t\t");
            t.append(rs.getString(2));
            t.append("\t\t");
            t.append(String.valueOf(rs.getInt(3)));
            t.append("\n");
            k.setSize(600,600);
            k.setLocationRelativeTo(null);
            k.setLayout(null);
             k.setVisible(true);
        }  
        k.add(p);            
 }catch(Exception e){
     System.out.println("error:"+e);
 }

}
    void AdminPage(){
        JFrame j =new JFrame();
        JLabel l =new JLabel("ADMIN PORTAL");
        l.setBounds(150,0,400,50);
        l.setFont(new Font(l.getFont().getName(), l.getFont().getStyle(), 40));
        j.getContentPane().setBackground(new Color(72,61,139));
        j.setUndecorated(true);
        ImageIcon i1 = new ImageIcon("download.jfif");
        ImageIcon i2 = new ImageIcon();
        j.setUndecorated(true);
        j.getRootPane().setBorder(BorderFactory.createMatteBorder(8,8,8,8,Color.BLACK));
        JButton database , last ,AddPerson, DeletePerson , AddAdmin ;
        last = new JButton("LAST");
        database = new JButton("DATABASE");

        database.setBounds(100,100,100,50);
        database.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                j.setVisible(false);
                Fee_management_system f = new Fee_management_system();
                f.fetchDataBase();
            }
        });
        last.setBounds(100,200,100,50);
        last.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                j.setVisible(false);
                Fee_management_system f = new Fee_management_system();
                f.Last();
            }
        });
        JButton b = new JButton(i1);
        b.setBounds(500,500,100,100);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){
                j.setVisible(false);
                Fee_management_system f = new Fee_management_system();
                f.Admin();
            }
        });
        j.setSize(600,600);
        j.setLocationRelativeTo(null);
        j.add(b);
        j.add(database);
        j.add(last);
        j.add(l);
        j.setLayout(null);
        j.setVisible(true);
    }
    void AdminDataBase(String name , String pass ,JFrame j){
        try{
            StringBuffer query = new StringBuffer();
            String password; 
            query.append("select password from Admin where name ="); 
        query.append("'");
        query.append(name);
        query.append("'");
        query.append(";");
        System.out.println(query);
        String q = new String(query);
        java.sql.Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3307/Test","root",null); 
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery(q);
rs.next();
password = rs.getString(1);
System.out.println(password);
if(password.equals(pass)==true){
    System.out.println("successfully login!");
    j.setVisible(false);
    Fee_management_system f = new Fee_management_system();
    f.AdminPage(); 
}  
        }catch(Exception e){
            System.out.println("Error:"+e);
        }
    }
    void Main_page1(){
        JFrame Main_page = new JFrame("Fee Management System");
         Main_page.setUndecorated(true);
         Main_page.getContentPane().setBackground(new Color(72,61,139));
        JButton login = new JButton("LOGIN");
        JLabel j1 = new JLabel("Enter name :");
        JLabel j2 = new JLabel("Enter password:");
        JLabel l3 = new JLabel("ENTER DETAILS");
        JLabel l4 = new JLabel("ENTER ACCOUNT ID:");
        l3.setFont(new Font(l3.getFont().getName(), l3.getFont().getStyle(), 40));
        JTextField user ;
        JTextField id = new JTextField();
        JButton BACK= new JButton("BACK");
        JPasswordField pass;
        user = new JTextField();
        pass = new JPasswordField();
        id.setBounds(100,100,150,50);
        l4.setBounds(0,100,150,50);
        l3.setBounds(40,0,400,50);
        BACK.setBounds(300,400,100,40);
        BACK.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Main_page.setVisible(false);
                Fee_management_system f = new Fee_management_system();
                f.Menu();
            }
        } );
        login.setBounds(100,400,100,40);
        login.addActionListener(new ActionListener(){
          
            public void actionPerformed(ActionEvent e){
                  String name =  user.getText();
        char  pa[] = pass.getPassword();
        String password = String.valueOf(pa);
        String str = id.getText();
        int i = Integer.parseInt(str);
                Fee_management_system f = new Fee_management_system();
                 f.LoginDataBase(i,name , password , Main_page);
            }
        });
        user.setBounds(100,200,150,50);
        Main_page.add(user);
        Main_page.add(BACK);
        pass.setBounds(100,300,150,50);
        j1.setBounds(0,200,150,50);
        j2.setBounds(0,300,150,50);
        Main_page.add(pass);
        Main_page.add(l3);
        Main_page.add(l4);
        Main_page.add(id);
        Main_page.add(j1);  Main_page.add(j2);  Main_page.add(login);
        Main_page.setSize(400,500);
        Main_page.setLocationRelativeTo(null);
        Main_page.getRootPane().setBorder(BorderFactory.createMatteBorder(8,8,8,8,Color.BLACK));
        Main_page.setLayout(null);
        Main_page.setVisible(true);
    }
    void addFees(String str , int id){
        try{
        StringBuffer query =new StringBuffer(); 
        query.append("UPDATE login SET fees = ") ; 
        query.append(str);
        query.append(" WHERE id = ");
    query.append(String.valueOf(id));
   // query.append(";");
    System.out.println(query);
    String q1= new String(query);
    System.out.println(q1);
    java.sql.Connection con = DriverManager.getConnection(  
        "jdbc:mysql://localhost:3307/test","root",null); 
    Statement stmt1=con.createStatement();  
stmt1.executeUpdate(q1);  
System.out.println("fees updated success!!");
    }catch(Exception e){
        e.printStackTrace();
        System.out.print(e);
        System.out.print("chirag");
    }
}
     void Login_page(int id){
        JFrame j = new JFrame("LOGIN_PAGE");
        j.setUndecorated(true);
        JTextField name , batch ,father , mother ,amount , Phone ;
        JLabel n , b , f , m , am,ph,e;
        e= new JLabel("RECIEPT ENTRIES");
        n = new JLabel("NAME:");
        f= new JLabel("FATHER's NAME:");
        b = new JLabel("BATCH:");
        m = new JLabel("MOTHER's NAME:");
        am= new JLabel("ENTER AMOUNT:");
        ph= new JLabel("ENTER PHONE:");
           JComboBox course , Dept ,mop;
        final JTextArea a = new JTextArea();
        a.setBackground(Color.GREEN);
        JButton Generate , Exit , Back , Print;
        Generate = new JButton("Generate reciept");
        Exit = new JButton("Exit.");
        JButton submit = new JButton("SUBMIT");
        Back= new JButton("Back"); 
        Print = new JButton("Print");
         String c[]={"B.TECH.","MBA","M.TECH."};
         String Dep[] = {"CSE","ECE","MECHANICAL","CIVIL","ELECTRICAL"};
         String mod[]={"MOD OF PAYMENT","CASH","DEBIT CARD","CREDIT CARD"};
        name = new JTextField();
        father = new JTextField();
        mother= new JTextField();
        amount = new JTextField();
        Phone = new JTextField();
        course = new JComboBox(c);
        Dept = new JComboBox(Dep);
        mop= new JComboBox(mod);
        batch = new JTextField();
        name.setBounds(100,50,150,40);
        father.setBounds(100,100,150,40);
        mother.setBounds(100,150,150,40);
        Phone.setBounds(100,200,150,40);
        amount.setBounds(100,250,150,40);
        course.setBounds(100,300,150,40);
        Dept.setBounds(100,350,150,40);
        batch.setBounds(100,400,150,40);
        mop.setBounds(100,500,150,40);
        Generate.setBounds(0,600,150,50);
        submit.setBounds(200,600,150,50);
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Fee_management_system f =new Fee_management_system();
                if((name.getText().isEmpty())||(father.getText().isEmpty())||(mother.getText().isEmpty())||(Phone.getText().isEmpty())||(amount.getText().isEmpty())||(batch.getText().isEmpty())){
                    
                JOptionPane.showMessageDialog(j,"Enter Details");
                }
                else{
                    f.addLast(Integer.parseInt(amount.getText()),id);
                f.addFees(amount.getText(),id);
                }
        }
        });
        Generate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                String na , fat , moth , pho , amo ,m , cou , D;
                na = name.getText();
                fat = father.getText();
                moth=mother.getText();
                pho = Phone.getText();
                amo = amount.getText();
                m=(String)mop.getSelectedItem();
                cou=(String)course.getSelectedItem();
                D=(String)Dept.getSelectedItem();
                if(!(na.isEmpty())&&!(fat.isEmpty())&&!(moth.isEmpty())&&!(pho.isEmpty())&&!(amo.isEmpty())&&!(batch.getText().isEmpty())){
                a.setText(null);
                a.append("==========================MITRC==========================\n");
                a.append("\n\n\n");
                a.append("=========================================================\n");
                a.append("name          : "+na);
                a.append("\n\n");
                a.append("Father's Name : "+fat);
                a.append("\n\n");
                a.append("Mother's Name : "+moth);
                a.append("\n\n");
                a.append("phone No.     : "+pho);
                a.append("\n\n");
                a.append("Amount        : "+amo);
                a.append("\n\n");
                a.append("Mod Of Payment: "+m);
                a.append("\n\n");
                a.append("course        : "+cou);
                a.append("\n\n");
                a.append("Dept          : "+D);
                a.append("\n\n\n\n");
                a.append("Student Singnature.                                                                       Accounts.");
                }
                else
                JOptionPane.showMessageDialog(j,"Enter Details");
            }
        });
        Back.setBounds(400,600,150,50);
        Back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                j.setVisible(false);
                Fee_management_system f = new Fee_management_system();
                f.Menu();
            }
        });        
        Print.setBounds(600,600,150,50);
        Print.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
            try{   
                if(!(a.getText().isEmpty())){ 
                    Fee_management_system f = new Fee_management_system();
                    f.addFees(amount.getText(), id);
                    f.addLast(Integer.parseInt(amount.getText()), id);
                    a.print();
                }
                else{
                    JOptionPane.showMessageDialog(j,"First Generate Reciept");
                }
        }catch(Exception e){
                System.out.println("error:"+e);
            }
            }
        });
        Exit.setBounds(800,600,150,50);  
        Exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                System.exit(0);
            }
        });
        n.setBounds(0,50,100,40);
        f.setBounds(0,100,100,40);
        m.setBounds(0,150,100,40);
        am.setBounds(0,250,100,40);
        ph.setBounds(0,200,100,40);
        b.setBounds(0,400,100,40);
        e.setBounds(100,0,400,50);
        e.setFont(new Font(e.getFont().getName(), e.getFont().getStyle(), 40));
        j.getContentPane().setBackground(new Color(72,61,139));
        JPanel p = new JPanel();
        p.setBackground(Color.GREEN);
        p.add(new JScrollPane(a));
        p.setBounds(600,0,400,500);
        a.setBounds(600,0,400,500);
        j.setSize(1000,700);
        j.add(p);
        j.add(Generate);
        j.add(Exit);
        j.add(Back);
        j.add(Print);
        j.add(a);
        j.add(e);
        j.add(submit);
        j.add(mop);
        j.add(name);
        j.add(father);
        j.add(mother);
        j.add(Phone);
        j.add(amount);
        j.add(course);
        j.add(Dept);
        j.add(batch);
        j.add(course);
        j.add(n);
        j.add(f);
        j.add(m);
        j.add(am);
        j.add(ph);
        j.add(b);
        j.setLocationRelativeTo(null);
        j.setLayout(null);
        j.setVisible(true);
    }
    void addLast(int id , int am){
        try{
            String name = new String("");
            StringBuffer query =new StringBuffer(); 
            query.append("select name from LAST where id =");
            query.append(String.valueOf(id));
        String q1= new String(query);
        System.out.println(q1);
        java.sql.Connection con = DriverManager.getConnection(  
            "jdbc:mysql://localhost:3307/Test","root",null); 
        Statement stmt1=con.createStatement();  
    ResultSet rs = stmt1.executeQuery(q1);
            name = rs.getString(2);
            query = new StringBuffer("");
            query.append("insert into LAST values(");
            query.append(String.valueOf(id));
            query.append(",");
            query.append(name);
            query.append(",");
            query.append(String.valueOf(am));
            System.out.println(query);
            q1=String.valueOf(query);
             stmt1.executeUpdate(q1);
    System.out.println("fees updated success!!");
        
        }catch(Exception e){
            System.out.print("error:"+e);
        }
    }
    void LoginDataBase( int i,String name , String pass ,JFrame j){
          String password;
     StringBuffer query= new StringBuffer();
         try{
        query.append("select password from login where name ="); 
        query.append("'");
        query.append(name);
        query.append("'");
        query.append("and ");
        query.append("id =");
        query.append(i);
        query.append(";");
        System.out.println(query);
        String q = new String(query);
        java.sql.Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3307/Test","root",null); 
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery(q);
rs.next();
password = rs.getString(1);
System.out.println(password);
if(password.equals(pass)==true){
    System.out.println("successfully login!");
    j.setVisible(false);
    JOptionPane.showMessageDialog(j,"LOGIN SUCCESS!!");
    Fee_management_system f = new Fee_management_system();
    f.Login_page(i);
}  
            }catch(Exception e){
                System.out.println("exception "+ e);
            }
    }
    public static void main(String[]args){
        Fee_management_system f = new Fee_management_system();
        f.Strating();
    }
}