package Studentmanagement;
import java.util.*;

public class StudentManagement {

    private StudentStack studentStack;


    public StudentManagement() {
        studentStack = new StudentStack();
    }


    public void addStudent(Student student) {
        studentStack.push(student);
    }

    Runtime runtime = Runtime.getRuntime();

    // Edit a student's marks based on ID
    public void editStudent(int id, double newMarks) {
        StudentStack tempStack = new StudentStack();
        boolean found = false;


        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId() == id) {
                student.setMarks(newMarks);
                found = true;
            }
            tempStack.push(student);
        }


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
        StudentStack tempStack = new StudentStack();
        boolean found = false;

        // Search for the student in the stack
        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId() == id) {
                found = true;
                System.out.println("Student deleted: " + student);
                continue;
            }
            tempStack.push(student);
        }


        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }


    public Student searchStudentById(int id) {
        StudentStack tempStack = new StudentStack();
        Student foundStudent = null;


        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId() == id) {
                foundStudent = student;
                System.out.println("Found: " + student);
            }
            tempStack.push(student);
        }


        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        if (foundStudent == null) {
            System.out.println("No student found with ID: " + id);
        }

        return foundStudent;
    }




    public void displayAllStudents() {
        studentStack.displayStudents();
    }


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


        switch (algorithmChoice) {
            case 1: // Bubble Sort
                bubbleSort(students, ascending);
                break;
            case 2: // Quick Sort
                quickSort(students, 0, students.length - 1, ascending, true);
                break;
            case 3: // Merge Sort
                mergeSort(students, 0, students.length - 1, ascending);
                break;
            default:
                System.out.println("Invalid algorithm choice.");
                return;
        }


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
            merge(students, left, mid, right, ascending, left == 0 && right == students.length - 1);
        }
    }

    private void merge(Student[] students, int left, int mid, int right, boolean ascending, boolean isTopLevel) {
        // Record memory usage before merge
        runtime.gc();
        long beforeMerge = runtime.totalMemory() - runtime.freeMemory();
        long start = System.nanoTime();

        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        Student[] leftArray = new Student[n1];
        Student[] rightArray = new Student[n2];

        // Copy data to temp arrays
        System.arraycopy(students, left, leftArray, 0, n1);
        System.arraycopy(students, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0;
        int k = left;

        // Merging the arrays
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

        // Copy remaining elements of leftArray
        while (i < n1) {
            students[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray
        while (j < n2) {
            students[k] = rightArray[j];
            j++;
            k++;
        }

        long end = System.nanoTime();
        long afterMerge = runtime.totalMemory() - runtime.freeMemory();

        // Print space and time metrics only for the top-level merge
        if (isTopLevel) {
            System.out.println("Space Merge (bytes): " + (afterMerge - beforeMerge));
            System.out.println("Time Merge (nanoseconds): " + (end - start));
        }
    }


    private void bubbleSort(Student[] students, boolean ascending) {
        runtime.gc();
        long beforeMerge = runtime.totalMemory() - runtime.freeMemory();
        long start = System.nanoTime();
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((ascending && students[j].getMarks() > students[j + 1].getMarks()) ||
                        (!ascending && students[j].getMarks() < students[j + 1].getMarks())) {

                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        long afterMerge = runtime.totalMemory() - runtime.freeMemory();
        long end = System.nanoTime();
        System.out.println("Space Bubble: " +(afterMerge - beforeMerge) );
        System.out.println("Time Bubble:" +(end-start));
    }

    private void quickSort(Student[] students, int low, int high, boolean ascending, boolean isTopLevel) {
        long beforeMerge = 0, start = 0;
        if (isTopLevel) {
            runtime.gc(); // Suggest garbage collection for consistent measurements
            beforeMerge = runtime.totalMemory() - runtime.freeMemory();
            start = System.nanoTime();
        }

        if (low < high) {
            int pi = partition(students, low, high, ascending);

            // Recursive calls for left and right subarrays
            quickSort(students, low, pi - 1, ascending, false);
            quickSort(students, pi + 1, high, ascending, false);
        }

        if (isTopLevel) {
            long afterMerge = runtime.totalMemory() - runtime.freeMemory();
            long end = System.nanoTime();

            // Print only at the top level
            System.out.println("Space Quick Sort (bytes): " + (afterMerge - beforeMerge));
            System.out.println("Time Quick Sort (nanoseconds): " + (end - start));
        }
    }

    private int partition(Student[] students, int low, int high, boolean ascending) {
        Student pivot = students[high];
        int i = low - 1;

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

        return i + 1;
    }


}

