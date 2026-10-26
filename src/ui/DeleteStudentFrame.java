package ui;

import service.StudentService;

import javax.swing.*;
import java.awt.Font;

public class DeleteStudentFrame extends JFrame {

    public DeleteStudentFrame() {

        setTitle("Delete Student");
        setSize(350, 200);
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
        add(idField);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(120, 90, 100, 30);
        deleteBtn.setFont(font);
        deleteBtn.setFocusPainted(false);
        add(deleteBtn);

        deleteBtn.addActionListener(e -> {

            try {
                int id = Integer.parseInt(idField.getText().trim());

                boolean deleted = StudentService.deleteStudent(id);

                if (deleted) {
                    JOptionPane.showMessageDialog(this, "Deleted Successfully");
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