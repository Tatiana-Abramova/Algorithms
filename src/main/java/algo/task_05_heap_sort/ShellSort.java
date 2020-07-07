package algo.task_05_heap_sort;

/**
 * Shellsort is an optimization of insertion sort that allows the exchange of items that are far apart.
 * The idea is to arrange the list of elements so that, starting anywhere,
 * taking every hth element produces a sorted list.
 *
 * Time Complexity: O(n*2) - for Shell gap sequence, O(n*3/2) - for Hibbard/Papernov & Stasevich gap sequences
 * Auxiliary Space: O(1)
 * Sorting In Place: Yes
 * Stable: No
 * Online: Yes
 */
public class ShellSort {
    static void sortShell(int array[]) {
        int n = array.length;
        for (int i = n / 2; i > 0; i /= 2) {
            sort(array, n, i);
        }
    }

    public static void sortPapernov(int[] array) {
        int[] seq = new int[]{1, 3, 5, 9, 17, 33, 65, 129, 257, 513, 1025, 2049, 4097, 8193, 16385, 32769, 65537, 131073, 262145, 524289, 1048577, 2097153, 4194305, 8388609, 16777217, 33554433, 67108865, 134217729, 268435457, 536870913, 1073741825};
        sort(array, seq);
    }

    public static void sortHibbard(int[] array) {
        int[] seq = new int[]{1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, 2147483647};
        sort(array, seq);
    }

    private static void sort(int[] array, int n, int i) {
        for (int t = i; t < n; t++) {
            int element = array[t];
            int j = t;
            while (j >= i && array[j - i] > element) {
                array[j] = array[j - i];
                j -= i;
            }
            array[j] = element;
        }
    }

    private static void sort(int[] array, int[] seq) {
        int n = array.length;
        if (n < 2) {
            return;
        }
        int i;
        for (i = 1; i < seq.length; i++) {
            if (seq[i] > n) {
                break;
            }
        }

        while (i > 0) {
            sort(array, n, seq[--i]);
        }
    }
}
