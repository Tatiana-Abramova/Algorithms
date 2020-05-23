package algo.task_03;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Chess pieces with their labels from FEN notation
 */
public enum Piece {
        WHITE_PAWNS('P'),
        WHITE_KNIGHTS('N'),
        WHITE_BISHOPS('B'),
        WHITE_ROOKS('R'),
        WHITE_QUEENS('Q'),
        WHITE_KING('K'),
        BLACK_PAWNS('p'),
        BLACK_KNIGHTS('n'),
        BLACK_BISHOPS('b'),
        BLACK_ROOKS('r'),
        BLACK_QUEENS('q'),
        BLACK_KING('k');

    private final Character label;

        public Character getLabel() {
        return label;
    }

    Piece(Character label) {
        this.label = label;
    }

    private static final Map<Character, Piece> lookup = new HashMap<>();

    static
    {
        for(Piece piece : Piece.values())
        {
            lookup.put(piece.label, piece);
        }
    }

    public static Piece get(Character label) {
        return lookup.get(label);
    }

    public static Set<Character> getLabels() {
        return lookup.keySet();
    }
}
