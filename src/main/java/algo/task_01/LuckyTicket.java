package algo.task_01;

/**
 * Lucky tickets.
 *
 * A ticket with 2N-digits number is lucky,
 * if a sum of its first N digits equals to a sum of its last N digits.
 *
 * Calculate an amount of all possible 2N-digits lucky tickets.
 *
 * Initial data: a number from 1 to N.
 * Required result: am amount of all possible 2N-digits lucky tickets.
 */
public class LuckyTicket {

    // TODO write better algorithm
    public static long calc(int number) {

        // Create an array where we will add quantities of combinations for each digits sum
        int countSum = number * 9;
        long[] array = new long[countSum + 1];

        // Fill the array with digits sums count
        for (int i = 0; i < Math.pow(10, number); i++) {
            int sum = 0;
            int var = i;
            for (int j = (int) Math.pow(10, number - 1); j >= 10; j /= 10) {
                sum += var / j;
                var %= j;
            }
            sum += var;
            array[sum]++;
        }

        // Calculate all the combinations of equal sums from both sides
        long count = 1;
        for (int i = 0; i < countSum; i++) {
            count += array[i] * array[i];
        }
        System.out.println(String.format("Amount of all possible 2N-digits (where N = %s) lucky tickets: %s", number, count));
        return count;
    }
}
