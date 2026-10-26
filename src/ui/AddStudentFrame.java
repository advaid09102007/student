package ui;

import model.Student;
import service.StudentService;

import javax.swing.*;
import java.awt.*;

public class AddStudentFrame extends JFrame {

    public AddStudentFrame() {

        setTitle("Add Student");
        setSize(400, 420);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        Font font = new Font("Arial", Font.PLAIN, 14);

        JTextField id = new JTextField();
        JTextField name = new JTextField();
        JTextField dept = new JTextField();
        JTextField email = new JTextField();
        JTextField phone = new JTextField();

        JLabel[] labels = {
                new JLabel("ID:"),
                new JLabel("Name:"),
                new JLabel("Department:"),
                new JLabel("Email:"),
                new JLabel("Phone:")
        };

        JTextField[] fields = {id, name, dept, email, phone};

        int y = 30;

        for (int i = 0; i < labels.length; i++) {
            labels[i].setBounds(50, y, 100, 25);
            labels[i].setFont(font);
            fields[i].setBounds(150, y, 180, 25);
            add(labels[i]);
            add(fields[i]);
            y += 50;
        }

        JButton save = new JButton("Save");
        save.setBounds(130, 300, 120, 30);
        save.setFont(font);
        save.setFocusPainted(false);
        add(save);

        save.addActionListener(e -> {

            try {
                int sid = Integer.parseInt(id.getText().trim());

                if (StudentService.exists(sid)) {
                    JOptionPane.showMessageDialog(this, "ID already exists!");
                    return;
                }

                Student s = new Student(
                        sid,
                        name.getText(),
                        dept.getText(),
                        email.getText(),
                        phone.getText()
                );

                StudentService.addStudent(s);

                JOptionPane.showMessageDialog(this, "Student Added Successfully");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid Input");
            }
        });

        setVisible(true);
    }
}