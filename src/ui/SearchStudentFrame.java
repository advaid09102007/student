package ui;

import model.Student;
import service.StudentService;

import javax.swing.*;
import java.awt.Font;

public class SearchStudentFrame extends JFrame {

    public SearchStudentFrame() {

        setTitle("Search Student");
        setSize(350, 220);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Font font = new Font("Arial", Font.PLAIN, 14);

        JLabel label = new JLabel("Enter ID:");
        label.setBounds(50, 40, 100, 25);
        label.setFont(font);
        add(label);

        JTextField idField = new JTextField();
        idField.setBounds(140, 40, 150, 25);
        idField.setFont(font);
        add(idField);

        JButton searchBtn = new JButton("Search");
        searchBtn.setBounds(120, 90, 100, 30);
        searchBtn.setFont(font);
        searchBtn.setFocusPainted(false);
        add(searchBtn);

        searchBtn.addActionListener(e -> {

            try {
                int id = Integer.parseInt(idField.getText().trim());

                Student s = StudentService.searchStudent(id);

                if (s != null) {
                    JOptionPane.showMessageDialog(this,
                            "ID: " + s.getId() +
                                    "\nName: " + s.getName() +
                                    "\nDept: " + s.getDepartment() +
                                    "\nEmail: " + s.getEmail() +
                                    "\nPhone: " + s.getPhone()
                    );
                } else {
                    JOptionPane.showMessageDialog(this, "Student Not Found");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter valid numeric ID");
            }
        });

        setVisible(true);
    }
}