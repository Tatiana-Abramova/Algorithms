package algo.task_05_heap_sort;

/**
 * The selection sort algorithm sorts an array by repeatedly finding the minimum element
 * (considering ascending order) from unsorted part and putting it at the beginning.
 * The algorithm maintains two subarrays in a given array.
 * 1) The subarray which is already sorted.
 * 2) Remaining subarray which is unsorted.
 *
 * In every iteration of selection sort, the minimum element (considering ascending order)
 * from the unsorted subarray is picked and moved to the sorted subarray.
 *
 * Time Complexity: O(n*2)
 * Auxiliary Space: O(1)
 * Sorting In Place: Yes
 * Stable: Yes
 * Online: No
 */
public class SelectionSort {

    public static void sort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] <  array[minIndex]) {
                    minIndex = j;
                }
            }
            int curr = array[i];
            array[i] = array[minIndex];
            array[minIndex] = curr;
        }
    }
}
