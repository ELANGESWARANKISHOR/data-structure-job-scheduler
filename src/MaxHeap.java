public class MaxHeap {

    private Job[] heap;
    private int size;

    public MaxHeap(int capacity) {
        heap = new Job[capacity];
        size = 0;
    }

    // Add a job to the heap
    public void insert(Job job) {

        heap[size] = job;

        int current = size;

        size++;

        // Move the job upward
        while (current > 0) {

            int parent = (current - 1) / 2;

            if (hasHigherPriority(heap[current], heap[parent])) {

                Job temp = heap[current];
                heap[current] = heap[parent];
                heap[parent] = temp;

                current = parent;

            } else {
                break;
            }
        }
    }

    // Remove and return the highest-priority job
    public Job removeMax() {

        if (size == 0) {
            return null;
        }

        Job maxJob = heap[0];

        heap[0] = heap[size - 1];

        size--;

        // Move the root downward
        heapifyDown(0);

        return maxJob;
    }

    private void heapifyDown(int index) {

        while (true) {

            int left = 2 * index + 1;
            int right = 2 * index + 2;

            int highest = index;

            if (left < size &&
                hasHigherPriority(heap[left], heap[highest])) {

                highest = left;
            }

            if (right < size &&
                hasHigherPriority(heap[right], heap[highest])) {

                highest = right;
            }

            if (highest == index) {
                break;
            }

            Job temp = heap[index];
            heap[index] = heap[highest];
            heap[highest] = temp;

            index = highest;
        }
    }

    private boolean hasHigherPriority(Job first, Job second) {

        if (first.getPriority() != second.getPriority()) {
            return first.getPriority() > second.getPriority();
        }

        // Same priority → earlier arrival first
        if (first.getArrivalTime() != second.getArrivalTime()) {
            return first.getArrivalTime() < second.getArrivalTime();
        }

        // Same priority and arrival → keep original/input order
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}