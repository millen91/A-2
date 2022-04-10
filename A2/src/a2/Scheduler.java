package a2;

import net.datastructures.*;
import java.util.*;

/**
 * scheduler class that contains a scheduler constructor, aswell as a method
 * that processes the scheduler
 */
public class Scheduler {

    int maxWaitingTime = 0;
    String fileName;

    /**
     * Constructor for Scheduler object
     * 
     * @param fileName       String Job.txt
     * @param maxWaitingTime given max waiting time for a scheudler
     */
    public Scheduler(String fileName, int maxWaitingTime) {

        this.maxWaitingTime = maxWaitingTime;
        this.fileName = fileName;
    }

    /**
     * deques a job from given queue and executes it
     * 
     * @param schedule
     * @param HeapPriorityQueue
     */
    public static void processSchedule(Scheduler schedule,
            HeapPriorityQueue<Integer, Job> jobQueue) {

        Scanner scan = null;
        scan = new Scanner(schedule.fileName); // inputs instructions into scanner

        try {

            while (scan.hasNextLine()) { // time slice loop: reads instrucitons from jobs.txt
                int priority = jobQueue.min().getKey();
                Job currentJob = jobQueue.removeMin().getValue(); // saves the job with highest priority and removes it
                                                                  // from the queue

                Job proccessedJob = new Job(jobQueue.min().getKey(),
                        currentJob.length - 1, currentJob.timeWaiting, currentJob.name);
                System.out.printf("%s /n", proccessedJob.toString());

                //2. For all waiting processes, incrament time waiting..
                waitingProcess(jobQueue, schedule);

                //3. insert the executing job back into the priority queue
                jobQueue.insert(priority, proccessedJob);

                //4. process one instruciton from jobs.txt
                String[] line = scan.nextLine().split(" "); // splits one line of jobs.txt into an array of strings
                if (line[0].equals("add")) // create a new job when index0 is string "add"
                {
                    Job addJob = processInstruction(line);

                    if (addJob != null)
                    {
                        jobQueue.insert(addJob.priority, addJob);
                    }

                }
                if (line[0].equals("no")){} // no new job this slice, do nothing 
                else{}                      // anything other than "add" or "no" found, do nothing

            }
            scan.close();                   //entire file was read through, close stream and print Done!
            System.out.printf("Done! \n");  
        }

        catch (Exception e) {

        }
    }

    /**
     * Will return the given priority -1, unless priority = -20,
     * then it has reached the maximum priority so return -20
     * 
     * @param priority
     * @return
     */
    public static int increasePriority(int priority) {
        if (priority == -20) {
            return -20;
        }
        return priority - 1;
    }

    /**
     * Creates a new job when the "add" keyword is found in the schedule array
     * checks if any malformed values are found: return null if malformed value is
     * found
     * return new Job if all values are valid
     */
    public static Job processInstruction(String[] schedule) {

        String name = ProcessInstruction.getName(schedule);
        if (name == null) {
            return null;
        }

        int priority = ProcessInstruction.getPriority(schedule);
        if (priority == -21) {
            return null;
        }
        int length = ProcessInstruction.getLength(schedule);
        if (length == -1) {
            return null;
        }
        return new Job(priority, length, 0, name);
    }
    /**
     * dequeues each job from the priority queue: processes each job: enqueue job into a LinkedQueue
     * @param job
     * @param schedule
     */
    public static HeapPriorityQueue<Integer,Job> waitingProcess(HeapPriorityQueue<Integer,Job> jobQueue,Scheduler schedule)
    {
        LinkedQueue<Job> updatedQueue = 
            new LinkedQueue<>(); 
        
            while(!jobQueue.isEmpty()) //dequeue loop
                {
                    Job  currentJob = jobQueue.removeMin().getValue();
                     currentJob.timeWaiting++;
                    if(currentJob.timeWaiting > schedule.maxWaitingTime) {
                        increasePriority(currentJob.priority);
                        currentJob.timeWaiting = 0;
                }
                updatedQueue.enqueue(currentJob);
                }

            while(!updatedQueue.isEmpty())    //enqueue loop
            {
                Job updatedJob = updatedQueue.dequeue();
                jobQueue.insert(updatedJob.priority, updatedJob);
            }

            return jobQueue;
    }
}
