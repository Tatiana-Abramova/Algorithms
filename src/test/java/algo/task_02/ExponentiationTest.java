package algo.task_02;

import algo.BaseTest;
import algo.Actions;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static algo.task_02.Exponentiation.*;
import static algo.task_02.Exponentiation.calcByPowerOfTwo;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExponentiationTest extends BaseTest {
    private static final String PATH = BaseTest.ROOT_DATA_PATH + "/task_02/3.Power";
    private static final double ACCURACY = 0.0001;

    private static Stream<Arguments> getAllArgs() throws Exception {
        Map<String, String> fileNames = BaseTest.getFilesList(PATH);
        return BaseTest.getArguments(fileNames);
    }

    @ParameterizedTest
    @MethodSource("getAllArgs")
    void calcByLoopTest(String inputA, String inputN, double expected) {
        assertTrue(Math.abs(calcByLoop(Double.parseDouble(inputA), Long.parseLong(inputN)) - expected) < ACCURACY);
    }

    @ParameterizedTest
    @MethodSource("getAllArgs")
    void calcByLoopOptimizedTest(String inputA, String inputN, double expected) {
        assertTrue(Math.abs(calcByPowerOfTwo(Double.parseDouble(inputA), Long.parseLong(inputN)) - expected) < ACCURACY);
    }

    @ParameterizedTest
    @MethodSource("getAllArgs")
    void calcByBinaryDecompositionTest(String inputA, String inputN, double expected) {
        assertTrue(Math.abs(calcByBinaryDecomposition(Double.parseDouble(inputA), Long.parseLong(inputN)) - expected) < ACCURACY);
    }

    @Test
    public void comparativeTest() throws Exception {
        List<Arguments> args = getAllArgs().collect(Collectors.toList());
        Object[][] table = getComparativeTable(args);
        printTable(table);
    }

    @Override
    public Actions getActions(Arguments arg) {
        double a = Double.parseDouble(String.valueOf(arg.get()[0]));
        long n = Long.parseLong(String.valueOf(arg.get()[1]));
        return new Actions(
                a + " ^ " + n,
                new Actions.ActionDetail("Simple loop", () -> calcByLoop(a, n)),
                new Actions.ActionDetail("Power of 2", () -> calcByPowerOfTwo(a, n)),
                new Actions.ActionDetail("By decomposition", () -> calcByBinaryDecomposition(a, n)));
    }
}

