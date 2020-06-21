package algo;


import algo.task_04.dynamic_arrays.*;

public class Application {
    public static void main(String[] args) {
        Array<String> singleArray = new SingleArray<>();
        Array<String> vectorArray = new VectorArray<>();
        Array<String> factorArray = new FactorArray<>();
        Array<String> matrixArray = new MatrixArray<>();
        testAddArray(singleArray, 10);
        testAddArray(vectorArray, 100);
        testAddArray(factorArray, 100);
        testAddArray(matrixArray, 100);

        singleArray.add("Added", 5);
        vectorArray.add("Added", 25);
        factorArray.add("Added", 55);
        matrixArray.add("Added", 15);
        System.out.println();
    }

    private static void testAddArray(Array data, int total) {
        long start = System.currentTimeMillis();

        for (int j = 0; j < total; j++)
            data.add("Test " + j);

        System.out.println(data + " testAddArray: " +
                (System.currentTimeMillis() - start));
    }
}
