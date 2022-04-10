package A2;

import net.datastructures.*;
//import java.io.*;
import java.util.*;

/**
 * scheduler class that contains a scheduler constructor, aswell as a method that processes the scheduler
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
     * @param schedule
     * @param HeapPriorityQueue
     */
    public static void processSchedule(Scheduler schedule, 
        HeapPriorityQueue<Integer,Integer> jobQueue) {
         
        Scanner scan = null;
        String instruction;
        scan = new Scanner(schedule.fileName);
        

        try {

            while (scan.hasNextLine()) { // time slice loop: reads instrucitons from jobs.txt
                //index = 0; // might use this if I decide to use an array of strings
               
                // Job job = new Job(jobQueue.min().getKey(), jobQueue.min().getValue(), name);
                String[] line = scan.nextLine().split(" "); // splits one line of jobs.txt into an array of strings

            // for (:)  // compare waiting times with the maxWaitingTime, increase priority for all keys if wT > mWT
                // {

                // }

                if (line[0].equals("add"))  //create a new job when index0 is string "add"
                { 
                   
                }
                if (line[0].equals("no")) // no new job this slice, so do nothing and go to nextLine of file
                {

                } 

            }
            scan.close();

        }

        catch (Exception e) {

        }
    }
     public static int increasePriority(int priority) {
        if (priority == -20)
        {
            return -20;
        }
        return priority - 1;
    }

}
