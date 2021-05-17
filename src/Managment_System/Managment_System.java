
package Managment_System;

import java.util.Scanner;

public class Managment_System {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String UserChoice;
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("\tWelcome to the grading and Absence Managment System for students ");
        System.out.println("---------------------------------------------------------------------------------");
        int increment = 1;
        // Print out the instuctions to the user and what to enter if they want a specific operation.
        do {

            System.out.println("Enter \"Grades\" for Adding grades of students \nEnter\"Absences\" for Adding Number of Absences "
                    + "for students \nEnter \"Exit\" for exiting from the System ");
            System.out.print("\tPlease enter your choice: ");
            UserChoice = scan.nextLine();
            System.out.println("");
            if (UserChoice.equalsIgnoreCase("grades") || UserChoice.equalsIgnoreCase("absences")
                    || UserChoice.equalsIgnoreCase("exit")) {
                switch (UserChoice.toLowerCase()) {
                    // If the user entered grades.
                    case "grades":
                        int number_of_students = 0;
                        addStudentsGrades(number_of_students);
                        increment++;
                        break;
                    // If the user entered absences.
                    case "absences": {
                        int NumberOfStudents = 0;
                        addStudentsAbsence(NumberOfStudents);
                        increment++;
                    }
                    break;
                    // If the user entered exit.
                    case "exit":
                        System.out.println("Thanks for using this System");
                        increment++;
                        break;
                    /*default:
                     System.out.println("Wronge selction!, Please try again.");
                     System.out.println("");*/
                }
            } else if (!UserChoice.equalsIgnoreCase("grades")
                    || !UserChoice.equalsIgnoreCase("absences")
                    || !UserChoice.equalsIgnoreCase("exit")) {
                System.out.println("Wronge selction!, Please try again.");
                System.out.println("");
            }
        } while (increment == 1);
    }

    public static void addStudentsGrades(int number_of_students) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\t\t**Grades of Students**");
        // Asking the user to input the course name and number of students.
        System.out.print("Please enter the name of your course(ex: MATH-110): ");
        String course = scan.nextLine();
        System.out.print("Please enter the No. of students in " + course.toUpperCase() + ": ");
        number_of_students = scan.nextInt();
        double first_exam, second_exam, final_exam;
        // Using for to rebeat the statments based on the number of students entered.
        for (int i = 1; i <= number_of_students; i++) {
            System.out.println("Student " + i);
            // Asking the user the enter the ID.
            System.out.print("Enter Students ID: ");
            int student_id = scan.nextInt();
            System.out.println("Enter Student Scores: ");
            // Using Do-While to repeat the statments if the user entered an invalid opition.
            do {
                System.out.print("Enter the score of the first exam: ");
                first_exam = scan.nextDouble();
                if (first_exam < 0 || first_exam > 30) {
                    System.out.println("");
                    System.out.println("Invalid input! ( must be between 0 and 30)");
                    System.out.println("Please try again.");
                    System.out.println("");
                }
            } while (first_exam < 0 || first_exam > 30);
            // Using Do-While to repeat the statments if the user entered an invalid opition.
            do {
                System.out.print("Enter the score of the second exam: ");
                second_exam = scan.nextDouble();
                if (second_exam < 0 || second_exam > 30) {
                    System.out.println("");
                    System.out.println("Invalid input! ( must be between 0 and 30)");
                    System.out.println("Please try again.");
                    System.out.println("");
                }
            } while (second_exam < 0 || second_exam > 30);
            // Using Do-While to repeat the statments if the user entered an invalid opition.
            do {
                System.out.print("Enter the score of the final exam: ");
                final_exam = scan.nextDouble();
                if (final_exam < 0 || final_exam > 40) {
                    System.out.println("");
                    System.out.println("Invalid input! ( must be between 0 and 40)");
                    System.out.println("Please try again.");
                    System.out.println("");
                }
            } while (final_exam < 0 || final_exam > 40);
            // Print the results.
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("Student ID " + student_id);
            double final_score = first_exam + second_exam + final_exam;
            System.out.println("Final Score: " + final_score + " Grade: "
                    + getSymbolGrade(final_score) + ", has been added to the system.");
            System.out.println("---------------------------------------------------------------------------------");
        }
    }
    // Compare students' final score to give them a sympol that mtches their grade.

    public static char getSymbolGrade(double score) {
        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void addStudentsAbsence(int NumberOfStudents) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\t\t **Number of Absences for Students** ");
        // Asking the user to input the course name and number of students.
        System.out.print("Please enter the name of your course (ex: MATH-110): ");
        String course = scan.nextLine();
        System.out.print("Please enter the No. of students in " + course + ": ");
        NumberOfStudents = scan.nextInt();
        int i, NumberOfAbsences;
        // Using for to rebeat the statments based on the number of students entered.
        for (i = 1; NumberOfStudents >= i; i++) {
            System.out.println("Student " + i);
            // Asking the user the enter the ID.
            System.out.print("Enter Student ID: ");
            int ID = scan.nextInt();
            // Using Do-While to repeat the statments if the user entered an invalid opition.
            do {
                System.out.print("Enter No. of Absences: ");
                NumberOfAbsences = scan.nextInt();
                if (NumberOfAbsences <= 0) {
                    System.out.println("");
                    System.out.println("Invalid input! (must be >= 0) \nPlease try again");
                    System.out.println("");
                }
            } while (NumberOfAbsences <= 0);
            // Print the results.
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("Student ID:" + ID + "\n" + "No. of absences: "
                    + NumberOfAbsences + " " + getWarningMessage(NumberOfAbsences) + ", has been added to the system.");
            System.out.println("---------------------------------------------------------------------------------");
        }
    }
    // Compare students' absence number to give them a matching message for their status .

    public static String getWarningMessage(int NumberOfAbsences) {
        if (NumberOfAbsences < 8) {
            return "(without warning)";
        } else if (NumberOfAbsences == 8) {
            return "(first warning)";
        } else {
            return "(second warning)";
        }
    }
}
