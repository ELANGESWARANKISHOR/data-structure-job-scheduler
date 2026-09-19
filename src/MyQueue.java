public class MyQueue {

    private class Node {
        Job job;
        Node next;

        Node(Job job) {
            this.job = job;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public MyQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Add a job to the rear
    public void enqueue(Job job) {

        Node newNode = new Node(job);

        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    // Remove a job from the front
    public Job dequeue() {

        if (front == null) {
            return null;
        }

        Job removedJob = front.job;

        front = front.next;

        if (front == null) {
            rear = null;
        }

        size--;

        return removedJob;
    }

    // Look at the front job without removing it
    public Job peek() {

        if (front == null) {
            return null;
        }

        return front.job;
    }

    // Check whether queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Return number of jobs
    public int size() {
        return size;
    }
}