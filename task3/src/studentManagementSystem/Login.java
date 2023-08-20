package studentManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Login extends JFrame implements ActionListener {
    JButton btn,btn2;
    JTextField textField1;
    JPasswordField tfpassword;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Student Management System");
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);

        textField1 = new JTextField();
        textField1.setBounds(150, 20, 150, 30);
        add(textField1);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);

        btn = new JButton("Login");
        btn.setBounds(40, 140, 120, 30);
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        btn.addActionListener(this);
        btn.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(btn);

        btn2 = new JButton("Cancel");
        btn2.setBounds(180, 140, 120, 30);
        btn2.setBackground(Color.BLACK);
        btn2.setForeground(Color.WHITE);
        btn2.addActionListener(this);
        btn2.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(btn2);


        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         String username = textField1.getText();
         String password = tfpassword.getText();

         if(e.getSource()==btn){
             if(username.equals("admin") && password.equals("1234")){
                 JOptionPane.showMessageDialog(null,"login Successful");
                 setVisible(false);
                 new dashboard();
             }else{
                 JOptionPane.showMessageDialog(null,"Invalid Username or password.");
             }
         }else{
             textField1.setText("");
             tfpassword.setText("");
         }
    }
}
