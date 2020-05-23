package algo.task_03;

import algo.BaseTest;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static algo.task_03.BitKnight.calcPossibleMoves;

public class BitKnightTest extends BaseTest{
    private static final String PATH = BaseTest.ROOT_DATA_PATH + "/task_03/0.BITS/2.Bitboard - Конь";

    private static Stream<Arguments> getAllArgs() throws Exception {
        Map<String, String> fileNames = BaseTest.getFilesList(PATH);
        return BaseTest.getArguments(fileNames);
    }

    @ParameterizedTest
    @MethodSource("getAllArgs")
    void calcPossibleMovesTest(String input, String expectedNumber, String expectedMask) {
        Assert.assertEquals(expectedMask, Long.toUnsignedString(calcPossibleMoves(Integer.parseInt(input))));
    }
}
