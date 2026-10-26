package ui;

import service.StudentService;

import javax.swing.*;
import java.awt.Font;

public class UpdateStudentFrame extends JFrame {

    public UpdateStudentFrame() {

        setTitle("Update Student");
        setSize(420, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Font font = new Font("Arial", Font.PLAIN, 14);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 30, 100, 25);
        idLabel.setFont(font);
        add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(170, 30, 180, 25);
        add(idField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 70, 100, 25);
        nameLabel.setFont(font);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(170, 70, 180, 25);
        add(nameField);

        JLabel deptLabel = new JLabel("Department:");
        deptLabel.setBounds(50, 110, 100, 25);
        deptLabel.setFont(font);
        add(deptLabel);

        JTextField deptField = new JTextField();
        deptField.setBounds(170, 110, 180, 25);
        add(deptField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 150, 100, 25);
        emailLabel.setFont(font);
        add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(170, 150, 180, 25);
        add(emailField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(50, 190, 100, 25);
        phoneLabel.setFont(font);
        add(phoneLabel);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(170, 190, 180, 25);
        add(phoneField);

        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(150, 250, 120, 30);
        updateBtn.setFont(font);
        updateBtn.setFocusPainted(false);
        add(updateBtn);

        updateBtn.addActionListener(e -> {

            try {
                int id = Integer.parseInt(idField.getText().trim());

                boolean updated = StudentService.updateStudent(
                        id,
                        nameField.getText().trim(),
                        deptField.getText().trim(),
                        emailField.getText().trim(),
                        phoneField.getText().trim()
                );

                if (updated) {
                    JOptionPane.showMessageDialog(this, "Updated Successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Student Not Found");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter valid ID");
            }
        });

        setVisible(true);
    }
}