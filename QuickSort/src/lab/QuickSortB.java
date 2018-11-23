package lab;

import frame.SortArray;

public class QuickSortB extends QuickSort {

	/**
	 * Quicksort algorithm implementation to sort a SorrtArray by choosing the
	 * pivot as the median of the elements at positions (left,middle,right)
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
		// TODO
		if(left < right){
			//pivot element
            int q = partition(records, left, right);
            Quicksort(records, left, q - 1);
            Quicksort(records, q + 1, right);
		}
	}

	public int partition(SortArray records, int left, int right) {
        int indexPivot = calculateMedian(records, left, right);
        SortingItem pivot = records.getElementAt(indexPivot);
        int i = left;
        for (int j = left; j <= right; j++) {
            SortingItem temp = records.getElementAt(j);
            //element at j before pivot
            if (temp.BookSerialNumber.compareTo(pivot.BookSerialNumber) < 0) {
                if (indexPivot == i)
                    indexPivot = j;
                swapItems(records, i, j);
                i++;
            }
            //serial numbers are equal
            else if (temp.BookSerialNumber.compareTo(pivot.BookSerialNumber) == 0) {
                //reader id of j before pivot
                if (temp.ReaderID.compareTo(pivot.ReaderID) < 0) {
                    if (indexPivot == i)
                        indexPivot = j;
                    swapItems(records, i, j);
                    i++;
                }
            }
        }
        if (indexPivot != i){
            swapItems(records, i, indexPivot);
            indexPivot = i;
        }
         return indexPivot;
	}

    /**
     * function that calculates the index of the pivot element quicksort will be using
     *
     * @param records
     *      list of elements
     * @param left
     *      left bound of algorithm
     * @param right
     *      right bound of algorithm
     * @return i
     *      ndex of pivot element
     */
	private int calculateMedian(SortArray records, int left, int right) {
	    if(right - left < 2)
	        return left;
	    else {
            int middle = (left + right) / 2;
            //System.out.println(left + " " + middle + " " + right);
            int lComparedToM = records.getElementAt(left).BookSerialNumber.compareTo(records.getElementAt(middle).BookSerialNumber);
            if (lComparedToM == 0) // check if BookSerialNumber of l equals m
                lComparedToM = records.getElementAt(left).ReaderID.compareTo(records.getElementAt(middle).ReaderID);

            int mComparedToR = records.getElementAt(middle).BookSerialNumber.compareTo(records.getElementAt(right).BookSerialNumber);
            if (mComparedToR == 0) // check if BookSerialNumber of m equals r
                mComparedToR = records.getElementAt(middle).ReaderID.compareTo(records.getElementAt(right).ReaderID);

            int lComparedToR = records.getElementAt(left).BookSerialNumber.compareTo(records.getElementAt(right).BookSerialNumber);
            if (lComparedToR == 0) // check if BookSerialNumber of l equals r
                lComparedToR = records.getElementAt(left).ReaderID.compareTo(records.getElementAt(right).ReaderID);


            if (lComparedToM == 0 && mComparedToR == 0)
                return middle;

            else if (lComparedToM == 0) {
                if (mComparedToR < 0)
                    return middle;
                else
                    return left;
            }

            else if (mComparedToR == 0){
                if(lComparedToM < 0)
                    return middle;
                else
                    return right;
            }

            else if (lComparedToR == 0){
                if (lComparedToM < 0)
                    return right;
                else
                    return left;
            }


            // left before middle
            else if (lComparedToM < 0){
		        //middle before right
                if( mComparedToR < 0)
                    return middle;
                else{
                    if(lComparedToR < 0)
                        return right;
                    else
                        return left;
                }

            }
            //middle before left;
            else{
                //m before r
                if(mComparedToR < 0) {
                    // l before r
                    if (lComparedToR < 0)
                        return left;
                    else
                        return right;
                }
                else
                    return middle;
            }
        }
	}
	// You may add additional methods here

}
