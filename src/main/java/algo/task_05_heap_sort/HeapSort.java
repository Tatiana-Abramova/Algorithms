package algo.task_05_heap_sort;

/**
 * Heap sort works by visualizing the elements of the array as a special kind of complete binary tree called a heap.
 *
 * Time Complexity: O(n*log(n))
 * Auxiliary Space: O(1)
 * Sorting In Place: Yes
 * Stable: Yes
 * Online: No
 */
public class HeapSort {
    public static void sort(int[] array) {

        int start = array.length/2 - 1;
        for (int i = start; i >= 0; i--) {
         order(array, i, array.length);
        }
        for (int i = (array.length - 1); i > 0; i--) {
            swap(array, 0, i);
            order(array, 0, i);
        }
    }

    private static void order(int[] array, int index, int last) {
        int left = index*2 + 1;
        int right = left + 1;
        int maxIndex = index;

        if (left < last && array[index] < array[left]) {
            maxIndex = left;
        }
        if (right < last && array[maxIndex] < array[right]) {
            maxIndex = right;
        }
        if (maxIndex != index) {
            swap(array, index, maxIndex);
            order(array, maxIndex, last);
        }
    }

    private static void swap(int[] array, int parentIndex, int childIndex) {
        int curr = array[parentIndex];
        array[parentIndex] = array[childIndex];
        array[childIndex] = curr;
    }
}
