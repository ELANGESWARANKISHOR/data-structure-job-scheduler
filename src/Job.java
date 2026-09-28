public class Job {

    private String id;
    private int priority;
    private int arrivalTime;
    private int burstTime;

    // Scheduling information
    private int startTime;
    private int completionTime;
    private int waitingTime;
    private int turnaroundTime;
    private int responseTime;

    // Used by Round Robin
    private int remainingTime;

    public Job(
        String id,
        int priority,
        int arrivalTime,
        int burstTime
    ) {

        this.id = id;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;

        // Initially, remaining time is the complete burst time
        this.remainingTime = burstTime;

        // Default scheduling values
        this.startTime = -1;
        this.completionTime = -1;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
        this.responseTime = 0;
    }

    public String getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getCompletionTime() {
        return completionTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public int getTurnaroundTime() {
        return turnaroundTime;
    }

    public int getResponseTime() {
        return responseTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setCompletionTime(int completionTime) {
        this.completionTime = completionTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    public void setResponseTime(int responseTime) {
        this.responseTime = responseTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public void display() {

        System.out.println(
            "Job ID: " + id +
            ", Priority: " + priority +
            ", Arrival Time: " + arrivalTime +
            ", Burst Time: " + burstTime
        );
    }
}

