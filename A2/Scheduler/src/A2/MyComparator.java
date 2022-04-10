package A2;

import java.util.Comparator;
/**
 * Creates a comparator that sets the lower number as the higher priority in a priority queue
 */
class MyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2)
    {
        return (o1-o2);
    }

}
