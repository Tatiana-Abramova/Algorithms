package algo.task_05_heap_sort;

import algo.BaseTest;
import org.junit.Assert;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class SortTest extends BaseTest {
    private static final String PATH = ROOT_DATA_PATH + "/task_05_heap_sort/";
    private static final String PATH_RANDOM = PATH + "/0.random/";
    private static final String PATH_DIGITS = PATH + "/1.digits/";
    private static final String PATH_SORTED = PATH + "/2.sorted/";
    private static final String PATH_REVERS = PATH + "/3.revers/";

    protected static Stream<Arguments> getAllArgs(String path) throws Exception {
        Map<String, String> fileNames;
        switch (path) {
            case PATH_RANDOM:
                fileNames = getFilesList(PATH_RANDOM);
                return getArguments(fileNames);
            case PATH_DIGITS:
                fileNames = getFilesList(PATH_DIGITS);
                return getArguments(fileNames);
            case PATH_SORTED:
                fileNames = getFilesList(PATH_SORTED);
                return getArguments(fileNames);
            case PATH_REVERS:
                fileNames = getFilesList(PATH_REVERS);
                return getArguments(fileNames);
            default:
                return null;
        }
    }

    protected static Stream<Arguments> getAllArgsRandom() throws Exception {
        return getAllArgs(PATH_RANDOM);
    }

    protected static Stream<Arguments> getAllArgsDigits() throws Exception {
        return getAllArgs(PATH_DIGITS);
    }

    protected static Stream<Arguments> getAllArgsSorted() throws Exception {
        return getAllArgs(PATH_SORTED);
    }

    protected static Stream<Arguments> getAllArgsRevers() throws Exception {
        return getAllArgs(PATH_REVERS);
    }

    protected static int[] toArray(String input) {
        String[] array = input.split(" ");
        return Arrays.stream(array).mapToInt(Integer::parseInt).toArray();
    }

    protected static String fromArray(int[] array) {
        StringJoiner sj = new StringJoiner(" ");
        for (int item : array) {
            sj.add(String.valueOf(item));
        }
        return sj.toString();
    }

    protected void compareFunc(String input, String output, Consumer<int[]> func) {
        int[] expectedArray = toArray(output);
        int[] actualArray = toArray(input);
        func.accept(actualArray);
        String actual = fromArray(actualArray);
        String expected = fromArray(expectedArray);
        Assert.assertEquals(expected, actual);
    }
}
