package com.codegym;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1;
        TeacherManagement teacherManagement = new TeacherManagement();
        menu();
        do {
            System.out.println("Enter Menu: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    teacherManagement.displayAllTeachers();
                    break;
                }
                case 2: {
                    System.out.println("----Thêm giáo viên----");
                    System.out.println("Nhập số lượng giáo viên muốn nhâp: ");
                    int n = scanner.nextInt();
                    Salary newTeacher;
                    for (int i = 0; i < n; i++) {
                        System.out.println("Giáo viên thứ: "+ (i+1));
                        newTeacher = inputTeacherInfo();
                        teacherManagement.addNewTeacher(newTeacher);
                        System.out.println("Thêm giáo viên thành công!");
                    }
                    break;
                }
                case 3: {
                    System.out.println("---Hiển thị thông tin giáo viên lương >= 8 triệu----");
                    teacherManagement.teacherSalary8M();
                    break;
                }
            }
        } while (choice != 4);
    }

    public static void menu() {
        System.out.println("----MENU QUẢN LÝ GIÁO VIÊN----");
        System.out.println("1. Hiển thị toàn bộ danh sách giáo viên");
        System.out.println("2. Thêm giáo viên");
        System.out.println("3. Hiển thị giáo viên lương > 8 triệu");
        System.out.println("4. Thoát");
    }

    public static Salary inputTeacherInfo() {
        scanner.nextLine();
        System.out.println("Họ và tên: ");
        String name = scanner.nextLine();
        System.out.println("Sinh nhật: ");
        String birthDay = scanner.nextLine();
        System.out.println("Quê quán: ");
        String hometown = scanner.nextLine();
        System.out.println("Nhập lương cơ bản: ");
        double basicSalary = scanner.nextDouble();
        System.out.println("Thưởng: ");
        double bonus = scanner.nextDouble();
        System.out.println("Phạt: ");
        double fine = scanner.nextDouble();
        return new Salary(basicSalary, bonus, fine, new Teacher(name, birthDay, hometown));
    }
}
