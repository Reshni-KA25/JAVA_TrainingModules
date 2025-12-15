package com.demo1;

import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] marks = new int[5];

        System.out.println("Enter marks for 5 subjects (0 - 100):");

        for (int i = 0; i < 5; i++) {

            int m;
            do {
                System.out.print("Subject " + (i + 1) + ": ");
                m = sc.nextInt();

                if (m < 0 || m > 100) {
                    System.out.println("Invalid input Enter a value between 0 and 100.");
                }

            } while (m < 0 || m > 100);

            marks[i] = m; 
        }

        calculateGradeReport(marks);
    }

    public static void calculateGradeReport(int[] marks) {

        int total = 0;
        for (int m : marks) total += m;

        double avg = total / 5.0;
        double gpa = calculateGPA(avg);
        char grade = calculateGrade(avg);

        System.out.println("\n----- Student Grade Report -----");
        System.out.println("Total: " + total);
        System.out.println("Average: " + avg);
        System.out.println("GPA: " + gpa);
        System.out.println("Grade: " + grade);
        System.out.println("--------------------------------");
    }

    public static double calculateGPA(double avg) {
        if (avg >= 90) return 4.0;
        else if (avg >= 80) return 3.0;
        else if (avg >= 70) return 2.0;
        else if (avg >= 60) return 1.0;
        else return 0.0;
    }

    public static char calculateGrade(double avg) {
        if (avg >= 90) return 'A';
        else if (avg >= 80) return 'B';
        else if (avg >= 70) return 'C';
        else if (avg >= 60) return 'D';
        else return 'F';
    }
}
