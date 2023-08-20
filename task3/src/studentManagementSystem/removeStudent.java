package studentManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class removeStudent extends JFrame implements ActionListener {

    Choice crollno;
    JTable table;

    JButton search, delete, cancel;

    removeStudent() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        crollno = new Choice();
        crollno.setBounds(180, 20, 150, 20);
        add(crollno);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

        delete = new JButton("Delete");
        delete.setBounds(20,70,80,20);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        cancel = new JButton("Cancel");
        cancel.setBounds(120, 70, 80, 20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setSize(800, 600);
        setLocation(300, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delete){
            try {
                String rollno = crollno.getSelectedItem();

                Conn con = new Conn();
                int rowsAffected = con.s.executeUpdate("delete from student where rollno='" + rollno + "'");

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Student Record Deleted Successfully");
                    setVisible(false);
                    new dashboard();
                } else {
                    JOptionPane.showMessageDialog(null, "Error deleting student record");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }else{
            setVisible(false);
            new dashboard();
        }
    }

    public static void main(String[] args) {
        new removeStudent();
    }
}
