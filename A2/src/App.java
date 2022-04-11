

//import net.datastructures.HeapPriorityQueue;
import net.datastructures.*;
/* 
Description: Assignment 2
Author: Nick Miller
Date: 04/10/2022
Bugs: 1. For some reason, the program only works when run with the debugger.
      2. The terminal cuts off some of the output for some reason
    output bugs: output 2 doesn't always match correctly ( priority 4: length 6) will sometimes not show up
      3. 


Overview: The main issue for me was understanding how the priority queue<K,V> was supposed to work with 
          a Job object. At first I wasn't sure if the Key and the Values were supposed to be variales 
          from a Job object. I know we are supposed to be using a comparator with the keys being the priority,
          however I wasn't sure what the value was suppsoed to be.

          on the difficulty scale overall I would give this assignment an 10 out of 10
            
*/

/**
 * creates a priority queue passing in the comparator I created, and calls the process scheduler method
 * from the Scheduler class, and creates a new scheduler that are passed into the parameters.
 * Enter in the maxTimeWaiting as the second argument for the Scheduler
 */
public class App {
    public static void main(String[] args) throws Exception { 
        HeapPriorityQueue<Integer, Job> jobQueue = new HeapPriorityQueue<>(new MyComparator()); //Key is priority, value is int length
        Scheduler schedule = new Scheduler("jobs.txt", 0);
        Scheduler.processSchedule(schedule, jobQueue);
  
      }
}
