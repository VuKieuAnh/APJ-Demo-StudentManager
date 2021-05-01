package view;

import controller.GradeManager;
import model.Grade;
import storage.GradeFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeClient {
    private static List<Grade> listGrade = new ArrayList<>();

    static {
        try {
            listGrade = GradeFile.getINSTANCE("Kieu Anh").readFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GradeManager kieuanh = new GradeManager();
        GradeManager.setGradeList(listGrade);

        Scanner input = new Scanner(System.in);
        int choice=-1;

        while(choice!= 0) {
            System.out.println("Menu");
            System.out.println("1. Create");
            System.out.println("2. Show All Grade");
            System.out.println("3. Edit Grade");
            System.out.println("4. Delete Grade");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    createNewGrade(kieuanh);
                    break;
                case 2:
                   //Hiển thị danh sách khối thi
                    showAllGrade(kieuanh);
                    break;
                case 3:
                    // Sửa khối thi
                    editGrade(kieuanh);
                    break;
                case 4:
                    // Xóa khối thi
                    deleteGrade(kieuanh);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }

    private static void deleteGrade(GradeManager gradeManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Moi ban nhap ten khoi thi");
        String name = scanner.nextLine();
        Grade grade = gradeManager.findByName(name);
        if (grade == null)
            System.out.println("Tên khối thi không tồn tại");
        else {
            gradeManager.deleteGrade(grade);
        }
    }

    private static void editGrade(GradeManager gradeManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Moi ban nhap ten khoi thi");
        String name = scanner.nextLine();
        Grade grade = gradeManager.findByName(name);
        if (grade == null)
            System.out.println("Tên khối thi không tồn tại");
        else {
            //sửa mô tả
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Mời bạn nhập mô tả mới");
            System.out.println("Mô tả cũ: " + grade.getDescription());
            String newDecription = scanner1.nextLine();
            grade.setDescription(newDecription);
            //sửa môn 1
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Mời bạn nhập môn 1");
            System.out.println("Mô tả cũ: " + grade.getSubject1());
            String newSubject1 = scanner2.nextLine();
            grade.setSubject1(newSubject1);
            //sửa môn 2
            Scanner scanner3 = new Scanner(System.in);
            System.out.println("Mời bạn nhập môn 2");
            System.out.println("Mô tả cũ: " + grade.getSubject2());
            String newSubject2 = scanner3.nextLine();
            grade.setSubject2(newSubject2);
            //sửa môn 3
            Scanner scanner4 = new Scanner(System.in);
            System.out.println("Mời bạn nhập môn 1");
            System.out.println("Mô tả cũ: " + grade.getSubject3());
            String newSubject3 = scanner4.nextLine();
            grade.setSubject3(newSubject3);
        }
    }

    private static void showAllGrade(GradeManager gradeManager) {
        System.out.println("Danh sách khối thi");
        for (Grade g:listGrade
             ) {
            System.out.println(g);
        }
    }

    private static void createNewGrade(GradeManager gradeManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Moi ban nhap id");
        String id = scanner.nextLine();
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Moi ban nhap ten khoi thi");
        String name = scanner2.nextLine();
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Moi ban nhap mo ta khoi thi");
        String description = scanner3.nextLine();
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Moi ban nhap mon thi 1");
        String subject1 = scanner4.nextLine();
        Scanner scanner5 = new Scanner(System.in);
        System.out.println("Moi ban nhap khoi mon thi 2");
        String subject2 = scanner5.nextLine();
        Scanner scanner6 = new Scanner(System.in);
        System.out.println("Moi ban nhap khoi mon thi 3");
        String subject3 = scanner6.nextLine();
        Grade grade = new Grade(id, name, description, subject1, subject2, subject3);
        gradeManager.addNewGrade(grade);
    }


}