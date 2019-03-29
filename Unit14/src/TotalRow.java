//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import java.util.*;

public class TotalRow
{
    public static List<Integer> getRowTotals( int[][] m )
    {
    	List<Integer> totals = new ArrayList<Integer>();
    	for (int[] row: m)
    	{
    		int sum = 0;
    		for (int each: row)
    		{
    			sum += each;
    		}
    		totals.add(sum);
    	}
		return totals;
    }
}
