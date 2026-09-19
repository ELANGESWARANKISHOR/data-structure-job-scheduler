public class JobSorter {

    public static void sortByArrivalTime(Job[] jobs) {

        for (int i = 1; i < jobs.length; i++) {

            Job currentJob = jobs[i];

            int j = i - 1;

            // Move jobs with larger arrival times one position forward
            while (j >= 0 &&
                   jobs[j].getArrivalTime() > currentJob.getArrivalTime()) {

                jobs[j + 1] = jobs[j];

                j--;
            }

            // Insert current job into the correct position
            jobs[j + 1] = currentJob;
        }
    }
}