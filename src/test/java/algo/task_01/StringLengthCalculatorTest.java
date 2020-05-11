package algo.task_01;

import algo.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringLengthCalculatorTest extends BaseTest {

    private static final String PATH = BaseTest.ROOT_DATA_PATH + "/task_01/0.String";

    private static Stream<Arguments> getAllArgs() throws Exception {
        Map<String, String> fileNames = BaseTest.getFilesList(PATH);
        return BaseTest.getArguments(fileNames);
    }

    @ParameterizedTest
    @MethodSource("getAllArgs")
    void calcTest(String input, int expected) {
        assertEquals(expected, StringLengthCalculator.calc(input));
    }
}
