package view;

import controller.GradeManager;
import controller.StudentManager;
import model.Grade;
import model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentClient {
    static List<Grade> gradeList = GradeManager.getGradeList();

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        StudentManager kieuanh = new StudentManager("Kieu Anh", studentList);
        Scanner input = new Scanner(System.in);
        int choice=-1;

        while(choice!= 0) {
            System.out.println("Menu");
            System.out.println("1. Create new Student");
            System.out.println("2. Show All Student");
            System.out.println("3. Edit Student");
            System.out.println("4. Delete Student");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    createNewStudent(kieuanh);
                    break;
                case 2:
                    //Hiển thị danh sách khối thi
                    showAllStudent(kieuanh);
                    break;
                case 3:
                    // Sửa khối thi
//                    editStudent(kieuanh);
                    break;
                case 4:
                    // Xóa khối thi
//                    deleteStudent(kieuanh);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }

    private static void showAllStudent(StudentManager kieuanh) {
        for (Student s: kieuanh.getStudents()
             ) {
            System.out.println(s);
        }
    }

    private static void createNewStudent(StudentManager kieuanh) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Moi ban nhap id");
        String id = scanner.nextLine();
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Moi ban nhap ten");
        String name = scanner2.nextLine();
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Moi ban nhap địa chỉ");
        String address = scanner3.nextLine();
        Student student = new Student(id, name, address);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Mời bạn nhập khối thi");
        String gradeName = scanner.nextLine();
        GradeManager gradeManager = new GradeManager();
        Grade grade = gradeManager.findByName(gradeName);
        if (grade != null) student.setGrade(grade);
        kieuanh.addNewStudent(student);
    }
}