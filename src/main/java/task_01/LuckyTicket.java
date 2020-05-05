package task_01;

import java.math.BigInteger;

/**
 * Счастливые билеты 20
 *
 * Билет с 2N значным номером считается счастливым,
 * если сумма N первых цифр равна сумме последних N цифр.
 * Посчитать, сколько существует счастливых 2N-значных билетов.
 *
 * Начальные данные: число N от 1 до 10.
 * Вывод результата: количество 2N-значных счастливых билетов.
 */
public class LuckyTicket {
    public static long calc(int number) {

        // Create an array where we will add quantities of combinations for each digits sum
        int countSum = number * 9;
        long[] array = new long[countSum + 1];

        // Fill the array with digits sums count
        for (int i = 0; i < Math.pow(10, number); i++) {
            int sum = 0;
            int var = i;
            for (int j = (int) Math.pow(10, number - 1); j >= 10; j /= 10) {
                sum += var/j;
                var %= j;
            }
            sum += var;
            array[sum]++;
        }

        // Calculate all the combinations of equal sums from both sides
        long count = 1;
        for (int i = 0; i < countSum; i++) {
            count += array[i]*array[i];
        }
        System.out.println(count);
        return count;
    }
}
