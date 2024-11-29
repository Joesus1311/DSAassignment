package Memorystack;
import java.util.*;
public class Stackframe {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        int result = add(x, y); // Call to the add method
        System.out.println("Result: " + result);
    }

    public static int add(int a, int b) {
        int sum = a + b; // Local variable
        return sum; // Return the result
    }

}
