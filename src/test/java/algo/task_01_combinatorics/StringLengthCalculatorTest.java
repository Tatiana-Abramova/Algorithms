package algo.task_01_combinatorics;

import algo.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringLengthCalculatorTest extends BaseTest {

    private static final String PATH = ROOT_DATA_PATH + "/task_01_combinatorics/0.String";

    private static Stream<Arguments> getAllArgs() throws Exception {
        Map<String, String> fileNames = getFilesList(PATH);
        return getArguments(fileNames);
    }

    @ParameterizedTest
    @MethodSource("getAllArgs")
    void calcTest(String input, int expected) {
        assertEquals(expected, StringLengthCalculator.calc(input));
    }
}
