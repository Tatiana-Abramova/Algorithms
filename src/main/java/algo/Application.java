package algo;


import algo.task_05_heap_sort.HeapSort;
import algo.task_05_heap_sort.ShellSort;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        int[] array = new int[]{1,3,10,6,2,5,13,12,11,7,4,8,14,9};
        ShellSort.sortHibbard(array);
        System.out.println(Arrays.toString(array));
    }

}
