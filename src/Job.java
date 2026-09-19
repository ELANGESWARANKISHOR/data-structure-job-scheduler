public class Job {

    private String id;
    private int priority;
    private int arrivalTime;
    private int burstTime;

    
    public Job(String id, int priority, int arrivalTime, int burstTime) {
        this.id = id;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public int getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public int getBurstTime() {
        return burstTime;
    }
    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
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