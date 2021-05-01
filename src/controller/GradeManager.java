package controller;

import model.Grade;
import storage.GradeFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GradeManager {
    GradeFile gradeFile = GradeFile.getINSTANCE("Kieu Anh");
    private String name;
    private static List<Grade> gradeList = new ArrayList<>();

    public void addNewGrade(Grade grade){
        gradeList.add(grade);
        try {
            gradeFile.writeFile(gradeList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Grade findByName(String name){
        Grade grade = null;
        for (Grade g: gradeList
             ) {
            if (g.getName().equals(name))
                grade = g;
        }
        return grade;
    }

    public void deleteGrade(Grade grade){
        gradeList.remove(grade);
        try {
            gradeFile.writeFile(gradeList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GradeManager() {
    }

    public GradeManager(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Grade> getGradeList() {

        GradeFile gradeFile = GradeFile.getINSTANCE("Kieu Anh");
        try {
            gradeList = gradeFile.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return gradeList;
    }

    public static void setGradeList(List<Grade> gradeList) {
        GradeManager.gradeList = gradeList;
    }
}