package studentManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

public class dashboard extends JFrame implements ActionListener {

    JButton btn1,btn2,btn3,btn4,btn5,btn6;

    dashboard(){
        setSize(800,600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Student Management System");
        setLocation(300, 150);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/student1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(300, 50, 500, 300);
        add(image);

        btn1 = new JButton("Add Student");
        btn1.setBounds(100,50,150,30);
        btn1.setFont(new Font("Arial",Font.PLAIN,15));
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.WHITE);
        btn1.addActionListener(this);
        add(btn1);

        btn2 = new JButton("Remove Student");
        btn2.setBounds(100,90,150,30);
        btn2.setFont(new Font("Arial",Font.PLAIN,15));
        btn2.setBackground(Color.BLACK);
        btn2.setForeground(Color.WHITE);
        btn2.addActionListener(this);
        add(btn2);

        btn3 = new JButton("Update Student");
        btn3.setBounds(100,130,150,30);
        btn3.setFont(new Font("Arial",Font.PLAIN,15));
        btn3.setBackground(Color.BLACK);
        btn3.setForeground(Color.WHITE);
        btn3.addActionListener(this);
        add(btn3);

        btn4 = new JButton("Display Student Details");
        btn4.setBounds(100,170,150,30);
        btn4.setFont(new Font("Arial",Font.PLAIN,15));
        btn4.setBackground(Color.BLACK);
        btn4.setForeground(Color.WHITE);
        btn4.addActionListener(this);
        add(btn4);

        btn5 = new JButton("search Student");
        btn5.setBounds(100,210,150,30);
        btn5.setFont(new Font("Arial",Font.PLAIN,15));
        btn5.setBackground(Color.BLACK);
        btn5.setForeground(Color.WHITE);
        btn5.addActionListener(this);
        add(btn5);

        btn6 = new JButton("Exit");
        btn6.setBounds(100,250,150,30);
        btn6.setFont(new Font("Arial",Font.PLAIN,15));
        btn6.setBackground(Color.BLACK);
        btn6.setForeground(Color.WHITE);
        btn6.addActionListener(this);
        add(btn6);

       setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==btn1){
          setVisible(false);
          new AddStudent();
      } else if (e.getSource() == btn2) {
          setVisible(false);
                 new removeStudent();
      }else if (e.getSource() == btn3) {
          setVisible(false);
                 new updateStudent();
      }else if (e.getSource() == btn4) {
          setVisible(false);
               new displayStudent();
      }else if (e.getSource() == btn5) {
          setVisible(false);
               new searchStudent();
      }else if (e.getSource() == btn6) {
             System.exit(0);
      }
    }

    public static void main(String[] args) {
        new dashboard();
    }
}
