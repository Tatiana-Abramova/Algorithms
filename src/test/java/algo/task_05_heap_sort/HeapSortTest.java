package algo.task_05_heap_sort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class HeapSortTest extends SortTest {

    @ParameterizedTest
    @MethodSource("getAllArgsRandom")
    void sortRandomTest(int length, String input, String output) {
        compare(input, output);
    }

    @ParameterizedTest
    @MethodSource("getAllArgsDigits")
    void sortDigitsTest(int length, String input, String output) {
        compare(input, output);
    }

    @ParameterizedTest
    @MethodSource("getAllArgsSorted")
    void sortSortedTest(int length, String input, String output) {
        compare(input, output);
    }

    @ParameterizedTest
    @MethodSource("getAllArgsRevers")
    void sortReversTest(int length, String input, String output) {
        compare(input, output);
    }

    private void compare(String input, String output){
        compareFunc(input, output, HeapSort::sort);
    }
}
