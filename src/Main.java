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

        System.out.println("\n=== FCFS Results ===");

        for (Job job : jobs) {

            System.out.println(
                "Job " + job.getId() +
                " | Arrival: " + job.getArrivalTime() +
                " | Burst: " + job.getBurstTime() +
                " | Start: " + job.getStartTime() +
                " | Completion: " + job.getCompletionTime() +
                " | Waiting: " + job.getWaitingTime() +
                " | Turnaround: " + job.getTurnaroundTime() +
                " | Response: " + job.getResponseTime()
            );
        }

        double totalWaitingTime = 0;
        double totalTurnaroundTime = 0;
        double totalResponseTime = 0;

        for (Job job : jobs) {
            totalWaitingTime += job.getWaitingTime();
            totalTurnaroundTime += job.getTurnaroundTime();
            totalResponseTime += job.getResponseTime();
    }

        double averageWaitingTime =
            totalWaitingTime / numberOfJobs;

        double averageTurnaroundTime =
            totalTurnaroundTime / numberOfJobs;

        double averageResponseTime =
            totalResponseTime / numberOfJobs;

        System.out.println("\n=== Average Metrics ===");

        System.out.printf(
            "Average Waiting Time: %.2f%n",
            averageWaitingTime
        );

        System.out.printf(
            "Average Turnaround Time: %.2f%n",
            averageTurnaroundTime
        );

        System.out.printf(
            "Average Response Time: %.2f%n",
        averageResponseTime
        );
        scanner.close();


    }
}