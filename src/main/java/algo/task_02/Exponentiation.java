package algo.task_02;

/**
 * Calculate the result of a real number A raised to a power of N: A^N.
 *
 */
public class Exponentiation {

    /**
     * Calculates the result of a real number A raised to a power of N: A^N. Simple multiplication in a loop.
     * @param a a real number A > 0
     * @param n a power N >= 0
     * @return the result of a real number A raised to a power of N: A^N
     */
    public static double calcByLoop(double a, long n) {
        double result = 1;
        for (long i = 0; i < n; i++) {
            result *= a;
        }
        return result;
    }

    /**
     * Calculates the result of a real number A raised to a power of N: A^N. By power of 2 with further multiplication.
     * @param a a real number A > 0
     * @param n a power N >= 0
     * @return the result of a real number A raised to a power of N: A^N
     */
    public static double calcByPowerOfTwo(double a, long n) {
        double result = n == 0 ? 1 : a;
        long power = 1;
        while (power < n) {
            if (power * 2 <= n) {
                power <<= 1;
                result *= result;
            } else {
                power++;
                result *= a;
            }
        }
        return result;
    }

    /**
     * Calculates the result of a real number A raised to a power of N: A^N. By binary decomposition.
     * @param a a real number A > 0
     * @param n a power N >= 0
     * @return the result of a real number A raised to a power of N: A^N
     */
    public static double calcByBinaryDecomposition(double a, long n) {
        double result = 1;
    double multiplier = a;
        for (long power = n; power > 0; power >>= 1) {
        if ((power & 1) > 0) {
            result *= multiplier;
        }
        multiplier *= multiplier;
    }
        return result;
}
}
