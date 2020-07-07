package algo.task_05_heap_sort;

/**
 * Pick element arr[i] and insert it into sorted sequence arr[0…i-1]
 *
 * Time Complexity: O(n*2)
 * Auxiliary Space: O(1)
 * Sorting In Place: Yes
 * Stable: Yes
 * Online: Yes
 */
public class InsertionSort {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int element = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > element) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = element;
        }
    }
}
