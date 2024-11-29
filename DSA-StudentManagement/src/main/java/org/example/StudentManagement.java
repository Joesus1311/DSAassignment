package org.example;
import java.util.*;

public class StudentManagement {
    private StudentStack studentStack;

    // Constructor
    public StudentManagement() {
        studentStack = new StudentStack();
    }

    // Add a new student to the stack
    public void addStudent(Student student) {
        studentStack.push(student);
    }

    // Edit a student's marks based on ID
    public void editStudent(int id, double newMarks) {
        StudentStack tempStack = new StudentStack(); // Temporary stack
        boolean found = false;

        // Search for the student in the stack
        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId() == id) {
                student.setMarks(newMarks);
                found = true;
            }
            tempStack.push(student); // Move others to temporary stack
        }

        // Restore the original stack
        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        if (found) {
            System.out.println("Student updated.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Delete a student by ID
    public void deleteStudent(int id) {
        StudentStack tempStack = new StudentStack(); // Temporary stack
        boolean found = false;

        // Search for the student in the stack
        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId() == id) {
                found = true;
                System.out.println("Student deleted: " + student);
                continue; // Skip pushing this student back to the stack
            }
            tempStack.push(student); // Move others to temporary stack
        }

        // Restore the original stack
        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    // Search for a student by ID
    public Student searchStudentById(int id) {
        StudentStack tempStack = new StudentStack(); // Temporary stack
        Student foundStudent = null;

        // Search for the student in the stack
        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId() == id) {
                foundStudent = student;
                System.out.println("Found: " + student);
            }
            tempStack.push(student); // Temporarily store the student in a temporary stack
        }

        // Restore the original stack
        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        if (foundStudent == null) {
            System.out.println("No student found with ID: " + id);
        }

        return foundStudent;
    }



    // Display all students
    public void displayAllStudents() {
        studentStack.displayStudents(); // Use the display method from StudentStack
    }

    // Sort students by marks in ascending or descending order
    public void sortStudentsByMarks(int algorithmChoice, boolean ascending) {
        if (studentStack.isEmpty()) {
            System.out.println("No students to sort.");
            return;
        }

        // Transfer students from stack to array
        Student[] students = new Student[studentStack.size()];
        int i = 0;
        while (!studentStack.isEmpty()) {
            students[i++] = studentStack.pop();
        }

        // Sort based on the selected algorithm
        switch (algorithmChoice) {
            case 1: // Bubble Sort
                bubbleSort(students, ascending);
                break;
            case 2: // Quick Sort
                quickSort(students, 0, students.length - 1, ascending);
                break;
            case 3: // Merge Sort
                mergeSort(students, 0, students.length - 1, ascending);
                break;
            default:
                System.out.println("Invalid algorithm choice.");
                return;
        }

        // Push sorted students back to the stack
        for (int j = students.length - 1; j >= 0; j--) {
            studentStack.push(students[j]);
        }

        System.out.println("Students sorted successfully.");
    }


    public boolean hasStudents() {
        return !studentStack.isEmpty();
    }

    private void mergeSort(Student[] students, int left, int right, boolean ascending) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Recursively sort the halves
            mergeSort(students, left, mid, ascending);
            mergeSort(students, mid + 1, right, ascending);

            // Merge the sorted halves
            merge(students, left, mid, right, ascending);
        }
    }

    // Helper method to merge two sorted halves
    private void merge(Student[] students, int left, int mid, int right, boolean ascending) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary arrays
        Student[] leftArray = new Student[n1];
        Student[] rightArray = new Student[n2];

        // Copy data into temporary arrays
        System.arraycopy(students, left, leftArray, 0, n1);
        System.arraycopy(students, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0;
        int k = left;

        // Merge the temporary arrays back into students[]
        while (i < n1 && j < n2) {
            if ((ascending && leftArray[i].getMarks() <= rightArray[j].getMarks()) ||
                    (!ascending && leftArray[i].getMarks() >= rightArray[j].getMarks())) {
                students[k] = leftArray[i];
                i++;
            } else {
                students[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray[], if any
        while (i < n1) {
            students[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[], if any
        while (j < n2) {
            students[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private void bubbleSort(Student[] students, boolean ascending) {
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((ascending && students[j].getMarks() > students[j + 1].getMarks()) ||
                        (!ascending && students[j].getMarks() < students[j + 1].getMarks())) {
                    // Swap students[j] and students[j + 1]
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    private void quickSort(Student[] students, int low, int high, boolean ascending) {
        if (low < high) {
            int pi = partition(students, low, high, ascending); // Partition index
            quickSort(students, low, pi - 1, ascending);  // Sort left half
            quickSort(students, pi + 1, high, ascending); // Sort right half
        }
    }

    private int partition(Student[] students, int low, int high, boolean ascending) {
        Student pivot = students[high]; // Pivot element
        int i = low - 1; // Index of smaller element

        for (int j = low; j < high; j++) {
            if ((ascending && students[j].getMarks() <= pivot.getMarks()) ||
                    (!ascending && students[j].getMarks() >= pivot.getMarks())) {
                i++;
                // Swap students[i] and students[j]
                Student temp = students[i];
                students[i] = students[j];
                students[j] = temp;
            }
        }

        // Swap students[i + 1] and students[high] (pivot)
        Student temp = students[i + 1];
        students[i + 1] = students[high];
        students[high] = temp;

        return i + 1; // Return partition index
    }

}

