package algo;

import algo.task_02.Exponentiation;

public class Application {
    public static void main(String[] args) {
        Exponentiation.calcByLoop(3, 1);
        Exponentiation.calcByBinaryDecomposition(3, 1);
        System.out.println();
        Exponentiation.calcByLoop(3, 2);
        Exponentiation.calcByBinaryDecomposition(3, 2);
        System.out.println();
        Exponentiation.calcByLoop(3, 3);
        Exponentiation.calcByBinaryDecomposition(3, 3);
        System.out.println();
        Exponentiation.calcByLoop(3, 4);
        Exponentiation.calcByBinaryDecomposition(3, 4);
        System.out.println();
        Exponentiation.calcByLoop(3, 55);
        Exponentiation.calcByBinaryDecomposition(3, 55);
        System.out.println();
        Exponentiation.calcByLoop(3, 67);
        Exponentiation.calcByBinaryDecomposition(3, 67);
        System.out.println();
        Exponentiation.calcByLoop(3.2, 70);
        Exponentiation.calcByBinaryDecomposition(3.2, 70);
        System.out.println();
        Exponentiation.calcByLoop(3.4, 8);
        Exponentiation.calcByBinaryDecomposition(3.4, 8);
        System.out.println();
        Exponentiation.calcByLoop(3, 9);
        Exponentiation.calcByBinaryDecomposition(3, 9);
    }
}
