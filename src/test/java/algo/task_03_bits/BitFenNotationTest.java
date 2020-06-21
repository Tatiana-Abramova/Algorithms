package algo.task_03_bits;

import algo.BaseTest;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static algo.task_03_bits.BitFenNotation.calcPositions;

public class BitFenNotationTest extends BaseTest {
    private static final String PATH = BaseTest.ROOT_DATA_PATH + "/task_03_bits/0.BITS/3.Bitboard - FEN";

    private static Stream<Arguments> getAllArgs() throws Exception {
        Map<String, String> fileNames = BaseTest.getFilesList(PATH);
        return BaseTest.getArguments(fileNames);
    }

    @ParameterizedTest
    @MethodSource("getAllArgs")
    void calcPossibleStepsTest(String input
            , String expected0
            , String expected1
            , String expected2
            , String expected3
            , String expected4
            , String expected5
            , String expected6
            , String expected7
            , String expected8
            , String expected9
            , String expected10
            , String expected11) {
        Map<Piece, Pair<Integer, Long>> actuals = calcPositions(input);

        Assert.assertEquals(expected0, Long.toUnsignedString(actuals.get(Piece.WHITE_PAWNS).getValue()));
        Assert.assertEquals(expected1, Long.toUnsignedString(actuals.get(Piece.WHITE_KNIGHTS).getValue()));
        Assert.assertEquals(expected2, Long.toUnsignedString(actuals.get(Piece.WHITE_BISHOPS).getValue()));
        Assert.assertEquals(expected3, Long.toUnsignedString(actuals.get(Piece.WHITE_ROOKS).getValue()));
        Assert.assertEquals(expected4, Long.toUnsignedString(actuals.get(Piece.WHITE_QUEENS).getValue()));
        Assert.assertEquals(expected5, Long.toUnsignedString(actuals.get(Piece.WHITE_KING).getValue()));
        Assert.assertEquals(expected6, Long.toUnsignedString(actuals.get(Piece.BLACK_PAWNS).getValue()));
        Assert.assertEquals(expected7, Long.toUnsignedString(actuals.get(Piece.BLACK_KNIGHTS).getValue()));
        Assert.assertEquals(expected8, Long.toUnsignedString(actuals.get(Piece.BLACK_BISHOPS).getValue()));
        Assert.assertEquals(expected9, Long.toUnsignedString(actuals.get(Piece.BLACK_ROOKS).getValue()));
        Assert.assertEquals(expected10, Long.toUnsignedString(actuals.get(Piece.BLACK_QUEENS).getValue()));
        Assert.assertEquals(expected11, Long.toUnsignedString(actuals.get(Piece.BLACK_KING).getValue()));
    }
}
