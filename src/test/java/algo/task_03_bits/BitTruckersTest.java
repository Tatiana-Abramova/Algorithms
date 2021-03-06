package algo.task_03_bits;

import algo.BaseTest;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static algo.task_03_bits.BitTruckers.calcMoves;


public class BitTruckersTest extends BaseTest {
    private static final String PATH = ROOT_DATA_PATH + "/task_03_bits/0.BITS/4.Bitboard - Дальнобойщики";

    private static Stream<Arguments> getAllArgs() throws Exception {
        Map<String, String> fileNames = getFilesList(PATH);
        return getArguments(fileNames);
    }

    @ParameterizedTest
    @MethodSource("getAllArgs")
    void calcMovesTest(String input, String maskRook, String maskBishop, String maskQuin) {
        long[] actual = calcMoves(input);
        Assert.assertEquals(maskRook, Long.toUnsignedString(actual[0]));
        Assert.assertEquals(maskBishop, Long.toUnsignedString(actual[1]));
        Assert.assertEquals(maskQuin, Long.toUnsignedString(actual[2]));
    }
}
