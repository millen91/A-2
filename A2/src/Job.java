

/**
 * Used to create a job object that has four variables 
 * conteains a constructor, a getter for priority, and a toString() method
 * Jobs are used in the scheduler class 
 */

public class Job {
    int priority;       // priority for PQ 
    int length;         //time measurment for a process (1-100 slices)
    int timeWaiting;    //time it takes a job to run (in slices)
    String name;        //name of the job

   /** 
    *Constructor for job class
    *@param priority        The priority of the job object -20 to 19 (-20 being higher priority)
    *@param length          The measurment of time the scheduler uses to execute a job (meausred in slices 1-100)
    *@param timeWaiting     T5he remaining time (slices) in a job being executed
    *@param name            The name given to a job denoted by a capital letter; job A, B, C
    */
    public Job(int priority, int length, int timeWaiting, String name)
    {
        this.priority = priority;
        this.length = length;
        this.timeWaiting = timeWaiting;
        this.name = name;
    }

    /** 
    *getter for the priority of a job object
    *@param priority        The given priority of the current job
    */
    public static int getPriority(int priority)
    {
        return priority;
    }

    /**
     * Used to print out the name of the job, aswell as the priority and time remaining
     */
    @Override
    public String toString()
    {
            return String.format("%s (priority: %d, time remaining: %d)", name, priority, timeWaiting);
        
    }
}
