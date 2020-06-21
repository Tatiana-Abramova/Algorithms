package algo.task_03_bits;

/**
 * A supplementary class to count "1"s in a given number
 */
public class BitCalculator {

    /**
     * This is a long way to count, go through all the digits in a mask
     * @param mask a given bit mask
     * @return amount of "1"s in the mask
     */
    public static int calcPossibleStepsNumberLong(long mask) {
        int count = 0;
        while (mask != 0) {
            if ((mask & 1) > 0) {
                count++;
            }
            mask >>>= 1;
        }
        return count;
    }

    /**
     * This is a short way to count, number of loops equals to number of "1"s
     * @param mask a given bit mask
     * @return amount of "1"s in the mask
     */
    public static int calcPossibleStepsNumberShort(long mask) {
        int count = 0;
        while (mask != 0) {
            long temp = mask - 1;
            mask &= temp;
            count++;
        }
        return count;
    }
}
