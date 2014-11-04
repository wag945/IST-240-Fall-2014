/*
 * @Course: IST 240 (FA 14)
 * @Section: 001
 *
 * @Group 08
 */

import java.util.Comparator;

class ColumnComparator implements Comparator 
{
	int columnToSort;
	ColumnComparator(int columnToSort) 
        {
		this.columnToSort = columnToSort;
	}
	
        @Override
	public int compare(Object o1, Object o2) 
        {
		String[] row1 = (String[]) o1;
		String[] row2 = (String[]) o2;
		//compare the columns to sort
		return row1[columnToSort].compareTo(row2[columnToSort]);
	}
}
