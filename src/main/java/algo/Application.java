package algo;

import static algo.task_02.FibonacciNumbers.*;

public class Application {
    public static void main(String[] args) {
        System.out.println(calcRecursion(0));
        System.out.println(calcRecursion(1));
        System.out.println(calcRecursion(2));
        System.out.println(calcRecursion(3));
        System.out.println(calcRecursion(4));
        System.out.println(calcRecursion(5));
        System.out.println(calcRecursion(6));
        System.out.println(calcRecursion(7));
        System.out.println();
        System.out.println(calcIteration(0));
        System.out.println(calcIteration(1));
        System.out.println(calcIteration(2));
        System.out.println(calcIteration(3));
        System.out.println(calcIteration(4));
        System.out.println(calcIteration(5));
        System.out.println(calcIteration(6));
        System.out.println(calcIteration(7));
        System.out.println();
        System.out.println(calcGoldenRatio(0));
        System.out.println(calcGoldenRatio(1));
        System.out.println(calcGoldenRatio(2));
        System.out.println(calcGoldenRatio(3));
        System.out.println(calcGoldenRatio(4));
        System.out.println(calcGoldenRatio(5));
        System.out.println(calcGoldenRatio(6));
        System.out.println(calcGoldenRatio(7));
        System.out.println();
        System.out.println(calcByMatrix(0));
        System.out.println(calcByMatrix(1));
        System.out.println(calcByMatrix(2));
        System.out.println(calcByMatrix(3));
        System.out.println(calcByMatrix(4));
        System.out.println(calcByMatrix(5));
        System.out.println(calcByMatrix(6));
        System.out.println(calcByMatrix(7));
    }
}
