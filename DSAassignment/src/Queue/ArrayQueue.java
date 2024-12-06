package Queue;

public class ArrayQueue {
    private int front, rear, size, capacity;
    private int[] array;

    // Constructor to initialize the queue
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.front = this.size = 0;
        this.rear = capacity - 1;
        this.array = new int[capacity];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Add an item to the queue
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        rear = (rear + 1) % capacity; // circular increment
        array[rear] = item;
        size++;
        System.out.println(item + " enqueued to queue");
    }

    // Remove an item from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int item = array[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    // Get the front item
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return array[front];
    }
}
