package A2;
import net.datastructures.*;
import java.io.*;
import java.util.*;

public class Scheduler extends Job {

    public Scheduler(int priority, int length, int timeWaiting, String name) {
        super(priority, length, timeWaiting, name);
        
    }

    HeapPriorityQueue<Integer, String> jobQueue = 
        new HeapPriorityQueue<>(new MyComparator());

    public static void main(String[] args) throws Exception {
      File schedule = new File("jobs.txt");

    }

    private void procesSchdedule(File schedule)
    {
        //String line;
        //String [] splitLine;
        int index;
        try 
        {
            Scanner scan = new Scanner(schedule);           //stores jobs.txt
            while (scan.hasNextLine()) {                    //reads through jobs.txt
                index = 0;
            String [] line = scan.nextLine().split(" ");    //splits one line of jobs.txt into an array of strings

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
            
        }
        catch (FileNotFoundException e)
        {
            System.out.printf("File was not found");
        }

    }

    

   

    
}
