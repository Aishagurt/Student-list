package com.example.demo.db;

import com.example.demo.entity.Student;

import java.util.ArrayList;

public class DBManager {
    private static final ArrayList<Student> students = new ArrayList<>();
    static{
        students.add(new Student(1L, "Aisha", "Bolatova", 100, "A"));
        students.add(new Student(2L, "Miras", "ERMKE", 60, "C"));
        students.add(new Student(3L, "Albert", "EQWOOO", 50, "F"));

    }
    private static Long id = 4L;
    public static ArrayList<Student> getStudents(){
        return students;
    }
    public static void addStudent(Student stud){
        stud.setId(id);
        id++;
        if (stud.getExam() >= 90)
            stud.setGrade("A");
        else if (stud.getExam() >= 80)
            stud.setGrade("B");
        else if (stud.getExam() >= 70)
            stud.setGrade("C");
        else if (stud.getExam() >= 60)
            stud.setGrade("D");
        else
            stud.setGrade("F");
        students.add(stud);
    }
}
