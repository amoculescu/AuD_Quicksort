package lab;

import frame.SortArray;

/**
 * Abstract superclass for the Quicksort algorithm.
 * 
 * @author NAJI
 */
public abstract class QuickSort {

	// DO NOT modify this method
	public abstract void Quicksort(SortArray records, int left, int right);
	
	
	/**
	 * method that partitions the list that is to be sorted into 2 smaller arrays
	 * 
	 * @param records
	 * 		- list that is to be sorted as SortArray
	 * 
	 * @param left
	 *      - the index of the left bound for the algorithm
	 *      
	 * @param right
	 * 		- the index of the right bound for the algorithm
	 * 
	 * @return
	 * 		- return index of the pivot element
	 */
	public abstract int partition(SortArray records, int left, int right);
	
	/**
	 * function to swap 2 items in a list
	 * 
	 * @param records
	 * 		- list of items containing the 2 items that are going to be swapped
	 * @param first
	 * 		- first item
	 * @param second
	 * 		- second item 
	 */
    protected void swapItems(SortArray records, int first, int second){
    	
    	//temporarily store first item
        SortingItem temp = records.getElementAt(first);
        //put second element in place of first
        records.setElementAt(first, records.getElementAt(second));
        //put back first item in place of the second one
        records.setElementAt(second, temp);
    }
}
