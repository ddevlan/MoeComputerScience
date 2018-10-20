package me.ohvalsgod.cs.a05;

import me.ohvalsgod.cs.a05.student.Student;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    //here u go moe XD

    private static Set<Student> students;
    private static Scanner scan;

    public static void main(String[] args) {

        students = new HashSet<>();

        System.out.println("This is a program that averages student grades.");

        scan = new Scanner(System.in);

        callStudent();
    }

    private static void callStudent() {
        System.out.println(" ");
        System.out.println("Please enter a student name:");
        String name = scan.nextLine();

        if (name.isEmpty()) {
            System.out.println("Done collecting students... calculating averages..");

            double classAvg = 0;

            for (Student s : students) {
                if (getLowest(s.getGrades()) != Double.MAX_VALUE) {
                    s.removeGrade(getLowest(s.getGrades()));
                }

                for (Double d : s.getGrades()) {
                    classAvg = classAvg + d;
                }
            }
            System.out.println();
            System.out.println("The total class average grade is " + (classAvg/students.size()) + "%");
            return;
        }

        System.out.println("Please enter a student id:");
        String id = scan.nextLine();

        Student student = new Student(name, id);

        System.out.println("Please enter a student grades:");

        String rawGrades = scan.nextLine();
        Set<Double> grades = new HashSet<>();

        int i = 0;
        for (String string : rawGrades.split(" ")) {
            i++;
            if (!Double.valueOf(string).isNaN()) {
                if (Double.valueOf(string) < 100 && Double.valueOf(string) > 0) {
                    grades.add(Double.valueOf(string));
                } else {
                    System.out.println("Please enter a valid grade (must be a number between 0-100)!");
                }
            } else {
                System.out.println("Error: syntax error at argument " + i);
            }
        }
        grades.forEach(student::addGrade);

        double totalGrades = 0;
        for (Double d : student.getGrades()) {
            totalGrades = totalGrades + d;
        }

        System.out.println(" ");
        System.out.println("Total grade average for '" + student.getName() + "' is: " + Math.round(totalGrades/student.getGrades().size()) + "%");

        students.add(student);

        System.out.println(" ");
        System.out.println("Student '" + student.getName() + "' has been added with id '" + student.getUniqueId() + "'.");
        System.out.println(" ");

        callStudent();
    }

    private static double getLowest(Set<Double> ds) {
        double current = Double.MAX_VALUE;
        for (double d : ds) {
            if (d < current) {
                current = d;
            }
        }
        return current;
    }

}
