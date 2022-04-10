package A2;

import net.datastructures.HeapPriorityQueue;
/* 
Description: Assignment 2
Author: Nick Miller
Date: 04/10/2022
Bugs:
Overview: The main issue for me was understanding how the priority queue<K,V> was supposed to work with 
          a Job object. At first I wasn't sure if the Key and the Values were supposed to be variales 
          from a Job object. I know we are supposed to be using a comparator with the keys being the priority,
          however I wasn't sure what the value was suppsoed to be.

          on the difficulty scale overall I would give this assignment an 8 out of 10
            
*/

/**
 * creates a priority queue passing in the comparator I created, and calls the process scheduler method
 * from the Scheduler class, and creates a new scheduler that are passed into the parameters.
 * Enter in the maxTimeWaiting as the second argument for the Scheduler
 */
public class App {
    public static void main(String[] args) throws Exception { //move to own class
        HeapPriorityQueue<Integer, Integer> jobQueue = new HeapPriorityQueue<>(new MyComparator()); //Key is int priority, value is int length
        Scheduler.processSchedule(new Scheduler("jobs.txt", 2), jobQueue);
        
  
      }
}
