package storage;

import model.Grade;
import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GradeFile {
    private String name;
    private static GradeFile INSTANCE;

    private GradeFile(String name) {
        this.name = name;
        System.out.println(name);
    }

    public static GradeFile getINSTANCE(String name){
        if (INSTANCE == null)
            INSTANCE = new GradeFile(name);
        return INSTANCE;
    }

    public List<Grade> readFile() throws IOException, ClassNotFoundException {
        File file = new File("listGrade.dat");
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length() >0){
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            List<Grade> list = (List<Grade>) object;
            objectInputStream.close();
            fileInputStream.close();
            return list;
        }
        else return new ArrayList<>();
    }
    public void writeFile(List<Grade> gradeList) throws IOException{
        File file = new File("listGrade.dat");
        if (!file.exists()){
            file.createNewFile();
        }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(gradeList);
            objectOutputStream.close();
            fileOutputStream.close();
    }
}