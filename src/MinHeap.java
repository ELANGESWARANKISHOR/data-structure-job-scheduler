public class MinHeap {

    private Job[] heap;
    private int size;

    public MinHeap(int capacity) {
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

    // Remove the job with the shortest burst time
    public Job removeMin() {

        if (size == 0) {
            return null;
        }

        Job minJob = heap[0];

        heap[0] = heap[size - 1];

        size--;

        heapifyDown(0);

        return minJob;
    }

    private void heapifyDown(int index) {

        while (true) {

            int left = 2 * index + 1;
            int right = 2 * index + 2;

            int smallest = index;

            if (left < size &&
                hasHigherPriority(heap[left], heap[smallest])) {

                smallest = left;
            }

            if (right < size &&
                hasHigherPriority(heap[right], heap[smallest])) {

                smallest = right;
            }

            if (smallest == index) {
                break;
            }

            Job temp = heap[index];
            heap[index] = heap[smallest];
            heap[smallest] = temp;

            index = smallest;
        }
    }

    private boolean hasHigherPriority(Job first, Job second) {

        // Shorter burst time comes first
        if (first.getBurstTime() != second.getBurstTime()) {
            return first.getBurstTime() < second.getBurstTime();
        }

        // If burst times are equal,
        // earlier arrival time comes first
        if (first.getArrivalTime() != second.getArrivalTime()) {
            return first.getArrivalTime() < second.getArrivalTime();
        }

        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}