package algo.task_03;

import javafx.util.Pair;

import java.util.Map;

/**
 * Calculate possible moves for white Root, Bishop, Queen for a given FEN notation
 * with a possibility to capture (kill) an enemy piece
 */
public class BitTruckers {

    public static long[] calcMoves(String fenNotation) {
        // Get all the pieces positions
        Map<Piece, Pair<Integer, Long>> positions = BitFenNotation.calcPositions(fenNotation);

        // Masks for white Root, Bishop, Queen
        long positionR = positions.get(Piece.WHITE_ROOKS).getValue();
        long positionB = positions.get(Piece.WHITE_BISHOPS).getValue();
        long positionQ = positions.get(Piece.WHITE_QUEENS).getValue();

        // Cells indexes for white Root, Bishop, Queen
        int indexR = positions.get(Piece.WHITE_ROOKS).getKey();
        int indexB = positions.get(Piece.WHITE_BISHOPS).getKey();
        int indexQ = positions.get(Piece.WHITE_QUEENS).getKey();

        // Masks for all white pieces
        long whites = positions.get(Piece.WHITE_ROOKS).getValue()
                | positions.get(Piece.WHITE_QUEENS).getValue()
                | positions.get(Piece.WHITE_BISHOPS).getValue()
                | positions.get(Piece.WHITE_KING).getValue()
                | positions.get(Piece.WHITE_PAWNS).getValue()
                | positions.get(Piece.WHITE_KNIGHTS).getValue();

        // Masks for all black pieces
        long blacks = positions.get(Piece.BLACK_ROOKS).getValue()
                | positions.get(Piece.BLACK_QUEENS).getValue()
                | positions.get(Piece.BLACK_BISHOPS).getValue()
                | positions.get(Piece.BLACK_KING).getValue()
                | positions.get(Piece.BLACK_PAWNS).getValue()
                | positions.get(Piece.BLACK_KNIGHTS).getValue();

        // Get a mask for all possible moves for Root
        long maskR = shift((7 - (indexR % 8)), 1, positionR, whites, blacks)
                        | shift((indexR / 8), -8, positionR, whites, blacks)
                        | shift((indexR % 8), -1, positionR, whites, blacks)
                        | shift((7 - (indexR / 8)), 8, positionR, whites, blacks);

        // Get a mask for all possible moves for Bishop
        long maskB = shift((7 - (indexB % 8)), 9, positionB, whites, blacks)
                | shift((indexB % 8), 7, positionB, whites, blacks)
                | shift((indexB % 8), -9, positionB, whites, blacks)
                | shift((7 - (indexB % 8)), -7, positionB, whites, blacks);

        // Get a mask for all possible moves for Queen
        long maskQ = shift((7 - (indexQ % 8)), 9, positionQ, whites, blacks)
                        | shift((indexQ % 8), 7, positionQ, whites, blacks)
                        | shift((indexQ % 8), -9, positionQ, whites, blacks)
                        | shift((7 - (indexQ % 8)), -7, positionQ, whites, blacks)
                        | shift((7 - (indexQ % 8)), 1, positionQ, whites, blacks)
                        | shift((indexQ / 8), -8, positionQ, whites, blacks)
                        | shift((indexQ % 8), -1, positionQ, whites, blacks)
                        | shift((7 - (indexQ / 8)), 8, positionQ, whites, blacks);

        return new long[]{maskR, maskB, maskQ};
    }


    /**
     * Calculates all possible moves for a piece taking into account that
     * the piece can't kill a piece with the same colot
     * the piece can kill a piece with an opposite color
     * @param stepsNo amount of possible moves to one direction
     * @param shift a required shift to a certain amount of cell in order to keep a necessary trajectory
     * @param position a start position of the piece
     * @param whites all white pieces' positions
     * @param blacks all black pieces' positions
     * @return
     */
    private static long shift(int stepsNo, int shift, long position, long whites, long blacks) {
        long mask = 0L;
        for (int i = 0; i < stepsNo; i++) {
            if (shift > 0) {
                position <<= shift;
            } else {
                position >>>= shift * -1;
            }

            if ((position & whites) != 0) {
                break;
            }
            if ((position & blacks) != 0) {
                mask = mask | position;
                break;
            }
            mask = mask | position;
        }
        return mask;
    }
}
