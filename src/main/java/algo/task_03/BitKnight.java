package algo.task_03;

/**
 * Possible Knight's moves on a chess board
 */
public class BitKnight {

    public static long calcPossibleMoves(int positionNumber) {
        // Set the Knight to a start position
        long position = 1L << positionNumber;

        // Define left and right borders
        long positionL = position & Long.parseUnsignedLong("18374403900871474942");
        long positionLL = position & Long.parseUnsignedLong("18229723555195321596"); // For the leftmost moves
        long positionR = position & Long.parseUnsignedLong("9187201950435737471");
        long positionRR = position & Long.parseUnsignedLong("4557430888798830399"); // For the rightmost moves

        // Define a bit mask for possible steps
        return positionLL << 6 | positionRR << 10 | positionL << 15 | positionR << 17
                | positionRR >>> 6 | positionLL >>> 10 | positionR >>> 15 | positionL >>> 17;
    }
}
