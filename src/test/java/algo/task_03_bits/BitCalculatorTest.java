package algo.task_03_bits;

import algo.BaseTest;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static algo.task_03_bits.BitCalculator.calcPossibleStepsNumberLong;
import static algo.task_03_bits.BitCalculator.calcPossibleStepsNumberShort;

public class BitCalculatorTest extends BaseTest {

    private static Stream<Arguments> getAllArgs() {
        return Stream.of(Arguments.of("770", "3"),
                Arguments.of("1797", "5"),
                Arguments.of("13853283560024178688", "5"));
    }

    @ParameterizedTest
    @MethodSource("getAllArgs")
    void calcPossibleStepsNumberShortTest(String input, int expectedNumber) {
        Assert.assertEquals(expectedNumber, calcPossibleStepsNumberShort(Long.parseUnsignedLong(input)));
    }

    @ParameterizedTest
    @MethodSource("getAllArgs")
    void calcPossibleStepsNumberLongTest(String input, int expectedNumber) {
        Assert.assertEquals(expectedNumber, calcPossibleStepsNumberLong(Long.parseUnsignedLong(input)));
    }
}
