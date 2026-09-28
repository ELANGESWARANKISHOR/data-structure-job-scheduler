public class SJFScheduler {

    public void schedule(Job[] jobs) {

        int currentTime = 0;
        int jobIndex = 0;

        MinHeap readyQueue = new MinHeap(jobs.length);

        System.out.println("\n=== SJF Scheduling ===");

        while (jobIndex < jobs.length || !readyQueue.isEmpty()) {

            // Add all jobs that have arrived
            while (jobIndex < jobs.length &&
                   jobs[jobIndex].getArrivalTime() <= currentTime) {

                readyQueue.insert(jobs[jobIndex]);

                jobIndex++;
            }

            // If no job is ready, move time to the next arrival
            if (readyQueue.isEmpty()) {

                currentTime = jobs[jobIndex].getArrivalTime();

                continue;
            }

            // Select shortest job
            Job job = readyQueue.removeMin();

            // Record start time
            job.setStartTime(currentTime);

            System.out.println(
                "Time " + currentTime +
                " -> Starting " + job.getId() +
                " (Burst: " + job.getBurstTime() + ")"
            );

            // Execute the job
            currentTime += job.getBurstTime();

            // Record completion
            job.setCompletionTime(currentTime);

            // Calculate metrics
            int waitingTime =
                job.getStartTime() - job.getArrivalTime();

            int turnaroundTime =
                job.getCompletionTime() - job.getArrivalTime();

            int responseTime =
                job.getStartTime() - job.getArrivalTime();

            job.setWaitingTime(waitingTime);
            job.setTurnaroundTime(turnaroundTime);
            job.setResponseTime(responseTime);

            System.out.println(
                "Time " + currentTime +
                " -> Finished " + job.getId()
            );
        }

        System.out.println("=== Scheduling Complete ===");
    }
}