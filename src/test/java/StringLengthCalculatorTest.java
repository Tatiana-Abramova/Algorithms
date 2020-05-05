import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import task_01.StringLengthCalculator;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringLengthCalculatorTest extends BaseTest {

    private static final String PATH = ROOT_DATA_PATH + "/A01_Счастливые_билеты/0.String";

    static Stream<Arguments> getAllArgs() throws Exception {
        Map<String, String> fileNames = getFilesList(PATH);
        return getArguments(fileNames);
    }

    @ParameterizedTest
    @MethodSource("getAllArgs")
    void calcTest(String input, int expected) {
        assertEquals(expected, StringLengthCalculator.calc(input));
    }
}
