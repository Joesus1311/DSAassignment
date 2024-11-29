package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student Marks");
            System.out.println("3. Delete Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Sort Students by Marks");
            System.out.println("6. Search Student by ID");

            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add Student
                    System.out.print("Enter ID: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input! Please enter a valid number for ID.");
                        scanner.next(); // Clear invalid input
                    }
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    double marks;
                    do {
                        System.out.print("Enter Marks (0 to 10): ");
                        while (!scanner.hasNextDouble()) {
                            System.out.println("Invalid input! Please enter a valid number for marks.");
                            scanner.next(); // Clear invalid input
                        }
                        marks = scanner.nextDouble();
                        if (marks < 0 || marks > 10) {
                            System.out.println("Marks must be between 0 and 10.");
                        }
                    } while (marks < 0 || marks > 10);

                    studentManagement.addStudent(new Student(id, name, marks));
                    System.out.println("Student added.");
                    break;


                case 2: // Edit Student
                    System.out.print("Enter ID of the student to edit: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input! Please enter a valid number for ID.");
                        scanner.next(); // Clear invalid input
                    }
                    int editId = scanner.nextInt();

                    double newMarks;
                    do {
                        System.out.print("Enter new marks (0 to 10): ");
                        while (!scanner.hasNextDouble()) {
                            System.out.println("Invalid input! Please enter a valid number for marks.");
                            scanner.next(); // Clear invalid input
                        }
                        newMarks = scanner.nextDouble();
                        if (newMarks < 0 || newMarks > 10) {
                            System.out.println("Marks must be between 0 and 10.");
                        }
                    } while (newMarks < 0 || newMarks > 10);

                    studentManagement.editStudent(editId, newMarks);
                    break;


                case 3: // Delete Student
                    System.out.print("Enter ID of the student to delete: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input! Please enter a valid number for ID.");
                        scanner.next(); // Clear invalid input
                    }
                    int deleteId = scanner.nextInt();
                    studentManagement.deleteStudent(deleteId);
                    break;


                case 4: // Display All Students
                    if (!studentManagement.hasStudents()) {
                        System.out.println("No students to display.");
                    } else {
                        System.out.println("List of Students:");
                        studentManagement.displayAllStudents();
                    }
                    break;

                case 5: // Sort Students by Marks
                    if (!studentManagement.hasStudents()) {
                        System.out.println("No students to sort.");
                        break;
                    }

                    int algorithmChoice = 0;
                    while (algorithmChoice < 1 || algorithmChoice > 3) {
                        System.out.println("Choose a sorting algorithm:");
                        System.out.println("1. Bubble Sort");
                        System.out.println("2. Quick Sort");
                        System.out.println("3. Merge Sort");
                        System.out.print("Enter your choice: ");
                        if (scanner.hasNextInt()) {
                            algorithmChoice = scanner.nextInt();
                            if (algorithmChoice < 1 || algorithmChoice > 3) {
                                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                            }
                        } else {
                            System.out.println("Invalid input! Please enter a number.");
                            scanner.next(); // Clear invalid input
                        }
                    }

                    int sortOrderChoice = 0;
                    boolean ascending = false;
                    while (sortOrderChoice != 1 && sortOrderChoice != 2) {
                        System.out.println("1. Sort by Ascending Order");
                        System.out.println("2. Sort by Descending Order");
                        System.out.print("Enter your choice: ");
                        if (scanner.hasNextInt()) {
                            sortOrderChoice = scanner.nextInt();
                            ascending = (sortOrderChoice == 1);
                        } else {
                            System.out.println("Invalid input! Please enter 1 or 2.");
                            scanner.next(); // Clear invalid input
                        }
                    }

                    // Call the appropriate sorting method based on user input
                    studentManagement.sortStudentsByMarks(algorithmChoice, ascending);

                    System.out.println("Students after sorting:");
                    studentManagement.displayAllStudents(); // Display the sorted students
                    break;



                case 6: // Search Student by ID
                    if (!studentManagement.hasStudents()) {
                        System.out.println("No students to search.");
                        break;
                    }
                    System.out.print("Enter the ID of the student to search: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input! Please enter a valid number for ID.");
                        scanner.next(); // Clear invalid input
                    }
                    int searchId = scanner.nextInt();
                    Student foundStudent = studentManagement.searchStudentById(searchId);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;



                case 7: // Exit
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}