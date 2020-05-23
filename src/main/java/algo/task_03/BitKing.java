package algo.task_03;

/**
 * Possible King's moves on a chess board
 */
public class BitKing {

    public static long calcPossibleMoves(int positionNumber) {
        // Set the King to a start position
        long position = 1L << positionNumber;

        // Define left and right borders
        long positionL = position & Long.parseUnsignedLong("18374403900871474942");
        long positionR = position & Long.parseUnsignedLong("9187201950435737467");

        // Define a bit mask for possible steps
        return positionL << 7  | position << 8  | positionR << 9
             | positionL >>> 1                  | positionR << 1
             | positionL >>> 9 | position >>> 8 | positionR >>> 7;
    }
}
