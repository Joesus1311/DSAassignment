//package Studentmanagement;
//
//import java.util.Scanner;
////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
//    public static void main(String[] args) {
//        StudentManagement studentManagement = new StudentManagement();
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("\nStudent Management System");
//            System.out.println("1. Add Student");
//            System.out.println("2. Edit Student Marks");
//            System.out.println("3. Delete Student");
//            System.out.println("4. Display All Students");
//            System.out.println("5. Sort Students by Marks");
//            System.out.println("6. Search Student by ID");
//
//            System.out.println("7. Exit");
//            System.out.print("Enter your choice: ");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (choice) {
//                case 1:
//                    System.out.print("Enter ID: ");
//                    while (!scanner.hasNextInt()) {
//                        System.out.println("Invalid input! Please enter a valid number for ID.");
//                        scanner.next();
//                    }
//                    int id = scanner.nextInt();
//                    scanner.nextLine();
//
//                    System.out.print("Enter Name: ");
//                    String name = scanner.nextLine();
//
//                    double marks;
//                    do {
//                        System.out.print("Enter Marks (0 to 10): ");
//                        while (!scanner.hasNextDouble()) {
//                            System.out.println("Invalid input! Please enter a valid number for marks.");
//                            scanner.next();
//                        }
//                        marks = scanner.nextDouble();
//                        if (marks < 0 || marks > 10) {
//                            System.out.println("Marks must be between 0 and 10.");
//                        }
//                    } while (marks < 0 || marks > 10);
//
//                    studentManagement.addStudent(new Student(id, name, marks));
//                    System.out.println("Student added.");
//                    break;
//
//
//                case 2: // Edit Student
//                    System.out.print("Enter ID of the student to edit: ");
//                    while (!scanner.hasNextInt()) {
//                        System.out.println("Invalid input! Please enter a valid number for ID.");
//                        scanner.next();
//                    }
//                    int editId = scanner.nextInt();
//
//                    double newMarks;
//                    do {
//                        System.out.print("Enter new marks (0 to 10): ");
//                        while (!scanner.hasNextDouble()) {
//                            System.out.println("Invalid input! Please enter a valid number for marks.");
//                            scanner.next();
//                        }
//                        newMarks = scanner.nextDouble();
//                        if (newMarks < 0 || newMarks > 10) {
//                            System.out.println("Marks must be between 0 and 10.");
//                        }
//                    } while (newMarks < 0 || newMarks > 10);
//
//                    studentManagement.editStudent(editId, newMarks);
//                    break;
//
//
//                case 3: // Delete Student
//                    System.out.print("Enter ID of the student to delete: ");
//                    while (!scanner.hasNextInt()) {
//                        System.out.println("Invalid input! Please enter a valid number for ID.");
//                        scanner.next();
//                    }
//                    int deleteId = scanner.nextInt();
//                    studentManagement.deleteStudent(deleteId);
//                    break;
//
//
//                case 4: // Display All Students
//                    if (!studentManagement.hasStudents()) {
//                        System.out.println("No students to display.");
//                    } else {
//                        System.out.println("List of Students:");
//                        studentManagement.displayAllStudents();
//                    }
//                    break;
//
//                case 5: // Sort Students by Marks
//                    if (!studentManagement.hasStudents()) {
//                        System.out.println("No students to sort.");
//                        break;
//                    }
//
//                    int algorithmChoice = 0;
//                    while (algorithmChoice < 1 || algorithmChoice > 3) {
//                        System.out.println("Choose a sorting algorithm:");
//                        System.out.println("1. Bubble Sort");
//                        System.out.println("2. Quick Sort");
//                        System.out.println("3. Merge Sort");
//                        System.out.print("Enter your choice: ");
//                        if (scanner.hasNextInt()) {
//                            algorithmChoice = scanner.nextInt();
//                            if (algorithmChoice < 1 || algorithmChoice > 3) {
//                                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
//                            }
//                        } else {
//                            System.out.println("Invalid input! Please enter a number.");
//                            scanner.next(); // Clear invalid input
//                        }
//                    }
//
//                    int sortOrderChoice = 0;
//                    boolean ascending = false;
//                    while (sortOrderChoice != 1 && sortOrderChoice != 2) {
//                        System.out.println("1. Sort by Ascending Order");
//                        System.out.println("2. Sort by Descending Order");
//                        System.out.print("Enter your choice: ");
//                        if (scanner.hasNextInt()) {
//                            sortOrderChoice = scanner.nextInt();
//                            ascending = (sortOrderChoice == 1);
//                        } else {
//                            System.out.println("Invalid input! Please enter 1 or 2.");
//                            scanner.next();
//                        }
//                    }
//
//
//                    studentManagement.sortStudentsByMarks(algorithmChoice, ascending);
//
//                    System.out.println("Students after sorting:");
//                    studentManagement.displayAllStudents();
//                    break;
//
//
//
//                case 6:
//                    if (!studentManagement.hasStudents()) {
//                        System.out.println("No students to search.");
//                        break;
//                    }
//                    System.out.print("Enter the ID of the student to search: ");
//                    while (!scanner.hasNextInt()) {
//                        System.out.println("Invalid input! Please enter a valid number for ID.");
//                        scanner.next();
//                    }
//                    int searchId = scanner.nextInt();
//                    Student foundStudent = studentManagement.searchStudentById(searchId);
//                    if (foundStudent != null) {
//                        System.out.println("Student found: " + foundStudent);
//                    } else {
//                        System.out.println("Student not found.");
//                    }
//                    break;
//
//
//
//                case 7:
//                    System.out.println("Exiting the program...");
//                    scanner.close();
//                    return;
//
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
//}

package Studentmanagement;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Ask for initial number of students
        int numStudents;
        while (true) {
            System.out.print("Enter the number of students: ");
            if (scanner.hasNextInt()) {
                numStudents = scanner.nextInt();
                if (numStudents > 0) {
                    break;
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } else {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        }

        // Generate students automatically
        for (int i = 1; i <= numStudents; i++) {
            // Generate a random ID between 1000 and 9999
            int id = 1 + random.nextInt(30);

            // Create default name with index
            String name = "Nguyen Van B" + i;

            // Generate random marks between 0 and 10
            double marks = random.nextDouble() * 10;

            // Round marks to one decimal place
            marks = Math.round(marks * 10.0) / 10.0;

            studentManagement.addStudent(new Student(id, name, marks));
        }

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
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input! Please enter a valid number for ID.");
                        scanner.next();
                    }
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    double marks;
                    do {
                        System.out.print("Enter Marks (0 to 10): ");
                        while (!scanner.hasNextDouble()) {
                            System.out.println("Invalid input! Please enter a valid number for marks.");
                            scanner.next();
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
                        scanner.next();
                    }
                    int editId = scanner.nextInt();

                    double newMarks;
                    do {
                        System.out.print("Enter new marks (0 to 10): ");
                        while (!scanner.hasNextDouble()) {
                            System.out.println("Invalid input! Please enter a valid number for marks.");
                            scanner.next();
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
                        scanner.next();
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
                            scanner.next();
                        }
                    }

                    studentManagement.sortStudentsByMarks(algorithmChoice, ascending);

                    System.out.println("Students after sorting:");
                    studentManagement.displayAllStudents();

                    break;

                case 6:
                    if (!studentManagement.hasStudents()) {
                        System.out.println("No students to search.");
                        break;
                    }
                    System.out.print("Enter the ID of the student to search: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input! Please enter a valid number for ID.");
                        scanner.next();
                    }
                    int searchId = scanner.nextInt();
                    Student foundStudent = studentManagement.searchStudentById(searchId);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 7:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}