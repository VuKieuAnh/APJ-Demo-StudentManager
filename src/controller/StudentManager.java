package controller;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private String name;
    private List<Student> students = new ArrayList<>();

    public StudentManager() {
    }

    public StudentManager(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }


    public void addNewStudent(Student student){
        students.add(student);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}