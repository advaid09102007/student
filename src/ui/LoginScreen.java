package ui;

import javax.swing.*;
import java.awt.*;

public class LoginScreen extends JFrame {

    public LoginScreen() {

        setTitle("Login");
        setSize(350, 220);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Font font = new Font("Arial", Font.PLAIN, 14);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30, 30, 100, 25);
        userLabel.setFont(font);
        add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(120, 30, 150, 25);
        userField.setFont(font);
        add(userField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 70, 100, 25);
        passLabel.setFont(font);
        add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(120, 70, 150, 25);
        passField.setFont(font);
        add(passField);

        JButton login = new JButton("Login");
        login.setBounds(120, 120, 100, 30);
        login.setFont(font);
        login.setFocusPainted(false);
        add(login);

        login.addActionListener(e -> {

            if (userField.getText().equals("admin")
                    && new String(passField.getPassword()).equals("admin123")) {

                JOptionPane.showMessageDialog(this, "Login Successful");
                dispose();
                new DashboardFrame();

            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials");
            }
        });

        setVisible(true);
    }
}