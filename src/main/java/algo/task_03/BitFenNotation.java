package algo.task_03;

import javafx.util.Pair;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Parse FEN notation and calculate positions of all pieces on a board
 */
public class BitFenNotation {

    public static Map<Piece, Pair<Integer, Long>> calcPositions(String notation) {
        // We will store pieces' positions here
        Map<Piece, Pair<Integer, Long>> positions = new LinkedHashMap<>();

        // Split FEN notation to lines
        String[] lines = notation.split("/");

        // Pre fill the map with zero positions
        for (Piece value : Piece.values()) {
            positions.put(value, new Pair<>(0, 0L));
        }

        // Get all possible letters from FEN notation
        Set<Character> letters = Piece.getLabels();

        // Go through each line on board
        int index = 0;
        for (int i = lines.length - 1; i >= 0; i--) {
            // Check each symbol,
            // if it is a valid letter, then calc a corresponding piece position and shift to the next cell
            // if it is a digit, then shift to a corresponding amount of cells
            for (Character c : lines[i].toCharArray()) {
                if (letters.contains(c)) {
                    long mask = positions.get(Piece.get(c)).getValue() | 1L << index;
                    positions.put(Piece.get(c), new Pair<>(index, mask));
                    index++;
                } else if (Character.isDigit(c) && Character.getNumericValue(c) < 9) {
                    int shift = Character.getNumericValue(c);
                    index  += shift;
                } else {
                    throw new IllegalArgumentException("Incorrect character in FEN notation: " + c);
                }
            }
        }
        return positions;
    }
}
