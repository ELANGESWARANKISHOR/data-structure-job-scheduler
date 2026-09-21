public class FCFSScheduler {

    public void schedule(MyQueue queue) {

        int currentTime = 0;

        System.out.println("=== FCFS Scheduling ===");

        while (!queue.isEmpty()) {

            Job job = queue.dequeue();

            // If the CPU is idle, move time to the job's arrival
            if (currentTime < job.getArrivalTime()) {
                currentTime = job.getArrivalTime();
            }

            job.setStartTime(currentTime);

            System.out.println(
                "Time " + currentTime +
                " -> Starting " + job.getId()
            );

            // Simulate execution
            currentTime = currentTime + job.getBurstTime();

            job.setCompletionTime(currentTime);

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