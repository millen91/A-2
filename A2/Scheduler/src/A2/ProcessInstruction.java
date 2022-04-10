package A2;

/**
 * Class used to process a one line string instruction from a text file
 * Processes the name, length, and priority of a job
 */
public class ProcessInstruction {
   

    /**
     * Once keyword "job" is found, 
     * name is formed from every string between "job" and "with length n",
     * Has to account for names with multiple strings
     * see example that has the name "with length"
     * @param scheduler
     * @return
     */
    public static String getName(String [] scheduler) {
        String title = "";
        StringBuilder titleBuilder = new StringBuilder();
        for (int i = scheduler.length - 1; i > 0; i--) {
            if (scheduler[i].equals(String.valueOf(getLength(scheduler)))) 
            {
                int j = i -2;
                while(!scheduler[j].equals("job"))
                {
                    //titleBuilder.append()
                }
            }
        }
        return title;
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
        int length;

        for (int i = 3; i < scheduler.length; i++) {
            if (scheduler[i].equals("length")) {
                if (scheduler[i + 1] == null) // if the next index is out of bounds
                {
                    return -1;
                } else if (isInt(scheduler[i + 1])) {
                    length = Integer.parseInt(scheduler[i + 1]);
                    if (length >= 1 && length <= 100) {
                        return length;
                    }
                    else 
                    {
                        return -1;
                    }
                }

            }
        }
        return -1;
    }

    /**
     * return the priority of a job by returning the last index of an array
     * (which should be an int)
     * 
     * @param schedule arry of strings
     * @return waiting time
     * @return - 1 if last index is not a valid number
     */
    public static int getPriority(String[] schedule) {
        int lastIndex = schedule.length - 1;
        if (isInt(schedule[lastIndex])) {
            return Integer.parseInt(schedule[lastIndex]);
        } else {
            return -1;
        }
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
