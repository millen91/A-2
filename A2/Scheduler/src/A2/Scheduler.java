package A2;
import net.datastructures.*;
import java.io.*;
import java.util.*;

/**
 * creates 
 */
public class Scheduler  {
    HeapPriorityQueue<Integer, String> jobQueue = 
        new HeapPriorityQueue<>(new MyComparator());
    
    int maxWaitingTime = 0;
    String fileName;

    
    /**
     * Constructor for Scheduler object
     * @param fileName String Job.txt 
     * @param maxWaitingTime given max waiting time for a scheudler
     */
    public Scheduler(String fileName, int maxWaitingTime) {
       
        this.maxWaitingTime = maxWaitingTime;
        this.fileName = fileName; 
        processSchedule(new File(fileName), 2);
        
    }

    private void processSchedule(File schedule, int maxWaitingTime)
    {
        //String line;
        //String [] splitLine;
        int index;
        try 
        {
            Scanner scan = new Scanner(schedule);            //stores jobs.txt
            while (scan.hasNextLine()) {                    //reads through jobs.txt
                index = 0;
            String [] line = scan.nextLine().split(" ");  //splits one line of jobs.txt into an array of strings
              
            if (line[0].equals("#")) {}
            if (line[0].equals("no"))                       //no new job this slice
            {
                line = scan.nextLine().split(" ");
            }
            else if (line[0].equals("add"))               //Edge case where add instruciton is not found
            {
                
                
                //System.out.printf("Error: Reading add instruction");
            }
            else if(line[index].equals("job"))              //
            {
                index++;
            }
            
            }
            scan.close();
            
        }
        catch (FileNotFoundException e)
        {
            System.out.printf("File was not found");
        }

    }

    

   

    
}
