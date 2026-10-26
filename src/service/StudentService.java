package service;

import model.Student;
import util.FileStorage;

import java.util.ArrayList;

public class StudentService {

    // ✔ LOAD DATA ON START
    private static ArrayList<Student> students = FileStorage.loadFromFile();

    // ✔ ADD STUDENT
    public static void addStudent(Student student) {
        students.add(student);
        FileStorage.saveToFile(students);
    }

    // ✔ GET ALL STUDENTS
    public static ArrayList<Student> getStudents() {
        return students;
    }

    // ✔ SEARCH STUDENT
    public static Student searchStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    // ⭐ FIXED: CHECK IF STUDENT EXISTS (YOU WERE MISSING THIS)
    public static boolean exists(int id) {
        return searchStudent(id) != null;
    }

    // ✔ DELETE STUDENT
    public static boolean deleteStudent(int id) {

        Student s = searchStudent(id);

        if (s != null) {
            students.remove(s);
            FileStorage.saveToFile(students);
            return true;
        }

        return false;
    }

    // ✔ UPDATE STUDENT (FULL DATA UPDATE)
    public static boolean updateStudent(int id,
                                        String name,
                                        String department,
                                        String email,
                                        String phone) {

        Student s = searchStudent(id);

        if (s != null) {

            s.setName(name);
            s.setDepartment(department);
            s.setEmail(email);
            s.setPhone(phone);

            FileStorage.saveToFile(students);
            return true;
        }

        return false;
    }
}