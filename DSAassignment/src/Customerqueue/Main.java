package Customerqueue;

public class Main {
    public static void main(String[] args) {
        FIFOQueue queue = new FIFOQueue(3); // Capacity of the queue is 3

        // Customers arriving
        queue.enqueue(new Customer("Customer A"));
        queue.displayQueue();

        queue.enqueue(new Customer("Customer B"));
        queue.displayQueue();

        queue.enqueue(new Customer("Customer C"));
        queue.displayQueue();

        // Attempting to add another customer
        queue.enqueue(new Customer("Customer D")); // This should indicate the queue is full

        // Serving customers
        queue.dequeue();
        queue.displayQueue();

        queue.dequeue();
        queue.displayQueue();

        queue.dequeue();
        queue.displayQueue();

        // Attempting to serve another customer
        queue.dequeue(); // This should indicate the queue is empty
    }

}
