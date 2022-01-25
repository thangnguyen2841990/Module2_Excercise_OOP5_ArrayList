package com.codegym;

import java.io.*;
import java.util.ArrayList;

public class TeacherManagement {
    private ArrayList<Salary> teachers;

    public TeacherManagement() {
        this.teachers = new ArrayList<>();
    }

    public TeacherManagement(ArrayList<Salary> teachers) {
        this.teachers = teachers;
    }

    public ArrayList<Salary> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Salary> teachers) {
        this.teachers = teachers;
    }
    public void addNewTeacher(Salary newTeacher){
        teachers.add(newTeacher);
    }
    public void displayAllTeachers(){
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println((i+1)+". "+teachers.get(i));
        }
    }
    public void teacherSalary8M(){
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getTotalSalary() >= 8000000){
                System.out.println(teachers.get(i));
            }
        }
    }
    public void writerTofiles(String path) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Salary teacher: teachers) {
            bufferedWriter.write(teacher.toString()+"\n");
        }
        bufferedWriter.close();
        fileWriter.close();
    }
    public void readFiles(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null){
            String [] lines = line.split(",");
            String name = lines[0].trim();
            String birthDay = lines[1].trim();
            String homeTown = lines[2].trim();
            Teacher teacher = new Teacher(name,birthDay,homeTown);
            double basicSalary = Double.parseDouble(lines[3].trim());
            double bonus = Double.parseDouble(lines[4].trim());
            double fine = Double.parseDouble(lines[5].trim());
            Salary teacherSalary = new Salary(basicSalary,bonus,fine,teacher);
            this.teachers.add(teacherSalary);
        }
        bufferedReader.close();
        fileReader.close();
    }
}
