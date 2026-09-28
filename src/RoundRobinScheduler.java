public class RoundRobinScheduler {

    public void schedule(Job[] jobs, int timeQuantum) {

        int currentTime = 0;
        int jobIndex = 0;

        MyQueue readyQueue = new MyQueue();

        System.out.println("\n=== Round Robin Scheduling ===");
        System.out.println("Time Quantum: " + timeQuantum);

        while (jobIndex < jobs.length || !readyQueue.isEmpty()) {

            // If no job is ready, move time to the next arrival
            if (readyQueue.isEmpty() &&
                jobIndex < jobs.length &&
                currentTime < jobs[jobIndex].getArrivalTime()) {

                currentTime = jobs[jobIndex].getArrivalTime();
            }

            // Add all jobs that have arrived
            while (jobIndex < jobs.length &&
                   jobs[jobIndex].getArrivalTime() <= currentTime) {

                readyQueue.enqueue(jobs[jobIndex]);

                jobIndex++;
            }

            if (readyQueue.isEmpty()) {
                continue;
            }

            // Get next job
            Job job = readyQueue.dequeue();

            // Record first start time
            if (job.getStartTime() == -1) {

                job.setStartTime(currentTime);

                System.out.println(
                    "Time " + currentTime +
                    " -> Starting " + job.getId()
                );
            }

            // Run for one time quantum
            int executionTime = Math.min(
                timeQuantum,
                job.getRemainingTime()
            );

            currentTime += executionTime;

            job.setRemainingTime(
                job.getRemainingTime() - executionTime
            );

            // Add newly arrived jobs
            while (jobIndex < jobs.length &&
                   jobs[jobIndex].getArrivalTime() <= currentTime) {

                readyQueue.enqueue(jobs[jobIndex]);

                jobIndex++;
            }

            // Check whether job finished
            if (job.getRemainingTime() == 0) {

                job.setCompletionTime(currentTime);

                int turnaroundTime =
                    job.getCompletionTime()
                    - job.getArrivalTime();

                int waitingTime =
                    turnaroundTime
                    - job.getBurstTime();

                int responseTime =
                    job.getStartTime()
                    - job.getArrivalTime();

                job.setTurnaroundTime(turnaroundTime);
                job.setWaitingTime(waitingTime);
                job.setResponseTime(responseTime);

                System.out.println(
                    "Time " + currentTime +
                    " -> Finished " + job.getId()
                );

            } else {

                // Job still needs CPU time.
                // Put it at the back of the queue.
                readyQueue.enqueue(job);
            }
        }

        System.out.println("=== Scheduling Complete ===");
    }
}

