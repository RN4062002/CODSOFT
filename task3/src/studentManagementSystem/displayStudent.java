package studentManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class displayStudent extends JFrame implements ActionListener {

    JTable table;

    JButton  cancel;

    displayStudent() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Student Details");
        heading.setBounds(350,10,150,30);
        heading.setFont(new Font("Arial",Font.BOLD,20));
        add(heading);
        table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 40, 900, 350);
        add(jsp);

        cancel = new JButton("Back");
        cancel.setBounds(350, 400, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 500);
        setLocation(300, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == cancel){
            setVisible(false);
            new dashboard();
        }

    }

    public static void main(String[] args) {
        new displayStudent();
    }
}
