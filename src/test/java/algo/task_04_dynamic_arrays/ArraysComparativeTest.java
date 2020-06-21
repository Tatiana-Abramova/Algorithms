package algo.task_04_dynamic_arrays;

import algo.BaseTest;
import algo.task_04_dynamic_arrays.dynamic_arrays.Array;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Map;
import java.util.stream.Stream;

/**
 * A base class for the dynamic array implementations comparative performance testing.
 */
public class ArraysComparativeTest extends BaseTest {
    private static final String PATH = BaseTest.ROOT_DATA_PATH + "/task_04_dynamic_arrays";

    static Stream<Arguments> getAllArgs() throws Exception {
        Map<String, String> fileNames = BaseTest.getFilesList(PATH);
        return BaseTest.getArguments(fileNames);
    }

    static void fillArray(Array data, int total) {
        for (int j = 0; j < total; j++) {
            data.add(j, 0);
        }
    }

    static void clearArray(Array data, int total) {
        for (int j = 0; j < total; j++) {
            data.remove(0);
        }
    }
}
