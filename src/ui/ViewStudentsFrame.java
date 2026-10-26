package ui;

import model.Student;
import service.StudentService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewStudentsFrame extends JFrame {

    DefaultTableModel model;

    public ViewStudentsFrame() {

        setTitle("View Students");
        setSize(600, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        Font font = new Font("Arial", Font.PLAIN, 14);

        String[] cols = {"ID", "Name", "Dept", "Email", "Phone"};

        model = new DefaultTableModel(cols, 0);
        JTable table = new JTable(model);

        table.setFont(font);
        table.setRowHeight(25);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 50, 540, 250);
        add(sp);

        JButton refresh = new JButton("Refresh");
        refresh.setBounds(20, 320, 120, 30);
        add(refresh);

        refresh.addActionListener(e -> load());

        load();

        setVisible(true);
    }

    void load() {

        model.setRowCount(0);

        for (Student s : StudentService.getStudents()) {
            model.addRow(new Object[]{
                    s.getId(),
                    s.getName(),
                    s.getDepartment(),
                    s.getEmail(),
                    s.getPhone()
            });
        }
    }
}