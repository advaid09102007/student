package ui;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {

        setTitle("Dashboard");
        setSize(500, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Font font = new Font("Arial", Font.PLAIN, 14);

        JLabel title = new JLabel("Smart Student Management System");
        title.setBounds(100, 30, 400, 30);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        add(title);

        JButton add = new JButton("Add Student");
        JButton view = new JButton("View Students");
        JButton search = new JButton("Search");
        JButton update = new JButton("Update");
        JButton delete = new JButton("Delete");
        JButton logout = new JButton("Logout");

        JButton[] buttons = {add, view, search, update, delete, logout};

        int y = 100;

        for (JButton b : buttons) {
            b.setBounds(150, y, 180, 35);
            b.setFont(font);
            b.setFocusPainted(false);
            add(b);
            y += 50;
        }

        add.addActionListener(e -> new AddStudentFrame());
        view.addActionListener(e -> new ViewStudentsFrame());
        search.addActionListener(e -> new SearchStudentFrame());
        update.addActionListener(e -> new UpdateStudentFrame());
        delete.addActionListener(e -> new DeleteStudentFrame());

        logout.addActionListener(e -> {
            dispose();
            new LoginScreen();
        });

        setVisible(true);
    }
}