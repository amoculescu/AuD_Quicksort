package lab;

import frame.SortArray;

public class QuickSortA extends QuickSort {

	/**
	 * Quicksort algorithm implementation to sort a SorrtArray by choosing the
	 * pivot as the first (leftmost) element in the list
	 * 
	 * @param records
	 *            - list of elements to be sorted as a SortArray
	 * @param left
	 *            - the index of the left bound for the algorithm
	 * @param right
	 *            - the index of the right bound for the algorithm
	 * @return Returns the sorted list as SortArray
	 */
	@Override
	public void Quicksort(SortArray records, int left, int right) {
		if(left < right){
			//pivot element
            int q = partition(records, left, right);
            Quicksort(records, left, q - 1);
            Quicksort(records, q + 1, right);
        }
	}

	public int partition(SortArray records, int left, int right){
		// pivot element
	    SortingItem pivot = records.getElementAt(left);
	    // index of first item lexicographically bigger than pivot element
        int i = left + 1;
        for (int j = left + 1;  j <= right;  j++){
            SortingItem temp = records.getElementAt(j);
            // serialnumber of j before pivot
            if (temp.BookSerialNumber.compareTo(pivot.BookSerialNumber)  <  0){
                swapItems(records, i, j);
                i++;
            }
            //serial numbers are equal
            else if(temp.BookSerialNumber.compareTo(pivot.BookSerialNumber)  ==  0){
            	//reader id of j before pivot
                if(temp.ReaderID.compareTo(pivot.ReaderID) < 0){
                    swapItems(records, i, j);
                    i++;
                }
            }
        }
        swapItems(records, i - 1, left);
        return i - 1;
    }
}
