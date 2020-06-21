package algo.task_04;

import algo.Actions;
import algo.task_04.dynamic_arrays.*;
import org.junit.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Collectors;

public class ArraysRemoveComparativeTest extends ArraysComparativeTest {

    @Test
    public void comparativeTest() throws Exception {
        List<Arguments> args = getAllArgs().collect(Collectors.toList());
        Object[][] table = getComparativeTable(args);
        printTable(table);
    }

    @Override
    public Actions getActions(Arguments arg) {
        Array<Integer> vectorArray = new VectorArray<>(10000);
        Array<Integer> factorArray1 = new FactorArray<>(50, 1000);
        Array<Integer> factorArray2 = new FactorArray<>(100, 1000);
        Array<Integer> matrixArray1 = new MatrixArray<>(1000);
        Array<Integer> matrixArray2 = new MatrixArray<>(10000);
        Array<Integer> wrapperArray1 = new ArrayListWrapper<>(1000);
        Array<Integer> wrapperArray2 = new ArrayListWrapper<>(10000);

        int n = Integer.parseInt(String.valueOf(arg.get()[0]));

        fillArray(vectorArray, n);
        fillArray(factorArray1, n);
        fillArray(factorArray2, n);
        fillArray(matrixArray1, n);
        fillArray(matrixArray2, n);
        fillArray(wrapperArray1, n);
        fillArray(wrapperArray2, n);

        return new Actions(
                "Dynamic Arrays remove() " + n,
                new Actions.ActionDetail("Vector", () -> clearArray(vectorArray, n)),
                new Actions.ActionDetail("Factor1", () -> clearArray(factorArray1, n)),
                new Actions.ActionDetail("Factor2", () -> clearArray(factorArray2, n)),
                new Actions.ActionDetail("Matrix1", () -> clearArray(matrixArray1, n)),
                new Actions.ActionDetail("Matrix2", () -> clearArray(matrixArray2, n)),
                new Actions.ActionDetail("ArrayList Wrapper1", () -> clearArray(wrapperArray1, n)),
                new Actions.ActionDetail("ArrayList Wrapper2", () -> clearArray(wrapperArray2, n)));
    }
}

