import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of jobs: ");
        int numberOfJobs = scanner.nextInt();

        Job[] jobs = new Job[numberOfJobs];

        // Get job information
        for (int i = 0; i < numberOfJobs; i++) {

            String id = "J" + (i + 1);

            System.out.println("\nEnter details for " + id);

            System.out.print("Priority: ");
            int priority = scanner.nextInt();

            System.out.print("Arrival Time: ");
            int arrivalTime = scanner.nextInt();

            System.out.print("Burst Time: ");
            int burstTime = scanner.nextInt();

            jobs[i] = new Job(
                id,
                priority,
                arrivalTime,
                burstTime
            );
        }

        // Sort jobs by arrival time
        JobSorter.sortByArrivalTime(jobs);

        System.out.println("\nJobs sorted by arrival time:");

        for (Job job : jobs) {
            job.display();
        }

        // Add sorted jobs to the queue
        MyQueue queue = new MyQueue();

        for (Job job : jobs) {
            queue.enqueue(job);
        }

        // Run FCFS
        FCFSScheduler scheduler = new FCFSScheduler();

        scheduler.schedule(queue);

        scanner.close();
    }
}