package algo.task_03;

import algo.BaseTest;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static algo.task_03.BitKing.*;

public class BitKingTest extends BaseTest {
    private static final String PATH = BaseTest.ROOT_DATA_PATH + "/task_03/0.BITS/1.Bitboard - Король";

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
