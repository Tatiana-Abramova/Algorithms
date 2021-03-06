package algo.task_02_algebraic_alg;

import algo.Actions;
import algo.BaseTest;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static algo.task_02_algebraic_alg.FibonacciNumbers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciNumbersTest extends BaseTest{
    private static final String PATH = ROOT_DATA_PATH + "/task_02_algebraic_alg/4.Fibo";

    private static Stream<Arguments> getAllArgs() throws Exception {
        Map<String, String> fileNames = getFilesList(PATH);
        return getArguments(fileNames);
    }

    @ParameterizedTest
    @MethodSource("getAllArgs")
    void calcIterationTest(String input, long expected) {
        assertEquals(expected, calcIteration(Integer.parseInt(input)));
    }

    @ParameterizedTest
    @MethodSource("getAllArgs")
    void calcGoldenRatioTest(String input, long expected) {
        assertEquals(expected, calcGoldenRatio(Integer.parseInt(input)));
    }

    @ParameterizedTest
    @MethodSource("getAllArgs")
    void calcByMatrixTest(String input, long expected) {
        assertEquals(expected, calcByMatrix(Integer.parseInt(input)));
    }

    @Test
    public void comparativeTest() throws Exception {
        List<Arguments> args = getAllArgs().collect(Collectors.toList());
        Object[][] table = getComparativeTable(args);
        printTable(table);
    }

    @Override
    public Actions getActions(Arguments arg) {
        int n = Integer.parseInt(String.valueOf(arg.get()[0]));
        return new Actions(
                "Fibonacci N " + n,
                new Actions.ActionDetail("Loop", () -> calcIteration(n)),
                new Actions.ActionDetail("Formula", () -> calcGoldenRatio(n)),
                new Actions.ActionDetail("Matrix", () -> calcByMatrix(n)));
    }
}
