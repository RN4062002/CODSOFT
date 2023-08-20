package studentManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddStudent extends JFrame implements ActionListener {
   JTextField textField1,textField2,textField3,textField4,textField5;
   JButton btn,btn2;
    AddStudent(){
        setSize(800,600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Student Management System");
        setLocation(300, 150);

        JLabel heading = new JLabel("Add Student");
        heading.setBounds(270,20,300,50);
        heading.setFont(new Font("Arial",Font.BOLD,30));
        add(heading);

        JLabel l1  = new JLabel("Student Name:");
        l1.setBounds(100,90,200,30);
        l1.setFont(new Font("Arial",Font.PLAIN,20));
        add(l1);

        JLabel l2 = new JLabel("Roll No:");
        l2.setBounds(100,130,200,30);
        l2.setFont(new Font("Arial",Font.PLAIN,20));
        add(l2);

        JLabel l3  = new JLabel("Grade:");
        l3.setBounds(100,170,200,30);
        l3.setFont(new Font("Arial",Font.PLAIN,20));
        add(l3);

        JLabel l4 = new JLabel("Phone No:");
        l4.setBounds(100,210,200,30);
        l4.setFont(new Font("Arial",Font.PLAIN,20));
        add(l4);

        JLabel l5 = new JLabel("Email:");
        l5.setBounds(100,250,200,30);
        l5.setFont(new Font("Arial",Font.PLAIN,20));
        add(l5);

        textField1 = new JTextField();
        textField1.setBounds(290,90,200,30);
        textField1.setFont(new Font("Arial",Font.PLAIN,20));
        add(textField1);

        textField2 = new JTextField();
        textField2.setBounds(290,130,200,30);
        textField2.setFont(new Font("Arial",Font.PLAIN,20));
        add(textField2);

        textField3 = new JTextField();
        textField3.setBounds(290,170,200,30);
        textField3.setFont(new Font("Arial",Font.PLAIN,20));
        add(textField3);

        textField4 = new JTextField();
        textField4.setBounds(290,210,200,30);
        textField4.setFont(new Font("Arial",Font.PLAIN,20));
        add(textField4);

        textField5 = new JTextField();
        textField5.setBounds(290,250,200,30);
        textField5.setFont(new Font("Arial",Font.PLAIN,20));
        add(textField5);

        btn = new JButton("Submit");
        btn.setBounds(290,290,100,30);
        btn.setFont(new Font("Arial",Font.PLAIN,15));
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        btn.addActionListener(this);
        add(btn);

        btn2 = new JButton("Back");
        btn2.setBounds(400,290,90,30);
        btn2.setFont(new Font("Arial",Font.PLAIN,15));
        btn2.addActionListener(this);
        btn2.setBackground(Color.BLACK);
        btn2.setForeground(Color.WHITE);
        add(btn2);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==btn){
          String name = textField1.getText();
          String rollno = textField2.getText();
          String grade = textField3.getText();
          String phone = textField4.getText();
          String email = textField5.getText();

          try{
              String query = "insert into student values('"+name+"','"+rollno+"','"+grade+"','"+phone+"','"+email+"')";
              Conn con = new Conn();
              con.s.executeUpdate(query);

              JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
              setVisible(false);
              new dashboard();
          } catch (SQLException ex) {
              throw new RuntimeException(ex);
          }
      }else{
           setVisible(false); new dashboard();
      }
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
