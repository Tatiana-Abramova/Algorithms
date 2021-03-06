package algo.task_02_algebraic_alg;

import static algo.task_02_algebraic_alg.Exponentiation.calcByBinaryDecomposition;

/**
 * Calculate Nth element of Fibonacci sequence.
 * Fn = Fn-2 + Fn-1
 * 0,1,1,2,3,5,8,13,21,34,55,89,144,...
 */
public class FibonacciNumbers {

    /**
     * Calculates Nth number of Fibonacci sequence. Recursion.
     * @param n a number of Fibonacci sequence
     * @return Nth element of Fibonacci sequence
     */
    public static long calcRecursion(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return calcRecursion(n - 2) + calcRecursion(n - 1);
    }

    /**
     * Calculates Nth number of Fibonacci sequence. Loop.
     * @param n a number of Fibonacci sequence
     * @return Nth element of Fibonacci sequence
     */
    public static long calcIteration(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        long prev = 0;
        long result = 1;
        for (int i = 1; i < n; i++) {
            long temp = prev;
            prev = result;
            result = temp + result;
        }
        return result;
    }

    /**
     * Calculates Nth number of Fibonacci sequence. Golden Ratio formula.
     * @param n a number of Fibonacci sequence
     * @return Nth element of Fibonacci sequence
     */
    public static long calcGoldenRatio(int n) {
        double sqrt5 = Math.sqrt(5);
        double phi = (1 + sqrt5)/2;
        double res = calcByBinaryDecomposition(phi, n)/sqrt5 + 0.5;
        return (long)res;
    }

    /**
     * Calculates Nth number of Fibonacci sequence. Matrices multiplication.
     * @param n a number of Fibonacci sequence
     * @return Nth element of Fibonacci sequence
     */
    public static long calcByMatrix(int n) {
        long m0 = 0;
        long m1 = 1;
        long m2 = 1;
        long r0 = 0;
        long r1 = 1;
        long r2 = 1;

        for (long power = n; power > 0; power >>= 1) {
            if ((power & 1) > 0) {

                long temp1 = r1;
                long temp2 = r2;
                r2 = m2*r2 + m1*r1;
                r1 = m1*temp2 + m0*r1;
                r0 = m1*temp1 + m0*r0;
            }

            long temp1 = m1;
            long temp2 = m2;
            m2 = m2*m2 + m1*m1;
            m1 = m1*(temp2 + m0);
            m0 = temp1*temp1 + m0*m0;
        }
        return r0;
    }
}
