package Customerqueue;

public class FIFOQueue {
    private Customer[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    // Constructor to initialize the queue
    public FIFOQueue(int capacity) {
        this.capacity = capacity;
        queue = new Customer[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Method to add a customer to the queue
    public void enqueue(Customer customer) {
        if (size == capacity) {
            System.out.println("Queue is full! Cannot add " + customer.getName());
            return;
        }
        rear = (rear + 1) % capacity; // Wrap around
        queue[rear] = customer;
        size++;
        System.out.println(customer.getName() + " has joined the queue.");
    }

    // Method to remove a customer from the queue
    public Customer dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty! No one to serve.");
            return null; // Indicating the queue is empty
        }
        Customer customer = queue[front];
        front = (front + 1) % capacity; // Wrap around
        size--;
        System.out.println("Serving: " + customer.getName());
        return customer;
    }

    // Method to get the current size of the queue
    public int size() {
        return size;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to display the current queue status
    public void displayQueue() {
        System.out.print("Current queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity].getName() + " ");
        }
        System.out.println();
    }
}
