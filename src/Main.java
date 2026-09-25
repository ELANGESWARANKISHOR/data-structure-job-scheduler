import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Job Scheduling System ===");

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

        // Scheduling menu
        System.out.println("\n=== Select Scheduling Algorithm ===");
        System.out.println("1. FCFS");
        System.out.println("2. Priority Scheduling");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();

        if (choice == 1) {

            MyQueue queue = new MyQueue();

            for (Job job : jobs) {
                queue.enqueue(job);
            }

            FCFSScheduler scheduler = new FCFSScheduler();

            scheduler.schedule(queue);

            displayResults(jobs);

        } else if (choice == 2) {

            PriorityScheduler scheduler = new PriorityScheduler();

            scheduler.schedule(jobs);

            displayResults(jobs);

        } else {

            System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    public static void displayResults(Job[] jobs) {

        System.out.println("\n=== Scheduling Results ===");

        double totalWaitingTime = 0;
        double totalTurnaroundTime = 0;
        double totalResponseTime = 0;

        for (Job job : jobs) {

            System.out.println(
                "Job " + job.getId() +
                " | Arrival: " + job.getArrivalTime() +
                " | Burst: " + job.getBurstTime() +
                " | Priority: " + job.getPriority() +
                " | Start: " + job.getStartTime() +
                " | Completion: " + job.getCompletionTime() +
                " | Waiting: " + job.getWaitingTime() +
                " | Turnaround: " + job.getTurnaroundTime() +
                " | Response: " + job.getResponseTime()
            );

            totalWaitingTime += job.getWaitingTime();
            totalTurnaroundTime += job.getTurnaroundTime();
            totalResponseTime += job.getResponseTime();
        }

        int numberOfJobs = jobs.length;

        System.out.println("\n=== Average Metrics ===");

        System.out.printf(
            "Average Waiting Time: %.2f%n",
            totalWaitingTime / numberOfJobs
        );

        System.out.printf(
            "Average Turnaround Time: %.2f%n",
            totalTurnaroundTime / numberOfJobs
        );

        System.out.printf(
            "Average Response Time: %.2f%n",
            totalResponseTime / numberOfJobs
        );
    }
}