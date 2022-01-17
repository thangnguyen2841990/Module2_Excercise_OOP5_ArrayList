package com.codegym;

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
        }    }
}
