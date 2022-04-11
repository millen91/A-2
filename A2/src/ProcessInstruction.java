

/**
 * Class used to process a one line string instruction from a text file
 * Processes the name, length, and priority of a job
 */
public class ProcessInstruction {
   

    public static boolean isJob(String [] instruction)
    {
        if (instruction[0].equals("add"))
        {
            return true;
        }
        return false;
    }

    /**
     * assumes scheduler is an add job instruction
     * A properly formed transaction will have "with" at index length -6
     * checks with is at correct index
     * loops backwards through array until keyword "job"
     * adds onto "final string" the indecies between with and job to form name
     * 
     * if with is not in correct location, then it is a malformed transaction
     * @param scheduler
     * @return finalString (name)
     */
    public static String getName(String [] scheduler) {
        String finalString = "";                    //empty string that adds strings onto it
        int length = scheduler.length;              //length of the given array
        if (scheduler[length - 6].equals("with"))  // "with" was found
        {
            for (int i = length - 7; i >= 0; i--) {
                
                if (scheduler[i -1].equals("job")) 
                {
                    if (scheduler [i - 2].equals("add"))
                    {
                        finalString = scheduler[i] + " " + finalString;
                        return finalString;
                    }
                }
                else
                {
                    finalString = scheduler[i] + " " + finalString;
                }
            }
            return finalString;
        }
        
        return null;
    }

    /**
     * Checks for keyword "length" in String array
     * if found, check if next index is a number
     * if next index is a number, return it
     * else keep going
     * if length is not found, return Length not found error
     * 
     * @param scheduler
     * @return length
     */
    public static int getLength(String[] scheduler) {
        int arrayLength = scheduler.length;

        
            if (scheduler[arrayLength - 5].equals("length")) {
                if (isInt(scheduler[arrayLength - 4]))
                    {
                        return Integer.parseInt(scheduler[arrayLength - 4]);
                    }
                else {
                    return -1;
                }
            }
        
        return -1;
    }

    /**
     * return the priority of a job by returning the last index of an array
     * (which should be an int)
     * 
     * @param schedule arry of strings
     * @return priority
     * @return - 21 if last index is not a valid number
     */
    public static int getPriority(String[] schedule) {
        int lastIndex = schedule.length - 1;
        if (isInt(schedule[lastIndex])) {
            int priority = Integer.parseInt(schedule[lastIndex]);
            if( priority <= 19 && priority >= -20 )
            {
               return priority; 
            }
           
        }
        return -21;
        
    }

    /**
     * Method used to check if a string is a number
     */
    public static boolean isInt(String string) {
        if (string == null) {
            return false;
        }
        try {
            int num = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    

}
