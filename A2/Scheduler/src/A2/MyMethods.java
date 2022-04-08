package A2;

public class MyMethods {
    public static int changePriority(int priority)
    {
        return priority;
    }
    public static int getPriority(String [] scheduler)
    {
        int priority = Integer.parseInt(scheduler[scheduler.length -1]);
       
        return priority;
    }
    public static String getTitle(String [] scheduler)
    {
        String title = "";
        StringBuilder titleBuilder = new StringBuilder();
        for (int i = 2; i < scheduler.length - 2; i++)
        {
            if ()
             {

             }
        }
        return title;
    }
    public static int getLength(String [] scheduler)
    {
        int length = 0;

       // for (int i = )
        return length;
    }

    public static int maxWaitingTime(String [] schedule)
    {
        int lastIndex = schedule.length - 1;
        return Integer.parseInt(schedule[lastIndex]);
    }

}
