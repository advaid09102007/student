package util;

import model.Student;

import java.io.*;
import java.util.ArrayList;

public class FileStorage {

    private static final String FILE_NAME = "students.txt";

    public static void saveToFile(ArrayList<Student> students) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Student s : students) {
                bw.write(s.getId() + "," + s.getName() + "," +
                        s.getDepartment() + "," + s.getEmail() + "," + s.getPhone());
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> loadFromFile() {

        ArrayList<Student> list = new ArrayList<>();

        File file = new File(FILE_NAME);
        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {

                String[] d = line.split(",");

                if (d.length == 5) {
                    list.add(new Student(
                            Integer.parseInt(d[0]),
                            d[1],
                            d[2],
                            d[3],
                            d[4]
                    ));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}