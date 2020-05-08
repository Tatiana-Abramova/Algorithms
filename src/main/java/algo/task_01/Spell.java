package algo.task_01;

import java.util.function.BiFunction;

/**
 * Harry Potter's square
 */
public class Spell {


    /**
     * Prints any figure based on a given function (spell) in a square with <b>size</b>
     * @param fn bi function
     * @param size square size
     */
    public static void print(BiFunction<Integer, Integer, Boolean> fn, int size) {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                System.out.print(fn.apply(y, x) ? "# " : ". ");
            }
            System.out.println();
        }
    }

    /**
     * Prints a dozen of figures in a square of size = 25
     */
    public static void printDozen() {
        int size = 25;
        System.out.println("Task #1");
        print((y, x) -> x > y, size);
        System.out.println("Task #5");
        print((y, x) -> x == 2 * y || x == 2 * y + 1, size);
        System.out.println("Task #7");
        print((y, x) -> x > size - 9 && y > size - 9, size);
        System.out.println("Task #10");
        print((y, x) -> x > y - 1 && x - 1 < 2 * y, size);
        System.out.println("Task #11");
        print((y, x) -> x == 1 || y == 1 || x == size - 2 || y == size - 2, size);
        System.out.println("Task #13");
        print((y, x) -> y > size - 6 - x && y < size + 4 - x, size);
        System.out.println("Task #19");
        print((y, x) -> x == 0 || y == 0 || x == size - 1 || y == size - 1, size);
        System.out.println("Task #20");
        print((y, x) -> (x + y) % 2 + 1 == 1, size);
        System.out.println("Task #22");
        print((y, x) -> (x + y) % 3 + 1 == 1, size);
        System.out.println("Task #23");
        print((y, x) -> x % 2 + 1 == 1 && y % 3 + 1 == 1, size);
        System.out.println("Task #24");
        print((y, x) -> y == size - 1 - x || x == y, size);
        System.out.println("Task #25");
        print((y, x) -> x % 6 + 1 == 1 || y % 6 + 1 == 1, size);
    }
}
